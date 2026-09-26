class Solution {
    public static String getValue(HashMap<String, String> map, String key) {
        if (map.containsKey(key)) {
            return map.get(key);
        }
        return "?";
    }
    public String evaluate(String s, List<List<String>> knowledge) {
        StringBuilder ans = new StringBuilder();
        HashMap<String, String> map = new HashMap<>();
        for (List<String> pair : knowledge) {
            map.put(pair.get(0), pair.get(1));
        }
        char[] arr = s.toCharArray();
        for (int i = 0; i < arr.length; i++) {
            if (arr[i] == '(') {
                String str = "";
                int j = i + 1;
                while (arr[j] != ')') {
                    str = str + arr[j];
                    j++;
                    i = j;
                }
                ans.append(getValue(map, str));
            } else {
                ans.append(arr[i]);
            }
        }
        return ans.toString();
    }
}