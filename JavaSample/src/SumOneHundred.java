import java.math.BigInteger;
import java.util.Stack;

public class SumOneHundred {

	public static void main(String[] args) {
		SumOneHundred sum = new SumOneHundred();
		sum.sumOneToOneHundred();
		sum.getFactorial(100);
		sum.verifyString("토마토");

		User user1 = new User("영감");
		User user2 = new User("영감");

		if (user1.equals(user2)) {
			System.out.println("object-true");
		} else {
			System.out.println("object-false");
		}
		
	}

	public void sumOneToOneHundred() {
		// 1~100까지 더하자 5050 = 101 * 50

		int result = 0;
		int target = 100;
		for (int i = 1; i < 51; i++) {

			if (i == 50) {
				System.out.println("!");
			}

			result += target + i;
			target--;
		}

		System.out.println(result);
		System.out.println(101 * 50);
	}

	public void getFactorial(int param) {
		int x = param;
		int result = 1;

		for (int i = 1; i < (x + 1); i++) {
			result = (result * i);
			System.out.println(result);
		}

		BigInteger fac = BigInteger.ONE;

		for (int i = 1; i <= x; i++)
			fac = fac.multiply(BigInteger.valueOf(i));

		System.out.println(fac);
	}

	public void verifyString(String message) {
		Stack<String> stack = new Stack<String>();
		int j = 1;

		for (int i = 0; i < message.length(); i++) {
			stack.add(message.substring(i, j));
			j++;
		}

		String temp = "";

		for (int i = 0; i < message.length(); i++) {
			temp += stack.pop();
		}

		System.out.println(temp);
		if (message.equals(temp)) {
			System.out.println("true");
		} else {
			System.out.println("false");
		}
	}
}
