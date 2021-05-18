package binarytree;

import java.util.ArrayList;
import java.util.List;

public class BinarySearchTree<T extends Comparable<T>> {
    private BSNode<T> root;


    public List<T> preOrder(){
        List<T> datas = new ArrayList<>();
        this.preOrder(root,datas);
        return datas;
    }
    private void preOrder(BSNode<T> node, List<T> datas){
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
    private void inOrder(BSNode<T> node, List<T> datas){
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
    private void postOrder(BSNode<T> node, List<T> datas){
        if(node == null){
            return;
        }
        this.postOrder(node.left,datas);
        this.postOrder(node.right,datas);
        datas.add(node.data);
    }
    private BSNode<T>  search(BSNode<T> node,T data){
        if(node == null){
            return null;
        }
        BSNode<T> result;
        int cmp = data.compareTo(node.data);
        if(cmp == 0){
            result = node;
        }
        else if(cmp > 0){
            result = this.search(node.right,data);
        }
        else{
            result = this.search(node.left,data);
        }
        return result;

    }
    public BSNode<T> search(T data){
        return this.search(this.root,data);
    }
    private BSNode<T> iterativeSearch(BSNode<T> node,T data){
        while (node != null){
            int cmp = data.compareTo(node.data);
            if(cmp == 0){
                return node;
            }
            else if(cmp > 0){
                node = node.right;
            }
            else{
                node = node.left;
            }
        }
        return null;
    }
    public BSNode<T> iterativeSearch(T data){
        return this.iterativeSearch(this.root,data);
    }
    private void insert(BinarySearchTree<T> tree,BSNode<T> insertNode){
        if(tree.root == null){
            tree.root = insertNode;
            return;
        }
        int cmp;
        BSNode<T> node = tree.root;
        BSNode<T> preNode = null;
        while(node != null ){
            preNode = node;
            cmp = insertNode.data.compareTo(node.data);
            if(cmp < 0){
                node = node.left;
            }else{
                node = node.right;
            }
        }
        node = preNode;
        cmp = insertNode.data.compareTo(node.data);
        if(cmp < 0){
            node.left = insertNode;
        }else{
            node.right = insertNode;
        }

    }
    public void insert(T data){
        BSNode<T> insertNode = new BSNode<T>(data,null,null,null);
        this.insert(this,insertNode);
    }


    private void delete(BinarySearchTree<T> tree, BSNode<T> deletedNode){

         BSNode<T> parentNode =  this.parent(deletedNode);
         BSNode<T> remainedNode;

         if((deletedNode.left == null) || (deletedNode.right == null)){//删除结点度数为0和1的情况
             if(deletedNode.left !=null){
                 remainedNode = deletedNode.left;
             }else{
                 remainedNode = deletedNode.right;
             }


             if(parentNode.left == deletedNode){
                 parentNode.left = remainedNode;
             }else{
                 parentNode.right = remainedNode;
             }
         }
         else{
             BSNode<T> successorNode = successor(deletedNode,true);
             deletedNode.data = successorNode.data;
         }

    }
    public void remove(T data){
        BSNode<T> removedNode = search(data);
        delete(this,removedNode);
    }






    private void destroy(BSNode<T> node){
        if(node == null){
            return;
        }
        destroy(node.left);
        destroy(node.right);
        node = null;
    }
    public void clear(){
        this.destroy(this.root);
        this.root = null;
    }
    public BSNode<T> parent(BSNode<T> objectNode){
        if(this.root == null || objectNode == null){
            return null;
        }
        BSNode<T> node = this.root;
        BSNode<T> preNode = null;
        while(node != null){
            int cmp = objectNode.data.compareTo(node.data);
            if(cmp < 0){
                preNode = node;
                node = node.left;
            }else if(cmp > 0){
                preNode = node;
                node = node.right;
            }else{
                break;
            }
        }
        return preNode;
    }


    public BSNode<T> successor(BSNode<T> objectNode,boolean isCutted){
        if(objectNode == null || objectNode.right == null){
            return null;
        }
        BSNode<T> node = objectNode.right;
        BSNode<T> preNode = null;
        while(node.left != null){
            preNode = node;
            node = node.left;
        }
        if(isCutted){
           preNode.left = node.right;
        }
        return node;
    }

    public BSNode<T> predecessor(BSNode<T> objectNode,boolean isCutted){
        if(objectNode == null || objectNode.left == null){
            return null;
        }
        BSNode<T> node = objectNode.left;
        BSNode<T> preNode = null;
        while(node.right != null){
            preNode = node;
            node = node.right;
        }
        if(isCutted){
            preNode.right = node.left;
        }
        return node;
    }


    public class BSNode<T extends Comparable<T>>{
        public T data;
        public BSNode<T> left;
        public BSNode<T> right;
        public BSNode<T> parent;

        public BSNode(T data, BSNode<T> left, BSNode<T> right, BSNode<T> parent) {
            this.data = data;
            this.left = left;
            this.right = right;
            this.parent = parent;
        }
    }


}
