import java.awt.*;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.*;
import java.io.IOException;
import java.util.List;

class Main {

	static int N, M;
	static StringBuilder sb = new StringBuilder();
	static int[] arr, comb;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());

		arr = new int[N];
		comb = new int[M];

		st = new StringTokenizer(br.readLine());
		for (int i = 0; i < N; i++) {
			arr[i] = Integer.parseInt(st.nextToken());
		}

		Arrays.sort(arr);

		dfs(0, 0);

		System.out.println(sb);
	}

	static void dfs(int start, int depth) {
		if (depth == M) {
			for (int i = 0; i < M; i++) {
				sb.append(comb[i]).append(' ');
			}
			sb.append('\n');
			return;
		}

		for (int i = start; i < N; i++) {
			comb[depth] = arr[i];
			dfs(i, depth+1);
		}
	}








}
