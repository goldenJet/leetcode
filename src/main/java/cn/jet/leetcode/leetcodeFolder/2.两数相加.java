/*
 * @lc app=leetcode.cn id=2 lang=java
 *
 * [2] 两数相加
 *
 * https://leetcode-cn.com/problems/add-two-numbers/description/
 *
 * algorithms
 * Medium (38.01%)
 * Likes:    4932
 * Dislikes: 0
 * Total Accepted:    556.4K
 * Total Submissions: 1.5M
 * Testcase Example:  '[2,4,3]\n[5,6,4]'
 *
 * 给出两个 非空 的链表用来表示两个非负的整数。其中，它们各自的位数是按照 逆序 的方式存储的，并且它们的每个节点只能存储 一位 数字。
 * 
 * 如果，我们将这两个数相加起来，则会返回一个新的链表来表示它们的和。
 * 
 * 您可以假设除了数字 0 之外，这两个数都不会以 0 开头。
 * 
 * 示例：
 * 
 * 输入：(2 -> 4 -> 3) + (5 -> 6 -> 4)
 * 输出：7 -> 0 -> 8
 * 原因：342 + 465 = 807
 * 
 * 
 */

// @lc code=start
/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */
class Solution {
    // 思路：递归，简单粗暴
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        return addTwoNumbersCommon(l1, l2, 0);
    }

    public static ListNode addTwoNumbersCommon(ListNode l1, ListNode l2, int v) {
        ListNode result = null;
        if (l1 == null && l2 == null) {
            if (v == 0) return null;
            return new ListNode(v);
        } else if(l1 == null || l2 == null) {
            if (l1 == null) {
                l1 = l2;
            }
            int sum = l1.val + v;
            result = new ListNode(sum%10);
            result.next = addTwoNumbersCommon(l1.next, null, sum / 10);
        } else {
            int sum = l1.val + l2.val + v;
            result = new ListNode(sum%10);
            result.next = addTwoNumbersCommon(l1.next, l2.next, sum / 10);
        }
        return result;
    }
}
// @lc code=end

