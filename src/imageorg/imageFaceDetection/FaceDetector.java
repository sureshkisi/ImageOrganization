package imageorg.imageFaceDetection;
import org.opencv.core.Core;
import org.opencv.core.Mat;
import org.opencv.core.MatOfRect;
import org.opencv.core.Rect;
import org.opencv.imgcodecs.Imgcodecs;
import org.opencv.objdetect.CascadeClassifier;

public class FaceDetector
{

    public static void main(String[] args)
    {

        System.loadLibrary(Core.NATIVE_LIBRARY_NAME);


        CascadeClassifier faceDetector = new CascadeClassifier();
        CascadeClassifier eyeDetector=new CascadeClassifier();


        faceDetector.load("D:\\OpenCv\\opencv\\sources\\data\\haarcascades\\haarcascade_frontalface_alt.xml");
//        eyeDetector.load("D:\\OpenCv\\opencv\\sources\\data\\haarcascades\\haarcasccade_eye.xml");

        System.out.println ( "Working" );
        // Input image
        Mat image = Imgcodecs.imread("D:\\001\\0J1A9874.jpg");

        // Detecting faces
        MatOfRect faceDetections = new MatOfRect();
        faceDetector.detectMultiScale(image, faceDetections);

        //Detecting eyes
//        MatOfRect eyeDetections = new MatOfRect();
//        eyeDetector.detectMultiScale(image,eyeDetections);

        // Creating a rectangular box showing faces detected
        Rect rectCrop=null;
        int i=9;
        for (Rect rect : faceDetections.toArray())
        {

//            Imgproc.rectangle(image, new Point(rect.x, rect.y),
//                    new Point(rect.x + rect.width, (rect.y+5) + rect.height),
//                    new Scalar(0, 255, 0));
            rectCrop = new Rect(rect.x, (rect.y+20), rect.width, rect.height);

            // Saving the output image
            Mat markedImage = new Mat(image,rectCrop);
            Imgcodecs.imwrite("D:\\IMAGE PROCESSING\\cropimage"+(i++)+".jpg",markedImage );
        }

        String filename = "Output"+(i++) +".jpg";
        Imgcodecs.imwrite("D:\\IMAGE PROCESSING\\"+filename, image);

    }
}