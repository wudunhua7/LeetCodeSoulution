package com.leetcode.backtrack;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.TreeMap;

/**
 * n 皇后问题研究的是如何将 n 个皇后放置在 n×n 的棋盘上，并且使皇后彼此之间不能相互攻击。

 上图为 8 皇后问题的一种解法。

 给定一个整数 n，返回所有不同的 n 皇后问题的解决方案。

 每一种解法包含一个明确的 n 皇后问题的棋子放置方案，该方案中 'Q' 和 '.' 分别代表了皇后和空位。

 示例:

 输入: 4
 输出: [
 [".Q..",  // 解法 1
 "...Q",
 "Q...",
 "..Q."],

 ["..Q.",  // 解法 2
 "Q...",
 "...Q",
 ".Q.."]
 ]
 解释: 4 皇后问题存在两个不同的解法。

 */
public class Nquenen {

    public int n;
    public int[] quenens;
    public int[] cols;
    public int[] zdjxs;
    public int[] cdjxs;
    public List<List<String>> results;

    public List<List<String>> solveNQueens(int n) {
        this.n = n;
        quenens = new int[n];
        cols = new int[n];
        zdjxs = new int[2 * n + 1];
        cdjxs = new int[2 * n + 1];
        results = new ArrayList<List<String>>();
        backtrack(0);

        return results;
    }

    public void backtrack(int row) {
        TreeMap<Integer, List<Integer>> integerListTreeMap = new TreeMap<>(new Comparator<Integer>() {
            @Override
            public int compare(Integer o1, Integer o2) {
                return 0;
            }
        });
        for (List<Integer> value:integerListTreeMap.values()){


        }
        for (int col = 0; col < n; col++) {
            if (isNotUnderAttack(row, col)) {
                putQuenen(row, col);
                if (row + 1 == n) {
                    putResult();
                }
                backtrack(row + 1);
                removeQuenen(row, col);
            }
        }
    }

    public void putResult() {
        List<String> result = new ArrayList();

        for (int i = 0; i < n; i++) {
            StringBuilder sb = new StringBuilder();
            int col = quenens[i];
            for (int j = 0; j < col; j++) {
                sb.append(".");
            }
            sb.append("Q");
            for (int j = 0; j < n - col - 1; j++) {
                sb.append(".");
            }
            result.add(sb.toString());
        }
        results.add(result);

    }

    public void removeQuenen(int row, int col) {
        quenens[row] = 0;

        cols[col] = 0;
        cdjxs[row - col + n] = 0;
        zdjxs[row + col] = 0;
    }

    public void putQuenen(int row, int col) {
        quenens[row] = col;

        cols[col] = 1;
        cdjxs[row - col + n] = 1;
        zdjxs[row + col] = 1;
    }

    public boolean isNotUnderAttack(int row, int col) {
        int attack = cols[col] + cdjxs[row - col + n] + zdjxs[row + col];
        return attack == 0 ? true : false;
    }


}
