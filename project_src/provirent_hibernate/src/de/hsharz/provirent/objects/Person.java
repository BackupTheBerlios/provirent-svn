package de.hsharz.provirent.objects;

import java.io.Serializable;
import java.util.Calendar;
import org.apache.commons.lang.builder.EqualsBuilder;
import org.apache.commons.lang.builder.HashCodeBuilder;
import org.apache.commons.lang.builder.ToStringBuilder;


/** 
 *         Represents a single Person.
 *         @author Philipp Schneider
 *       
*/
public class Person implements Serializable {

    /** identifier field */
    private Integer personId;

    /** persistent field */
    private String firstName;

    /** persistent field */
    private String lastName;

    /** nullable persistent field */
    private String middleName;

    /** nullable persistent field */
    private String salutation;

    /** nullable persistent field */
    private String title;

    /** persistent field */
    private String street;

    /** persistent field */
    private String streetNumber;

    /** persistent field */
    private String city;

    /** persistent field */
    private String zipCode;

    /** persistent field */
    private String country;

    /** persistent field */
    private String emailAddress;

    /** nullable persistent field */
    private Calendar dayOfBirth;

    /** full constructor */
    public Person(String firstName, String lastName, String middleName, String salutation, String title, String street, String streetNumber, String city, String zipCode, String country, String emailAddress, Calendar dayOfBirth) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.middleName = middleName;
        this.salutation = salutation;
        this.title = title;
        this.street = street;
        this.streetNumber = streetNumber;
        this.city = city;
        this.zipCode = zipCode;
        this.country = country;
        this.emailAddress = emailAddress;
        this.dayOfBirth = dayOfBirth;
    }

    /** default constructor */
    public Person() {
    }

    /** minimal constructor */
    public Person(String firstName, String lastName, String street, String streetNumber, String city, String zipCode, String country, String emailAddress) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.street = street;
        this.streetNumber = streetNumber;
        this.city = city;
        this.zipCode = zipCode;
        this.country = country;
        this.emailAddress = emailAddress;
    }

    public Integer getPersonId() {
        return this.personId;
    }

    protected void setPersonId(Integer personId) {
        this.personId = personId;
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

    public String getMiddleName() {
        return this.middleName;
    }

    public void setMiddleName(String middleName) {
        this.middleName = middleName;
    }

    public String getSalutation() {
        return this.salutation;
    }

    public void setSalutation(String salutation) {
        this.salutation = salutation;
    }

    public String getTitle() {
        return this.title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getStreet() {
        return this.street;
    }

    public void setStreet(String street) {
        this.street = street;
    }

    public String getStreetNumber() {
        return this.streetNumber;
    }

    public void setStreetNumber(String streetNumber) {
        this.streetNumber = streetNumber;
    }

    public String getCity() {
        return this.city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getZipCode() {
        return this.zipCode;
    }

    public void setZipCode(String zipCode) {
        this.zipCode = zipCode;
    }

    public String getCountry() {
        return this.country;
    }

    public void setCountry(String country) {
        this.country = country;
    }

    public String getEmailAddress() {
        return this.emailAddress;
    }

    public void setEmailAddress(String emailAddress) {
        this.emailAddress = emailAddress;
    }

    public Calendar getDayOfBirth() {
        return this.dayOfBirth;
    }

    public void setDayOfBirth(Calendar dayOfBirth) {
        this.dayOfBirth = dayOfBirth;
    }

    public String toString() {
        return new ToStringBuilder(this)
            .append("personId", getPersonId())
            .append("firstName", getFirstName())
            .append("lastName", getLastName())
            .append("middleName", getMiddleName())
            .append("salutation", getSalutation())
            .append("title", getTitle())
            .append("street", getStreet())
            .append("streetNumber", getStreetNumber())
            .append("city", getCity())
            .append("zipCode", getZipCode())
            .append("country", getCountry())
            .append("emailAddress", getEmailAddress())
            .append("dayOfBirth", getDayOfBirth())
            .toString();
    }

    public boolean equals(Object other) {
        if ( (this == other ) ) return true;
        if ( !(other instanceof Person) ) return false;
        Person castOther = (Person) other;
        return new EqualsBuilder()
            .append(this.getPersonId(), castOther.getPersonId())
            .isEquals();
    }

    public int hashCode() {
        return new HashCodeBuilder()
            .append(getPersonId())
            .toHashCode();
    }

}
