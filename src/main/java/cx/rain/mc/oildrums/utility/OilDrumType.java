package cx.rain.mc.oildrums.utility;

public enum OilDrumType {
    SINGLE_YELLOW("single_yellow", 5, 1, 8),
    TRIPLE_YELLOW("triple_yellow", 15, 1, 16),
    SINGLE_RED("single_red", 5, 1, 8),
    TRIPLE_RED("triple_red", 15, 1, 16),
    SUPER_LOUD("super_loud", 5, 1.5f, 24),
    OIL_DRUM_SET("oil_drum_set", 20, 1, 16);

    private String drumId = null;
    private float explode = 0.0f;
    private float volume = 0.0f;
    private float distance = 0.0f;

    /**
     * Constructor of OilDrumType.
     * @param id For confirm textures and models.
     * @param explodeDistance For set of oil drums. Bigger explode.
     * @param soundVolume For SUPER loud oil drums.
     * @param soundDistance For SUPER loud oil drums.
     */
    private OilDrumType(String id, float explodeDistance, float soundVolume, float soundDistance) {
        drumId = id;

        explode = explodeDistance;
        volume = soundVolume;
        distance = soundDistance;
    }

    public static OilDrumType fromId(String id) {
        return switch (id) {
            case "single_yellow" -> SINGLE_YELLOW;
            case "triple_yellow" -> TRIPLE_YELLOW;
            case "single_red" -> SINGLE_RED;
            case "triple_red" -> TRIPLE_RED;
            case "super_loud" -> SUPER_LOUD;
            case "oil_drum_set" -> OIL_DRUM_SET;
            default -> TRIPLE_YELLOW;
        };
    }

    public String getId() {
        return drumId;
    }

    public float getExplodeDistance() {
        return explode;
    }

    public float getSoundVolume() {
        return volume;
    }

    public float getSoundDistance() {
        return distance;
    }
}
