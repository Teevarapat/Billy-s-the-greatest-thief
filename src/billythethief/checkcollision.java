package billythethief;

public class checkcollision {


	public static boolean collide(float pX, float pY, float x, float y) {
		if(pX <= x + 30 && pX >= x) {
			System.out.println("X axis pass");
			if(pY == y) {
				System.out.println("Y axis pass");
				return true;
			}
		}
		return false;
	}
}
