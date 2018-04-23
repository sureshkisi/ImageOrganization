package imageorg.fileVisitor;

import imageorg.DAO.ImageMetaDAO;
import imageorg.DAO.PhotoMetadata;

import java.io.IOException;
import java.nio.file.*;
import java.nio.file.attribute.BasicFileAttributes;
import java.sql.Date;
import java.util.ArrayList;

public class MyFileVisitor extends SimpleFileVisitor<Path> {

    private ArrayList<PhotoMetadata> imgLocations=new ArrayList<>();

    private MyFileVisitor() {
    }

    //used for checking whether a file is image or not
    private static String getFileExtension(String fullName) {
        if (fullName == null) return "";
        int dotIndex = fullName.lastIndexOf(46);
        return dotIndex == -1 ? "" : fullName.substring(dotIndex + 1);
    }


    @Override
    public FileVisitResult visitFile(Path file, BasicFileAttributes attrs) throws IOException {
        System.out.println(file.toString());
        if (attrs.isRegularFile() && attrs.size()>50000 && getFileExtension(file.toString()).equalsIgnoreCase("jpg")) {
            imgLocations.add(new PhotoMetadata(file.getFileName().toString(),file.toString(),new Date(attrs.creationTime().toMillis()),new Date(attrs.lastModifiedTime().toMillis())));
        }


        return FileVisitResult.CONTINUE;
    }

    //needed to continue to scan file if file is not image
    @Override
    public FileVisitResult visitFileFailed(Path file, IOException exc) throws IOException {
        return FileVisitResult.CONTINUE;
    }

    public static void getMyFileVisitor(String path) throws IOException {
        MyFileVisitor myFileVisitor = new MyFileVisitor();
        Path files = Paths.get(path);
        Files.walkFileTree(files, myFileVisitor);
        new ImageMetaDAO().saveMeta(myFileVisitor.imgLocations);
    }

}
