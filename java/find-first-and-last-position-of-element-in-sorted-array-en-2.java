package java;

class FindFirstAndLastPositionOfElementInSortedArrayEn2 {
    int start = -1;
    int end = -1;
    public int[] searchRange(int[] nums, int target) {
        int len = nums.length;
        if (len == 1) {
            if (nums[0] == target) {
                return new int[]{0,0};
            } else {
                return new int[] {start, end};
            }
        }
        int left = 0, right = len - 1;
        while (left <= right) {
            int mid = (left + right) / 2;
            int num = nums[mid];
            if (num == target) {
                expand(nums, mid, target);
                break;
            } else if (num > target) {
                right = mid - 1;
            } else {
                left = mid + 1;
            }
        }
        return new int[] {start, end};
    }
    
    private void expand(int[] nums, int i, int target) {
        start = i;
        end = i;
        int left = i - 1, right = i + 1;
        while (left <= right && left >= 0 && right < nums.length) {
            if (nums[left] == target) {
                start = left;
            }
            if (nums[right] == target) {
                end = right;
            }
            left--;
            right++;
        }
        while (left >= 0) {
            if (nums[left] == target) {
                start = left;
            }
            left--;
        }
        while (right < nums.length) {
            if (nums[right] == target) {
                end = right;
            }
            right++;
        }
    }
}
