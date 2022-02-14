package genericUtility;

import java.util.Random;

/**
 * this class contains all java related generic methods
 * @author Aswathy
 *
 */
public class JavaUtility {

	/**
	 * this method returns the new number to every request
	 * @return
	 */
	public int getRandomNum() {
		Random randomNum = new Random();
		int val=randomNum.nextInt();
		return val;
	}
}