// FileUtils.java
package com.macys.pos.utils;

import org.apache.commons.codec.digest.DigestUtils;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;

public class FileUtils {

    public static String calculateMD5Checksum(File file) {
        try (FileInputStream fis = new FileInputStream(file)) {
            return DigestUtils.md5Hex(fis);
        } catch (IOException e) {
            e.printStackTrace();
            return null;
        }
    }

    public static void writeByteArrayToFile(File file, byte[] data) throws IOException {
        FileUtils.writeByteArrayToFile(file, data);
    }

}
