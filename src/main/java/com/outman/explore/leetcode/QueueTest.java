package com.outman.explore.leetcode;

import java.util.ArrayDeque;
import java.util.Deque;
import java.util.LinkedList;
import java.util.Queue;

public class QueueTest {

    public static void main(String[] args) {
        // 常见队列: LinkedList,ArrayQueue,PriorityQueue

        Queue<Integer> queue = new LinkedList<>();
        queue.add(1);
        queue.add(2);
        System.out.println(queue.poll()); // 输出 1
        System.out.println(queue.poll()); // 输出 2

        // 双端队列: 允许在两端插入和删除元素的队列,同样可以使用ArrayDeque 或 LinkedList
        Deque<Integer> deque = new ArrayDeque<>();
        deque.addFirst(1);
        deque.addLast(2);
        System.out.println(deque.removeFirst()); // 输出 1
        System.out.println(deque.removeLast()); // 输出 2

        // 阻塞队列LinkedBlockingQueue，生产者消费者模型

    }
}
