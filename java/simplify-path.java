package java;

import java.util.Deque;
import java.util.LinkedList;

class SimplifyPath {
    public String simplifyPath(String path) {
        Deque<String> deq = new LinkedList<>();
        int n = path.length();
        for (int i = 1; i < n;) {
            char c = path.charAt(i);
            if (c == '/') {
                i++;
                continue;
            }
            int j = i;
            while (j < n && path.charAt(j) != '/') j++;
            String p = path.substring(i, j);
            if ("..".equals(p)) {
                if (!deq.isEmpty()) {
                    deq.pollLast();
                }
            } else if (".".equals(p)) {
            } else {
                deq.offer(p);
            }
            i = j + 1;
        }
        if (deq.isEmpty()) return "/";
        StringBuilder sb = new StringBuilder();
        while (!deq.isEmpty()) {
            sb.append("/" + deq.pollFirst());
        }
        return sb.toString();
    }
}