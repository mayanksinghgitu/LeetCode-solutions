class Solution {
    public ListNode sortList(ListNode head) {
        if(head==null) return null;
        if(head.next==null) return head;
        ArrayList<Integer> list=new ArrayList<>();
        ListNode temp=head;
        while(temp!=null){
            list.add(temp.val);
            temp=temp.next;
        }
        Collections.sort(list);
        ListNode newhead=new ListNode(list.get(0));
        int max=list.size();
        temp=newhead;
        int i=1;
        while(i<max){
            temp.next=new ListNode(list.get(i));
            i++;
            temp=temp.next;
        }
        temp.next=null;
        return newhead;

    }
}