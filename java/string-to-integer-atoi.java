package java;

class StringToIntegerAtoi {
    public int myAtoi(String s) {
        int len = s.length();
        if (len == 0) return 0;
        char[] chars = s.toCharArray();
        int index = 0;
        while (index < len && chars[index] == ' ') {
            index++;
        }
        // 字符串中只包含空格的情况
        if (index == len) return 0;
        boolean negative = false;
        if (chars[index] == '+') {
            index++;
        } else if (chars[index] == '-') {
            negative = true;
            index++;
        }
        int ans = 0, last = 0;
        while (index < len) {
            char current = chars[index];
            if (current > '9' || current < '0') break;
            int n = current - '0';
            last = ans;
            ans = ans * 10 + n;
            if (last != ans / 10) {
                // 说明溢出
                return negative ? Integer.MIN_VALUE : Integer.MAX_VALUE;
            }
            index++;
        }
        return negative ? -ans : ans;
    }
}
