package logica;

import com.google.gson.Gson;
import excepcion.ErrorExcepcion;
import model.Apis;
import model.DIVISA;
import model.Moneda;
import servicio.ConsultaApi;

import javax.swing.*;
import java.io.IOException;
import java.util.Scanner;
import java.math.BigDecimal;

public class CotizacionMoneda {

    public static String cotizacion;
    public static boolean exit = true;
    public static String opcion = "";
    public static boolean error = false;
    public static BigDecimal valor;
    public static Moneda conversion;
    public static Scanner scanner = new Scanner(System.in);


    public static void apiCotizacionMoneda() {


        while (exit) {
            try {
                opcionesDelPrograma();
                opcion = lectoOpcion();
                System.out.println("-------------------------------------------------");
                System.out.println("------------------Ingrese Valor: ----------------");
                valor = lectoValor();
                switch (opcion) {
                    case "1":
                        convertirATipoDeCambio(DIVISA.DOLAR.getDescripcion(), DIVISA.PESOSARGENTINO.getDescripcion(), valor);
                        break;
                    case "2":
                        convertirATipoDeCambio(DIVISA.PESOSARGENTINO.getDescripcion(), DIVISA.DOLAR.getDescripcion(), valor);
                        break;
                    case "3":
                        convertirATipoDeCambio(DIVISA.REALBRASIL.getDescripcion(), DIVISA.DOLAR.getDescripcion(), valor);
                        break;
                    case "4":
                        convertirATipoDeCambio(DIVISA.DOLAR.getDescripcion(), DIVISA.REALBRASIL.getDescripcion(), valor);
                        break;
                    case "5":
                        convertirATipoDeCambio(DIVISA.LIBRAESTERLINA.getDescripcion(), DIVISA.DOLAR.getDescripcion(), valor);
                        break;
                    case "6":
                        convertirATipoDeCambio(DIVISA.DOLAR.getDescripcion(), DIVISA.LIBRAESTERLINA.getDescripcion(), valor);
                        break;
                    case "7":
                        exit = false;
                        break;
                    default:
                        System.out.println("Vuelva a ingresar una Opcion !..");
                        break;
                }
            } catch (Exception e) {
                System.out.println("Se produjo un error vuelva a intentarlo...");
            }
            esperarTecla();
        }

    }

    public static void opcionesDelPrograma() {
        System.out.println("-----------------MENU PRINCIPAL------------------");
        System.out.println("-                Opcion Convertir               -");
        System.out.println("-------------------------------------------------");
        System.out.println("----1)           Dolares a Pesos                -");
        System.out.println("----2)           Pesos a Dolares                -");
        System.out.println("----3)           Real a Dolar                   -");
        System.out.println("----4)           Dolar a Real                   -");
        System.out.println("----5)           Libra a Dolar                  -");
        System.out.println("----6)           Dolar a Libra                  -");
        System.out.println("----7)                Salir                     -");
        System.out.println("-------------------------------------------------");
        System.out.println("-------Ingrese opcion a convertir: --------------");
        System.out.println("-------------------------------------------------");
    }

    public static String lectoOpcion() {
        Scanner lectura = new Scanner(System.in);
        String opcionSeleccionada = lectura.next();
        return opcionSeleccionada;
    }

    public static BigDecimal lectoValor() {
        Scanner lectura = new Scanner(System.in);
        String opcionSeleccionada = lectura.next();
        BigDecimal valor = null;

        try {
            valor = new BigDecimal(opcionSeleccionada);
        } catch (Exception e) {
            throw new ErrorExcepcion("Error al ingresar valor : " + e);
        }
        return valor;
    }

    public static void convertirATipoDeCambio(String Tipo1, String Tipo2, BigDecimal valor) {
        //https://v6.exchangerate-api.com/v6/ TU-CLAVE-API /par/ EUR / GBP
        //https://v6.exchangerate-api.com/v6/07721c4e517e8959d4a57db6/latest/USD
        //OBTENER https://v6.exchangerate-api.com/v6/ 07721c4e517e8959d4a57db6/pair/EUR/GBP/1000

        Apis apis = new Apis("https://v6.exchangerate-api.com/v6/07721c4e517e8959d4a57db6/pair/" + Tipo1 + "/" + Tipo2 + "/" + valor.toString());
        ConsultaApi consultaApi = new ConsultaApi();

        Gson gson = new Gson();


        try {
            cotizacion = consultaApi.consultaHttpClient(apis.getRequesURL());
            conversion = gson.fromJson(cotizacion, Moneda.class);
        } catch (InterruptedException e) {
            throw new ErrorExcepcion("Error en la consuta a la API: " + e.toString());
        } catch (IOException e) {
            throw new RuntimeException(e);
        }

        System.out.println("Valor : " + DIVISA.obtenerPorDescripcion(Tipo2).getSimbolo() + " " + conversion.valor + " en " + conversion.tipo2);
    }

    public static void esperarTecla() {
        System.out.println("Presiona Enter para continuar...");
        Scanner scanner = new Scanner(System.in);
        scanner.nextLine();  // Espera a que se presione Enter
    }

}
