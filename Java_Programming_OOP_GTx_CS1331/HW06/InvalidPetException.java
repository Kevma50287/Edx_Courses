public class InvalidPetException extends RuntimeException {
  public InvalidPetException() {
    super("Your pet is invalid!");
  }

  public InvalidPetException(String message) {
    super(message);
  }
}
