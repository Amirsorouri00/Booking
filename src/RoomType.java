public enum RoomType {
    HONEYMOON, DELUX, KING;

    public String toString() {
        System.out.println("inside room type enum\n");

        switch (this) {
            case HONEYMOON:
                return "Honeymoon";
            case DELUX:
                return "Delux";
            case KING:
                return "King";
            default:
                return "";
        }
    }
}
