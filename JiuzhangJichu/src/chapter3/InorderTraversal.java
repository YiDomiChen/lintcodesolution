/**
 * 
 * @LintCode:
 * @Description: TODO
 * @Difficulty: 
 * @Category: 
 * @Author: Yi Chen
 * @CreatedTime: Aug 3, 2017
 * @LastEditTime: Aug 3, 2017
 *
 */
package chapter3;

import java.util.*;

public class InorderTraversal {
    
    // Version 1: Traverse
    public ArrayList<Integer> inorderTraversal_Traverse(TreeNode root) {
        ArrayList<Integer> result = new ArrayList<>();
        traverse(root, result);
        
        return result;
    }
    
    public void traverse(TreeNode root, ArrayList<Integer> result) {
        if (root == null) {
            return;
        }
        
        traverse(root.left, result);
        result.add(root.val);
        traverse(root.right, result);
    }
    
    // Version 2: Divide and Conquer
    public ArrayList<Integer> inorderTraversal_DC(TreeNode root) {
        ArrayList<Integer> result = new ArrayList<>();
        if (root == null) {
            return result;
        }
        
        ArrayList<Integer> left = inorderTraversal_DC(root.left);
        ArrayList<Integer> right = inorderTraversal_DC(root.right);
        
        result.addAll(left);
        result.add(root.val);
        result.addAll(right);
        
        return result;
    }
    
    
    /**
     * @param args
     */
    public static void main(String[] args) {
        // TODO Auto-generated method stub
        TreeNode root = new TreeNode(1);
        root.left = new TreeNode(2);
        root.right = new TreeNode(3);
        root.left.left = new TreeNode(4);
        root.left.right = new TreeNode(5);
        
        InorderTraversal pt = new InorderTraversal();
        
        ArrayList<Integer> res = pt.inorderTraversal_DC(root);
        for(int num : res) {
            System.out.println(String.valueOf(num) + " ");
        }
    }

}
