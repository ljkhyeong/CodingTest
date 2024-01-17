import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.*;
import java.io.IOException;

class Main{

	static int[][] field;
	static boolean[][] visited;
	static int[] dx = {0, 0, 1, -1};
	static int[] dy = {1, -1, 0, 0};
	static int N,M, K;

	public static void main(String[] args) throws IOException {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();

		int T = Integer.parseInt(br.readLine());

		while (T-- > 0) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			M = Integer.parseInt(st.nextToken());
			N = Integer.parseInt(st.nextToken());
			K = Integer.parseInt(st.nextToken());
			field = new int[N][M];
			visited = new boolean[N][M];
			int count = 0;

			while (K-- > 0) {
				st = new StringTokenizer(br.readLine());
				int x = Integer.parseInt(st.nextToken());
				int y = Integer.parseInt(st.nextToken());
				field[y][x] = 1;
			}

			for (int i = 0; i < N; i++) {
				for (int j = 0; j < M; j++) {
					if (field[i][j] == 1 && !visited[i][j]) {
						count++;
						bfs(j, i);
					}
				}
			}

			sb.append(count).append('\n');
		}

		System.out.println(sb);

	}

	public static void bfs(int x, int y) {
		Queue<int[]> queue = new LinkedList<>();
		queue.add(new int[] {x, y});

		while (!queue.isEmpty()) {
			int[] temp = queue.poll();
			int currentX = temp[0];
			int currentY = temp[1];
			visited[currentY][currentX] = true;

			for (int i = 0; i < 4; i++) {
				int nextX = currentX + dx[i];
				int nextY = currentY + dy[i];

				if (inRange(nextX, nextY) && !visited[nextY][nextX] && field[nextY][nextX] == 1) {
					queue.add(new int[] {nextX, nextY});
					visited[nextY][nextX] = true;
				}
			}
		}
	}

	private static boolean inRange(int x, int y) {
		if (x >= 0 && y >= 0 && x < M && y < N) {
			return true;
		}
		return false;
	}


}
