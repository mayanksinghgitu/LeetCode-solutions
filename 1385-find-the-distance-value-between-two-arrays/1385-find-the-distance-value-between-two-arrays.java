class Solution {
    public int findTheDistanceValue(int[] arr1, int[] arr2, int d) {
        int cnt=0;
        for(int x : arr1){
            int n=0;
            for(int y : arr2){
                if(Math.abs(x-y)>d) n++;
                else break;
            }
            if(n==arr2.length) cnt+=n;
        }
        return cnt/arr2.length;        
    }
}