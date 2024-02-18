import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.*;
import java.io.IOException;

class Main {

	static class Node implements Comparable<Node>{
		int end;
		int weight;

		Node(int end, int weight) {
			this.end = end;
			this.weight = weight;
		}

		@Override
		public int compareTo(Node o) {
			return weight - o.weight;
		}
	}

	static List<List<Node>> list;
	static int n,m, x;
	static final int INF = Integer.MAX_VALUE;
	static int max = Integer.MIN_VALUE;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		n = Integer.parseInt(st.nextToken());
		m = Integer.parseInt(st.nextToken());
		x = Integer.parseInt(st.nextToken());

		list = new ArrayList<>();

		for (int i = 0; i <= n; i++) {
			list.add(new ArrayList<>());
		}

		for (int i = 0; i < m; i++) {
			st = new StringTokenizer(br.readLine());
			int start = Integer.parseInt(st.nextToken());
			int end = Integer.parseInt(st.nextToken());
			int weight = Integer.parseInt(st.nextToken());

			list.get(start).add(new Node(end, weight));
		}

		for (int i = 1; i <= n; i++) {

			if (i == x) {
				continue;
			}

			int go = dijkstra(i, x);
			int back = dijkstra(x, i);

			max = Math.max(max, go + back);
		}

		System.out.println(max);
	}

	static int dijkstra(int start, int end) {
		PriorityQueue<Node> pq = new PriorityQueue<>();
		boolean[] visited = new boolean[n + 1];
		int[] dist = new int[n + 1];

		pq.offer(new Node(start, 0));
		Arrays.fill(dist, INF);
		dist[start] = 0;

		while (!pq.isEmpty()) {
			Node current = pq.poll();
			int cur = current.end;

			if (!visited[cur]) {
				visited[cur] = true;

				for (Node node : list.get(cur)) {
					if (!visited[node.end] && dist[node.end] > dist[cur] + node.weight) {
						dist[node.end] = dist[cur] + node.weight;
						pq.add(new Node(node.end, dist[node.end]));
					}
				}
			}
		}
		return dist[end];
	}




}
