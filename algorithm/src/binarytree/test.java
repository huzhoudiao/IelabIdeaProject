package binarytree;

public class test {
    public static void main(String[] args) {
        BalanceBinaryTree<Integer> btree = new BalanceBinaryTree<>();
        int[] datas = new int[]{4,3,12,43,9,10,21};
        for (int i = 0; i < datas.length; i++) {
            btree.insert(datas[i]);
        }
//        btree.remove(12);
//        BinarySearchTree<Integer>.BSNode<Integer> node = btree.search(4);
//        BinarySearchTree<Integer>.BSNode<Integer> successor = btree.successor(node, true);
//        System.out.println(successor.data);
        System.out.println(btree.preOrder());
    }
}
