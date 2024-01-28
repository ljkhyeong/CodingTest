import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.*;
import java.io.IOException;

class Main {


	static int[] card;

	public static void main(String[] args) throws IOException {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		int N = Integer.parseInt(br.readLine());
		card = new int[N];

		StringTokenizer st = new StringTokenizer(br.readLine());
		for (int i = 0; i < N; i++) {
			card[i] = Integer.parseInt(st.nextToken());
		}

		Arrays.sort(card);

		int M = Integer.parseInt(br.readLine());
		st = new StringTokenizer(br.readLine());

		for (int i = 0; i < M; i++) {
			sb.append(binarySearch(Integer.parseInt(st.nextToken()))).append(' ');
		}

		System.out.println(sb);


	}

	static int binarySearch(int target) {
		int min = 0;
		int max = card.length;
		while (min < max) {
			int mid = (max + min) / 2;

			if (card[mid] < target) {
				min = mid+1;
			} else if (card[mid] > target) {
				max = mid;
			} else {
				return 1;
			}
		}
		return 0;
	}







}
