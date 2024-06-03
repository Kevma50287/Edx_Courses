import java.util.Scanner;

public class FahrenheitToCelsius {
  public static void main (String[] args) {
    Scanner input = new Scanner(System.in);
    System.out.print("Enter a Fahrenheit Value: ");
    int fahrenheit = input.nextInt();
    input.nextLine();
    System.out.print("Enter a day of the week along with the month, day, and year: ");
    String day = input.nextLine();
    double celsius = (5.0/9) * (fahrenheit - 32);
    System.out.println(day + " Fahrenheit:" + fahrenheit);
    System.out.println(day + " Celsius:" + celsius); 
    input.close();
  }
}