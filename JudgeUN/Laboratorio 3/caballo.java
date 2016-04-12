import java.util.*;

public class Main {
	public static void main (String[] args) {
		Scanner s = new Scanner(System.in);
		
		int[][] board = new int[64][64];
		
		for (int i = 0; i < 64; ++i) {
			for (int j = 0; j < 64; ++j){
				board[i][j] = Integer.MAX_VALUE;
			}
		}
		
		int UR = 17;
		int UL = 15;
		int LU = 6;
		int LD = -10;
		int DL = -17;
		int DR = -15;
		int RU = 10;
		int RD = -6;
		
		for (int x = 0; x < 64; ++x) {
			board[x][x] = 0;
			int xloc = x % 8;
			int yloc = x / 8;
			
			if (x + UR < 64 && xloc + 1 < 8 && yloc + 2 < 8) {
				board[x][x + UR] = 1;
			}
			
			if (x + UL < 64 && xloc - 1 >= 0 && yloc + 2 < 8) {
				board[x][x + UL] = 1;
			}
			
			if (x + LU < 64 && xloc - 2 >= 0 && yloc + 1 < 8) {
				board[x][x + LU] = 1;
			}
			
			if (x + LD >= 0 && xloc - 2 >= 0 && yloc - 1 >= 0) {
				board[x][x + LD] = 1;
			}
			
			if (x + DL >= 0 && xloc - 1 >= 0 && yloc - 2 >= 0) {
				board[x][x + DL] = 1;
			}
			
			if (x + DR >= 0 && xloc + 1 < 8 && yloc - 2 >= 0) {
				board[x][x + DR] = 1;
			}
			
			if (x + RU < 64 && xloc + 2 < 8 && yloc + 1 < 8) {
				board[x][x + RU] = 1;
			}
			
			if (x + RD >= 0 && xloc + 2 < 8 && yloc - 1 >= 0) {
				board[x][x + RD] = 1;
			}
		}
		
		int[][] lookup = floyds(board);
		
		while (s.hasNext()) {		
			String from = s.next();
			String to = s.next();
			
			int fx = from.charAt(0) - 'a';
			int fy = from.charAt(1) - '1';
			int tx = to.charAt(0) - 'a';
			int ty = to.charAt(1) - '1';
			
			int start = fx + 8 * fy;
			int finish = tx + 8 * ty;
			
			
			System.out.printf("To get from %s to %s takes %d knight moves.\n", from, to, lookup[start][finish]);
		}
	}
	
	public static int[][] floyds(int[][] adjacencyMatrix) {
		// Used as infinity
		final int I = Integer.MAX_VALUE;

		int[][] aMatrix = adjacencyMatrix;
		int n = aMatrix.length;
		for (int k = 0; k < n; ++k) {
			for (int i = 0; i < n; ++i) {
				for (int j = 0; j < n; ++j) {
					if (aMatrix[i][k] != I && aMatrix[k][j] != I && aMatrix[i][k] + aMatrix[k][j] < aMatrix[i][j]) {
						aMatrix[i][j] = aMatrix[i][k] + aMatrix[k][j];
					}
				}
			}
		}

		return aMatrix;
	}
}