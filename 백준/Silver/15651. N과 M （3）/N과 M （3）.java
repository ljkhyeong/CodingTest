import java.io.BufferedInputStream;
import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.*;
import java.io.IOException;

class Main{

	private static StringBuilder sb = new StringBuilder();

	public static void main(String[] args) throws IOException {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int N = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());
		int[] arr = new int[M];

		dfs(N, M, 0, arr);
		System.out.println(sb);

	}

	private static void dfs(int N, int M, int depth, int[] arr) {
		if (depth == M) {
			for (int i = 0; i < M; i++) {
				sb.append(arr[i]).append(' ');
			}
			sb.append('\n');
			return;
		}

		for (int i = 0; i < N; i++) {
			arr[depth] = i + 1;
			dfs(N,M,depth+1,arr);
		}
	}
}
