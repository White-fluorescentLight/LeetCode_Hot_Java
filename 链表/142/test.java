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
    public ListNode detectCycle(ListNode head) {
        // 1. 快慢指针找相遇点
        ListNode slow = head;
        ListNode fast = head;
        boolean hasCycle = false;

        while (fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;
            if (slow == fast) {
                hasCycle = true;
                break;
            }
        }

        // 无环直接返回null
        if (!hasCycle) {
            return null;
        }

        // 2. 一个指针回到head，两个指针同速走，相遇点就是环入口
        fast = head;
        while (slow != fast) {
            slow = slow.next;
            fast = fast.next;
        }

        return slow;
    }
}

/*  1.利用相遇点，找到环的入口节点
    重置指针：将 fast 指针重新移回链表头 head
    同速移动指针：slow 和 fast 都改为每次走 1 步，继续移动

    2.为什么找到环的入口节点slow 和 fast 都改为每次走 1 步思路能成立？（核心逻辑）

    快慢指针第一次相遇时，快指针比慢指针多走了 n 圈环，两者的路程差是环长的整数倍。
    推导得出：从链表头到环入口的距离 = 从相遇点到环入口的距离。
    因此，让两个指针分别从「链表头」和「相遇点」同速移动，它们会同时到达环入口并相遇    */