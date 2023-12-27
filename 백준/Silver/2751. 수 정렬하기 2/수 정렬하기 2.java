import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.*;
import java.io.IOException;

class Main{


	public static void main(String[] args) throws IOException {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		int N = Integer.parseInt(br.readLine());

		boolean[] arr = new boolean[2000001];

		while (N-- > 0) {
			arr[Integer.parseInt(br.readLine()) + 1000000] = true;
		}

		for (int i = 0; i < arr.length; i++) {
			if (arr[i])
				sb.append(i - 1000000).append('\n');
		}

		System.out.println(sb);
	}

}
