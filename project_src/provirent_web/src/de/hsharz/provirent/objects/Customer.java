package de.hsharz.provirent.objects;

import java.io.Serializable;
import java.util.Calendar;
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
    private String firstName;

    /** persistent field */
    private String lastName;

    /** persistent field */
    private String middleName;

    /** persistent field */
    private String salutation;

    /** persistent field */
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

    /** persistent field */
    private String userName;

    /** persistent field */
    private String password;

    /** persistent field */
    private String hiddenQuestion;

    /** persistent field */
    private String hiddenAnswer;

    /** nullable persistent field */
    private Calendar dayOfBirth;

    /** persistent field */
    private Calendar dayOfRegistration;

    /** full constructor */
    public Customer(String firstName, String lastName, String middleName, String salutation, String title, String street, String streetNumber, String city, String zipCode, String country, String emailAddress, String userName, String password, String hiddenQuestion, String hiddenAnswer, Calendar dayOfBirth, Calendar dayOfRegistration) {
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
        this.userName = userName;
        this.password = password;
        this.hiddenQuestion = hiddenQuestion;
        this.hiddenAnswer = hiddenAnswer;
        this.dayOfBirth = dayOfBirth;
        this.dayOfRegistration = dayOfRegistration;
    }

    /** default constructor */
    public Customer() {
    }

    /** minimal constructor */
    public Customer(String firstName, String lastName, String middleName, String salutation, String title, String street, String streetNumber, String city, String zipCode, String country, String emailAddress, String userName, String password, String hiddenQuestion, String hiddenAnswer, Calendar dayOfRegistration) {
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
        this.userName = userName;
        this.password = password;
        this.hiddenQuestion = hiddenQuestion;
        this.hiddenAnswer = hiddenAnswer;
        this.dayOfRegistration = dayOfRegistration;
    }

    public Integer getCustomerId() {
        return this.customerId;
    }

    protected void setCustomerId(Integer customerId) {
        this.customerId = customerId;
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

    public String getUserName() {
        return this.userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getPassword() {
        return this.password;
    }

    public void setPassword(String password) {
        this.password = password;
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

    public Calendar getDayOfBirth() {
        return this.dayOfBirth;
    }

    public void setDayOfBirth(Calendar dayOfBirth) {
        this.dayOfBirth = dayOfBirth;
    }

    public Calendar getDayOfRegistration() {
        return this.dayOfRegistration;
    }

    public void setDayOfRegistration(Calendar dayOfRegistration) {
        this.dayOfRegistration = dayOfRegistration;
    }

    public String toString() {
        return new ToStringBuilder(this)
            .append("customerId", getCustomerId())
            .toString();
    }

}
