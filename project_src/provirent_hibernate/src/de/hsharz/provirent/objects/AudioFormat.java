package de.hsharz.provirent.objects;

import java.io.Serializable;
import org.apache.commons.lang.builder.EqualsBuilder;
import org.apache.commons.lang.builder.HashCodeBuilder;
import org.apache.commons.lang.builder.ToStringBuilder;


/** 
 *         Represents an AudioFormat.
 *         @author Philipp Schneider
 *       
*/
public class AudioFormat implements Serializable {

    /** identifier field */
    private Integer audioFormatId;

    /** persistent field */
    private String name;

    /** persistent field */
    private String shortname;

    /** full constructor */
    public AudioFormat(String name, String shortname) {
        this.name = name;
        this.shortname = shortname;
    }

    /** default constructor */
    public AudioFormat() {
    }

    public Integer getAudioFormatId() {
        return this.audioFormatId;
    }

    protected void setAudioFormatId(Integer audioFormatId) {
        this.audioFormatId = audioFormatId;
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
            .append("audioFormatId", getAudioFormatId())
            .append("name", getName())
            .append("shortname", getShortname())
            .toString();
    }

    public boolean equals(Object other) {
        if ( (this == other ) ) return true;
        if ( !(other instanceof AudioFormat) ) return false;
        AudioFormat castOther = (AudioFormat) other;
        return new EqualsBuilder()
            .append(this.getAudioFormatId(), castOther.getAudioFormatId())
            .append(this.getName(), castOther.getName())
            .append(this.getShortname(), castOther.getShortname())
            .isEquals();
    }

    public int hashCode() {
        return new HashCodeBuilder()
            .append(getAudioFormatId())
            .append(getName())
            .append(getShortname())
            .toHashCode();
    }

}
