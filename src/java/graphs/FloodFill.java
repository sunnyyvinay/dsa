package graphtheory;

/*
 * Floodfill is an algorithm that identifies and labels the connected component that a particular cell belongs to,
 * in a multi-dimensional array (implicit graph). It is DFS, on a grid and we want to find the connected component of all the
 * connected cells with the same number.
 *
 * When doing floodfill, we will maintain an N × M array of booleans to keep track of which squares have been visited, and a
 * global variable to maintain the size of the current component we are visiting. Make sure to store the grid, the visited
 * array, dimensions, and the current size variable globally
 */

public class FloodFill {
    static int[][] grid; // the grid itself
    static int n, m; // grid dimensions, rows and columns
    static boolean[][] visited; // keeps track of which nodes have been visited
    static int currentSize = 0; // reset to 0 each time we start a new component

    public static void main(String[] args) {
        /**
         * input code (grid) and other problem-specific stuff here
         */

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if(!visited[i][j]) {
                    currentSize = 0;
                    floodfill(i, j, grid[i][j]);
                    // start a floodfill if the square hasn't already been visited and then store or otherwise use
                    // the component size for whatever it's needed for
                }
            }
        }
    }

    static void floodfill(int r, int c, int color) {
        if(r < 0 || r >= n || c < 0 || c >= m) return; // if outside grid
        if(grid[r][c] != color) return; // wrong color
        if(visited[r][c]) return; // already visited this square
        visited[r][c] = true; // mark current square as visited
        currentSize++; // increment the size for each square we visit
        // recursively call floodfill for neighboring squares
        floodfill(r, c+1, color);
        floodfill(r, c-1, color);
        floodfill(r-1, c, color);
        floodfill(r+1, c, color);
    }
}
