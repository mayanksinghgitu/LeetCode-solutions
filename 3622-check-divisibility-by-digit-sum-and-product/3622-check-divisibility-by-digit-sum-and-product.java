class Solution {
    public int Total(ArrayList<Integer> arr){
        int prod=1;
        int sum=0;
        for(int x : arr){
            prod*=x;
            sum+=x;           
        }
        return prod+sum;
    }
    public boolean checkDivisibility(int n) {
    if(n<10) return false;
    ArrayList<Integer> arr = new ArrayList<>();
    int m=n;
    while (m > 0) {
        arr.add(0, m % 10);
        m /= 10;
    }
    if(Total(arr)%n==0 || n%(Total(arr))==0) return true;
    return false;
    }
}