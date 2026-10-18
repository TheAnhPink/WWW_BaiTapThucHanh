package iuh.fit.demospringjdbc.model;

public class Position {
    private int id;
    private String title;

    public Position() {
    }

    public Position(int id, String title) {
        this.id = id;
        this.title = title;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }
}
