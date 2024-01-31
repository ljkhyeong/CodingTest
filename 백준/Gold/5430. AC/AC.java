import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.*;
import java.io.IOException;

class Main {

	static StringBuilder sb = new StringBuilder();
	static Deque<Integer> deque;

	public static void main(String[] args) throws IOException {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		int T = Integer.parseInt(br.readLine());
		while (T-- > 0) {
			String p = br.readLine();
			int n = Integer.parseInt(br.readLine());
			StringTokenizer st = new StringTokenizer(br.readLine(), "[],");

			deque = new ArrayDeque<>();

			for (int i = 0; i < n; i++) {
				deque.add(Integer.parseInt(st.nextToken()));
			}

			AC(p);
		}

		System.out.println(sb);
	}

	public static void AC(String p) {
		boolean isRight = true;

		for (char cmd : p.toCharArray()) {
			if (cmd == 'R') {
				isRight = !isRight;
				continue;
			}

			if (isRight) {
				if (deque.pollFirst()==null) {
					sb.append("error").append('\n');
					return;
				}
			} else {
				if (deque.pollLast() == null) {
					sb.append("error").append('\n');
					return;
				}
			}
		}

		sb.append('[');

		if (deque.size() > 0) {

			if (isRight) {
				sb.append(deque.pollFirst());

				while (!deque.isEmpty()) {
					sb.append(',').append(deque.pollFirst());
				}
			} else {
				sb.append(deque.pollLast());

				while (!deque.isEmpty()) {
					sb.append(',').append(deque.pollLast());
				}
			}
		}

		sb.append(']').append('\n');
	}

}
