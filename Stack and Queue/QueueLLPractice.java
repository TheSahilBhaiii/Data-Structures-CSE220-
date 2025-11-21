
import java.util.Deque;
import java.util.Queue;

// QueueLLPractice.java
// Practice for Queue implemented with Linked List
// Default rule inside problem functions:
//   - Only use MyQueue objects
//   - Only use: enqueue(int), Integer dequeue(), Integer peek(), boolean isEmpty()
//   - Multiple MyQueue instances allowed
//   - No arrays/lists unless explicitly mentioned (none are here)
// Problem 9 explicitly allows using MyStack as well.

public class QueueLLPractice {

    // ======================
    // Linked-list Queue impl
    // ======================
    static class MyQueue {
        private static class Node {
            int data;
            Node next;
            Node(int d) { data = d; }
        }

        private Node front; // head of queue (dequeue from here)
        private Node rear;  // tail of queue (enqueue here)

        public void enqueue(int value) {
            Node n = new Node(value);
            if (rear == null) {
                // empty queue
                front = rear = n;
            } else {
                rear.next = n;
                rear = n;
            }
        }

        // returns null on underflow
        public Integer dequeue() {
            if (front == null) return null;
            int v = front.data;
            front = front.next;
            if (front == null) rear = null;
            return v;
        }

        public Integer peek() {
            if (front == null) return null;
            return front.data;
        }

        public boolean isEmpty() {
            return front == null;
        }
    }

    // ======================
    // Simple Stack (for P9)
    // ======================
    static class MyStack {
        private static class Node {
            int data;
            Node next;
            Node(int d) { data = d; }
        }

        private Node top;

        public void push(int value) {
            Node n = new Node(value);
            n.next = top;
            top = n;
        }

        public Integer pop() {
            if (top == null) return null;
            int v = top.data;
            top = top.next;
            return v;
        }

        public Integer peek() {
            if (top == null) return null;
            return top.data;
        }

        public boolean isEmpty() {
            return top == null;
        }
    }

    // ================
    // Helper Utilities
    // ================

    // Build queue from array: arr[0] enters first (front), arr[n-1] last (rear)
    static MyQueue buildFromArray(int[] arr) {
        MyQueue q = new MyQueue();
        for (int x : arr) q.enqueue(x);
        return q;
    }

    // Print queue from FRONT to REAR using only queue ops (for testing)
    static void printQueue(MyQueue q) {
        MyQueue temp = new MyQueue();
        System.out.print("Front [ ");
        while (!q.isEmpty()) {
            int v = q.dequeue();
            System.out.print(v + " ");
            temp.enqueue(v);
        }
        System.out.println("] Rear");
        // restore
        while (!temp.isEmpty()) {
            q.enqueue(temp.dequeue());
        }
    }

    // ===========================
    // Problem 1: rotate_queue
    // ===========================
    /*
        rotate_queue

        Rotate queue elements by k positions to the LEFT (front moves to rear).

        One rotation:
            - Dequeue front element and enqueue it at rear.

        Example:
        Queue front→rear: [1, 2, 3, 4, 5], k = 2
        After 1: [2, 3, 4, 5, 1]
        After 2: [3, 4, 5, 1, 2]

        Constraints:
        - Queue operations only.
        - Use modulo with length to handle large k.
    */
    public static void rotate_queue(MyQueue q, long k) {
        int len=0;
        MyQueue aux=new MyQueue();

        while(!q.isEmpty()){
            aux.enqueue(q.dequeue());
            len++;
        }
        while(!aux.isEmpty()){
            q.enqueue(aux.dequeue());
        }
        k=k%len;
        for(int i=0;i<k;i++){
            q.enqueue(q.dequeue());
        }
    }

    static void testProblem1() {
        MyQueue q = buildFromArray(new int[]{1,2,3,4,5});
        System.out.println("Problem 1 - Before:");
        printQueue(q);
        rotate_queue(q, 2);
        System.out.println("Problem 1 - After (expected: Front [ 3 4 5 1 2 ] Rear):");
        printQueue(q);
        System.out.println();
    }

    // ===========================
    // Problem 2: remove_negative
    // ===========================
    /*
        remove_negative

        Remove all negative numbers from the queue, preserving the order
        of the remaining (non-negative) elements.

        Example:
        Input : front [ -1 3 -2 4 0 -5 ] rear
        Output: front [ 3 4 0 ] rear

        Constraints:
        - Queue operations only.
        - Use auxiliary queues if needed.
    */
    public static void remove_negative(MyQueue q) {
        MyQueue aux=new MyQueue();

        while(!q.isEmpty()){
            if(q.peek()>=0){
                aux.enqueue(q.dequeue());
            }
            else{
                q.dequeue();
            }
        }
        while(!aux.isEmpty()){
            q.enqueue(aux.dequeue());
        }
    }

    static void testProblem2() {
        MyQueue q = buildFromArray(new int[]{-1,3,-2,4,0,-5});
        System.out.println("Problem 2 - Before:");
        printQueue(q);
        remove_negative(q);
        System.out.println("Problem 2 - After (expected: Front [ 3 4 0 ] Rear):");
        printQueue(q);
        System.out.println();
    }

    // ===========================
    // Problem 3: interleave_queue
    // ===========================
    /*
        interleave_queue

        Given a queue with an even number of elements, interleave the first half
        and the second half.

        Example:
        Input : front [ 1 2 3 4 ] rear
                (first half: 1,2; second half: 3,4)
        Output: front [ 1 3 2 4 ] rear

        Another example:
        Input : front [ 10 20 30 40 50 60 ] rear
        Output: front [ 10 40 20 50 30 60 ] rear

        Constraints:
        - Even number of elements.
        - Queue operations only.
    */
    public static MyQueue interleave_queue(MyQueue q) {
        int counter=0;
        MyQueue aux=new MyQueue();

        while(!q.isEmpty()){
            aux.enqueue(q.dequeue());
            counter++;
        }
        while(!aux.isEmpty()){
            q.enqueue(aux.dequeue());
        }
        counter=counter/2;
        int x=counter;

        MyQueue firsthalf=new MyQueue();
        MyQueue secondhalf=new MyQueue();
        
        for(int i=0;i<x;i++){
            firsthalf.enqueue(q.dequeue());
        }
        for(int i=0;i<counter;i++){
            secondhalf.enqueue(q.dequeue());
        }
        while(!firsthalf.isEmpty() && !secondhalf.isEmpty()){
            q.enqueue(firsthalf.dequeue());
            q.enqueue(secondhalf.dequeue());
        }
        return q;
    }

    static void testProblem3() {
        MyQueue q = buildFromArray(new int[]{1,2,3,4});
        System.out.println("Problem 3 - Before:");
        printQueue(q);
        q = interleave_queue(q);
        System.out.println("Problem 3 - After (expected: Front [ 1 3 2 4 ] Rear):");
        printQueue(q);
        System.out.println();
    }

    // ===========================
    // Problem 4: generate_binary
    // ===========================
    /*
        generate_binary

        Using a queue, generate binary representations of numbers from 1 to n.
        For simplicity, store the binary numbers as integers whose digits form
        the binary (e.g., 1, 10, 11, 100, 101, ...)

        Example:
        n = 5
        Output sequence: 1, 10, 11, 100, 101

        Typical logic uses a queue of integers and repeatedly:
            - dequeue x
            - enqueue x*10 (append '0')
            - enqueue x*10 + 1 (append '1')

        Constraints:
        - Queue operations only.
    */
    public static MyQueue generate_binary(int n) {
        MyQueue result=new MyQueue();
        MyQueue q=new MyQueue();

        q.enqueue(1);

        for(int i=0;i<n;i++){
            int top=q.dequeue();
            result.enqueue(top);

            q.enqueue(top*10);
            q.enqueue(top*10+1);
        }
       return result;
    }

    static void testProblem4() {
        MyQueue q = generate_binary(5);
        System.out.println("Problem 4 - Generated binary for 1..5 (as ints):");
        printQueue(q);
        System.out.println();
    }

    // ===========================
    // Problem 5: merge_queues
    // ===========================
    /*
        merge_queues

        Given two sorted queues q1 and q2 (non-decreasing), merge them into
        a single sorted queue.

        Example:
        q1: front [ 1 3 5 ] rear
        q2: front [ 2 4 6 ] rear
        Output:
            front [ 1 2 3 4 5 6 ] rear

        Constraints:
        - Queue operations only.
        - You may create a new queue for the result.
    */
    public static MyQueue merge_queues(MyQueue q1, MyQueue q2) {
        MyQueue mergedQueue=new MyQueue();

        while(!q1.isEmpty() && !q2.isEmpty()){
            if(q1.peek()<q2.peek()){
            mergedQueue.enqueue(q1.dequeue());
            mergedQueue.enqueue(q2.dequeue());
        }
          else{
             mergedQueue.enqueue(q2.dequeue());
            mergedQueue.enqueue(q1.dequeue());
          }
        }
        return mergedQueue;
    }

    static void testProblem5() {
        MyQueue q1 = buildFromArray(new int[]{1,3,5});
        MyQueue q2 = buildFromArray(new int[]{2,4,6});
        System.out.println("Problem 5 - q1:");
        printQueue(q1);
        System.out.println("Problem 5 - q2:");
        printQueue(q2);
        MyQueue merged = merge_queues(q1, q2);
        System.out.println("Problem 5 - After merge:");
        printQueue(merged);
        System.out.println();
    }

    // ===========================
    // Problem 6: rearrange_positive_negative
    // ===========================
    /*
        rearrange_positive_negative

        Rearrange the queue so that:
            - All NEGATIVE numbers come first,
            - then all POSITIVE (and zero) numbers,
        preserving the original relative order within each group.

        Example:
        Input : front [ 1 -2 3 -4 5 -6 ] rear
        Output: front [ -2 -4 -6 1 3 5 ] rear

        Constraints:
        - Queue operations only.
    */
    public static void rearrange_positive_negative(MyQueue q) {
        MyQueue pos=new MyQueue();
        MyQueue neg=new MyQueue();

        while(!q.isEmpty()){
            int x=q.dequeue();

            if(x>=0){
                pos.enqueue(x);
            }
            else{
                neg.enqueue(x);
            }
        }
        while(!neg.isEmpty()){
            q.enqueue(neg.dequeue());
        }
        while(!pos.isEmpty()){
            q.enqueue(pos.dequeue());
        }
    }

    static void testProblem6() {
        MyQueue q = buildFromArray(new int[]{1,-2,3,-4,5,-6});
        System.out.println("Problem 6 - Before:");
        printQueue(q);
        rearrange_positive_negative(q);
        System.out.println("Problem 6 - After (expected: negatives then positives):");
        printQueue(q);
        System.out.println();
    }

    // ===========================
    // Problem 7: find_first_negative_window
    // ===========================
    /*
        find_first_negative_window

        Assume the queue initially holds an array's elements in order.
        Given window size k, output (into another queue) the first negative
        number in every contiguous window of size k. If a window has no
        negative, output 0 for that window.

        Example:
        Input array: [12, -1, -7, 8, -15, 30, 16, 28], k = 3
        Conceptual windows:
            [12, -1, -7] -> -1
            [-1, -7, 8]  -> -1
            [-7, 8, -15] -> -7
            [8, -15, 30] -> -15
            [-15, 30,16] -> -15
            [30,16,28]   -> 0
        Output queue: front [ -1 -1 -7 -15 -15 0 ] rear

        Constraints:
        - Queue operations only.
        - You may return a new queue with answers.
    */
    public static MyQueue find_first_negative_window(MyQueue q, int k) {
        // TODO: implement sliding-window style using only queues
        return new MyQueue();
    }

    static void testProblem7() {
        MyQueue q = buildFromArray(new int[]{12,-1,-7,8,-15,30,16,28});
        System.out.println("Problem 7 - Input:");
        printQueue(q);
        MyQueue ans = find_first_negative_window(q, 3);
        System.out.println("Problem 7 - First negatives (expected: -1 -1 -7 -15 -15 0):");
        printQueue(ans);
        System.out.println();
    }

    // ===========================
    // Problem 8: circular_queue_simulation
    // ===========================
    /*
        circular_queue_simulation

        Simulate circular queue operations using this linear linked-list queue.

        One possible setup:

        - Given an initial queue q and an integer k:
            repeatedly dequeue an element and enqueue it back (rotation),
            but every k-th dequeued element is REMOVED permanently.
          Return the order of removed elements in another queue.

        This is similar to the Josephus problem using a circular queue.

        Example (one variant):
        Input : q = [1,2,3,4,5], k = 2
        Removal order: [2,4,1,5,3]

        You may adopt this interpretation or adjust slightly;
        the goal is to practice circular behavior using only a linear queue.

        Constraints:
        - Queue operations only.
    */
    public static MyQueue circular_queue_simulation(MyQueue q, int k) {
        // TODO: implement
        return new MyQueue();
    }

    static void testProblem8() {
        MyQueue q = buildFromArray(new int[]{1,2,3,4,5});
        System.out.println("Problem 8 - Input:");
        printQueue(q);
        MyQueue removed = circular_queue_simulation(q, 2);
        System.out.println("Problem 8 - Removal order (e.g., 2 4 1 5 3):");
        printQueue(removed);
        System.out.println();
    }

    // ===========================
    // Problem 9: check_palindrome
    // ===========================
    /*
        check_palindrome

        Check if the elements in the queue form a palindrome.

        Example:
        front [ 1 2 3 2 1 ] rear  -> true
        front [ 1 2 2 3 1 ] rear  -> false

        Constraints:
        - You may use BOTH:
              - MyQueue
              - MyStack
        - No arrays/lists.

        Typical idea:
            - Copy elements while using a stack to reverse sequence,
            - Compare front sequence vs stack top sequence.
    */
    public static boolean check_palindrome(MyQueue q) {
       


        return true;
    }

    static void testProblem9() {
        MyQueue q1 = buildFromArray(new int[]{1,2,3,2,1});
        MyQueue q2 = buildFromArray(new int[]{1,2,2,3,1});
        System.out.println("Problem 9 - q1:");
        printQueue(q1);
        System.out.println("Is palindrome? (expected true): " + check_palindrome(q1));
        System.out.println();
        System.out.println("Problem 9 - q2:");
        printQueue(q2);
        System.out.println("Is palindrome? (expected false): " + check_palindrome(q2));
        System.out.println();
    }

    // ================
    // main – run tests
    // ================
    public static void main(String[] args) {
        // UNCOMMENT exactly one problem at a time to test:

                        // testProblem1();
                        //testProblem2();
                        // testProblem3();
                        //testProblem4();
                        //testProblem5();
                        //testProblem6();
        // testProblem7();
        // testProblem8();
         testProblem9();
    }
}
