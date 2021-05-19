package binarytree;

import java.util.ArrayList;
import java.util.List;

public class BalanceBinaryTree<T extends Comparable<T>> {
    private BBNode<T> root;



    public List<T> preOrder(){
        List<T> datas = new ArrayList<>();
        this.preOrder(root,datas);
        return datas;
    }
    private void preOrder(BBNode<T> node, List<T> datas){
        if(node == null){
            return;
        }
        datas.add(node.data);
        this.preOrder(node.left,datas);
        this.preOrder(node.right,datas);
    }
    public List<T> inOrder(){
        List<T> datas = new ArrayList<>();
        this.inOrder(root,datas);
        return datas;
    }
    private void inOrder(BBNode<T> node, List<T> datas){
        if(node == null){
            return;
        }
        this.inOrder(node.left,datas);
        datas.add(node.data);
        this.inOrder(node.right,datas);
    }
    public List<T> postOrder(){
        List<T> datas = new ArrayList<>();
        this.postOrder(root,datas);
        return datas;
    }
    private void postOrder(BBNode<T> node, List<T> datas){
        if(node == null){
            return;
        }
        this.postOrder(node.left,datas);
        this.postOrder(node.right,datas);
        datas.add(node.data);
    }


    public int getHeight(BBNode<T> node){
        if(node == null){
            return 0;
        }
        return node.height;
    }
    public boolean isBalance(BBNode<T> node){
        int balanceFactor = this.getHeight(node.left) - this.getHeight(node.right);
        if(balanceFactor >= -1 && balanceFactor <= 1){
            return true;
        }
        return false;
    }
    public int getBalanceFactor(BBNode<T> node){
        if(node == null){
            return 0;
        }
        int leftHeight;
        int rightHeight;
        if(node.left == null){
            leftHeight = 0;
        }else{
            leftHeight = node.left.height;
        }
        if(node.right == null){
            rightHeight = 0;
        }else{
            rightHeight = node.right.height;
        }
        return leftHeight - rightHeight;
    }
    private void insert(BalanceBinaryTree<T> tree,BBNode<T> insertedNode){

        if(tree.root == null){
            tree.root = insertedNode;
            return;
        }
        int cmp ;
        BBNode<T> node = tree.root;
        BBNode<T> preNode = null;
        while(node != null){
            preNode = node;
            node.height ++;
            cmp = insertedNode.data.compareTo(node.data);
            if(cmp < 0){
                node = node.left;
            }else{
                node = node.right;
            }
        }
        cmp = insertedNode.data.compareTo(preNode.data);
        if(cmp < 0){
            preNode.left = insertedNode;
        }else{
            preNode.right = insertedNode;
        }
        int balanceFactor = this.getBalanceFactor(root);







    }
    public void insert(T data){
        BBNode<T> node = new BBNode<>(data,null,null);
        this.insert(this,node);
    }
    public class BBNode<T extends Comparable<T>>{
        public T data;
        public int height;
        public BBNode<T> left;
        public BBNode<T> right;
        public BBNode(T data,BBNode<T> leftNode,BBNode<T> rightNode){
            this.data = data;
            this.left = leftNode;
            this.right = rightNode;
            this.height = 1;
        }
    }
}
