package java;

class ContainerWithMostWater {
    public int maxArea(int[] height) {
        int len = height.length;
        if (len < 2) return 0;
        int left = 0, right = len - 1, ans = 0;
        while (left < right) {
            ans = height[left] < height[right] ?
                    Math.max(ans, (right - left) * Math.min(height[left++], height[right])) :
                    Math.max(ans, (right - left) * Math.min(height[left], height[right--]));
        }
        return ans;
    }
}
