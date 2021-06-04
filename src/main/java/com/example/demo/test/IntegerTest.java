package com.example.demo.test;

import java.util.ArrayList;
import java.util.List;

public class IntegerTest {

    public static void main(String[] args) {
        //System.out.println(reverse(-130));
        int[] num = {2,16,3,5,13,1,16,1,12,18,11,8,11,11,5,1};
        int target = 9;
        //int[] ints = twoSum(num, target);
        //System.out.println(ints.toString());
//        double mySqrt = myPow(2,5);
//        System.out.println(mySqrt);
//        int climbStairs = stepCount(3);
//        System.out.println(climbStairs);

    }


    /**
     * 1234---4321
     * 10. 整数反转
     * @param x
     * @return
     */
    public static int reverse(int x) {
        int rev=0;
        while (x!=0){
            //余数pop
            int pop = x%10;
            //做除法
            x = x/10;
            //判断组合后数的范围 Integer.MAX_VALUE: 2147483747
            if (rev>Integer.MAX_VALUE/10|| (rev==Integer.MAX_VALUE/10 && pop>7) ){
                return 0;
            }
            //Integer.MAX_VALUE: -2147483648
            if (rev<Integer.MIN_VALUE/10|| (rev==Integer.MIN_VALUE/10 && pop<-8) ){
                return 0;
            }
            rev = rev*10+pop;
        }
        return rev;
    }

    /**
     * 二分查找法
     * x的平方根
     * @param x
     * @return
     */
    public static int mySqrt(int x) {
        //临界条件判断
        if (x==0||x==1) return x;
        long left = 1;
        long right = x;
        while (left<=right){
            long mid = left+(right-left)/2;
            if (mid*mid>x){
                right = mid-1;
            }else if(mid*mid<x){
                left = mid+1;
            }else{
                return (int)mid;
            }
        }
        return (int)right;//取平方后最接近x的数
    }

    /**
     * 即计算 x 的 n 次幂函数（即，xn）
     * @param x
     * @param n
     * @return
     */
    public static double myPow(double x, int n) {
        long N = n;
        return N >= 0 ? quickMul(x, N) : 1.0 / quickMul(x, -N);
    }

    public static double quickMul(double x, long N) {
        double ans = 1.0;
        // 贡献的初始值为 x
        double x_contribute = x;
        // 在对 N 进行二进制拆分的同时计算答案
        while (N > 0) {
            if (N % 2 == 1) {
                // 如果 N 二进制表示的最低位为 1，那么需要计入贡献
                ans *= x_contribute;
            }
            // 将贡献不断地平方
            x_contribute *= x_contribute;
            // 舍弃 N 二进制表示的最低位，这样我们每次只要判断最低位即可
            N /= 2;
        }
        return ans;
    }

    /**
     * 爬楼梯
     * 每次你可以爬 1 或 2 个台阶。你有多少种不同的方法可以爬到楼顶呢
     * @param n
     * @return
     */
    //3.动态规划：时间复杂度n
    public static int climbStairs(int n) {
        int left = 0;
        int right = 0;
        int r =1;
        for(int i = 0;i<n;i++){
            left = right;
            right = r;
            r = left+right;
        }
        return r;
    }

    /**
     * 爬楼梯
     * 每次你可以爬 1 或 2 个台阶。你有多少种不同的方法可以爬到楼顶呢
     * 递归
     * @param n
     * @return
     */
    public static int fn(int n) {
        if (n == 0) {
            return 0;
        } else if (n == 1 | n == 2) {
            return 1;
        } else return fn(n - 1) + fn(n - 2);
    }

    /**
     * 一个机器人位于一个 m x n 网格的左上角 （起始点在下图中标记为 “Start” ）。
     * 机器人每次只能向下或者向右移动一步。机器人试图达到网格的右下角（在下图中标记为 “Finish” ）。
     * 问总共有多少条不同的路径？
     * @param m
     * @param n
     * @return
     */
    public static int uniquePaths(int m, int n) {
        int[][] f = new int[m][n];
        for (int i = 0; i < m; ++i) {
            f[i][0] = 1;
        }
        for (int j = 0; j < n; ++j) {
            f[0][j] = 1;
        }
        for (int i = 1; i < m; ++i) {
            for (int j = 1; j < n; ++j) {
                f[i][j] = f[i - 1][j] + f[i][j - 1];
            }
        }
        return f[m - 1][n - 1];
    }

    public static int countSubstrings(String s) {
        // 中心扩展法
        int ans = 0;
        for (int center = 0; center < 2 * s.length() - 1; center++) {
            // left和right指针和中心点的关系是？
            // 首先是left，有一个很明显的2倍关系的存在，其次是right，可能和left指向同一个（偶数时），也可能往后移动一个（奇数）
            // 大致的关系出来了，可以选择带两个特殊例子进去看看是否满足。
            int left = center / 2;
            int right = left + center % 2;

            while (left >= 0 && right < s.length() && s.charAt(left) == s.charAt(right)) {
                ans++;
                left--;
                right++;
            }
        }
        return ans;
    }

    /**
     * 4,3,2,7,8,2,3,1
     *找到所有数组中消失的数字
     * @param nums
     * @return
     */
    public static List<Integer> findDisappearedNumbers(int[] nums) {
        int n = nums.length;
        for (int num : nums) {
            int x = (num - 1) % n;
            nums[x] += n;
        }
        List<Integer> ret = new ArrayList<Integer>();
        for (int i = 0; i < n; i++) {
            if (nums[i] <= n) {
                ret.add(i + 1);
            }
        }
        return ret;
    }

    /**
     * 明汉距离
     * @param x
     * @param y
     * @return
     */
    public static int hammingDistance(int x, int y) {
        int xor = x ^ y;
        int distance = 0;
        while (xor != 0) {
            if (xor % 2 == 1){
                distance += 1;
            }
            xor = xor >> 1;
        }
        return distance;
    }






}
