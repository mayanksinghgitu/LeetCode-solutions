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