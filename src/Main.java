import java.io.IOException;
import java.util.*;

public class Main {
    // Initialize Map containing combinations of Player:Computer moves that would result in a loss
    static final Map<String, String> losingCombinations = MoveUtils.map();
    static final String host = "10.1.2.221";
    static final int port = 7777;

    public static void main(String[] args) throws IOException {
        SocketClient.open(host, port);

        Scanner moveSC = new Scanner(System.in);
        System.out.println("Input move");
        String moveIn = moveSC.nextLine().toLowerCase();
        String compMove = MoveUtils.randomMove(); // Deterministic machine learning my ass

        // If move not valid, try again
        if(!Moves.contains(moveIn)) {
            System.out.println("Bad move, try again");
            moveIn = moveSC.nextLine();
        }

        // Notify user of computer's decision
        System.out.printf("You played %s, the computer played %s\n", moveIn, compMove);

        // Notify user of game status after moving
        if (Utils.tie(moveIn, compMove)) {
            System.out.printf("%s is the same as %s! You tied!\n", moveIn, compMove);
        } else if (Utils.win(moveIn, compMove, losingCombinations)) {
            System.out.printf("%s beats %s! You win!\n", moveIn, compMove);
        } else System.out.printf("%s beats %s! You lose!\n", compMove, moveIn);
    }
}