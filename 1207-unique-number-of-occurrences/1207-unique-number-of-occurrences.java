class Solution {
    public boolean uniqueOccurrences(int[] arr) {
        HashSet<Integer> set=new HashSet<>();
        Map<Integer,Integer> map=new HashMap<>();
        for(int n : arr){
           map.put(n,map.getOrDefault(n,0)+1);
        }
        for(Map.Entry<Integer,Integer> e : map.entrySet()){ 
            set.add(e.getValue());
        }
        if(map.entrySet().size()!=set.size()) return false;
        return true;
    }
}