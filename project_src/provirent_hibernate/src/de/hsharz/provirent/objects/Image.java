package de.hsharz.provirent.objects;

import java.io.Serializable;
import org.apache.commons.lang.builder.EqualsBuilder;
import org.apache.commons.lang.builder.HashCodeBuilder;
import org.apache.commons.lang.builder.ToStringBuilder;


/** 
 *         Represents an Image.
 *         @author Philipp Schneider
 *       
*/
public class Image implements Serializable {

    /** identifier field */
    private Integer imageId;

    /** nullable persistent field */
    private byte[] imageFile;

    /** nullable persistent field */
    private int imageFileSize;

    /** nullable persistent field */
    private String imageFileName;

    /** nullable persistent field */
    private String imageFileDescription;

    /** full constructor */
    public Image(byte[] imageFile, int imageFileSize, String imageFileName, String imageFileDescription) {
        this.imageFile = imageFile;
        this.imageFileSize = imageFileSize;
        this.imageFileName = imageFileName;
        this.imageFileDescription = imageFileDescription;
    }

    /** default constructor */
    public Image() {
    }

    public Integer getImageId() {
        return this.imageId;
    }

    public void setImageId(Integer imageId) {
        this.imageId = imageId;
    }

    public byte[] getImageFile() {
        return this.imageFile;
    }

    public void setImageFile(byte[] imageFile) {
        this.imageFile = imageFile;
    }

    public int getImageFileSize() {
        return this.imageFileSize;
    }

    public void setImageFileSize(int imageFileSize) {
        this.imageFileSize = imageFileSize;
    }

    public String getImageFileName() {
        return this.imageFileName;
    }

    public void setImageFileName(String imageFileName) {
        this.imageFileName = imageFileName;
    }

    public String getImageFileDescription() {
        return this.imageFileDescription;
    }

    public void setImageFileDescription(String imageFileDescription) {
        this.imageFileDescription = imageFileDescription;
    }

    public String toString() {
        return new ToStringBuilder(this)
            .append("imageId", getImageId())
            .append("imageFileSize", getImageFileSize())
            .append("imageFileName", getImageFileName())
            .append("imageFileDescription", getImageFileDescription())
            .toString();
    }

    public boolean equals(Object other) {
        if ( (this == other ) ) return true;
        if ( !(other instanceof Image) ) return false;
        Image castOther = (Image) other;
        return new EqualsBuilder()
            .append(this.getImageId(), castOther.getImageId())
            .append(this.getImageFile(), castOther.getImageFile())
            .append(this.getImageFileSize(), castOther.getImageFileSize())
            .append(this.getImageFileName(), castOther.getImageFileName())
            .append(this.getImageFileDescription(), castOther.getImageFileDescription())
            .isEquals();
    }

    public int hashCode() {
        return new HashCodeBuilder()
            .append(getImageId())
            .append(getImageFile())
            .append(getImageFileSize())
            .append(getImageFileName())
            .append(getImageFileDescription())
            .toHashCode();
    }

}
