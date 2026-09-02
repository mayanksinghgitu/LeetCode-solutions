class Solution {
    public boolean judgeSquareSum(int c) {
        int a=(int)Math.sqrt(c);
        int i=0;
        int [] arr =new int[a+1];
        while(i<=a){
            arr[i]=i;
            i++;
        }
        HashSet <Integer> set=new HashSet<>();
        for(int n : arr){
            set.add(n*n);
        }
        for(int n : arr){
            if(set.contains(c-(n*n))) return true;
        }
        return false;
        
    }
}