import java.util.Arrays;

/**
 * BlueAstronaut
 */
public class BlueAstronaut extends Player implements Crewmate{

  private int numTasks;
  private int taskSpeed;

  public BlueAstronaut(String name, int susLevel, int numTasks, int taskSpeed) {
    super(name, susLevel);
    this.numTasks = numTasks;
    this.taskSpeed = taskSpeed;
  }

  public BlueAstronaut(String name) {
    super(name, 15);
    this.numTasks = 6;
    this.taskSpeed = 10;
  }

  @Override
  public void completeTask() {
    if (super.isFrozen() || this.numTasks == 0) {
      return;
    } else if (this.taskSpeed > 20) {
      this.numTasks = this.numTasks - 2;
      if (this.numTasks < 0) {
        this.numTasks = 0;
      }
    } else {
      this.numTasks = this.numTasks - 1;
    }

    if (this.numTasks == 0) {
      System.out.println("I have completed all my tasks");
      super.setSusLevel(super.getSusLevel() / 2);
    }
  }

  @Override
  public void emergencyMeeting() {
    if (super.isFrozen()) {
      return;
    } else {
      Player[] players = getPlayers();
      Arrays.sort(players);
      Player[] filteredPlayers = Arrays.stream(players)
        .filter(player -> !player.isFrozen())
        .toArray(Player[]::new);
      if (filteredPlayers.length == 0) {
        return;
      } else if (filteredPlayers.length == 1) {
        filteredPlayers[0].setFrozen(true);
      // If two players have the same highest susLevel, no player will be voted off.
      } else if (filteredPlayers[filteredPlayers.length - 1].getSusLevel() == filteredPlayers[filteredPlayers.length - 2].getSusLevel()) {
        return;
      } else {
        filteredPlayers[filteredPlayers.length - 1].setFrozen(true);
      }
    }

    gameOver();
  }

  public boolean equals(Object o) {
    if (o instanceof BlueAstronaut) {
      BlueAstronaut blue = (BlueAstronaut) o;
      return super.getSusLevel() == blue.getSusLevel() 
              && super.isFrozen() == blue.isFrozen()
              && super.getName() == blue.getName() 
              && this.numTasks == blue.getNumTasks()
              && this.taskSpeed ==  blue.getTaskSpeed();
    }
  return false;
  }

  public String toString() {
    String statement = super.toString() + " I have " + this.numTasks + " left over."; 
    if (super.getSusLevel() > 15) {
      return statement.toUpperCase();
    } else {
      return statement;
    }
  }

  public int getNumTasks() {
    return numTasks;
  }

  public int getTaskSpeed() {
    return taskSpeed;
  }

  public void setTaskSpeed(int taskSpeed) {
    this.taskSpeed = taskSpeed;
  }

  public void setNumTasks(int numTasks) {
    this.numTasks = numTasks;
  }
}