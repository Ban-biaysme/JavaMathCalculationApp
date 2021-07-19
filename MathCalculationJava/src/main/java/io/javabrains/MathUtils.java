/**
* The MathUtils program implements a console based application that
* contains different math functions. Math function display the calculate 
* and display the result on the console.
* 
* @author  Biyas Banerjee
* @version 1.0
* @since   2021-07-19 
*/

package io.javabrains;
import java.util.Scanner;


public class MathUtils {

	// MathUtils() display the list of math operation and function according to user input
	public MathUtils() {
		
		System.out.println("========================================================");
		System.out.println("=======  M A T H  C A L C U L A T I O N  =======");
		System.out.println("========================================================");
		
		/**
		* Below code to take an input from the user and execute the function accordingly.
		* Switch case functionality helps the user to select option for math operations
		*/
		
		//below code to display the options to the user 
		System.out.println("Choose the following option \n"
				+ "1-> addition of two numbers \n "
				+ "2--> Difference of two numbers"
				+ "\n 3-> Product of two numbers \n"
				+ " 4-> Division of two numbers"
				+ "\n 5-> Product of two vectors"
				+ "\n 6-> Area of a circle  "
				+"7-> Exit from program" );
		
				@SuppressWarnings("resource")
				Scanner scan = new Scanner(System.in);
				System.out.println("Select An Option for math operation--");
				int userInput = scan.nextInt();

		/*
		 * While loop to continue the iteration until user select exit by giving int input
		 */
		while (userInput < 7) {
			
			/*
			 * switch case helps the user to execute the specific method from list
			 */
			switch (userInput) {
			
			case 1: {
				System.out.println("Addition of two numbers ");
				System.out.println("Sum: "+addition(3,4));
				break;
			}			
			case 2: {				
				System.out.println("Difference between two numbers");
				System.out.println("Difference : "+subtraction(9,4));
				break;
			}			
			case 3: {								
				System.out.println("Product of two numbers");
				System.out.println("Product :"+ product(19,4));
				break;
			}
			case 4: {								
				System.out.println("Division of two numbers");
				System.out.println("Quotient :"+ product(9,3));
				break;
			}
			case 5: {								
				System.out.println("Product of two vectors");
				int[] b= {3,4,3};
				int[] b2= {3,5,8};
				int[] result=productVector(b, b2);
				for (int i=0; i<result.length; i++) {
		            System.out.print(b[i]+ " X " + b2[i]+ " = " + result[i] +"\n");
		        }
				break;
			}
			case 6: {								
				System.out.println("Area of a circle");
				System.out.println("Area of the circle is : :"+ computeCircleArea(10));
				break;
			}
			case 7: {
				System.out.println("Exit from program");
				System.exit(0);
				break;
			}
			
		 } // end of switch

			/*
			 * After the first iteration it will check 
			 * do the user want to execute another function from the list or not
			 */
			//below code to display the options to the user 
			System.out.println("Choose the following option \n 1-> addition of two numbers \n "
					+ "2--> Difference of two numbers"
					+ "\n 3-> Product of two numbers \n 4-> Division of two numbers"
					+ "\n 5-> Product of two vectors"
					+ "\n 6-> Area of a circle  "
					+"7-> Exit from program" );
			System.out.println("======================================================================");
			
			System.out.println("Select Option");
			userInput = scan.nextInt();
		} //end of while
		
	}
	
	/**
	 * addition() take two parameter calculate and display the result
	  * @param num1 This is the first parameter to addNum method
	 * @param num2  This is the second parameter to addNum method
	 * @return int This returns sum of num1 and num2
	 */	
	
	public int addition(int num1, int num2) {		
		return num1+num2;				//return the sum of two numbers
	}
	
	/**
	 * subtraction() take two parameter calculate and display the result
	 * @param num1 This is the first parameter to addNum method
	 * @param num2  This is the second parameter to addNum method
	 * @return int This returns difference of num1 and num2.
	 */	
	
	public int subtraction(int num1, int num2) {
		return num1-num2;			//return the difference between numbers
	}
	
	/**
	 * product() take two parameter calculate and display the result
	 * @param num1 This is the first parameter to product method
	 * @param num2  This is the second parameter to product method
	 * @return int This returns product of num1 and num2
	 */
	public int product(int num1, int num2) {
		return num1*num2;		//return the product of two numbers
	}
	
	/**
	 * division() take two parameter calculate and display the result
	 * @param num1 This is the first parameter to division method
	 * @param num2  This is the second parameter to division method
	 * @return double This returns quotient of num1 and num2 
	 * @exception ArithmeticException On input error.
	 */
	
	public double division(double a, double b) throws ArithmeticException{
			double div=0;
			
			if(b==0)
				throw new ArithmeticException("Number divided by zero");
			try
	        {
				div=a/b;
	        }
			catch(ArithmeticException ex) 
	        {
	            throw ex;
	        }
			return div;		//return the quotient 
		}
	
	/**
	 * productVector() take two parameters array calculate and display the result
	 * @param vectA This is the first parameter as an integer array productVector method
	 * @param vectB  This is the second parameter as an integer array productVector method
	 * @return the product as an array 
	 * @exception InputMismatchException On input error.
	 */
	public int[] productVector(int[] vectA, int[] vectB) throws java.util.InputMismatchException{
		int[] productVec=null;
		
		if(vectA.length != vectB.length) {
			System.out.println("Both array are not same size");
			  throw new java.util.InputMismatchException("Both array are not same size");
		}else {
		   productVec= new int[vectA.length];			
			  for (int i = 0; i < vectA.length; i++) {
			   productVec[i] = vectA[i] * vectB[i];		  		   
		      }
		}
		  return productVec;	
	}
	
	/**
	 * computeCircleArea() take two parameter calculate and display the area of a circle
	 * @param radius takes the radius of the circle
	 * @return double This returns the area of circle
	 */
	public double computeCircleArea(double radius) {
		//Math.PI used to get the actual value of pi
		double area= Math.PI*radius*radius;
		return area;
	}
	
	 /**
	   * This is the main method which makes use of addNum method.
	   * @param args Unused.
	   * @return Nothing.
	   */
	public static void main(String[] args) {
		new MathUtils();
	}
	
}
