package com.xll.leetcode.greedy;

import java.util.Arrays;

/**
 * 分饼干的问题
 * https://leetcode-cn.com/problems/assign-cookies/description/
 * @author leiqian
 *
 */
public class ShareCookie {
    
    /**
     * 
     * @param g 孩子的胃口数组
     * @param s 饼干的尺寸数组
     * @return 最多可以满足孩子的个数
     */
    public static int findContentChildren(int[] g, int[] s) {
        int count = 0;
        int id = 0;
        Arrays.sort(g);
        Arrays.sort(s);
        for(int i = 0;i<g.length;i++) {
            for(int j= id;j<s.length;j++) {
                if(g[i]<=s[j]) {
                    count++;
                    id = j + 1;
                    break;
                }
            }
        }
        return count;
    }
    
    /**
     * 最优解法
     * @param g
     * @param s
     * @return
     */
    public static int findContentChildren2(int[] g, int[] s) {
        int count = 0;
        Arrays.sort(g);
        Arrays.sort(s);
        int i=0,j=0;
        while(i< g.length && j < s.length) {
            if(g[i]<=s[j]) {
                i++;
                count++;
            } 
            j++;
        }
        return count;
    }
    
    public static void main(String[] args) {
        int[] g = new int[]{5,10,2,9,15,9};
        int[] s = new int[] {6,1,20,3,8};
        
        long start = System.currentTimeMillis();
        for(int i = 0;i<10000000;i++) {
            findContentChildren(g,s);
        }
        System.out.println(findContentChildren(g,s));
        System.out.println(System.currentTimeMillis()-start);
        
        start = System.currentTimeMillis();
        for(int i = 0;i<10000000;i++) {
            findContentChildren2(g,s);
        }
        System.out.println(findContentChildren2(g,s));
        System.out.println(System.currentTimeMillis()-start);
    }
    
}
