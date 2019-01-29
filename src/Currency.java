public enum Currency {
    EURO, DOLLOR, RIAL;

    public String toString() {
        System.out.println("inside currency enum\n");

        switch (this) {
            case EURO:
                return "Euro";
            case DOLLOR:
                return "Dollor";
            case RIAL:
                return "Rial";

            default:
                return "";
        }
    }
}
