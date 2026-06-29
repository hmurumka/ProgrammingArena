package practice.leetcode;

/**
 * 
 * Same Tree
 * Easy
 * Topics
 * premium lock icon
 * Companies
 * Given the roots of two binary trees p and q, write a function to check if
 * they are the same or not.
 * 
 * Two binary trees are considered the same if they are structurally identical,
 * and the nodes have the same value.
 * 
 * 
 * 
 * Example 1:
 * 
 * 
 * Input: p = [1,2,3], q = [1,2,3]
 * Output: true
 * Example 2:
 * 
 * 
 * Input: p = [1,2], q = [1,null,2]
 * Output: false
 * Example 3:
 * 
 * 
 * Input: p = [1,2,1], q = [1,1,2]
 * Output: false
 * 
 * 
 * Constraints:
 * 
 * The number of nodes in both trees is in the range [0, 100].
 * -104 <= Node.val <= 104
 * 
 * 
 * SameTree
 */
public class SameTree {

    public static void main(String[] args) {
        Solution s = new Solution();
        TreeNode t1 = new TreeNode(5);
        t1.left = new TreeNode(3);
        t1.right = new TreeNode(6);


        TreeNode t2 = new TreeNode(5);
        t2.left = new TreeNode(3);
        t2.right = new TreeNode(6);

        System.out.println(s.isSameTree(t1, t2));
    }





    private static class Solution {
        public boolean isSameTree(TreeNode p, TreeNode q) {
            if(p == null && q == null)
                return true;
            else if((p == null && q != null) || (p != null && q == null))
                return false;
            else{
                return isSameTree(p.left, q.left) && isSameTree(p.right, q.right);
            }
        }
    }

    private static class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode() {
        }

        TreeNode(int val) {
            this.val = val;
        }

        TreeNode(int val, TreeNode left, TreeNode right) {
            this.val = val;
            this.left = left;
            this.right = right;
        }
    }
}
