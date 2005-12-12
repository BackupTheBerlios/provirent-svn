package de.hsharz.provirent.objects;

import java.io.Serializable;
import org.apache.commons.lang.builder.EqualsBuilder;
import org.apache.commons.lang.builder.HashCodeBuilder;
import org.apache.commons.lang.builder.ToStringBuilder;


/** 
 *         Represents an Actor.
 *         @author Philipp Schneider
 *       
*/
public class Actor implements Serializable {

    /** identifier field */
    private Integer actorId;

    /** persistent field */
    private String firstName;

    /** persistent field */
    private String lastName;

    /** persistent field */
    private String externEmail;

    /** persistent field */
    private String internEmail;

    /** full constructor */
    public Actor(String firstName, String lastName, String externEmail, String internEmail) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.externEmail = externEmail;
        this.internEmail = internEmail;
    }

    /** default constructor */
    public Actor() {
    }

    public Integer getActorId() {
        return this.actorId;
    }

    public void setActorId(Integer actorId) {
        this.actorId = actorId;
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

    public String getExternEmail() {
        return this.externEmail;
    }

    public void setExternEmail(String externEmail) {
        this.externEmail = externEmail;
    }

    public String getInternEmail() {
        return this.internEmail;
    }

    public void setInternEmail(String internEmail) {
        this.internEmail = internEmail;
    }

    public String toString() {
        return new ToStringBuilder(this)
            .append("actorId", getActorId())
            .toString();
    }

    public boolean equals(Object other) {
        if ( (this == other ) ) return true;
        if ( !(other instanceof Actor) ) return false;
        Actor castOther = (Actor) other;
        return new EqualsBuilder()
            .append(this.getActorId(), castOther.getActorId())
            .append(this.getFirstName(), castOther.getFirstName())
            .append(this.getLastName(), castOther.getLastName())
            .append(this.getExternEmail(), castOther.getExternEmail())
            .append(this.getInternEmail(), castOther.getInternEmail())
            .isEquals();
    }

    public int hashCode() {
        return new HashCodeBuilder()
            .append(getActorId())
            .append(getFirstName())
            .append(getLastName())
            .append(getExternEmail())
            .append(getInternEmail())
            .toHashCode();
    }

}
