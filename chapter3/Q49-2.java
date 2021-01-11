import java.util.*;
class Solution {
    private static final int MAX_MOVES = 2;
    private static int m, n;
    private static int[] rowCounts;
    private static int[] columnCounts;
    private static int maxDistance = 0;
    private static List<Character> moves = new ArrayList<Character>();
    private static List<Character> maxMoves;
    public static void main(String[] args) {
        m = 5;
        n = 6;
        System.out.println(maximumDistance(m,n));
    }
    public static int maximumDistance(int m, int n) {
        rowCounts = new int[m + 1];
        columnCounts = new int[n + 1];
        backtrack(0, 0, 0);
        System.out.println(maxMoves);
        return maxDistance;
    }

    public static void backtrack(int row, int column, int distance) {
        if (row == m && column == n) {
            if (distance > maxDistance) {
                maxDistance = distance;
                maxMoves = new ArrayList<Character>(moves);
            }
        } else {
            if (row > 0 && columnCounts[column] < MAX_MOVES) {
                columnCounts[column]++;
                moves.add('U');
                backtrack(row - 1, column, distance + 1);
                columnCounts[column]--;
                moves.remove(moves.size() - 1);
            }
            if (row < m && columnCounts[column] < MAX_MOVES) {
                columnCounts[column]++;
                moves.add('D');
                backtrack(row + 1, column, distance + 1);
                columnCounts[column]--;
                moves.remove(moves.size() - 1);
            }
            if (column > 0 && rowCounts[row] < MAX_MOVES) {
                rowCounts[row]++;
                moves.add('L');
                backtrack(row, column - 1, distance + 1);
                rowCounts[row]--;
                moves.remove(moves.size() - 1);
            }
            if (column < n && rowCounts[row] < MAX_MOVES) {
                rowCounts[row]++;
                moves.add('R');
                backtrack(row, column + 1, distance + 1);
                rowCounts[row]--;
                moves.remove(moves.size() - 1);
            }
        }
    }
}