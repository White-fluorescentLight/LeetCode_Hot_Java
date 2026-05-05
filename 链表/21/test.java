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
    public ListNode mergeTwoLists(ListNode list1, ListNode list2) {
        ListNode dummy = new ListNode(-1); 
        ListNode cur = dummy;               

        while (list1 != null && list2 != null) { 
            if (list1.val <= list2.val) {        
                cur.next = list1;                
                list1 = list1.next;             
            } else {                            
                cur.next = list2;                
                list2 = list2.next;             
            }
            cur = cur.next;                    
        }

        cur.next = (list1 != null) ? list1 : list2; 

        return dummy.next; 
    }
}

/*  造一个虚拟头结点 dummy固定不动，再用cur 指针从 dummy 开始当尾结点；
    同时遍历两个链表，谁值小，cur 就接谁；
    被接的链表往后走，cur 也往后移；
    一个链表走完，把另一个剩余部分直接接上；
    最后返回dummy.next就是合并好的链表         */