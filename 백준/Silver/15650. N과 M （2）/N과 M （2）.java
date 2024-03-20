import java.io.BufferedInputStream;
import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.*;
import java.io.IOException;

class Main{
	private static int N;
	private static int M;
	private static int[] arr;
	private static StringBuilder sb = new StringBuilder();

	public static void main(String[] args) throws IOException {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		StringTokenizer st = new StringTokenizer(br.readLine());

		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		arr = new int[M];

		bfs(1, 0);
		System.out.println(sb);
	}

	static void bfs(int at, int depth) {

		if (depth == M) {
			for (int value : arr) {
				sb.append(value).append(' ');
			}
			sb.append('\n');
			return;
		}

		for (int i = at; i <= N; i++) {
			arr[depth] = i;
			bfs(i + 1, depth + 1);
		}
	}

    }
