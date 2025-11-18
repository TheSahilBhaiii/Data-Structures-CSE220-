// Linked List Practice Suite with Solutions // Suhail — Uncomment ONE problem at a time in main() to test.

import java.util.*;

public class LinkedListPracticeSuite {

static class ListNode {
    int val;
    ListNode next;
    ListNode(int x) { val = x; }
}

static ListNode buildList(int[] arr) {
    ListNode dummy = new ListNode(0);
    ListNode cur = dummy;
    for (int x : arr) {
        cur.next = new ListNode(x);
        cur = cur.next;
    }
    return dummy.next;
}

static void printList(ListNode head) {
    while (head != null) {
        System.out.print(head.val + " -> ");
        head = head.next;
    }
    System.out.println("null");
}

// 1. Reverse Linked List (206)
static ListNode reverseList(ListNode head) {
    ListNode prev = null, cur = head;
    while (cur != null) {
        ListNode next = cur.next;
        cur.next = prev;
        prev = cur;
        cur = next;
    }
    return prev;
}

// 2. Merge Two Sorted Lists (21)
static ListNode mergeTwoLists(ListNode l1, ListNode l2) {
    ListNode dummy = new ListNode(0), cur = dummy;
    while (l1 != null && l2 != null) {
        if (l1.val < l2.val) {
            cur.next = l1;
            l1 = l1.next;
        } else {
            cur.next = l2;
            l2 = l2.next;
        }
        cur = cur.next;
    }
    cur.next = (l1 != null) ? l1 : l2;
    return dummy.next;
}

// 3. Linked List Cycle (141)
static boolean hasCycle(ListNode head) {
    ListNode slow = head, fast = head;
    while (fast != null && fast.next != null) {
        slow = slow.next;
        fast = fast.next.next;
        if (slow == fast) return true;
    }
    return false;
}

// 4. Remove Linked List Elements (203)
static ListNode removeElements(ListNode head, int val) {
    ListNode dummy = new ListNode(0);
    dummy.next = head;
    ListNode cur = dummy;
    while (cur.next != null) {
        if (cur.next.val == val) cur.next = cur.next.next;
        else cur = cur.next;
    }
    return dummy.next;
}

// 5. Middle of Linked List (876)
static ListNode middleNode(ListNode head) {
    ListNode slow = head, fast = head;
    while (fast != null && fast.next != null) {
        slow = slow.next;
        fast = fast.next.next;
    }
    return slow;
}

// 6. Remove Nth Node From End (19)
static ListNode removeNthFromEnd(ListNode head, int n) {
    ListNode dummy = new ListNode(0);
    dummy.next = head;
    ListNode fast = dummy, slow = dummy;
    for (int i = 0; i < n; i++) fast = fast.next;
    while (fast.next != null) {
        fast = fast.next;
        slow = slow.next;
    }
    slow.next = slow.next.next;
    return dummy.next;
}

// 7. Reorder List (143)
static void reorderList(ListNode head) {
    if (head == null || head.next == null) return;
    ListNode slow = head, fast = head;
    while (fast.next != null && fast.next.next != null) {
        slow = slow.next;
        fast = fast.next.next;
    }
    ListNode second = reverseList(slow.next);
    slow.next = null;
    ListNode first = head;
    while (second != null) {
        ListNode t1 = first.next;
        ListNode t2 = second.next;
        first.next = second;
        second.next = t1;
        first = t1;
        second = t2;
    }
}

// 8. Add Two Numbers (2)
static ListNode addTwoNumbers(ListNode l1, ListNode l2) {
    ListNode dummy = new ListNode(0), cur = dummy;
    int carry = 0;
    while (l1 != null || l2 != null || carry > 0) {
        int sum = carry;
        if (l1 != null) { sum += l1.val; l1 = l1.next; }
        if (l2 != null) { sum += l2.val; l2 = l2.next; }
        carry = sum / 10;
        cur.next = new ListNode(sum % 10);
        cur = cur.next;
    }
    return dummy.next;
}

// 9. Palindrome Linked List (234)
static boolean isPalindrome(ListNode head) {
    if (head == null || head.next == null) return true;
    ListNode slow = head, fast = head;
    while (fast != null && fast.next != null) {
        slow = slow.next;
        fast = fast.next.next;
    }
    ListNode second = reverseList(slow);
    ListNode p1 = head, p2 = second;
    while (p2 != null) {
        if (p1.val != p2.val) return false;
        p1 = p1.next;
        p2 = p2.next;
    }
    return true;
}

// 10. Odd Even Linked List (328)
static ListNode oddEvenList(ListNode head) {
    if (head == null) return null;
    ListNode odd = head, even = head.next, evenHead = even;
    while (even != null && even.next != null) {
        odd.next = even.next;
        odd = odd.next;
        even.next = odd.next;
        even = even.next;
    }
    odd.next = evenHead;
    return head;
}

// 11. Swap Nodes in Pairs (24)
static ListNode swapPairs(ListNode head) {
    ListNode dummy = new ListNode(0);
    dummy.next = head;
    ListNode cur = dummy;
    while (cur.next != null && cur.next.next != null) {
        ListNode a = cur.next;
        ListNode b = cur.next.next;
        a.next = b.next;
        b.next = a;
        cur.next = b;
        cur = a;
    }
    return dummy.next;
}

// 12. Rotate List (61)
static ListNode rotateRight(ListNode head, int k) {
    if (head == null || head.next == null) return head;
    ListNode tail = head;
    int len = 1;
    while (tail.next != null) {
        tail = tail.next;
        len++;
    }
    k %= len;
    if (k == 0) return head;
    tail.next = head;
    int steps = len - k;
    ListNode newTail = head;
    for (int i = 1; i < steps; i++) newTail = newTail.next;
    ListNode newHead = newTail.next;
    newTail.next = null;
    return newHead;
}

// 13. Linked List Cycle II (142)
static ListNode detectCycle(ListNode head) {
    ListNode slow = head, fast = head;
    while (fast != null && fast.next != null) {
        slow = slow.next;
        fast = fast.next.next;
        if (slow == fast) {
            ListNode p = head;
            while (p != slow) {
                p = p.next;
                slow = slow.next;
            }
            return p;
        }
    }
    return null;
}

// 14. Reverse Nodes in k-Group (25)
static ListNode reverseKGroup(ListNode head, int k) {
    ListNode cur = head;
    int count = 0;
    while (cur != null && count < k) {
        cur = cur.next;
        count++;
    }
    if (count < k) return head;
    ListNode prev = reverseKGroup(cur, k);
    while (count-- > 0) {
        ListNode next = head.next;
        head.next = prev;
        prev = head;
        head = next;
    }
    return prev;
}

static class RandomNode {
    int val;
    RandomNode next, random;
    RandomNode(int x) { val = x; }
}

// 15. Copy List With Random Pointer (138)
static RandomNode copyRandomList(RandomNode head) {
    if (head == null) return null;
    RandomNode cur = head;
    while (cur != null) {
        RandomNode copy = new RandomNode(cur.val);
        copy.next = cur.next;
        cur.next = copy;
        cur = copy.next;
    }
    cur = head;
    while (cur != null) {
        if (cur.random != null) cur.next.random = cur.random.next;
        cur = cur.next.next;
    }
    RandomNode dummy = new RandomNode(0), copyCur = dummy;
    cur = head;
    while (cur != null) {
        copyCur.next = cur.next;
        cur.next = cur.next.next;
        cur = cur.next;
        copyCur = copyCur.next;
    }
    return dummy.next;
}

public static void main(String[] args) {
    // Uncomment blocks to test
}

}