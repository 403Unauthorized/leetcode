package java;

class FindFirstAndLastPositionOfElementInSortedArrayEn {
    public int[] searchRange(int[] nums, int target) {
        int len = nums.length;
        int start = -1, end = -1;
        for (int i = 0; i < len; i++) {
            int num = nums[i];
            if (num == target) {
                if (start == -1) start = i;
                end = i;
            }
        }
        return new int[] {start, end};
    }
}
