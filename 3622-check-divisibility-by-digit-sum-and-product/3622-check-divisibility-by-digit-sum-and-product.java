class Solution {
    public int Product(ArrayList<Integer> arr){
        int prod=1;
        for(int x : arr){
            prod*=x;           
        }
        return prod;
    }
    public int Sum(ArrayList<Integer> arr){
        int sum=0;
        for(int x : arr){
           sum+=x;
        }
        return sum;
    }
    public boolean checkDivisibility(int n) {
    if(n<10) return false;
    ArrayList<Integer> arr = new ArrayList<>();
    int m=n;
    while (m > 0) {
        arr.add(0, m % 10);
        m /= 10;
    }
    if((Sum(arr)+Product(arr))%n==0 || n%(Sum(arr)+Product(arr))==0) return true;
    return false;
    }
}