import java.awt.*;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.math.BigDecimal;
import java.util.*;
import java.io.IOException;
import java.util.List;

class Main {

	static int[] parent;
	static int[] depth;
	static List<List<Integer>> graph;

	public static void main(String[] args) throws IOException {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());

		parent = new int[N + 1];
		depth = new int[N + 1];
		graph = new ArrayList<>();

		for (int i = 0; i < N + 1; i++) {
			graph.add(new ArrayList<>());
		}

		for (int i = 0; i < N - 1; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			int u = Integer.parseInt(st.nextToken());
			int v = Integer.parseInt(st.nextToken());
			graph.get(u).add(v);
			graph.get(v).add(u);
		}

		setTree(1, 1, 0);

		int M = Integer.parseInt(br.readLine());
		StringBuilder sb = new StringBuilder();
		for (int i = 0; i < M; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			int a = Integer.parseInt(st.nextToken());
			int b = Integer.parseInt(st.nextToken());
			sb.append(lca(a, b)).append('\n');
		}
		System.out.println(sb);
	}

	static void setTree(int cur, int h, int pa) {
		depth[cur] = h;
		parent[cur] = pa;
		for (int next : graph.get(cur)) {
			if (next == pa)
				continue;
			setTree(next, h + 1, cur);
		}
	}

	static int lca(int a, int b) {
		int ah = depth[a];
		int bh = depth[b];

		while (ah > bh) {
			a = parent[a];
			ah--;
		}
		while (bh > ah) {
			b = parent[b];
			bh--;
		}
		while (a != b) {
			a = parent[a];
			b = parent[b];
		}
		return a;
	}
}

