package de.hsharz.provirent.objects;

import java.io.Serializable;
import java.util.Calendar;
import java.util.Date;
import org.apache.commons.lang.builder.EqualsBuilder;
import org.apache.commons.lang.builder.HashCodeBuilder;
import org.apache.commons.lang.builder.ToStringBuilder;


/** 
 *         Represents an OrderItem.
 *         @author Philipp Schneider
 *       
*/
public class OrderItem implements Serializable {

    /** identifier field */
    private Integer orderItemId;

    /** nullable persistent field */
    private Calendar senderTime;

    /** nullable persistent field */
    private Calendar receivingTime;

    /** persistent field */
    private int duration;

    /** nullable persistent field */
    private Date orderTime;

    /** nullable persistent field */
    private de.hsharz.provirent.objects.Customer customer;

    /** nullable persistent field */
    private de.hsharz.provirent.objects.Dvd dvd;

    /** nullable persistent field */
    private de.hsharz.provirent.objects.Condition conditionSend;

    /** nullable persistent field */
    private de.hsharz.provirent.objects.Condition conditionReceiving;

    /** full constructor */
    public OrderItem(Calendar senderTime, Calendar receivingTime, int duration, Date orderTime, de.hsharz.provirent.objects.Customer customer, de.hsharz.provirent.objects.Dvd dvd, de.hsharz.provirent.objects.Condition conditionSend, de.hsharz.provirent.objects.Condition conditionReceiving) {
        this.senderTime = senderTime;
        this.receivingTime = receivingTime;
        this.duration = duration;
        this.orderTime = orderTime;
        this.customer = customer;
        this.dvd = dvd;
        this.conditionSend = conditionSend;
        this.conditionReceiving = conditionReceiving;
    }

    /** default constructor */
    public OrderItem() {
    }

    /** minimal constructor */
    public OrderItem(int duration) {
        this.duration = duration;
    }

    public Integer getOrderItemId() {
        return this.orderItemId;
    }

    protected void setOrderItemId(Integer orderItemId) {
        this.orderItemId = orderItemId;
    }

    public Calendar getSenderTime() {
        return this.senderTime;
    }

    public void setSenderTime(Calendar senderTime) {
        this.senderTime = senderTime;
    }

    public Calendar getReceivingTime() {
        return this.receivingTime;
    }

    public void setReceivingTime(Calendar receivingTime) {
        this.receivingTime = receivingTime;
    }

    public int getDuration() {
        return this.duration;
    }

    public void setDuration(int duration) {
        this.duration = duration;
    }

    public Date getOrderTime() {
        return this.orderTime;
    }

    public void setOrderTime(Date orderTime) {
        this.orderTime = orderTime;
    }

    public de.hsharz.provirent.objects.Customer getCustomer() {
        return this.customer;
    }

    public void setCustomer(de.hsharz.provirent.objects.Customer customer) {
        this.customer = customer;
    }

    public de.hsharz.provirent.objects.Dvd getDvd() {
        return this.dvd;
    }

    public void setDvd(de.hsharz.provirent.objects.Dvd dvd) {
        this.dvd = dvd;
    }

    public de.hsharz.provirent.objects.Condition getConditionSend() {
        return this.conditionSend;
    }

    public void setConditionSend(de.hsharz.provirent.objects.Condition conditionSend) {
        this.conditionSend = conditionSend;
    }

    public de.hsharz.provirent.objects.Condition getConditionReceiving() {
        return this.conditionReceiving;
    }

    public void setConditionReceiving(de.hsharz.provirent.objects.Condition conditionReceiving) {
        this.conditionReceiving = conditionReceiving;
    }

    public String toString() {
        return new ToStringBuilder(this)
            .append("orderItemId", getOrderItemId())
            .append("senderTime", getSenderTime())
            .append("receivingTime", getReceivingTime())
            .append("duration", getDuration())
            .append("orderTime", getOrderTime())
            .append("customer", getCustomer())
            .append("dvd", getDvd())
            .append("conditionSend", getConditionSend())
            .append("conditionReceiving", getConditionReceiving())
            .toString();
    }

    public boolean equals(Object other) {
        if ( (this == other ) ) return true;
        if ( !(other instanceof OrderItem) ) return false;
        OrderItem castOther = (OrderItem) other;
        return new EqualsBuilder()
            .append(this.getOrderItemId(), castOther.getOrderItemId())
            .isEquals();
    }

    public int hashCode() {
        return new HashCodeBuilder()
            .append(getOrderItemId())
            .toHashCode();
    }

}
