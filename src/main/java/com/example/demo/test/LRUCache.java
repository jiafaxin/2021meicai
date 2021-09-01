package com.example.demo.test;

import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

public class LRUCache<V> {
    private Map<Integer,Node> map = new ConcurrentHashMap<>();
    private Node head;
    private Node tail;
    private int capacity;
    private int size;

    public LRUCache(int capacity) {
        this.capacity = capacity;
        this.size = 0;
        head = new Node();
        tail = new Node();
        head.next = tail;
        tail.prev = head;


    }
    public int get(int key) {
        Node node = map.get(key);
        if(null == node){
            return -1;
        }else{
            // 如果 key 存在，先通过哈希表定位，再移到头部
            moveHead(node);
            return (int) node.value;
        }
    }


    public void put(int key, int value) {
        Node node = map.get(key);
        if(node == null){
            Node newNode = new Node(key,value);
            map.put(key,newNode);
            //添加到链表中的头部
            addNodeHead(newNode);
            ++size;
            if(size>capacity){
                //移除尾部的节点并数量减一
                Node removeTailNode = removeTailNode();
                map.remove(removeTailNode.key);
                --size;
            }
        }else{
            node.value = value;
            //把节点原来的位置删除，并放到头部
            moveHead(node);
        }
    }

    /**
     * 添加到头结点
     * @param node
     */
    public void addNodeHead(Node node){
        node.prev=head;
        node.next=head.next;
        head.next.prev=node;
        head.next = node;
    }

    /**
     * 删除尾节点
     * @return
     */
    public Node removeTailNode(){
        Node newNode = tail.prev;
        removeNode(newNode);
        return newNode;
    }

    /**
     * 删除节点
     * @param node
     */
    public void removeNode(Node node){
        node.prev.next = node.next;
        node.next.prev = node.prev;
    }

    /**
     * 移动到头结点
     * @param node
     */
    public void moveHead(Node node){
        removeNode(node);
        addNodeHead(node);
    }

    /**
     * 双向链表内部类
     */
    public static class Node<K, V> {
        private K key;
        private V value;
        Node<K, V> prev;
        Node<K, V> next;

        public Node(K key, V value) {
            this.key = key;
            this.value = value;
        }


        public Node() {

        }
    }


    public static void main(String[] args) {
//        LRUCache<ListNode> cache = new LRUCache<>(4);
//        ListNode<String, Integer> node1 = new ListNode<>("key1", 1);
//        ListNode<String, Integer> node2 = new ListNode<>("key2", 2);
//        ListNode<String, Integer> node3 = new ListNode<>("key3", 3);
//        ListNode<String, Integer> node4 = new ListNode<>("key4", 4);
//        ListNode<String, Integer> node5 = new ListNode<>("key5", 5);
//        cache.put("key1", node1);
//        cache.put("key2", node2);
//        cache.put("key3", node3);
//        cache.put("key4", node4);
//        cache.get("key2");
//        cache.put("key5", node5);
//        cache.get("key2");
    }
}
