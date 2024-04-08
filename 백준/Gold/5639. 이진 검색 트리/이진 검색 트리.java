import java.awt.*;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.*;
import java.io.IOException;


class Main {

	static int[] tree = new int[10001];
	static StringBuilder sb = new StringBuilder();

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int idx = 0;
		String input;
		while (true) {
			input = br.readLine();
			if (input == null || input.equals("")) {
				break;
			}
			tree[idx++] = Integer.parseInt(input);
		}

		postOrder(0, idx - 1);
		System.out.println(sb);
	}

	static void postOrder(int n, int end) {
		if (n > end) return;

		int mid = n + 1;
		while (mid <= end && tree[mid] < tree[n]) mid++;

		postOrder(n + 1, mid - 1);
		postOrder(mid, end);
		sb.append(tree[n]).append('\n');
	}


}
