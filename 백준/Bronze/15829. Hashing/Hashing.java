import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.*;
import java.io.IOException;

class Main{


	public static void main(String[] args) throws IOException {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int L = Integer.parseInt(br.readLine());
		String str = br.readLine();
		long sum = 0;
		long r = 1;
		int M = 1234567891;
		for (int i = 0; i < L; i++) {
			sum += (str.charAt(i) - 'a' + 1) * r % M;
			r = r * 31 % M;
		}
		long hash = sum % M;
		System.out.println(hash);
	}


}
