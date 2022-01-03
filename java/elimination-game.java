package java;

class EliminationGame {
    /**
     * 数学思想：约瑟夫环
     */
    public int lastRemaining(int n) {
        return n == 1 ? 1 : 2 * (n / 2 + 1 - lastRemaining(n / 2));
    }
}