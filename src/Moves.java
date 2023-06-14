import org.jetbrains.annotations.NotNull;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Random;

/**
 * Enum containing all possible moves
 */
public enum Moves {
    rock,
    paper,
    scissors;

    /**
     * Check if Moves contains a given value
     * @param string value to be checked
     * */
    public static boolean contains(String string) {
        for (Moves m : Moves.values()) {
            if (m.name().equalsIgnoreCase(string)) {
                return true;
            }
        }
        return false;
    }
}

