package com.example.recursion;

/**
 * <p>单词搜索</p>
 * <p>给定一个 m x n 二维字符网格 board 和一个字符串单词 word 。如果 word 存在于网格中，返回 true ；否则，返回 false 。</p>
 * <p>单词必须按照字母顺序，通过相邻的单元格内的字母构成，其中“相邻”单元格是那些水平相邻或垂直相邻的单元格。同一个单元格内的字母不允许被重复使用。</p>
 */
public class L79_Exist {
    public static void main(String[] args) {
        char [][] board = {
                {'A', 'B', 'C', 'E'},
                {'S', 'F', 'C', 'S'},
                {'A', 'D', 'E', 'E'}
        };
        String word = "ABCCED";
        System.out.println(existPro(board, word));
    }

    private static boolean existPro(char[][] board, String word) {
        int rows = board.length, cols = board[0].length;
        boolean[][] visited = new boolean[rows][cols];
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                if (exist(board, word, 0, visited, i, j)) {
                    return true;
                }
            }
        }
        return false;
    }

    private static boolean exist(char[][] board, String word,
                                 int index, boolean[][] visited,
                                 int row, int col) {
        if (index == word.length() - 1 && board[row][col] == word.charAt(index)) {
            return true;
        }
        if (board[row][col] == word.charAt(index)) {
            visited[row][col] = true;
            for (int[] direction : DIRECTIONS) {
                int newRow = row + direction[0];
                int newCol = col + direction[1];
                if (inArea(board, newRow, newCol) && !visited[newRow][newCol]) {
                    if (exist(board, word, index + 1, visited, newRow, newCol)) {
                        return true;
                    }
                }
            }
            visited[row][col] = false;
        }
        return false;
    }

    private static boolean inArea(char[][] board, int x, int y) {
        return x >= 0 && x < board.length && y >= 0 && y < board[0].length;
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

    /**
     * 时间复杂度：O(mn * 3^k), 其中 k 为单词长度
     * 空间复杂度：O(mn)
     */
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
