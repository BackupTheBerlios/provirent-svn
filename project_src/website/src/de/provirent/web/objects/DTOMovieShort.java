package de.provirent.web.objects;

public class DTOMovieShort {

    private String movietitle = "";
    private String moviedescrib = "";
    private String movieid = "";

    public DTOMovieShort() {

    }

    public DTOMovieShort(String title, String describ, String id) {
        this.movietitle = title;
        this.moviedescrib = describ;
        this.movieid = id;
    }


    public void setTitle(String title) {
        this.movietitle = title;
    }

    public void setDescrib(String describ) {
        this.moviedescrib = describ;
    }

    public void setId(String id) {
        this.movieid = id;
    }

    public String getId() {
        return movieid;

    }

    public String getTitle() {
        return movietitle;
    }

    public String getDescrib() {
        return moviedescrib;
    }


}
