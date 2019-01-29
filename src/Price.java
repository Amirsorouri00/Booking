public class Price {
    private float cost;
    private Currency currency;

    public Price(float cost, Currency currency) {
        this.cost = cost;
        this.currency = currency;
        System.out.println(toString());
    }


    public float getCost() {
        return cost;
    }

    public void setCost(float cost) {
        this.cost = cost;
    }

    public Currency getCurrency() {
        return currency;
    }

    public void setCurrency(Currency currency) {
        this.currency = currency;
    }

    public float computePrice(Room room, int duration, int adultNum ){


        return 300;
    }

    @Override
    public String toString() {
        return "Price{" +
                "cost=" + cost +
                ", currency=" + currency +
                '}';
    }
}
