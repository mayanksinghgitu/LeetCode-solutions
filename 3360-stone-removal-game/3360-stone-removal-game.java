class Solution {
    public boolean canAliceWin(int n) {
        int aR = 10;
        boolean alice = true;

        while (n >= aR) {
            n -= aR;
            aR--;

            alice = !alice;
        }

        return !alice;
    }
}