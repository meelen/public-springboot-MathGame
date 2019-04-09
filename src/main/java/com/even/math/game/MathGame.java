package com.even.math.game;

import org.junit.Test;

/**
 * This program prints the numbers from 1 to 100. 
 * The certain numbers will be replaced by certain words.
 * 
 * @author 梁敏  even@sina.com
 * @date 2019/04/09 12:55:12
 */
public class MathGame {
	private final static String STR_FIZZ = "Fizz";
	private final static String STR_BUZZ = "Buzz";
	private final static String STR_FIZZ_BUZZ = "FizzBuzz";
	private final static String STR_THREE = "3";
	private final static String STR_FIVE = "5";
	
	/**
	 * Stage1
	 */
	@Test
	public void printNumbers() {
		 String[] numbers = getPrintNumbers(100);
		 printArray(numbers);
	}

	/**
	 * Stage2
	 */
	@Test
	public void printNumbers2() {
		String[] numbers = getPrintNumbers2(100);
		printArray(numbers);
	}

	/**
	 * 1. A number is Fizz if it is divisible by 3
	 * 2. A number is Buzz if it is divisible by 5
	 * 3. A number is FizzBuzz if it is divisible by 3 and 5
	 * @param int numberCount
	 * @return String[] numbers
	 */
	public String[] getPrintNumbers(int numberCount) {
		String[] numbers = new String[numberCount];
		for (int i = numberCount-1; i >= 0; i--) {
			if (isMutiple(numberCount, 3) && isMutiple(numberCount, 5)) {
				numbers[i] = STR_FIZZ_BUZZ;
			} else if (isMutiple(numberCount, 3)) {
				numbers[i] = STR_FIZZ;
			} else if (isMutiple(numberCount, 5)) {
				numbers[i] = STR_BUZZ;
			} else {
				numbers[i] = String.valueOf(numberCount);
			}
			numberCount--;
		}
		return numbers;
	}

	/**
	 * 1. A number is Fizz if it is divisible by 3 or it has a 3 in it
	 * 2. A number is Buzz if it is divisible by 5 or it has a 5 in it
	 * 3. A number is FizzBuzz if it is divisible by 3 or 5 or if it has a 3 or 5 in it
	 * @param int numberCount
	 * @return String[] numbers
	 */
	public String[] getPrintNumbers2(int numberCount) {
		String[] numbers = new String[numberCount];
		for (int i = numberCount-1; i >= 0; i--) {
			if (isFizz(numberCount) && isBuzz(numberCount)) {
				numbers[i] = STR_FIZZ_BUZZ;
			} else if (isFizz(numberCount)) {
				numbers[i] = STR_FIZZ;
			} else if (isBuzz(numberCount)) {
				numbers[i] = STR_BUZZ;
			} else {
				numbers[i] = String.valueOf(numberCount);
			}
			numberCount--;
		}
		return numbers;
	}

	/**
	 * print a array
	 * @param String[] numbers
	 */
	public void printArray(String[] numbers) {
		for (int i = 0; i < numbers.length; i++) {
			System.out.println(numbers[i]);
		}
	}

	/**
	 * @param number
	 * @param multiple
	 * @return boolean: true if it is n multiples of the number, otherwise false
	 */
	public boolean isMutiple(int number, int n) {
		return Math.floorMod(number, n) == 0;
	}
	
	/**
	 * @param number
	 * @return boolean:  true if the number is divisible by 3 or it has a 3 in it
	 */
	public boolean isFizz(int number) {
		boolean flag = false;
		String numberStr = String.valueOf(number);
		if (isMutiple(number, 3) || numberStr.contains(STR_THREE)) {
			flag = true;
		}
		return flag;
	}
	
	/**
	 * @param number
	 * @return boolean:  true if the number is divisible by 5 or it has a 5 in it
	 */
	public boolean isBuzz(int number) {
		boolean flag = false;
		String numberStr = String.valueOf(number);
		if (isMutiple(number, 5) || numberStr.contains(STR_FIVE)) {
			flag = true;
		}
		return flag;
	}
	
}
