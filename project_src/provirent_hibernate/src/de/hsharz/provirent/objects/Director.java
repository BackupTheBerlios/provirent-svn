package de.hsharz.provirent.objects;

import java.io.Serializable;
import org.apache.commons.lang.builder.EqualsBuilder;
import org.apache.commons.lang.builder.HashCodeBuilder;
import org.apache.commons.lang.builder.ToStringBuilder;


/** 
 *         Represents an Director.
 *         @author Philipp Schneider
 *       
*/
public class Director implements Serializable {

    /** identifier field */
    private Integer directorId;

    /** persistent field */
    private String firstName;

    /** persistent field */
    private String lastName;

    /** full constructor */
    public Director(String firstName, String lastName) {
        this.firstName = firstName;
        this.lastName = lastName;
    }

    /** default constructor */
    public Director() {
    }

    public Integer getDirectorId() {
        return this.directorId;
    }

    public void setDirectorId(Integer directorId) {
        this.directorId = directorId;
    }

    public String getFirstName() {
        return this.firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return this.lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String toString() {
        return new ToStringBuilder(this)
            .append("directorId", getDirectorId())
            .append("firstName", getFirstName())
            .append("lastName", getLastName())
            .toString();
    }

    public boolean equals(Object other) {
        if ( (this == other ) ) return true;
        if ( !(other instanceof Director) ) return false;
        Director castOther = (Director) other;
        return new EqualsBuilder()
            .append(this.getDirectorId(), castOther.getDirectorId())
            .append(this.getFirstName(), castOther.getFirstName())
            .append(this.getLastName(), castOther.getLastName())
            .isEquals();
    }

    public int hashCode() {
        return new HashCodeBuilder()
            .append(getDirectorId())
            .append(getFirstName())
            .append(getLastName())
            .toHashCode();
    }

}
