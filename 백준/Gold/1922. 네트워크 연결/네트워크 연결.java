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

	static class Edge {
		int u, v, w;

		Edge(int u, int v, int w) {
			this.u = u; this.v = v; this.w = w;
		}
	}

	public static void main(String[] args) throws IOException {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		N = Integer.parseInt(br.readLine());
		M = Integer.parseInt(br.readLine());
		parent = new int[N+1];
		for (int i = 1; i < N + 1; i++) {
			parent[i] = i;
		}

		Edge[] edges = new Edge[M];

		for (int i = 0; i < M; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			int u = Integer.parseInt(st.nextToken());
			int v = Integer.parseInt(st.nextToken());
			int w = Integer.parseInt(st.nextToken());

			edges[i] = new Edge(u, v, w);
		}

		Arrays.sort(edges, (a, b) -> Integer.compare(a.w, b.w));

		int cnt = 0;
		int ans = 0;
		for (Edge edge : edges) {
			if (union(edge.u, edge.v)) {
				ans += edge.w;
				if (++cnt == N-1) break;
			}
		}
		System.out.println(ans);
	}





}

