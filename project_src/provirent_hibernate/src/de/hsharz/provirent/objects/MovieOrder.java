package de.hsharz.provirent.objects;

import java.io.Serializable;
import java.util.List;
import org.apache.commons.lang.builder.EqualsBuilder;
import org.apache.commons.lang.builder.HashCodeBuilder;
import org.apache.commons.lang.builder.ToStringBuilder;


/** 
 *         Represents an MovieOrder.
 *         @author Philipp Schneider
 *        
*/
public class MovieOrder implements Serializable {

    /** identifier field */
    private Integer movieOrderId;

    /** persistent field */
    private String name;

    /** persistent field */
    private String shortname;

    /** nullable persistent field */
    private de.hsharz.provirent.objects.Customer customer;

    /** persistent field */
    private List movieOrderItems;

    /** full constructor */
    public MovieOrder(String name, String shortname, de.hsharz.provirent.objects.Customer customer, List movieOrderItems) {
        this.name = name;
        this.shortname = shortname;
        this.customer = customer;
        this.movieOrderItems = movieOrderItems;
    }

    /** default constructor */
    public MovieOrder() {
    }

    /** minimal constructor */
    public MovieOrder(String name, String shortname, List movieOrderItems) {
        this.name = name;
        this.shortname = shortname;
        this.movieOrderItems = movieOrderItems;
    }

    public Integer getMovieOrderId() {
        return this.movieOrderId;
    }

    protected void setMovieOrderId(Integer movieOrderId) {
        this.movieOrderId = movieOrderId;
    }

    public String getName() {
        return this.name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getShortname() {
        return this.shortname;
    }

    public void setShortname(String shortname) {
        this.shortname = shortname;
    }

    public de.hsharz.provirent.objects.Customer getCustomer() {
        return this.customer;
    }

    public void setCustomer(de.hsharz.provirent.objects.Customer customer) {
        this.customer = customer;
    }

    public List getMovieOrderItems() {
        return this.movieOrderItems;
    }

    public void setMovieOrderItems(List movieOrderItems) {
        this.movieOrderItems = movieOrderItems;
    }

    public String toString() {
        return new ToStringBuilder(this)
            .append("movieOrderId", getMovieOrderId())
            .append("name", getName())
            .append("shortname", getShortname())
            .append("customer", getCustomer())
            .append("movieOrderItems", getMovieOrderItems())
            .toString();
    }

    public boolean equals(Object other) {
        if ( (this == other ) ) return true;
        if ( !(other instanceof MovieOrder) ) return false;
        MovieOrder castOther = (MovieOrder) other;
        return new EqualsBuilder()
            .append(this.getMovieOrderId(), castOther.getMovieOrderId())
            .append(this.getName(), castOther.getName())
            .append(this.getShortname(), castOther.getShortname())
            .append(this.getCustomer(), castOther.getCustomer())
            .append(this.getMovieOrderItems(), castOther.getMovieOrderItems())
            .isEquals();
    }

    public int hashCode() {
        return new HashCodeBuilder()
            .append(getMovieOrderId())
            .append(getName())
            .append(getShortname())
            .append(getCustomer())
            .append(getMovieOrderItems())
            .toHashCode();
    }

}
