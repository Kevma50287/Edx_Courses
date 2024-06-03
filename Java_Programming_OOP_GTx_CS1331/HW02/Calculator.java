import java.util.Scanner;

public class Calculator {
  public static void main (String[] args){
    Scanner input = new Scanner(System.in);
    System.out.println("List of operations: add subtract multiply divide alphabetize");
    System.out.println("Enter an operation:");
    String operation = input.nextLine().toLowerCase().trim();
    double inputOne, inputTwo, result;
    switch (operation) {
      case "add":
        System.out.println("Enter two integers:");
        try {
          inputOne = input.nextInt();
          inputTwo = input.nextInt();
        } catch (Exception e) {
          System.out.println("Invalid input entered. Terminating...");
          break;
        }
        result = inputOne + inputTwo;
        System.out.println("Answer: " + (int)result);
        break;
      case "subtract":
        System.out.println("Enter two integers:");
        try {
          inputOne = input.nextInt();
          inputTwo = input.nextInt();
        } catch (Exception e) {
          System.out.println("Invalid input entered. Terminating...");
          break;
        }
        result = inputOne - inputTwo;
        System.out.println("Answer: " + (int)result);
        break;
      case "multiply":
        System.out.println("Enter two doubles:");
        try {
          inputOne = input.nextDouble();
          inputTwo = input.nextDouble();
        } catch (Exception e) {
          System.out.println("Invalid input entered. Terminating...");
          break;
        }
        result = inputOne * inputTwo;
        System.out.println("Answer: " + String.format("%.2f", result));
        break;
      case "divide":
        System.out.println("Enter two doubles:");
        try {
          inputOne = input.nextDouble();
          inputTwo = input.nextDouble();
        } catch (Exception e) {
          System.out.println("Invalid input entered. Terminating...");
          break;
        }
        if (inputTwo == 0){
          System.out.println("Invalid input entered. Terminating...");
          break;
        }
        result = inputOne / inputTwo;
        System.out.println("Answer: " + String.format("%.2f", result));
        break;
      case "alphabetize":
        System.out.println("Enter two words:");
        String wordOne, wordTwo;
        try {
          wordOne = input.next();
          wordTwo = input.next();
        } catch (Exception e) {
          System.out.println("Invalid input entered. Terminating...");
          break;
        }
        int comparisonVal = wordOne.toLowerCase().compareTo(wordTwo.toLowerCase());
        if (comparisonVal < 0) {
          System.out.println("Answer: " + wordOne + " comes before " + wordTwo + " alphabetically.");
        } else if (comparisonVal > 0){
          System.out.println("Answer: " + wordTwo + " comes before " + wordOne + " alphabetically.");
        } else {
          System.out.println("Answer: Chicken or Egg.");
        }
        break;
      default:
        System.out.println("Invalid input entered. Terminating...");
        break;
    }
    input.close();
  }
}
