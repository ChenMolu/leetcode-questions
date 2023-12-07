package com.rocky.leetcode.editor.cn;

import java.util.ArrayList;
import java.util.List;

public class RestoreIpAddresses {
    public static void main(String[] args) {
        Solution solution = new RestoreIpAddresses().new Solution();
        solution.restoreIpAddresses("101023");
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        List<String> result = new ArrayList<>();
        StringBuilder sb = new StringBuilder();

        public List<String> restoreIpAddresses(String s) {
            backTracing(s, 0, 0);
            return result;
        }

        public void backTracing(String s, int startIndex, int num) {
            if (startIndex >= s.length() && num == 4) {
                result.add(sb.toString());
                return;
            }
            if (startIndex == s.length() || num == 4) {
                return;
            }

            for (int i = startIndex; i < s.length() && i - startIndex < 3
                    && Integer.parseInt(s.substring(startIndex, i + 1)) >= 0
                    && Integer.parseInt(s.substring(startIndex, i + 1)) <= 255; i++) {
                if (i + 1 - startIndex > 1 && s.charAt(startIndex) == '0') {
                    break;
                }
                sb.append(s.substring(startIndex, i + 1));
                if (num < 3) {
                    sb.append(".");
                }
                backTracing(s, i + 1, num + 1);
                sb.delete(startIndex + num, i + num + 2);
            }
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}