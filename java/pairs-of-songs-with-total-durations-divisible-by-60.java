package java;

class PairsOfSongsWithTotalDUrationsDivisibleBy60En {
    // 暴力双重循环 TLE
    // public int numPairsDivisibleBy60(int[] time) {
    //     int ans = 0;
    //     int len = time.length;
    //     if (len < 2) return 0;
    //     for (int i = 0; i < len; i++) {
    //         for (int j = i + 1; j < len; j++) {
    //             int duration = time[i] + time[j];
    //             if (duration % 60 == 0) ans++;
    //         }
    //     }
    //     return ans;
    // }
    public int numPairsDivisibleBy60(int[] time) {
        int[] c = new int[60];
        int ans = 0;
        for (int t : time) {
            ans += c[(600 - t) % 60];
            c [t % 60] += 1;
        }
        return ans;
    }
}
