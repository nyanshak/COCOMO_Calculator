package org.nyanshak.cocomo;

import java.lang.ArrayIndexOutOfBoundsException;

public class CocomoCalculator {
    SystemType systemType = new SystemType();
    private double cpph = 2000; // cost per personHour in dollars
    private double kdsi = 100;
    String vl = "Very Low", lo = "Low", nom = "Nominal", hi = "High", vh = "Very High", eh = "Extra High";

    // Product Attributes
    String[] aS = {vl, lo, nom, hi, vh};
    double[] aD = {.75, .88, 1, 1.15, 1.4};
    Attribute a = new Attribute("Required software reliability", aS, aD);

    String[] bS = {lo, nom, hi, vh};
    double[] bD = {.94, 1, 1.08, 1.16};
    Attribute b = new Attribute("Database size", bS, bD);

    String[] cS = {vl, lo, nom, hi, vh, eh};
    double[] cD = {.7, .85, 1, 1.15, 1.3, 1.65};
    Attribute c = new Attribute("Product complexity", cS, cD);

    // Computer Attributes
    String[] dS = {nom, hi, vh, eh};
    double[] dD = {1, 1.11, 1.3, 1.66};
    Attribute d = new Attribute("Execution time constraint", dS, dD);

    String[] eS = {nom, hi, vh, eh};
    double[] eD = {1, 1.06, 1.21, 1.56};
    Attribute e = new Attribute("Main storage constraint", eS, eD);

    String[] fS = {lo, nom, hi, vh};
    double[] fD = {.87, 1, 1.15, 1.3};
    Attribute f = new Attribute("Virtual machine volatility", fS, fD);

    String[] gS = {lo, nom, hi, vh};
    double[] gD = {.87, 1, 1.07, 1.15};
    Attribute g = new Attribute("Computer turnaround time", gS, gD);

    // Personnel Attributes
    String[] hS = {vl, lo, nom, hi, vh};
    double[] hD = {1.46, 1.19, 1, .86, .71};
    Attribute h = new Attribute("Analyst capabilities", hS, hD);

    String[] iS = {vl, lo, nom, hi, vh};
    double[] iD = {1.29, 1.13, 1, .91, .82};
    Attribute i = new Attribute("Applications experience", iS, iD);

    String[] jS = {vl, lo, nom, hi, vh};
    double[] jD = {1.42, 1.17, 1, .86, .7};
    Attribute j = new Attribute("Programmer capability", jS, jD);

    String[] kS = {vl, lo, nom, hi, vh};
    double[] kD = {1.21, 1.1, 1, .9};
    Attribute k = new Attribute("Virtual machine experience", kS, kD);

    String[] lS = {vl, lo, nom, hi, vh};
    double[] lD = {1.14, 1.07, 1, .95};
    Attribute l = new Attribute("Programming language experience", lS, lD);


    // Project Attributes
    String[] mS = {vl, lo, nom, hi, vh};
    double[] mD = {1.24, 1.1, 1, .91, .82};
    Attribute m = new Attribute("Use of modern programming practices", mS, mD);

    String[] nS = {vl, lo, nom, hi, vh};
    double[] nD = {1.24, 1.1, 1, .91, .83};
    Attribute n = new Attribute("Use of software tools", nS, nD);

    String[] oS = {vl, lo, nom, hi, vh};
    double[] oD = {1.23, 1.08, 1, 1.04, 1.1};
    Attribute o = new Attribute("Required development schedule", oS, oD);

    Attribute[] attributes = {a, b, c, d, e, f, g, h, i, j, k, l, m, n, o};

    public CocomoCalculator() {

    }

    public double calculateHours() {
        return (systemType.getCoefficient() * Math.pow(kdsi, systemType.getExponent())) * getMultiplier();
    }

    public double calculateCost() {
        return this.calculateHours() * cpph;
    }

    private double getMultiplier() {
        double returnVal = 1;
        for (int p = 0; p < attributes.length; p++) {
            returnVal = attributes[p].getMultiplier() * returnVal;
        }
        return returnVal;
    }

    public void printAttributeStatus() {
        for (int i = 0; i < attributes.length; i++) {
            System.out.println(i + ": " + attributes[i].getAttr() + ": " + attributes[i].getStatus());
        }

    }

    public void setKDSI(double k) {
        kdsi = k;
    }

    public void setCPPH(double c) {
        cpph = c;
    }

    public void printStatus() {
        System.out.println("\nKDSI: " + kdsi);
        System.out.printf("Cost per person hour: $%,.2f\n", cpph);
        System.out.println("System: " + systemType.getType());
        System.out.printf("Estimated total person hours: %,.2f\n", this.calculateHours());
        System.out.printf("Estimated total cost: $%,.2f\n", this.calculateCost());
        this.printAttributeStatus();
        System.out.println();
    }
	
	public Attribute[] getAttributes() {
		return attributes;
	}

    public void setAttribute(int attrNum, int val) throws ArrayIndexOutOfBoundsException {
        if (attrNum < 0 || attrNum > attributes.length - 1) {
			throw new ArrayIndexOutOfBoundsException("Input " + attrNum + "is an invalid attribute (out of bounds).");
        } else if (val < 0 || val > attributes[attrNum].getValidValues().length) {
			throw new ArrayIndexOutOfBoundsException("Input " + val + "is an invalid value for this attribute (out of bounds).");
		} else {
            attributes[attrNum].setAttribute(attributes[attrNum].getValidValues()[val]);
        }
    }

}


