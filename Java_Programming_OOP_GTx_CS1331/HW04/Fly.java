/**
 * Fly
 */
public class Fly {

  private double mass, speed;

  private static final double DEFAULT_MASS = 5;
  private static final double DEFAULT_SPEED = 10;

  public Fly(double mass, double speed) {
    this.mass = mass;
    this.speed = speed;
  };

  public Fly(double mass) {
    this(mass, DEFAULT_SPEED);
  };

  public Fly() {
    this(DEFAULT_MASS, DEFAULT_SPEED);
  };

  public double getMass() {
    return mass;
  };

  public void setMass(double mass) {
    this.mass = mass;
  }

  public double getSpeed() {
    return speed;
  };

  public void setSpeed(double speed) {
    this.speed = speed;
  }

  public String toString() {

    if (isDead()) {
      return "I’m dead, but I used to be a fly with a speed of " + String.format("%.2f", speed) + ".";
    } else {
      return "I’m a speedy fly with " + String.format("%.2f", speed) + " speed and " + String.format("%.2f", mass) + " mass.";
    }
  };

  public void grow(int number) {
    for (int i = 0; i < number; i++) {
      this.mass++;
      if (this.mass <= 20) {
        this.speed++;
      } else {
        this.speed = this.speed - 0.5;
      }
    }
  };

  public boolean isDead() {
    return mass == 0;
  }

}
