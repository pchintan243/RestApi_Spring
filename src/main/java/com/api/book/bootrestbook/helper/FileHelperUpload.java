package com.api.book.bootrestbook.helper;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.nio.file.StandardCopyOption;

import org.springframework.core.io.ClassPathResource;
import org.springframework.stereotype.Component;
import org.springframework.web.multipart.MultipartFile;

@Component
public class FileHelperUpload {
    public final String UPLOAD_DIR = new ClassPathResource("static/images").getFile().getAbsolutePath();

    public FileHelperUpload() throws IOException {
    }

    public boolean uploadFile(MultipartFile f) {
        boolean result = false;
        try {
            // InputStream inputStream = f.getInputStream();
            // byte data[] = new byte[inputStream.available()];
            // inputStream.read(data);

            // // write
            // FileOutputStream fos = new FileOutputStream(UPLOAD_DIR + "\\" +
            // f.getOriginalFilename());
            // fos.write(data);
            // fos.flush();
            // fos.close();

            Files.copy(f.getInputStream(), Paths.get(UPLOAD_DIR + File.separator + f.getOriginalFilename()),
                    StandardCopyOption.REPLACE_EXISTING);
            result = true;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return result;
    }
}
