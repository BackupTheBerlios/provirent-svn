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
    private List languages;

    /** persistent field */
    private List subtitles;

    /** persistent field */
    private List genres;

    /** persistent field */
    private List audioFormats;

    /** persistent field */
    private List videoFormats;

    /** full constructor */
    public Movie(String title, String description, int runtime, Calendar releaseDate, de.hsharz.provirent.objects.Image mainImage, List images, List actors, List director, List languages, List subtitles, List genres, List audioFormats, List videoFormats) {
        this.title = title;
        this.description = description;
        this.runtime = runtime;
        this.releaseDate = releaseDate;
        this.mainImage = mainImage;
        this.images = images;
        this.actors = actors;
        this.director = director;
        this.languages = languages;
        this.subtitles = subtitles;
        this.genres = genres;
        this.audioFormats = audioFormats;
        this.videoFormats = videoFormats;
    }

    /** default constructor */
    public Movie() {
    }

    /** minimal constructor */
    public Movie(String title, String description, List images, List actors, List director, List languages, List subtitles, List genres, List audioFormats, List videoFormats) {
        this.title = title;
        this.description = description;
        this.images = images;
        this.actors = actors;
        this.director = director;
        this.languages = languages;
        this.subtitles = subtitles;
        this.genres = genres;
        this.audioFormats = audioFormats;
        this.videoFormats = videoFormats;
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

    public List getLanguages() {
        return this.languages;
    }

    public void setLanguages(List languages) {
        this.languages = languages;
    }

    public List getSubtitles() {
        return this.subtitles;
    }

    public void setSubtitles(List subtitles) {
        this.subtitles = subtitles;
    }

    public List getGenres() {
        return this.genres;
    }

    public void setGenres(List genres) {
        this.genres = genres;
    }

    public List getAudioFormats() {
        return this.audioFormats;
    }

    public void setAudioFormats(List audioFormats) {
        this.audioFormats = audioFormats;
    }

    public List getVideoFormats() {
        return this.videoFormats;
    }

    public void setVideoFormats(List videoFormats) {
        this.videoFormats = videoFormats;
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
            .append("languages", getLanguages())
            .append("subtitles", getSubtitles())
            .append("genres", getGenres())
            .append("audioFormats", getAudioFormats())
            .append("videoFormats", getVideoFormats())
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
            .append(this.getLanguages(), castOther.getLanguages())
            .append(this.getSubtitles(), castOther.getSubtitles())
            .append(this.getGenres(), castOther.getGenres())
            .append(this.getAudioFormats(), castOther.getAudioFormats())
            .append(this.getVideoFormats(), castOther.getVideoFormats())
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
            .append(getLanguages())
            .append(getSubtitles())
            .append(getGenres())
            .append(getAudioFormats())
            .append(getVideoFormats())
            .toHashCode();
    }

}
