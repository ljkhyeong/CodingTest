import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.*;
import java.io.IOException;

class Main {

	static int[][] arr;
	static boolean[][] isVisited;
	static int N, M;
	static int[] dx = {0, 0, -1, 1};
	static int[] dy = {1, -1, 0, 0};
	static int max = Integer.MIN_VALUE;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		arr = new int[N][M];
		isVisited = new boolean[N][M];

		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine());
			for (int j = 0; j < M; j++) {
				arr[i][j] = Integer.parseInt(st.nextToken());
			}
		}

		for (int i = 0; i < N; i++) {
			for (int j = 0; j < M; j++) {
				isVisited[i][j] = true;
				dfs(i, j, arr[i][j], 1);
				isVisited[i][j] = false;
			}
		}

		System.out.println(max);
	}

	static void dfs(int row, int col, int sum, int depth) {

		if (depth == 4) {
			max = Math.max(max, sum);
			return;
		}

		for (int k = 0; k < 4; k++) {
			int nextRow = row + dx[k];
			int nextCol = col + dy[k];
			if (nextRow >= 0 && nextCol >= 0 && nextRow < N && nextCol < M && !isVisited[nextRow][nextCol]) {

				if (depth == 2) {
					isVisited[nextRow][nextCol] = true;
					dfs(row, col, sum + arr[nextRow][nextCol], depth + 1);
					isVisited[nextRow][nextCol] = false;
				}

				isVisited[nextRow][nextCol] = true;
				dfs(nextRow, nextCol, sum + arr[nextRow][nextCol], depth + 1);
				isVisited[nextRow][nextCol] = false;
			}

		}
	}

}
