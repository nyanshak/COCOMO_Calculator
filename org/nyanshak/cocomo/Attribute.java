package org.nyanshak.cocomo;

public class Attribute {

    private String[] validValues;
    private double[] associatedMultipliers;

    private int index;
    private String attr;

    public Attribute(String attr, String[] vv, double[] aM) {
        this.validValues = vv;
        this.associatedMultipliers = aM;
        this.attr = attr;
        setAttribute("Low");
    }

    public void setAttribute(String a) {
        for (int i = 0; i < validValues.length; i++) {
            if (validValues[i].equalsIgnoreCase(a)) {
                index = i;
                break;
            }
        }
    }

    public String[] getValidValues() {
        return validValues;
    }

    public String getStatus() {
        return validValues[index];
    }

    public double getMultiplier() {
        return associatedMultipliers[index];
    }
	
	public String getAttr() {
		return this.attr;
	}
}