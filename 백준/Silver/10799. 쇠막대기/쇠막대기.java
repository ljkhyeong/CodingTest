import java.awt.*;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.math.BigDecimal;
import java.util.*;
import java.io.IOException;
import java.util.List;

class Main {

	public static void main(String[] args) throws IOException {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String input = br.readLine();

		Stack<Character> stack = new Stack<>();

		int result = 0;
		for (int i = 0; i < input.length(); i++) {
			char cur = input.charAt(i);

			if (cur == '(') {
				stack.push('(');
			}else {
				stack.pop();
				if (i >= 1) {
					if (input.charAt(i - 1) == '(') {
						result += stack.size();
					} else {
						result += 1;
					}
				}
			}
		}
		System.out.println(result);
	}

}

