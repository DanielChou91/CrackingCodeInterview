package leetCode;
/**
 * Definition for binary tree
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
import java.util.List;
import java.util.ArrayList;
 
public class Solution3 {
	public class TreeNode {
		int val;
		TreeNode left;
		TreeNode right;

		TreeNode(int x) {
			val = x;
		}
	}
    public ArrayList<Integer> postorderTraversal(TreeNode root) {
        ArrayList<Integer>   los  =  new ArrayList<>();
        postHelper(root, los);
        return los;
    }
    private void postHelper(TreeNode n, List<Integer> los){
        // trivial case
        if ( n == null ){
            return;
        } 
        // non-trivial case
        postHelper(n.left, los);
        postHelper(n.right, los);
        los.add(n.val);
    }
}