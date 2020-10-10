package arrayAndString;

import org.junit.Test;

public class _02SearchInsert {

    /**
     * 给定一个排序数组和一个目标值，在数组中找到目标值，并返回其索引。如果目标值不存在于数组中，返回它将会被按顺序插入的位置。
     * 你可以假设数组中无重复元素。
     * <p>
     * 执行成功条件:
     * nums[index] == target 或者 nums[index - 1] < target < nums[index]
     * 或者 当index处于边界时 target < nums[0] 、 target > nums[nums.length-1]
     */
    public int searchInsert(int[] nums, int target) {
        if (nums == null) {
            throw new NullPointerException();
        }
        int index;
        if (target < nums[0]) {
            index = 0;
            return index;
        } else if (target > nums[nums.length - 1]) {
            index = nums.length;
            return index;
        }
        int max = nums.length - 1;
        int min = 0;
        index = (min + max) / 2;
        while (nums[index] != target) {
            if (index - 1 >= 0 && (nums[index - 1] < target && nums[index] > target)) {
                break;
            }
            if (nums[index] > target) {
                max = index - 1;
            } else if (nums[index] < target) {
                min = index + 1;
            }
            index = (min + max) / 2;
        }
        return index;
    }

    /**
     * leetcode官方题解
     *
     * @param nums
     * @param target
     * @return
     */
    public int searchInsert1(int[] nums, int target) {
        int n = nums.length;
        int left = 0, right = n - 1, ans = n;
        while (left <= right) {
            int mid = ((right - left) >> 1) + left;
            if (target <= nums[mid]) {
                ans = mid;
                right = mid - 1;
            } else {
                left = mid + 1;
            }
        }
        return ans;
    }

    @Test
    public void test() {
        int[] nums = new int[]{1, 3};
        int target = 2;
        int rst = new _02SearchInsert().searchInsert(nums, target);
        System.out.println(rst);
    }

}
