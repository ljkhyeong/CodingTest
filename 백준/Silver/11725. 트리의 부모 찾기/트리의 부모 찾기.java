import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.*;
import java.io.IOException;

class Main {





	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		int N = Integer.parseInt(br.readLine());

		List<List<Integer>> tree = new ArrayList<>();

		for (int i = 0; i <= N; i++) {
			tree.add(new ArrayList<>());
		}

		for (int i = 1; i < N; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			int i1 = Integer.parseInt(st.nextToken());
			int i2 = Integer.parseInt(st.nextToken());

			tree.get(i1).add(i2);
			tree.get(i2).add(i1);
		}

		Queue<Integer> queue = new LinkedList<>();
		boolean[] visited = new boolean[N+1];
		int[] parent = new int[N + 1];
		queue.add(1);
		visited[1] = true;

		while (!queue.isEmpty()) {
			int currentNode = queue.poll();
			for (int node : tree.get(currentNode)) {
				if (!visited[node]) {
					visited[node] = true;
					queue.offer(node);
					parent[node] = currentNode;
				}
			}
		}

		StringBuilder sb = new StringBuilder();
		for (int i = 2; i <= N; i++) {
			sb.append(parent[i]).append('\n');
		}
		System.out.println(sb);
	}




}
