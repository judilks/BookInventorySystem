package model;

import java.util.UUID;

public class Book {

    private String id;
    private String title;

    public Book(String title){
        this.title = title;
        id = UUID.randomUUID().toString();
    }

    public String getId() {
        return id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }
}
