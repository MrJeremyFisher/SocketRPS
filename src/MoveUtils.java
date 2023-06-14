import org.jetbrains.annotations.NotNull;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Random;

/*
 * Contains move-related utility methods
 */
public class MoveUtils {
    private static final List<Moves> VALUES = List.of(Moves.values());
    private static final int SIZE = VALUES.size();
    private static final Random RANDOM = new Random();
    /**
     * Generate a random move from the Moves enum
     * */
    public static String randomMove()  {
        return String.valueOf(VALUES.get(RANDOM.nextInt(SIZE)));
    }

    /**
     * Generate a map of losing move combinations
     * */
    @NotNull
    public static Map<String, String> map(){
        Map<String, String> moves = new HashMap<>();
        moves.put("rock", "paper");
        moves.put("paper", "scissors");
        moves.put("scissors", "rock");
        return moves;
    }
}
