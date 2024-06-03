
public class Dog extends Pet {
  private double droolRate;

  public Dog(String name, double health, int painLevel, double droolRate) {
    super(name, health, painLevel);
    this.droolRate = droolRate <= 0 ? 0.5 : droolRate;
  }

  public Dog(String name, double health, int painLevel) {
    this(name, health, painLevel, 5.0);
  }

  public double getDroolRate() {
    return droolRate;
  }

  @Override
  public int treat() {
    int painLevel = getPainLevel();
    double health = getHealth();
    super.heal();
    if (droolRate < 3.5) {
      return (int) Math.ceil((painLevel * 2) / health);
    } else if (droolRate <= 7.5) {
      return (int) Math.ceil(painLevel / health);
    } else {
      return (int) Math.ceil(painLevel / (health * 2));
    }
  }

  @Override
  public void speak() {
    super.speak();
    String bark = "bark ".repeat(getPainLevel()).trim();
    System.out.println(getPainLevel() > 5 ? bark.toUpperCase() : bark);
  }

  @Override
  public boolean equals(Object o) {
    if (super.equals(o) && o instanceof Dog) {
      Dog dog = (Dog) o;
      return this.getDroolRate() == dog.getDroolRate();
    }
    return false;
  }
}
