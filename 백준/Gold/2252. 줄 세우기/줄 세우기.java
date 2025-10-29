import java.awt.*;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.math.BigDecimal;
import java.util.*;
import java.io.IOException;
import java.util.List;

class Main {

	public static void main(String[] args) throws IOException {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int N = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());
		int[] indeg = new int[N + 1];
		List<List<Integer>> graph = new ArrayList<>();

		for (int i = 0; i <= N; i++) {
			graph.add(new ArrayList<>());
		}


		for (int i = 0; i < M; i++) {
			st = new StringTokenizer(br.readLine());
			int u = Integer.parseInt(st.nextToken());
			int v = Integer.parseInt(st.nextToken());
			graph.get(u).add(v); indeg[v]++;
		}

		Queue<Integer> q = new LinkedList<>();
		for (int i = 1; i <= N; i++) {
			if (indeg[i] == 0) q.offer(i);
		}

		StringBuilder sb = new StringBuilder();
		while (!q.isEmpty()) {
			int cur = q.poll();
			sb.append(cur).append(' ');
			for (int next : graph.get(cur)) {
				if (--indeg[next]==0)
					q.offer(next);
			}
		}

		System.out.println(sb);
	}





}

