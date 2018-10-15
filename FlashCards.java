import java.util.Scanner;

public class FlashCards
{
    /**
     * -------------------------------
     * Declare Constants
     * -------------------------------
     */

    private static final String MARQUEE = "========================================================";

    private static final int FIRST_GRADE  = 1 ;
    private static final int SECOND_GRADE = 2 ;
    private static final int THIRD_GRADE  = 3 ;
    private static final int FIRST_GRADE_QUESTIONS_CNT  = 4 ;
    private static final int SECOND_GRADE_QUESTIONS_CNT = 10 ;
    private static final int THIRD_GRADE_QUESTIONS_CNT  = 10 ;

    /**
     * -------------------------------
     * Main Method
     * -------------------------------
     */


    public static void main ( String[] args )
    {
        Scanner kboard = new Scanner ( System.in ) ;
        boolean playingGame = false ;

        int score = 0 ;


        // housekeeping - clear the contents of the console before we begin
        clearScreen () ;

        // welcome method - say hello to the student, hit enter to continue
        helloStudent ( kboard ) ;
        clearScreen () ;

        String studentName = getStudentName ( kboard ) ;

        System.out.println ( "\n\n\tWelcome " + studentName + "!" ) ;

        int studentGrade = getStudentGrade ( kboard, FIRST_GRADE, THIRD_GRADE ) ;

        String playerInput = getStringInput ( kboard, "\n\n\tDo you want to play Flash Cards? >> ");

        playingGame = checkForYes ( playerInput );

        while ( playingGame )
        {
            if ( studentGrade == FIRST_GRADE )
            {
                score = firstGradeFlashCards ( kboard, studentName, FIRST_GRADE_QUESTIONS_CNT );
                reportScore ( studentName, score, FIRST_GRADE_QUESTIONS_CNT );
            }

            // report the results
            // 1. print the marquee
            // 2. print the student's name and score
            // 3. calculate the percentage and print some logical encouragement
            // 4. print the marquee
            // 5. print < hit enter to continue >

            else if ( studentGrade == SECOND_GRADE )
            {
                score = secondGradeFlashCards ( kboard, studentName, SECOND_GRADE_QUESTIONS_CNT ) ;
                reportScore ( studentName, score, SECOND_GRADE_QUESTIONS_CNT );
            }

            // report the results
            // 1. print the marquee
            // 2. print the student's name and score
            // 3. calculate the percentage and print some logical encouragement
            // 4. print the marquee
            // 5. print < hit enter to continue >

            else
            {
                score = thirdGradeFlashCards ( kboard, studentName, THIRD_GRADE_QUESTIONS_CNT ) ;
                reportScore ( studentName, score, THIRD_GRADE_QUESTIONS_CNT );
            }




            // ask student if she / he wants to play Flash Cards again



            // if yes, then

            /*************************************************************
             *                                                           *
             *  P L A Y   F L A S H   C A R D S                          *
             *                                                           *
             *  In this section of code, play the version of             *
             *  FlashCards dependent on the grade level of the           *
             *  student.  As directed, the FlashCard levels are          *
             *  as follows:                                              *
             *  1.  firstGradeFlashCards: addition with numbers 0-10     *
             *  2.  secondGradeFlashCards: addition with numbers 0-100   *
             *  3.  thirdGradeFlashCards: subtraction with numbers0-100  *
             *                                                           *
             *************************************************************/

            //    if first grade, play firstGradeFlashCards
            //    else if second grade, play secondGradeFlashCards
            //    else play thirdGradeFlashCards

            // if no, call the goodbye method

            // ask student if she / he wants to play again

            // if yes, loop back to play

            // Keep playing?
            playerInput = getStringInput ( kboard, "\n\n\tKeep playing? >> ")
            ;

            playingGame = checkForYes ( playerInput ) ;
        }
        System.out.println ("\nThanks for playing!") ;
        kboard.close();
    }




    /**
     * -------------------------------
     * Declare Methods
     * -------------------------------
     */

    public static String getStringInput (Scanner kboard, String prompt)
    {
        // Create a variable to capture input from the keyboard

        // Capture the equation in an array

        System.out.print (prompt);

        String expr = kboard.nextLine();
        System.out.println ();

        return expr;
    }


    public static int getNumberInput (Scanner kboard, String prompt )
    {
        // Create a variable to capture input from the keyboard and get it

        System.out.print ( prompt ) ;
        int nextNumber = kboard.nextInt () ;
        String expr = kboard.nextLine();  // consumes the \n from nextInt
        System.out.println (expr);   // prints a blank line because expr is the \n from nextInt
        return nextNumber;
    }


    private static void helloStudent (Scanner kboard)
    {
        System.out.println (MARQUEE);
        System.out.println ();
        System.out.println ("\tH E L L O\n");
        System.out.println ("\tW E L C O M E   T O   F L A S H   C A R D S");
        System.out.println ();
        System.out.println ("\t\t< Press Enter to continue >");
        System.out.println ();
        System.out.println (MARQUEE);

        String studentInput = getStringInput (kboard, "");
        System.out.print ( studentInput );
    }


    public static int firstGradeFlashCards ( Scanner kboard, String studentName, int numberOfQuestions )
    {
        System.out.println ("I'm here in firstGradeFlashCards.");
        int score = 0 ;

        // loop through numberOfQuestions times
        // 1. clear the screen
        // 2. generate two random numbers 0-10
        // 3. print a math equation - addition only, using the two numbers
        // 3. retrieve the student's response
        // 4. determine if the response was correct
        // 5. if correct, increase score by one
        //
        for ( int i = 0; i < numberOfQuestions; i++ )
        {
            int number1 = (int)(Math.random() * 10) ;
            int number2 = (int)(Math.random() * 10) ;
            clearScreen () ;
            int studentResult = printEquation ( kboard, number1, number2, "+" ) ;

            if ( studentResult == ( number1 + number2 ) )
                score++;

        }
        return score ;
    }


    public static int secondGradeFlashCards ( Scanner kboard, String studentName, int numberOfQuestions )
    {
        System.out.println ("I'm here in secondGradeFlashCards.");
        int score = 0 ;

        // loop through numberOfQuestions times
        // 1. clear the screen
        // 2. generate two random numbers 10-99
        // 3. print a math equation - addition only, using the two digit numbers
        // 3. retrieve the student's response
        // 4. determine if the response was correct
        // 5. if correct, increase score by one
        //
        for ( int i = 0; i < numberOfQuestions; i++ )
        {
            int number1 = (int)(Math.random() * 100) ;
            int number2 = (int)(Math.random() * 100) ;
            clearScreen () ;
            int studentResult = printEquation ( kboard, number1, number2, "+" ) ;

            if ( studentResult == ( number1 + number2 ) )
                score++;
        }

        return score ;
    }

    public static int thirdGradeFlashCards ( Scanner kboard, String studentName, int numberOfQuestions )
    {
        System.out.println ("I'm here in thirdGradeFlashCards.");
        int score = 0 ;

        // loop through numberOfQuestions times
        // 1. clear the screen
        // 2. generate two random numbers 0-10
        // 3. print a math equation - mix of addition and subtraction, using the two numbers
        // 3. retrieve the student's response
        // 4. determine if the response was correct
        // 5. if correct, increase score by one
        //
        for ( int i = 0; i < numberOfQuestions; i++ )
        {
            int number1 = (int)(Math.random() * 100) ;
            int number2 = (int)(Math.random() * 100) ;
            clearScreen () ;
            if ( number2 > number1 )
            {
                int temp = number2 ;
                number2 = number1 ;
                number1 = temp ;
            }

            int studentResult = printEquation ( kboard, number1, number2, "-" ) ;

            if ( studentResult == ( number1 - number2 ) )
                score++;
        }

        return score ;
    }


    public static int printEquation ( Scanner kboard, int num1, int num2, String operator )
    {
        return getNumberInput ( kboard, "\n\n\t" + num1 + " " + operator + " " + num2 + " = " ) ;
    }


    public static void clearScreen()
    {
        for(int i = 0; i < 20; i++)
        {
            System.out.println("");
        }
    }

    public static String getStudentName ( Scanner kboard )
    {

        String studentName = getStringInput ( kboard, "\n\n\tPlease type your name >> ");

        return studentName ;
    }


    public static int getStudentGrade ( Scanner kboard, int limitLow, int limitHigh )
    {
        // getGrade method - prompt and validate grade 1-3
        int studentGrade = getNumberInput ( kboard, "\n\n\tWhat grade are you in? >> " );
        while ( studentGrade < limitLow || studentGrade > limitHigh )
        {
            System.out.println ( "\n\n\tPlease enter a grade between " + limitLow + " and " + limitHigh );
            studentGrade = getNumberInput ( kboard, "\n\tWhat grade are you in? >> " );
        }

        return studentGrade ;
    }


    public static boolean checkForYes ( String inputString )
    {
        return ( "Y".equals ( inputString.toUpperCase()) || "YES".equals (inputString.toUpperCase()) ) ;
    }


    public static void reportScore ( String studentName, int score, int totalQuestions )
    {
        clearScreen();
        System.out.println ( "\n\n\t" + studentName + ", you correctly answered " + score + " of " + totalQuestions ) ;
        double grade = (double) score / (double) totalQuestions ;
        System.out.print ( "\n\tYour score is " + ( grade * 100 ) + "%  ") ;
        if ( grade == 1.0 ) System.out.println ( "Excellent job!  Perfect score!  A+") ;
        else if ( grade > 0.9 ) System.out.println ( "Well Done.  Grade = A") ;
        else if ( grade > 0.8 ) System.out.println ( "Very Good.  Grade = B") ;
        else if ( grade > 0.7 ) System.out.println ( "Keep Practicing.  Grade = C") ;
        else System.out.println ( "Don't Give Up.  You can do better.  Grade = Bad times." ) ;
    }

}