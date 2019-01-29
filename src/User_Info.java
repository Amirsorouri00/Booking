import java.util.HashMap;
import java.util.Map;

public class User_Info {
    private HashMap<Info, String> info;

    public User_Info() {
        info = new HashMap<>();
    }

    public String getEachInfo(Info param) {
        return info.get(param);
    }

    public HashMap<Info, String> getInfo() {
        return info;
    }

    public void setEachInfo(Info param, String val) {
        info.put(param, val);
    }

    public String print() {
        String print = "[";
        int count = 0;
        for (Map.Entry<Info, String> entry : info.entrySet()) {
            count++;
            print = print + "key:" + entry.getKey() + "val:" + entry.getValue();
            if (count != info.size()) {
                print = print + ",";
            }
        }
        print = print + "]";
        return print;
        // "[" + ""
    }
}
