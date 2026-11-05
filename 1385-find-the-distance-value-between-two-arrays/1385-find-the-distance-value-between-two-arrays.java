class Solution {
    public int findTheDistanceValue(int[] arr1, int[] arr2, int d) {
        int cnt=0;
        for(int x : arr1){
            int n=0;
            boolean use=true;
            for(int y : arr2){
                if(Math.abs(x-y)>d) use=true;
                else{
                    use=false;
                    break;
                    } 
            }
            if(use) cnt++;
        }
        return cnt;        
    }
}