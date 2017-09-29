import java.util.Scanner;

public class scanner {
	static Scanner scanner = new Scanner(System.in);
	
	public static String requestString() {
		String res = "";
		res = scanner.nextLine();
		return res;
	}
	public static char requestWASDChar(){
		String resLine = "";
		char res;
		while(resLine.equals("")){
			resLine = scanner.nextLine();
		}
		res = resLine.charAt(0);
		switch(res){
		case 'w':
		case 'W':
		case 'a':
		case 'A':
		case 's':
		case 'S':
		case 'd':
		case 'D':
			return res;
		default:
			System.out.println("ERROR INVALID CHAR");
			return requestWASDChar();
		}
		
	}
}
