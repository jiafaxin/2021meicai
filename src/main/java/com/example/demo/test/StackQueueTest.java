package com.example.demo.test;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;

/**
 *
 */
public class StackQueueTest {

    Stack<Integer> stack1 = new Stack<Integer>();
    Stack<Integer> stack2 = new Stack<Integer>();

    public Queue<Integer> queue = new LinkedList<>();

    public static void main(String[] args) {
        StackQueueTest stackQueueTest = new StackQueueTest();
        stackQueueTest.pushStack(1);
        stackQueueTest.pushStack(2);
        stackQueueTest.pushStack(3);
        stackQueueTest.pushStack(4);
        for(int i = 0 ;i<3;i++){
            System.out.println(stackQueueTest.popStack());
            System.out.println("==========");
        }
    }

    /**
     * 当往queue添加123的时候，
     * 在第一次添加后什么都不做，（无循环）
     * 在二次添加的时候，先把第一次添加的1删除取出来,这时候2变成第一个添加的元素了,
     * 然后在把取出来的1添加到队列中，此时队列里是21（循环一次）
     * 第三次类似，（循环两次）
     */
    public void pushStack(int x) {
        queue.add(x);
        int size = queue.size();
        while(size-- > 1){
            Integer poll = queue.poll();
            queue.add(poll);
        }
    }

    /**
     *
     *
     */
    public int popStack() {
        return queue.poll();
    }


    /**
     * 进 1 2 3 4
     * @param node
     */
    public void pushQueue(int node) {
        stack1.push(node);
    }

    /**
     * 出1 2 3 4
     * 相当于把原来stack1入栈的1234出栈到stack2变成4321，最后stack2再次出栈1234
     * @return
     */
    public int popQueue() {
        if (stack2.isEmpty()){
            while (!stack1.isEmpty()){
                stack2.push(stack1.pop());
            }
        }
        if (stack2.isEmpty()) {
            return -1;
        } else {
            return stack2.pop();
        }
    }


}
