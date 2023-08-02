//{ Driver Code Starts
// Initial Template for Java

import java.io.*;
import java.util.*;
class GFG {
    public static void main(String args[]) throws IOException {
        BufferedReader read =
            new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(read.readLine());
        while (t-- > 0) {
            int N, M, x, y;
            String S[] = read.readLine().split(" ");
            N = Integer.parseInt(S[0]);
            M = Integer.parseInt(S[1]);
            int a[][] = new int[N][M];
            for (int i = 0; i < N; i++) {
                String s[] = read.readLine().split(" ");
                for (int j = 0; j < M; j++) a[i][j] = Integer.parseInt(s[j]);
            }
            String s1[] = read.readLine().split(" ");
            x = Integer.parseInt(s1[0]);
            y = Integer.parseInt(s1[1]);
            Solution ob = new Solution();
            System.out.println(ob.shortestDistance(N, M, a, x, y));
        }
    }
}
// } Driver Code Ends


// User function Template for Java

// import java.util.LinkedList;
// import java.util.Queue;

class Solution {
    public int shortestDistance(int N, int M, int[][] A, int X, int Y) {
        // Check if the starting cell is valid (A[0][0] should be 1)
        if (A[0][0] == 0) {
            return -1;
        }
        
        // Initialize a queue for BFS
        Queue<int[]> queue = new LinkedList<>();
        queue.add(new int[]{0, 0});
        
        // Create a visited array to keep track of visited cells
        boolean[][] visited = new boolean[N][M];
        visited[0][0] = true;
        
        // Create an array to keep track of the distance from (0, 0)
        int[][] distance = new int[N][M];
        
        // Define the possible moves in the up, down, left, right direction
        int[] dx = {-1, 1, 0, 0};
        int[] dy = {0, 0, -1, 1};
        
        // BFS loop
        while (!queue.isEmpty()) {
            int[] current = queue.poll();
            int x = current[0];
            int y = current[1];
            
            // Check if we reached the destination (X, Y)
            if (x == X && y == Y) {
                return distance[X][Y];
            }
            
            // Explore the adjacent cells
            for (int i = 0; i < 4; i++) {
                int nx = x + dx[i];
                int ny = y + dy[i];
                
                // Check if the adjacent cell is valid and not visited
                if (nx >= 0 && nx < N && ny >= 0 && ny < M && A[nx][ny] == 1 && !visited[nx][ny]) {
                    visited[nx][ny] = true;
                    distance[nx][ny] = distance[x][y] + 1;
                    queue.add(new int[]{nx, ny});
                }
            }
        }
        
        // If we cannot reach the destination (X, Y)
        return -1;
    }
}
