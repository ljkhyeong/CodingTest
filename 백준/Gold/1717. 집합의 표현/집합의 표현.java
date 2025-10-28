import java.awt.*;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.math.BigDecimal;
import java.util.*;
import java.io.IOException;
import java.util.List;

class Main {
	static int N, M;
	static int[] parent;

	static int find(int n) {
		if (parent[n] == n) return n;
		return parent[n] = find(parent[n]);
	}

	static boolean union(int a, int b) {
		a = find(a);
		b = find(b);
		if (a==b) return false;
		parent[b] = a;
		return true;
	}

	public static void main(String[] args) throws IOException {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());

		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		parent = new int[N+1];
		for (int i = 1; i < N + 1; i++) {
			parent[i] = i;
		}

		StringBuilder sb = new StringBuilder();
		for (int i = 0; i < M; i++) {
			st = new StringTokenizer(br.readLine());
			int op = Integer.parseInt(st.nextToken());
			int a = Integer.parseInt(st.nextToken());
			int b = Integer.parseInt(st.nextToken());
			if (op == 0) {
				union(a, b);
			}
			if (op == 1) {
				if (find(a) == find(b))
					sb.append("YES").append('\n');
				else
					sb.append("NO").append('\n');
			}
		}

		System.out.println(sb);
	}





}

