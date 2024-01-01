import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.*;
import java.io.IOException;

class Main{

	static int[] stack;
	static int size;

	public static void main(String[] args) throws IOException {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		StringBuilder sb = new StringBuilder();
		stack = new int[N];
		size = 0;

		while (N-- > 0) {
			StringTokenizer st = new StringTokenizer(br.readLine());

			switch (st.nextToken()) {
				case "push":
					push(Integer.parseInt(st.nextToken()));
					break;
				case "pop":
					sb.append(pop()).append('\n');
					break;
				case "size":
					sb.append(size()).append('\n');
					break;
				case "empty":
					sb.append(empty()).append('\n');
					break;
				case "top":
					sb.append(top()).append('\n');
					break;
			}
		}

		System.out.println(sb);
	}

	static void push(int i) {
		stack[size] = i;
		size++;
	}

	static int pop() {
		if (size==0)
			return -1;

		int pop = stack[size-1];
		stack[size-1] = 0;
		size--;
		return pop;
	}

	static int size() {
		return size;
	}

	static int empty() {
		if (size==0)
			return 1;
		return 0;
	}

	static int top() {
		if (size==0)
			return -1;
		return stack[size-1];
	}




}
