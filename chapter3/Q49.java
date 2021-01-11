class Solution {
    private static final int MAX_MOVES = 2;
    private static int m, n;
    private static int[] rowCounts;
    private static int[] columnCounts;
    private static int maxDistance = 0;
    public static void main(String[] args) {
        m = 5;
        n = 6;
        System.out.println(maximumDistance(m,n));
    }
    public static int maximumDistance(int m, int n) {
        rowCounts = new int[m + 1];
        columnCounts = new int[n + 1];
        backtrack(0, 0, 0);
        return maxDistance;
    }

    public static void backtrack(int row, int column, int distance) {
        if (row == m && column == n) {
            maxDistance = Math.max(maxDistance, distance);
        } else {
            if (row > 0 && columnCounts[column] < MAX_MOVES) {
                columnCounts[column]++;
                backtrack(row - 1, column, distance + 1);
                columnCounts[column]--;
            }
            if (row < m && columnCounts[column] < MAX_MOVES) {
                columnCounts[column]++;
                backtrack(row + 1, column, distance + 1);
                columnCounts[column]--;
            }
            if (column > 0 && rowCounts[row] < MAX_MOVES) {
                rowCounts[row]++;
                backtrack(row, column - 1, distance + 1);
                rowCounts[row]--;
            }
            if (column < n && rowCounts[row] < MAX_MOVES) {
                rowCounts[row]++;
                backtrack(row, column + 1, distance + 1);
                rowCounts[row]--;
            }
        }
    }
}

