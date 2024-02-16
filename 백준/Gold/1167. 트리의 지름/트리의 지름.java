import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.*;
import java.io.IOException;

class Main {

	static boolean[] visited;

	static List<List<Node>> graph;
	static int v, max, node;



	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		v = Integer.parseInt(br.readLine());
		graph = new ArrayList<>();

		for (int i = 0; i <= v; i++) {
			graph.add(new ArrayList<>());
		}

		for (int i = 1; i <= v; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			int currentVertex = Integer.parseInt(st.nextToken());
			while (st.hasMoreTokens()) {
				int point = Integer.parseInt(st.nextToken());
				if (point == -1) {
					break;
				}
				int length = Integer.parseInt(st.nextToken());
				graph.get(currentVertex).add(new Node(point, length));
			}
		}

		visited = new boolean[v + 1];
		dfs(1, 0);
		visited = new boolean[v + 1];
		dfs(node, 0);

		System.out.println(max);
	}

	static void dfs(int x, int length) {
		if (length > max) {
			max = length;
			node = x;
		}

		visited[x] = true;

		for (Node n : graph.get(x)) {
			if (!visited[n.target]) {
				dfs(n.target, length + n.weight);
			}
		}

	}

	static class Node {
		int target, weight;

		public Node(int target, int weight) {
			this.target = target;
			this.weight = weight;
		}
	}


}
