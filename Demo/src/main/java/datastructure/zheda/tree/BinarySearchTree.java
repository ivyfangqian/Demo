package datastructure.zheda.tree;

public class BinarySearchTree<Item> {
    private BinaryNode root;

    public BinarySearchTree() {
    }

    public BinarySearchTree(BinaryNode node) {
        root = node;
    }

    public BinaryNode find(Item element,BinaryNode node) {
        if (node == null) {
            return null;
        }
        if (node.getData()>element) {

        }
    }

}
