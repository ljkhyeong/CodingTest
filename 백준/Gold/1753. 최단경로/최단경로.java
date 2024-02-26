import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.*;
import java.io.IOException;

class Main {

	static class Node implements Comparable<Node> {
		int end;
		int weight;

		public Node(int end, int weight) {
			this.end = end;
			this.weight = weight;
		}

		@Override
		public int compareTo(Node o) {
			return weight - o.weight;
		}
	}

	static int[] dist;
	static List<List<Node>> list;
	static final int INF = Integer.MAX_VALUE / 10;
	static int V, E, K;


	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());

		V = Integer.parseInt(st.nextToken());
		E = Integer.parseInt(st.nextToken());
		K = Integer.parseInt(br.readLine());

		dist = new int[V + 1];
		Arrays.fill(dist, INF);
		list = new ArrayList<>();

		for (int i = 0; i <= V; i++) {
			list.add(new ArrayList<>());
		}

		for (int i = 0; i < E; i++) {
			st = new StringTokenizer(br.readLine());

			int u = Integer.parseInt(st.nextToken());
			int v = Integer.parseInt(st.nextToken());
			int w = Integer.parseInt(st.nextToken());

			list.get(u).add(new Node(v, w));
		}

		dijkstra(K);

		StringBuilder sb = new StringBuilder();
		for (int i = 1; i <= V; i++) {

			if (dist[i] == INF) {
				sb.append("INF\n");
				continue;
			}

			sb.append(dist[i]).append('\n');
		}

		System.out.println(sb);
	}

	static void dijkstra(int start) {
		PriorityQueue<Node> pq = new PriorityQueue<>();
		boolean[] visited = new boolean[V+1];
		dist[start] = 0;
		pq.offer(new Node(start, 0));

		while (!pq.isEmpty()) {
			Node current = pq.poll();
			int currentEnd = current.end;

			if (!visited[currentEnd]) {
				visited[currentEnd] = true;

				for (Node node : list.get(currentEnd)) {
					if (!visited[node.end] && (dist[node.end] > dist[currentEnd] + node.weight)) {
						dist[node.end] = dist[currentEnd] + node.weight;
						pq.offer(new Node(node.end, dist[node.end]));
					}
				}
			}
		}
	}

}
