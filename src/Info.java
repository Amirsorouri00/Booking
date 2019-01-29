public enum Info {
    EMAIL, PHONENO, COUNTRY, GMAINL_TOKEN;

    public String toString() {
        System.out.println("inside Info enum\n");

        switch (this) {
            case EMAIL:
                return "Email";
            case PHONENO:
                return "PhoneNo";
            case COUNTRY:
                return "Country";
            case GMAINL_TOKEN:
                return "Gmail token";
            default:
                return "";
        }
    }
}
