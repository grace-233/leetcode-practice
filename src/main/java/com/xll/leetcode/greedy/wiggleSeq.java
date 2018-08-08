package com.xll.leetcode.greedy;

import java.util.ArrayList;
import java.util.List;

/**
 * 摆动序列
 * https://leetcode-cn.com/problems/wiggle-subsequence/description/
 * @author leiqian
 *
 */
public class wiggleSeq {
    
    /**
     * 
     * @param nums 原始数组
     * @return 作为摆动序列的最长子序列的长度
     */
    public static int wiggleMaxLength(int[] nums) {
        if(nums.length < 2) {
            return nums.length;
        }
        int count = 1;
        int preLast = nums[0];
        int last = nums[0];
        for(int i=1;i<nums.length;i++) {
            boolean flag = false;
            int symbol = (nums[i] - last) * (last - preLast);
            if(count == 1 && nums[i] != last) {
                flag = true;
            } else if(symbol < 0) {
                flag = true;
            } else if(symbol > 0 && (Math.abs(nums[i]-preLast) > Math.abs(last-preLast))) {
                // 如果符号相同,要选择相差最大的那个值
                last = nums[i];
            }
            
            if(flag) {
              count++;
              preLast = last;
              last = nums[i];
            }
        }
        return count;
    }
    
    /**
     * 最优解法
     * @param nums
     * @return
     */
    public static int wiggleMaxLength2(int[] nums) {
        int count = 1;
        if(nums.length < 2) {
            return nums.length;
        }
        int symbol = 0;  //标识+/-符号
        for(int i=1;i<nums.length;i++) {
            if(symbol == 0 && nums[i] != nums[i-1]) {
                symbol = nums[i] - nums[i-1];
                count++;
            } else if(symbol * (nums[i] - nums[i-1]) < 0) {
                symbol = -symbol;
                count++;
            }
        }
        return count;
    }
    
    public static void main(String[] args) {
        int[] arr = new int[] {33,53,12,64,50,41,45,21,97,35,47,92,39,0,93,55,40,46,69,42,6,95,51,68,72,9,32,84,34,64,6,2,26,98,3,43,30,60,3,68,82,9,97,19,27,98,99,4,30,96,37,9,78,43,64,4,65,30,84,90,87,64,18,50,60,1,40,32,48,50,76,100,57,29,63,53,46,57,93,98,42,80,82,9,41,55,69,84,82,79,30,79,18,97,67,23,52,38,74,15};
        long start = System.currentTimeMillis();
        for(int i = 0;i<1000000;i++) {
            wiggleMaxLength(arr);
        }
        System.out.println(wiggleMaxLength(arr));
        System.out.println("执行时间:" + (System.currentTimeMillis() - start));
        
        
        start = System.currentTimeMillis();
        for(int i = 0;i<1000000;i++) {
            wiggleMaxLength2(arr);
        }
        System.out.println(wiggleMaxLength2(arr));
        System.out.println("执行时间:" + (System.currentTimeMillis() - start));
    }
}
