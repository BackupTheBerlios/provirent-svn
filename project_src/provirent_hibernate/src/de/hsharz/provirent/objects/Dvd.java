package de.hsharz.provirent.objects;

import java.io.Serializable;
import java.util.List;
import org.apache.commons.lang.builder.EqualsBuilder;
import org.apache.commons.lang.builder.HashCodeBuilder;
import org.apache.commons.lang.builder.ToStringBuilder;


/** 
 *         Represents a single Dvd.
 *         @author Philipp Schneider
 *       
*/
public class Dvd implements Serializable {

    /** identifier field */
    private Integer dvdId;

    /** nullable persistent field */
    private String barcode;

    /** nullable persistent field */
    private de.hsharz.provirent.objects.PaymentCategory paymentCategory;

    /** nullable persistent field */
    private de.hsharz.provirent.objects.Movie movie;

    /** nullable persistent field */
    private de.hsharz.provirent.objects.Condition condition;

    /** nullable persistent field */
    private de.hsharz.provirent.objects.Status status;

    /** persistent field */
    private List languages;

    /** persistent field */
    private List subtitles;

    /** persistent field */
    private List audioFormats;

    /** persistent field */
    private List videoFormats;

    /** full constructor */
    public Dvd(String barcode, de.hsharz.provirent.objects.PaymentCategory paymentCategory, de.hsharz.provirent.objects.Movie movie, de.hsharz.provirent.objects.Condition condition, de.hsharz.provirent.objects.Status status, List languages, List subtitles, List audioFormats, List videoFormats) {
        this.barcode = barcode;
        this.paymentCategory = paymentCategory;
        this.movie = movie;
        this.condition = condition;
        this.status = status;
        this.languages = languages;
        this.subtitles = subtitles;
        this.audioFormats = audioFormats;
        this.videoFormats = videoFormats;
    }

    /** default constructor */
    public Dvd() {
    }

    /** minimal constructor */
    public Dvd(List languages, List subtitles, List audioFormats, List videoFormats) {
        this.languages = languages;
        this.subtitles = subtitles;
        this.audioFormats = audioFormats;
        this.videoFormats = videoFormats;
    }

    public Integer getDvdId() {
        return this.dvdId;
    }

    public void setDvdId(Integer dvdId) {
        this.dvdId = dvdId;
    }

    public String getBarcode() {
        return this.barcode;
    }

    public void setBarcode(String barcode) {
        this.barcode = barcode;
    }

    public de.hsharz.provirent.objects.PaymentCategory getPaymentCategory() {
        return this.paymentCategory;
    }

    public void setPaymentCategory(de.hsharz.provirent.objects.PaymentCategory paymentCategory) {
        this.paymentCategory = paymentCategory;
    }

    public de.hsharz.provirent.objects.Movie getMovie() {
        return this.movie;
    }

    public void setMovie(de.hsharz.provirent.objects.Movie movie) {
        this.movie = movie;
    }

    public de.hsharz.provirent.objects.Condition getCondition() {
        return this.condition;
    }

    public void setCondition(de.hsharz.provirent.objects.Condition condition) {
        this.condition = condition;
    }

    public de.hsharz.provirent.objects.Status getStatus() {
        return this.status;
    }

    public void setStatus(de.hsharz.provirent.objects.Status status) {
        this.status = status;
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
            .append("dvdId", getDvdId())
            .append("barcode", getBarcode())
            .append("paymentCategory", getPaymentCategory())
            .append("movie", getMovie())
            .append("languages", getLanguages())
            .append("subtitles", getSubtitles())
            .append("audioFormats", getAudioFormats())
            .append("videoFormats", getVideoFormats())
            .toString();
    }

    public boolean equals(Object other) {
        if ( (this == other ) ) return true;
        if ( !(other instanceof Dvd) ) return false;
        Dvd castOther = (Dvd) other;
        return new EqualsBuilder()
            .append(this.getDvdId(), castOther.getDvdId())
            .append(this.getBarcode(), castOther.getBarcode())
            .append(this.getPaymentCategory(), castOther.getPaymentCategory())
            .append(this.getMovie(), castOther.getMovie())
            .append(this.getCondition(), castOther.getCondition())
            .append(this.getStatus(), castOther.getStatus())
            .append(this.getLanguages(), castOther.getLanguages())
            .append(this.getSubtitles(), castOther.getSubtitles())
            .append(this.getAudioFormats(), castOther.getAudioFormats())
            .append(this.getVideoFormats(), castOther.getVideoFormats())
            .isEquals();
    }

    public int hashCode() {
        return new HashCodeBuilder()
            .append(getDvdId())
            .append(getBarcode())
            .append(getPaymentCategory())
            .append(getMovie())
            .append(getCondition())
            .append(getStatus())
            .append(getLanguages())
            .append(getSubtitles())
            .append(getAudioFormats())
            .append(getVideoFormats())
            .toHashCode();
    }

}
