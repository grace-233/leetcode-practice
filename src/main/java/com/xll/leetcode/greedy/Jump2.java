package com.xll.leetcode.greedy;

/**
 * 跳跃游戏2:https://leetcode-cn.com/problems/jump-game-ii/description/
 * 
 * @author leiqian
 *
 */
public class Jump2 {

    /**
     * 假设你总是可以到达数组的最后一个位置
     * 
     * @param nums 数组
     * @return 跳跃的最少次数
     */
    public static int jump(int[] nums) {
        int i = 0; // 数组当前位置
        int count = 0; // 跳的次数
        while (i < nums.length - 1) {
            int step = 0; // 往前跳的步数
            int max = 0; // 步数+跳跃到的位置的数字的最大值
            for (int j = 0; j <= nums[i]; j++) {
                if (i + j >= nums.length - 1) {
                    step = j;
                    break;
                }
                if (j + nums[i + j] > max) {
                    max = j + nums[i + j];
                    step = j;
                }
            }
            i = i + step;
            count++;
            if (step == 0)
                break;
        }
        return count;
    }

    /**
     * 最优解法
     * 
     * @param nums
     * @return
     */
    public static int jump3(int[] nums) {
        if (nums.length < 2)
            return 0;
        int count = 0; // 跳跃次数
        int preMaxInx = nums[0]; // 当前最远可到达的位置
        int newMaxInx = nums[0]; // 步数+跳跃到的位置的数字的最大值
        for (int i = 1; i < nums.length; i++) {
            if (i > preMaxInx) {
                count++;
                preMaxInx = newMaxInx;
            }
            newMaxInx = Math.max(newMaxInx, nums[i] + i);
        }
        count++;
        return count;
    }

    public static void main(String[] args) {
        int[] s = new int[] { 5, 9, 3, 2, 1, 0, 2, 3, 3, 1, 0, 0 };

        long start = System.currentTimeMillis();
        for (int i = 0; i < 10000000; i++) {
            jump(s);
        }
        System.out.println(jump(s));
        System.out.println("用时:" + (System.currentTimeMillis() - start));

        start = System.currentTimeMillis();
        for (int i = 0; i < 10000000; i++) {
            jump3(s);
        }
        System.out.println(jump3(s));
        System.out.println("用时:" + (System.currentTimeMillis() - start));
    }
}
