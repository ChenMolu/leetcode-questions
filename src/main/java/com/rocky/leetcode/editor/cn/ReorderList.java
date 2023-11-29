package com.rocky.leetcode.editor.cn;


public class ReorderList {

    public static void main(String[] args) {
        int[] arr = new int[]{1, 2, 3, 4};
        ListNode head = new ListNode(arr[0]);
        ListNode current = head;
        for (int i = 1; i < arr.length; i++) {
            current.next = new ListNode(arr[i]);
            current = current.next;
        }
        Math.sqrt()
        reorderList(head);
    }

    public static void reorderList(ListNode head) {
        ListNode center = findCenter(head);
        ListNode tmp = center.next;
        center.next = null;
        ListNode back = reverseList(tmp);
        while (head != null && back != null) {
            ListNode tmpFront = head.next;
            ListNode tmpBack = back.next;
            back.next = head.next;
            head.next = back;
            head = tmpFront;
            back = tmpBack;
        }
    }

    public static ListNode findCenter(ListNode head) {
        ListNode slow = head;
        ListNode fast = head;
        while (fast.next != null && fast.next.next != null) {
            slow = slow.next;
            fast = fast.next.next;
        }
        return slow;
    }

    public static ListNode reverseList(ListNode head) {
        ListNode pre = null;
        while (head != null) {
            ListNode tmp = head.next;
            head.next = pre;
            pre = head;
            head = tmp;
        }
        return pre;
    }

}

class ListNode {
    int val;
    ListNode next;

    ListNode() {
    }

    ListNode(int val) {
        this.val = val;
    }

    ListNode(int val, ListNode next) {
        this.val = val;
        this.next = next;
    }

}