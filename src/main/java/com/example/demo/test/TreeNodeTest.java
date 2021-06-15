package com.example.demo.test;

import lombok.Data;

import java.util.*;

@Data
public class TreeNodeTest {

    private int val;

    private TreeNodeTest left;

    private TreeNodeTest right;

    public TreeNodeTest(int val) {
        this.val = val;
    }

    @Override
    public String toString() {
        return "TreeNodeTest{" +
                "val=" + val +
                ", left=" + left +
                ", right=" + right +
                '}';
    }

    public static void main(String[] args) {
//        TreeNodeTest root3 = new TreeNodeTest(3);
//        TreeNodeTest root9 = new TreeNodeTest(9);
//        TreeNodeTest root20 = new TreeNodeTest(20);
//        TreeNodeTest root15 = new TreeNodeTest(15);
//        TreeNodeTest root7 = new TreeNodeTest(7);
//        root3.left = root9;
//        root3.right = root20;
//        root20.left = root15;
//        root20.right = root7;
//        levelOrder(root3);
        int[] array = {1,3,2,6,5};


    }

    static Map<Integer,TreeNodeTest> parent = new HashMap<Integer,TreeNodeTest>();
    static Set<Integer> visited = new HashSet<Integer>();

    //遍历树将每个节点的父节点存起来
    public static void dfs(TreeNodeTest root){
        if (root.left!=null){
            parent.put(root.left.val,root);
            dfs(root.left);
        }
        if(root.right!=null){
            parent.put(root.right.val,root);
            dfs(root.right);
        }
    }
    /**
     *二叉树的最近公共祖先
     * @param root
     * @param p
     * @param q
     * @return
     */
    public static TreeNodeTest lowestCommonAncestor(TreeNodeTest root, TreeNodeTest p, TreeNodeTest q) {
        //遍历树将每个节点的父节点存起来
        dfs(root);
        //从p节点开始不断地往上跳，并记录访问过的节点，
        while (p!=null){
            visited.add(p.val);
            p = parent.get(p.val);
        }
        while (q!=null){
            //从q节点开始不断地往上跳,如果碰到已经访问过的节点，那么这个节点就是我们要找的最近公共祖先
            if (visited.contains(q.val)){
                return q;
            }
            q = parent.get(q.val);
        }
        return null;
    }


    /**
     * 翻转二叉树
     * @param root
     * @return
     */
    public static TreeNodeTest invertTree(TreeNodeTest root) {
        //递归终止条件
        if(root == null){
            return null;
        }
        System.out.println(root.val);
        //反转左子树
        TreeNodeTest leftNode = invertTree(root.left);
        //反转右子树
        TreeNodeTest rightNode = invertTree(root.right);
        //交换左右子树
        root.left = rightNode;
        root.right = leftNode;
        return root;
    }

    /**
     * 二叉树的最大深度
     * @param root
     * @return
     */
    public static int maxDepth(TreeNodeTest root){
        if(root == null){
            return 0;
        }
        int left = maxDepth(root.left);
        System.out.println("left:"+left);
        int right = maxDepth(root.right);
        System.out.println("right:"+right);
        return Math.max(left,right)+1;
    }

    /**
     * 二叉树的最小深度
     * @param root
     * @return
     */
    public static int minDepth(TreeNodeTest root){
        if(root == null){
            return 0;
        }
        int left = minDepth(root.left);
        int right = minDepth(root.right);
        return null == root.left || null == root.right ? left+right+1:Math.min(left,right)+1;
    }

    /**
     * 左叶子之和
     * @param root
     * @return
     */
    public static int sumOfLeftLeaves(TreeNodeTest root) {
        return root != null ? sfll(root) : 0;
    }

    /**
     * 递归找子节点
     * @param node
     * @return
     */
    public static int sfll(TreeNodeTest node) {
        int ans = 0;
        if (node.left != null) {
            ans += isLeafNode(node.left) ? node.left.val : sfll(node.left);
        }
        if (node.right != null && !isLeafNode(node.right)) {
            ans += sfll(node.right);
        }
        return ans;
    }

    /**
     * 判断是不是还有子节点
     * @param node
     * @return
     */
    public static boolean isLeafNode(TreeNodeTest node) {
        return node.left == null && node.right == null;
    }

    /**
     * 求根到叶子节点数字之和
     * @param root
     * @return
     */
    public static int sumNumbers(TreeNodeTest root) {
        return sns(root, 0);
    }

    private static int sns(TreeNodeTest root, int sum) {
        //终止条件的判断
        if (root == null)
            return 0;
        //计算当前节点的值
        sum = sum * 10 + root.val;
        //如果当前节点是叶子节点，说明找到了一条完整路径，直接
        //返回这条路径的值即可
        if (root.left == null && root.right == null)
            return sum;
        //如果当前节点不是叶子结点，返回左右子节点的路径和
        int left =sns(root.left, sum);
        int right =sns(root.right, sum);

        return left + right;
    }

    /**
     * 二叉树的右视图
     * @param root
     * @return
     */
    public static List<Integer> rightSideView(TreeNodeTest root) {
        Queue<TreeNodeTest> queue = new LinkedList();
        List<Integer> list = new ArrayList();
        if(root==null) return list;
        queue.add(root);
        while(!queue.isEmpty()){
            int size = queue.size();
            for(int i=0;i<size;i++){
                TreeNodeTest node = queue.poll();
                if(node.left!=null){
                    queue.add(node.left);
                }
                if(node.right!=null){
                    queue.add(node.right);
                }
                if(i==size-1){
                    list.add(node.val);
                }
            }
        }
        return list;
    }

    /**
     * 二叉树的中序遍历
     * @param root
     * @return
     */
    public List<Integer> inorderTraversal(TreeNodeTest root) {
        List<Integer> list = new ArrayList<>();
        getList(root,list);
        return list;
    }

    public void getList(TreeNodeTest root,List<Integer> list){
        if(root == null){
            return;
        }
        getList(root.left,list);
        list.add(root.val);
        getList(root.right,list);

    }

    /**
     * 根据前序和中序，输出这个二叉树
     */
    //利用原理,先序遍历的第一个节点就是根。在中序遍历中通过根 区分哪些是左子树的，哪些是右子树的
    //左右子树，递归
    HashMap<Integer, Integer> map = new HashMap<>();//标记中序遍历
    int[] preorder;//保留的先序遍历

    public TreeNodeTest buildTree(int[] preorder, int[] inorder) {
        this.preorder = preorder;
        for (int i = 0; i < preorder.length; i++) {
            map.put(inorder[i], i);
        }
        return recursive(0,0,inorder.length-1);
    }

    /**
     * @param pre_root_idx  先序遍历的索引
     * @param in_left_idx  中序遍历的索引
     * @param in_right_idx 中序遍历的索引
     */
    public TreeNodeTest recursive(int pre_root_idx, int in_left_idx, int in_right_idx) {
        //相等就是自己
        if (in_left_idx > in_right_idx) {
            return null;
        }
        //root_idx是在先序里面的
        TreeNodeTest root = new TreeNodeTest(preorder[pre_root_idx]);
        // 有了先序的,再根据先序的，在中序中获 当前根的索引
        int idx = map.get(preorder[pre_root_idx]);

        //左子树的根节点就是 左子树的(前序遍历）第一个，就是+1,左边边界就是left，右边边界是中间区分的idx-1
        root.left = recursive(pre_root_idx + 1, in_left_idx, idx - 1);

        //由根节点在中序遍历的idx 区分成2段,idx 就是根

        //右子树的根，就是右子树（前序遍历）的第一个,就是当前根节点 加上左子树的数量
        // pre_root_idx 当前的根  左子树的长度 = 左子树的左边-右边 (idx-1 - in_left_idx +1) 。最后+1就是右子树的根了
        root.right = recursive(pre_root_idx + (idx-1 - in_left_idx +1)  + 1, idx + 1, in_right_idx);
        return root;
    }

    public static List<List<Integer>> levelOrder(TreeNodeTest root) {
        List<List<Integer>> lists = new ArrayList<>();
        if(null == root){
            return lists;
        }
        Queue<TreeNodeTest> queue = new LinkedList<>();
        queue.add(root);
        int s = 2;
        while(!queue.isEmpty()){
            int size = queue.size();
            LinkedList<Integer> list = new LinkedList<>();
            for(int i = 0;i<size;i++){
                TreeNodeTest node = queue.poll();

                if(s%2==0){
                    list.addLast(node.val);
                }else{
                    list.addFirst(node.val);
                }
                if(node.left != null){
                    queue.add(node.left);
                }
                if(node.right != null){
                    queue.add(node.right);
                }
            }
            s++;
            lists.add(list);
        }
        return lists;
    }


}
