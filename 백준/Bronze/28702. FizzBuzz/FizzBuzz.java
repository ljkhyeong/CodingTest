import java.awt.*;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.*;
import java.io.IOException;
import java.util.List;

class Main {



	public static void main(String[] args) throws IOException {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		int result = 0;
		boolean flag = false;

		for (int i = 0; i < 3; i++) {

			String str = br.readLine();

			if (str.charAt(0) != 'B' && str.charAt(0) != 'F') {
				flag = true;
				result = Integer.parseInt(str);
			}

			if (flag) {
				result++;
			}
		}

		if (result % 3 == 0 && result % 5 == 0) {
			System.out.println("FizzBuzz");
		} else if (result % 3 == 0) {
			System.out.println("Fizz");
		} else if (result % 5 == 0) {
			System.out.println("Buzz");
		} else {
			System.out.println(result);
		}

	}



}

