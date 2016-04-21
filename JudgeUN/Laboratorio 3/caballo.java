import java.util.*;

public class Main {
	public static void main (String[] args) {
		Scanner s = new Scanner(System.in);
		
		int[][] tablero = new int[64][64];
		int UR = 17;
		int UL = 15;
		int LU = 6;
		int LD = -10;
		int DL = -17;
		int DR = -15;
		int RU = 10;
		int RD = -6;
		
		
		
		for (int i = 0; i < 64; ++i) {
			for (int j = 0; j < 64; ++j){
				tablero[i][j] = Integer.MAX_VALUE;
			}
		}
		
		
		
		for (int casilla = 0; casilla < 64; ++casilla) {
			tablero[casilla][casilla] = 0;
			int casillaloc = casilla % 8;
			int yloc = casilla / 8;
			
			if (casilla + UR < 64 && casillaloc + 1 < 8 && yloc + 2 < 8) {
				tablero[casilla][casilla + UR] = 1;
			}
			
			if (casilla + UL < 64 && casillaloc - 1 >= 0 && yloc + 2 < 8) {
				tablero[casilla][casilla + UL] = 1;
			}
			
			if (casilla + LU < 64 && casillaloc - 2 >= 0 && yloc + 1 < 8) {
				tablero[casilla][casilla + LU] = 1;
			}
			
			if (casilla + LD >= 0 && casillaloc - 2 >= 0 && yloc - 1 >= 0) {
				tablero[casilla][casilla + LD] = 1;
			}
			
			if (casilla + DL >= 0 && casillaloc - 1 >= 0 && yloc - 2 >= 0) {
				tablero[casilla][casilla + DL] = 1;
			}
			
			if (casilla + DR >= 0 && casillaloc + 1 < 8 && yloc - 2 >= 0) {
				tablero[casilla][casilla + DR] = 1;
			}
			
			if (casilla + RU < 64 && casillaloc + 2 < 8 && yloc + 1 < 8) {
				tablero[casilla][casilla + RU] = 1;
			}
			
			if (casilla + RD >= 0 && casillaloc + 2 < 8 && yloc - 1 >= 0) {
				tablero[casilla][casilla + RD] = 1;
			}
		}
		
		int[][] buscar = Grises(tablero);
		
		while (s.hasNext()) {		
			String desde = s.next();
			String hasta = s.next();
			
			int fx = desde.charAt(0) - 'a';
			int fy = desde.charAt(1) - '1';
			int tx = hasta.charAt(0) - 'a';
			int ty = hasta.charAt(1) - '1';			
			int inicio = fx + 8 * fy;
			int fin = tx + 8 * ty;
			
			
			System.out.printf("To get from %s to %s takes %d knight moves.\n", desde, hasta, buscar[inicio][fin]);
		}
	}
	
	public static int[][] Grises(int[][] matrixAdyacente) {
		//UTILIZADO COMO INFINITO
		final int I = Integer.MAX_VALUE;

		int[][] aMatrix = matrixAdyacente;
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