import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.*;
import java.io.IOException;


class Main {



	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.parseInt(br.readLine());
		int[][] board = new int[n + 1][3];
		int[][] maxDp = new int[n + 1][3];
		int[][] minDp = new int[n + 1][3];
		int min = Integer.MAX_VALUE;
		int max = Integer.MIN_VALUE;

		for (int i = 1; i <= n; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			board[i][0] = Integer.parseInt(st.nextToken());
			board[i][1] = Integer.parseInt(st.nextToken());
			board[i][2] = Integer.parseInt(st.nextToken());
		}

		for (int i = 1; i <= n; i++) {
			maxDp[i][0] += Math.max(maxDp[i - 1][0], maxDp[i - 1][1]) + board[i][0];
			maxDp[i][1] += Math.max(Math.max(maxDp[i - 1][0], maxDp[i - 1][1]), maxDp[i - 1][2]) + board[i][1];
			maxDp[i][2] += Math.max(maxDp[i - 1][1], maxDp[i - 1][2]) + board[i][2];

			minDp[i][0] += Math.min(minDp[i - 1][0], minDp[i - 1][1]) + board[i][0];
			minDp[i][1] += Math.min(Math.min(minDp[i - 1][0], minDp[i - 1][1]), minDp[i - 1][2]) + board[i][1];
			minDp[i][2] += Math.min(minDp[i - 1][1], minDp[i - 1][2]) + board[i][2];
		}

		for (int i = 0; i < 3; i++) {
			max = Math.max(max, maxDp[n][i]);
			min = Math.min(min, minDp[n][i]);
		}

		System.out.println(max + " " + min);
	}


}
