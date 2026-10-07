class Solution {
    public ListNode mergeInBetween(ListNode list1, int a, int b, ListNode list2) {

        ListNode temp = list1;
        for (int i = 0; i < a - 1; i++) {
            temp = temp.next;
        }

        ListNode temp2 = list1;
        for (int i = 0; i <= b; i++) {
            temp2 = temp2.next;
        }
        temp.next = list2;
        ListNode temp3 = list2;
        while (temp3.next != null) {
            temp3 = temp3.next;
        }
        temp3.next = temp2;

        return list1;
    }
}