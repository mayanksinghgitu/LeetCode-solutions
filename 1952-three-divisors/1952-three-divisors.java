class Solution {
    public boolean isThree(int n) {
    if(n<4) return false;
    int i=1;
    int ans=1;
    while(i<=n/2){
        if(n%i==0) ans++;
        i++;
    }
    return ans==3;
        
    }
}