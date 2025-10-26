import java.awt.*;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.math.BigDecimal;
import java.util.*;
import java.io.IOException;
import java.util.List;

class Main {

	static class Tower {
		int h; int idx;
		Tower(int h, int idx) {
			this.h = h;
			this.idx = idx;
		}
	}
	public static void main(String[] args) throws IOException {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());

		StringTokenizer st = new StringTokenizer(br.readLine());
		Stack<Tower> stack = new Stack<>();
		StringBuilder sb = new StringBuilder();
		for (int i = 1; i <= N; i++) {
			int h = Integer.parseInt(st.nextToken());
			while (!stack.isEmpty() && stack.peek().h < h)
				stack.pop();
			sb.append(stack.isEmpty() ? 0 : stack.peek().idx).append(' ');
			stack.push(new Tower(h, i));
		}
		System.out.println(sb);
	}



}

