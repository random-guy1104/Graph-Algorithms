// Java program to find number of magical
// indices in the given array.
import java.io.*;
import java.util.*;

public class GFG {

	// Function to count number of magical
	// indices.
	static int solve(int []A, int n)
	{
		int i, cnt = 0, j;
	
		// Array to store parent node of
		// traversal.
		int []parent = new int[n + 1];
	
		// Array to determine whether current node
		// is already counted in the cycle.
		int []vis = new int[n + 1];
	
		// Initialize the arrays.
		for (i = 0; i < n+1; i++) {
			parent[i] = -1;
			vis[i] = 0;
		}
			
	
		for (i = 0; i < n; i++) {
			j = i;
	
			// Check if current node is already
			// traversed or not. If node is not
			// traversed yet then parent value
			// will be -1.
			if (parent[j] == -1) {
	
				// Traverse the graph until an
				// already visited node is not
				// found.
				while (parent[j] == -1) {
					parent[j] = i;
					j = (j + A[j] + 1) % n;
				}
	
				// Check parent value to ensure
				// a cycle is present.
				if (parent[j] == i) {
	
					// Count number of nodes in
					// the cycle.
					while (vis[j]==0) {
						vis[j] = 1;
						cnt++;
						j = (j + A[j] + 1) % n;
					}
				}
			}
		}
	
		return cnt;
	}
	
	// Driver code	
	public static void main(String args[])
	{
		int []A = { 0, 0, 0, 2 };
		int n = A.length;
		System.out.print(solve(A, n));
	}
}

// This code is contributed by Manish Shaw
// (manishshaw1)
