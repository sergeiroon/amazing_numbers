package numbers;

public enum Property {
    EVEN,
    ODD,
    BUZZ,
    DUCK,
    PALINDROMIC,
    GAPFUL,
    SPY,
    SQUARE,
    SUNNY,
    JUMPING,
    HAPPY,
    SAD;

    public static Property getProperty(String property) {
        for (Property p : Property.values()) {
            if (p.name().equalsIgnoreCase(property)) {
                return p;
            }
        }

        return null;
    }
}
