class Solution {
    public static void reverse(ArrayList<ListNode> list, int left, int right) {
        left = left - 1;
        right = right - 1;

        while (left < right) {
            ListNode temp = list.get(left);

            list.set(left, list.get(right));
            list.set(right, temp);

            left++;
            right--;
        }
    }
    public ListNode reverseBetween(ListNode head, int left, int right) {
        if (head == null || head.next == null || left == right)
            return head;

        ListNode dummy = new ListNode(0);

        ArrayList<ListNode> arr = new ArrayList<>();

        ListNode temp = head;

        while (temp != null) {
            arr.add(temp);
            temp = temp.next;
        }

        reverse(arr, left, right);

        temp = dummy;

        for (ListNode n : arr) {
            temp.next = n;
            temp = temp.next;
        }

        temp.next = null;

        return dummy.next;
    }
}