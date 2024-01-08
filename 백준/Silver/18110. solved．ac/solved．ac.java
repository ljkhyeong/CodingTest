import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.*;
import java.io.IOException;

class Main{


	public static void main(String[] args) throws IOException {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.parseInt(br.readLine());

		int[] arr = new int[n];
		int except = (int)Math.round(n * 0.15);

		for (int i = 0; i < n; i++) {
			arr[i] = Integer.parseInt(br.readLine());
		}

		Arrays.sort(arr);

		double sum = 0;
		for (int i = except; i < n - except; i++) {
			sum += arr[i];
		}
		System.out.println((int)Math.round(sum / (n - 2 * except)));
	}


}
