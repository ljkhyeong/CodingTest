import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.*;
import java.io.IOException;


class Main {

	static int[][] map;
	static boolean[][] visited;
	static int[] dx = {0, 0, 1, -1};
	static int[] dy = {1, -1, 0, 0};
	static int N, M, cheeseCnt;
	static ArrayList<Point> cheeses;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());

		map = new int[N][M];
		cheeses = new ArrayList<>();

		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine());
			for (int j = 0; j < M; j++) {
				map[i][j] = Integer.parseInt(st.nextToken());
				if (map[i][j] == 1) {
					cheeses.add(new Point(i,j));
					cheeseCnt++;
				}
			}
		}

		int time = 0;

		while (cheeseCnt!=0) {
			visited = new boolean[N][M];
			bfs();
			melt();
			time++;
		}

		System.out.println(time);
	}

	static void bfs() {
		Queue<Point> queue = new LinkedList<>();
		queue.offer(new Point(0,0));
		visited[0][0] = true;
		map[0][0] = 2;

		while (!queue.isEmpty()) {
			Point cur = queue.poll();
			for (int i = 0; i < 4; i++) {
				int nx = cur.x + dx[i];
				int ny = cur.y + dy[i];

				if (nx >= 0 && ny >= 0 && nx < N && ny < M && !visited[nx][ny] && map[nx][ny] != 1) {
					map[nx][ny] = 2;
					visited[nx][ny] = true;
					queue.offer(new Point(nx,ny));
				}
			}
		}
	}

	static void melt() {
		for (int j = 0; j < cheeses.size(); j++) {
			int x = cheeses.get(j).x;
			int y = cheeses.get(j).y;
			int cnt = 0;

			for (int i = 0; i < 4; i++) {
				int nx = x + dx[i];
				int ny = y + dy[i];

				if (map[nx][ny] == 2) {
					cnt++;
				}
			}

			if (cnt > 1) {
				map[x][y] = 0;
				cheeseCnt--;
				cheeses.remove(j);
				j--;
			}
		}
	}

	static class Point {
		int x;
		int y;

		public Point(int x, int y) {
			this.x = x;
			this.y = y;
		}
	}
}
