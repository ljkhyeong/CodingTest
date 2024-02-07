import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.*;
import java.io.IOException;

class Main {

	static int[][] arr;
	static boolean[][] isVisited;
	static int[][] result;
	static int[] dx = {0, 0, 1, -1};
	static int[] dy = {1, -1, 0, 0};

	static int n, m;

	public static void main(String[] args) throws IOException {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		n = Integer.parseInt(st.nextToken());
		m = Integer.parseInt(st.nextToken());

		arr = new int[n][m];
		result = new int[n][m];
		isVisited = new boolean[n][m];

		int x = 0, y = 0;
		for (int i = 0; i < n; i++) {
			st = new StringTokenizer(br.readLine());
			for (int j = 0; j < m; j++) {
				arr[i][j] = Integer.parseInt(st.nextToken());
				if (arr[i][j] == 2) {
					x = i;
					y = j;
					isVisited[i][j] = true;
				}
				if (arr[i][j] == 0) {
					isVisited[i][j] = true;
				}
			}
		}

		bfs(x, y);
		StringBuilder sb = new StringBuilder();

		for (int i = 0; i < n; i++) {
			for (int j = 0; j < m; j++) {
				if (!isVisited[i][j]) {
					result[i][j] = -1;
				}
				sb.append(result[i][j]).append(' ');
			}
			sb.append('\n');
		}
		System.out.println(sb);

	}

	static void bfs(int x, int y) {
		Queue<int[]> queue = new LinkedList<>();
		queue.add(new int[] {x, y});

		while (!queue.isEmpty()) {
			int[] current = queue.poll();
			for (int i = 0; i < 4; i++) {
				int nextN = current[0] + dy[i];
				int nextM = current[1] + dx[i];
				if (nextN >= 0 && nextM >= 0 && nextN < n && nextM < m && !isVisited[nextN][nextM]
					&& arr[nextN][nextM]==1) {
					isVisited[nextN][nextM] = true;
					result[nextN][nextM] = result[current[0]][current[1]] + 1;
					queue.add(new int[] {nextN, nextM});
				}
			}
		}

	}

}
