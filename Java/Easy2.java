public class Easy2{
	public static void main(String[] args) {
		int[] a = {1,2,3,4,5,6,7,4,3,2,11,33,44,55,2,3,4,5,6,7,8,9}; 
		int swap;
		int total = a.length;
	
	for (int i=0; i<(total-1); i++){
		for (int j=0; j<total-i-1; j++){  
 				if (a[j] > a[j+1]){
					swap = a[j];
					a[j] = a[j+1];
					a[j+1] = swap;
	  		 	}
 			}
		}
	for (int i = 0; i < total;i++){
		if (a[i]%2 == 0)
			continue;
			System.out.print(a[i] + ", ");
	}

	for (int i = 0; i < total;i++){
		if (a[i]%2 != 0)
			continue;
			System.out.print(a[i] + ", ");
}
}
}
