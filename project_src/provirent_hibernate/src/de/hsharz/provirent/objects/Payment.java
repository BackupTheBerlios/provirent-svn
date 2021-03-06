package de.hsharz.provirent.objects;

import java.io.Serializable;
import java.util.Calendar;
import org.apache.commons.lang.builder.EqualsBuilder;
import org.apache.commons.lang.builder.HashCodeBuilder;
import org.apache.commons.lang.builder.ToStringBuilder;


/** 
 *         Represents a Payment.
 *         @author Stefan Forstner
 *       
*/
public class Payment implements Serializable {

    /** identifier field */
    private Integer paymentId;

    /** persistent field */
    private double duration1;

    /** persistent field */
    private double duration2;

    /** persistent field */
    private double duration3;

    /** persistent field */
    private Calendar startdate;

    /** persistent field */
    private de.hsharz.provirent.objects.PaymentCategory PaymentCategory;

    /** full constructor */
    public Payment(double duration1, double duration2, double duration3, Calendar startdate, de.hsharz.provirent.objects.PaymentCategory PaymentCategory) {
        this.duration1 = duration1;
        this.duration2 = duration2;
        this.duration3 = duration3;
        this.startdate = startdate;
        this.PaymentCategory = PaymentCategory;
    }

    /** default constructor */
    public Payment() {
    }

    public Integer getPaymentId() {
        return this.paymentId;
    }

    public void setPaymentId(Integer paymentId) {
        this.paymentId = paymentId;
    }

    public double getDuration1() {
        return this.duration1;
    }

    public void setDuration1(double duration1) {
        this.duration1 = duration1;
    }

    public double getDuration2() {
        return this.duration2;
    }

    public void setDuration2(double duration2) {
        this.duration2 = duration2;
    }

    public double getDuration3() {
        return this.duration3;
    }

    public void setDuration3(double duration3) {
        this.duration3 = duration3;
    }

    public Calendar getStartdate() {
        return this.startdate;
    }

    public void setStartdate(Calendar startdate) {
        this.startdate = startdate;
    }

    public de.hsharz.provirent.objects.PaymentCategory getPaymentCategory() {
        return this.PaymentCategory;
    }

    public void setPaymentCategory(de.hsharz.provirent.objects.PaymentCategory PaymentCategory) {
        this.PaymentCategory = PaymentCategory;
    }

    public String toString() {
        return new ToStringBuilder(this)
            .append("paymentId", getPaymentId())
            .append("startdate", getStartdate())
            .append("PaymentCategory", getPaymentCategory())
            .toString();
    }

    public boolean equals(Object other) {
        if ( (this == other ) ) return true;
        if ( !(other instanceof Payment) ) return false;
        Payment castOther = (Payment) other;
        return new EqualsBuilder()
            .append(this.getPaymentId(), castOther.getPaymentId())
            .append(this.getDuration1(), castOther.getDuration1())
            .append(this.getDuration2(), castOther.getDuration2())
            .append(this.getDuration3(), castOther.getDuration3())
            .append(this.getStartdate(), castOther.getStartdate())
            .append(this.getPaymentCategory(), castOther.getPaymentCategory())
            .isEquals();
    }

    public int hashCode() {
        return new HashCodeBuilder()
            .append(getPaymentId())
            .append(getDuration1())
            .append(getDuration2())
            .append(getDuration3())
            .append(getStartdate())
            .append(getPaymentCategory())
            .toHashCode();
    }

}
