/*
 * Created on 06.10.2004
 *
 * Copyright (c) 2004/2005, Remo Griesch/Stefan Forstner/Philipp Schneider
 * All rights reserved.
 *
 * Redistribution and use in source and binary forms, with or without
 * modification, are permitted provided that the following conditions
 * are met:
 *
 * - Redistributions of source code must retain the above copyright notice,
 * this list of conditions and the following disclaimer.
 * - Redistributions in binary form must reproduce the above copyright notice,
 * this list of conditions and the following disclaimer in the documentation
 * and/or other materials provided with the distribution.
 * - Neither the name of the Remo Griesch/Stefan Forstner/Philipp Schneider nor
 * the names of its contributors may be used to endorse or promote products
 * derived from this software without specific prior written permission.
 *
 * THIS SOFTWARE IS PROVIDED BY THE COPYRIGHT HOLDERS AND CONTRIBUTORS "AS IS"
 * AND ANY EXPRESS OR IMPLIED WARRANTIES, INCLUDING, BUT NOT LIMITED TO, THE
 * IMPLIED WARRANTIES OF MERCHANTABILITY AND FITNESS FOR A PARTICULAR PURPOSE
 * ARE DISCLAIMED. IN NO EVENT SHALL THE COPYRIGHT OWNER OR CONTRIBUTORS BE
 * LIABLE FOR ANY DIRECT, INDIRECT, INCIDENTAL, SPECIAL, EXEMPLARY, OR
 * CONSEQUENTIAL DAMAGES (INCLUDING, BUT NOT LIMITED TO, PROCUREMENT OF
 * SUBSTITUTE GOODS OR SERVICES; LOSS OF USE, DATA, OR PROFITS; OR BUSINESS
 * INTERRUPTION) HOWEVER CAUSED AND ON ANY THEORY OF LIABILITY, WHETHER IN
 * CONTRACT, STRICT LIABILITY, OR TORT (INCLUDING NEGLIGENCE OR OTHERWISE)
 * ARISING IN ANY WAY OUT OF THE USE OF THIS SOFTWARE, EVEN IF ADVISED OF THE
 * POSSIBILITY OF SUCH DAMAGE.
 *
 */
package de.hsharz.provirent.objects;

import java.util.Calendar;

import org.apache.commons.lang.builder.ToStringBuilder;

/**
 * @author Philipp Schneider
 *
 */
public class Customer {

    private int userId;
    private String firstName;
    private String lastName;
    private String middleName;
    private String salutation; //Herr Frau Firma Familie
    private String title;
    private String street;
    private String streetNumber;
    private String city;
    private String zipCode;
    private String country;
    private Calendar dayOfBirth;
    private Calendar dayOfRegistration;
    private String emailAddress;
    private String userName;
    private String password;
    private String hiddenQuestion;
    private String hiddenAnswer;
    
    
    
    /**
     * @return Returns the city.
     */
    public String getCity() {
        return city;
    }
    /**
     * @param city The city to set.
     */
    public void setCity(final String city) {
        this.city = city;
    }
    /**
     * @return Returns the country.
     */
    public String getCountry() {
        return country;
    }
    /**
     * @param country The country to set.
     */
    public void setCountry(final String country) {
        this.country = country;
    }
    /**
     * @return Returns the dayOfBirth.
     */
    public Calendar getDayOfBirth() {
        return dayOfBirth;
    }
    /**
     * @param dayOfBirth The dayOfBirth to set.
     */
    public void setDayOfBirth(final Calendar dayOfBirth) {
        this.dayOfBirth = dayOfBirth;
    }
    /**
     * @return Returns the dayOfRegistration.
     */
    public Calendar getDayOfRegistration() {
        return dayOfRegistration;
    }
    /**
     * @param dayOfRegistration The dayOfRegistration to set.
     */
    public void setDayOfRegistration(final Calendar dayOfRegistration) {
        this.dayOfRegistration = dayOfRegistration;
    }
    /**
     * @return Returns the emailAddress.
     */
    public String getEmailAddress() {
        return emailAddress;
    }
    /**
     * @param emailAddress The emailAddress to set.
     */
    public void setEmailAddress(final String emailAddress) {
        this.emailAddress = emailAddress;
    }
    /**
     * @return Returns the firstName.
     */
    public String getFirstName() {
        return firstName;
    }
    /**
     * @param firstName The firstName to set.
     */
    public void setFirstName(final String firstName) {
        this.firstName = firstName;
    }
    /**
     * @return Returns the hiddenAnswer.
     */
    public String getHiddenAnswer() {
        return hiddenAnswer;
    }
    /**
     * @param hiddenAnswer The hiddenAnswer to set.
     */
    public void setHiddenAnswer(final String hiddenAnswer) {
        this.hiddenAnswer = hiddenAnswer;
    }
    /**
     * @return Returns the hiddenQuestion.
     */
    public String getHiddenQuestion() {
        return hiddenQuestion;
    }
    /**
     * @param hiddenQuestion The hiddenQuestion to set.
     */
    public void setHiddenQuestion(final String hiddenQuestion) {
        this.hiddenQuestion = hiddenQuestion;
    }
    /**
     * @return Returns the lastName.
     */
    public String getLastName() {
        return lastName;
    }
    /**
     * @param lastName The lastName to set.
     */
    public void setLastName(final String lastName) {
        this.lastName = lastName;
    }
    /**
     * @return Returns the middleName.
     */
    public String getMiddleName() {
        return middleName;
    }
    /**
     * @param middleName The middleName to set.
     */
    public void setMiddleName(final String middleName) {
        this.middleName = middleName;
    }
    /**
     * @return Returns the password.
     */
    public String getPassword() {
        return password;
    }
    /**
     * @param password The password to set.
     */
    public void setPassword(final String password) {
        this.password = password;
    }
    /**
     * @return Returns the salutation.
     */
    public String getSalutation() {
        return salutation;
    }
    /**
     * @param salutation The salutation to set.
     */
    public void setSalutation(final String salutation) {
        this.salutation = salutation;
    }
    /**
     * @return Returns the street.
     */
    public String getStreet() {
        return street;
    }
    /**
     * @param street The street to set.
     */
    public void setStreet(final String street) {
        this.street = street;
    }
    /**
     * @return Returns the streetNumber.
     */
    public String getStreetNumber() {
        return streetNumber;
    }
    /**
     * @param streetNumber The streetNumber to set.
     */
    public void setStreetNumber(final String streetNumber) {
        this.streetNumber = streetNumber;
    }
    /**
     * @return Returns the title.
     */
    public String getTitle() {
        return title;
    }
    /**
     * @param title The title to set.
     */
    public void setTitle(final String title) {
        this.title = title;
    }
    /**
     * @return Returns the userId.
     */
    public int getUserId() {
        return userId;
    }
    /**
     * @param userId The userId to set.
     */
    public void setUserId(final int userId) {
        this.userId = userId;
    }
    /**
     * @return Returns the userName.
     */
    public String getUserName() {
        return userName;
    }
    /**
     * @param userName The userName to set.
     */
    public void setUserName(final String userName) {
        this.userName = userName;
    }
    /**
     * @return Returns the zipCode.
     */
    public String getZipCode() {
        return zipCode;
    }
    /**
     * @param zipCode The zipCode to set.
     */
    public void setZipCode(final String zipCode) {
        this.zipCode = zipCode;
    }
    public String toString() {
        return new ToStringBuilder(this).
          append("userId", userId).
          append("salutation", salutation).
          append("title", title).
          append("firstName", firstName).
          append("middleName", middleName).
          append("lastName", lastName).
          append("street", street).
          append("streetNumber", streetNumber).
          append("zipCode", zipCode).
          append("city", city).
          append("country", country).
          append("dayOfBirth", dayOfBirth).
          append("emailAddress", emailAddress).
          append("dayOfRegistration", dayOfRegistration).
          append("userName", userName).
          append("password", password).
          append("hiddenQuestion", hiddenQuestion).
          append("hiddenAnswer", hiddenAnswer).
          toString();
      }
    
    
    
    
}
