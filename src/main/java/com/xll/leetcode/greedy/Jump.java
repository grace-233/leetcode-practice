package com.xll.leetcode.greedy;

/**
 * 跳跃问题 https://leetcode-cn.com/problems/jump-game/description/
 * 
 * @author leiqian
 *
 */
public class Jump {

    /**
     * 方法：对于任何一个位置，在可跳跃的范围内，选择跳转步数+跳跃到的位置的数字最大即可。<br>
     * 所以这是一个贪心问题
     * 
     * @param nums 非负整数的数组
     * @return
     */
    public static boolean canJump(int[] nums) {
        int i = 0; // 数组当前位置
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
            if (step == 0)
                break;
        }
        if (i != nums.length - 1)
            return false;
        return true;
    }

    /**
     * 最优解法
     * 
     * @param nums
     * @return
     */
    public static boolean canJump2(int[] nums) {
        int idx = 0; // 当前数组位置
        int maxInx = nums[0]; // 最远可到达的位置
        while (idx < nums.length - 1 && idx <= maxInx) {
            if (idx + nums[idx] > maxInx)
                maxInx = idx + nums[idx];
            else if (idx == maxInx)
                break;
            idx++;
        }
        if (idx == nums.length - 1)
            return true;
        return false;
    }

    public static void main(String[] args) {
        int[] s = new int[] { 2, 3, 1, 1, 4 };

        long start = System.currentTimeMillis();
        for (int i = 0; i < 100000000; i++) {
            canJump(s);
        }
        System.out.println(canJump(s));
        System.out.println("用时:" + (System.currentTimeMillis() - start));

        start = System.currentTimeMillis();
        for (int i = 0; i < 100000000; i++) {
            canJump2(s);
        }
        System.out.println(canJump2(s));
        System.out.println("用时:" + (System.currentTimeMillis() - start));
    }
}
