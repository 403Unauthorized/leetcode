// 2021/12/31 - 507. 完美数 - Easy
// https://leetcode-cn.com/problems/perfect-number/
package java;

class PerfectNumber {
    public boolean checkPerfectNumber(int num) {
        if (num == 1) return false;
        int sum = 1, i = 2;
        double sqrt = Math.sqrt(num);
        while (i < sqrt) {
            if (num % i == 0) {
                sum += i;
                sum += num / i;
            }
            i++;
        }
        if (i * i == num) {
            sum += i;
        }
        return sum == num;
    }
}
