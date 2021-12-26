package java;

import java.util.ArrayList;
import java.util.List;

class OcurrencesAfterBigram {
    // 简单字符串操作
    public String[] findOcurrences(String text, String first, String second) {
        String[] split = text.split(" ");
        int len = split.length;
        List<String> list = new ArrayList<>();
        for (int i = 0; i + 2 < len; i++) {
            if (split[i].equals(first) && split[i + 1].equals(second)) list.add(split[i + 2]);
        }
        len = list.size();
        String[] ans = new String[len];
        for (int i = 0; i < len; i++) {
            ans[i] = list.get(i);
        }
        return ans;
    }
}