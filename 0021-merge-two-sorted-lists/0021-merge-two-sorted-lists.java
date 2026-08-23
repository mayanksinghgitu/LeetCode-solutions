class Solution {
    public ListNode mergeTwoLists(ListNode list1, ListNode list2) {
        if (list1 == null)
            return list2;
        if (list2 == null)
            return list1;
        ListNode dummy = new ListNode();
        ArrayList<ListNode> list = new ArrayList<>();
        ListNode temp1 = list1;
        ListNode temp2 = list2;
        while (temp1 != null) {
            list.add(temp1);
            temp1 = temp1.next;
        }
        while (temp2 != null) {
            list.add(temp2);
            temp2 = temp2.next;
        }
        Collections.sort(list, (a, b) -> a.val - b.val);
        ListNode curr = dummy;

        for (int i = 0; i < list.size(); i++) {
            curr.next = list.get(i);
            curr = curr.next;
        }
        curr.next = null;
        return dummy.next;
    }
}
