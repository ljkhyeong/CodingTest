import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.*;
import java.io.IOException;

class Main{


	public static void main(String[] args) throws IOException {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		Stack<Integer> stack = new Stack<>();

		int N = Integer.parseInt(br.readLine());

		int start = 1;

		while (N-- > 0) {

			int val = Integer.parseInt(br.readLine());

			if (val>=start) {
				for (int i = start; i <= val; i++) {
					stack.push(i);
					sb.append('+').append('\n');
				}
				start = val + 1;
			} else if (stack.peek() != val) {
				System.out.println("NO");
				return;
			}

			stack.pop();
			sb.append('-').append('\n');
		}

		System.out.println(sb);

	}



}
