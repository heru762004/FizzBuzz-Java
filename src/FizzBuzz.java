/**
 * FizzBuzz.java
 * Write a program that prints the numbers from 1 to 100. But for multiples of three print “Fizz” instead of the number and for the multiples of five print “Buzz”. For numbers which are multiples of both three and five print “FizzBuzz”
 * For a number which is not divisible by 3 or 5, print the number
 * 
 * @author heru
 *
 */

public class FizzBuzz {
	public String[] fizzBuzz_1(int start, int end) {
		// make array result to return the result
		// size is end - start
		String ans[] = new String[(end - start)];
		// to store the current position of the array result
		int pos = 0;
		for(int i=start; i < end; i++) {
			String a = "";
			// if its divisible by 5, print "Fizz"
			if(i % 3 == 0) a += "Fizz";
			// if its divisible by 5, print "Buzz"
			if(i % 5 == 0) a += "Buzz";
			// if its not divisible by 3 or 5, the a keeps empty
			if(a.length() == 0) a=i+"";
			ans[pos++] = a;
		}
		return ans;
	}
	
	public String[] fizzBuzz_2(int start, int end) {
		// make array result to return the result
		// size is end - start
		String ans[] = new String[(end - start)];
		// to store the current position of the array result
		int pos = 0;
		for(int i=start; i < end; i++) {
			String a = "";
			// if its divisible by 3 and 5, print "FizzBuzz"
			if(i % 3 == 0 && i % 5 == 0) a = "FizzBuzz";
			// if its divisible by 5, print "Fizz"
			else if(i % 3 == 0) a = "Fizz";
			// if its divisible by 5, print "Buzz"
			else if(i % 5 == 0) a = "Buzz";
			// if its not divisible by 3 or 5, the a keeps empty
			else a=i+"";
			ans[pos++] = a;
		}
		return ans;
	}
	
	public static void main(String[] args) {
		FizzBuzz a = new FizzBuzz();
		String result[] = a.fizzBuzz_1(1, 100);
		for(int i=0; i < result.length; i++) {
			System.out.println(result[i]);
		}
		
		String result2[] = a.fizzBuzz_2(1, 100);
		for(int i=0; i < result2.length; i++) {
			System.out.println(result2[i]);
		}
	}

}
