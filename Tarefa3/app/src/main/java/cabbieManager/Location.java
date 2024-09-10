package cabbieManager;

public enum Location {
    AEROPORTO (5, 18, "Aeroporto"),
    ESTAÇÃO_DE_TREM (12, 8, "Estação de trem"),
    SHOPPING (20, 7, "Shopping"),
    ESCOLA (6, 23, "Escola"),
    PARQUE (0, 4, "Parque"),
    HOSPITAL (15, 11, "Hospital"),
    BIBLIOTECA (3, 19, "Biblioteca"),
    ESTÁDIO (22, 25, "Estádio");

    private final int x;
    private final int y;
    private final String name;

    private Location(int x, int y, String name) {
        this.x = x;
        this.y = y;
        this.name = name;
    }

    public int getX() {
        return x;
    }

    public int getY() {
        return y;
    }

    public String getName() {
        return name;
    }
}