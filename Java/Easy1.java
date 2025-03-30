public class Easy1{
	public static void main(String[] args) {
		int[] a = {1,2,3,4,6,7,3,1,3};
		int[] b = {2,5,7,8,3,2,5,2,3};
		int total = a.length + b.length;
		int[] result = new int[total];
		
		System.arraycopy(a,0,result,0,a.length);
		System.arraycopy(b,0,result,a.length,b.length);

		for(int i=0;i<total-1;i++)
			for (int j=i+1;j<total;j++)
				if(result[i]>result[j]){
					int swap =result[i];
					result[i]=result[j];
					result[j]=swap;
				}

		System.out.print("Result: ");
		for (int i=0; i<total; i++){
			System.out.print(result[i] + ", ");
		}
 }
}
	