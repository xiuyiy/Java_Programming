package edu.njit.cs602.assignments;

import java.util.Scanner;

public class CashRegister {

   public enum CurrencyUnitType {
        PENNY("pennies",1), DIME("dimes",10), QUARTER("quarters",25),
        ONE_DOLLAR("one dollar bills",100), TEN_DOLLAR("ten dollar bills",1000),
        TWENTY_DOLLAR("twenty dollar bills",2000);

        private final String desc;
        private final int centValue;

        CurrencyUnitType(String desc, int centValue) {
            this.desc = desc;
            this.centValue = centValue;
        }

        public int centValue() { return centValue; }

        public String toString() { return desc; }
    }

    /**
     * Constructor
     * @param units number of units of each currency unit type
     */
    public CashRegister(int [] units) {
    }

   /**
     *  Display cash register.
     */
    public void display() {}

    /**
     * Display units The display format example:
     *  5 Quarters, 10 one dollar bills
     *  Omit currency units with 0 values
     * @param units to display
     */
    public static void display(int [] units) {}

    /**
     * Add units of a currency unit type
     * @param unitType currency unit type
     * @param numUnits number of units
     */
    public void add(CurrencyUnitType unitType, int numUnits) {}

    /**
     * Remove units if a currency unit type
     * @param unitType currency unit type
     * @param numUnits number of units
     * @return true if numUnits can be removed else false; in the latter case do not remove any units
     */
    public boolean remove(CurrencyUnitType unitType, int numUnits) { return false; }

    /**
     * Give change back for the difference between price and paid amount
     * @param price price of item to pay for
     * @param paidUnits currency units paid
     * @return currency units for difference or the paidUnits if we cannot make change
     */
    public int [] changeBack(float price, int [] paidUnits) {
        return null;
    }

    /**
     * Convert to amount
     * @param units number of units of different currency units
     * @return amount in dollars and cents
     */
    public static float amount(int [] units) { return 0.0f; }

    /**
     * If the units given by units1 and units2 give the same amount
     * @param units1 first bag of units
     * @param units2 second bag of units
     * @return true if same amount else false
     */
    public static boolean sameAmount(int [] units1, int [] units2) { return false; }


    public static void main(String [] args) {
        Scanner scanner = new Scanner(System.in);

        // get initial values of currency units in the cash register
        int [] nUnits = new int[CurrencyUnitType.values().length];
        for (CurrencyUnitType unitType: CurrencyUnitType.values()) {
            System.out.print(unitType.toString()+ " :");
            nUnits[unitType.ordinal()] = scanner.nextInt();
        }

        // Create a CashRegister object with these initial values
        CashRegister register = new CashRegister(nUnits);

        // Call other methods on the object to test
        register.display();

        display(register.changeBack(7.5f,new int [] { 0, 5, 0, 0, 10, 0 }));

        float price = 10.25f;
        int [] paidUnits = new int [] { 0, 5, 0, 0, 10, 0 };
        int [] changeBack = register.changeBack(price,paidUnits);
        if (sameAmount(changeBack,paidUnits)) {
            System.out.println("Cannot break change for " + (amount(paidUnits)-price));
        } else {
            display(changeBack);
        }

        register.add(CurrencyUnitType.QUARTER,50);
        register.display();

        System.out.println("Units removed:" + register.remove(CurrencyUnitType.DIME,10));

    }

}
