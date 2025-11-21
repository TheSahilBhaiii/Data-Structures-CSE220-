// StackLLPractice.java
// Practice for Stack implemented with Linked List
// Only allowed operations inside problem functions:
//   push(int), Integer pop(), Integer peek(), boolean isEmpty()

public class StackLLPractice {

    // ======================
    // Linked-list Stack impl
    // ======================
    static class MyStack {
        private static class Node {
            int data;
            Node next;
            Node(int d) { data = d; }
        }

        private Node top; // null when empty

        public void push(int value) {
            Node n = new Node(value);
            n.next = top;
            top = n;
        }

        // returns null on underflow (as per your faculty note)
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

    // Build a stack from an array: arr[0] at bottom, arr[n-1] at top
    static MyStack buildFromArray(int[] arr) {
        MyStack st = new MyStack();
        for (int x : arr) st.push(x);
        return st;
    }

    // Print stack from top to bottom using only stack ops.
    // (This is for testing; in exam problems you'll not need printing.)
    static void printStackTopDown(MyStack st) {
        MyStack temp = new MyStack();
        System.out.println("Top");
        while (!st.isEmpty()) {
            int v = st.pop();
            System.out.println("| " + v + " |");
            temp.push(v);
        }
        System.out.println("-----");
        // restore
        while (!temp.isEmpty()) {
            st.push(temp.pop());
        }
    }

    // ===========================
    // Problem 1: Segregate Odd/Even
    // ===========================
    /*
        You are given a stack "original" containing integers in arbitrary order.
        Rearrange it so that:

          - All ODD numbers appear at the TOP,
            in the SAME relative order as in the original stack.
          - All EVEN numbers appear at the BOTTOM,
            in the SAME relative order as in the original stack.

        Return the modified stack (you may modify original or build a new one).

        Constraints:
        - Only use MyStack objects.
        - Only operations allowed: push, pop, peek, isEmpty.
        - You may create auxiliary stacks; no arrays / lists.

        Example:

        Input (top to bottom):

            Top
            | 12 |
            |  7 |
            |  5 |
            |  8 |
            | 11 |
            | 14 |
            |  3 |
            -----
        (so bottom is 3)

        Output:

            Top
            |  7 |
            |  5 |
            | 11 |
            |  3 |
            | 12 |
            |  8 |
            | 14 |
            -----
    */
    public static MyStack segregateOddEven(MyStack original) {
        MyStack aux=new MyStack();
        while(!original.isEmpty()){
            int x=original.pop();
            aux.push(x);
        }
        MyStack odds=new MyStack();
        MyStack evens=new MyStack();

        while(!aux.isEmpty()){
            int x=aux.pop();

            if(x%2==0){
                evens.push(x);
            }
            else{
                odds.push(x);
            }
        }
        MyStack revOdds=new MyStack();
        MyStack revEvens=new MyStack();

        while(!evens.isEmpty()){
            revEvens.push(evens.pop());
        }
        while(!odds.isEmpty()){
            revOdds.push(odds.pop());
        }
        MyStack result=new MyStack();

        while(!revEvens.isEmpty()){
            result.push(revEvens.pop());
        }
        while(!revOdds.isEmpty()){
            result.push(revOdds.pop());
        }
                return result;
    }

    static void testProblem1() {
        int[] arr = {3, 14, 11, 8, 5, 7, 12}; // 3 at bottom, 12 at top
        MyStack st = buildFromArray(arr);
        System.out.println("Problem 1 - Before:");
        printStackTopDown(st);
        st = segregateOddEven(st);
        System.out.println("Problem 1 - After (odds on top, evens bottom):");
        printStackTopDown(st);
    }

    // =====================================
    // Problem 2: sub_stack (top-bottom diff)
    // =====================================
    /*
        Even number of elements in the stack.

        Pair elements from BOTTOM and TOP:
        (bottom, top), (second-bottom, second-top), ...

        For each pair (a, b) where a is from bottom side and b from top side,
        compute (b - a). After the operation, the stack should contain only
        these differences, from bottom to top as:

            [b1 - a1, b2 - a2, ..., b_(n/2) - a_(n/2)]

        Example:

        Stack (top to bottom):
            | 4 |
            | 3 |
            | 2 |
            | 1 |
            -----
        Pairs: (1,4), (2,3)
        Result stack (top to bottom):
            | 1 |
            | 3 |
            -----
        (bottom is 3, top is 1)

        Use only MyStack operations and auxiliary stacks.
    */
    public static void sub_stack(MyStack st) {
       int count=0;
       MyStack aux=new MyStack();
       
       while(!st.isEmpty()){
        aux.push(st.pop());
        count++;
       }
       count=count/2;
       int n=count;

       MyStack bottomhalf=new MyStack();
       MyStack tophalf=new MyStack();

       while(n!=0){
        bottomhalf.push(aux.pop());
        n--;
       }
       while(count!=0){
        tophalf.push(aux.pop());
        count--;
       }
       MyStack revbottom=new MyStack();

       while(!bottomhalf.isEmpty()){
        revbottom.push(bottomhalf.pop());
       }

       while(!tophalf.isEmpty() && !revbottom.isEmpty()){
        int x=revbottom.pop();
        int y=tophalf.pop();
        if(x>y){
            st.push(x-y);
        }
        else{
            st.push(y-x);
        }
       }
        }

    static void testProblem2() {
        int[] arr = {1, 2, 3, 4};
        MyStack st = buildFromArray(arr);
        System.out.println("Problem 2 - Before:");
        printStackTopDown(st);
        sub_stack(st);
        System.out.println("Problem 2 - After (expected diffs):");
        printStackTopDown(st);
    }

    // =================================
    // Problem 3: sum_stack (top-bottom)
    // =================================
    /*
        Same pairing as sub_stack, but store SUM instead of difference.

        Example:
        Input stack (top to bottom):
            | 4 |
            | 3 |
            | 2 |
            | 1 |
            -----
        Pairs: (1,4), (2,3)
        Output stack:
            | 5 |
            | 5 |
            -----
    */
    public static void sum_stack(MyStack st) {
        int count=0;
       MyStack aux=new MyStack();
       
       while(!st.isEmpty()){
        aux.push(st.pop());
        count++;
       }
       count=count/2;
       int n=count;

       MyStack bottomhalf=new MyStack();
       MyStack tophalf=new MyStack();

       while(n!=0){
        bottomhalf.push(aux.pop());
        n--;
       }
       while(count!=0){
        tophalf.push(aux.pop());
        count--;
       }
       MyStack revbottom=new MyStack();

       while(!bottomhalf.isEmpty()){
        revbottom.push(bottomhalf.pop());
       }

       while(!tophalf.isEmpty() && !revbottom.isEmpty()){
        int x=revbottom.pop();
        int y=tophalf.pop();
            st.push(x+y);
       }
        }
    static void testProblem3() {
        int[] arr = {1, 2, 3, 4};
        MyStack st = buildFromArray(arr);
        System.out.println("Problem 3 - Before:");
        printStackTopDown(st);
        sum_stack(st);
        System.out.println("Problem 3 - After (expected all 5s):");
        printStackTopDown(st);
    }

    // ==========================================
    // Problem 4: conditional_reverse (bottom-up)
    // ==========================================
    /*
        Reverse the stack from the BOTTOM up to the n-th element
        (counting from the bottom). Elements above that region
        keep their relative order.

        Example (bottom to top): [1,2,3,4,5,6], n = 4
        Bottom 4: [1,2,3,4] -> reversed to [4,3,2,1]
        Final (bottom to top): [4,3,2,1,5,6]
    */
    public static void conditional_reverse_bottom_up(MyStack st, int n) {
        MyStack aux=new MyStack();
        
        while(!st.isEmpty()){
            aux.push(st.pop());
        }

        MyStack rev=new MyStack();

        for(int i=0;i<n;i++){
            rev.push(aux.pop());
        }
        MyStack rest=new MyStack();

        while(!aux.isEmpty()){
            rest.push(aux.pop());
        }
        MyStack result=new MyStack();
        while(!rev.isEmpty()){
            result.push(rev.pop());
        }
        while(!rest.isEmpty()){
            st.push(rest.pop());
        }
        while(!result.isEmpty()){
            st.push(result.pop());
        }
    }

    static void testProblem4() {
        int[] arr = {1,2,3,4,5,6};
        MyStack st = buildFromArray(arr);
        System.out.println("Problem 4 - Before:");
        printStackTopDown(st);
        conditional_reverse_bottom_up(st, 4);
        System.out.println("Problem 4 - After:");
        printStackTopDown(st);
    }

    // ==========================================
    // Problem 5: conditional_reverse (top-down)
    // ==========================================
    /*
        Reverse the TOP n elements of the stack, leaving the bottom part
        unchanged.

        Example (bottom to top): [1,2,3,4,5,6], n = 3
        Top 3: [4,5,6] -> reversed to [6,5,4]
        Final (bottom to top): [1,2,3,6,5,4]
    */
    public static void conditional_reverse_top_down(MyStack st, int n) {
        MyStack aux=new MyStack();
        int counter=0;

        while(!st.isEmpty()){
            aux.push(st.pop());
            counter++;
        }
        for(int i=0;i<(counter-n);i++){
            st.push(aux.pop());
        }
        MyStack rev=new MyStack();
        while(!aux.isEmpty()){
            rev.push(aux.pop());
        }
        while(!rev.isEmpty()){
            st.push(rev.pop());
        }
        }

    static void testProblem5() {
        int[] arr = {1,2,3,4,5,6};
        MyStack st = buildFromArray(arr);
        System.out.println("Problem 5 - Before:");
        printStackTopDown(st);
        conditional_reverse_top_down(st, 3);
        System.out.println("Problem 5 - After:");
        printStackTopDown(st);
    }

    // ================================
    // Problem 6: rotate_stack_upward
    // ================================
    /*
        Rotate stack UPWARD by k positions.

        One upward rotation:
            - Remove the TOP element
            - Make it the BOTTOM element

        Example (bottom to top): [1,2,3,4,5], k = 2
        After 1 rotation: [5,1,2,3,4]
        After 2 rotations: [4,5,1,2,3]
    */
    public static void rotate_stack_upward(MyStack st, long k) {
        MyStack bottom=new MyStack();
        MyStack top=new MyStack();

        for(int i=0;i<k;i++){
            bottom.push(st.pop());
        }
        while(!st.isEmpty()){
            top.push(st.pop());
        }
        while(!bottom.isEmpty()){
            st.push(bottom.pop());
        }
        while(!top.isEmpty()){
            st.push(top.pop());
        }
    }

    static void testProblem6() {
        int[] arr = {1,2,3,4,5};
        MyStack st = buildFromArray(arr);
        System.out.println("Problem 6 - Before:");
        printStackTopDown(st);
        rotate_stack_upward(st, 2);
        System.out.println("Problem 6 - After:");
        printStackTopDown(st);
    }

    // ==================================
    // Problem 7: rotate_stack_downward
    // ==================================
    /*
        Rotate stack DOWNWARD by k positions.

        One downward rotation:
            - Remove the BOTTOM element
            - Push it on TOP

        Example (bottom to top): [1,2,3,4,5], k = 2
        After 1 rotation: [2,3,4,5,1]
        After 2 rotations: [3,4,5,1,2]
    */
    public static void rotate_stack_downward(MyStack st, long k) {
        MyStack aux=new MyStack();
        int counter=0;
        while(!st.isEmpty()){
            aux.push(st.pop());
            counter++;
        }
        while(!aux.isEmpty()){
            st.push(aux.pop());
        }
        MyStack bottom=new MyStack();
        MyStack top=new MyStack();

        for(int i=0;i<(counter-k);i++){
            bottom.push(st.pop());
        }
        while(!st.isEmpty()){
            top.push(st.pop());
        }
        while(!bottom.isEmpty()){
            st.push(bottom.pop());
        }
        while(!top.isEmpty()){
            st.push(top.pop());
        }
    }

    static void testProblem7() {
        int[] arr = {1,2,3,4,5};
        MyStack st = buildFromArray(arr);
        System.out.println("Problem 7 - Before:");
        printStackTopDown(st);
        rotate_stack_downward(st, 2);
        System.out.println("Problem 7 - After:");
        printStackTopDown(st);
    }

    // ===========================================
    // Problem 8: retain_and_reverse_top_m
    // ===========================================
    /*
        Retain only the TOP m elements of the stack and reverse their order.
        All elements below the top m are removed.

        Example (bottom to top): [1,2,3,4,5,6], m = 3
        Top m: [4,5,6] -> reversed to [6,5,4]
        Result stack (bottom to top): [6,5,4]
    */
    public static void retain_and_reverse_top_m(MyStack st, int m) {
        MyStack res=new MyStack();
        MyStack rev=new MyStack();

        for(int i=0;i<m;i++){
            res.push(st.pop());
        }
        while(!st.isEmpty()){
            st.pop();
        }
        while(!res.isEmpty()){
            rev.push(res.pop());
        }
        while(!rev.isEmpty()){
            st.push(rev.pop());
        }
    }

    static void testProblem8() {
        int[] arr = {1,2,3,4,5,6};
        MyStack st = buildFromArray(arr);
        System.out.println("Problem 8 - Before:");
        printStackTopDown(st);
        retain_and_reverse_top_m(st, 3);
        System.out.println("Problem 8 - After:");
        printStackTopDown(st);
    }

    // ================
    // main – run tests
    // ================
    public static void main(String[] args) {
        // UNCOMMENT exactly one problem at a time to test:

         //testProblem1();
         //testProblem2();
         //testProblem3();
         // testProblem4();
         //testProblem5();
         //testProblem6();
         //testProblem7();
         //testProblem8();
    }
}
