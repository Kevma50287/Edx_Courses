/**
 * Frog
 */
public class Frog {

  private String name;
  private int age;
  private double tongueSpeed;
  private static String species = "Rare Pepe";
  private boolean isFroglet;

  public Frog(String name, int age, double tongueSpeed) {
    this.name = name;
    this.age = age;
    this.tongueSpeed = tongueSpeed;
    this.isFroglet = this.age > 1.0 && this.age < 7.0;
  };

  public Frog(String name, double ageInYears, double tongueSpeed) {
    this(name, (int)ageInYears, tongueSpeed);
  };

  public Frog(String name) {
    this(name, 5, 5);
  };

  public void grow(int months) {
    for (int i = 0; i < months; i++) {
      grow();
    }
  };

  public void grow() {
    this.age++;
    if (this.age <= 12) {
      this.tongueSpeed++;
    } else if (this.age > 30 && this.tongueSpeed > 5) {
      this.tongueSpeed--;
    }
    this.isFroglet = this.age > 1.0 && this.age < 7.0;
  }

  public void eat(Fly fly) {
    if (fly.isDead()) {
      return;
    }

    if (this.tongueSpeed > fly.getSpeed()) {
      fly.setMass(0.0);
      if (fly.getMass() >= (age * 0.5)) {
        grow();
      }
    } else {
      fly.grow(1);
    }
  }

  public String toString() {
    if (this.isFroglet) {
      return "My name is " + name + " and I’m a rare froglet! I’m " + age + " months old and my tongue has a speed of " + String.format("%.2f", tongueSpeed) + ".";
    } else {
      return "My name is " + name + " and I’m a rare frog. I’m " + age + " months old and my tongue has a speed of " + String.format("%.2f", tongueSpeed) + ".";
    }
  };

  public void setSpecies(String species) {
    Frog.species = species;
  }

  public static String getSpecies() {
    return species;
  }
}