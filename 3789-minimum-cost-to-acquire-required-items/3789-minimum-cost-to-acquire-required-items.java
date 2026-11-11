
class Solution {
    public long minimumCost(int cost1, int cost2, int costBoth, int need1, int need2) {
        long both = Math.min(need1, need2);
        long remaining1 = need1 - both;
        long remaining2 = need2 - both;

        long option1 = (long) need1 * cost1 + (long) need2 * cost2;

        long option2 = (long) Math.max(need1, need2) * costBoth;

        long option3 = both * costBoth
                     + remaining1 * cost1
                     + remaining2 * cost2;

        return Math.min(option1, Math.min(option2, option3));
    }
}
