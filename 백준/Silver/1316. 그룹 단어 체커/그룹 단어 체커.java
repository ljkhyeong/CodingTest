import java.awt.*;
import java.io.BufferedInputStream;
import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.*;
import java.io.IOException;

class Main{


	public static void main(String[] args) throws IOException {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		int count = 0;
		int N = Integer.parseInt(br.readLine());

		while (N-- > 0) {
			if (check(br.readLine())) count++;
		}
		System.out.println(count);
	}

	static boolean check(String str) {
		boolean[] usedAlphabet = new boolean[26];
		int prev = 0, now = 0;

		for (int i = 0; i < str.length(); i++) {
			now = str.charAt(i);

			if (now!=prev) {
				if (!usedAlphabet[now - 'a']) {
					usedAlphabet[now - 'a'] = true;
					prev = now;
				} else {
					return false;
				}
			}
		}
		return true;
	}


}
