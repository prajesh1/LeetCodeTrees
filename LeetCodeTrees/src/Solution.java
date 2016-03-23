import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;


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
    /*
     * 102. Binary Tree Level Order Traversal
     */
    List<List<Integer>> ll = new ArrayList<List<Integer>>();
    public List<List<Integer>> levelOrder(TreeNode root) {
        if(root==null) return ll;
        Queue<List<TreeNode>> q = new LinkedList<List<TreeNode>>();        
        
         List<TreeNode> ln = new ArrayList<TreeNode>();
       ln.add(root);
        q.add(ln);
        while(!q.isEmpty())
        {
        	List<TreeNode> levelNodes = q.remove();
        	List<Integer> l = new ArrayList<Integer>();
        	 ln = new ArrayList<TreeNode>();
        	for(TreeNode n: levelNodes)
        	{
        	    l.add(n.val);
                ln.add(n);
        	}
            q.add(ln);
            if(!l.isEmpty()) ll.add(l);
        }
        return ll;
    }
}