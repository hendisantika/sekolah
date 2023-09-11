package com.hendisantika.sekolah.test;

import static org.junit.jupiter.api.Assertions.assertTrue;

import java.awt.image.BufferedImage;
import java.io.*;
import java.util.Objects;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.imageio.ImageIO;
import org.apache.commons.codec.binary.Base64;
import org.apache.commons.io.FileUtils;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.util.ResourceUtils;

/**
 * Created by IntelliJ IDEA.
 * Project : sekolah
 * User: hendisantika
 * Email: hendisantika@gmail.com
 * Telegram : @hendisantika34
 * Date: 26/03/20
 * Time: 18.08
 */
@SpringBootTest
class ConvertImageTest {
    private final String INPUT_FILE_PATH = "ninja.jpeg";
    private final String OUTPUT_FILE_PATH = "ninja-test_image_copy.jpeg";

    @Test
    void ConvertImageToByteArray() throws IOException {
        /*
         * 1. How to convert an image file to  byte array?
         */
        String fileName = "girl.png";
        ClassLoader classLoader = ConvertImageTest.class.getClassLoader();

        File file = new File(Objects.requireNonNull(classLoader.getResource(fileName)).getFile());
//        File file = ResourceUtils.getFile("classpath:girl.png");
        System.out.println("File getAbsolutePath : " + file.getAbsolutePath());
        System.out.println("File: " + file.getName());
        System.out.println("File Found : " + file.exists());

        try (FileInputStream fis = new FileInputStream(file)) {
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
                Logger.getLogger(ConvertImageTest.class.getName()).log(Level.SEVERE, null, ex);
            }
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
    void ConvertImageToByteArrayTest() throws IOException {
        File file = ResourceUtils.getFile("classpath:girl.png");
        String dirName = "/tmp";
        ByteArrayOutputStream baos = new ByteArrayOutputStream(1000);
        BufferedImage img = ImageIO.read(new File(String.valueOf(file)));
        ImageIO.write(img, "jpg", baos);
        baos.flush();

        Base64 base64 = new Base64();
        byte[] base64String = base64.encode(baos.toByteArray());
//        String base64String = new String(base64.encode(baos.toByteArray()));
        baos.close();

        byte[] byteArray = base64.decode(base64String);

        BufferedImage imag = ImageIO.read(new ByteArrayInputStream(byteArray));
        ImageIO.write(imag, "jpg", new File(dirName, "hasilnya.jpg"));
        System.out.println("Hasilnya ada di: " + dirName);
    }

    @Test
    void ConvertImageFileToBase64StringTest() throws IOException {
        //load file from /src/test/resources
        ClassLoader classLoader = getClass().getClassLoader();
        File inputFile = new File(Objects.requireNonNull(classLoader
                        .getResource(INPUT_FILE_PATH))
                .getFile());

        byte[] fileContent = FileUtils.readFileToByteArray(inputFile);
        String encodedString = java.util.Base64
                .getEncoder()
                .encodeToString(fileContent);

        //create output file
        File outputFile = new File(inputFile
                .getParentFile()
                .getAbsolutePath() + File.pathSeparator + OUTPUT_FILE_PATH);

        // decode the string and write to file
        byte[] decodedBytes = java.util.Base64
                .getDecoder()
                .decode(encodedString);
        FileUtils.writeByteArrayToFile(outputFile, decodedBytes);

        assertTrue(FileUtils.contentEquals(inputFile, outputFile));
    }

}
