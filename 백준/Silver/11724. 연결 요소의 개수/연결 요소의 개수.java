import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.*;
import java.io.IOException;

class Main {

	static int[][] arr;
	static boolean[] visited;
	static int N;

	public static void main(String[] args) throws IOException {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());

		N = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());
		arr = new int[N+1][N+1];
		visited = new boolean[N + 1];

		while (M-- > 0) {
			st = new StringTokenizer(br.readLine());
			int i = Integer.parseInt(st.nextToken());
			int j = Integer.parseInt(st.nextToken());
			arr[i][j] = arr[j][i] = 1;
		}
		int count = 0;
		for (int i = 1; i <= N; i++) {
			if (!visited[i]) {
				dfs(i);
				count++;
			}
		}

		System.out.println(count);
	}

	static void dfs(int i) {
		if (visited[i]) {
			return;
		}
		visited[i] = true;
		for (int k = 1; k <= N; k++) {
			if (!visited[k] && arr[i][k]==1) {
				dfs(k);
			}
		}

	}

}
