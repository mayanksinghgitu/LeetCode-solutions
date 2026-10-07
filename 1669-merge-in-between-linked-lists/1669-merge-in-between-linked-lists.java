class Solution {
    public ListNode mergeInBetween(ListNode list1, int a, int b, ListNode list2) {

        ListNode temp = list1;
        int i = 0;

        while (i < a - 1) {
            temp = temp.next;
            i++;
        }

        ListNode temp2 = list1;
        int j = 0;

        while (j <= b) {
            temp2 = temp2.next;
            j++;
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