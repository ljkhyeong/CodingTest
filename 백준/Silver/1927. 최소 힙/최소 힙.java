import java.io.BufferedInputStream;
import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.*;
import java.io.IOException;

class Main{

	public static void main(String[] args) throws IOException {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		PriorityQueue<Integer> pq = new PriorityQueue<>();

		int N = Integer.parseInt(br.readLine());
		int input;

		for (int i = 0; i < N; i++) {
			input = Integer.parseInt(br.readLine());

			if (input == 0) {
				if (!pq.isEmpty()) {
					System.out.println(pq.poll());
				} else {
					System.out.println(0);
				}
			} else {
				pq.add(input);
			}
		}
	}
}
