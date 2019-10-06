import java.util.*;
import java.io.*;

class LCS{

	static void lcs(String A,String B,int m,int n)
	{
		int[][] table= new int[m+1][n+1];

		for(int i=0;i<=m;i++)
		{
			for(int j=0;j<=n;j++)
			{
				if(i==0 || j==0)
					table[i][j]=0;
				else if(A.charAt(i-1)==B.charAt(j-1))
					table[i][j]=table[i-1][j-1]+1;
				else
					table[i][j]=Math.max(table[i-1][j],table[i][j-1]);

			for(int p=0;p<=m;p++)
			{
				for(int q=0;q<=n;q++)
				{
					System.out.print("  "+table[p][q]);
				}
				System.out.println();
			}
			System.out.println();



			}
		}
		for(int i=0;i<=m;i++)
		{
			for(int j=0;j<=n;j++)
			{
				System.out.print("  "+table[i][j]);
			}
			System.out.println();
		}
		System.out.println();
		
	
		int index=table[m][n];
		int temp=index;

		char[] lcs=new char[index+1];
		int[][] lab= new int[m+1][n+1];


		lcs[index]=0;
		int i=m, j=n;
		//lab[m][n]=table[m][n];

		

		while(i>0 && j>0)
		{
			if(A.charAt(i-1)==B.charAt(j-1))
			{
				lcs[index-1] = A.charAt(i-1);
				if(table[i-1][j]==table[i][j-1]){
					lab[i-1][j]=table[i-1][j];
				}
				i--;
				j--;
				index--;
			}
			else if(table[i-1][j] > table[i][j-1])
				i--;
			else
				j--;
		}
		System.out.println("this is the intermediate matrix")
		for(i=0;i<=m;i++)
		{
			for(j=0;j<=n;j++)
			{
				System.out.print("  "+lab[i][j]);
			}
			System.out.println();
		}
		System.out.println();


		System.out.print("LCS of "+A+" and "+B+" is --- ");
		for(int k=0;k<temp;k++)
			System.out.print(lcs[k]+"  ");

	}



	public static void main(String args[])
	{
		int m,n;
		Scanner sc=new Scanner(System.in);
		System.out.println("Enter the first String");
		String a = sc.nextLine();
		System.out.println("Enter the second String");
		String b = sc.nextLine();
		m=a.length();
		n=b.length();

		lcs(a,b,m,n);
	}	
}