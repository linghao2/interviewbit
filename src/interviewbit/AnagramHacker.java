package interviewbit;

import java.io.*;
import java.util.HashMap;

public class AnagramHacker {
	public static int changeLetters(String str) {
		if (str.length() % 2 >= 1) {
			return -1;
		}
		int size = str.length() / 2;
		String a = str.substring(0, size);
		String b = str.substring(size, str.length());
		
		HashMap<Character, Integer> map = new HashMap<Character, Integer>();
		for (int i = 0; i < b.length(); i++) {
			char c = b.charAt(i);
			if (map.containsKey(c)) {
				int num = map.get(c);
				map.put(c, num+1);
			} else {
				map.put(c, 1);
			}
		}
		
		int numLetters = 0;
		for (int i = 0; i < a.length(); i++) {
			char c = a.charAt(i);
			if (map.containsKey(c)) {
				int num = map.get(c);
				if (num <= 1) {
					map.remove(c);
				} else {
					map.put(c, num-1);
				}
			} else {
				numLetters++;
			}
		}

		return numLetters;
	}
	
	public static void main(String args[]) throws Exception {
		/*
		System.out.println(changeLetters("aaabbb"));
		System.out.println(changeLetters("ab"));
		System.out.println(changeLetters("abc"));
		System.out.println(changeLetters("mnop"));
		System.out.println(changeLetters("xyyx"));
		*/
		try {
			BufferedReader br  =new BufferedReader(new InputStreamReader(System.in));
			int numLines = Integer.parseInt(br.readLine());
			for (int i = 0; i < numLines; i++) {
				String str = br.readLine();
				int num = changeLetters(str);
				System.out.println(num);
			}
		} catch (Exception e) {
			
		}
	}
}
