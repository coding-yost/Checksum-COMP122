import java.util.Scanner;

class checksum  
{  

  public static void main(String args[]) {

    final int max_int = 255;  // The maximum size for the input
    int count = 10;           // The number of integers to read from indexInt
    int sum = 0;              // Note that the "sum" might exceed max_int
    int checksum = 0;         // The value of the 6th input integer
    int quotient;             // The result of evaluating the assignment:  quotient   = sum / (max_int + 1);
    int remainder;            // The result of evaluating the assignment:  remainder  = sum % (max_int + 1 );
    int complement;           // The result of evaluationg the assignment: complement = max_int - sum;
    
    Scanner stdin = new Scanner(System.in);
    //int arr[] = new int[] {45, 2, 16, 5, 12, 156, 55, 17, 192, 10};

/*
    Write a Java program that computes a simple checksum of 8-bit integers. This program is based upon the calculation of the checksum value of a IPv4 header, defined by RFC791.
    Time the execution of your program, as well as two other programs provided by the professor.
    This program should conform to the following specification:
    Program name: checksum.java
*/
    int indexInt;   //Reads 10 non-negative integers from standard input (indexInt), with each integer value in the range of 0..2^8-1 (I.e., 0..255).

    for(int i = 0; i < count; ++i) {
        
        //indexInt = arr[i];
        indexInt = Integer.parseInt(stdin.nextLine());
        System.out.println("Parse Int...");
        if (indexInt > 0 && indexInt < max_int) {
            
            if(i == 5){ //Stores the 6th input integer into a variable called "checksum", and resets this input value to zero (0).
            
            checksum = indexInt;

            System.out.println("Checksum:\t" + checksum);

            indexInt = 0;
            }   //end if

            else {
            System.out.print(sum + " + " + indexInt);
            sum += indexInt;    //Stores the sum of the integers read from indexInt into a variable called "sum".
            System.out.println("Sum:\t" + sum);
            }

        }   //end if
        
        else {
            System.err.printf("Error Detected!\n");  
        }   //end else
    }   //end for

    quotient = sum / (max_int + 1);     //Performs integer division on this sum using 2^8 as the divisor to yield both a quotient and a remainder. 
    System.out.println("Quotient:\t" + quotient);
    remainder = sum % (max_int + 1);    //These values are then stored in the variables "quotient" and "remainder", respectively.
    System.out.println("Remainder:\t" + remainder);
    sum = quotient + remainder;         //Adds the values of "quotient" and "remainder" together, and stores this value into the variable "sum".
    System.out.println("New Sum:\t" + sum);
    complement = max_int - sum;         //Subtracts this new value of "sum" from 2^8-1, and stores the result in a variable called "complement".
    System.out.println("MAX_INT - sum:\t" + complement);

    

    System.out.printf("Stored Checksum: %d, Computed Checksum: %d\n", checksum, complement);    //Outputs the value of "checksum" and "complement" to standard output (System.out).
    if (checksum != complement ) {      //If the value of "checksum" and "complement" are not the same, outputs the string "Error Detected!" to standard error (stderr).
      System.err.printf("Error Detected!\n");  
    }   //end if
    
    stdin.close();

  } //end main
}   //end classs