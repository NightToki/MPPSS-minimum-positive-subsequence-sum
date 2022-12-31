import java.util.Arrays;
import java.util.Random;
import java.util.Scanner;

public class MPSS2 {
	public static int[] call(int n) {
		Random rand = new Random(); 
	
		int[] a = new int[n];
		for(int i = 0; i <n;i++) {
			a[i] = rand.nextInt(40)-20;
		}
		return a;
		
	}

	public static double midMPSS(double[] a) {
		 
	        int n = a.length;
	 
	        double[] sL = new double[(n + 1)/2];
	        double[] sR = new double[n - sL.length];
	 
	        for (int i = 0; i < n; i++)
	        {
	            if (i < sL.length) {
	            	sL[i] =  a[i];
	            }
	            else {
	            	sR[i - sL.length] =  a[i];
	            }
	        }
	        Arrays.sort(sL);
	        Arrays.sort(sR);
	        double[] temp = new double[sR.length];
	        int n2 = sR.length;
	        for(int i = 0; i<n2;i++) {
	        	temp[n2-1]=sR[i];
	        	n2--;
	        }
	        sR = temp;
	        double sMin = Double.POSITIVE_INFINITY;
	       
	        for(int i=0,j=0;i<sL.length&&j<sR.length;) {
	        	double s =  (sL[i]+sR[j]);
	        	if(s <=0) {
	        		i++;
	        	}
	        	else if(s<sMin) {
	        		sMin = s;
	        		j++;
	        	}
	        	else if(s>sMin) {
	        		j++;
	        	}
	        }
	        double midMPSS = (sMin);
	        
	        
		return midMPSS;
		
	}
	public static double leftMPSS(double[] a) {
		 int n = a.length;
	     double[] sL = new double[(n + 1)/2];
	     double[] sR = new double[n - sL.length];
	 
	        for (int i = 0; i < n; i++)
	        {
	            if (i < sL.length) {
	            	sL[i] =  a[i];
	            }
	            else {
	            	sR[i - sL.length] = (int) a[i];
	            }
	        }
		double left = midMPSS(sL);
		return left;
		
	}
	public static double rightMPSS(double[] a) {
		 int n = a.length;
	     double[] sL = new double[(n + 1)/2];
	     double[] sR = new double[n - sL.length];
	 
	        for (int i = 0; i < n; i++)
	        {
	            if (i < sL.length) {
	            	sL[i] =  a[i];
	            }
	            else {
	            	sR[i - sL.length] =a[i];
	            }
	        }
		double right = midMPSS(sR);
		return right;
	}
	
	
	
	public static void main(String[] args) {
		Scanner userInt = new Scanner(System.in);
		boolean loop = true;
		int n = 0;
		while(loop == true){
			System.out.println("Enter a valid positive integer: ");
			 n = userInt.nextInt();
			if(n<0) {
				System.out.println("Not valid positive integer");
				loop=true;
			}
			else {
				loop =false;
			}
		}
		//int[]a = call(n);
		double[]a = {2, -3, 1, 4, -6, 10, -12, 5.2, 3.6, -8};
		System.out.println(Arrays.toString(a));
		int size = a.length-1;
		double right = rightMPSS(a);
		double left = leftMPSS(a);
		double mid = midMPSS(a);
		System.out.println(right);
		System.out.println(left);
		System.out.println(mid);
		
		double compare = Math.min(right,left);
		double compare2 = Math.min(compare,mid);
	
		System.out.println(compare2);
	}
	
}
