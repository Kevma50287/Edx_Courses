import java.util.Arrays;

public class RedAstronaut extends Player implements Impostor{
  private String skill;

  public RedAstronaut(String name, int susLevel, String skill) {
    super(name, susLevel);
    this.skill = skill;
  }

  public RedAstronaut(String name) {
    super(name, 15);
    this.skill = "experienced";
  }

  @Override
  public void freeze(Player p) {
    // It is not possible to freeze another Impostor, and an Impostor that is frozen cannot attempt to freeze. 
    if (super.isFrozen()) {
      return;
    } else if (p instanceof Impostor) {
      return;
    } else if (p.isFrozen()) {
      return;
    } else if (super.getSusLevel() < p.getSusLevel()) {
      p.setFrozen(true);
    } else {
      super.setSusLevel(super.getSusLevel() * 2);
    }

    gameOver();
    // If the passed in Player is an Impostor, the method should end. Freezing an already frozen Player should also do nothing.
    // A freeze is successful if the RedAstronaut’s susLevel is less than the Player’s
    // If the freeze is unsuccessful, the RedAstronaut’s susLevel doubles (multiply the current susLevel by 2)
    // Remember to change the frozen boolean value for the Crewmate as needed.
    // After the freeze attempt, check if the game is over using the provided method in Player.java
    // Does not return anything
  }

  @Override
  public void sabotage(Player p) {
    // It is not possible to sabotage another Impostor, and an Impostor that is frozen cannot sabotage. Also, sabotaging a frozen Player should do nothing.
    // If the Impostor’s susLevel is under 20, through shifty maneuvers and cunning words, they are able to increase the Crewmate’s susLevel by 50%
    // Otherwise, they can only manage to increase the Crewmate’s susLevel by 25%
    // (Note: In both cases, the the Crewmate’s susLevel is rounded down to the nearest int value)
    // Does not return anything
    if (super.isFrozen()) {
      return;
    } else if (p instanceof Impostor) {
      return;
    } else if (p.isFrozen()) {
      return;
    } else if (super.getSusLevel() < 20) {
      double increasedLevel = p.getSusLevel() * 1.5;
      p.setSusLevel((int)increasedLevel);
    } else {
      double increasedLevel = p.getSusLevel() * 1.25;
      p.setSusLevel((int)increasedLevel);
    }
  }

  @Override
  public void emergencyMeeting() {
    if (super.isFrozen()) {
      return;
    } else {
      Player[] players = getPlayers();
      Arrays.sort(players);
      // Include only players that aren't frozen and is not the current impostor calling the meeting
      Player[] filteredPlayers = Arrays.stream(players)
        .filter(player -> !player.isFrozen() && !super.equals(player))
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
    if (o instanceof RedAstronaut) {
      RedAstronaut red = (RedAstronaut) o;
      return super.getSusLevel() == red.getSusLevel() && super.isFrozen() == red.isFrozen()
              && super.getName() == red.getName() && this.skill == red.getSkill();
    }
    return false;
  }

  public String toString() {
    String statement = super.toString() + " I am an " + this.skill + " player!"; 
    if (super.getSusLevel() > 15) {
      return statement.toUpperCase();
    } else {
      return statement;
    }
  }

  public String getSkill() {
    return skill;
  }

  public void setSkill(String skill) {
    this.skill = skill;
  }
}
