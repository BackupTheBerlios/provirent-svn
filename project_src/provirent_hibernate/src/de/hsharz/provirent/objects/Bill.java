package de.hsharz.provirent.objects;

import java.io.Serializable;
import org.apache.commons.lang.builder.EqualsBuilder;
import org.apache.commons.lang.builder.HashCodeBuilder;
import org.apache.commons.lang.builder.ToStringBuilder;


/** 
 *         Represents a Bill.
 *         @author Philipp Schneider
 *         @todo Orderid muss noch irgendwie rein
 *       
*/
public class Bill implements Serializable {

    /** identifier field */
    private Integer billId;

    /** nullable persistent field */
    private byte[] pdfFile;

    /** nullable persistent field */
    private int pdfFileSize;

    /** nullable persistent field */
    private de.hsharz.provirent.objects.Customer customer;

    /** full constructor */
    public Bill(byte[] pdfFile, int pdfFileSize, de.hsharz.provirent.objects.Customer customer) {
        this.pdfFile = pdfFile;
        this.pdfFileSize = pdfFileSize;
        this.customer = customer;
    }

    /** default constructor */
    public Bill() {
    }

    public Integer getBillId() {
        return this.billId;
    }

    public void setBillId(Integer billId) {
        this.billId = billId;
    }

    public byte[] getPdfFile() {
        return this.pdfFile;
    }

    public void setPdfFile(byte[] pdfFile) {
        this.pdfFile = pdfFile;
    }

    public int getPdfFileSize() {
        return this.pdfFileSize;
    }

    public void setPdfFileSize(int pdfFileSize) {
        this.pdfFileSize = pdfFileSize;
    }

    public de.hsharz.provirent.objects.Customer getCustomer() {
        return this.customer;
    }

    public void setCustomer(de.hsharz.provirent.objects.Customer customer) {
        this.customer = customer;
    }

    public String toString() {
        return new ToStringBuilder(this)
            .append("billId", getBillId())
            .append("pdfFileSize", getPdfFileSize())
            .append("customer", getCustomer())
            .toString();
    }

    public boolean equals(Object other) {
        if ( (this == other ) ) return true;
        if ( !(other instanceof Bill) ) return false;
        Bill castOther = (Bill) other;
        return new EqualsBuilder()
            .append(this.getBillId(), castOther.getBillId())
            .append(this.getPdfFile(), castOther.getPdfFile())
            .append(this.getPdfFileSize(), castOther.getPdfFileSize())
            .append(this.getCustomer(), castOther.getCustomer())
            .isEquals();
    }

    public int hashCode() {
        return new HashCodeBuilder()
            .append(getBillId())
            .append(getPdfFile())
            .append(getPdfFileSize())
            .append(getCustomer())
            .toHashCode();
    }

}
