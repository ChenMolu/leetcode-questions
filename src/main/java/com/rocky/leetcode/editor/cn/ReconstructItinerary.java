//给你一份航线列表 tickets ，其中 tickets[i] = [fromi, toi] 表示飞机出发和降落的机场地点。请你对该行程进行重新规划排序。
//
//
// 所有这些机票都属于一个从 JFK（肯尼迪国际机场）出发的先生，所以该行程必须从 JFK 开始。如果存在多种有效的行程，请你按字典排序返回最小的行程组合。 
//
//
// 
// 例如，行程 ["JFK", "LGA"] 与 ["JFK", "LGB"] 相比就更小，排序更靠前。 
// 
//
// 假定所有机票至少存在一种合理的行程。且所有的机票 必须都用一次 且 只能用一次。 
//
// 
//
// 示例 1： 
// 
// 
//输入：tickets = [["MUC","LHR"],["JFK","MUC"],["SFO","SJC"],["LHR","SFO"]]
//输出：["JFK","MUC","LHR","SFO","SJC"]
// 
//
// 示例 2： 
// 
// 
//输入：tickets = [["JFK","SFO"],["JFK","ATL"],["SFO","ATL"],["ATL","JFK"],["ATL",
//"SFO"]]
//输出：["JFK","ATL","JFK","SFO","ATL","SFO"]
//解释：另一种有效的行程是 ["JFK","SFO","ATL","JFK","ATL","SFO"] ，但是它字典排序更大更靠后。
// 
//
// 
//
// 提示： 
//
// 
// 1 <= tickets.length <= 300 
// tickets[i].length == 2 
// fromi.length == 3 
// toi.length == 3 
// fromi 和 toi 由大写英文字母组成 
// fromi != toi 
// 
//
// Related Topics 深度优先搜索 图 欧拉回路 👍 862 👎 0


package com.rocky.leetcode.editor.cn;

import java.util.*;

public class ReconstructItinerary {
    public static void main(String[] args) {
        Solution solution = new ReconstructItinerary().new Solution();
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        private LinkedList<String> res;
        private LinkedList<String> path = new LinkedList<>();

        public List<String> findItinerary(List<List<String>> tickets) {
            Collections.sort(tickets, (a, b) -> a.get(1).compareTo(b.get(1)));
            for (int i = 1; i < tickets.size(); i++) {
                if (tickets.get(i).get(1).equals(tickets.get(i-1).get(0))
                        && tickets.get(i).get(1).equals(tickets.get(i-1).get(1))) {
                    tickets.remove(i);
                }
            }
            path.add("JFK");
            boolean[] used = new boolean[tickets.size()];
            backTracking((ArrayList) tickets, used);
            return res;
        }

        public boolean backTracking(ArrayList<List<String>> tickets, boolean[] used) {
            if (path.size() == tickets.size() + 1) {
                res = new LinkedList(path);
                return true;
            }

            for (int i = 0; i < tickets.size(); i++) {
                if (!used[i] && tickets.get(i).get(0).equals(path.getLast())) {
                    path.add(tickets.get(i).get(1));
                    used[i] = true;
                    if (backTracking(tickets, used)) {
                        return true;
                    }
                    used[i] = false;
                    path.removeLast();
                }
            }
            return false;
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}