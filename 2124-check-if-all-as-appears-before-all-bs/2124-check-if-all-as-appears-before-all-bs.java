class Solution {
    public boolean checkString(String s) {
        boolean Ahas=false;
        boolean Bhas=false;
        for(char c : s.toCharArray()){
            if(c=='a' && !Bhas) Ahas=true;
            else if(c=='b') {
                Bhas=true;
                Ahas=false;
            }
            else return false;
        }
        if(Bhas && !Ahas) return Bhas;
        return true;
    }
}