package com.mytestpractice;

public class LengthOfLastWord {

	public static int getLastWordLength(String s) {
		s=s.trim();
		return s.substring(s.lastIndexOf(" ")+1).length();
		
	}
	

    public static void main(String[] args) {
        // Test cases
        String s1 = "Hello World";
        System.out.println("Length of last word in \"" + s1 + "\": " + getLastWordLength(s1)); // Expected: 5

        String s2 = "   fly me   to   the moon  ";
        System.out.println("Length of last word in \"" + s2 + "\": " + getLastWordLength(s2)); // Expected: 4 ("moon")

        String s3 = "luffy is still joyboy";
        System.out.println("Length of last word in \"" + s3 + "\": " + getLastWordLength(s3)); // Expected: 6 ("joyboy")

        String s4 = "a";
        System.out.println("Length of last word in \"" + s4 + "\": " + getLastWordLength(s4)); // Expected: 1

        String s5 = "";
        System.out.println("Length of last word in \"" + s5 + "\": " + getLastWordLength(s5)); // Expected: 0

        String s6 = "   ";
        System.out.println("Length of last word in \"" + s6 + "\": " + getLastWordLength(s6)); // Expected: 0

        String s7 = "HelloWorld";
        System.out.println("Length of last word in \"" + s7 + "\": " + getLastWordLength(s7)); // Expected: 10
    }
}
