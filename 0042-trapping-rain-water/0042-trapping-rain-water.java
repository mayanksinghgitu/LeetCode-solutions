class Solution {
    public int trap(int[] height) {
        int n=height.length;
        int left[]=new int[n];
        int rigth[]=new int[n];
        int max1=height[0];
        int max2=height[n-1];
        for(int i=0;i<n;i++){
            if(height[i]>max1){
                max1=height[i];
            }
            left[i] = max1;
        }
        for (int i=n-1;i>=0;i--) {
             if (max2 <= height[i]) {
                  max2 = height[i];
            }
            rigth[i] = max2;
        }
        int water=0;
        for (int i = 0; i < n; i++) {
        water += Math.min(left[i],rigth[i]) -  height[i];
        }
        
        return water;
    }
        
}
