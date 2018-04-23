package imageorg.DAO;

import java.sql.Date;

public class PhotoMetadata {
    private String imgName;
    private String imgPath;
    private Date creationDate;
    private Date modifiedDate;

    public PhotoMetadata(String imgName, String imgPath, Date creationDate, Date modifiedDate) {
        this.imgName = imgName;
        this.imgPath = imgPath;
        this.creationDate = creationDate;
        this.modifiedDate = modifiedDate;
    }

    public String getImgName() {
        return imgName;
    }

    public String getImgPath() {
        return imgPath;
    }

    public Date getCreationDate() {
        return creationDate;
    }

    public Date getModifiedDate() {
        return modifiedDate;
    }
}
