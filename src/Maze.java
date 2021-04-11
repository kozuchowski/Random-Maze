import java.util.Arrays;

public class Maze {
	static char[][] field = new char[20][20];
	static int enter = (int) Math.floor(Math.random() * 10);
	static int exit = (int) Math.floor(Math.random() * 10);
	static int direction;
	static int i = enter;
	static int j = 0;
	static boolean check;
	static boolean maze(int x, int y) {
		direction = (int) Math.floor(Math.random() * 4);
		
		if(direction == 0 && y + 1 < field[x].length) {
			field[x][y + 1] = '_';
			 
			if(x == exit && y + 1 == 14) {
				check = true;
			}
			maze(x, y + 1);
		}else if(direction == 1 && y > 0) {
			field[x][y - 1] = '_';
//			y -= 1;
			if(x == exit && y == 14) {
				check = true;
			}
			maze(x, y - 1);
		}else if(direction == 2 && x + 1 < field.length) {
			field[x + 1][y] = '_';
//			x += 1;
			if(x == exit && y == 14) {
				check = true;
			}
			maze(x + 1, y);
		}else if(direction  == 3 && x > 0) {
			field[x - 1][y] = '_';
//			x -= 1;
			if(x == exit && y == 14) {
				check = true;
			}
			maze(x - 1, y);
		}
//		maze(x, y);
		if(check)
			return true;
		maze(x, y);
		return false;
	}
	public static void main(String[] args) {
		
		
		for(int i = 0; i < field.length; i++) {
			for(int j = 0; j < field[0].length; j++) {
				field[i][j] = 'I';
			}
		}
		maze(i, j);
		
		field[enter][0] = 'X';
		field[exit][field.length - 1] = 'O';
		for(int i = 0; i < field.length; i++) {
			System.out.println(Arrays.toString(field[i]));
		}
		
	}

}
