package model;

public enum DIVISA {
    DOLAR(10, "USD", "$"), // Dolar
    EURO(20, "EUR", "€"),                 // Euro
    PESOSARGENTINO(30, "ARS", "$"),      // Peso Argentino
    REALBRASIL(40, "BRL", "R$"),     // Real Brasil
    LIBRAESTERLINA(50, "GBL", "£");     // Libra esterlina

    private final int id;
    private final String descripcion;
    private final String simbolo;

    DIVISA(int id, String descripcion, String simbolo) {
        this.id = id;
        this.descripcion = descripcion;
        this.simbolo = simbolo;
    }

    public int getId() {
        return id;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public String getSimbolo() {
        return simbolo;
    }

    @Override
    public String toString() {
        return nombreFormal();
    }

    public String nombreFormal() {
        return this.name() + " - " + descripcion;
    }

    public static DIVISA obtenerPorId(int id) {
        for (DIVISA d : values()) {
            if (d.getId() == id) {
                return d;
            }
        }
        throw new IllegalArgumentException("ID de divisa no encontrado: " + id);
    }
    public static DIVISA obtenerPorDescripcion(String descripcion) {
        for (DIVISA d : values()) {
            if (d.descripcion.equals(descripcion)) {
                return d;
            }
        }
        throw new IllegalArgumentException("ID de divisa no encontrado: " + descripcion);
    }
}
