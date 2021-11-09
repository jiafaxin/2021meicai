package com.example.demo.test;

import java.util.*;

/**
 *
 */
public class ArrayTest {

    public static void main(String[] string) throws Exception{

    }

    /**
     * 滑动窗口的最大值
     * array 数组
     * @param nums
     * @param k
     * @return
     */
    public int[] maxSlidingWindow(int[] nums, int k) {
        if(nums == null || nums.length < 2) return nums;
        // 双向队列 保存当前窗口最大值的数组位置 保证队列中数组位置的数值按从大到小排序
        LinkedList<Integer> queue = new LinkedList();
        // 结果数组
        int[] result = new int[nums.length-k+1];
        // 遍历nums数组
        for(int i = 0;i < nums.length;i++){
            // 保证从大到小 如果前面数小则需要依次弹出，直至满足要求
            while(!queue.isEmpty() && nums[queue.peekLast()] <= nums[i]){
                queue.pollLast();
            }
            // 添加当前值对应的数组下标
            queue.addLast(i);
            // 判断当前队列中队首的值是否有效
            if(queue.peek() <= i-k){
                queue.poll();
            }
            // 当窗口长度为k时 保存当前窗口中最大值
            if(i+1 >= k){
                result[i+1-k] = nums[queue.peek()];
            }
        }
        return result;
    }

    /**
     * 删除排序数组中的重复项
     * @param nums
     * @return
     */
    public int removeDuplicates(int[] nums) {
        int n = nums.length;
        if (n == 0) {
            return 0;
        }
        int fast = 1, slow = 1;
        while (fast < n) {
            if (nums[fast] != nums[fast - 1]) {
                nums[slow] = nums[fast];
                ++slow;
            }
            ++fast;
        }
        return slow;
    }


    /**
     * 合并两个有序数组
     * 3 6 8
     * 4 7
     * @param nums1
     * @param m
     * @param nums2
     * @param n
     */
    public void merge(int[] nums1, int m, int[] nums2, int n) {
        int p1 = m - 1, p2 = n - 1;
        int tail = m + n - 1;
        int cur;
        while (p1 >= 0 || p2 >= 0) {
            if (p1 == -1) {
                cur = nums2[p2--];
            } else if (p2 == -1) {
                cur = nums1[p1--];
            } else if (nums1[p1] > nums2[p2]) {
                cur = nums1[p1--];
            } else {
                cur = nums2[p2--];
            }
            nums1[tail--] = cur;
        }
    }

    /**
     * 归并排序
     * @param array
     * @param left
     * @param right
     */
    public static void mergeSort(int[] array, int left, int right) {
        //递归终止条件
        if (right <= left) return;
        //把长度为n的输入序列分成两个长度为n/2的子序列
        int mid = (left + right) >> 1; // (left + right) / 2
        //对这两个子序列分别采用归并排序
        mergeSort(array, left, mid);
        mergeSort(array, mid + 1, right);
        //将两个排序好的子序列合并成一个最终的排序序列
        merge(array, left, mid, right);
    }

    /**
     *
     * @param arr
     * @param left
     * @param mid
     * @param right
     */
    public static void merge(int[] arr, int left, int mid, int right) {
        //额外的空间
        int[] temp = new int[right - left + 1]; // 中间数组 right(arr.length-1) - left (0) +1 = arr.length
        //i 为arr第一个子序列的起点 j 为 arr第二个子序列的起点 k 为temp中元素的个数
        int i = left, j = mid + 1, k = 0;
        //当 i 和 j 都小于其长度时,往temp里放元素
        while (i <= mid && j <= right) {
            //将 arr[i]与arr[j]中的最小者放入temp中,且用到i或者j谁了就给谁进行i++
            //同时temo里的k下标也要++
            temp[k++] = arr[i] <= arr[j] ? arr[i++] : arr[j++];
        }
        //当第二个子序列j 中先把元素都放入temp了，就剩下 第一个子序列i了，也依次放入temp中
        while (i <= mid) temp[k++] = arr[i++];
        //当第一个子序列i 中先把元素都放入temp了，就剩下 第一个子序列i了，也依次放入temp中
        while (j <= right) temp[k++] = arr[j++];
        //现在已经将两个子序列都放入temp中了，则将结果在放回arr中
        for (int p = 0; p < temp.length; p++) {
            arr[left + p] = temp[p];
        }
    }

    /**
     * 给定一个整数数组 nums 和一个目标值 target，请你在该数组中找出和为目标值的那 两个 整数，并返回他们的数组下标。
     * 你可以假设每种输入只会对应一个答案。但是，你不能重复利用这个数组中同样的元素
     * num [2, 7, 11, 15]
     * target 9
     * [0, 1]
     * @param num
     * @param target
     * @return
     */
    public static int[] twoSum(int[] num,int target){
        for(int i = 0;i<num.length;i++){
            for(int j = i+1;j<num.length;j++){
                if(num[i] +num[j] == target){
                    return new int[]{i,j};
                }
            }
        }
        return null;
    }

    /**
     * https://blog.csdn.net/qq_41645636/article/details/98104894
     * 盛最多水的容器
     * @param num
     * @return
     */
    public static int maxArea(int[] num){
        int left = 0;
        int right = num.length-1;
        int maxArea = 0;
        while(left< right){
            int area = Math.min(num[left],num[right])*(right-left);
            if(area > maxArea){
                maxArea = area;
            }
            if(num[left]<num[right]){
                left++;
            }else{
                right--;
            }
        }
        return maxArea;
    }
    /**
     * 我们定义两个max，分别来记录左指针left和右指针right所走过的最大值，分别将它们记为left_max和right_max，然后：
     *
     * 从左往右看，我们可以发现，只要left指针所指的这个元素的值（即height[left]的值）小于left_max的值（即现在的值比前面的值要小，此时就肯定能蓄水），
     * 它就能进行蓄水，其蓄水面积为left_max - height[left]；
     *
     * 从右往左看，只要height[right]的值小于right_max的值，它就能进行蓄水，其蓄水面积为right_max - height[right]。
     * https://blog.csdn.net/qq_41645636/article/details/98479848
     * 接雨水
     */
    public static int trap(int[] num){
        int left = 0, right = num.length - 1;
        int left_max = 0, right_max = 0;
        int area = 0;

        while(left <= right) {
            if(num[left] <= num[right]) {
                left_max = (num[left] > left_max) ? num[left] : left_max;
                if(num[left] < left_max) {
                    area = area + left_max - num[left];
                }
                left ++;
            } else {
                right_max = (num[right] > right_max) ? num[right] : right_max;
                if(num[right] < right_max) {
                    area = area + right_max - num[right];
                }
                right --;
            }
        }
        return area;
    }

    /**
     * 无序数组中的第K个最大元素
     * @param nums
     * @param k
     * @return
     */
    public static int findKthLargest(int[] nums, int k) {
        int len = nums.length;
        Arrays.sort(nums);
        for(int j=0;j<len-k;j++){
            if(j == len-k-1){
                return nums[j+1];
            }
        }
        return 0;
    }

    /**
     * 最大子序和= 当前元素自身最大 或者 包含 之前 后最大
     * 从该序列中寻找一个连续的子序列，使得子序列的和最大
     * @param nums
     * @return
     */
    public static int maxSubArray(int[] nums) {
        int length=nums.length;
        int sum=nums[0];
        int tmpnum=0;
        for(int i=0;i<length;i++){
            tmpnum+=nums[i];
            if(tmpnum>sum){
                sum=tmpnum;
            }
            if(tmpnum<=0) {
                tmpnum = 0;
            }
        }
        return sum;
    }

    public static int findMin(int[] nums) {

        int count = nums.length-1;
        int numMix = nums[count];
        while(count >= 0){
            if(nums[count] < numMix){
                numMix = nums[count];
            }
            count --;
        }
        return numMix;
    }

    /**
     * 求两个数组合并的中位数
     * @param nums1
     * @param nums2
     * @return
     */
    public static double findMedianSortedArrays(int[] nums1, int[] nums2) {
        int sum1 = nums1.length;
        int sum2 = nums2.length;
        int sum3 = sum1+sum2;
        int[] arr1 = new int[sum3];
        int ii = 0;
        for(int i = 0 ;i<nums1.length ;i++){
            arr1[ii] = nums1[i];
            ii ++;
        }
        for(int j = 0 ;j<nums2.length ;j++){
            arr1[ii] = nums2[j];
            ii ++;
        }
        Arrays.sort(arr1);
        if(arr1.length%2 == 0){
            int count = arr1.length/2;
            return (arr1[count] + arr1[count-1])/2;
        }else{
            int count = arr1.length/2;
            return arr1[count];
        }
    }

    /**
     * 1,2,-1,6,-5,0
     * 三数之和
     * @param nums
     * @return
     */
    public static List<List<Integer>> threeSum(int[] nums) {
        List<List<Integer>> sum = new ArrayList<>();
        if(nums==null||nums.length<3) return sum;
        //双指针要先排序
        Arrays.sort(nums);
        for(int i = 0;i<nums.length-2;i++){
            if(nums[i]>0){
                break;
            }
            if(i>0 && nums[i] == nums[i-1]){
                continue;
            }
            int left = i+1;
            int right = nums.length-1;
            while(left<right){
                int count = nums[i] + nums[left]+nums[right];
                if(count == 0){
                    sum.add(new ArrayList(Arrays.asList(nums[i],nums[left],nums[right])));
                    while(left<right && nums[left] == nums[++left]);
                    while(left<right && nums[right] == nums[--right]);
                }else if(count>0){
                    while(left<right && nums[right] == nums[--right]);
                }else if(count<0){
                    while(left<right && nums[left] == nums[++left]);
                }
            }
        }
        return sum;
    }

    public List<String> list = new ArrayList<>();
    public StringBuffer sb = new StringBuffer();
    public List<String> letterCombinations(String digits) {
        if(digits == null || digits.length()==0){
            return list;
        }
        Map<Character, String> phoneMap = new HashMap<Character, String>() {{
            put('2', "abc");
            put('3', "def");
            put('4', "ghi");
            put('5', "jkl");
            put('6', "mno");
            put('7', "pqrs");
            put('8', "tuv");
            put('9', "wxyz");
        }};
        getList(digits,phoneMap,0);
        return list;

    }
    public void getList(String digits, Map<Character, String> phoneMap,int index){
        if(sb.length()== digits.length()){
            list.add(sb.toString());
            return;
        }
        char ch = digits.charAt(index);
        String string = phoneMap.get(ch);
        for(char charAt: string.toCharArray()){
            sb.append(charAt);
            getList(digits,phoneMap,index+1);
            sb.deleteCharAt(sb.length()-1);
        }
    }

    static List<String> res = new ArrayList<>();

    /**
     * 生成括弧
     * @param n
     * @return
     */
    public static List<String> generateParenthesis(int n) {
        if(n <= 0){
            return res;
        }
        getParenthesis("",n,n);
        return res;
    }

    private static void getParenthesis(String str,int left, int right) {
        if(left == 0 && right == 0 ){
            res.add(str);
            return;
        }
        if(left == right){
            //剩余左右括号数相等，下一个只能用左括号
            getParenthesis(str+"(",left-1,right);
        }else if(left < right){
            //剩余左括号小于右括号，下一个可以用左括号也可以用右括号
            if(left > 0){
                getParenthesis(str+"(",left-1,right);
            }
            getParenthesis(str+")",left,right-1);
        }
    }

    /**
     * [5,7,7,8,8,10]
     * @param nums
     * @param target
     * @return
     */
    public static int[] searchRange(int[] nums, int target) {
        int leftIdx = binarySearch(nums, target, true);
        int rightIdx = binarySearch(nums, target, false) - 1;
        if (leftIdx <= rightIdx && rightIdx < nums.length && nums[leftIdx] == target && nums[rightIdx] == target) {
            return new int[]{leftIdx, rightIdx};
        }
        return new int[]{-1, -1};
    }

    public static int binarySearch(int[] nums, int target, boolean lower) {
        int left = 0, right = nums.length - 1, ans = nums.length;
        while (left <= right) {
            int mid = (left + right) / 2;
            if (nums[mid] > target || (lower && nums[mid] >= target)) {
                right = mid - 1;
                ans = mid;
            } else {
                left = mid + 1;
            }
        }
        return ans;
    }

    /**
     *candidates = [2,3,5], target = 8
     * [
     *   [2,2,2,2],
     *   [2,3,3],
     *   [3,5]
     * ]
     */
    private static List<List<Integer>> returnList = new ArrayList<>();
    public static List<List<Integer>> combinationSum(int[] candidates, int target) {
        List<Integer> path = new ArrayList<>();
        Arrays.sort(candidates);
        backtrack(path,candidates,target,0,0);
        return returnList;
    }
    /**
     * 2 3 5
     * 8
     * @param path
     * @param candidates
     * @param target
     * @param sum
     * @param begin
     */
    private static void backtrack(List<Integer> path,int[] candidates,int target,int sum,int begin) {
        if(sum == target) {
            returnList.add(new ArrayList<>(path));
            return;
        }
        for(int i = begin;i < candidates.length;i++) {
            int rs = candidates[i] + sum;
            if(rs <= target) {
                path.add(candidates[i]);
                backtrack(path,candidates,target,rs,i);
                path.remove(path.size()-1);
            } else {
                break;
            }
        }
    }

    /**
     * 字母异位词分组
     * 输入: ["eat", "tea", "tan", "ate", "nat", "bat"]
     * 输出:
     * [
     *   ["ate","eat","tea"],
     *   ["nat","tan"],
     *   ["bat"]
     * ]
     * @param strs
     * @return
     */
    public static List<List<String>> groupAnagrams(String[] strs) {
        Map<String, List<String>> map = new HashMap<String, List<String>>();
        for (String str : strs) {
            char[] array = str.toCharArray();
            Arrays.sort(array);
            String key = new String(array);
            List<String> list = map.getOrDefault(key, new ArrayList<String>());
            list.add(str);
            map.put(key, list);
        }
        return new ArrayList<>(map.values());
    }

    /**
     * 跳跃游戏 2,3,1,1,4 true
     * 3,2,1,0,4 false
     * 给定一个非负整数数组 nums ，你最初位于数组的 第一个下标 。
     * 数组中的每个元素代表你在该位置可以跳跃的最大长度。
     * 判断你是否能够到达最后一个下标。
     * @param nums
     * @return
     */
    public static boolean canJump(int[] nums) {
        int n = nums.length;
        int rightmost = 0;
        for (int i = 0; i < n; ++i) {
            if(i <= rightmost) {
                rightmost = Math.max(rightmost, i + nums[i]);
                if (rightmost >= n - 1) {
                    return true;
                }
            }
        }
        return false;
    }

    /**
     *  合并区间
     *  输入：intervals = [[1,3],[2,6],[8,10],[15,18]]
     * 输出：[[1,6],[8,10],[15,18]]
     * 解释：区间 [1,3] 和 [2,6] 重叠, 将它们合并为 [1,6].
     * @param intervals
     * @return
     */
    public static int[][] merge(int[][] intervals) {
        if (intervals.length == 0) {
            return new int[0][2];
        }
        Arrays.sort(intervals, new Comparator<int[]>() {
            public int compare(int[] interval1, int[] interval2) {
                return interval1[0] - interval2[0];
            }
        });
        List<int[]> merged = new ArrayList<int[]>();
        for (int i = 0; i < intervals.length; ++i) {
            int L = intervals[i][0], R = intervals[i][1];
            if (merged.size() == 0 || merged.get(merged.size() - 1)[1] < L) {
                merged.add(new int[]{L, R});
            } else {
                merged.get(merged.size() - 1)[1] = Math.max(merged.get(merged.size() - 1)[1], R);
            }
        }
        return merged.toArray(new int[merged.size()][]);
    }

    /**
     * 给定一个包含红色、白色和蓝色，一共 n 个元素的数组，原地对它们进行排序，使得相同颜色的元素相邻，并按照红色、白色、蓝色顺序排列。
     * 此题中，我们使用整数 0、 1 和 2 分别表示红色、白色和蓝色。
     * [2,0,2,1,1,0]
     * @param nums
     */
    public static void sortColors(int[] nums) {
        int n = nums.length;
        int ptr = 0;
        for (int i = 0; i < n; ++i) {
            if (nums[i] == 0) {
                int temp = nums[i];
                nums[i] = nums[ptr];
                nums[ptr] = temp;
                ++ptr;
            }
        }
        for (int i = ptr; i < n; ++i) {
            if (nums[i] == 1) {
                int temp = nums[i];
                nums[i] = nums[ptr];
                nums[ptr] = temp;
                ++ptr;
            }
        }
    }

    /**
     * 给你一个整数数组 nums ，数组中的元素 互不相同 。返回该数组所有可能的子集（幂集）。
     * 输入：nums = [1,2,3]
     * 输出：[[],[1],[2],[1,2],[3],[1,3],[2,3],[1,2,3]]
     */
    static List<Integer> t = new ArrayList<Integer>();
    static List<List<Integer>> ans = new ArrayList<List<Integer>>();

    public static List<List<Integer>> subsets(int[] nums) {
        dfs(0, nums);
        return ans;
    }

    public static void dfs(int cur, int[] nums) {
        if (cur == nums.length) {
            ans.add(new ArrayList<Integer>(t));
            return;
        }
        t.add(nums[cur]);
        dfs(cur + 1, nums);
        t.remove(t.size() - 1);
        dfs(cur + 1, nums);
    }

    /**
     * 单词搜索
     * 给定一个 m x n 二维字符网格 board 和一个字符串单词 word 。如果 word 存在于网格中，返回 true ；否则，返回 false 。
     * 单词必须按照字母顺序，通过相邻的单元格内的字母构成，其中“相邻”单元格是那些水平相邻或垂直相邻的单元格。同一个单元格内的字母不允许被重复使用。
     * @param board
     * @param word
     * @return
     */
    public static boolean exist(char[][] board, String word) {
        for (int i = 0; i < board.length; ++i) {
            for (int j = 0; j < board[0].length; ++j) {
                if (board[i][j] == word.charAt(0)) {
                    if (dfs(board, word, i, j, 0)) {
                        return true;
                    }
                }
            }
        }
        return false;
    }

    public static boolean dfs(char[][] board, String word, int i, int j, int k) {
        if (k == word.length()) {
            return true;
        }
        if (i < 0 || j < 0 || i >= board.length || j >= board[0].length) {
            return false;
        }

        if (word.charAt(k) != board[i][j]) {
            return false;
        }
        char t = board[i][j];
        board[i][j] = '0';
        boolean res = dfs(board, word, i + 1, j, k + 1) ||
                dfs(board, word, i - 1, j, k + 1) ||
                dfs(board, word, i, j + 1, k + 1) ||
                dfs(board, word, i, j - 1, k + 1);
        board[i][j] = t;
        return res;
    }

    /**
     * 柱状图中最大的矩形
     * 给定 n 个非负整数，用来表示柱状图中各个柱子的高度。每个柱子彼此相邻，且宽度为 1 。
     * 求在该柱状图中，能够勾勒出来的矩形的最大面积
     * @param heights
     * @return
     */
    public static int largestRectangleArea(int[] heights) {
        int n = heights.length;
        int[] left = new int[n];
        int[] right = new int[n];

        Stack<Integer> mono_stack = new Stack<Integer>();
        for (int i = 0; i < n; ++i) {
            while (!mono_stack.isEmpty() && heights[mono_stack.peek()] >= heights[i]) {
                mono_stack.pop();
            }
            left[i] = (mono_stack.isEmpty() ? -1 : mono_stack.peek());
            mono_stack.push(i);
        }

        mono_stack.clear();
        for (int i = n - 1; i >= 0; --i) {
            while (!mono_stack.isEmpty() && heights[mono_stack.peek()] >= heights[i]) {
                mono_stack.pop();
            }
            right[i] = (mono_stack.isEmpty() ? n : mono_stack.peek());
            mono_stack.push(i);
        }

        int ans = 0;
        for (int i = 0; i < n; ++i) {
            ans = Math.max(ans, (right[i] - left[i] - 1) * heights[i]);
        }
        return ans;
    }

    /**
     *
     * @param matrix
     * @return
     */
    public static int maximalRectangle(char[][] matrix) {
        if (matrix.length == 0) {
            return 0;
        }
        int[] heights = new int[matrix[0].length];
        int maxArea = 0;
        for (int row = 0; row < matrix.length; row++) {
            //遍历每一列，更新高度
            for (int col = 0; col < matrix[0].length; col++) {
                if (matrix[row][col] == '1') {
                    heights[col] += 1;
                } else {
                    heights[col] = 0;
                }
            }
            //调用上一题的解法，更新函数
            maxArea = Math.max(maxArea, largestRectangleArea(heights));
        }
        return maxArea;
    }

    /**
     * 股票
     * @param prices
     * @return
     */
    public int maxProfit(int prices[]) {
        int minprice = Integer.MAX_VALUE;
        int maxprofit = 0;
        for (int i = 0; i < prices.length; i++) {
            if (prices[i] < minprice) {
                minprice = prices[i];
            } else if (prices[i] - minprice > maxprofit) {
                maxprofit = prices[i] - minprice;
            }
        }
        return maxprofit;
    }

    /**
     * 找到一个数组中连续最大长度
     * @param nums
     * @return
     */
    public static int longestConsecutive(int[] nums) {
        Set<Integer> set = new HashSet<>();
        for(int i = 0;i<nums.length;i++){
            set.add(nums[i]);
        }
        int max = 0;
        for(int num:set){
            if(!set.contains(num-1)){
                int currNum = num;
                int currLength = 1;
                while(set.contains(currNum+1)){
                    currNum = currNum +1;
                    currLength = currLength+1;
                }
                max = Math.max(currLength,max);
            }
        }
        return max;
    }

    /**
     * 单词拆分
     * @param s
     * @param wordDict
     * @return
     */
    public static boolean wordBreak(String s, List<String> wordDict) {
        Set<String> wordDictSet = new HashSet(wordDict);
        boolean[] dp = new boolean[s.length() + 1];
        dp[0] = true;
        for (int i = 1; i <= s.length(); i++) {
            for (int j = 0; j < i; j++) {
                if (dp[j] && wordDictSet.contains(s.substring(j, i))) {
                    dp[i] = true;
                    break;
                }
            }
        }
        return dp[s.length()];
    }

    public static void quickSort(int[] array) {
        int len;
        if (array == null || (len = array.length) == 0 || len == 1) {
            return;
        }
        sort(array, 0, len - 1);
        System.out.println(array.toString());
    }
    /**
     * 快速排序
     * 5,4,3,2,1
     * @param array
     * @param left
     * @param right
     */
    public static void sort(int[] array, int left, int right) {
        if(left<right){
            int p1 = left;
            int p2 = right;
            int base = array[p1];
            while(p1<p2){
                if(array[p2]<base){
                    if(array[p1]>base){
                        int temp = array[p1];
                        array[p1] = array[p2];
                        array[p2]=temp;
                        p2--;
                    }else{
                        p1++;
                    }
                }else{
                    p2--;
                }
            }
            array[left]=array[p1];
            array[p1] = base;
            sort(array,left,p1-1);
            sort(array,p1+1,right);
        }
    }

    public static int findDuplicate(int[] nums) {
        int len = nums.length;
        int left = 1;
        int right = len - 1;
        while (left < right) {
            // 在 Java 里可以这么用，当 left + right 溢出的时候，无符号右移保证结果依然正确
            int mid = (left + right) >>> 1;

            int cnt = 0;
            for (int num : nums) {
                if (num <= mid) {
                    cnt += 1;
                }
            }

            // 根据抽屉原理，小于等于 4 的个数如果严格大于 4 个
            // 此时重复元素一定出现在 [1, 4] 区间里
            if (cnt > mid) {
                // 重复元素位于区间 [left, mid]
                right = mid;
            } else {
                // if 分析正确了以后，else 搜索的区间就是 if 的反面
                // [mid + 1, right]
                left = mid + 1;
            }
        }
        return left;
    }

    /**
     * 2,6,4,8,10,9,15
     *
     * 2 4 6 8 9 10 15
     * @param nums
     * @return
     */
    public int findUnsortedSubarray(int[] nums) {
        int[] snums = nums.clone();
        Arrays.sort(snums);
        int start = snums.length, end = 0;
        for (int i = 0; i < snums.length; i++) {
            if (snums[i] != nums[i]) {
                start = Math.min(start, i);//1
                end = Math.max(end, i);//5
            }
        }
        return (end - start >= 0 ? end - start + 1 : 0);
    }


    public int[] spiralOrder(int[][] matrix) {
        if(matrix.length == 0) return new int[0];
        int l = 0, r = matrix[0].length - 1, t = 0, b = matrix.length - 1, x = 0;
        int[] res = new int[(r + 1) * (b + 1)];
        while(true) {
            for(int i = l; i <= r; i++) {
                res[x++] = matrix[t][i]; // left to right.

            }
            if(++t > b) {
                break;
            }
            for(int i = t; i <= b; i++){
                res[x++] = matrix[i][r]; // top to bottom.
            }
            if(l > --r){
                break;
            }
            for(int i = r; i >= l; i--){
                res[x++] = matrix[b][i]; // right to left.
            }
            if(t > --b){
                break;
            }
            for(int i = b; i >= t; i--){
                res[x++] = matrix[i][l]; // bottom to top.
            }
            if(++l > r){
                break;
            }
        }
        return res;
    }

    public static boolean verifyPostorder(int[] postorder) {
        return recur(postorder, 0, postorder.length - 1);
    }
    static boolean  recur(int[] postorder, int i, int j) {
        if(i >= j) return true;
        int p = i;
        while(postorder[p] < postorder[j]) p++;
        int m = p;
        while(postorder[p] > postorder[j]) p++;
        return p == j && recur(postorder, i, m - 1) && recur(postorder, m, j - 1);
    }

    //为了让递归函数添加结果方便，定义到函数之外，这样无需带到递归函数的参数列表中
    static List<String> lists = new ArrayList<>();
    //同；但是其赋值依赖c，定义声明分开
    static char[] c;
    public static String[] permutation(String s) {
        c = s.toCharArray();
        //从第一层开始递归
        dfs(0);
        //将字符串数组ArrayList转化为String类型数组
        return lists.toArray(new String[lists.size()]);
    }

    private static void dfs(int x) {
        //当递归函数到达第三层，就返回，因为此时第二第三个位置已经发生了交换
        if (x == c.length - 1) {
            //将字符数组转换为字符串
            lists.add(String.valueOf(c));
            return;
        }
        //为了防止同一层递归出现重复元素
        HashSet<Character> set = new HashSet<>();
        //这里就很巧妙了,第一层可以是a,b,c那么就有三种情况，这里i = x,正巧dfs(0)，正好i = 0开始
        // 当第二层只有两种情况，dfs(1）i = 1开始
        for (int i = x; i < c.length; i++){
            //发生剪枝，当包含这个元素的时候，直接跳过
            if (set.contains(c[i])){
                continue;
            }
            set.add(c[i]);
            //交换元素，这里很是巧妙，当在第二层dfs(1),x = 1,那么i = 1或者 2， 不是交换1和1，要就是交换1和2
            swap(i,x);
            //进入下一层递归
            dfs(x + 1);
            //返回时交换回来，这样保证到达第1层的时候，一直都是abc。这里捋顺一下，开始一直都是abc，那么第一位置总共就3个交换
            //分别是a与a交换，这个就相当于 x = 0, i = 0;
            //     a与b交换            x = 0, i = 1;
            //     a与c交换            x = 0, i = 2;
            //就相当于上图中开始的三条路径
            //第一个元素固定后，每个引出两条路径,
            //     b与b交换            x = 1, i = 1;
            //     b与c交换            x = 1, i = 2;
            //所以，结合上图，在每条路径上标注上i的值，就会非常容易好理解了
            swap(i,x);
        }
    }

    private static void swap(int i, int x) {
        char temp = c[i];
        c[i] = c[x];
        c[x] = temp;
    }

    public static int[] singleNumbers(int[] nums) {
        //用于将所有的数异或起来
        int k = 0;

        for(int num: nums) {
            k ^= num;
        }

        //获得k中最低位的1
        int mask = 1;

        //mask = k & (-k) 这种方法也可以得到mask，具体原因百度 哈哈哈哈哈
        while((k & mask) == 0) {
            mask <<= 1;
        }

        int a = 0;
        int b = 0;

        for(int num: nums) {
            if((num & mask) == 0) {
                a ^= num;
            } else {
                b ^= num;
            }
        }

        return new int[]{a, b};
    }

    /**
     * 零钱兑换
     * @param coins
     * @param amount
     * @return
     */
    public static int coinChange(int[] coins, int amount) {
        int max = amount + 1;
        int[] dp = new int[amount + 1];
        Arrays.fill(dp, max);
        dp[0] = 0;
        for (int i = 1; i <= amount; i++) {
            for (int j = 0; j < coins.length; j++) {
                if (coins[j] <= i) {
                    dp[i] = Math.min(dp[i], dp[i - coins[j]] + 1);
                }
            }
        }
        return dp[amount] > amount ? -1 : dp[amount];
    }




}
