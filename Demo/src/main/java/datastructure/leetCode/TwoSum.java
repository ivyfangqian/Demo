package datastructure.leetCode;

import datastructure.utils.In;

import java.util.Arrays;
import java.util.HashMap;

/**
 * Given an array of integers, return indices of the two numbers such that they add up to a specific target.
 * <p>
 * You may assume that each input would have exactly one solution, and you may not use the same element twice.
 * <p>
 * Example:
 * Given nums = [2, 7, 11, 15], target = 9,
 * <p>
 * Because nums[0] + nums[1] = 2 + 7 = 9,
 * return [0, 1].
 */
public class TwoSum {

    /**
     * 我的笨方法，从头开始遍历查找，有没有能够相加得到最后的target的方法
     *
     * @param nums
     * @param target
     * @return
     */
//    public int[] twoSum(int[] nums, int target) {
//        int[] indices = {-1, -1};
//        for (int i = 0; i < nums.length - 1; i++) {
//            for (int j = i + 1; j < nums.length; j++) {
//                if (nums[i] + nums[j] == target) {
//                    indices[0] = i;
//                    indices[1] = j;
//                    break;
//                }
//            }
//        }
//        return indices;
//    }
    public int[] twoSum(int[] nums, int target) {
        HashMap<Integer, Integer> numMap = new HashMap<Integer, Integer>();
        int[] indices = new int[2];

        //将数据放到map中，其中key为nums[i],value为索引值
        for (int i = 0; i < nums.length; i++) {
            numMap.put(nums[i], i);
        }

        for (int i = 0; i < nums.length; i++) {
            int searched = target - nums[i];  //要搜索的值为target-nums[i]
            if (numMap.containsKey(searched) && numMap.get(searched)!= i) {
                indices[0] = i;
                indices[1] = numMap.get(searched); //索引为找到的map的searched所对应的值
            }
        }
        Arrays.sort(indices);
        return indices;
    }

    public static void main(String[] args) {
        int[] nums = {3, 3};
        TwoSum twoSum = new TwoSum();
        int[] res = twoSum.twoSum(nums, 6);
        System.out.println(res[0] + "," + res[1]);
    }


}
