package de.hsharz.provirent.objects;

import java.io.Serializable;
import org.apache.commons.lang.builder.EqualsBuilder;
import org.apache.commons.lang.builder.HashCodeBuilder;
import org.apache.commons.lang.builder.ToStringBuilder;


/** 
 *         Represents an Condition.
 *         @author Philipp Schneider
 *       
*/
public class Condition implements Serializable {

    /** identifier field */
    private Integer conditionId;

    /** persistent field */
    private String conditionName;

    /** persistent field */
    private String conditionshortname;

    /** full constructor */
    public Condition(String conditionName, String conditionshortname) {
        this.conditionName = conditionName;
        this.conditionshortname = conditionshortname;
    }

    /** default constructor */
    public Condition() {
    }

    public Integer getConditionId() {
        return this.conditionId;
    }

    protected void setConditionId(Integer conditionId) {
        this.conditionId = conditionId;
    }

    public String getConditionName() {
        return this.conditionName;
    }

    public void setConditionName(String conditionName) {
        this.conditionName = conditionName;
    }

    public String getConditionshortname() {
        return this.conditionshortname;
    }

    public void setConditionshortname(String conditionshortname) {
        this.conditionshortname = conditionshortname;
    }

    public String toString() {
        return new ToStringBuilder(this)
            .append("conditionId", getConditionId())
            .append("conditionName", getConditionName())
            .append("conditionshortname", getConditionshortname())
            .toString();
    }

    public boolean equals(Object other) {
        if ( (this == other ) ) return true;
        if ( !(other instanceof Condition) ) return false;
        Condition castOther = (Condition) other;
        return new EqualsBuilder()
            .append(this.getConditionId(), castOther.getConditionId())
            .isEquals();
    }

    public int hashCode() {
        return new HashCodeBuilder()
            .append(getConditionId())
            .toHashCode();
    }

}
