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
                return false;
            }
        }
        return true;
    }
}

