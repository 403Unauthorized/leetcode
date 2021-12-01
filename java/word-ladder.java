// 127. 单词接龙 - Hard
// https://leetcode-cn.com/problems/word-ladder/
package java;

import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.Set;

class WordLadder {
    /**
     * BFS题，可以使用双向BFS优化时间
     */
    public int ladderLength(String beginWord, String endWord, List<String> wordList) {
        Set<String> visited = new HashSet<>();
        Queue<String> q = new LinkedList<>();
        q.offer(beginWord);
        int count = 0;
        while (!q.isEmpty()) {
            int size = q.size();
            for (int i = 0; i < size; i++) {
                String str = q.poll();
                if (str.equals(endWord)) return count + 1;
                for (String word : wordList) {
                    if (visited.contains(word)) continue;
                    if (convertable(str, word)) {
                        q.offer(word);
                        visited.add(word);
                    }
                }
            }
            count++;
        }
        return 0;
    }

    private boolean convertable(String word1, String word2) {
        int diff = 0;
        for (int i = 0; i < word1.length(); i++) {
            if (diff > 1) {
                return false;
            }
            if (word1.charAt(i) != word2.charAt(i)) {
                diff++;
            }
        }
        return diff == 1;
    }
}
