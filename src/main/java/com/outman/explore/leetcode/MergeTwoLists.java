package com.outman.explore.leetcode;

public class MergeTwoLists {

    static class ListNode {
        int val;
        ListNode next;

        ListNode(int val) {
            this.val = val;
            this.next = null;
        }
    }

    public static void main(String[] args) {
        ListNode l1 = new ListNode(1);
        l1.next = new ListNode(3);
        l1.next.next = new ListNode(5);

        ListNode l2 = new ListNode(8);
        l2.next = new ListNode(9);
        l2.next.next = new ListNode(10);

        ListNode mergedHead = mergeTwoLists(l1, l2);
        while (mergedHead != null) {
            System.out.print(mergedHead.val + " ");
            mergedHead = mergedHead.next;
        }
    }

    public static ListNode mergeTwoLists(ListNode l1, ListNode l2) {
        // 创建一个哑节点，简化新链表的构建
        ListNode dummy = new ListNode(0);
        ListNode current = dummy;

        // 遍历两个链表，比较每个节点的值，将较小的节点添加到新链表中
        while (l1 != null && l2 != null) {
            if (l1.val < l2.val) {
                current.next = l1;
                l1 = l1.next;
            } else {
                current.next = l2;
                l2 = l2.next;
            }
            current = current.next;
        }

        // 连接剩余节点
        if (l1 != null) {
            current.next = l1;
        } else {
            current.next = l2;
        }

        // 返回新链表的头节点
        return dummy.next;
    }
}
