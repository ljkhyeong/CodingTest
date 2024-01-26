import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.*;
import java.io.IOException;

class Main {


	static int N;
	static int[][] arr;
	static boolean[][] isVisited;
	static int danji = 0;
	static int[] dx = {0, 0, 1, -1};
	static int[] dy = {1, -1, 0, 0};

	public static void main(String[] args) throws IOException {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		List<Integer> countList = new ArrayList<>();
		N = Integer.parseInt(br.readLine());

		arr = new int[N][N];
		isVisited = new boolean[N][N];

		for (int i = 0; i < N; i++) {
			String str = br.readLine();
			for (int j = 0; j < N; j++) {
				arr[i][j] = str.charAt(j) - '0';
			}
		}

		for (int i = 0; i < N; i++) {
			for (int j = 0; j < N; j++) {
				if (arr[i][j] == 1 && !isVisited[i][j]) {
					countList.add(bfs(i, j));
					danji++;
				}
			}
		}

		Collections.sort(countList);
		sb.append(danji).append('\n');
		for (Integer i : countList) {
			sb.append(i).append('\n');
		}

		System.out.println(sb);
	}

	public static int bfs(int x, int y) {
		Queue<int[]> queue = new LinkedList();
		int count = 1;
		queue.add(new int[] {x, y});
		isVisited[x][y] = true;

		while (!queue.isEmpty()) {
			int[] n = queue.poll();

			for (int k = 0; k < 4; k++) {
				int nextX = n[0] + dx[k];
				int nextY = n[1] + dy[k];
				if (nextX >= 0 && nextX < N && nextY >= 0 && nextY < N && !isVisited[nextX][nextY]
					&& arr[nextX][nextY] == 1) {
					queue.add(new int[] {nextX, nextY});
					isVisited[nextX][nextY] = true;
					count++;
				}
			}
		}

		return count;
	}




}
