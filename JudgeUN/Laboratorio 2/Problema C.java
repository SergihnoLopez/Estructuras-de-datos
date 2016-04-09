import java.util.Scanner;

public class Main
{

    public static void main(String[] args)
    {

        Scanner sc = new Scanner(System.in);

        int c=sc.nextInt();
        int[] objetive = new int[c];

        for(int i=0; i<c; i++)
        {
            objetive[i]=sc.nextInt();
        }
        int n=sc.nextInt();
        sc.nextLine();
        int[][] darlings= new int[n][100000];
        int max=0;
//***************************************************************
        for(int i=0; i<n; i++)
        {
            String s=sc.nextLine().trim();
            String[] id= s.split(" ");
            if(id.length> max)
            {
                max=id.length;
            };
            for(int p=0; p<id.length; p++)
            {
            }
            for(int a=0; a<id.length; a++)
            {
                darlings[i][a]=Integer.parseInt(id[a]);
            }
        }
//***************************************************************
        int count=0;
        int count2=0;
//***************************************************************
        for(int a=0; a<n; a++)
        {
            count=0;
            for(int t=0; t<c; t++)
            {
                for(int i=0; i<max; i++)
                {
                    if(objetive[t]==darlings[a][i])
                    {
                        count++;
                    }
                    if(count==objetive.length)
                    {
                        count2++;
                        break;
                    }
                    if(objetive[t]==darlings[a][i])
                    {
                        break;
                    }
                }
            }
        }
//*******************************************************************
        System.out.println(count2);


    }
}
