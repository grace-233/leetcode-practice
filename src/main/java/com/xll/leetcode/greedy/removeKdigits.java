package com.xll.leetcode.greedy;

/**
 * 移掉K位数字 https://leetcode-cn.com/problems/remove-k-digits/description/
 * 
 * @author leiqian
 *
 */
public class removeKdigits {

    /**
     * 方法：如果要保留m位,那么每次在num的前(length - num + 1) 位中找最小的一位
     * 
     * @param num
     *            字符串形式的数字 ,num 的长度小于 10002 且 ≥ k
     * @param k
     *            k位数字
     * @return 移除后的最小数字
     */
    public static String removeKdigits1(String num, int k) {
        if (num.length() == k) {
            return "0";
        }
        char[] c = num.toCharArray();
        int m = num.length() - k; // 要保留为位数
        StringBuffer result = new StringBuffer();
        int minIdx = 0; // 最小值的下标
        int i = 0;
        while (i < c.length) {
            if (c[i] < c[minIdx]) {
                minIdx = i;
            }
            if (c[minIdx] == '0' || i == (c.length - m)) {
                if (!(result.length() == 0 && c[minIdx] == '0')) {
                    result.append(c[minIdx]);
                }
                i = minIdx;
                minIdx = i + 1;
                m--;
            }
            i++;
        }
        String s = result.toString();
        return s.equals("") ? "0" : s;
    }

    public static void main(String[] args) {
        String s = "1234567890";
        int k = 9;

        long start = System.currentTimeMillis();
        for (int i = 0; i < 10000000; i++) {
            removeKdigits1(s, k);
        }
        System.out.println(removeKdigits1(s, k));
        System.out.println("用时:" + (System.currentTimeMillis() - start));

    }
}
