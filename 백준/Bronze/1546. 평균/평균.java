import java.awt.*;
import java.io.BufferedInputStream;
import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.*;
import java.io.IOException;
import java.util.List;

class Main{

	static int[] arr;

	public static void main(String[] args) throws IOException {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		StringTokenizer st = new StringTokenizer(br.readLine());
		int max = -1;
		double sum = 0.0;

		for (int i = 0; i < N; i++) {
			int val = Integer.parseInt(st.nextToken());
			max = Math.max(max, val);
			sum += val;
		}

		System.out.println((sum / max) * 100 / N);

	}


}
