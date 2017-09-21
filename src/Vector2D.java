
public class Vector2D {
	private int x = 0;
	private int y = 0;
	public static void main(String[] args) {
		//TEST DISTANCE FUNCTION
		//System.out.println(distance(new Vector2D(10,2), new Vector2D(99, -25)));
	}
	public Vector2D(int x, int y) {
		this.x = x;
		this.y = y;
	}
	
	public int getX(){
		return this.x;
	}
	public int getY(){
		return this.y;
	}
	
	public static double distance(Vector2D v1, Vector2D v2) {
		return Math.sqrt(
			(
			Math.pow(v1.getX() - v2.getX(), 2)
				+
			Math.pow(v1.getY() - v2.getY(), 2)
			)
		);
	}
}
