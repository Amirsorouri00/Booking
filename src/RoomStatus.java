public enum RoomStatus {
    AVAILABLE, LIMITED, SOLDOUT;

    public String toString() {
        System.out.println("inside room status enum\n");
        switch (this) {
            case AVAILABLE:
                return "Available";
            case LIMITED:
                return "Limited";
            case SOLDOUT:
                return "Soldout";
            default:
                return "";
        }
    }
}
