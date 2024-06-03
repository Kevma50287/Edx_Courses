/**
 * Pond
 */
public class Pond {

  public static void main(String[] args) {
    Frog Peepo = new Frog("Peepo");
    Frog Pepe = new Frog("Pepe", 10, 15);
    Frog Peepaw = new Frog("Peepaw", 4.6, 5);
    Frog Papo = new Frog("Papo");

    Fly fodder1 = new Fly(1, 3);
    Fly fodder2 = new Fly(6);
    Fly fodder3 = new Fly();

    Peepo.setSpecies("1331 Frogs");
    
    System.out.println(Peepo.toString());

    Peepo.eat(fodder2);
    System.out.println(fodder2.toString());

    Peepo.grow(8);

    Peepo.eat(fodder2);
    System.out.println(fodder2.toString());
    System.out.println(Peepo.toString());

    System.out.println(Papo.toString());

    Peepaw.grow(4);
    System.out.println(Peepaw.toString());
    System.out.println(Pepe.toString());
  }
}