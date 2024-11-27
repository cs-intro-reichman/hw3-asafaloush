/** Functions for checking if a given string is an anagram. */
public class Anagram {
	public static void main(String args[]) {
		// Tests the isAnagram function.
		System.out.println(isAnagram("silent","listen"));  // true
		System.out.println(isAnagram("William Shakespeare","I am a weakish speller")); // true
		System.out.println(isAnagram("Madam Curie","Radium came")); // true
		System.out.println(isAnagram("Tom Marvolo Riddle","I am Lord Voldemort")); // true

		// Tests the preProcess function.
		System.out.println(preProcess("What? No way!!!"));
		System.out.println(preProcess("William Shakespeare"));
		System.out.println(preProcess("I am a weakish speller"));

		// Tests the randomAnagram function.
		System.out.println("silent and " + randomAnagram("silent") + " are anagrams.");
	
		// Performs a stress test of randomAnagram 
		String str = "1234567";
		Boolean pass = true;
		//// 10 can be changed to much larger values, like 1000
		for (int i = 0; i < 10; i++) {
			String randomAnagram = randomAnagram(str);
			System.out.println(randomAnagram);
			pass = pass && isAnagram(str, randomAnagram);
			if (!pass) break;
		}
		System.out.println(pass ? "test passed" : "test Failed");
	}  

	// Returns true if the two given strings are anagrams, false otherwise.
	public static boolean isAnagram(String str1, String str2) {
		String str1n = preProcessnew(str1);
		String str2n = preProcessnew(str2);
		if (str1n.length() != str2n.length()) {
			return false;
		}
		for (int i = 0; i < str1n.length(); i++) {
			char c = str1n.charAt(i);
			int count1 = 0;
			int count2 = 0;
			for (int n = 0; n < str1n.length(); n++) {
				if (str1n.charAt(n) == c) {
					count1++;
				}
				if (str2n.charAt(n) == c) {
					count2++;
				}
			}
			if (count1 != count2) {
				return false; 
				}
		}
		return true;
	}
	   
	// Returns a preprocessed version of the given string: all the letter characters are converted
	// to lower-case, and all the other characters are deleted, except for spaces, which are left
	// as is. For example, the string "What? No way!" becomes "whatnoway"
	public static String preProcess(String str) {
		str = str.toLowerCase();
		int n = str.length();
		String newstr = "";
		for (int i = 0; i < n; i++){
			if (str.charAt(i) > 96 && str.charAt(i) < 123 || str.charAt(i) == 32 ) {
				newstr = newstr + str.charAt(i); 
			}
		}
		return newstr;
	} 

	public static String preProcessnew(String str) {
		str = str.toLowerCase();
		int n = str.length();
		String newstr = "";
		for (int i = 0; i < n; i++){
			if (str.charAt(i) > 96 && str.charAt(i) < 123) {
				newstr = newstr + str.charAt(i); 
			}
		}
		return newstr;
	} 
	   
	// Returns a random anagram of the given string. The random anagram consists of the same
	// characters as the given string, re-arranged in a random order. 
	public static String randomAnagram(String str) {
		String nstr = "";
		int size = str.length();
		for (int n = 0; n < size; n++){
			double a = (Math.random() * str.length());
			int r = (int) a;
			nstr = nstr + str.charAt(r);
			str = str.substring(0, r) + str.substring(r+1);
		}
		return nstr;
	}
}
