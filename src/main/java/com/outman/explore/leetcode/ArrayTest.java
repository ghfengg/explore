package com.outman.explore.leetcode;

public class ArrayTest {

    public static void main(String[] args) {
        int[] nums = new int[]{1, 2, 3, 4, 5, 6, 7, 8};
        int[] result = twoSum(nums, 9);
    }

    /**
     * 给定一个整数数组 nums 和一个目标值 target，请在数组中找出和为目标值的两个数，并返回它们的索引
     *
     * @param nums
     * @param target
     * @return
     */
    public static int[] twoSum(int[] nums, int target) {
        // Your code here
        for (int i = 0; i < nums.length; i++) {
            int left = nums[i];
            for (int j = i + 1; j < nums.length; j++) {
                int right = nums[j];
                if ((left + right) == target) {
                    System.out.println(i);
                    System.out.println(j);
                }
            }
        }
        return null;
    }

}
