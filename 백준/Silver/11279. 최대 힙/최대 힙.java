import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.*;
import java.io.IOException;

class Main{


	public static void main(String[] args) throws IOException {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		PriorityQueue<Integer> pq = new PriorityQueue<>(Collections.reverseOrder());
		StringBuilder sb = new StringBuilder();

		int N = Integer.parseInt(br.readLine());

		while (N-- > 0) {
			int i = Integer.parseInt(br.readLine());
			if (i == 0) {
				if (pq.isEmpty()) {
					sb.append('0').append('\n');
				} else {
					sb.append(pq.poll()).append('\n');
				}
			} else {
				pq.offer(i);
			}
		}
		System.out.println(sb);
	}


}
