package Models;

/**
 * Created by root on 8/16/17.
 */

public class RecyclerViewItem {
    private String title;
    private String description;

    public RecyclerViewItem(String title, String description) {
        this.title = title;
        this.description = description;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getDescription() {
        return description;
    }

    public  void setDescription(String description) {
        this.description = description;
    }
}
