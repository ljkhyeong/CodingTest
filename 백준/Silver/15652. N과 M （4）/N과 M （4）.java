import java.io.BufferedInputStream;
import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.*;
import java.io.IOException;

class Main{

	private static StringBuilder sb = new StringBuilder();
	private static int N, M;
	private static int[] arr;

	public static void main(String[] args) throws IOException {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		arr = new int[M];

		dfs(1,0);
		System.out.println(sb);

	}

	private static void dfs(int at, int depth) {
		if (depth == M) {
			for (int value : arr) {
				sb.append(value).append(' ');
			}
			sb.append('\n');
			return;
		}

		for (int i = at; i <= N; i++) {
			arr[depth] = i;
			dfs(i,depth+1);
		}
	}

}
