import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.*;
import java.io.IOException;

class Main{

	static int[] deque = new int[20001];
	static int size = 0;
	static int front = 10000;
	static int back = 10000;

	public static void main(String[] args) throws IOException {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		StringBuilder sb = new StringBuilder();
		

		while (N-- > 0) {
			StringTokenizer st = new StringTokenizer(br.readLine());

			switch (st.nextToken()) {
				case "push_front":
					push_front(Integer.parseInt(st.nextToken()));
					break;
				case "push_back":
					push_back(Integer.parseInt(st.nextToken()));
					break;
				case "pop_front":
					sb.append(pop_front()).append('\n');
					break;
				case "pop_back":
					sb.append(pop_back()).append('\n');
					break;
				case "size":
					sb.append(size()).append('\n');
					break;
				case "empty":
					sb.append(empty()).append('\n');
					break;
				case "front":
					sb.append(front()).append('\n');
					break;
				case "back":
					sb.append(back()).append('\n');
					break;
			}
		}

		System.out.println(sb);
	}

	static void push_front(int i) {
		deque[front] = i;
		front--;
		size++;
	}
	static void push_back(int i) {
		back++;
		size++;
		deque[back] = i;
	}

	static int pop_front() {
		if (size==0)
			return -1;

		int pop = deque[front+1];
		front++;
		size--;
		return pop;
	}

	static int pop_back() {
		if (size==0)
			return -1;

		int pop = deque[back];
		back--;
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

	static int front() {
		if (size==0)
			return -1;
		return deque[front+1];
	}

	static int back() {
		if (size==0)
			return -1;
		return deque[back];
	}




}
