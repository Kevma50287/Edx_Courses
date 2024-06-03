public class Cat extends Pet {
  private int miceCaught;

  public Cat(String name, double health, int painLevel, int miceCaught) {
    super(name, health, painLevel);
    this.miceCaught = Math.max(miceCaught, 0);
  }

  public Cat(String name, double health, int painLevel) {
    this(name, health, painLevel, 0);
  }

  public int getMiceCaught() {
    return miceCaught;
  }

  @Override
  public int treat() {
    int painLevel = getPainLevel();
    double health = getHealth();
    super.heal();
    if (miceCaught < 4) {
      return (int) Math.ceil((painLevel * 2) / health);
    } else if (miceCaught <= 7) {
      return (int) Math.ceil(painLevel / health);
    } else {
      return (int) Math.ceil(painLevel / (health * 2));
    }
  }

  @Override
  public void speak() {
    super.speak();
    String meow = "meow ".repeat(miceCaught).trim();
    System.out.println(getPainLevel() > 5 ? meow.toUpperCase() : meow);
  }

  @Override
  public boolean equals(Object o) {
    if (super.equals(o) && o instanceof Cat) {
      Cat cat = (Cat) o;
      return this.getMiceCaught() == cat.getMiceCaught();
    }
    return false;
  }
}
