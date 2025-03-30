public class Easy3{
	public static void main(String[] args) {
		int[] a = {1,14,17,7,25,3,100};
		int total = 7;
		int sum = 0;
		float avg;

		for(int i=0;i<total;i++){
		sum = sum+a[i];	
		}

		avg = sum/total;
		System.out.println("The average of the said array is: " + avg);

		System.out.println("The numbers in the said array that are greater than the average are: ");
		for(int i=0;i<total;i++){
			if(a[i] > avg)
				System.out.println(a[i]);
		}
	}
}
