package com.outman.explore.leetcode;

import java.util.Stack;

public class ReverseLinkedList {

    /**
     * 单向链表
     */
    static class ListNode {
        int val;
        ListNode next;

        ListNode(int val) {
            this.val = val;
            this.next = null;
        }
    }

    public static void main(String[] args) {
        ListNode head = new ListNode(1);
        ListNode node1 = new ListNode(2);
        ListNode node2 = new ListNode(3);
        head.next = node1;
        node1.next = node2;

        ListNode newListNode = reverseListV2(head);
    }

    /**
     * 翻转链表(方法一)
     *
     * @param head
     * @return
     */
    public static ListNode reverseList(ListNode head) {
        ListNode newHead = null;
        // 利用栈的后进先出翻转
        Stack stack = new Stack();
        do {
            // clone新节点
            ListNode newNode = new ListNode(head.val);
            // 从栈中peek之前元素挂到next节点
            if (!stack.isEmpty()) {
                ListNode existNode = (ListNode) stack.peek();
                newNode.next = existNode;
            }
            // 新节点入栈
            stack.push(newNode);
            head = head.next;
            newHead = newNode;
        } while (head != null);

        return newHead;
    }

    /**
     * 翻转链表(方法二) -- 空间复杂度O(1)
     *
     * @param head
     * @return
     */
    public static ListNode reverseListV2(ListNode head) {
        ListNode prev = null;
        while (head != null) {
            // 暂存下一节点
            ListNode nextNode = head.next;
            // 翻转指针
            head.next = prev;
            // 更新 prev 为当前节点
            prev = head;
            // 继续处理下一节点
            head = nextNode;
        }
        // 新的头节点
        return prev;
    }

}
