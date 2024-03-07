import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.*;
import java.io.IOException;

class Main {

	static int[][] map;
	static int n, m;


	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		n = Integer.parseInt(st.nextToken());
		m = Integer.parseInt(st.nextToken());
		map = new int[n][m];

		for (int i = 0; i < n; i++) {
			String str = br.readLine();
			for (int j = 0; j < m; j++) {
				map[i][j] = str.charAt(j)-'0';
			}
		}

		if (n == 1 && m == 1) {
			System.out.println(1);
		} else {
			System.out.println(bfs());
		}

	}

	static int bfs() {
		int[][][] check = new int[2][n][m];
		Queue<int[]> queue = new LinkedList<>();

		int[] dx = {0, 0, 1, -1};
		int[] dy = {-1, 1, 0, 0};

		queue.offer(new int[] {0, 0, 0});
		check[0][0][0] = 1;

		while (!queue.isEmpty()) {
			int[] current = queue.poll();
			int w = current[0];
			int x = current[1];
			int y = current[2];

			for (int i = 0; i < 4; i++) {
				int nx = x + dx[i];
				int ny = y + dy[i];

				if (nx < 0 || ny < 0 || nx >= n || ny >= m) {
					continue;
				}

				if (map[nx][ny] == 0) {
					if (check[w][nx][ny] == 0) {
						queue.offer(new int[] {w, nx, ny});
						check[w][nx][ny] = check[w][x][y] + 1;
						if (nx == n - 1 && ny == m - 1) {
							return check[w][nx][ny];
						}
					}
				} else {
					if (w == 0) {
						if (check[w][nx][ny] == 0) {
							queue.offer(new int[] {1, nx, ny});
							check[1][nx][ny] = check[0][x][y] + 1;
							if (nx == n - 1 && ny == m - 1) {
								return check[1][nx][ny];
							}
						}


					}
				}
			}
		}

		return -1;
	}



}
