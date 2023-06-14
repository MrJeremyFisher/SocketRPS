import java.util.Map;
import java.util.Objects;

/*
 * Contains generic utility methods
 */
public class Utils {
    /**
     * Check if move1 wins against move2
     * @param move1 move to be checked
     * @param move2 move to be checked against
     * */
    public static boolean win(String move1, String move2, Map<String, String> losingCombinations) {
        if (move1.equalsIgnoreCase(move2)) return false;
        else return !losingCombinations.get(move1).equalsIgnoreCase(move2);
    }

    public static boolean tie(String move1, String move2){
        return move1.equalsIgnoreCase(move2);
    }
}
