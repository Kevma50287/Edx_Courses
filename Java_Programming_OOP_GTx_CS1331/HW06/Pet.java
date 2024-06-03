public abstract class Pet {
  private String name;
  private double health;
  private int painLevel;

  public Pet(String name, double health, int painLevel) {
    this.name = name;
    this.health = Math.min(Math.max(health, 0.0), 1.0);
    this.painLevel = Math.min(Math.max(painLevel, 1), 10);
  }

  public String getName() {
    return name;
  }

  public double getHealth() {
    return health;
  }

  public int getPainLevel() {
    return painLevel;
  }

  public abstract int treat();

  public void speak() {
    String message = "Hello! My name is " + name;
    System.out.println(painLevel > 5 ? message.toUpperCase() : message);
  }

  public boolean equals(Object o) {
    if (o instanceof Pet) {
      return this.name.equals(((Pet) o).name);
    }
    return false;
  }

  protected void heal() {
    health = 1.0;
    painLevel = 1;
  }
}
