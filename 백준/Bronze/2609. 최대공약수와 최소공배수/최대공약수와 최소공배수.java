import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.*;
import java.io.IOException;

class Main{


	public static void main(String[] args) throws IOException {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int num1 = Integer.parseInt(st.nextToken());
		int num2 = Integer.parseInt(st.nextToken());

		int gcd = gcd(num1, num2);
		int lcm = (num1 * num2) / gcd;
		System.out.println(gcd);
		System.out.println(lcm);

	}

	public static int gcd(int a, int b) {
		if (b==0)
			return a;
		return gcd(b, a % b);
	}





}
