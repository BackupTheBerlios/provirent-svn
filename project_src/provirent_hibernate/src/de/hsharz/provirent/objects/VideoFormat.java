package de.hsharz.provirent.objects;

import java.io.Serializable;
import org.apache.commons.lang.builder.EqualsBuilder;
import org.apache.commons.lang.builder.HashCodeBuilder;
import org.apache.commons.lang.builder.ToStringBuilder;


/** 
 *         Represents an VideoFormat.
 *         @author Philipp Schneider
 *       
*/
public class VideoFormat implements Serializable {

    /** identifier field */
    private Integer videoFormatId;

    /** persistent field */
    private String name;

    /** persistent field */
    private String shortname;

    /** full constructor */
    public VideoFormat(String name, String shortname) {
        this.name = name;
        this.shortname = shortname;
    }

    /** default constructor */
    public VideoFormat() {
    }

    public Integer getVideoFormatId() {
        return this.videoFormatId;
    }

    public void setVideoFormatId(Integer videoFormatId) {
        this.videoFormatId = videoFormatId;
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
            .append("videoFormatId", getVideoFormatId())
            .append("name", getName())
            .append("shortname", getShortname())
            .toString();
    }

    public boolean equals(Object other) {
        if ( (this == other ) ) return true;
        if ( !(other instanceof VideoFormat) ) return false;
        VideoFormat castOther = (VideoFormat) other;
        return new EqualsBuilder()
            .append(this.getVideoFormatId(), castOther.getVideoFormatId())
            .append(this.getName(), castOther.getName())
            .append(this.getShortname(), castOther.getShortname())
            .isEquals();
    }

    public int hashCode() {
        return new HashCodeBuilder()
            .append(getVideoFormatId())
            .append(getName())
            .append(getShortname())
            .toHashCode();
    }

}
