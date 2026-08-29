
class Solution {
    public static void Pre_Order(TreeNode x,ArrayList<TreeNode> list){
        if(x==null) return;
        list.add(x);
        Pre_Order(x.left,list);
        Pre_Order(x.right,list);
    }
    public void flatten(TreeNode root) {
        if(root==null) return;
        ArrayList<TreeNode> list=new ArrayList<>();
        Pre_Order(root,list);
        list.get(list.size()-1).left=null;
        for(int i=0;i<list.size()-1;i++){
            list.get(i).right=list.get(i+1);
            list.get(i).left=null;
        }
        list.get(list.size()-1).right=null;        
    }
}