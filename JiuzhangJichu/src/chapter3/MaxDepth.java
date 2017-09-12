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

public class MaxDepth {
    
    
    // Version 1: Traverse
    int depth = 0;
    public int maxDepth_traverse(TreeNode root) {
        
        helper(root, 1);
        return depth;
    }
    
    public void helper(TreeNode root, int curDepth) {
        if(root == null) {
            return;
        }
        
        if(curDepth > depth) {
            depth = curDepth;
        }
        
        helper(root.left, curDepth + 1);
        helper(root.right, curDepth);
    }
    
    public int maxDepth_dc(TreeNode root) {
        if(root == null) {
            return 0;
        }
        
        int leftDepth = maxDepth_dc(root.left);
        int rightDepth = maxDepth_dc(root.right);
        
        return Math.max(leftDepth, rightDepth) + 1;    // considering current node's level
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
        
        MaxDepth md = new MaxDepth();
        System.out.println(md.maxDepth_dc(root));
        
    }

}
