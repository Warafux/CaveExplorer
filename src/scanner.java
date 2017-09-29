import java.util.Scanner;

public class scanner {
	static Scanner scanner = new Scanner(System.in);
	
	public static String requestString() {
		String res = "";
		res = scanner.nextLine();
		return res;
	}
}
