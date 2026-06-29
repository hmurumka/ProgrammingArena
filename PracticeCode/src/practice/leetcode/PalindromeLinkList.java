package practice.leetcode;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.Stack;

/*
Palindrome Linked List
Easy
Topics
premium lock icon
Companies
Given the head of a singly linked list, return true if it is a palindrome or false otherwise.

 

Example 1:


Input: head = [1,2,2,1]
Output: true
Example 2:


Input: head = [1,2]
Output: false
 

Constraints:

The number of nodes in the list is in the range [1, 105].
0 <= Node.val <= 9
 */

public class PalindromeLinkList {

    public static void main(String[] args) {
        PalindromeLinkList p = new PalindromeLinkList();
        System.out.println(p.isPalindrome(p.createSampleList(new int[] { 1, 2, 2, 1 })));
    }

    // using stack
    /*
     * public boolean isPalindrome(ListNode head) {
     * if(head == null)
     * return true;
     * else if(head.next == null)
     * return true;
     * else
     * {
     * //return check(head);
     * // reverse a LL
     * ListNode temp = head;
     * Stack<Integer> stack = new Stack<>();
     * while(temp != null)
     * {
     * stack.push(temp.val);
     * temp = temp.next;
     * }
     * 
     * temp = head;
     * while(temp != null)
     * {
     * if(temp.val != stack.pop())
     * return false;
     * temp = temp.next;
     * }
     * 
     * return true;
     * }
     * }
     */

    // finding mid point
    public boolean isPalindrome(ListNode head) {
        if (head == null)
            return true;
        else if (head.next == null)
            return true;
        else {
            ListNode slow = head, fast = head;
            while (fast != null && fast.next != null) {
                slow = slow.next;
                fast = fast.next.next;
            }

            ListNode firstHalf = head, secondHalf = reverse(slow);
            while (secondHalf != null)
            {
                if (firstHalf.val != secondHalf.val)
                    return false;

                firstHalf = firstHalf.next;
                secondHalf = secondHalf.next;
            }


            return true;
        }
    }

    private ListNode reverse(ListNode node) {
        ListNode prev = null, next = null;
        while (node != null) {
            next = node.next;
            node.next = prev;
            prev = node;
            node = next;
        }

        return prev;
    }

    private ListNode createSampleList(int[] a) {
        if (a.length > 0) {
            ListNode head = new ListNode(a[0], null), c = head;
            for (int i = 1; i < a.length; i++) {
            c.next = new ListNode(a[i], null);
            c = c.next;
        }
        return head;
    }

        return null;
    }

    private class ListNode {
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

}
