package regex;
/*
 **************************************************************************
 * (C) Copyright 1992-2005 by Deitel & Associates, Inc. and               *
 * Pearson Education, Inc. All Rights Reserved.                           *
 *                                                                        *
 * DISCLAIMER: The authors and publisher of this book have used their     *
 * best efforts in preparing the book. These efforts include the          *
 * development, research, and testing of the theories and programs        *
 * to determine their effectiveness. The authors and publisher make       *
 * no warranty of any kind, expressed or implied, with regard to these    *
 * programs or to the documentation contained in these books. The authors *
 * and publisher shall not be liable in any event for incidental or       *
 * consequential damages in connection with, or arising out of, the       *
 * furnishing, performance, or use of these programs.                     *
 **************************************************************************
*/

import java.util.Scanner;
//Fig. 29.21: InputValidationTest
	// Validate user information using regular expressions.
public class InputValidationTest {
	
	  public static void main( String[] args ) {
	      // get user input
	      Scanner scanner = new Scanner( System.in );
	      System.out.println( "Please enter first name:" );
	      String firstName = scanner.nextLine();
		  if ( !InputValidationExample.validateFirstName( firstName ) )
			  System.out.println( "Invalid first name" );

	      System.out.println( "Please enter last name:" );
	      String lastName = scanner.nextLine();
		  if ( !InputValidationExample.validateLastName( lastName ) )
			  System.out.println( "Invalid last name" );

	      System.out.println( "Please enter address:" );
	      String address = scanner.nextLine();
		  if ( !InputValidationExample.validateAddress( address ) )
			  System.out.println( "Invalid address" );

	      System.out.println( "Please enter city:" );
	      String city = scanner.nextLine();
		  if ( !InputValidationExample.validateCity( city ) )
			  System.out.println( "Invalid city" );

	      System.out.println( "Please enter zip:" );
	      String zip = scanner.nextLine();
		  if ( !InputValidationExample.validateZip( zip ) )
			  System.out.println( "Invalid zip code" );

	      System.out.println( "Please enter phone:" );
	      String phone = scanner.nextLine();
		  if ( !InputValidationExample.validatePhone( phone ) )
			  System.out.println( "Invalid phone number" );

	     System.out.println( "Valid input.  Thank you." );
	   } // end main
	} // end class Validate



	
