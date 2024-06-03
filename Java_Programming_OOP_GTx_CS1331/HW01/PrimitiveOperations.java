    /* a) First, declare and initialize two variables, an integer type (byte, short, int, or long) and a floating point value (float or double). 
          The names and values can be whatever you like, for this step and all others. Make sure that the numbers you choose can be stored within 
          the respective primitive type you choose. Print each of these values out on their own line using `System.out.println()`.
       b) Multiply these variables together, and assign the outcome to a `new` variable, ensuring that no data is lost. For example, if I 
          multiply 5 and 3.5, the answer should be 17.5. Print out this new value.
       c) Use casting to convert the integer from the first step to a floating point value and store that in another `new` variable. Print out the value.
       d) Use casting to convert the floating point value from the first step to an integer type and store that in a `new` variable.  Print out the value.
       e) Shifting focus, declare a `char` variable, and assign an uppercase letter to it. Print out this value.
       f) Using a *numerical operation*, change the letter to the same letter, but in lowercase. Use a numerical operation - do not reassign the variable. 
          You may want to review a [table of ASCII values](https://ascii.cl/) as you're working on this section. Print out the new `char` value.
          **Hint:** you'll likely have to use casting to get this to work.
    */

public class PrimitiveOperations {
    //TODO: Start your code after this line
    public static void main(String[] args) {
        // Declare, initialize, and print two variables
        int numOne = 327;
        float numTwo = 2.2f;
        System.out.println(numOne);
        System.out.println(numTwo);
        
        // Multiply and print result
        float numOneTimesNumTwo = numOne * numTwo;
        System.out.println(numOneTimesNumTwo);
        
        // Cast numOne as float and print
        float numOneAsFloat = numOne;
        System.out.println(numOneAsFloat);

        // Cast numOne as int and print
        int numOneAsInt = (int) numOneAsFloat;
        System.out.println(numOneAsInt);
        
        // Declare, initialize, and print character
        char someCharacter = 'A';
        System.out.println(someCharacter);
        
        // Convert "A" to "a" numerically
        // 1. Get ASCII value of "A"
        int someCharacterAscii = (int) someCharacter;
        // 2. Add 32 to get lowercase, then convert ascii to char and print
        int someCharacterLowerCaseAscii = someCharacterAscii + 32;
        char someCharacterLowerCase = (char) someCharacterLowerCaseAscii;
        System.out.println(someCharacterLowerCase);
    }
}
