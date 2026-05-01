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
    public ListNode reverseList(ListNode head) {
        ListNode prev = null;
        ListNode curr = head;
        while (curr != null) {
            // 先保存下一个节点
            ListNode nextTemp = curr.next;
            // 反转当前节点的指针
            curr.next = prev;
            // 两个指针向前移动
            prev = curr;
            curr = nextTemp;
        }
        return prev;
    }
}

/*  先把下一个节点存起来
    把当前节点的指针指向前一个节点
    两个指针都往前挪一步            */