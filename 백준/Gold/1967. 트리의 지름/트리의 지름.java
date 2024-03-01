import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.*;
import java.io.IOException;

class Main {

	static class Node {
		int point, weight;

		public Node(int point, int weight) {
			this.point = point;
			this.weight = weight;
		}
	}

	static List<List<Node>> graph;
	static boolean[] visited;
	static int node, max;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.parseInt(br.readLine());

		graph = new ArrayList<>();
		for (int i = 0; i <= n; i++) {
			graph.add(new ArrayList<>());
		}

		for (int i = 1; i < n; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			int parent = Integer.parseInt(st.nextToken());
			int child = Integer.parseInt(st.nextToken());
			int weight = Integer.parseInt(st.nextToken());

			graph.get(parent).add(new Node(child, weight));
			graph.get(child).add(new Node(parent, weight));
		}

		visited = new boolean[n + 1];
		dfs(1, 0);
		visited = new boolean[n + 1];
		dfs(node, 0);

		System.out.println(max);

	}

	public static void dfs(int x, int length) {
		if (length > max) {
			max = length;
			node = x;
		}

		visited[x] = true;

		for (Node n : graph.get(x)) {
			if (!visited[n.point]) {
				dfs(n.point, length + n.weight);
			}
		}
	}

}
