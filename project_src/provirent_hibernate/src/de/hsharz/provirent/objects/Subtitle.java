package de.hsharz.provirent.objects;

import java.io.Serializable;
import org.apache.commons.lang.builder.EqualsBuilder;
import org.apache.commons.lang.builder.HashCodeBuilder;
import org.apache.commons.lang.builder.ToStringBuilder;


/** 
 *         Represents an Subtitle.
 *         @author Philipp Schneider
 *       
*/
public class Subtitle implements Serializable {

    /** identifier field */
    private Integer subtitleId;

    /** persistent field */
    private String name;

    /** persistent field */
    private String shortname;

    /** full constructor */
    public Subtitle(String name, String shortname) {
        this.name = name;
        this.shortname = shortname;
    }

    /** default constructor */
    public Subtitle() {
    }

    public Integer getSubtitleId() {
        return this.subtitleId;
    }

    protected void setSubtitleId(Integer subtitleId) {
        this.subtitleId = subtitleId;
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
            .append("subtitleId", getSubtitleId())
            .append("name", getName())
            .append("shortname", getShortname())
            .toString();
    }

    public boolean equals(Object other) {
        if ( (this == other ) ) return true;
        if ( !(other instanceof Subtitle) ) return false;
        Subtitle castOther = (Subtitle) other;
        return new EqualsBuilder()
            .append(this.getSubtitleId(), castOther.getSubtitleId())
            .isEquals();
    }

    public int hashCode() {
        return new HashCodeBuilder()
            .append(getSubtitleId())
            .toHashCode();
    }

}
