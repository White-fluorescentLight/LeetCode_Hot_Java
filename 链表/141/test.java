/**
 * Definition for singly-linked list.
 * class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) {
 *         val = x;
 *         next = null;
 *     }
 * }
 */
public class Solution {
    public boolean hasCycle(ListNode head) {

        ListNode slow = head;
        ListNode fast = head;
        
        // 快指针每次走两步，慢指针每次走一步
        while (fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;
            // 相遇则说明有环
            if (slow == fast) {
                return true;
            }
        }
        
        // 未相遇 无环
        return false;
    }
}