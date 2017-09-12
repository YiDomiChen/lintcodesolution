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

public class PreorderTraversal {
    
    
    // Version 1: Traverse
    public ArrayList<Integer> preorderTraversal_Traverse(TreeNode root) {
        ArrayList<Integer> result = new ArrayList<>();
        traverse(root, result);
        
        return result;
    }
    
    public void traverse(TreeNode root, ArrayList<Integer> result) {
        if(root == null) {
            return;
        }
        
        result.add(root.val);
        traverse(root.left, result);
        traverse(root.right, result);
    }
    
    
    public ArrayList<Integer> preorderTraversal_DC(TreeNode root) {
        ArrayList<Integer> result = new ArrayList<Integer>();
        // null or leaf
        if(root == null) {
            return result;
        }
        
        // Divide
        ArrayList<Integer> left = preorderTraversal_DC(root.left);
        ArrayList<Integer> right = preorderTraversal_DC(root.right);
        
        // Conquer
        result.add(root.val);
        result.addAll(left);
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
        
        PreorderTraversal pt = new PreorderTraversal();
        
        ArrayList<Integer> res = pt.preorderTraversal_Traverse(root);
        for(int num : res) {
            System.out.println(String.valueOf(num) + " ");
        }
        
    }

}
