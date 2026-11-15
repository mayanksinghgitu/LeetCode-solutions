/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode() {}
 *     TreeNode(int val) { this.val = val; }
 *     TreeNode(int val, TreeNode left, TreeNode right) {
 *         this.val = val;
 *         this.left = left;
 *         this.right = right;
 *     }
 * }
 */
class Solution {
    public void Store(TreeNode root,PriorityQueue<Integer> pq){
        if(root==null) return;
        pq.offer(root.val);
        Store(root.left,pq);
        Store(root.right,pq);
    }
    public int kthSmallest(TreeNode root, int k) {
        PriorityQueue<Integer> pq = new PriorityQueue<>();
        Store(root,pq);
        for(int i=1;i<k;i++){
            pq.poll();
        }
        return pq.poll();        
    }
}