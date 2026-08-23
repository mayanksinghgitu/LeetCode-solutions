public class Solution {
    public boolean hasCycle(ListNode head) {
        if(head==null || head.next==null) return false;
        HashSet<ListNode> set=new HashSet<>();
        ListNode temp=head;
        while(!set.contains(temp) && temp!=null){
            set.add(temp);
            temp=temp.next;
        }
        return set.contains(temp);
        
    }
}