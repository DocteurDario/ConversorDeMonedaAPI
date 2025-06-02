package model;

import com.google.gson.annotations.SerializedName;

import java.math.BigDecimal;
import java.time.LocalDate;

public class Moneda {

    @SerializedName("base_code")
    public String tipo1;
    @SerializedName("target_code")
    public String tipo2;
    @SerializedName("conversion_result")
    public BigDecimal valor;

    public Moneda() {
    }

    public Moneda(String tipo1, String tipo2, BigDecimal valor) {
        this.tipo1 = tipo1;
        this.tipo2 = tipo2;
        this.valor = valor;
    }

    public String getTipo1() {
        return tipo1;
    }

    public void setTipo1(String tipo1) {
        this.tipo1 = tipo1;
    }

    public String getTipo2() {
        return tipo2;
    }

    public void setTipo2(String tipo2) {
        this.tipo2 = tipo2;
    }

    public BigDecimal getValor() {
        return valor;
    }

    public void setValor(BigDecimal valor) {
        this.valor = valor;
    }
}
