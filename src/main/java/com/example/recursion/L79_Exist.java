package com.example.recursion;

/**
 * <p>单词搜索</p>
 * <p>给定一个 m x n 二维字符网格 board 和一个字符串单词 word 。如果 word 存在于网格中，返回 true ；否则，返回 false 。</p>
 * <p>单词必须按照字母顺序，通过相邻的单元格内的字母构成，其中“相邻”单元格是那些水平相邻或垂直相邻的单元格。同一个单元格内的字母不允许被重复使用。</p>
 */
public class L79_Exist {
    public static void main(String[] args) {

    }

    private static final int[][] DIRECTIONS = {{-1, 0}, {0, 1}, {1, 0}, {0, -1}};
    private char[][] board;
    private boolean[][] visited;
    private int rows, cols;

    /**
     * 单词长度
     */
    private int len;

    /**
     * 单词中每个字符组成的字符数组
     */
    private char[] charArray;

    public boolean exist(char[][] board, String word) {
        this.rows = board.length;
        if (this.rows == 0) {
            return false;
        }
        this.cols = board[0].length;
        this.board = board;
        this.visited = new boolean[this.rows][this.cols];
        this.len = word.length();
        this.charArray = word.toCharArray();
        for (int i = 0; i < this.rows; i++) {
            for (int j = 0; j < this.cols; j++) {
                if (dfs(i, j, 0)) {
                    return true;
                }
            }
        }
        return false;
    }

    public boolean dfs(int x, int y, int begin) {
        if (begin == this.len - 1) {
            return this.board[x][y] == this.charArray[begin];
        }
        if (this.board[x][y] == this.charArray[begin]) {
            // 置访问标记，开始考察各个方向
            this.visited[x][y] = true;
            for (int[] direction : DIRECTIONS) {
                int newX = x + direction[0];
                int newY = y + direction[1];
                if (inArea(newX, newY) && !this.visited[newX][newY]) {
                    if (dfs(newX, newY, begin + 1)) {
                        return true;
                    }
                }
            }
            // 回退
            this.visited[x][y] = false;
        }
        return false;
    }

    public boolean inArea(int x, int y) {
        return x >= 0 && x < this.rows && y >=0 && y < this.cols;
    }
}
