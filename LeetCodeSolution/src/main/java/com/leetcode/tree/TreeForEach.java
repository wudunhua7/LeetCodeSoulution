package com.leetcode.tree;

import java.util.*;

/**
 * Created by dun on 2020/6/18.
 */
public class TreeForEach {

    private List<Integer> result = new ArrayList<>();

    private static TreeNode root;
    static {
        root = new TreeNode(1);
        root.left=new TreeNode(2);
        root.right=new TreeNode(3);
        root.left.left=new TreeNode(4);
        root.left.right=new TreeNode(5);
        root.right.left=new TreeNode(6);
        root.left.right.right=new TreeNode(7);
    }

    public static void main(String[] args) {
        //inorderTraversalByMorris2(root);
    }

    //=====================前序遍历=====================
    /**
     * 144. 二叉树的前序遍历
     给定一个二叉树，返回它的 前序 遍历。

     示例:

     输入: [1,null,2,3]
     1
     \
     2
     /
     3

     输出: [1,2,3]
     进阶: 递归算法很简单，你可以通过迭代算法完成吗？
     */
    public List<Integer> preorderTraversal(TreeNode root) {
        if(root==null){
            return result;
        }

        result.add(root.val);
        preorderTraversal(root.left);
        preorderTraversal(root.right);
        return result;
    }

    public List<Integer> preorderTraversalByMorris(TreeNode root) {

        TreeNode current = root;
        while(current!=null){
            if(current.left==null){
                result.add(current.val);
                current=current.right;
            }else {
                TreeNode pre=current.left;

                while(pre.right!=null&&pre.right!=current){
                    pre=pre.right;
                }

                if(pre.right==null){
                    //挂载前输出当前节点
                    result.add(current.val);
                    //挂载当前节点,到其左子树的最右节点,作为记录线索,遍历后续的有节点
                    pre.right=current;
                    //移动到下个左子树
                    current=current.left;
                }

                if(pre.right==current){
                    //切断联系
                    pre.right=null;
                    current=current.right;
                }
            }
        }

        return result;
    }

    public List<Integer> preorderTraversalByStack(TreeNode root) {

        TreeNode current = root;
        Stack<TreeNode> stack = new Stack();
        while(current!=null||!stack.isEmpty()){
            while(current!=null){
                result.add(current.val);
                stack.push(current);
                current=current.left;
            }
            current = stack.pop();
            current = current.right;
        }
        return result;
    }
    //=====================前序遍历=====================


    //=====================中序遍历=====================
    /**
     * 94. 二叉树的中序遍历
     给定一个二叉树，返回它的中序 遍历。

     示例:

     输入: [1,null,2,3]
     1
     \
     2
     /
     3

     输出: [1,3,2]
     进阶: 递归算法很简单，你可以通过迭代算法完成吗？
     */
    public List<Integer> inorderTraversal(TreeNode root) {

        if(root==null){
            return result;
        }

        inorderTraversal(root.left);
        result.add(root.val);
        inorderTraversal(root.right);
        return result;
    }

    /**
     * Step 1: 将当前节点current初始化为根节点

     Step 2: While current不为空，

     若current没有左子节点

     a. 将current添加到输出

     b. 进入右子树，亦即, current = current.right

     否则

     a. 在current的左子树中，令current成为最右侧节点的右子节点

     b. 进入左子树，亦即，current = current.left




     举例而言:

     1
     /   \
     2     3
     / \   /
     4   5 6

     首先，1 是根节点，所以将 current 初始化为 1。1 有左子节点 2，current 的左子树是


     2
     / \
     4   5
     在此左子树中最右侧的节点是 5，于是将 current(1) 作为 5 的右子节点。令 current = cuurent.left (current = 2)。
     现在二叉树的形状为:


     2
     / \
     4   5
     \
     1
     \
     3
     /
     6
     对于 current(2)，其左子节点为4，我们可以继续上述过程


     4
     \
     2
     \
     5
     \
     1
     \
     3
     /
     6
     由于 4 没有左子节点，添加 4 为输出，接着依次添加 2, 5, 1, 3 。节点 3 有左子节点 6，故重复以上过程。
     最终的结果是 [4,2,5,1,6,3]。
     */
    //不破坏原先的root树结构
    public List<Integer> inorderTraversalByMorris(TreeNode root) {

        TreeNode current = root;
        while(current!=null){
            if(current.left==null){
                //左子树为空，输出当前节点，并进入右边子树
                result.add(current.val);
                current=current.right;
            }else{
                //左子树非空，进入左子树
                TreeNode pre=current.left;
                //寻找左子树的最右子树,pre.right!=current是为了打断（将当前节点“挂入”当前节点左子树的最右节点）后形成的循环
                while(pre.right!=null&&pre.right!=current){
                    pre=pre.right;
                }
                //pre.right==null表示，最右节点没挂入当前节点；
                if(pre.right==null){
                    //当前节点挂入当前左子树最右节点
                    pre.right=current;
                    //进入当前节点左子树
                    current=current.left;
                }

                //表示当前先驱节点加入了线索
                if(pre.right==current){
                    //输出当前节点
                    result.add(current.val);
                    //切端线索
                    pre.right=null;
                    //进入右子树
                    current=current.right;
                }
            }
        }
        return result;
    }

    //破坏root树结构
    public List<Integer> inorderTraversalByMorris2(TreeNode root) {

        TreeNode current = root;
        while(current!=null){
            if(current.left==null){
                //左子树为空，输出当前节点，并进入右边子树
                result.add(current.val);
                current=current.right;
            }else{
                //左子树非空，进入左子树
                TreeNode pre=current.left;
                //寻找左子树的最右子树
                while(pre.right!=null){
                    pre=pre.right;
                }

                //最右节点挂入当前节点
                pre.right=current;
                TreeNode temp=current;
                //进入左子树
                current=current.left;
                //切断当前节点，和左子树的联系，避免形成循环
                temp.left=null;
            }
        }
        return result;
    }

    public List<Integer> inorderTraversalByStack(TreeNode root) {

        Stack<TreeNode> stack = new Stack();
        TreeNode current = root;

        while(current!=null||!stack.isEmpty()){
            //非空入栈
            while (current!=null){
                stack.push(current);
                current=current.left;
            }
            //为空弹栈
            current=stack.pop();
            result.add(current.val);
            //遍历右子树
            current=current.right;
        }
        return result;
    }
    //=====================中序遍历=====================

    //=====================后序遍历=====================
    public List<Integer> postorderTraversal(TreeNode root) {
        if(root==null){
            return result;
        }
        postorderTraversal(root.left);
        postorderTraversal(root.right);
        result.add(root.val);
        return result;
    }


    private LinkedList<Integer> resultLinked = new LinkedList<>();

    public List<Integer> postorderTraversalByStack(TreeNode root) {

        if(root==null){
            return resultLinked;
        }

        TreeNode current = root;
        Stack<TreeNode> stack = new Stack();
        stack.push(root);
        while(!stack.isEmpty()){
            current=stack.pop();
            resultLinked.addFirst(current.val);
            if(current.left!=null){
                stack.push(current.left);
            }
            if(current.right!=null){
                stack.push(current.right);
            }
        }
        return resultLinked;
    }
    //=====================后序遍历=====================

    //=====================层次遍历=====================
    private List<List<Integer>> results = new ArrayList();
    public List<List<Integer>> levelOrder(TreeNode root) {
        if(root==null){
            return results;
        }
        ArrayDeque<TreeNode> queue = new ArrayDeque();
        queue.add(root);
        while(!queue.isEmpty()){
            List<Integer> level = new ArrayList();
            //记录当前层级node个数
            int leveSize = queue.size();
            for(int i=0;i<leveSize;i++){
                TreeNode current = queue.poll();
                level.add(current.val);
                if(current.left!=null){
                    queue.add(current.left);
                }
                if(current.right!=null){
                    queue.add(current.right);
                }
            }
            results.add(level);
        }
        return results;
    }

    //递归
    public List<List<Integer>> levelOrderByDigui(TreeNode root) {
        if(root==null){
            return results;
        }

        bfs(1, root);

        return results;
    }

    public void bfs(int index, TreeNode current){
        if(results.size()<index){
            results.add(new ArrayList<Integer>());
        }

        results.get(index-1).add(current.val);
        if(current.left!=null){
            bfs(index+1, current.left);
        }

        if(current.right!=null){
            bfs(index+1, current.right);
        }
    }

    //N叉树的层次遍历--递归
    public List<List<Integer>> levelOrderByDigui(Node root) {
        if(root!=null) nNodeBfs(1, root);
        return results;
    }

    private void nNodeBfs(int index, Node node) {
        if(results.size()<index){
            results.add(new ArrayList<>());
        }

        results.get(index-1).add(node.val);
        for (Node nodeK: node.children){
            nNodeBfs(index+1,nodeK);
        }
    }
    //N叉树的层次遍历--递归

    //N叉树的层次遍历--队列
    public List<List<Integer>> levelOrder(Node root) {
        if(root==null){
            return results;
        }
        ArrayDeque<Node> queue = new ArrayDeque();
        queue.add(root);
        while(!queue.isEmpty()){
            List<Integer> level = new ArrayList();
            int levelSize=queue.size();
            for(int i=0;i<levelSize;i++){
                Node current = queue.poll();
                level.add(current.val);
                for(Node next:current.children){
                    queue.add(next);
                }
            }
            results.add(level);
        }
        return results;
    }
    //N叉树的层次遍历--队列
    //=====================层次遍历=====================


    //=====================垂序遍历=====================
    private List<List<Integer>> results1 = new ArrayList();
    ArrayDeque<TreeNode> queue = new ArrayDeque();

    TreeMap<Integer, List<Integer>> treeMap = new TreeMap<>(new Comparator<Integer>(){
        @Override
        public int compare(Integer k1, Integer k2){
            return k1-k2;
        }
    });
    public List<List<Integer>> verticalTraversal(TreeNode root) {
        if(root==null){
            return results1;
        }
        queue.add(root);
        bfs(0,0);
        transfer();
        return results1;
    }

    public void bfs(int x, int y){
        while(!queue.isEmpty()){
            TreeNode node = queue.poll();
            List<Integer> vertical= treeMap.get(x);
            if(vertical==null){
                vertical = new ArrayList<Integer>();
                vertical.add(node.val);
                treeMap.put(x, vertical);
            }else{
                vertical.add(node.val);
            }

            if(node.left!=null){
                queue.add(node.left);
                bfs(x-1,y+1);
            }

            if(node.right!=null){
                queue.add(node.right);
                bfs(x+1, y+1);
            }
        }
    }
    public void transfer(){
        if(treeMap.size()>0){
            for(List<Integer> value: treeMap.values()){
                results1.add(value);
            }
        }
    }
    //=====================垂序遍历=====================

}
