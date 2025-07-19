import java.util.ArrayList;
import java.util.Random;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        Random random = new Random();
        ArrayList<String> history = new ArrayList<>();

        String[] choices = {"rock", "paper", "scissors"};
        String playerchoice;
        String machinechoice;
        String playagain = "yes";

        do {
            System.out.print("Enter your move (rock, paper, scissors): ");
            playerchoice = sc.nextLine().toLowerCase();

            if (!playerchoice.equals("rock") && !playerchoice.equals("paper") && !playerchoice.equals("scissors")) {
                System.out.println("Invalid choice");
                continue;
            }

            machinechoice = choices[random.nextInt(3)];
            System.out.println("Machine choice: " + machinechoice);

            String result = "";  

            if (playerchoice.equals(machinechoice)) {
                result = "Tie";
                System.out.println("It's a tie!");
            } else if (
                (playerchoice.equals("rock") && machinechoice.equals("scissors")) ||
                (playerchoice.equals("paper") && machinechoice.equals("rock")) ||
                (playerchoice.equals("scissors") && machinechoice.equals("paper"))
            ) {
                result = "Win";
                System.out.println("You win!");
            } else {
                result = "Lose";
                System.out.println("You lose!");
            }

         
            history.add("Player: " + playerchoice + " | Machine: " + machinechoice + " | Result: " + result);

            System.out.print("Play again (yes/no): ");
            playagain = sc.nextLine().toLowerCase();

        } while (playagain.equals("yes"));

        System.out.println("\nThanks for playing!");
        System.out.println("Match History:");
        for (String match : history) {
            System.out.println(match);
        }

        sc.close();
    }
}
