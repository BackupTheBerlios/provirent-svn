package de.provirent.web.objects;

public class DTOMovie {

    private String title = "";
    private String describ = "";
    private String id = "";

    public DTOMovie() {

    }

    public DTOMovie(String title, String describ, String id) {
        this.title = title;
        this.describ = describ;
        this.id = id;
    }


    public void setTitle(String title) {
        this.title = title;
    }

    public void setDescrib(String describ) {
        this.describ = describ;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getId() {
        return id;

    }

    public String getTitle() {
        return title;
    }

    public String getDescrib() {
        return describ;
    }
}
