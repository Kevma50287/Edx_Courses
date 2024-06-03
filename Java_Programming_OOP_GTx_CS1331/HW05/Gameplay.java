public class Gameplay {
    
  public static void main(String[] args) {
    BlueAstronaut Bob = new BlueAstronaut(
      "Bob", 
      20, 
      6, 
      30
    );
    BlueAstronaut Heath = new BlueAstronaut(
      "Heath", 
      30, 
      3, 
      21
    );
    BlueAstronaut Albert = new BlueAstronaut(
      "Albert", 
      44, 
      2, 
      0
    );
    BlueAstronaut Angel = new BlueAstronaut(
      "Angel", 
      0, 
      1, 
      0
    );
    RedAstronaut Liam = new RedAstronaut("Liam", 19, "experienced");
    RedAstronaut suspiciousPerson = new RedAstronaut("Suspicious Person", 100, "expert");

    // Have RedAstronaut Liam sabotage BlueAstronaut Bob. After the sabotage:
    // Bob should have: susLevel = 30, frozen = false
    Liam.sabotage(Bob);

    // Have RedAstronaut Liam freeze RedAstronaut Suspicious Person:
    // Nothing should happen
    Liam.freeze(suspiciousPerson);

    // Have RedAstronaut Liam freeze BlueAstronaut Albert. After the freeze:
    // Liam should have: susLevel = 19
    // Albert is now frozen
    Liam.freeze(Albert);

    // Have BlueAstronaut Albert call an emergency meeting:
    // Nothing should happen since he is frozen
    Albert.emergencyMeeting();
    
    // Have RedAstronaut Suspicious Person call an emergency meeting:
    // This will result in a tie between Bob and Heath, so nothing should happen
    suspiciousPerson.emergencyMeeting();

    // Have BlueAstronaut Bob call an emergency meeting:
    // Suspicious Person should have: frozen = true 
    Bob.emergencyMeeting();

    // Have BlueAstronaut Heath complete tasks:
    // Heath should have: numTasks = 1
    Heath.completeTask();

    // Have BlueAstronaut Heath complete tasks:
    // “I have completed all my tasks” should be printed to console
    // Heath should have: numTasks = 0, susLevel = 15
    Heath.completeTask();

    // Have BlueAstronaut Heath complete tasks:
    // Nothing should happen
    Heath.completeTask();

    // Have RedAstronaut Liam freeze Angel:
    // Angel should have: frozen = false
    // Liam should have: susLevel = 38
    Liam.freeze(Angel);

    // Have RedAstronaut Liam sabotage Bob twice:
    // Bob should have: susLevel = 46 (30 -> 37 -> 46)
    Liam.sabotage(Bob);
    Liam.sabotage(Bob);

    // Have RedAstronaut Liam freeze Bob:
    // Bob should have: frozen = true
    Liam.freeze(Bob);

    if (args.length > 0 && args[0] == "Crewmate") {
      // Crewmates win
      Angel.emergencyMeeting();
    } else {
      // Impostors win
      // Have RedAstronaut Liam call sabotage on Heath 5 times:
      // Heath should have: susLevel = 41 (15->18->22->27->33->41)
      for (int i = 0; i < 5; i++) {
        Liam.sabotage(Heath);
      }

      // Have RedAstronaut Liam freeze Heath:
      // Heath should have: frozen = true
      // “Impostors win!” should be printed to console
      Liam.freeze(Heath);
    }
  }
}
