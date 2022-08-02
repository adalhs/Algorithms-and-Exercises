package ex2_Valid_Parentheses;
import java.util.ArrayList;
import java.util.List;

public class Solution {

	public boolean isValid(String s) {

		List<Boolean> validParentheses = new ArrayList<>();

		if (s.length() > 2) {
			for (int i = s.length(); i >= 1; i -= 2) {
				if ((s.charAt(i - 1) == ']' && s.charAt(i - 2) == '[') || (s.charAt(i - 1) == '}' && s.charAt(i - 2) == '{')
						|| (s.charAt(i - 1) == ')' && s.charAt(i - 2) == '(')) {
					validParentheses.add(true);
				}

			}

		} else if ((s.length() <= 2) && ((s.charAt(0) == '{' && s.charAt(1) == '}')
				|| (s.charAt(0) == '(' && s.charAt(1) == ')') || (s.charAt(0) == '[' && s.charAt(1) == ']'))) {
			validParentheses.add(true);
		}

		for (boolean valid : validParentheses) {
			if (valid == false) {
				return false;
			} else {
				return true;
			}
		}
		return false;
	}
}
