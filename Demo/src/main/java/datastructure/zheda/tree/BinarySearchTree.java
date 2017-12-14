package datastructure.zheda.tree;

import datastructure.princeton.Queue;

public class BinarySearchTree {
    private BstNode root;

    public BinarySearchTree() {
        root = null;
    }

    public BinarySearchTree(BstNode node) {
        root = node;
    }

    public BstNode getRoot() {
        return root;
    }

    public void setRoot(BstNode root) {
        this.root = root;
    }

    /**
     * 通过递归的方式在二叉搜索树中查找元素
     *
     * @param element
     * @param node
     * @return 如果node为空，返回null，如果element小于node的值，递归查找左子树，
     * 如果element大于node的值，递归查找又子树
     */
    public BstNode find(int element, BstNode node) {
        if (node == null) {
            return null;
        }
        if (element < node.key) {
            return find(element, node.left);
        } else if (element > node.key) {
            return find(element, node.right);
        } else {
            return node;
        }
    }

    /**
     * 循环查找元素
     *
     * @param element
     * @param node
     * @return
     */
    public BstNode iterFind(int element, BstNode node) {
        while (node != null) {
            if (element < node.key) {
                node = node.left;
            } else if (element > node.key) {
                node = node.right;
            } else {
                return node;
            }
        }
        return null;
    }

    public BstNode findMin(BstNode node) {
        if (node == null) {
            return null;
        }
        if (node.left == null) {
            return node;
        } else {
            return findMin(node.left);
        }
    }

    public BstNode findMax(BstNode node) {
//        while (node != null) {
//            if (node.right == null) {
//                return node;
//            } else {
//                node = node.right;
//            }
//        }
//        return node;

        if (node != null) {
            while (node.right != null) {
                node = node.right;
            }

        }
        return node;
    }

    public BstNode insert(int element, BstNode node) {
        if (node == null) {
            node = new BstNode(element, 100);
            return node;
        }
        if (element < node.key) {
            node.left = insert(element, node.left);
        } else if (element > node.key) {
            node.right = insert(element, node.right);
        }
        return node;

    }

    void inorderRec(BstNode root) {
        Queue<BstNode> queue = new Queue<BstNode>();
        if (root != null) {
            queue.enQueue(root);
            while (!queue.isEmpty()) {
                BstNode node = queue.deQueue();
                System.out.println(node);
                if (node.left != null) {
                    queue.enQueue(node.left);
                }
                if (node.right != null) {
                    queue.enQueue(node.right);
                }
            }
        }
    }

    public static void main(String[] args) {
        BstNode node1 = new BstNode(50, 1);
        BstNode node2 = new BstNode(30, 2);
        BstNode node3 = new BstNode(70, 3);
        BstNode node4 = new BstNode(20, 4);
        BstNode node5 = new BstNode(40, 5);
        BstNode node6 = new BstNode(60, 6);
        BstNode node7 = new BstNode(80, 7);

        BinarySearchTree bst = new BinarySearchTree(node1);
        node1.left = node2;
        node1.right = node3;
        node2.left = node4;
        node2.right = node5;
        node3.left = node6;
        node3.right = node7;

        System.out.println("递归查找：");
        System.out.println(bst.find(60, node1));
        System.out.println("非递归查找：");
        System.out.println(bst.iterFind(80, node1));
        System.out.println("查找最小值：");
        System.out.println(bst.findMin(node1));
        System.out.println("查找最大值：");
        System.out.println(bst.findMax(node1));

        BstNode node8 = new BstNode(10, 8);
        System.out.println(bst.insert(35, node1));
        System.out.println(bst.find(35, node1));

        System.out.println("层序遍历二叉搜索树：");
        bst.inorderRec(node1);
    }

}

class BstNode {
    public int key;
    public BstNode left;
    public BstNode right;
    public int index;

    public BstNode(int value, int index) {
        this.key = value;
        this.index = index;
        left = null;
        right = null;
    }

    @Override
    public String toString() {
        return "node index:" + index + "==>node value:" + key;
    }

}
