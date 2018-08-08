package com.xll.leetcode.greedy;

import java.util.Arrays;
import java.util.Comparator;

/**
 * 用最少数量的箭引爆气球:
 * https://leetcode-cn.com/problems/minimum-number-of-arrows-to-burst-balloons/description/
 * 
 * @author leiqian
 *
 */
public class MinArrowShots {

    /**
     * 方法:满足贪心规律：依次遍历,找到一个能引爆最多数量的点 如何找到一个能引爆最多数量的点？<br>
     * 比较第i点和第i+1点，如果能同时穿透，就比较i和i+2,依次类推 如果第i和i+k个点刚好不能不穿透,那么第i和i+k-1个点之间的点都能穿透
     * 还需要记录每次的可穿透范围,因为 可穿透没有传递性
     * 
     * @param points 平面上的坐标
     * @return 最少需要的弓箭数
     */
    public static int findMinArrowShots(int[][] points) {
        Comparator<int[]> c = new Comparator<int[]>() {
            @Override
            public int compare(int[] o1, int[] o2) {
                return o1[0] - o2[0]; // 只需对第一个坐标排序
            }
        };
        Arrays.sort(points, c);
        print(points);
        if (points.length == 0)
            return 0;
        int count = 1;// 需要的弓箭个数
        int[] firstPoint = points[0]; // 可以同时穿透的第一个point的索引
        int[] range = points[0]; // 记录可穿透的范围
        for (int i = 1; i < points.length; i++) {
            if (firstPoint[1] < points[i][0] || range[0] > range[1]) {// 不能穿透
                count++;
                firstPoint = points[i];
                range = points[i];
            } else { // 可穿透
                range[0] = Math.max(range[0], points[i][0]);
                range[1] = Math.min(range[1], points[i][1]);
            }
        }
        return count;
    }

    public static void print(int[][] points) {
        System.out.print("[");
        for (int i = 0; i < points.length; i++) {
            System.out.print(Arrays.toString(points[i]));
            System.out.print(",");
        }
        System.out.println("]");
    }

    /**
     * 最优解法:按照第一个坐标排序可以有传递性，不再需要每次记录可穿透范围了
     * 
     * @param points
     * @return
     */
    public static int findMinArrowShots2(int[][] points) {
        Comparator<int[]> c = new Comparator<int[]>() {
            @Override
            public int compare(int[] o1, int[] o2) {
                return o1[1] - o2[1]; // 只需对第2个坐标排序
            }
        };
        Arrays.sort(points, c);
        print(points);
        if (points.length == 0)
            return 0;
        int count = 1;// 需要的弓箭个数
        int firstPoint = points[0][1];
        for (int i = 1; i < points.length; i++) {
            if (firstPoint < points[i][0]) {// 不能穿透
                count++;
                firstPoint = points[i][1];
            }
        }
        return count;
    }

    public static void main(String[] args) {
        // int[][] points = new int[][] { { 10, 16 }, { 2, 8 }, { 1, 6 }, { 7, 12 } };
        int[][] points = new int[][] { { 1, 9 }, { 7, 16 }, { 2, 5 }, { 7, 12 }, { 9, 11 }, { 2, 10 }, { 9, 16 },
                { 3, 9 }, { 1, 3 } };
        System.out.println(findMinArrowShots2(points));
    }
}
