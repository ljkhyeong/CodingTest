import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.*;
import java.io.IOException;

import org.w3c.dom.Node;

class Main {

	static boolean[] alpha;
	static int r, c;
	static int[][] board;
	static int max = 0;
	static int[] dx = {0, 0, 1, -1};
	static int[] dy = {1, -1, 0, 0};

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		r = Integer.parseInt(st.nextToken());
		c = Integer.parseInt(st.nextToken());
		board = new int[r][c];
		alpha = new boolean[26];
		for (int i = 0; i < r; i++) {
			String str = br.readLine();
			for (int j = 0; j < c; j++) {
				board[i][j] = str.charAt(j) - 'A';
			}
		}

		dfs(0, 0, 1);
		System.out.println(max);
	}

	static void dfs(int x, int y, int depth) {
		alpha[board[x][y]] = true;
		max = Math.max(max, depth);

		for (int i = 0; i < 4; i++) {
			int nx = x + dx[i];
			int ny = y + dy[i];
			if (nx >= 0 && ny >= 0 && nx < r && ny < c) {
				if (!alpha[board[nx][ny]]) {

					dfs(nx,ny,depth+1);
					alpha[board[nx][ny]] = false;
				}
			}
		}
	}

}
