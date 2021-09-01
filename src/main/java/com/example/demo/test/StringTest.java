package com.example.demo.test;

import java.util.*;


public class StringTest {


    public static void main(String[] args) {
       String a = "abbcd";
       String b = "agbce";
        int longestCommonSubsequence = longestCommonSubsequence(a, b);
    }


    public static String addStrings(String num1, String num2) {
        StringBuilder s = new StringBuilder();
        int i= num1.length()-1;
        int j= num2.length()-1;
        int add=0;
        while(i>=0||j>=0||add!=0){
            int x = i<0?0:num1.charAt(i--)-'0';
            int y = j<0?0:num2.charAt(j--)-'0';
            int sum = x+y+add;
            s.append(sum%10);
            add = sum/10;
        }
        return s.reverse().toString();
    }

    /**
     * 33. 最长公共子序列
     * @param text1
     * @param text2
     * @return
     */
    public static int longestCommonSubsequence(String text1, String text2) {
        if (text1.length()==0||text2.length()==0) return 0;
        int m = text1.length();
        int n = text2.length();
        int[][] dp = new int[m+1][n+1];
        for (int i = 1; i < m+1; i++) {
            for (int j = 1; j < n+1; j++) {
                if (text1.charAt(i-1)==text2.charAt(j-1)){
                    dp[i][j] = dp[i-1][j-1]+1;
                }else {
                    dp[i][j] = Math.max(dp[i-1][j],dp[i][j-1]);
                }
            }
        }
        return dp[m][n];
    }

//    public static int longestCommonSubsequence(String text1, String text2) {
//        //临界条件判断
//        if(text1.length()==0||text2.length()==0) return 0;
//        int m = text1.length();
//        int n = text2.length();
//        int[][] dp = new int[m+1][n+1];
//        int result = 0;
//        //从1开始，所以dp数组长度加一
//        for(int i=1;i<m+1;i++){
//            for(int j=1;j<n+1;j++){
//                if(text1.charAt(i-1)==text2.charAt(j-1)){
//                    dp[i][j] = dp[i-1][j-1]+1;
//                    result = Math.max(result,dp[i][j]);
//                }else{
//                    dp[i][j] = 0;
//                }
//            }
//        }
//        return result;
//    }

    /**
     *36. 是不是验证回文串（正反都是一样的）
     * @param s
     * @return
     */
    public static boolean isPalindrome(String s) {
        if (s.isEmpty())
            return true;
        int left = 0, right = s.length() - 1;
        while (left < right) {
            while (left < right && !Character.isLetterOrDigit(s.charAt(left)))//确定指定的字符是否为字母或数字
                left++;
            while (left < right && !Character.isLetterOrDigit(s.charAt(right)))//确定指定的字符是否为字母或数字
                right--;
            if (Character.toLowerCase(s.charAt(left)) != Character.toLowerCase(s.charAt(right)))//比较左右对称的字符是否相等,不相等直接返回false
                return false;
            left++;//向右移动
            right--;//向左移动
        }
        return true;
    }

    /**
     * 反转字符串
     * @param string
     * @return
     */
    public static String reverseString(String string){
        StringBuffer stringBuffer = new StringBuffer();
        int sum = string.length()-1;
        while(sum >=0){
            char c = string.charAt(sum);
            stringBuffer.append(c);
            sum--;
        }
        return stringBuffer.toString();
    }

    /**
     * 给定一个只包括 '('，')'，'{'，'}'，'['，']' 的字符串 s ，判断字符串是否有效。
     * 有效字符串需满足：
     * 左括号必须用相同类型的右括号闭合。
     * 左括号必须以正确的顺序闭合
     * 有效的括号
     * @param s
     * @return
     */
    public static  boolean isValid(String s) {
        if(s.isEmpty() || s.length()%2 != 0){
            return false;
        }
        while(s.contains("[]") || s.contains("{}") || s.contains("()")){
            if(s.contains("[]")){
                s = s.replaceAll("\\[]","");
            }
            if( s.contains("{}")){
                s = s.replaceAll("\\{}","");
            }
            if( s.contains("()")){
                s = s.replaceAll("\\(\\)","");
            }
        }
        return s.isEmpty();
    }

    /**
     * 无重复字符的最长子串
     * @param s
     * @return
     */
    public static int lengthOfLongestSubstring(String s) {
        if("".equals(s) || null == s){
            return 0;
        }
        //用链表实现队列，队列是先进先出的
        Queue<Character> queue = new LinkedList<>();
        int res = 0;
        for (char c : s.toCharArray()) {
            while (queue.contains(c)) {
                //如果有重复的，队头出队
                queue.poll();
            }
            //添加到队尾
            queue.offer(c);
            res = Math.max(res, queue.size());
        }
        return res;
    }
    /**
     * 暴力解法
     * abbakudg
     * 给你一个字符串 s，找到 s 中最长的回文子串
     * @param s
     * @return
     */
    public static String longestPalindrome(String s) {
        String ans = "";
        int max = 0;
        int len = s.length();
        for (int i = 0; i < len; i++)
            for (int j = i + 1; j <= len; j++) {
                String test = s.substring(i, j);
                if (isPalindromic(test) && test.length() > max) {
                    ans = s.substring(i, j);
                    max = Math.max(max, ans.length());
                }
            }
        return ans;
    }
    /**
     * 进行前后字段比较
     * @param s
     * @return
     */
    public static boolean isPalindromic(String s) {
        int len = s.length();
        for (int i = 0; i < len / 2; i++) {
            if (s.charAt(i) != s.charAt(len - i - 1)) {
                return false;
            }
        }
        return true;
    }

    /**
     * ()(())
     * 给你一个只包含 '(' 和 ')' 的字符串，找出最长有效（格式正确且连续）括号子串的长度。
     * @param s
     * @return
     */
    public static int longestValidParentheses(String s) {
        int left = 0, right = 0, maxlength = 0;
        for (int i = 0; i < s.length(); i++) {
            if (s.charAt(i) == '(') {
                left++;
            } else {
                right++;
            }
            if (left == right) {
                maxlength = Math.max(maxlength, 2 * right);
            } else if (right > left) {
                left = right = 0;
            }
        }
        left = right = 0;
        for (int i = s.length() - 1; i >= 0; i--) {
            if (s.charAt(i) == '(') {
                left++;
            } else {
                right++;
            }
            if (left == right) {
                maxlength = Math.max(maxlength, 2 * left);
            } else if (left > right) {
                left = right = 0;
            }
        }
        return maxlength;
    }

    /**
     * 找到字符串中所有字母异位词
     * @param s
     * @param p
     * @return
     */
    public static List<Integer> findAnagrams(String s, String p) {
        List<Integer> list = new ArrayList<>();
        int sLength = s.length();
        int pLength = p.length();
        char[] pArray = p.toCharArray();
        Arrays.sort(pArray);
        //获取到p排序后的字符串
        String string = new String(pArray);
        for(int i=0;i<=sLength-pLength;i++){
            StringBuffer sb = new StringBuffer();
            //k pTemp是两个临时变量
            int k = i;
            int pTemp = pLength;
            //获取到和p一样长度的字符串
            while(pTemp>0){
                sb.append(s.charAt(k));
                k++;
                pTemp--;

            }
            char[] sbTemp = sb.toString().toCharArray();
            Arrays.sort(sbTemp);
            //临时的字符串进行排序
            String sbString = new String(sbTemp);
            //比较两个字符串是否一样
            if(string.equals(sbString)){
                list.add(i);
            }
        }
        return list;

    }

    public String replaceSpace(String s) {
        StringBuffer sb = new StringBuffer();
        for(char c:s.toCharArray()){
            if(c == ' '){
                sb.append("%20");
            }else{
                sb.append(c);
            }
        }
        return sb.toString();


    }


}
