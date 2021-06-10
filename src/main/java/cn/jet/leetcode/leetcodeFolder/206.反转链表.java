/*
 * @lc app=leetcode.cn id=206 lang=java
 *
 * [206] 反转链表
 */

// @lc code=start
/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode() {}
 *     ListNode(int val) { this.val = val; }
 *     ListNode(int val, ListNode next) { this.val = val; this.next = next; }
 * }
 */
class Solution {
    // 思路：先拿到head，然后往后遍历，同时将前一个node置为后一个node的next
    public ListNode reverseList(ListNode head) {
        if (head == null) return null;
        ListNode result = new ListNode(head.val);
        if (head.next != null) {
            ListNode temp = head.next;
            while (temp != null) {
                result = new ListNode(temp.val, result);
                temp = temp.next;
            }
        }
        return result;
    }
}
// @lc code=end

