import java.awt.*;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.math.BigDecimal;
import java.util.*;
import java.io.IOException;
import java.util.List;

class Main {

	static int[][] map;
	static int N, M, count = 0;
	static int[] dc = {0, 1, 0, -1 };
	static int[] dr = {-1, 0, 1, 0};

	public static void main(String[] args) throws IOException {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());

		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		map = new int[N][M];

		st = new StringTokenizer(br.readLine());
		int r = Integer.parseInt(st.nextToken());
		int c = Integer.parseInt(st.nextToken());
		int d = Integer.parseInt(st.nextToken());

		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine());
			for (int j = 0; j < M; j++) {
				map[i][j] = Integer.parseInt(st.nextToken());
			}
		}

		clean(r, c, d);
		System.out.println(count);
	}

	static void clean(int r, int c, int d) {
		if (map[r][c] == 0) {
			map[r][c] = 2;
			count++;
		}

		boolean hasDirty = false;

		for (int i = 0; i < 4; i++) {
			int nr = r + dr[i];
			int nc = c + dc[i];

			if (nr >= 0 && nc >= 0 && nr < N && nc < M) {
				if (map[nr][nc] == 0) {
					hasDirty = true;
					break;
				}
			}
		}

		if (hasDirty) {
			d = (d + 3) % 4;
			int nr = r + dr[d];
			int nc = c + dc[d];

			if (nr >= 0 && nc >= 0 && nr < N && nc < M && map[nr][nc] == 0) {
				clean(nr, nc, d);
			} else {
				clean(r, c, d);
			}
		} else {
			int nr = r - dr[d];
			int nc = c - dc[d];

			if (nr >= 0 && nc >= 0 && nr < N && nc < M && map[nr][nc] != 1) {
				clean(nr, nc, d);
			} else {
				return;
			}
		}
	}

}

