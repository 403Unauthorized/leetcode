package java;

class NthDigit {
    // 暴力解法：超出时间限制
    // public int findNthDigit(int n) {
    //     int idx = 1;
    //     for (int i = 1; i <= n; i++) {
    //         String v = String.valueOf(i);
    //         int len = v.length();
    //         for (int j = 0; j < len; j++) {
    //             if (idx == n) {
    //                 return Integer.parseInt(String.valueOf(v.charAt(j)));
    //             }
    //             idx++;
    //         }
    //     }
    //     return -1;
    // }
    /**
     * 简单来说就是定位第n位数字在哪一个数中。
     * 只有1位的数字：1 - 9，一共有9个数
     * 只有2位的数字：10 - 99，一共有180个数
     * ...
     * 有n位的数字：10^(n-1) ~ (10^n - 1)，一共有 (n * 9 * 10^(n - 1)) 个数字
     * 
     * 从以上规律我们可以找到规律，定位到第n位数字所在的数
     * 让 n 循环减去 9, 180, ..., 每减一次，将 digit++，base * 10
     * 为什么这样做，可以参考上面的推导过程，我们要找出目标数字的长度。
     * 
     * 直到 n <= base * 9 * digit 
     * 
     * 那么就可以确定第n位数字所在的数有 digit 位数，而digit位数的最小值是 10 ^ (digit - 1)
     * 所以第n位数字所在的数是 10 ^ (digit - 1) + (n / digit)
     * 而第n位数字在该数中的索引就是 (n % digit) - 1
     */
    public int findNthDigit(int n) {
        int digit = 1;
        while (n > digit * 9 * Math.pow(10, digit - 1)) {
            n -= digit * 9 * Math.pow(10, digit - 1);
            digit++;
        }
        // 这里把n减一的原因是：
        // 可能会出现 n / digit 整除的情况，
        // 那么 n % digit 就是 0
        // 整除的情况下，第n位数字一定是 (n - 1) / digit + 10^(digit - 1) 的最后一位
        // 减一之后，n % digit一定就是 digit - 1
        // 这样的话我们就能返回目标数字的最后一位了
        n--;
        return getKthDigit((int) Math.pow(10, digit - 1) + n / digit, n % digit);
    }

    private int getKthDigit(int i, int j) {
        return String.valueOf(i).charAt((int) j) - '0';
    }
}
