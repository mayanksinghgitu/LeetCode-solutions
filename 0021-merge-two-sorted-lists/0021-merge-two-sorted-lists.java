class Solution {
    public ListNode mergeTwoLists(ListNode list1, ListNode list2) {
        if (list1 == null)
            return list2;
        if (list2 == null)
            return list1;
        ListNode dummy = new ListNode(5);
        ListNode temp1 = list1;
        ListNode temp2 = list2;
        ListNode crr=dummy;
        while(temp1!=null && temp2!=null){
            if(temp1.val<temp2.val){
                crr.next=temp1;
                crr=temp1;
                temp1=temp1.next;
            }
            else{
                crr.next=temp2;
                crr=temp2;
                temp2=temp2.next;
            }
        }
        if(temp1==null) crr.next=temp2;
        else crr.next=temp1;
        return dummy.next;
    }
}
