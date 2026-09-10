
class Solution {
    public int averageOfSubtree(TreeNode root) {
        if(root==null) return NodeVal(root);
        int ans=0;
        return Helper(root,ans);
                       
    }
    public int Helper(TreeNode root,int ans){
        if(root==null) return ans;
        if(root.val==Sum(root)/Count(root)){
            ans++;
        }
        ans=Helper(root.left,ans);
        ans=Helper(root.right,ans);
        return ans;
    }
    public int Count(TreeNode root){
        if(root==null) return 0;
        return 1+Count(root.left)+Count(root.right);
    }
    public int Sum(TreeNode root){
        if(root==null) return 0;
        return NodeVal(root)+Sum(root.left)+Sum(root.right);
    }
    public int NodeVal(TreeNode root){
        if(root==null) return 0;
        return root.val;
    }
}