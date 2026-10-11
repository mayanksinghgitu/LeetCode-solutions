class Solution {
    public int SquareOf(int n) {
        return n * n;
    }

    public int sumOfSquares(int[] nums) {
        int n = nums.length;
        int sum = 0;
        int i = 1;
        for (int x : nums) {
            if (n % i == 0)
                sum += SquareOf(x);
            i++;
        }
        if (sum != 0)
            return sum;
        return -1;

    }
}