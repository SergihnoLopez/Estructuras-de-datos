import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;


public class Main
{

    static BufferedReader line= new BufferedReader (new InputStreamReader (System.in));
    static int  count, sum,sum2;
    static  int [] list;

    public static void main(String[] args) throws NumberFormatException, IOException
    {
        int tamano,numCase;
        boolean flag, flag2=true;
        char [][] choco;
        String [] out;
        // System.out.println("ingrese el numero de casos");
        numCase=Integer.parseInt(line.readLine());
        out=new String[numCase];

        for (int i = 0; i < numCase; i++)
        {
            //System.out.println("tamano del chocolate ");
            tamano=Integer.parseInt(line.readLine());
            choco= new char [tamano][tamano];
            fill( choco,tamano);
            flag=cutRow(choco,tamano);
            flag2=cutCol(choco,tamano);
            if(flag==true||flag2==true)
                out[i]="YES";
            else
                out[i]="NO";
        }
        for (int i = 0; i < out.length; i++)
            System.out.println(out[i]);

    }

    public static char[][] fill(char a[][],int n) throws IOException
    {
        for (int i = 0; i <n; i++)
        {
            a[i]=line.readLine().toCharArray();
        }
        return  a;
    }

    public static boolean cutRow (char a[][], int n) throws IOException
    {
        list=new int[n];
        boolean flag=true;
        for (int i = 0; i <n; i++)
        {
            count=0;
            for (int j = 0; j < n; j++)
            {
                if(a[i][j]=='#')
                {
                    count++;
                }
            }
            list[i]=count;
        }
        for (int i = 0; i <list.length; i++)
        {
            sum+=list[i];
        }
        for (int i = 0; i < list.length; i++)
        {
            sum2+=list[i];
            if(sum2==sum-sum2)
            {
                flag=true;
                break;
            }
        }
        if(sum2!=sum-sum2)
        {
            flag=false;
        }
        sum=0;
        sum2=0;
        return flag;
    }

    public static boolean cutCol (char a[][], int n) throws IOException
    {
        list=new int[n];
        boolean flag= true;
        for (int i = 0; i <n; i++)
        {
            count=0;
            for (int j = 0; j < n; j++)
            {
                if(a[j][i]=='#')
                {
                    count++;
                }
            }
            list[i]=count;
        }
        for (int i = 0; i <list.length; i++)
        {
            sum+=list[i];
        }
        for (int i = 0; i < list.length; i++)
        {
            sum2+=list[i];
            if(sum2==sum-sum2)
            {
                flag = true;
                break;
            }
        }
        if(sum2!=sum-sum2)
        {
            flag=false;
        }
        sum=0;
        sum2=0;
        return flag;
    }


}
