package com.hendisantika.sekolah.test;

import com.sun.org.apache.xerces.internal.impl.dv.util.Base64;
import org.junit.jupiter.api.Test;
import org.springframework.util.ResourceUtils;

import javax.imageio.ImageIO;
import java.awt.image.BufferedImage;
import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 * Created by IntelliJ IDEA.
 * Project : sekolah
 * User: hendisantika
 * Email: hendisantika@gmail.com
 * Telegram : @hendisantika34
 * Date: 26/03/20
 * Time: 18.08
 */
public class ConvertImage {
    @Test
    public void ConvertImageToByteArray() throws IOException {
        /*
         * 1. How to convert an image file to  byte array?
         */
        String fileName = "girl.png";
        ClassLoader classLoader = new ConvertImage().getClass().getClassLoader();

//        File file = new File(classLoader.getResource(fileName).getFile());
        File file = ResourceUtils.getFile("classpath:girl.png");
        System.out.println("File getAbsolutePath : " + file.getAbsolutePath());
        System.out.println("File: " + file.getName());
        System.out.println("File Found : " + file.exists());

        FileInputStream fis = new FileInputStream(file);
        //create FileInputStream which obtains input bytes from a file in a file system
        //FileInputStream is meant for reading streams of raw bytes such as image data. For reading streams of
        // characters, consider using FileReader.

        ByteArrayOutputStream bos = new ByteArrayOutputStream();
        byte[] buf = new byte[1024];
        try {
            for (int readNum; (readNum = fis.read(buf)) != -1; ) {
                //Writes to this byte array output stream
                bos.write(buf, 0, readNum);
                System.out.println("read " + readNum + " bytes,");
            }
            System.out.println("Size1: " + file.length());
            System.out.println("Size2: " + bos.size());
        } catch (IOException ex) {
            Logger.getLogger(ConvertImage.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

//    @Test
//    public void ConvertByteArrayToImage() throws FileNotFoundException, IOException {
//        /*
//         * 2. How to convert byte array back to an image file?
//         */
//
//        byte[] bytes = bos.toByteArray();
//        ByteArrayInputStream bis = new ByteArrayInputStream(bytes);
//        Iterator<?> readers = ImageIO.getImageReadersByFormatName("jpg");
//
//        //ImageIO is a class containing static methods for locating ImageReaders
//        //and ImageWriters, and performing simple encoding and decoding.
//
//        ImageReader reader = (ImageReader) readers.next();
//        Object source = bis;
//        ImageInputStream iis = ImageIO.createImageInputStream(source);
//        reader.setInput(iis, true);
//        ImageReadParam param = reader.getDefaultReadParam();
//
//        Image image = reader.read(0, param);
//        //got an image file
//
//        BufferedImage bufferedImage = new BufferedImage(image.getWidth(null), image.getHeight(null),
//                BufferedImage.TYPE_INT_RGB);
//        //bufferedImage is the RenderedImage to be written
//
//        Graphics2D g2 = bufferedImage.createGraphics();
//        g2.drawImage(image, null, null);
//
//        File imageFile = new File("C:\\newrose2.jpg");
//        ImageIO.write(bufferedImage, "jpg", imageFile);
//
//        System.out.println(imageFile.getPath());
//    }

    @Test
    public void ConvertImageToByteArrayTest() throws IOException {
        File file = ResourceUtils.getFile("classpath:girl.png");
        String dirName = "/tmp";
        ByteArrayOutputStream baos = new ByteArrayOutputStream(1000);
        BufferedImage img = ImageIO.read(new File(String.valueOf(file)));
        ImageIO.write(img, "jpg", baos);
        baos.flush();

        String base64String = Base64.encode(baos.toByteArray());
        baos.close();

        byte[] byteArray = Base64.decode(base64String);

        BufferedImage imag = ImageIO.read(new ByteArrayInputStream(byteArray));
        ImageIO.write(imag, "jpg", new File(dirName, "hasilnya.jpg"));
        System.out.println("Hasilnya ada di: " + dirName);
    }
}
