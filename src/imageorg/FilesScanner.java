package imageorg;

import imageorg.fileVisitor.MyFileVisitor;

import java.io.IOException;

public class FilesScanner {
    public static void main(String[] args) throws IOException {
        long a= System.currentTimeMillis();
        MyFileVisitor.getMyFileVisitor("D:\\001");
        System.out.println(System.currentTimeMillis()-a);
    }
}
