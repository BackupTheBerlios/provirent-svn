package de.hsharz.provirent.objects;

import java.io.Serializable;
import java.util.List;
import org.apache.commons.lang.builder.EqualsBuilder;
import org.apache.commons.lang.builder.HashCodeBuilder;
import org.apache.commons.lang.builder.ToStringBuilder;


/** 
 *         Represents an Order.
 *         @author Philipp Schneider
 *       
*/
public class Order implements Serializable {

    /** identifier field */
    private Integer orderId;

    /** persistent field */
    private String name;

    /** persistent field */
    private String shortname;

    /** nullable persistent field */
    private de.hsharz.provirent.objects.Customer customer;

    /** persistent field */
    private List orderItems;

    /** full constructor */
    public Order(String name, String shortname, de.hsharz.provirent.objects.Customer customer, List orderItems) {
        this.name = name;
        this.shortname = shortname;
        this.customer = customer;
        this.orderItems = orderItems;
    }

    /** default constructor */
    public Order() {
    }

    /** minimal constructor */
    public Order(String name, String shortname, List orderItems) {
        this.name = name;
        this.shortname = shortname;
        this.orderItems = orderItems;
    }

    public Integer getOrderId() {
        return this.orderId;
    }

    protected void setOrderId(Integer orderId) {
        this.orderId = orderId;
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

    public de.hsharz.provirent.objects.Customer getCustomer() {
        return this.customer;
    }

    public void setCustomer(de.hsharz.provirent.objects.Customer customer) {
        this.customer = customer;
    }

    public List getOrderItems() {
        return this.orderItems;
    }

    public void setOrderItems(List orderItems) {
        this.orderItems = orderItems;
    }

    public String toString() {
        return new ToStringBuilder(this)
            .append("orderId", getOrderId())
            .append("name", getName())
            .append("shortname", getShortname())
            .append("customer", getCustomer())
            .append("orderItems", getOrderItems())
            .toString();
    }

    public boolean equals(Object other) {
        if ( (this == other ) ) return true;
        if ( !(other instanceof Order) ) return false;
        Order castOther = (Order) other;
        return new EqualsBuilder()
            .append(this.getOrderId(), castOther.getOrderId())
            .isEquals();
    }

    public int hashCode() {
        return new HashCodeBuilder()
            .append(getOrderId())
            .toHashCode();
    }

}
