package de.hsharz.provirent.objects;

import java.io.Serializable;
import org.apache.commons.lang.builder.EqualsBuilder;
import org.apache.commons.lang.builder.HashCodeBuilder;
import org.apache.commons.lang.builder.ToStringBuilder;


/** 
 *         Represents an Language.
 *         @author Philipp Schneider
 *       
*/
public class Language implements Serializable {

    /** identifier field */
    private Integer languageId;

    /** persistent field */
    private String name;

    /** persistent field */
    private String shortname;

    /** full constructor */
    public Language(String name, String shortname) {
        this.name = name;
        this.shortname = shortname;
    }

    /** default constructor */
    public Language() {
    }

    public Integer getLanguageId() {
        return this.languageId;
    }

    protected void setLanguageId(Integer languageId) {
        this.languageId = languageId;
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
            .append("languageId", getLanguageId())
            .append("name", getName())
            .append("shortname", getShortname())
            .toString();
    }

    public boolean equals(Object other) {
        if ( (this == other ) ) return true;
        if ( !(other instanceof Language) ) return false;
        Language castOther = (Language) other;
        return new EqualsBuilder()
            .append(this.getLanguageId(), castOther.getLanguageId())
            .isEquals();
    }

    public int hashCode() {
        return new HashCodeBuilder()
            .append(getLanguageId())
            .toHashCode();
    }

}
