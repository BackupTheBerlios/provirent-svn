package de.hsharz.provirent.objects;

import java.io.Serializable;
import java.util.Date;
import org.apache.commons.lang.builder.EqualsBuilder;
import org.apache.commons.lang.builder.HashCodeBuilder;
import org.apache.commons.lang.builder.ToStringBuilder;


/** 
 *         Represents a single customer.
 *         @author Philipp Schneider
 *       
*/
public class Customer implements Serializable {

    /** identifier field */
    private Integer customerId;

    /** persistent field */
    private String userName;

    /** persistent field */
    private String userPassword;

    /** persistent field */
    private String hiddenQuestion;

    /** persistent field */
    private String hiddenAnswer;

    /** nullable persistent field */
    private Date dayOfRegistration;

    /** nullable persistent field */
    private de.hsharz.provirent.objects.Person person;

    /** full constructor */
    public Customer(String userName, String userPassword, String hiddenQuestion, String hiddenAnswer, Date dayOfRegistration, de.hsharz.provirent.objects.Person person) {
        this.userName = userName;
        this.userPassword = userPassword;
        this.hiddenQuestion = hiddenQuestion;
        this.hiddenAnswer = hiddenAnswer;
        this.dayOfRegistration = dayOfRegistration;
        this.person = person;
    }

    /** default constructor */
    public Customer() {
    }

    /** minimal constructor */
    public Customer(String userName, String userPassword, String hiddenQuestion, String hiddenAnswer) {
        this.userName = userName;
        this.userPassword = userPassword;
        this.hiddenQuestion = hiddenQuestion;
        this.hiddenAnswer = hiddenAnswer;
    }

    public Integer getCustomerId() {
        return this.customerId;
    }

    public void setCustomerId(Integer customerId) {
        this.customerId = customerId;
    }

    public String getUserName() {
        return this.userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getUserPassword() {
        return this.userPassword;
    }

    public void setUserPassword(String userPassword) {
        this.userPassword = userPassword;
    }

    public String getHiddenQuestion() {
        return this.hiddenQuestion;
    }

    public void setHiddenQuestion(String hiddenQuestion) {
        this.hiddenQuestion = hiddenQuestion;
    }

    public String getHiddenAnswer() {
        return this.hiddenAnswer;
    }

    public void setHiddenAnswer(String hiddenAnswer) {
        this.hiddenAnswer = hiddenAnswer;
    }

    public Date getDayOfRegistration() {
        return this.dayOfRegistration;
    }

    public void setDayOfRegistration(Date dayOfRegistration) {
        this.dayOfRegistration = dayOfRegistration;
    }

    public de.hsharz.provirent.objects.Person getPerson() {
        return this.person;
    }

    public void setPerson(de.hsharz.provirent.objects.Person person) {
        this.person = person;
    }

    public String toString() {
        return new ToStringBuilder(this)
            .append("customerId", getCustomerId())
            .append("userName", getUserName())
            .append("userPassword", getUserPassword())
            .append("hiddenQuestion", getHiddenQuestion())
            .append("hiddenAnswer", getHiddenAnswer())
            .append("dayOfRegistration", getDayOfRegistration())
            .toString();
    }

    public boolean equals(Object other) {
        if ( (this == other ) ) return true;
        if ( !(other instanceof Customer) ) return false;
        Customer castOther = (Customer) other;
        return new EqualsBuilder()
            .append(this.getCustomerId(), castOther.getCustomerId())
            .append(this.getUserName(), castOther.getUserName())
            .append(this.getUserPassword(), castOther.getUserPassword())
            .append(this.getHiddenQuestion(), castOther.getHiddenQuestion())
            .append(this.getHiddenAnswer(), castOther.getHiddenAnswer())
            .append(this.getDayOfRegistration(), castOther.getDayOfRegistration())
            .append(this.getPerson(), castOther.getPerson())
            .isEquals();
    }

    public int hashCode() {
        return new HashCodeBuilder()
            .append(getCustomerId())
            .append(getUserName())
            .append(getUserPassword())
            .append(getHiddenQuestion())
            .append(getHiddenAnswer())
            .append(getDayOfRegistration())
            .append(getPerson())
            .toHashCode();
    }

}
