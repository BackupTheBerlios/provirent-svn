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

    /** full constructor */
    public Actor(String firstName, String lastName) {
        this.firstName = firstName;
        this.lastName = lastName;
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

    public String toString() {
        return new ToStringBuilder(this)
            .append("actorId", getActorId())
            .append("firstName", getFirstName())
            .append("lastName", getLastName())
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
            .isEquals();
    }

    public int hashCode() {
        return new HashCodeBuilder()
            .append(getActorId())
            .append(getFirstName())
            .append(getLastName())
            .toHashCode();
    }

}
