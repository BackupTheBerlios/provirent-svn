package de.hsharz.provirent.objects;

import java.io.Serializable;
import org.apache.commons.lang.builder.EqualsBuilder;
import org.apache.commons.lang.builder.HashCodeBuilder;
import org.apache.commons.lang.builder.ToStringBuilder;


/** 
 *         Represents a PaymentCategory
 *         @author Philipp Schneider
 *       
*/
public class PaymentCategory implements Serializable {

    /** identifier field */
    private Integer paymentCategoryId;

    /** persistent field */
    private String name;

    /** full constructor */
    public PaymentCategory(String name) {
        this.name = name;
    }

    /** default constructor */
    public PaymentCategory() {
    }

    public Integer getPaymentCategoryId() {
        return this.paymentCategoryId;
    }

    public void setPaymentCategoryId(Integer paymentCategoryId) {
        this.paymentCategoryId = paymentCategoryId;
    }

    public String getName() {
        return this.name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String toString() {
        return new ToStringBuilder(this)
            .append("paymentCategoryId", getPaymentCategoryId())
            .append("name", getName())
            .toString();
    }

    public boolean equals(Object other) {
        if ( (this == other ) ) return true;
        if ( !(other instanceof PaymentCategory) ) return false;
        PaymentCategory castOther = (PaymentCategory) other;
        return new EqualsBuilder()
            .append(this.getPaymentCategoryId(), castOther.getPaymentCategoryId())
            .append(this.getName(), castOther.getName())
            .isEquals();
    }

    public int hashCode() {
        return new HashCodeBuilder()
            .append(getPaymentCategoryId())
            .append(getName())
            .toHashCode();
    }

}
