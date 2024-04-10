import java.awt.*;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.*;
import java.io.IOException;
import java.util.List;

class Main {

	static int N, K;
	static int[] time = new int[100001];
	static int minTime = Integer.MAX_VALUE;
	static int count = 0;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		K = Integer.parseInt(st.nextToken());

		if (N >= K) {
			System.out.println(N-K+"\n1");
			return;
		}

		bfs();
		System.out.println(minTime+"\n"+count);
	}

	static void bfs() {
		Queue<Integer> q = new LinkedList<>();
		q.offer(N);
		time[N] = 1;

		while (!q.isEmpty()) {
			int cur = q.poll();

			if (minTime < time[cur])
				return;

			for (int i = 0; i < 3; i++) {
				int next;

				if (i==0)
					next = cur + 1;
				else if (i==1)
					next = cur - 1;
				else
					next = cur * 2;

				if (next<0 || next>100000) continue;

				if (next == K) {
					minTime = time[cur];
					count++;
				}

				if (time[next] == 0 || time[next] == time[cur] + 1) {
					time[next] = time[cur] + 1;
					q.offer(next);
				}
			}
		}
	}



}
