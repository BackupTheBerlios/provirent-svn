package de.hsharz.provirent.objects;

import java.io.Serializable;
import java.util.Date;
import org.apache.commons.lang.builder.ToStringBuilder;


/** 
 *         Represents a single Movie.
 *         @author Philipp Schneider
 *       
*/
public class Movie implements Serializable {

    /** identifier field */
    private Integer movieId;

    /** persistent field */
    private String title;

    /** persistent field */
    private String description;

    /** nullable persistent field */
    private int runtime;

    /** nullable persistent field */
    private Date releaseDate;

    /** full constructor */
    public Movie(String title, String description, int runtime, Date releaseDate) {
        this.title = title;
        this.description = description;
        this.runtime = runtime;
        this.releaseDate = releaseDate;
    }

    /** default constructor */
    public Movie() {
    }

    /** minimal constructor */
    public Movie(String title, String description) {
        this.title = title;
        this.description = description;
    }

    public Integer getMovieId() {
        return this.movieId;
    }

    protected void setMovieId(Integer movieId) {
        this.movieId = movieId;
    }

    public String getTitle() {
        return this.title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getDescription() {
        return this.description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    /** 
     * Playing time
     */
    public int getRuntime() {
        return this.runtime;
    }

    public void setRuntime(int runtime) {
        this.runtime = runtime;
    }

    /** 
     * When the movie was released or added
     */
    public Date getReleaseDate() {
        return this.releaseDate;
    }

    public void setReleaseDate(Date releaseDate) {
        this.releaseDate = releaseDate;
    }

    public String toString() {
        return new ToStringBuilder(this)
            .append("movieId", getMovieId())
            .toString();
    }

}
