import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.*;
import java.io.IOException;

class Main {

	static int N;


	static char[][] arr;
	static boolean[][] isVisited;
	static int[] dx = {0, 0, 1, -1};
	static int[] dy = {1, -1, 0, 0};

	public static void main(String[] args) throws IOException {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		N = Integer.parseInt(br.readLine());
		arr = new char[N][N];
		isVisited = new boolean[N][N];
		int count = 0;

		for (int i = 0; i < N; i++) {
			String str = br.readLine();
			for (int j = 0; j < N; j++) {
				arr[i][j] = str.charAt(j);
			}
		}

		for (int i = 0; i < N; i++) {
			for (int j = 0; j < N; j++) {
				if (!isVisited[i][j]) {
					bfs(i, j);
					count++;
				}
			}
		}

		StringBuilder sb = new StringBuilder();
		sb.append(count).append(' ');

		isVisited = new boolean[N][N];
		count = 0;

		for (int i = 0; i < N; i++) {
			for (int j = 0; j < N; j++) {
				if (arr[i][j] == 'G') {
					arr[i][j] = 'R';
				}
			}
		}

		for (int i = 0; i < N; i++) {
			for (int j = 0; j < N; j++) {
				if (!isVisited[i][j]) {
					bfs(i, j);
					count++;
				}
			}
		}

		sb.append(count);

		System.out.println(sb);



	}

	static void bfs(int n, int m) {
		Queue<int[]> queue = new LinkedList<>();
		queue.add(new int[] {n, m});

		while (!queue.isEmpty()) {
			int[] current = queue.poll();
			for (int i = 0; i < 4; i++) {
				int nextN = current[0] + dy[i];
				int nextM = current[1] + dx[i];
				if (nextN >= 0 && nextM >= 0 && nextN < N && nextM < N && !isVisited[nextN][nextM]
					&& arr[current[0]][current[1]] == arr[nextN][nextM]) {
					isVisited[nextN][nextM] = true;
					queue.add(new int[] {nextN, nextM});
				}
			}
		}

	}

}
