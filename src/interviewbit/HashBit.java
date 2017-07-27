package interviewbit;

import java.util.*;

public class HashBit {
	public HashBit() {
		/*
		int colorful = colorful(3245);
		System.out.println(colorful);
		*/
		
		String list[] = { "aababbaaaabaabbabaaaaabbbaaaabbaabbabbaaaaababaaabbaaabaaaabbbaaabbabaaababaa", "bbbbbbaaaabaababbbaaabbabaaabaabbbbaabababaaababababbaaabbaabaabbabbaaaabaaba", "abaaababbababbababababaabaababbababaabaabaaabbabbaabbaaabbbabbbbbbaabbbbbbabb", "aabbabbbbababbaaabbbaaaaaaaabaabbabbabbbbaabaaaaabaaabaabbaaabbbbaaababaaabbb", "ababaaabaabbbabaaaababbaababaabaabaaabbabbaaabbbbbbabbbbaababbbbaaaaaabababaa", "babbbabbabaaabaaaabbbabbabbbaaaaabbbbabaaaaababaababbbabaaaaabbbbbbbbaabbbabb", "bbaabaabbbbbbaabaabbabbbbabababaaabaabbbbbaaaabbbaaabbbbbaaaabbaaaabababbaaaa", "ababbaaaabababaababababbabbaaaabbbbababbbbabaaabbabbabbabbbbabaababbbabbbbbab", "aaaaabbaaabbbbaabaabbbaabaaabbbbaaaaaabaaaaaabaabbbaababaabaaaaabaabaaabbbabb", "abbaaababbbbbaabbaaaabbaaaabbbbbaabaabaaaabbbabbbbabababaaabbabbabbbabbababbb", "bbbbabbbbaabbbbababbbaaaabaaababbabbababbababbabaaabbbbaabababaaaaaabbbbaabab", "babaabbaaabbaabbaabaabaaaaabbabbabbbbbbaaaaaabbbbbabaaaaabbbabaabbbaaaabbbbaa"};
		/*
[1]
[2, 5]
[3, 10, 11]
[4]
[6]
[7]
[8]
[9]
[12]
		 */
		/*
		ArrayList<ArrayList<Integer>> anagram = anagrams(Arrays.asList(list));
		for (int i = 0; i < anagram.size(); i++) {
			System.out.println(anagram.get(i));
		}
		
		
		String f1 = fractionToDecimal(1,2);
		System.out.println("ANS:" + f1);
		String f2 = fractionToDecimal(2,3);
		System.out.println("ANS:" + f2);
		String f3 = fractionToDecimal(-2147483648,-1);
		System.out.println("ANS:" + f3);
		String f4 = fractionToDecimal(3227,555);
		System.out.println("ANS:" + f4);
		*/
		
		/*
		int leng = lengthOfLongestSubstring("Wnb9z9dMc7E8v1RTUaZPoDNIAXRlzkqLaa97KMWLzbitaCkRpiE4J4hJWhRcGnC8H6mwasgDfZ76VKdXhvEYmYrZY4Cfmf4HoSlchYWFEb1xllGKyEEmZOLPh1V6RuM7Mxd7xK72aNrWS4MEaUmgEn7L4rW3o14Nq9l2EN4HH6uJWljI8a5irvuODHY7A7ku4PJY2anSWnfJJE1w8p12Ks3oZRxAF3atqGBlzVQ0gltOwYmeynttUmQ4QBDLDrS4zn4VRZLosOITo4JlIqPD6t4NjhHThOjJxpMp9fICkrgJeGiDAwsb8a3I7Txz5BBKV9bEfMsKNhCuY3W0ZHqY0MhBfz1CbYCzwZZdM4p65ppP9s5QJcfjadmMMi26JKz0TVVwvNA8LP5Vi1QsxId4SI19jfcUH97wmZu0pbw1zFtyJ8GAp5yjjQTzFIboC1iRzklnOJzJld9TMaxqvBNBJKIyDjWrdfLOY8FGMOcPhfJ97Dph35zfxYyUf4DIqFi94lm9J0skYqGz9JT0kiAABQZDazZcNi80dSSdveSl6h3dJjHmlK8qHIlDsqFd5FMhlEirax8WA0v3NDPT8vPhwKpxcnVeu14Gcxr3h1wAXXV0y7Xy9qqB2NQ5HQLJ7cyXAckEYHsLCPSy28xcdNJatx1KLWohOQado4WywJbGvsFR17rKmvOPABweXnFD3odrbSMD4Na4nuBBswvMmFRTUOcf7jZi4z5JnJqXz6hitaPnaEtjoSEBq82a52nvqYy7hhldBoxen2et2OMadVEHeTYLL7GLsIhTP6UizHIuzcJMljo4lFgW5AyrfUlIBPAlhwaSiJtTvcbVZynDSM6RO1PqFKWKg2MHIgNhjuzENg2oFCfW7z5KJvEL9qWqKzZNc0o3BMRjS04NCHFvhtsteQoQRgz84XZBHBJRdekCdcVVXu9c01gYRAz7oIAxN3zKZb64EFKssfQ4HW971jv3H7x5E9dAszA0HrKTONyZDGYtHWt4QLhNsIs8mo4AIN7ecFKewyvGECAnaJpDn1MTTS4yTgZnm6N6qnmfjVt6ZU51F9BxH0jVG0kovTGSjTUkmb1mRTLQE5mTlVHcEz3yBOh4WiFFJjKJdi1HBIBaDL4r45HzaBvmYJPlWIomkqKEmQ4rLAbYG7C5rFfpMu8rHvjU7hP0JVvteGtaGn7mqeKsn7CgrJX1tb8t0ldaS3iUy8SEKAo5IZHNKOfEaij3nI4oRVzeVOZsH91pMsA4jRYgEohubPW8ciXwVrFi1qEWjvB8gfalyP60n1fHyjsiLW0T5uY1JzQWHKCbLVh7QFoJFAEV0L516XmzIo556yRH1vhPnceOCjebqgsmO78AQ8Ir2d4pHFFHAGB9lESn3OtJye1Lcyq9D6X93UakA3JKVKEt6JZDLVBMp4msOefkPKSw59Uix9d9kOQm8WCepJTangdNSOKaxblZDNJ5eHvEroYacBhd9UdafEitdF3nfStF7AhkSfQVC61YWWkKTNdx96OoJGTnxuqt4oFZNFtO7aMuN3IJAkw3m3kgZFRGyd3D3wweagNL9XlYtvZwejbjpkDOZz33C0jbEWaMEaUPw6BG49XqyQoUwtriguO0yvWyaJqD4ye3o0E46huKYAsdKAq6MLWMxF6tfyPVaoqOGd0eOBHbAF89XXmDd4AIkoFPXkAOW8hln5nXnIWP6RBbfEkPPbxoToMbV");
		System.out.println("ANS:" + leng);
		int leng2 = lengthOfLongestSubstring("abcabcbb");
		System.out.println("ANS:" + leng2);
		*/
		
		ArrayList<String> sub = new ArrayList<String>();
		sub.add("cac");
		sub.add("aaa");
		sub.add("aba");
		sub.add("aab");
		sub.add("abc");
		ArrayList<Integer> indexes = getSubstringIndex("abbaccaaabcabbbccbabbccabbacabcacbbaabbbbbaaabaccaacbccabcbababbbabccabacbbcabbaacaccccbaabcabaabaaaabcaabcacabaa", sub);
		System.out.println(indexes);
	}
	
	public ArrayList<Integer> getSubstringIndex(String a, ArrayList<String> b) {
		ArrayList<Integer> list = new ArrayList<Integer>();
		int size = b.get(0).length() * b.size();
		
		boolean done = false;
		int fromIndex = 0;
		while (!done) {
			ArrayList<Integer> indexes = new ArrayList<Integer>();
			for (int i = 0; i < b.size(); i++) {
				String subString = b.get(i);
				int index = a.indexOf(subString, fromIndex);
				if (index >= fromIndex) {
					indexes.add(index);					
				} else {
					done = true;
					break;
				}
			}	
			if (!done) {
				Collections.sort(indexes);
				System.out.println(indexes);
				int firstIndex = indexes.get(0);
				fromIndex = indexes.get(indexes.size() - 1) + 1;
				if ((firstIndex + size) > a.length()) {
					done = true;
				} else {
					list.add(firstIndex);					
				}
			}			
		}
		return list;
	}

	public int lengthOfLongestSubstring(String a) {
		int max = 0;
		int count = 0;
		HashMap<Character, Integer> map = new HashMap<Character, Integer>();
		
		for (int i = 0; i < a.length(); i++) {
			char c = a.charAt(i);
			if (map.containsKey(c)) {
				int prevIndex = map.get(c);
				count = Math.min(count + 1, i - prevIndex);
			} else {
				count++;
			}
			map.put(c, i);
			if (count > max) {
				max = count;
			}
		}
		
		return max;
	}
	
	public String fractionToDecimal3(int numerator, int denominator) {
		long quotient = numerator / denominator;
		double remainder = ((double)numerator / (double)denominator) - quotient;
		StringBuffer buf = new StringBuffer();
		buf.append(quotient);
		if (remainder > 0) {
			buf.append(".");
			
			String str = Double.toString(remainder);
			int index = str.indexOf(".");
			str = str.substring(index+1);
			int length = 3;
			boolean foundRepeat = false;
			for (int i = 0; i < length; i++) {
				int size = i+1;
				for (int offset = 0; offset <= i; offset++) {
					boolean notRepeat = false;
					String prevStr = null;
					int next = 0;
					for(int count = 0; count < 4; count++) {
						try {
							String subStr = str.substring(offset+next, offset+size+next);							
							if (prevStr == null) {
								prevStr = subStr;
							} else {
								if (!prevStr.equals(subStr)) {
									notRepeat = true;
									break;
								}
							}
							next += size;
						} catch (Exception ex) {
							notRepeat = true;
							break;
						}
					}
					
					if (!notRepeat) {
						buf.append(str.substring(0, offset));
						buf.append("(");
						buf.append(prevStr);
						buf.append(")");
						foundRepeat = true;
						break;
					}
				}
				
				if (foundRepeat) {
					break;
				}
			}			
			if (!foundRepeat) {
				buf.append(str);
			}
		}
		
		
		return buf.toString();
	}
	
	public void test(String str) {
		/*
		HashMap<Character, Integer> map = new HashMap<Character, Integer>();
		String str = Double.toString(remainder);
		int length = Math.min(str.length(), 1000);
		for (int i = 0; i < length; i++) {
			char c = str.charAt(i);
			if (map.containsKey(c)) {
				int value = map.get(c);
				map.put(c, value+1);
				if (value > 100) {
					break;
				}
			}
		}
		*/

		//int length = Math.min(str.length() / 2, 1000);
		int length = 3;
		for (int i = 0; i < length; i++) {
			int size = i+1;
			boolean foundRepeat = false;
			for (int offset = 0; offset <= i; offset++) {
				System.out.println("i= " + i + " offset= " + offset);
				
				boolean found = false;
				boolean notRepeat = false;
				String prevStr = null;
				int next = 0;
				for(int count = 0; count < 5; count++) {
					String subStr = str.substring(offset+next, offset+size+next);
					System.out.println(subStr);
					if (prevStr == null) {
						prevStr = subStr;
					} else {
						if (!prevStr.equals(subStr)) {
							notRepeat = true;
							break;
						}
					}
					next += size;
				}
				
				if (!notRepeat) {
					System.out.println("Repeat " + prevStr);
					System.out.println("ADD " + str.substring(0, offset));
					foundRepeat = true;
					break;
				}
			}
			
			if (foundRepeat) {
				System.out.println("isRepeating " + foundRepeat);
				break;
			}
		}

	}
	
	
	public ArrayList<ArrayList<Integer>> anagrams(final List<String> a) {
		ArrayList<ArrayList<Integer>> list = new ArrayList<ArrayList<Integer>>();
		HashMap<String, Integer> map = new HashMap<String, Integer>();
		for (int i = 0; i < a.size(); i++) {
		    char[] chars = a.get(i).toCharArray();
		    Arrays.sort(chars);
		    String sorted = new String(chars);
		    
		    	if (map.containsKey(sorted)) {
		    		int index = map.get(sorted);
		    		ArrayList<Integer> anaList = list.get(index);
		    		anaList.add(i+1);
		    	} else {
		    		ArrayList<Integer> anaList = new ArrayList<Integer>();
		    		anaList.add(i+1);
		    		map.put(sorted, list.size());

		    		list.add(anaList);
		    	}
		}
		return list;
	}
	
	public ArrayList<ArrayList<Integer>> anagramsBad(final List<String> a) {
		ArrayList<ArrayList<Integer>> list = new ArrayList<ArrayList<Integer>>();
		
		List<String> sortedA = new ArrayList<String>();
		for (String str: a) {
		    char[] chars = str.toCharArray();
		    Arrays.sort(chars);
		    sortedA.add(new String(chars));
		}
		
		int size = sortedA.size();
		int[] found = new int[size];
		for (int i = 0; i < size ; i++) {
		    found[i] = 0;
		    System.out.println(sortedA.get(i));
		}
		
		for (int i = 0; i < size ; i++) {
		    ArrayList<Integer> matchList = null;
		    for (int j = i+1; j < size; j++) {
		        if (found[j] > 0) {
		            continue;
		        }
		        String str1 = sortedA.get(i);
		        String str2 = sortedA.get(j);
		        if (str1.equals(str2)) {
		            if (matchList == null) {
		                matchList = new ArrayList<Integer>();
		                matchList.add(i+1);
		                found[i] = 1;
		            }
		            matchList.add(j+1);
		            found[j] = 1;
		        }
		    }
		    if (matchList == null && found[i] == 0) {
		      matchList = new ArrayList<Integer>();
		      matchList.add(i+1);
		      found[i] = 1;
		    }
		    if (matchList != null) {
		        list.add(matchList);
		    }
		}
		for (int i = 0; i < size ; i++) {
		    if (found[i] == 0) {
		      ArrayList<Integer>  matchList = new ArrayList<Integer>();
		      matchList.add(i+1);
		      list.add(matchList);
		    }
		}
		
		return list;
	}

	/*
	 * Given an array of strings, return all groups of strings that are anagrams. 
	 * Represent a group by a list of integers representing the index in the original list. Look at the sample case for clarification.
	 */
	public ArrayList<ArrayList<Integer>> anagramOld(final List<String> a) {
		ArrayList<ArrayList<Integer>> list = new ArrayList<ArrayList<Integer>>();
		
		ArrayList<HashMap<Character, Integer>> hashList = new ArrayList<HashMap<Character, Integer>>();
		for (String str: a) {
			HashMap<Character, Integer> map = new HashMap<Character, Integer>();
			for (int i = 0; i < str.length(); i++) {
				char c = str.charAt(i);
				if (map.containsKey(c)) {
					Integer value = map.get(c);
					map.put(c, value + 1);
				} else {
					map.put(c,  1);
				}
			}
			hashList.add(map);
		}
		
		int[] found = new int[hashList.size()];
		for (int i = 0; i < hashList.size(); i++) {
			found[i] = 0;
		}
		for (int i = 0; i < hashList.size(); i++) {
			for (int j = i+1; j < hashList.size(); j++) {
				HashMap<Character, Integer> map1 = hashList.get(i);
				HashMap<Character, Integer> map2 = hashList.get(j);
				if (map1.equals(map2)) {
					ArrayList<Integer> match = new ArrayList<Integer>();
					match.add(i+1);
					match.add(j+1);
					
					list.add(match);
					found[i] = 1;
					found[j] = 1;
 				}
			}
			if (found[i] == 0) {
				ArrayList<Integer> match = new ArrayList<Integer>();
				match.add(i+1);
				list.add(match);
				found[i] = 1;
			}
		}
		
		for (int i = 0; i < hashList.size(); i++) {
			if (found[i] == 0) {
				ArrayList<Integer> match = new ArrayList<Integer>();
				match.add(i+1);
				list.add(match);
			}
		}
		return list;
	}
	
	/*
	 * A number can be broken into different contiguous sub-subsequence parts. 
Suppose, a number 3245 can be broken into parts like 3 2 4 5 32 24 45 324 245. 
And this number is a COLORFUL number, since product of every digit of a contiguous subsequence is different
	 */
	
	public int colorful(int a) {
		HashSet<Integer> set = new HashSet<Integer>();
		ArrayList<Integer> list = new ArrayList<Integer>();
		
		while (a > 0) {
			int remainder = a % 10;
			list.add(0, remainder);
			a = a / 10;
		}
		
		for (int i = 0; i < list.size(); i++) {
			int product = 1;
			for (int j = i; j < list.size(); j++) {
				product *= list.get(j);
				
				if (set.contains(product)) {
					return 0;
				}
				set.add(product);
			}
		}
		
		
		return 1;
	}
	public int isColorful(int a) {
		//HashMap<Integer, Integer> map = new HashMap<Integer, Integer>();
		HashSet<Integer> set = new HashSet<Integer>();
		String str = Integer.toString(a);
		for (int i = 0; i < str.length(); i++) {
			for (int j = i+1; j <= str.length(); j++) {
				String subString = str.substring(i, j);
					int product = 1;
					for (int n = 0; n < subString.length(); n++) {
						int digit = Integer.parseInt(subString.substring(n, n+1));
						product *= digit;
					}
					if (set.contains(product)) {
						return 0;
					}
					set.add(product);
			}
		}
		return 1;
	}
	
	public static void main(String[] args) {
		new HashBit();
	}

}
