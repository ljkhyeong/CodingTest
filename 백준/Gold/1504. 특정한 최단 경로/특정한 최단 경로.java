import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.*;
import java.io.IOException;

class Main {

	static int N,E;
	static int INF = 200000000;
	static ArrayList<ArrayList<Node>> graph;
	static int[] dist;
	static boolean[] visited;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		E = Integer.parseInt(st.nextToken());

		graph = new ArrayList<>();
		dist = new int[N + 1];
		visited = new boolean[N + 1];

		for (int i = 0; i <= N; i++) {
			graph.add(new ArrayList<>());
		}

		for (int i = 0; i < E; i++) {
			st = new StringTokenizer(br.readLine());
			int start = Integer.parseInt(st.nextToken());
			int end = Integer.parseInt(st.nextToken());
			int length = Integer.parseInt(st.nextToken());

			graph.get(start).add(new Node(end, length));
			graph.get(end).add(new Node(start, length));
		}

		st = new StringTokenizer(br.readLine());
		int v1 = Integer.parseInt(st.nextToken());
		int v2 = Integer.parseInt(st.nextToken());

		int res1 = 0;
		res1 += dijkstra(1, v1);
		res1 += dijkstra(v1, v2);
		res1 += dijkstra(v2, N);
		int res2 = 0;
		res2 += dijkstra(1, v2);
		res2 += dijkstra(v2, v1);
		res2 += dijkstra(v1, N);

		int answer = (res1 >= INF && res2 >= INF) ? -1 : Math.min(res1, res2);

		System.out.println(answer);
	}

	static int dijkstra(int start, int end) {
		Arrays.fill(dist, INF);
		Arrays.fill(visited, false);
		PriorityQueue<Node> pq = new PriorityQueue<>();

		pq.offer(new Node(start, 0));
		dist[start] = 0;

		while (!pq.isEmpty()) {
			Node curNode = pq.poll();
			int curEnd = curNode.end;
			if (!visited[curEnd]) {
				visited[curEnd] = true;

				for (Node node : graph.get(curEnd)) {
					if (!visited[node.end] && dist[node.end] > dist[curEnd] + node.weight) {
						dist[node.end] = dist[curEnd] + node.weight;
						pq.add(new Node(node.end, dist[node.end]));
					}
				}
			}
		}

		return dist[end];
	}

	public static class Node implements Comparable<Node> {
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
}
