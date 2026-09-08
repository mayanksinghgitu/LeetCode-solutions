
class Solution {
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        ListNode tem1=l1;
        ListNode tem2=l2;
        ListNode ans=new ListNode(5);
        ListNode temAn=ans;
        int carry=0;
        int an=0;
        while(tem1!=null && tem2!=null){
            an=tem1.val+tem2.val+carry;
            if((an)>=10){
                an=an%10;
                carry=1;
            }
            else carry=0;
            ListNode temp=new ListNode(an);
            temAn.next=temp;
            temAn=temAn.next;
            tem1=tem1.next;
            tem2=tem2.next;
        }
        if(tem1==null){
            while(tem2!=null){
                an=tem2.val+carry;
                if((an)>=10){
                    an=an%10;
                    carry=1;
                }
                else carry=0;
                ListNode tempo=new ListNode(an);
                temAn.next=tempo;
                temAn=temAn.next;
                tem2=tem2.next;
            }
        } 
        else {
            while(tem1!=null){
                an=tem1.val+carry;
                if((an)>=10){
                    an=an%10;
                    carry=1;
                }
                else carry=0;
                ListNode tempo=new ListNode(an);
                temAn.next=tempo;
                temAn=temAn.next;
                tem1=tem1.next;
            }
        }
        if (carry != 0) {
            temAn.next = new ListNode(carry);
        }
        return ans.next;
        
    }
}