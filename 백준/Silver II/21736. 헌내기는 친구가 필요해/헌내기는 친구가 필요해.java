import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.*;
import java.io.IOException;

class Main {

	static char[][] campus;
	static boolean[][] visited;

	static int[] dx = {0, 0, 1, -1};
	static int[] dy = {1, -1, 0, 0};
	static int n, m;


	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		n = Integer.parseInt(st.nextToken());
		m = Integer.parseInt(st.nextToken());

		campus = new char[n][m];
		visited = new boolean[n][m];

		int x =0 ,y = 0;
		for (int i = 0; i < n; i++) {
			String str = br.readLine();
			for (int j = 0; j < m; j++) {
				if (str.charAt(j) == 'I') {
					x = i;
					y = j;
				}
				campus[i][j] = str.charAt(j);
			}
		}

		int count = bfs(x, y);
		
		if (count == 0) {
			System.out.println("TT");
		} else {
			System.out.println(count);
		}
	}

	static int bfs(int x, int y) {
		Queue<int[]> queue = new LinkedList<>();
		queue.offer(new int[] {x, y});
		visited[x][y] = true;
		int count = 0;
		while (!queue.isEmpty()) {
			int[] current = queue.poll();

			for (int i = 0; i < 4; i++) {
				int nextX = current[0] + dx[i];
				int nextY = current[1] + dy[i];
				if (nextX >= 0 && nextY >= 0 && nextX < n && nextY < m && !visited[nextX][nextY] && campus[nextX][nextY]!='X') {
					if (campus[nextX][nextY] == 'P') {
						count++;
					}
					queue.offer(new int[] {nextX, nextY});
					visited[nextX][nextY] = true;
				}
			}
		}

		return count;
	}

}
