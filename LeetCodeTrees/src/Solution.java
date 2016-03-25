import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.Stack;


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
    /*
     * 235. Lowest Common Ancestor of a Binary Search Tree
     * Ancestor is the place where both dont follow same ways
     * Either beacuse they are opposite sides of node or 1 has value
     * of node.
     */
    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
      if(p==q||p.val==q.val) return p;
      int less = Math.min(p.val,q.val);
      int more = Math.max(p.val,q.val);
      TreeNode lca = root;
      TreeNode node = root;
      while(node!=null)
      {
          lca = node;
          if(less<node.val&&more<node.val)
          node = node.left;
          else if(less>node.val&&more>node.val)
          node = node.right;
          else break;
      }
      return lca;
  }
    
    public TreeNode lowestCommonAncestor2(TreeNode root, TreeNode p, TreeNode q) {
      while ((root.val - p.val) * (root.val - q.val) > 0)
          root = p.val < root.val ? root.left : root.right;
      return root;
}
       
    /*
     * 144. Binary Tree Preorder Traversal
     */
        public List<Integer> preorderTraversal(TreeNode root) {
          
          List<Integer> l = new ArrayList<Integer>();
          Stack<TreeNode> st = new Stack<TreeNode>();
          if(root!=null)st.push(root);
          while(!st.isEmpty())
          {
              TreeNode node = st.pop();
          
              while(node!=null)
              {
                   l.add(node.val);
                   if(node.right!=null)st.push(node.right);
                   node = node.left;
              }
          }
          return l;
      }
        
/*
 * 108. Convert Sorted Array to Binary Search Tree
 */
        private TreeNode createTree(int[] a, int l, int r)
        {
            if(l>r||l<0||r>=a.length)return null;
            int mid = l + (r-l)/2;
            TreeNode node = new TreeNode(a[mid]);
            node.left = createTree(a,l,mid-1);
            node.right = createTree(a,mid+1,r);
            return node;
        }
        public TreeNode sortedArrayToBST(int[] nums) {
            return createTree(nums,0,nums.length-1);
            
        }    
        
 /*
  * 105. Construct Binary Tree from Preorder and Inorder Traversal
  */
        private int i=0;
        private TreeNode built(int[] pr, int[] in,int st, int end )
        {
            if(i>=in.length||st>end) return null;
            TreeNode node = new TreeNode(pr[i]);
            int j=find(in,pr[i],st, end);
            if(j==-1) return node;
            i++;
            node.left = built(pr,in,st,j-1);
            node.right = built(pr,in,j+1,end);
            
            return node;
        }
        private int find(int[] in , int val,int st, int end)
        {
            for(int i=st;i<=end;i++)
            if(in[i] ==val)return i;
            return -1;
        }
        public TreeNode buildTree(int[] preorder, int[] inorder) {
            return built(preorder,inorder,0,preorder.length-1);
        }
}