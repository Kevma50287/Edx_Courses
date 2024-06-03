import java.util.Scanner;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.PrintWriter;

public class Clinic {
  private File patientFile;
  private int day;

  public Clinic(File file) {
    this.patientFile = file;
    this.day = 1;
  }

  public Clinic(String fileName) {
    this(new File(fileName));
  }

  public String nextDay(File f) throws FileNotFoundException {
    Scanner fileScanner = new Scanner(f);
    try (Scanner input = new Scanner(System.in)) {
      String[] tokens = null;
      String line = null;

      // While next line exists, we loop through each one, generate the string, and add it to the String line variable
      while (fileScanner.hasNextLine()) {
        line = fileScanner.nextLine();
        tokens = line.split(",");
        String name = tokens[0];
        String typeOfPet = tokens[1];
        String miscellaneousCount = tokens[2];
        String timeIn = tokens[3];
        if (typeOfPet != "Dog" && typeOfPet != "Cat" ) {
          throw new InvalidPetException();
        }
        System.out.println("Consultation for " + name + " the " + typeOfPet + " at " + timeIn + 
          ".\nWhat is the health of " + name + "?\n");

        // Loop until we get a double
        double health = 0.0;
        boolean isValidNumber = false;
        while (!isValidNumber) {
          if (input.hasNextDouble()) {
            health = input.nextDouble();
            isValidNumber = true;
          } else {
            System.err.println("Please enter a valid number");
            input.next();
          }
        }

        // Loop until we get an int
        System.out.println("On a scale of 1 to 10, how much pain is " + name + " in right now?\n");
        boolean isValidInt = false;
        int painLevelInput = 0;
        while (!isValidInt) {
          if (input.hasNextInt()) {
            painLevelInput = input.nextInt();
            isValidInt = true;
          } else {
            System.err.println("Please enter a valid integer");
            input.next();
          }
        }

        // Dynamically create Dog or Cat with inputs
        Pet pet;
        if (typeOfPet == "Dog") {
          pet = new Dog(name, health, painLevelInput);
        } else {
          pet = new Cat(name, health, painLevelInput);
        }

        // Call speak, treat, and calculate timeOut
        pet.speak();
        String timeOut = addTime(timeIn,pet.treat());
        this.day += 1;

        // Create patient string that will be used to add to file
        // [Name],[Species],[DroolRate/MiceCaught],[Day],[EntryTime],[ExitTime],[InitialHealth],[InitialPainLevel]
        String patientString = String.join(",", name, typeOfPet, miscellaneousCount, 
          String.valueOf(this.day), timeIn, timeOut, String.valueOf(health), String.valueOf(painLevelInput)); 
        
        // Add patientstring and newline character to line
        line += patientString + "\n";
      }

      // Close objects and return all the lines
      fileScanner.close();
      return line;
    }
  }

  public String nextDay(String fileName) throws FileNotFoundException {
    File newFile = new File(fileName);
    return nextDay(newFile);
  }

  public boolean addToFile(String patientInfo) {
    // Assume the vet will never see two different pets with the same name
    // Note (cont’d): Don’t try to read the file and write to it at the same time – this method is intended to rewrite the file.
    try {
      PrintWriter writer = new PrintWriter(this.patientFile);
      writer.write(patientInfo);
      writer.close();
      return true;
    } catch (FileNotFoundException e) {
      System.err.println("File not found");
      return false;
    } 
  }

  private String addTime(String timeIn, int treatmentTime) {
    // Assumes no roll over to next day
    int hours = Integer.parseInt(timeIn.substring(0, 2));
    int minutes = Integer.parseInt(timeIn.substring(2)) + treatmentTime;
    hours += minutes / 60;
    minutes %= 60;
    return String.format("%02d%02d", hours, minutes);
  }
}
