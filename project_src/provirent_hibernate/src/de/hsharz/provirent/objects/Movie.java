package de.hsharz.provirent.objects;

import java.io.Serializable;
import java.util.Calendar;
import java.util.List;
import org.apache.commons.lang.builder.EqualsBuilder;
import org.apache.commons.lang.builder.HashCodeBuilder;
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
    private Calendar releaseDate;

    /** nullable persistent field */
    private de.hsharz.provirent.objects.Image mainImage;

    /** persistent field */
    private List images;

    /** persistent field */
    private List actors;

    /** persistent field */
    private List director;

    /** persistent field */
    private List genres;

    /** full constructor */
    public Movie(String title, String description, int runtime, Calendar releaseDate, de.hsharz.provirent.objects.Image mainImage, List images, List actors, List director, List genres) {
        this.title = title;
        this.description = description;
        this.runtime = runtime;
        this.releaseDate = releaseDate;
        this.mainImage = mainImage;
        this.images = images;
        this.actors = actors;
        this.director = director;
        this.genres = genres;
    }

    /** default constructor */
    public Movie() {
    }

    /** minimal constructor */
    public Movie(String title, String description, List images, List actors, List director, List genres) {
        this.title = title;
        this.description = description;
        this.images = images;
        this.actors = actors;
        this.director = director;
        this.genres = genres;
    }

    public Integer getMovieId() {
        return this.movieId;
    }

    public void setMovieId(Integer movieId) {
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
    public Calendar getReleaseDate() {
        return this.releaseDate;
    }

    public void setReleaseDate(Calendar releaseDate) {
        this.releaseDate = releaseDate;
    }

    public de.hsharz.provirent.objects.Image getMainImage() {
        return this.mainImage;
    }

    public void setMainImage(de.hsharz.provirent.objects.Image mainImage) {
        this.mainImage = mainImage;
    }

    public List getImages() {
        return this.images;
    }

    public void setImages(List images) {
        this.images = images;
    }

    public List getActors() {
        return this.actors;
    }

    public void setActors(List actors) {
        this.actors = actors;
    }

    public List getDirector() {
        return this.director;
    }

    public void setDirector(List director) {
        this.director = director;
    }

    public List getGenres() {
        return this.genres;
    }

    public void setGenres(List genres) {
        this.genres = genres;
    }

    public String toString() {
        return new ToStringBuilder(this)
            .append("movieId", getMovieId())
            .append("title", getTitle())
            .append("description", getDescription())
            .append("runtime", getRuntime())
            .append("releaseDate", getReleaseDate())
            .append("mainImage", getMainImage())
            .append("images", getImages())
            .append("actors", getActors())
            .append("director", getDirector())
            .append("genres", getGenres())
            .toString();
    }

    public boolean equals(Object other) {
        if ( (this == other ) ) return true;
        if ( !(other instanceof Movie) ) return false;
        Movie castOther = (Movie) other;
        return new EqualsBuilder()
            .append(this.getMovieId(), castOther.getMovieId())
            .append(this.getTitle(), castOther.getTitle())
            .append(this.getDescription(), castOther.getDescription())
            .append(this.getRuntime(), castOther.getRuntime())
            .append(this.getReleaseDate(), castOther.getReleaseDate())
            .append(this.getMainImage(), castOther.getMainImage())
            .append(this.getImages(), castOther.getImages())
            .append(this.getActors(), castOther.getActors())
            .append(this.getDirector(), castOther.getDirector())
            .append(this.getGenres(), castOther.getGenres())
            .isEquals();
    }

    public int hashCode() {
        return new HashCodeBuilder()
            .append(getMovieId())
            .append(getTitle())
            .append(getDescription())
            .append(getRuntime())
            .append(getReleaseDate())
            .append(getMainImage())
            .append(getImages())
            .append(getActors())
            .append(getDirector())
            .append(getGenres())
            .toHashCode();
    }

}
