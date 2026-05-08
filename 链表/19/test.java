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
    public ListNode removeNthFromEnd(ListNode head, int n) {
        // 虚拟头结点，统一处理删除头结点的情况
        ListNode dummy = new ListNode(0);
        dummy.next = head;
        
        ListNode fast = dummy;
        ListNode slow = dummy;
        
        // 快指针先走n步
        for (int i = 0; i < n; i++) {
            fast = fast.next;
        }
        
        // 快慢指针一起走，直到fast到达末尾
        while (fast.next != null) {
            fast = fast.next;
            slow = slow.next;
        }
        
        // slow.next就是要删除的结点，直接跳过它
        slow.next = slow.next.next;
        
        // 返回新的头结点
        return dummy.next;
    }
}

/*  快指针 fast 先向前走 n 步。
    然后快慢指针一起走，直到 fast 走到链表末尾，此时 slow 刚好停在要删除结点的前一个结点  */