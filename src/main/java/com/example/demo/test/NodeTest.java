package com.example.demo.test;

import java.util.*;

public class NodeTest {


    public int data;

    public NodeTest next;


    public NodeTest(int data) {
        this.data = data;
    }

    public NodeTest(int data, NodeTest next) {
        this.data = data;
        this.next = next;
    }

    @Override
    public String toString() {
        return "NodeTest{" +
                "data=" + data +
                ", next=" + next +
                '}';
    }

    public static void main(String[] args) {
        NodeTest node1 = new NodeTest(1);
        NodeTest node2 = new NodeTest(2);
        NodeTest node3 = new NodeTest(3);
        NodeTest node4 = new NodeTest(4);
        NodeTest node5 = new NodeTest(5);

        node1.next = node2;
        node2.next = node3;
        node3.next = node4;
        node4.next = node5;
        NodeTest nodeTest = reverseKGroup(node1, 2);


    }

    /**
     * 在头部添加节点9
     * @param node
     * @return
     */
    private static NodeTest addFirstNode(NodeTest node){
        NodeTest node1 = new NodeTest(9);
        node1.next = node;
        return node1;
    }

    /**
     * 在尾部添加节点9
     * @param node
     * @return
     */
    private static NodeTest addEndNode(NodeTest node){
        NodeTest newNode = new NodeTest(9);
        NodeTest end = node;
        while(null != end.next){
            end = end.next;
        }
        end.next = newNode;
        return node;
    }
    /**
     *  删除排序链表中的重复元素
     * 1 3 5 5 7------>1 3 5 7
     * @param node
     * @return
     */
    private static NodeTest deleteDuplicates(NodeTest node){
        NodeTest currNode = node;
        while(null != currNode && null != currNode.next){
            if(currNode.data == currNode.next.data){
                currNode.next = currNode.next.next;
            }else{
                currNode = currNode.next;
            }
        }
        return node;
    }

    /**
      *  删除排序链表中的重复元素
     * 1 3 3 5 7 7------>1  5
     * @param head
     * @return
     */
    private static NodeTest deleteDuplicated(NodeTest head){
        NodeTest preNode=new NodeTest(0);
        preNode.next=head;
        NodeTest pre=preNode;
        //用两个引用来比较前后两个结点的值相不相同
        NodeTest p1=head;
        NodeTest p2=head.next;
        while(p2!=null){
            if(p1.data==p2.data){
                while(p2!=null&&p1.data==p2.data){
                    p2=p2.next;
                }
                pre.next=p2;
                p1=p2;
                if(p2!=null) {
                    p2 = p2.next;
                }
            }else{
                pre=pre.next;
                p1=p1.next;
                p2=p2.next;
            }
        }
        return preNode.next;

    }

    /**
     * 1 3 5 7 5-----删除5------>1 3 7
     * 删除指定的节点
     * @param node1
     * @param var
     */
    private static void deleteNode1(NodeTest node1, int var){
        while(node1 != null){
            if(node1.data!= var){
                break;
            }
            node1 = node1.next;
        }
        //上面的循环跳出之后，说明新的头结点不可能是要删除的
        //因此可以不用再考虑头结点的删除问题
        NodeTest cur = node1;
        NodeTest pre = node1;
        while(cur != null){
            //这个相等的判断在第一次循环时不会成立
            //所以在第一次循环结束时,pre=head,cur=head.next
            //pre和cur是相差了一个指针的节点，相当于cur节点的的前一个结点
            //使用pre作为指针节点是为了删除当前(如果值满足条件)节点的
            if(cur.data== var){
                pre.next = cur.next;
            }else{
                pre = cur;
            }
            cur = cur.next;
        }
        System.out.println(node1);
    }

    /**
     * 1 3 5 7 9 ------删除倒数第三个5-----> 1 3 7 9
     * 删除链表的倒数第N个节点
     * @param head
     * @param n
     * @return
     */
    //双指针法
    public static NodeTest removeNthFromEnd(NodeTest head, int n) {
        NodeTest fast = head;
        NodeTest slow = head;
        //fast先走n步
        for (int i = 0; i < n ; i++) {
            fast = fast.next;
        }
        if (fast == null){
            return head.next;
        }
        //同时移动fast和slow
        while (fast.next != null){
            fast = fast.next;
            slow = slow.next;
        }
        //删除第n个节点
        slow.next = slow.next.next;
        return head;
    }
    /**
     * 1 3 5 7 9 ------删除第2个3-----> 1 5 7 9
     * 删除链表的第N个节点
     * @param head
     * @param n
     * @return
     */
    public static NodeTest removeNthFromStart(NodeTest head, int n) {
        NodeTest curr = head;
        n = n-1;
        for (int i = 0; i < n ; i++) {
            if(i+1 == n){
                curr.next = curr.next.next;
                break;
            }
            curr = curr.next;
        }
        return head;
    }

    /**
     *实现两个有序单链表合并
     * @param list1 1 3 5
     * @param list2 2 4
     * @return
     */
    public static NodeTest merge(NodeTest list1, NodeTest list2) {
        if(list1 == null){
            return list2;
        }
        if(list2 == null){
            return list1;
        }
        NodeTest node = null;
        if(list1.data <= list2.data){
            list1.next = merge(list1.next, list2);
            node = list1;
        }else {
            list2.next = merge(list1, list2.next);
            node = list2;
        }
        return node;
    }

    /**
     *实现两个有序单链表合并
     * @param a 1 3 5
     * @param b 2 4
     * @param b
     * @return
     */
    public NodeTest merge2(NodeTest a, NodeTest b) {
        if (a == null || b == null) {
            return a != null ? a : b;
        }
        NodeTest head = new NodeTest(0);
        NodeTest tail = head, aPtr = a, bPtr = b;
        while (aPtr != null && bPtr != null) {
            if (aPtr.data < bPtr.data) {
                tail.next = aPtr;
                aPtr = aPtr.next;
            } else {
                tail.next = bPtr;
                bPtr = bPtr.next;
            }
            tail = tail.next;
        }
        tail.next = (aPtr != null ? aPtr : bPtr);
        return head.next;
    }

    /**
     * 合并K个升序链表
     * lists = [[1,4,5],[1,3,4],[2,6]]
     * [1,1,2,3,4,4,5,6]
     * @param lists
     * @return
     */
    public NodeTest mergeKLists(NodeTest[] lists) {
        NodeTest list = null;
        for(int i=0;i<lists.length;i++){
            list = merge2(list,lists[i]);
        }
        return list;
    }

    /**
     * 输入一个链表，输出该链表中倒数第k个节点。为了符合大多数人的习惯，本题从1开始计数，即链表的尾节点是倒数第1个节点。
     * 例如，一个链表有 6 个节点，从头节点开始，它们的值依次是 1、2、3、4、5、6。这个链表的倒数第 3 个节点是值为 4 的节点。
     * 给定一个链表: 1->2->3->4->5, 和 k = 2.
     * 返回链表 4->5.
     * @return
     */
    private static NodeTest getKthFromEnd(NodeTest head, int k){
        NodeTest fast = head;
        NodeTest slow = head;
        //fast先走n步
        for (int i = 0; i < k ; i++) {
            fast = fast.next;
        }
        while(fast.next != null){
            fast = fast.next;
            slow = slow.next;
        }
        head = slow.next;
        System.out.println(slow.next.data);
        return head;
    }
    /**
     * 输入一个链表，输出该链表中第k个节点。为了符合大多数人的习惯，本题从1开始计数，即链表的尾节点是第1个节点。
     * 例如，一个链表有 6 个节点，从头节点开始，它们的值依次是 1、2、3、4、5、6。这个链表的第 3 个节点是值为 3 的节点。
     * 给定一个链表: 1->2->3->4->5, 和 k = 2.
     * 返回链表 2->3->4->5.
     * @return
     */
    private static NodeTest getKthFromStart(NodeTest head, int k){
        NodeTest curr = head;
        k = k-1;
        for(int i = 1 ;i<= k ;i++){
            curr = curr.next;
            if(i == k){
                break;
            }
        }
        head = curr;
        return head;
    }

    /**
     * 分段反转链表
     * @param head
     * @param k
     * @return
     */
    public static NodeTest reverseKGroup(NodeTest head, int k) {
        if(head==null||head.next==null) return head;
        //定义一个假的节点。
        NodeTest dummy = new NodeTest(0);
        //假节点的next指向head。
        dummy.next = head;
        // dummy->1->2->3->4->5
        //初始化pre和end都指向dummy。pre指每次要翻转的链表的头结点的上一个节点。end指每次要翻转的链表的尾节点
        NodeTest pre=dummy;
        NodeTest end=dummy;
        while(end.next!=null){
            //循环k次，找到需要翻转的链表的结尾,这里每次循环要判断end是否等于空,因为如果为空，end.next会报空指针异常。
            for(int i=0;i<k&&end!=null;i++){
                end = end.next;
            }
            //如果end==null，即需要翻转的链表的节点数小于k，不执行翻转。
            if(end==null)break;
            //先记录下end.next,方便后面链接链表
            NodeTest next = end.next;
            //然后断开链表
            end.next=null;
            //记录下要翻转链表的头节点
            NodeTest start=pre.next;
            //翻转链表,pre.next指向翻转后的链表。1->2 变成2->1。 dummy->2->1
            pre.next=reverse(start);
            //翻转后头节点变到最后。通过.next把断开的链表重新链接。
            start.next=next;
            //将pre换成下次要翻转的链表的头结点的上一个节点。即start
            pre = start;
            //翻转结束，将end置为下次要翻转的链表的头结点的上一个节点。即start
            end = start;
        }
        return dummy.next;
    }

    /**
     * 1 3 5 7 9 ---->9 7 5 3 1
     * 反转链表
     * @return
     */
    private static NodeTest reverse(NodeTest head){
        NodeTest curr = head;
        NodeTest pre = null;
        while(null != curr){
            NodeTest temp = curr.next;
            curr.next = pre;
            pre = curr;
            curr = temp;
        }
        return pre;
    }

    /**
     *  环形链表
     * @return
     */
    private static boolean isCycle(NodeTest head){
        NodeTest fast = head;
        NodeTest slow = head;
        while(fast != null && fast.next != null){
            fast = fast.next.next;
            slow = slow.next;
            if(fast == slow){
                return true;
            }
        }
        return false;
    }

    /**
     * node1   1 3 5 7 9
     * node2   1 2 5 7 9
     * 公共节点就是 5  7  9
     * 两个链表的第一个公共节点
     * @return
     */
    private static NodeTest isFirstPublic(NodeTest node1,NodeTest node2){
        NodeTest nodeTest1 = node1;
        NodeTest nodeTest2 = node2;
        Map<NodeTest,Integer> map = new HashMap<>();
        while(null != nodeTest1){
            map.put(nodeTest1,nodeTest1.data);
            nodeTest1 = nodeTest1.next;
        }
        while(null != nodeTest2){
            if(map.containsKey(nodeTest2)){
                return nodeTest2;
            }
            nodeTest2 = nodeTest2.next;
        }
        return null;
    }

    /**
     * 1 2 3 4 5
     * 从尾到头打印链表
     */
    private static void  printNode(NodeTest node){
        Stack<NodeTest> stack = new Stack<>();
        while(null != node){
            stack.push(node);
            node = node.next;
        }
        while(stack.size()>0){
            System.out.println(stack.pop().toString());
        }
    }

    /**
     * 链表的中间节点
     * @return
     */
    private static NodeTest middleNode(NodeTest node1){
        NodeTest fast = node1;
        NodeTest slow = node1;
        while(null != fast && null != fast.next){
            fast = fast.next.next;
            slow = slow.next;
        }
        return slow;
    }

    /**
     * 1 3 5
     * 2 4
     * 新的链表应该是 1 5 9
     * 正向两个链表求和，组成新的链表
     * @param node1
     * @param node2
     * @return
     */
    private static NodeTest addTwoNumbers(NodeTest node1,NodeTest node2){
        LinkedList<Integer> queue1 = new LinkedList<>();
        LinkedList<Integer> queue2 = new LinkedList<>();
        NodeTest nodeTest = null;
        NodeTest returnNode = null;
        while(null != node1){
            queue1.add(node1.data);
            node1 = node1.next;
        }
        while(null != node2){
            queue2.add(node2.data);
            node2 = node2.next;
        }
        StringBuffer s1 = new StringBuffer();
        StringBuffer s2 = new StringBuffer();
        while(queue1.size()>0){
            s1.append(queue1.pop());
        }
        while(queue2.size()>0){
            s2.append(queue2.pop());
        }
        int i1 = Integer.parseInt(s1.toString());

        int i2 = Integer.parseInt(s2.toString());
        int a = i2+i1;
        String s = String.valueOf(a);
        for(int i = 0 ;i<s.length();i++){
            int newI = s.charAt(i)-'0';
            NodeTest newNode = new NodeTest(newI);
            if(null != nodeTest){
                nodeTest.next = newNode;
                nodeTest = nodeTest.next;
            }else{
                nodeTest = newNode;
                returnNode = nodeTest;
            }
        }
        return returnNode;
    }

    /**
     * 1 3 5--->5 3 1
     * 2 4----> 4 2
     * 新的链表应该是 5 7 3
     * 反向两个链表求和，组成新的链表
     * @param l1
     * @param l2
     * @return
     */
    private static NodeTest addTwoNumbersReverse(NodeTest l1,NodeTest l2){
        //1.特判
        NodeTest ans = new NodeTest(0);
        NodeTest p1=ans;
        int add = 0;
        //2.从这两个链表的头开始取对应位置的节点进行
        while(l1!=null||l2!=null||add!=0){
            int v1 = l1==null?0: l1.data;
            int v2 = l2==null?0: l2.data;
            int sum = v1+v2+add;
            p1.next = new NodeTest(sum%10);
            add = sum/10;
            p1=p1.next;
            if(l1!=null)l1 = l1.next;
            if(l2!=null)l2 = l2.next;
        }
        return ans.next;
    }



}
