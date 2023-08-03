//{ Driver Code Starts
import java.util.*;
import java.lang.*;
import java.io.*;

class Main {
	public static void main(String[] args) throws IOException {
		Scanner sc = new Scanner(System.in);
		int T = sc.nextInt();
		while (T-- > 0) {
			int n = sc.nextInt();
			int m = sc.nextInt();
			int[][] edge = new int[m][3];
			for (int i = 0; i < m; i++) {
				edge[i][0] = sc.nextInt();
				edge[i][1] = sc.nextInt();
				edge[i][2] = sc.nextInt();
			}
			Solution obj = new Solution();
			int res[] = obj.shortestPath(n, m,edge);
			for (int i = 0; i < n; i++) {
				System.out.print(res[i] + " ");
			}
			System.out.println();
		}
	}
}
// } Driver Code Ends



class Solution {

    public int[] shortestPath(int N, int M, int[][] edges) {
        // Create the adjacency list to represent the graph
        List<List<int[]>> adjList = new ArrayList<>();
        for (int i = 0; i < N; i++) {
            adjList.add(new ArrayList<>());
        }
        for (int[] edge : edges) {
            int u = edge[0];
            int v = edge[1];
            int w = edge[2];
            adjList.get(u).add(new int[]{v, w});
        }

        // Initialize the distance array
        int[] distance = new int[N];
        Arrays.fill(distance, Integer.MAX_VALUE);
        distance[0] = 0;

        // Perform Topological Sorting
        Stack<Integer> stack = new Stack<>();
        boolean[] visited = new boolean[N];
        for (int i = 0; i < N; i++) {
            if (!visited[i]) {
                topologicalSort(i, adjList, visited, stack);
            }
        }

        // Process vertices in the sorted order and update shortest distances
        while (!stack.isEmpty()) {
            int u = stack.pop();
            if (distance[u] != Integer.MAX_VALUE) {
                for (int[] neighbor : adjList.get(u)) {
                    int v = neighbor[0];
                    int w = neighbor[1];
                    if (distance[u] + w < distance[v]) {
                        distance[v] = distance[u] + w;
                    }
                }
            }
        }

        // Convert the distance array to -1 where no path exists
        for (int i = 0; i < N; i++) {
            if (distance[i] == Integer.MAX_VALUE) {
                distance[i] = -1;
            }
        }

        return distance;
    }

    // Helper function to perform Topological Sorting
    private void topologicalSort(int u, List<List<int[]>> adjList, boolean[] visited, Stack<Integer> stack) {
        visited[u] = true;
        for (int[] neighbor : adjList.get(u)) {
            int v = neighbor[0];
            if (!visited[v]) {
                topologicalSort(v, adjList, visited, stack);
            }
        }
        stack.push(u);
    }
}
