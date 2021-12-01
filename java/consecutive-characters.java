package java;

class ConsecutiveCharacters {
    public int maxPower(String s) {
        int ans = 0;
        int max = 0;
        char[] chs = s.toCharArray();
        for (int i = 0; i < chs.length; i++) {
            if (i == 0) {
                max++;
            } else {
                if (chs[i] == chs[i - 1]) {
                    max++;
                } else {
                    max = 1;
                }
            }
            ans = Math.max(ans, max);
        }
        return ans;
    }
}
