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

		StringTokenizer st = new StringTokenizer(br.readLine());

		int answer = 0;
		while (st.hasMoreTokens()) {
			int i = Integer.parseInt(st.nextToken());
			answer += i * i;
		}
		System.out.println(answer%10);

	}

}
