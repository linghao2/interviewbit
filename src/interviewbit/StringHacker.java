package interviewbit;

import java.util.HashSet;

public class StringHacker {
	public StringHacker() {
		String str = "He had1- had2, quite enough of this nonsense the the.";
		String repeat = firstRepeatedWord(str);
		System.out.println(repeat);
	}
	
	public String firstRepeatedWord(String s) {
		String[] tokens = s.split("[ \\t.,:;-]");
		HashSet<String> set = new HashSet<String>();
		for (int i = 0; i< tokens.length; i++) {
			System.out.println(tokens[i]);
			if (tokens[i].length() == 0) {
				continue;
			}
			if (set.contains(tokens[i])) {
				System.out.println("**" + tokens[i] + "**");
				return tokens[i];
			} else {
				set.add(tokens[i]);
			}
		}
		return null;
	}
	public static void main(String[] args) {
		new StringHacker();
	}

}
