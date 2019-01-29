import java.util.LinkedList;

public class TravelArticle_List {
    private int id;
    private LinkedList<TravelArticle> travelArticle_list;
    private static int count;

    public TravelArticle_List() {
        travelArticle_list = new LinkedList<>();
        TravelArticle_List.count++;
        this.id = count;
    }

    public TravelArticle getTravelArticle(int travelArticleId) {
        for (TravelArticle travelArticle : travelArticle_list) {
            if (travelArticle.getId() == travelArticleId) {
                return travelArticle;
            }
        }
        return null;
    }

    public void addTravelArticle(TravelArticle travelArticle) {
        travelArticle_list.add(travelArticle);
    }

    public void removeTravelArticle(int travelArticleId) {
        for (TravelArticle travelArticle : travelArticle_list) {
            if (travelArticle.getId() == travelArticleId) {
                travelArticle_list.remove(travelArticle);
            }
        }
    }

    public int getId() {
        return id;
    }

    public LinkedList<TravelArticle> getTravelArticle_list() {
        return travelArticle_list;
    }

}
