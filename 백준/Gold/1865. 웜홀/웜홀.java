import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.*;
import java.io.IOException;

import org.w3c.dom.Node;

class Main {

	static class Node {
		int end;
		int weight;

		public Node(int end, int weight) {
			this.end = end;
			this.weight = weight;
		}
	}


	static int[] dist;
	static List<List<Node>> list;
	static final int INF = Integer.MAX_VALUE / 100;
	static int N, M, W;


	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		int TC = Integer.parseInt(br.readLine());

		while (TC-- > 0) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			N = Integer.parseInt(st.nextToken());
			M = Integer.parseInt(st.nextToken());
			W = Integer.parseInt(st.nextToken());

			dist = new int[N + 1];
			list = new ArrayList<>();

			for (int i = 0; i <= N; i++) {
				list.add(new ArrayList<>());
			}

			for (int i = 0; i < M; i++) {
				st = new StringTokenizer(br.readLine());
				int S = Integer.parseInt(st.nextToken());
				int E = Integer.parseInt(st.nextToken());
				int T = Integer.parseInt(st.nextToken());

				list.get(S).add(new Node(E, T));
				list.get(E).add(new Node(S, T));
			}

			for (int i = 0; i < W; i++) {
				st = new StringTokenizer(br.readLine());
				int S = Integer.parseInt(st.nextToken());
				int E = Integer.parseInt(st.nextToken());
				int T = Integer.parseInt(st.nextToken());

				list.get(S).add(new Node(E, -T));
			}

			sb.append(bellmanFord() ? "YES\n" : "NO\n");
		}

		System.out.println(sb);
	}

	public static boolean bellmanFord() {
		Arrays.fill(dist, INF);
		dist[1] = 0;
		boolean update = false;

		for (int i = 1; i < N; i++) {
			update = false;

			for (int j = 1; j <= N; j++) {
				for (Node node : list.get(j)) {
					if (dist[node.end] > dist[j] + node.weight) {
						dist[node.end] = dist[j] + node.weight;
						update = true;
					}
				}
			}

			if (!update) {
				break;
			}
		}

		if (update) {
			for (int i = 1; i <= N; i++) {
				for (Node node : list.get(i)) {
					if (dist[node.end] > dist[i] + node.weight) {
						return true;
					}
				}
			}
		}

		return false;
	}


}
