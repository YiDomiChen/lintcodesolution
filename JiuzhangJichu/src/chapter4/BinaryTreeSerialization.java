/**
 * 
 * @LintCode: 7. Binary Tree Serialization
 * @Description: Design an algorithm and write code to serialize and deserialize a binary 
 * tree. Writing the tree to a file is called 'serialization' and reading back from the 
 * file to reconstruct the exact same binary tree is 'deserialization'.
 * @Difficulty: Medium
 * @Category: Binary Tree
 * @Author: Yi Chen
 * @CreatedTime: Aug 15, 2017
 * @LastEditTime: Aug 15, 2017
 *
 */
package chapter4;

import java.util.*;

public class BinaryTreeSerialization {
    
    /**
     * This method will be invoked first, you should design your own algorithm 
     * to serialize a binary tree which denote by a root node to a string which
     * can be easily deserialized by your own "deserialize" method later.
     */
    public String serialize(TreeNode root) {
        // write your code here
        if (root == null) {
            return "{}";
        }
        ArrayList<TreeNode> queue = new ArrayList<TreeNode> ();
        queue.add(root);
        
        for (int i = 0; i < queue.size(); i++) {
            TreeNode node = queue.get(i);
            if (node == null) {
                continue;
            }
            queue.add(node.left);
            queue.add(node.right);
        }
        
        while (queue.get(queue.size() - 1) == null) {
            queue.remove(queue.size() - 1);
        }
        
        StringBuilder sb = new StringBuilder();
        sb.append("{");
        sb.append(queue.get(0).val);
        for (int i = 1; i < queue.size(); i++) {
            TreeNode n = queue.get(i);
            sb.append(n == null ? ",#" : "," + n.val);
        }
        sb.append("}");
        
        return sb.toString();
    }
    
    /**
     * This method will be invoked second, the argument data is what exactly
     * you serialized at method "serialize", that means the data is not given by
     * system, it's given by your own serialize method. So the format of data is
     * designed by yourself, and deserialize it here as you serialize it in 
     * "serialize" method.
     */
    public TreeNode deserialize(String data) {
        // write your code here
        if(data == "{}") {
            return null;
        }
        
        String[] vals = data.substring(1, data.length() - 1).split(",");
        ArrayList<TreeNode> queue = new ArrayList<TreeNode>();
        
        TreeNode root = new TreeNode(Integer.parseInt((vals[0])));
        queue.add(root);
        int index = 0;
        boolean isLeftChild = true;
        for (int i = 1; i < vals.length; i++) {
            if (!vals[i].equals("#")) {
                TreeNode node = new TreeNode(Integer.parseInt(vals[i]));
                if (isLeftChild) {
                    queue.get(index).left = node;
                } else {
                    queue.get(index).right = node;
                }
                queue.add(node);
            }
            if (!isLeftChild) {
                index++;
            }
            isLeftChild = !isLeftChild;
        }
        
        return root;
    }
    
    
    /**
     * @param args
     */
    public static void main(String[] args) {
        // TODO Auto-generated method stub
        TreeNode root = new TreeNode(1);
        TreeNode node1 = new TreeNode(2);
        root.left = node1;
        TreeNode node2 = new TreeNode(3);
        root.right = node2;
        TreeNode node3 = new TreeNode(4);
        node1.right = node3;
        
        BinaryTreeSerialization bts = new BinaryTreeSerialization();
        TreeNode resultRoot = bts.deserialize(bts.serialize(root));
        
        
    }

}
