package com.example.demo.test;

import java.util.Deque;
import java.util.LinkedList;
import java.util.Queue;

/**
 * 剑指 Offer 59 - II. 队列的最大值
 */
public class MaxQueue {
    Queue<Integer> queue;
    Deque<Integer> deque;

    public MaxQueue() {
        queue = new LinkedList<>();
        deque = new LinkedList<>();
    }

    public int max_value() {
        return deque.isEmpty()?-1:deque.peekFirst();

    }

    public void push_back(int value) {
        queue.add(value);
        while(!deque.isEmpty() && value>deque.peekLast()){
            deque.pollLast();
        }
        deque.addLast(value);

    }

    public int pop_front() {
        if(queue.isEmpty()){
            return -1;
        }
        int poll = queue.poll();
        if(poll==deque.peekFirst()){
            deque.pollFirst();
        }
        return poll;

    }
}
