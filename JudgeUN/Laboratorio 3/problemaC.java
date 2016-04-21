import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

class Main {

    static int a;
    static int [][]b;
    static List<Integer> outlist = new ArrayList<Integer>();

    static public int overflow(int x, int y, int t) {

        if (x >= a || y >= a || x < 0 || y < 0) {
            return 0;
        }

        if (b[x][y] != t) {
          
            return 0;
        }

       
        Integer index = x * a + y;
        int pos = outlist.indexOf(  index  );
        if (pos == -1) {
            return 0; 
        }
        outlist.remove( pos );

        int count = 1;
        count += overflow(x, y-1, t);
        count += overflow(x, y+1, t);
        count += overflow(x-1, y, t);
        count += overflow(x+1, y, t);
     

        return count;
    }

    static public void main(String args[]) {

        Scanner sc = new Scanner( System.in );

        while( sc.hasNextInt()) {

            a = sc.nextInt();

            if (a==0) {
                break;
            }

            sc.nextLine();

            b = new int[a][a];

            for( int i = 1; i < a; i++) {
                String line = sc.nextLine();
                //System.out.println(line);

                Scanner scline = new Scanner(line);
                while(scline.hasNextInt()) {
                    int x = scline.nextInt() - 1;
                    int y = scline.nextInt() - 1;
                    b[x][y] = i;
                }
            }

            outlist.clear();
            for( int i = 0; i < a * a; i++) {
                outlist.add( i );
            }

            boolean error = false;

            while(!outlist.isEmpty()) {
                int cur = outlist.get(0);

                int x = cur / a;
                int y = cur % a;

               
                int res = overflow(x,y, b[x][y]);

                if (res != a) {
                    error = true;
                    break;
                }

               
            }

            if (error) {
                System.out.println("wrong");
            } else {
                System.out.println("good");
            }

        }

    }
}