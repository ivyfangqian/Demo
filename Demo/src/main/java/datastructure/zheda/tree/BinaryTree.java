package datastructure.zheda.tree;

import datastructure.princeton.Queue;
import datastructure.princeton.StackLinked;
import datastructure.stack.Stack;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.List;

public class BinaryTree<Item> {


    private BinaryNode root;

    public BinaryTree() {
    }

    public BinaryTree(BinaryNode root) {
        this.root = root;
    }

    public BinaryTree(Item data) {
        root = new BinaryNode(data);
//        root.left = null;
//        root.right =null;
    }

    public BinaryNode getRoot() {
        return root;
    }

    public void setRoot(BinaryNode root) {
        this.root = root;
    }

    public boolean isEmpty() {
        return root.data == null;
    }

    public void add(BinaryNode parent, BinaryNode child, String orientation) {
        if ("left".equals(orientation)) {
            parent.left = child;
        } else if ("right".equals(orientation)) {
            parent.right = child;
        } else {
            throw new RuntimeException("no such orientation");
        }
    }

    /**
     * 先序遍历
     *
     * @param focusNode
     */
    public void preOrderTravelsal(BinaryNode focusNode) {
        if (focusNode != null) {
            System.out.println(focusNode.toString());
            preOrderTravelsal(focusNode.left);
            preOrderTravelsal(focusNode.right);

        }
    }

    /**
     * 中序遍历
     *
     * @param focusNode
     */
    public void inOrderTravelsal(BinaryNode focusNode) {
        if (focusNode != null) {
            inOrderTravelsal(focusNode.left);
            System.out.println(focusNode.toString());
            inOrderTravelsal(focusNode.right);

        }
    }

    /**
     * 后序遍历
     *
     * @param focusNode
     */
    public void postOrderTravelsal(BinaryNode focusNode) {
        if (focusNode != null) {
            postOrderTravelsal(focusNode.left);
            postOrderTravelsal(focusNode.right);
            System.out.println(focusNode.toString());
        }
    }

    /**
     * 用堆栈的方式实现先序遍历
     *
     * @param focusNode
     */
    public void preOrderTravelsalByStack(BinaryNode focusNode) {
        StackLinked<BinaryNode> s = new StackLinked<BinaryNode>();
        while (focusNode != null || !s.isEmpty()) {
            while (focusNode != null) {
                System.out.println(focusNode);
                s.push(focusNode);
                focusNode = focusNode.left;
            }
            if (!s.isEmpty()) {
                focusNode = s.pop();
                focusNode = focusNode.right;
            }
        }
    }

    /**
     * 用堆栈的方式实现中序遍历
     *
     * @param focusNode
     */
    public void inOrderTravelsalByStack(BinaryNode focusNode) {
        StackLinked<BinaryNode> s = new StackLinked<BinaryNode>();
        while (focusNode != null || !s.isEmpty()) {
            while (focusNode != null) {
                s.push(focusNode);
                focusNode = focusNode.left;
            }
            if (!s.isEmpty()) {
                focusNode = s.pop();
                System.out.println(focusNode);
                focusNode = focusNode.right;
            }
        }
    }

    /**
     * 用队列的方式实现层序遍历
     *
     * @param focusNode
     */
    public void levelOrderTravelsal(BinaryNode focusNode) {
        Queue<BinaryNode> queue = new Queue<BinaryNode>();
        queue.enQueue(focusNode);
        while (!queue.isEmpty()) {
            BinaryNode node = queue.deQueue();
            System.out.println(node);
            if (node.left != null) {
                queue.enQueue(node.left);
            }
            if (node.right != null) {
                queue.enQueue(node.right);
            }
        }

    }


    /**
     * 用堆栈的方式实现后序遍历
     * 这里的思路是这样的：先进行一个根节点，右子树，左子树这样顺序的先序遍历，
     * 得到的数据放到一个list中，然后对list进行反转就可以得到二叉树的后序遍历
     *
     * @param focusNode
     */
    public void postOrderTravelsalByStack(BinaryNode focusNode) {
        StackLinked<BinaryNode> s = new StackLinked<BinaryNode>();
        s.push(focusNode);
        List<BinaryNode> res = new ArrayList<BinaryNode>();
        while (!s.isEmpty()) {
            BinaryNode node = s.pop();
            if (node != null) {//进行一个根节点，右子树，左子树这样顺序的先序遍历
                res.add(node);
                s.push(node.left);
                s.push(node.right);
            }
        }

        //对list进行反转
        Collections.reverse(res);
        for (BinaryNode node : res) {
            System.out.println(node);
        }
    }

    /**
     * 访问所有叶子结点
     *
     * @param node
     */
    public void preOrderPrintLeaves(BinaryNode node) {
        if (node != null) {
            if (node.left == null && node.right == null) {
                System.out.println(node);
            }
            preOrderPrintLeaves(node.left);
            preOrderPrintLeaves(node.right);
        }
    }

    /**
     * 求二叉树的深度
     *
     * @param node 根节点
     * @return 二叉树的深度
     */
    public int postOrderGetHeight(BinaryNode node) {
        int heightLeft = 0;
        int heightRight = 0;
        int maxHeight = 0;
        if (node != null) {
            if (node.left == null && node.right == null) {
                return 1;
            }
            heightLeft = postOrderGetHeight(node.left);
            heightRight = postOrderGetHeight(node.right);
            return heightLeft > heightRight ? heightLeft + 1 : heightRight + 1;
        } else {
            return 0;
        }
    }

    /**
     * 判断两棵树是否同构
     *
     * @param node1 第一棵树的根节点
     * @param node2 第二颗树的根节点
     * @return 如果两棵树是同构的，返回true，如果两棵树不是同构的，返回false
     */
    public static boolean isomorphic(BinaryNode node1, BinaryNode node2) {
        //如果两个根节点都为空，则同构
        if (node1 == null && node2 == null) {
            return true;
        }
        //如果一个为空，另一个不为空，则不同构
        if ((node1 == null && node2 != null) || (node1 != null && node2 == null)) {
            return false;
        }
        //如果两个节点不为空，但是不相等，则不同构
        if (node1 != node2) {
            return false;
        }
        //如果两个节点的左子树为空，递归右子树
        if (node1.left == null && node2.left == null) {
            return isomorphic(node1.right, node2.right);
        }

        //如果两个节点左子树不为空，且左子树根节点相等，递归左子树
        if ((node1.left != null && node2.left != null) && (node1.left == node2.left)) {
            return isomorphic(node1.left, node2.left);
        } else {
            return isomorphic(node1.left, node2.right) && isomorphic(node1.right, node2.left);
        }
    }

    public static void main(String[] args) {
        BinaryNode nodeA = new BinaryNode("A");
        BinaryNode nodeB = new BinaryNode("B");
        BinaryNode nodeC = new BinaryNode("C");
        BinaryNode nodeD = new BinaryNode("D");
        BinaryNode nodeE = new BinaryNode("E");
        BinaryNode nodeF = new BinaryNode("F");
        BinaryNode nodeG = new BinaryNode("G");
        BinaryNode nodeH = new BinaryNode("H");
        BinaryNode nodeI = new BinaryNode("I");

        BinaryTree<String> tree = new BinaryTree<String>();
        tree.setRoot(nodeA);
        tree.add(nodeA, nodeB, "left");
        tree.add(nodeA, nodeC, "right");
        tree.add(nodeB, nodeD, "left");
        tree.add(nodeB, nodeF, "right");
        tree.add(nodeF, nodeE, "left");
        tree.add(nodeC, nodeG, "left");
        tree.add(nodeC, nodeI, "right");
        tree.add(nodeG, nodeH, "right");

        BinaryTree<String> tree2 = new BinaryTree<String>();
        tree2.setRoot(nodeA);
        tree2.add(nodeA, nodeB, "right");
        tree2.add(nodeA, nodeC, "left");
        tree2.add(nodeB, nodeD, "right");
        tree2.add(nodeB, nodeF, "left");
        tree2.add(nodeF, nodeE, "left");
        tree2.add(nodeC, nodeG, "left");
        tree2.add(nodeC, nodeI, "right");
        tree2.add(nodeG, nodeH, "left");

        System.out.println("先序遍历：");
        tree.preOrderTravelsal(nodeA);

        System.out.println("中序遍历：");
        tree.inOrderTravelsal(nodeA);

        System.out.println("后序遍历：");
        tree.postOrderTravelsal(nodeA);

        System.out.println("用堆栈的方式实现先序遍历：");
        tree.preOrderTravelsalByStack(nodeA);

        System.out.println("用堆栈的方式实现中序遍历：");
        tree.inOrderTravelsalByStack(nodeA);

        System.out.println("用堆栈的方式实现后序遍历：");
        tree.postOrderTravelsalByStack(nodeA);

        System.out.println("用队列实现层序遍历：");
        tree.levelOrderTravelsal(nodeA);

        System.out.println("访问所有叶子结点：");
        tree.preOrderPrintLeaves(nodeA);

        System.out.println("二叉树的深度为：" + tree.postOrderGetHeight(nodeA));

        System.out.println("tree与tree2是否同构：" + BinaryTree.isomorphic(tree.getRoot(), tree2.getRoot()));
    }


}

class BinaryNode<Item> {
    public Item data;
    public BinaryNode left;
    public BinaryNode right;

    public BinaryNode(Item data) {
        this.data = data;
    }

    public Item getData() {
        return data;
    }

    public void setData(Item data) {
        this.data = data;
    }

    public BinaryNode getLeft() {
        return left;
    }

    public void setLeft(BinaryNode left) {
        this.left = left;
    }

    public BinaryNode getRight() {
        return right;
    }

    public void setRight(BinaryNode right) {
        this.right = right;
    }

    @Override
    public String toString() {
        return "nodedata:" + data;
    }


}