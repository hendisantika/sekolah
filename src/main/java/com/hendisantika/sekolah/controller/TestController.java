package com.hendisantika.sekolah.controller;

import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Base64;

/**
 * Created by IntelliJ IDEA.
 * Project : sekolah
 * User: hendisantika
 * Email: hendisantika@gmail.com
 * Telegram : @hendisantika34
 * Date: 26/03/20
 * Time: 07.35
 */
@Slf4j
@Controller
@RequestMapping("tes")
public class TestController {

    //Save the uploaded file to this folder
    private static String UPLOADED_FOLDER = System.getProperty("java.io.tmpdir");

    @GetMapping("upload")
    public String index() {
        return "samples/upload";
    }

    @PostMapping("upload")
    public String singleFileUpload(@RequestParam("file") MultipartFile file,
                                   RedirectAttributes redirectAttributes) {
        log.info("UPLOADED_FOLDER --> ", UPLOADED_FOLDER);
        if (file.isEmpty()) {
            redirectAttributes.addFlashAttribute("message", "Please select a file to upload");
            return "redirect:uploadStatus";
        }

        try {

            // Get the file and save it somewhere
            byte[] bytes = file.getBytes();
            String encoded = Base64.getEncoder().encodeToString(bytes);
            byte[] decoded = Base64.getDecoder().decode(encoded);
            log.info("Image Base64 Encoded {}", encoded);
            Path path = Paths.get(UPLOADED_FOLDER + file.getOriginalFilename());
            Files.write(path, bytes);

            redirectAttributes.addFlashAttribute("message",
                    "You successfully uploaded '" + file.getOriginalFilename() + "'");

        } catch (IOException e) {
            e.printStackTrace();
        }

        return "redirect:/uploadStatus";
    }

    @GetMapping("/uploadStatus")
    public String uploadStatus() {
        return "uploadStatus";
    }
    //    public String test1(Model model, @RequestParam("file") MultipartFile file){
    //
    //        try {
    //            // Reading a Image file from file system
    //            FileInputStream imageInFile = new FileInputStream(file);
    //            byte imageData[] = new byte[(int) file.length()];
    //            imageInFile.read(imageData);
    //
    //            // Converting Image byte array into Base64 String
    //            String imageDataString = encodeImage(imageData);
    //
    //            // Converting a Base64 String into Image byte array
    //            byte[] imageByteArray = decodeImage(imageDataString);
    //
    //            // Write a image byte array into file system
    //            FileOutputStream imageOutFile = new FileOutputStream(
    //                    "/Users/jeeva/Pictures/wallpapers/water-drop-after-convert.jpg");
    //
    //            imageOutFile.write(imageByteArray);
    //
    //            imageInFile.close();
    //            imageOutFile.close();
    //
    //            System.out.println("Image Successfully Manipulated!");
    //        } catch (FileNotFoundException e) {
    //            System.out.println("Image not found" + e);
    //        } catch (IOException ioe) {
    //            System.out.println("Exception while reading the Image " + ioe);
    //        }
    //    }

//    public static void main(String[] args) throws UnsupportedEncodingException {
//
//        byte[] bytes = "Hello, World!".getBytes("UTF-8");
//        String encoded = Base64.getEncoder().encodeToString(bytes);
//        byte[] decoded = Base64.getDecoder().decode(encoded);
//
//        System.out.println("Original --> " + bytes);
//        System.out.println("encoded --> " + encoded);
//        System.out.println("decoded --> " + decoded);
//    }
}
