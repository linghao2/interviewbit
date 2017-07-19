package interviewbit;

import java.util.*;

public class StringBit {
	
	public StringBit() {
		/*
		//String str = "A man, a plan, a canal: Panama";
		String str = "race a car";
		int isP = isPalindrome(str);
		System.out.println(str + " " + (isP == 0 ? " is NOT a palindrome" : "is a palindrome"));

		Random rand = new Random();
		int value = 2;
		while (value < 3999) {
			String roman = intToRoman(value);
			System.out.println(value + " -> " + roman);		
			value += rand.nextInt(20) + 1;
		}
		String str = "the sky is blue";
		System.out.println(reverseWords(str));
*/
		
		/*
		String str = "This is an example of text justification.";
		String[] tokens = textJustification(str, 16);
		for (int i = 0; i < tokens.length; i++) {
			System.out.println(tokens[i]); 
		}
		*/
		
		String palin = longestPalindrome("abb");
		System.out.println(palin);
	}
	
	public String longestPalindrome(String a) {
		if (a.length() == 0)
			return "";
	    String longest = a.substring(0,1);
	    for (int num = a.length(); num > 1; num--) {
		    for (int i = 0; i < a.length(); i++) {
		        for (int j = i + 1; j < a.length(); j++) {
		        		if (j-i+1 == num) {
				            String str = a.substring(i, j+1);
				            if (isPalindrome2(str)) {
				            		return str;
				            }
		        		}
		        }
		    }
	    }
	    return longest;
	}
	
	public boolean isPalindrome2(String str) {
	    int startIndex = 0;
	    int endIndex = str.length() - 1;
	    while (startIndex < endIndex) {
	        if (str.charAt(startIndex) != str.charAt(endIndex)) {
	            return false;
	        }
	        startIndex++;
	        endIndex--;
	    }
	    return true;
	}
	
	public String[] textJustification(String str, int length) {

	    List<String> textList = new ArrayList<String>();
	    
	    String[] tokens = str.split(" ");
	    int size = 0;
	    int nextIndex = 0;
	    for (int i = 0; i < tokens.length; i++) {
	        int currentLength = tokens[i].length();
	        int space = (size > 0) ? 1 : 0;
	        if ((size + currentLength + space) > length) {
	            // create the line
	            String nextStr = createNewLine(tokens, nextIndex, i-1, length);
	            textList.add(nextStr);
	            nextIndex = i;
	            size = currentLength;
	        } else {
	            size += currentLength + space;
	        }        
	    }
	    
	    String nextStr = createNewLine(tokens, nextIndex, tokens.length - 1, length);
	    textList.add(nextStr);
	    
	    return textList.toArray(new String[textList.size()]);
	}

	String createNewLine(String[] tokens, int startIndex, int endIndex, int length) {
	    int size = 0;
	    for (int i = startIndex; i <= endIndex; i++) {
	        size += tokens[i].length();
	    }
	    int spaces = length - size;
	    int numTokens = endIndex - startIndex;
	    int space1 = numTokens <= 0 ? 0 : spaces / numTokens;
	    
	    StringBuffer buf = new StringBuffer();
	    for (int i = startIndex; i <= endIndex; i++) {
	        buf.append(tokens[i]);
	        
	        if (i < endIndex) {
	            for (int j = 0; j < space1; j++) {
	                buf.append(" ");
	            }
	        }
	    }
	    if (buf.length() < length) {
	        for (int j = 0; j < (length - buf.length()); j++) {
	            buf.append(" ");
	        }
	    }
	    return buf.toString();
	}

	
	public String reverseWords(String a) {
	    StringBuffer buf = new StringBuffer();
	    
	    int fromIndex = a.length() - 1;
	    int index;
	    do {
    	    index = a.lastIndexOf(' ', fromIndex);
	        if (index == fromIndex) {
	            fromIndex--;
	        } else {
	            if (buf.length() > 0) {
	                buf.append(" ");
	            }
	            buf.append(a.substring(index+1, fromIndex+1));
	            fromIndex = index - 1;
	        }
	    } while (index >= 0);
	    
	    return buf.toString();
	}

	public String intToRoman(int a) {
		int thousands = a / 1000;
		int hundreds = (a - (1000 * thousands)) / 100;
		int tens = (a - (1000 * thousands) - (100 * hundreds)) / 10;
		int singles = a - (1000 * thousands) - (100 * hundreds) - (tens * 10);
		
		StringBuffer buf = new StringBuffer();
		
		buf.append(digitToRoman(thousands, new String[]{"M", "?", "?"}));
		buf.append(digitToRoman(hundreds, new String[]{"C", "D", "M"}));
		buf.append(digitToRoman(tens, new String[]{"X", "L", "C"}));
		buf.append(digitToRoman(singles, new String[]{"I", "V", "X"}));
		
		return buf.toString();
	}
	
	public String digitToRoman(int digit, String map[]) {
		StringBuffer buf = new StringBuffer();
		if (digit <= 3) {
			for (int i = 0; i < digit; i++) {
				buf.append(map[0]);
			}
		} else if (digit == 4) {
			buf.append(map[0] + map[1]);
		} else if (digit == 5) {
			buf.append(map[1]);
		} else if (digit < 9) {
			buf.append(map[1]);
			for (int i = 5; i < digit; i++) {
				buf.append(map[0]);
			}
		} else if (digit == 9) {
			buf.append(map[0] + map[2]);			
		}
		return buf.toString();
	}
	
	public int isPalindrome(String a) {
		StringBuffer buf = new StringBuffer();
		for (char c : a.toCharArray()) {
			if (Character.isDigit(c) || Character.isAlphabetic(c)) {
				buf.append(Character.toLowerCase(c));
			}
		}
		
		String str = buf.toString();
		int start = 0;
		int end = str.length()-1;
		while (start < end) {
			if (str.charAt(start) != str.charAt(end)) {
				return 0;
			}
			start++;
			end--;
		}
		return 1;
	}
	
	public static void main(String[] args) {
		new StringBit();
	}
}
