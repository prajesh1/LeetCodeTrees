
public class Solution {
	
	/* 110. Balanced Binary Tree: 
	 * A naive solution would have used two recurisions
	 * One for depth and one for checking balanced
	 * Avoided that by using dummy variable
	 */
    boolean Balanced = true;
    private int depth(TreeNode node)
    {
        if(node==null||this.Balanced==false) return 0;
        int leftD = depth(node.left), rightD = depth(node.right);
        if(Math.abs(leftD-rightD)>1){Balanced =false; return 0;}
        else
        return 1+ Math.max(leftD, rightD);
    }
    public boolean isBalanced(TreeNode root) {
        int dummy = depth(root);
        return this.Balanced;
    }
}