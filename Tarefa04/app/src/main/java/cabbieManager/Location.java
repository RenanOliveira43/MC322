package cabbieManager;

public enum Location {
    
    AEROPORTO(5, 18, "Aeroporto"),
    ESTACAO_DE_TREM(12, 15, "Estação de Trem"),
    SHOPPING(20, 7, "Shopping"),
    ESCOLA(6, 23, "Escola"),
    PARQUE(0, 4, "Parque"),
    HOSPITAL(15, 12, "Hospital"),
    BIBLIOTECA(3, 19, "Biblioteca"),
    ESTADIO(22, 25, "Estadio");

    private final int x;
    private final int y;
    private final String name;

    /**
     * Constructs a Location object with the specified coordinates and name.
     *
     * @param x The x-coordinate of the location.
     * @param y The y-coordinate of the location.
     * @param name The name of the location.
     */
    Location(int x, int y, String name) {
        this.x = x;
        this.y = y;
        this.name = name;
    }

    /**
     * Returns the Location instance associated with the specified name.
     *
     * @param name The name of the location to find.
     * @return The Location instance with the specified name, or null if no such location exists.
     */
    public static Location valueOfName(String name) {
        for (Location location : Location.values()) {
            if (location.name.equals(name)) {
                return location;
            }
        }
        return null;
    }

    /**
     * Returns the x-coordinate of the location.
     * @return the x-coordinate of the location
     */
    public int getX() {
        return this.x;
    }


    /**
     * Returns the y-coordinate of the location.
     * @return the y-coordinate of the location
     */
    public int getY() {
        return this.y;
    }

    /**
     * Returns the name of the location.
     * @return the name of the location
     */
    public String getName() {
        return this.name;
    }
}