package com.xll.leetcode.greedy;

/**
 * 计算最大x元钱，使用1,5,10,20,100,200面额的钞票最小需要多少张
 * 如果面值不是整数倍递增的话，比如包含7元的面值，那么就不能使用贪心算法了
 * @author leiqian
 *
 */
public class GreedyDemo {

    /** 钱的面值*/
    private static final int[] MONEY = new int[] { 1, 5, 10, 20, 100, 200 };

    public static int getCount(int value) {
        int count = 0;
        for (int i = MONEY.length - 1; i >= 0; i--) {
            int tmpCount = value / MONEY[i];
            count += tmpCount;
            value -= tmpCount * MONEY[i];
        }
        return count;
    }

    public static void main(String[] args) {
        int value = 628;
        System.out.println(getCount(value));
    }
}
