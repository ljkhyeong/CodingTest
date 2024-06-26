import java.awt.*;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.*;
import java.io.IOException;


class Main {


	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String str = br.readLine();
		String bomb = br.readLine();
		Stack<Character> stack = new Stack<>();

		for (int i = 0; i < str.length(); i++) {
			stack.push(str.charAt(i));

			if (stack.size() >= bomb.length()) {
				boolean flag = true;
				for (int j = 0; j < bomb.length(); j++) {
					if (stack.get(stack.size() - bomb.length() + j) != bomb.charAt(j)) {
						flag = false;
						break;
					}
				}

				if (flag) {
					for (int j = 0; j < bomb.length(); j++) {
						stack.pop();
					}
				}
			}
		}

		StringBuilder sb = new StringBuilder();
		for (char ch : stack) {
			sb.append(ch);
		}

		System.out.println(sb.length() > 0 ? sb.toString() : "FRULA");

	}




}
