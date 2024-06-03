import java.util.*;
import java.io.*;

public class Battleship {
	public static void main(String[] args) {
    System.out.println("Welcome to Battleship!");
    Scanner input = new Scanner(System.in);

    // Setup initial boards
    char [][] playerOneBoard = new char[5][5];
    char [][] playerTwoBoard = new char[5][5];
    char [][] playerOneShotBoard = new char[5][5];
    char [][] playerTwoShotBoard = new char[5][5];

    setupDefaultEmptyBoard(playerOneBoard);
    setupDefaultEmptyBoard(playerTwoBoard);
    setupDefaultEmptyBoard(playerOneShotBoard);
    setupDefaultEmptyBoard(playerTwoShotBoard);

    // Enter ship positions for player one
    System.out.println("PLAYER 1, ENTER YOUR SHIPS’ COORDINATES.");
    for (int i = 0; i < 5; i++) {
      int shipNumber = i + 1;
      System.out.println("Enter ship " + shipNumber + " location:");
      getValidInputForBoard(playerOneBoard, input);
    }
    printBattleShip(playerOneBoard);
    printEmptyLines();

    // Enter ship positions for player two
    System.out.println("PLAYER 2, ENTER YOUR SHIPS’ COORDINATES.");
    for (int i = 0; i < 5; i++) {
      int shipNumber = i + 1;
      System.out.println("Enter ship " + shipNumber + " location:");
      getValidInputForBoard(playerTwoBoard, input);
    }
    printBattleShip(playerTwoBoard);
    printEmptyLines();

    // Commence firing until there is a winner
    int playerOneRemainingShips = 5;
    int playerTwoRemainingShips = 5;
    int currentPlayer = 1;
    boolean noWinner = true;

    do {
      if (currentPlayer == 1){
        boolean result = getShotFiredCoordinateAndResult(currentPlayer, playerTwoBoard, playerOneShotBoard, input);
        if (result) {
          playerTwoRemainingShips--;
        }
        printBattleShip(playerOneShotBoard);
        if (playerOneRemainingShips == 0 || playerTwoRemainingShips == 0) {
          noWinner = false;
        }
        currentPlayer = 2;
      } else {
        boolean result = getShotFiredCoordinateAndResult(currentPlayer, playerOneBoard, playerTwoShotBoard, input);
        if (result) {
          playerOneRemainingShips--;
        }
        printBattleShip(playerTwoShotBoard);
        currentPlayer = 1;
        if (playerOneRemainingShips == 0 || playerTwoRemainingShips == 0) {
          noWinner = false;
        }
      }
    } while (noWinner);

    if (playerOneRemainingShips == 0) {
      System.out.println("PLAYER 2 WINS! YOU SUNK ALL OF YOUR OPPONENT’S SHIPS!");
    } else {
      System.out.println("PLAYER 1 WINS! YOU SUNK ALL OF YOUR OPPONENT’S SHIPS!");
    }

    System.out.println("Final boards:");
    printBattleShip(playerOneBoard);
    printBattleShip(playerTwoBoard);

    input.close();
  }
    
    // Use this method to print game boards to the console.
	private static void printBattleShip(char[][] player) {
		System.out.print("  ");
		for (int row = -1; row < 5; row++) {
			if (row > -1) {
				System.out.print(row + " ");
			}
			for (int column = 0; column < 5; column++) {
				if (row == -1) {
					System.out.print(column + " ");
				} else {
					System.out.print(player[row][column] + " ");
				}
			}
			System.out.println("");
		}
	}

  private static void getValidInputForBoard(char[][] board, Scanner input){
    boolean validInput = false;

    while (!validInput){
      try {
        int row = input.nextInt();
        int col = input.nextInt();

        if (row > 4 || row < 0 || col > 4 || col < 0) {
          System.out.println("Invalid coordinates. Choose different coordinates.");
        } else if (board[row][col] == '@') {
          System.out.println("You already have a ship there. Choose different coordinates.");
        } else {
          validInput = true;
          board[row][col] = '@';
        }
      } catch (Exception e) {
        System.out.println("Invalid coordinates. Choose different coordinates.");
        input.nextLine();
      }
      
    }
  }

  private static boolean getShotFiredCoordinateAndResult(
    int currentPlayer, char[][] opponentPlayerBoard, 
    char[][] shotBoard, Scanner input
    ) {
    boolean validInput = false;
    boolean didShotHit = false;
    int otherPlayer;

    if (currentPlayer == 1) {
      otherPlayer = 2;
    } else {
      otherPlayer = 1;
    }

    while (!validInput) {
      System.out.println("Player " + currentPlayer + ", enter hit row/column:");

      try {
        int row = input.nextInt();
        int col = input.nextInt();

        if (row > 4 || row < 0 || col > 4 || col < 0) {
          System.out.println("Invalid coordinates. Choose different coordinates.");
        } else if (shotBoard[row][col] != '-') {
          System.out.println("You already fired on this spot. Choose different coordinates.");
        } else if (opponentPlayerBoard[row][col] == '@') {
          shotBoard[row][col] = 'X';
          opponentPlayerBoard[row][col] = 'X';
          System.out.println("PLAYER " + currentPlayer + " HIT PLAYER " + otherPlayer + "’s SHIP!");
          validInput = true;
          didShotHit = true;
        } else {
          shotBoard[row][col] = 'O';
          opponentPlayerBoard[row][col] = 'O';
          System.out.println("PLAYER " + currentPlayer + " MISSED!");
          validInput = true;
        }
      } catch (Exception e) {
        System.out.println("Invalid coordinates. Choose different coordinates.");
        input.nextLine();
      }
    }

    return didShotHit;
  }

  private static void printEmptyLines() {
    for (int i = 0; i < 100; i++) {
        System.out.println();
    };
  }

  private static void setupDefaultEmptyBoard(char[][] board){
    for (char[] row : board) {
      Arrays.fill(row, '-');
    }
  }
}
