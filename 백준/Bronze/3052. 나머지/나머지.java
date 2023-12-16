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

		Set<Integer> set = new HashSet<>();
		int N = 10;

		while (N-- > 0) {
			int i = Integer.parseInt(br.readLine());
			set.add(i % 42);
		}

		System.out.println(set.size());
	}

}
