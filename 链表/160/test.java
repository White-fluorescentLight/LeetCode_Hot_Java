/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) {
 *         val = x;
 *         next = null;
 *     }
 * }
 */
public class Solution {
    public ListNode getIntersectionNode(ListNode headA, ListNode headB) {
        // 边界处理：任一链表为空，直接返回 null
        if (headA == null || headB == null) {
            return null;
        }

        ListNode pA = headA;
        ListNode pB = headB;

        // 当两个指针不相等时继续移动
        while (pA != pB) {
            // pA 走完 A 就去走 B，否则继续走 A
            pA = (pA == null) ? headB : pA.next;
            // pB 走完 B 就去走 A，否则继续走 B
            pB = (pB == null) ? headA : pB.next;
        }

        // 相遇点就是相交节点，无交点时会同时走到 null
        return pA;
    }
}

/*  为什么说它是「自动对齐起点」
    假设链表 A 长 a+c，链表 B 长 b+c：
    pA 走完 A（a+c 步）后跳去 B，此时它在 B 上走的起点，相当于自动多走了 b 步
    pB 走完 B（b+c 步）后跳去 A，此时它在 A 上走的起点，相当于自动多走了 a 步   */

// 长度差法
public class Solution {
    public ListNode getIntersectionNode(ListNode headA, ListNode headB) {
        // 1. 分别计算两个链表的长度
        int lenA = 0, lenB = 0;
        ListNode pA = headA, pB = headB;
        while (pA != null) {
            lenA++;
            pA = pA.next;
        }
        while (pB != null) {
            lenB++;
            pB = pB.next;
        }

        // 2. 让长链表的指针先走「长度差」步，对齐起点
        pA = headA;
        pB = headB;
        if (lenA > lenB) {
            for (int i = 0; i < lenA - lenB; i++) {
                pA = pA.next;
            }
        } else {
            for (int i = 0; i < lenB - lenA; i++) {
                pB = pB.next;
            }
        }

        // 3. 同步移动，直到相遇
        while (pA != pB) {
            pA = pA.next;
            pB = pB.next;
        }

        return pA;
    }
}