package java;

class ReverseInteger {
    public int reverse(int x) {
        return x < 0 ? reverse(-x, true) : reverse(x, false);
    }
    private int reverse(int x, boolean negative) {
        int ans = 0;
        while (x != 0) {
            int next = ans * 10 + x % 10;
            if ((next - x % 10) / 10 != ans) {
                return 0;
            }
            ans = next;
            x /= 10;
        }
        return negative ? -ans : ans;
    }
}
