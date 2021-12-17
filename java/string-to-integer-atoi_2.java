package java;

class StringToInteger_2 {

    // 这个解法比较low，相当于暴力解法
    // 时间复杂度 O(n)
    public int myAtoi(String s) {
        long ans = 0L;
        int len = s.length();
        int firstNum = -1;
        for (int i = 0; i < len; i++) {
            if (isNumber(s.charAt(i))) {
                firstNum = i;
                break;
            }
        }
        if (firstNum < 0) return 0;
        int i = 0;
        boolean negative = false;
        boolean beyondLimit = false;
        while (i < len) {
            char c = s.charAt(i);
            if (i > firstNum && !isNumber(c)) break;
            if (isNumber(c)) {
                int n = Integer.parseInt(String.valueOf(c));
                if (n == 0) {
                    ans *= 10;
                } else {
                    ans = ans * 10 + n;
                }
                if (ans > Integer.MAX_VALUE) {
                    ans = Integer.MAX_VALUE;
                    beyondLimit = true;
                    break;
                }
            } else if (c == ' ') {
                i++;
                continue;
            } else {
                if (i == firstNum - 1) {
                    if (c == '-' || c == '+') {
                        negative = c == '-';
                    } else {
                        break;
                    }
                    i++;
                    continue;
                }
                break;
            }
            i++;
        }
        if (negative) {
            ans = beyondLimit ? - ans - 1 : -ans;
        }
        return (int) ans;
    }

    private boolean isNumber(char c) {
        return c >= '0' && c <= '9';
    }
}
