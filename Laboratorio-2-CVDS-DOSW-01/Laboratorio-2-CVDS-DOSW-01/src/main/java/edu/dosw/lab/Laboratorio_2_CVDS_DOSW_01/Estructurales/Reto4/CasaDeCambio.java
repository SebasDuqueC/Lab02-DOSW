package edu.dosw.lab.Laboratorio_2_CVDS_DOSW_01.Estructurales.Reto4;

import java.util.HashMap;
import java.util.Map;

public class CasaDeCambio {
    private final Map<String, Double> tasas;

    public CasaDeCambio() {
        tasas = new HashMap<>();
        tasas.put("USD", 1.0);
        tasas.put("EUR", 1.1); // 1 EUR = 1.1 USD
        tasas.put("JPY", 0.0067); // 1 JPY = 0.0067 USD
        tasas.put("COP", 0.00025); // 1 COP = 0.00025 USD
    }

    public double convertir(double monto, String origen, String destino) {
        double montoUSD = monto * tasas.get(origen);
        return montoUSD / tasas.get(destino);
    }
}
