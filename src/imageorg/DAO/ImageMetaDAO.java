package imageorg.DAO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.ArrayList;

public class ImageMetaDAO{

        private Connection con;
    public void saveMeta(ArrayList<PhotoMetadata> metadatas){
        String sql="insert into IMAGE.IMAGE_META(img_name,img_path,creation_date,modified_date) values(?,?,?,?)";
        if(con==null)
            con=DatabaseConnectivity.getConnection();

        final int batchSize=1000;
        int count=0;

        System.out.println("The size is :"+metadatas.size());

        try (PreparedStatement ps=con.prepareStatement(sql)) {

            for(PhotoMetadata metadata:metadatas){
                ps.setString(1,metadata.getImgName());
                ps.setString(2,metadata.getImgPath());
                ps.setDate(3,metadata.getCreationDate());
                ps.setDate(4,metadata.getModifiedDate());
                ps.addBatch();

                if(++count % batchSize == 0) {
                    ps.executeBatch();
                }
            }

            ps.executeBatch();

        } catch (SQLException e) {
            e.printStackTrace();
        }



    }

    public PhotoMetadata loadMeta(PhotoMetadata path) {
        return null;
    }
}