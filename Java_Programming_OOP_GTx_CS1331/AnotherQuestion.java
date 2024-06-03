public class AnotherQuestion {
  public static void foo(int x) throws MyException, IllegalArgumentException {
      if (x < 0) {
          System.out.println("low");
          throw(new MyException(x));
      }
      if (x > 100) {
          System.out.println("high");
          throw(new IllegalArgumentException("YellowJacket"));
      }
      System.out.println("Bunny");
  }
  public static void main(String[] args) {
      int x = -1;
      try {
          foo(x);
          System.out.println("Bug");
      }
      catch(IllegalArgumentException e) {
          System.out.println("2");
      }
      catch(MyException e) {
          System.out.println("1");
      }
      finally {
          System.out.println("OK");
      }
  }
}