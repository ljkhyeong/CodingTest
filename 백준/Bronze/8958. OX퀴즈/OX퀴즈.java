import java.awt.*;
import java.io.BufferedInputStream;
import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.*;
import java.io.IOException;
import java.util.List;

class Main{


	public static void main(String[] args) throws IOException {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		int N = Integer.parseInt(br.readLine());
		StringBuilder sb = new StringBuilder();

		int count, sum;

		while (N-- > 0) {
			sum = count = 0;
			for (byte ch : br.readLine().getBytes()) {
				if (ch == 'O') {
					count++;
					sum+=count;
				} else {
					count=0;
				}
			}
			sb.append(sum).append('\n');
		}

		System.out.println(sb);

	}

}
