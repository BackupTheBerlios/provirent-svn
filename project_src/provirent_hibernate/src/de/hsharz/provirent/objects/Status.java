package de.hsharz.provirent.objects;

import java.io.Serializable;
import org.apache.commons.lang.builder.EqualsBuilder;
import org.apache.commons.lang.builder.HashCodeBuilder;
import org.apache.commons.lang.builder.ToStringBuilder;


/** 
 *         Represents an Status.
 *         @author Philipp Schneider
 *       
*/
public class Status implements Serializable {

    /** identifier field */
    private Integer statusId;

    /** persistent field */
    private String statusName;

    /** persistent field */
    private String statusShortname;

    /** full constructor */
    public Status(String statusName, String statusShortname) {
        this.statusName = statusName;
        this.statusShortname = statusShortname;
    }

    /** default constructor */
    public Status() {
    }

    public Integer getStatusId() {
        return this.statusId;
    }

    protected void setStatusId(Integer statusId) {
        this.statusId = statusId;
    }

    public String getStatusName() {
        return this.statusName;
    }

    public void setStatusName(String statusName) {
        this.statusName = statusName;
    }

    public String getStatusShortname() {
        return this.statusShortname;
    }

    public void setStatusShortname(String statusShortname) {
        this.statusShortname = statusShortname;
    }

    public String toString() {
        return new ToStringBuilder(this)
            .append("statusId", getStatusId())
            .append("statusName", getStatusName())
            .append("statusShortname", getStatusShortname())
            .toString();
    }

    public boolean equals(Object other) {
        if ( (this == other ) ) return true;
        if ( !(other instanceof Status) ) return false;
        Status castOther = (Status) other;
        return new EqualsBuilder()
            .append(this.getStatusId(), castOther.getStatusId())
            .isEquals();
    }

    public int hashCode() {
        return new HashCodeBuilder()
            .append(getStatusId())
            .toHashCode();
    }

}
