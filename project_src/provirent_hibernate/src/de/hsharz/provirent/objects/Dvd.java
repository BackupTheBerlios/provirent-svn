package de.hsharz.provirent.objects;

import java.io.Serializable;
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
    private de.hsharz.provirent.objects.Movie movie;

    /** nullable persistent field */
    private de.hsharz.provirent.objects.Condition condition;

    /** nullable persistent field */
    private de.hsharz.provirent.objects.Status status;

    /** full constructor */
    public Dvd(String barcode, de.hsharz.provirent.objects.Movie movie, de.hsharz.provirent.objects.Condition condition, de.hsharz.provirent.objects.Status status) {
        this.barcode = barcode;
        this.movie = movie;
        this.condition = condition;
        this.status = status;
    }

    /** default constructor */
    public Dvd() {
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

    public String toString() {
        return new ToStringBuilder(this)
            .append("dvdId", getDvdId())
            .append("barcode", getBarcode())
            .append("movie", getMovie())
            .toString();
    }

    public boolean equals(Object other) {
        if ( (this == other ) ) return true;
        if ( !(other instanceof Dvd) ) return false;
        Dvd castOther = (Dvd) other;
        return new EqualsBuilder()
            .append(this.getDvdId(), castOther.getDvdId())
            .append(this.getBarcode(), castOther.getBarcode())
            .append(this.getMovie(), castOther.getMovie())
            .append(this.getCondition(), castOther.getCondition())
            .append(this.getStatus(), castOther.getStatus())
            .isEquals();
    }

    public int hashCode() {
        return new HashCodeBuilder()
            .append(getDvdId())
            .append(getBarcode())
            .append(getMovie())
            .append(getCondition())
            .append(getStatus())
            .toHashCode();
    }

}
