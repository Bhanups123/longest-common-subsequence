import java.util.Scanner;
class longest_common_subsequence{
	static int[][] lcs_matrix;
	static char[] arr_first, arr_second;

	static void lcs(char[] arr_f, char[] arr_s){
		arr_first = arr_f;
		arr_second = arr_s;

		lcs_matrix = new int[arr_first.length+1][arr_second.length+1];

		for(int i=1; i<= arr_first.length; i++)
			for(int j=1; j<= arr_second.length; j++){
				if(arr_first[i-1]== arr_second[j-1])
					lcs_matrix[i][j]= 1+ lcs_matrix[i-1][j-1];
				else
					lcs_matrix[i][j]= lcs_matrix[i-1][j]> lcs_matrix[i][j-1]? lcs_matrix[i-1][j]: lcs_matrix[i][j-1];
			}
	}
	static void print_lcs(int i, int j)
	{
		if(i==0||j==0)
			return;

		if(arr_first[i-1]== arr_second[j-1]){
			print_lcs(i-1, j-1);
			System.out.print(arr_first[i-1]);
		}
		else{
			if(lcs_matrix[i-1][j]== lcs_matrix[i][j-1]){
				print_lcs(i, j-1);
				//System.out.print(" ");
				//print_lcs(i-1, j);
			}
			else if(lcs_matrix[i][j-1]> lcs_matrix[i-1][j])
				print_lcs(i, j-1);
			else
				print_lcs(i-1, j);
		}
	}
	public static void main(String[] args) {
		Scanner inp= new Scanner(System.in);
		System.out.println("enter 2 strings:");
		String first = inp.nextLine();
		String second = inp.nextLine();

		arr_first = first.toCharArray();
		arr_second = second.toCharArray();
		
		longest_common_subsequence.lcs(arr_first, arr_second);
		for(int i=0; i<= arr_first.length; i++){
			for(int j=0; j<= arr_second.length; j++){
				System.out.print(lcs_matrix[i][j]+" ");
			}
			System.out.println();
		}
		longest_common_subsequence.print_lcs(arr_first.length, arr_second.length);
	}
}
