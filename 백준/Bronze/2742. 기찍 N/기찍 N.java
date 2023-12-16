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

		StringBuilder sb = new StringBuilder();
		int N = Integer.parseInt(br.readLine());

		while (N-- > 0) {
			sb.append(N + 1).append('\n');
		}
		System.out.println(sb);
	}

}
