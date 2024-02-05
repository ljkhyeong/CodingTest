import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.*;
import java.io.IOException;

class Main {


	static Queue<Register> queue;
	static boolean[] visited;
	static int D, S, L, R;



	public static void main(String[] args) throws IOException {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		int T = Integer.parseInt(br.readLine());
		StringBuilder sb = new StringBuilder();
		while (T-- > 0) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			queue = new LinkedList<>();
			visited = new boolean[10000];
			int A = Integer.parseInt(st.nextToken());
			int B = Integer.parseInt(st.nextToken());
			sb.append(bfs(new Register(A,""), B)).append('\n');
		}

		System.out.println(sb);
	}

	static String bfs(Register a, int b) {
		queue.offer(a);
		visited[a.num] = true;

		while (!queue.isEmpty() ) {
			Register cur = queue.poll();
			int curInt = cur.num;
			String curStr = cur.str;

			if (curInt == b) {
				return curStr;
			}
			D = (2 * curInt) % 10000;
			S = curInt == 0 ? 9999 : curInt - 1;
			L = (curInt % 1000 * 10) + (curInt / 1000);
			R = (curInt % 10 * 1000) + (curInt / 10);

			if (!visited[D]) {
				queue.add(new Register(D, curStr+"D"));
				visited[D] = true;
			}

			if (!visited[S]) {
				queue.add(new Register(S, curStr+"S"));
				visited[S] = true;
			}

			if (!visited[L]) {
				queue.add(new Register(L, curStr+"L"));
				visited[L] = true;
			}

			if (!visited[R]) {
				queue.add(new Register(R, curStr+"R"));
				visited[R] = true;
			}
		}

		return "";
	}

	static class Register {
		int num;
		String str;

		public Register(int num, String str) {
			this.num = num;
			this.str = str;
		}

	}


}
