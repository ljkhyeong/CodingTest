import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.*;
import java.io.IOException;

class Main{


	public static void main(String[] args) throws IOException {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		String str = br.readLine();
		int N = Integer.parseInt(str);
		int result = 0;
		for (int i = N - (str.length() * 9); i < N; i++) {
			int num = i;
			int sum = 0;

			while (num != 0) {
				sum += num % 10;
				num /= 10;
			}

			if (sum + i == N) {
				result = i;
				break;
			}
		}

		System.out.println(result);



	}



}
