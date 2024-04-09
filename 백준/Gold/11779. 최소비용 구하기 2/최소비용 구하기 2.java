import java.awt.*;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.*;
import java.io.IOException;
import java.util.List;

class Main {

	final static int INF = 100000001;
	static List<List<Node>> graph;
	static boolean[] visited;
	static int n, m;

	static int[] dist, route;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		n = Integer.parseInt(br.readLine());
		m = Integer.parseInt(br.readLine());
		visited = new boolean[n + 1];
		dist = new int[n + 1];
		route = new int[n + 1];
		graph = new ArrayList<>();

		Arrays.fill(dist, INF);

		for (int i = 0; i < n + 1; i++) {
			graph.add(new ArrayList<>());
		}
		for (int i = 0; i < m; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			int start = Integer.parseInt(st.nextToken());
			int end = Integer.parseInt(st.nextToken());
			int weight = Integer.parseInt(st.nextToken());

			graph.get(start).add(new Node(end, weight));
		}

		StringTokenizer st = new StringTokenizer(br.readLine());
		int start = Integer.parseInt(st.nextToken());
		int end = Integer.parseInt(st.nextToken());

		dijkstra(start);
		System.out.println(dist[end]);

		int cnt = 0;
		Stack<Integer> stack = new Stack<>();
		stack.push(end);
		while (route[end] != 0) {
			cnt++;
			stack.push(route[end]);
			end = route[end];
		}
		System.out.println(cnt + 1);
		while (!stack.isEmpty()) {
			System.out.println(stack.pop()+" ");
		}
	}

	static void dijkstra(int start) {
		PriorityQueue<Node> pq = new PriorityQueue<>();
		pq.add(new Node(start, 0));
		dist[start] = 0;

		while (!pq.isEmpty()) {
			Node current = pq.poll();
			int cur = current.end;
			if (!visited[cur]) {
				visited[cur] = true;

				for (Node next : graph.get(cur)) {
					if (!visited[next.end] && dist[next.end] > dist[cur] + next.weight) {
						dist[next.end] = dist[cur] + next.weight;
						route[next.end] = cur;
						pq.offer(new Node(next.end, dist[next.end]));
					}
				}
			}
		}
	}

	static class Node implements Comparable<Node> {
		int end;
		int weight;

		public Node(int end, int weight) {
			this.end = end;
			this.weight = weight;
		}

		@Override
		public int compareTo(Node node) {
			return this.weight - node.weight;
		}
	}

}
