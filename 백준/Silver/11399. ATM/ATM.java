import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.*;
import java.io.IOException;

class Main {



	public static void main(String[] args) throws IOException {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		StringTokenizer st = new StringTokenizer(br.readLine());
		int[] arr = new int[1001];
		while (N-->0) {
			int time = Integer.parseInt(st.nextToken());
			arr[time]++;
		}

		int sum = 0;
		int prev = 0;
		for (int i = 1; i < 1001; i++) {
			while (arr[i]-- > 0) {
				sum += prev + i;
				prev += i;
			}
		}
		System.out.println(sum);


	}

}
