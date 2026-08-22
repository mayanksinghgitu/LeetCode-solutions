
class Solution {
    public void Helper(TreeNode root, ArrayList<Integer> arr) {
        if (root == null || root.left == null || root.right == null) {
            return;
        }
        arr.add(root.left.val);
        arr.add(root.right.val);
        Helper(root.left, arr);
        Helper(root.right, arr);

    }

    public int SecondMin(ArrayList<Integer> list) {
        if (list == null || list.size() < 2)
            return -1;
        Integer min = null;
        Integer secondMin = null;
        for (Integer x : list) {
            if (min == null || x < min) {
                secondMin = min;
                min = x;
            } else if (x > min && (secondMin == null || x < secondMin)) {
                secondMin = x;
            }
        }
        return secondMin == null ? -1 : secondMin;
    }

    public int findSecondMinimumValue(TreeNode root) {
        if (root == null)
            return 0;
        ArrayList<Integer> arr = new ArrayList<>();
        arr.add(root.val);
        Helper(root, arr);
        return SecondMin(arr);

    }
}