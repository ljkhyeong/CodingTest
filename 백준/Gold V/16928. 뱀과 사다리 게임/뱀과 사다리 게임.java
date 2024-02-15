import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.*;
import java.io.IOException;

class Main {

	static int[] board = new int[101];
	static int[] visited = new int[101];

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int N = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());

		for (int i = 1; i < 101; i++) {
			board[i] = i;
		}

		while (N-- > 0) {
			st = new StringTokenizer(br.readLine());
			int x = Integer.parseInt(st.nextToken());
			int y = Integer.parseInt(st.nextToken());
			board[x] = y;
		}

		while (M-- > 0) {
			st = new StringTokenizer(br.readLine());
			int x = Integer.parseInt(st.nextToken());
			int y = Integer.parseInt(st.nextToken());
			board[x] = y;
		}

		int result = bfs(1);
		System.out.println(result);

	}

	public static int bfs(int start) {
		Queue<Integer> queue = new LinkedList<>();
		queue.offer(start);
		visited[start] = 0;

		while (!queue.isEmpty()) {
			int current = queue.poll();

			for (int i = 1; i < 7; i++) {
				int next = current + i;

				if (next > 100) {
					break;
				}

				if (visited[board[next]] == 0) {
					queue.offer(board[next]);
					visited[board[next]] = visited[current] + 1;
				}

				if (board[next] == 100) {
					return visited[100];
				}
			}
		}

		return -1;
	}


}
