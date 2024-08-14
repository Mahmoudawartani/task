public class Money {

    private final double amount;

    public static final Money Zero = new Money(0.00);
    public static final Money OneCent = new Money(0.01);
    public static final Money FiveCent = new Money(0.05);
    public static final Money TenCent = new Money(0.10);
    public static final Money TwentyFiveCent = new Money(0.25);
    public static final Money FiftyCent = new Money(0.50);
    public static final Money Onedinar = new Money(1.00);
    public static final Money Fivedinar = new Money(5.00);
    public static final Money Tendinar = new Money(10.00);
    public static final Money Twentydinar = new Money(20.00);
    public static final Money Fiftydinar = new Money(50.00);




    //custom constructor to handle instantiating objects & handling input violations.
    public Money(double amount) {
        if (amount < 0) {
            throw new IllegalArgumentException("Amount cannot be negative");
        }
        this.amount = amount;
    }

    public double amount() {

        return amount;
    }

    //multiplies the amount by a given count.
    public Money times(int count) {
        if (count < 0) {
            throw new IllegalArgumentException("Count cannot be negative");
        }

        return new Money(this.amount * count);
    }


    //adds the amount of another Money object to the current one.
    public Money plus(Money other) {
        return new Money(this.amount + other.amount);
    }

    //subtracts the amount of another Money object, with a check to prevent negative results.
    public Money minus(Money other) {

        if (this.amount < other.amount) {
            throw new IllegalArgumentException("Cannot subtract more than the available amount");
        }
        double result =this.amount-other.amount;
        System.out.println(" this " + this.amount +" minus "+other.amount+" IS "+result);
    return new Money(result);
    }

}

@Test
    public void minusTest() {
        assertThrows(IllegalArgumentException.class, () -> Zero.minus(Onedinar));
        assertEquals(Zero, Zero.minus(Zero));
        assertEquals(Zero, OnePiaster.minus(OnePiaster));
        assertEquals(Onedinar, Fivedinar.plus(Onedinar).minus(Fivedinar));
        assertEquals(Fivedinar, Onedinar.times(10).minus(Fivedinar));
        assertThrows(IllegalArgumentException.class, () -> Tendinar.minus(Onedinar));
        
    }