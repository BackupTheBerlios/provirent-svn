package de.hsharz.provirent.objects;

import java.io.Serializable;
import org.apache.commons.lang.builder.EqualsBuilder;
import org.apache.commons.lang.builder.HashCodeBuilder;
import org.apache.commons.lang.builder.ToStringBuilder;


/** 
 *         Represents an Genre.
 *         @author Philipp Schneider
 *       
*/
public class Genre implements Serializable {

    /** identifier field */
    private Integer genreId;

    /** persistent field */
    private String name;

    /** persistent field */
    private String shortname;

    /** full constructor */
    public Genre(String name, String shortname) {
        this.name = name;
        this.shortname = shortname;
    }

    /** default constructor */
    public Genre() {
    }

    public Integer getGenreId() {
        return this.genreId;
    }

    public void setGenreId(Integer genreId) {
        this.genreId = genreId;
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

    public String toString() {
        return new ToStringBuilder(this)
            .append("genreId", getGenreId())
            .append("name", getName())
            .append("shortname", getShortname())
            .toString();
    }

    public boolean equals(Object other) {
        if ( (this == other ) ) return true;
        if ( !(other instanceof Genre) ) return false;
        Genre castOther = (Genre) other;
        return new EqualsBuilder()
            .append(this.getGenreId(), castOther.getGenreId())
            .append(this.getName(), castOther.getName())
            .append(this.getShortname(), castOther.getShortname())
            .isEquals();
    }

    public int hashCode() {
        return new HashCodeBuilder()
            .append(getGenreId())
            .append(getName())
            .append(getShortname())
            .toHashCode();
    }

}
