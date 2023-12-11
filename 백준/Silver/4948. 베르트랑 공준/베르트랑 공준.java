import java.awt.*;
import java.io.BufferedInputStream;
import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.*;
import java.io.IOException;

class Main{

	static boolean[] isComposite = new boolean[246913];

	public static void main(String[] args) throws IOException {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		eratos();

		while (true) {
			int n = Integer.parseInt(br.readLine());
			if (n == 0) break;
			System.out.println(getPrimeCount(n));
		}
	}

	public static void eratos() {

		isComposite[0] = isComposite[1] = true;

		for (int i = 2; i <= Math.sqrt(isComposite.length); i++) {
			if (isComposite[i]) continue;
			for (int j = i * i; j < isComposite.length; j+=i) {
				isComposite[j] = true;
			}
		}
	}

	public static int getPrimeCount(int n) {
		int count = 0;
		for (int i = n + 1; i <= 2 * n; i++) {
			if (!isComposite[i]) count++;
		}
		return count;
	}


}
