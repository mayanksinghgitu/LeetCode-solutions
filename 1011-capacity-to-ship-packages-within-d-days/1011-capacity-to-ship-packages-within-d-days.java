class Solution {
    public int shipWithinDays(int[] weights, int days) {
        int cap=0;
        int max=Integer.MIN_VALUE;
        for(int n : weights){
            cap+=n;
            max=Math.max(n,max);
        } 
        int hi=cap,low=max,ans=cap;
        while(low<=hi){
            int mid=low+(hi-low)/2;
            if(Days(mid,weights)<=days){
                hi=mid-1;
                ans=mid;
            }
            else low=mid+1;
        }
        return ans;
    }
    public int Days(int capacity,int[] weights){
        int c=capacity;
        int day=0;
        for(int n : weights){
            if(c>=n) c=c-n;
            else{
                day++;
                c=capacity-n;
            }
        }
        day++;
        return day;
    }

}