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
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        // 1. 创建虚拟头节点，简化链表操作（避免处理头节点为空的边界情况）
        ListNode dummyHead = new ListNode(0);
        // 移动指针，指向当前正在构建的节点
        ListNode current = dummyHead;
        // 进位变量，初始为0
        int carry = 0;

        // 2. 循环条件：只要l1、l2没遍历完，或者还有进位，就继续
        while (l1 != null || l2 != null || carry != 0) {
            // 取出当前节点的值，空节点按0处理
            int x = (l1 != null) ? l1.val : 0;
            int y = (l2 != null) ? l2.val : 0;

            // 3. 计算当前位的和：两数之和 + 进位
            int sum = x + y + carry;
            // 更新进位（sum除以10取整）
            carry = sum / 10;
            // 当前位的数字是sum的个位（sum对10取余）
            int currentVal = sum % 10;

            // 4. 创建新节点，连接到结果链表
            current.next = new ListNode(currentVal);
            // 移动指针
            current = current.next;

            // 移动输入链表的指针
            if (l1 != null) l1 = l1.next;
            if (l2 != null) l2 = l2.next;
        }

        // 5. 虚拟头节点的next就是结果链表的头
        return dummyHead.next;
    }
}

/*  两个链表都是倒着存数字（头是个位），刚好符合我们从个位开始加法的习惯，
    直接同步遍历两个链表，逐位相加、算进位，一边加一边建新链表存结果就行   */