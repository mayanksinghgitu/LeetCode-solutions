class Solution {
    public String reverseVowels(String s) {
        String str="aeiouAEIOU";
        Set<Character> set=new HashSet<>();
        for(int i=0;i<str.length();i++) set.add(str.charAt(i));
        int st=0;
        int csI=0;
        int ceI=0;
        int end=s.length()-1;
        boolean stF=false;
        boolean enF=false;
        char[] arr = s.toCharArray();
        while(st<end){
            if(set.contains(arr[end])){
                ceI=end;
                enF=true;
            }
            else end--;
            if(set.contains(arr[st])){
                csI=st;
                stF=true;
            }
            else st++;
            if(enF && stF){
                char temp = arr[csI];
                arr[csI] = arr[ceI];
                arr[ceI] = temp;
                enF=false;
                stF=false;
                end--;
                st++;
            }

        }
        return new String(arr);
    }
}