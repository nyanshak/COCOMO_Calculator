package org.nyanshak.cocomo;

public class SystemType {

    String[] types = {"Organic", "Semidetached", "Detached"};
    double[] coefficients = {3.2, 3.0, 2.8};
    double[] exponents = {1.05, 1.12, 1.2};
    private int index = 1;

    public SystemType() {

    }

    public void setAttribute(String a) {
        for (int i = 0; i < types.length; i++) {
            if (types[i].equalsIgnoreCase(a)) {
                index = i;
                break;
            }
        }
    }

    public String getType() {
        return types[index];
    }

    public double getCoefficient() {
        return coefficients[index];
    }

    public double getExponent() {
        return exponents[index];
    }
}