class Solution {

    public static int[] getElements(int[] nums1, int[] nums2,
                                    ArrayList<Integer> list) {
        int[] ans = new int[nums1.length];

        for (int i = 0; i < nums1.length; i++) {
            ans[i] = -1;

            for (int j = 0; j < nums2.length; j++) {
                if (nums1[i] == nums2[j]) {
                    ans[i] = list.get(j);
                    break;
                }
            }
        }

        return ans;
    }


    public int[] nextGreaterElement(int[] nums1, int[] nums2) {
        int n = nums2.length;
        ArrayList<Integer> list=new ArrayList<>();
        Stack<Integer> st=new Stack<>();
        for(int i=0;i<n;i++) list.add(-1);
        for(int i=n-1;i>=0;i--){
            while(!st.isEmpty() && st.peek()<=nums2[i]){
                st.pop();
            }
            if(!st.isEmpty()) list.set(i,st.peek());
            st.push(nums2[i]);
        }
        return getElements(nums1,nums2,list);
    }
}