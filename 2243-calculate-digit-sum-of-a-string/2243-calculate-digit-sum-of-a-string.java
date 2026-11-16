
class Solution {
    public ArrayList<Character> StrTOlist(String s) {
        ArrayList<Character> list = new ArrayList<>();

        for (int i = 0; i < s.length(); i++) {
            list.add(s.charAt(i));
        }

        return list;
    }

    public String shorten(String s, int k) {
        ArrayList<Character> list = StrTOlist(s);

        while (list.size() > k) {
            list = helper(list, k);
        }

        StringBuilder sb = new StringBuilder();

        for (char ch : list) {
            sb.append(ch);
        }

        return sb.toString();
    }

    public String digitSum(String s, int k) {
        return shorten(s, k);
    }

    public ArrayList<Character> helper(ArrayList<Character> list, int k) {
        StringBuilder ans = new StringBuilder();

        for (int i = 0; i < list.size(); i += k) {
            int sum = 0;

            for (int j = i; j < Math.min(i + k, list.size()); j++) {
                sum += list.get(j) - '0';
            }
            ans.append(sum);
        }
        return StrTOlist(ans.toString());
    }
}
