import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.*;
import java.io.IOException;

class Main {


	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.parseInt(br.readLine());
		int[] arr = new int[n];
		int[] sortedArr = new int[n];

		StringTokenizer st = new StringTokenizer(br.readLine());

		for (int i = 0; i < n; i++) {
			int num = Integer.parseInt(st.nextToken());
			arr[i] = num;
			sortedArr[i] = num;
		}


		Arrays.sort(sortedArr);

		Map<Integer, Integer> map = new HashMap<>();

		int idx = 0;
		for (int i : sortedArr) {
			if (!map.containsKey(i)) {
				map.put(i, idx++);
			}
		}

		StringBuilder sb = new StringBuilder();

		for (int i : arr) {
			sb.append(map.get(i)).append(' ');
		}

		System.out.println(sb);



	}



}
