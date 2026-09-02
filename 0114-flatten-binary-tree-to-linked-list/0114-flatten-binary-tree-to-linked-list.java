class Solution {
    public void flatten(TreeNode root) {
        if(root==null) return;
        TreeNode curr=root;
        while(curr!=null){
            if(curr.left!=null){
                TreeNode prd=curr.left;
                while(prd.right!=null){
                    prd=prd.right;
                }
                    prd.right=curr.right;
                    curr.right=curr.left;
                    curr.left=null;
            }
            curr=curr.right;
        }
    }
}