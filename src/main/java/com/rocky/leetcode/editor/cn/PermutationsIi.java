package com.rocky.leetcode.editor.cn;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

public class PermutationsIi {
    public static void main(String[] args) {
        Solution solution = new PermutationsIi().new Solution();
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        List<List<Integer>> result = new ArrayList<>();
        LinkedList<Integer> path = new LinkedList<>();

        public List<List<Integer>> permuteUnique(int[] nums) {
            int[] vis = new int[10];
            Arrays.sort(nums);
            Arrays.fill(vis, 0);
            backTracing(nums, vis);
            return result;
        }

        public void backTracing(int[] nums, int[] vis) {
            if (path.size() == nums.length) {
                result.add(new ArrayList(path));
                return;
            }
            for (int i = 0; i < nums.length; i++) {
                if (i > 0 && nums[i] == nums[i - 1] && vis[i-1] == 0) {
                    continue;
                }
                if(vis[i]==0) {
                    path.add(nums[i]);
                    vis[i] = 1;
                    backTracing(nums, vis);
                    path.removeLast();
                    vis[i] = 0;
                }
            }
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}