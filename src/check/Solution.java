package check;

import java.util.Arrays;

/**
 * Given an array of integers nums sorted in non-decreasing order,
 * find the starting and ending position of a given target value.
 * If target is not found in the array, return [-1, -1].
 * You must write an algorithm with O(log n) runtime complexity.
 */
public class Solution {
    public static void main(String[] args) {
        System.out.println(getPosition(new int[]{1,2,2,2,3,4,5,6,7,8,9}, 2, 0, 9));
        System.out.println(Arrays.toString(searchRange(new int[]{1, 2, 2, 2, 3, 4, 5, 6, 7, 8, 9}, 2)));
        System.out.println(Arrays.toString(searchRange(new int[]{2,2}, 3)));
    }

    public static int[] searchRange(int[] nums, int target) {
        if (nums.length == 0) {
            return new int[]{-1, -1};
        }
        int position = getPosition(nums, target, 0, nums.length-1);
        if (position == -1){
            return new int[]{-1, -1};
        }
        int[] positions = new int[2];
        int temp = position-1;
        while (temp >=0 && nums[temp] == target){
            temp--;
        }
        positions[0] = temp+1;

        temp = position+1;
        while (temp < nums.length && nums[temp] == target){
            temp++;
        }
        positions[1] = temp-1;
        return positions;
    }

    private static int getPosition(int[] array, int target, int left, int right){
        int mid = (left+right)/2;
        if (mid > right || mid < left){
            return -1;
        }
        if (array[mid] == target){
            return mid;
        }
        if (array[mid]<target){
            left = mid+1;

        } else {
            right = mid-1;
        }

        return getPosition(array, target, left, right);
    }

}
