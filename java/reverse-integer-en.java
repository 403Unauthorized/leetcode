package java;

class ReverseIntegerEn {
    public int reverse(int x) {
        return x < 0 ? reverse(-x, true) : reverse(x, false);
    }
    private int reverse(int x, boolean negative) {
        int ans = 0;
        while (x != 0) {
            int tail = x % 10;
            int nextRes = ans * 10 + tail;
            if ((nextRes - tail) / 10 != ans) return 0;
            ans = nextRes;
            x /= 10;
        }
        return negative ? -ans : ans;
    }
}
