package cn.rumofuture.nemo.util.utils;

import java.util.regex.Pattern;

/**
 * Created by WangZhenqi on 2017/8/11.
 */

public class DataUtils {

    private final static Pattern mobilePhoneNumberPattern = Pattern
            .compile("^(1[0-9])\\d{9}$");

    public static boolean isIdEmpty(Integer id) {
        if (null == id || 0 == id)
            return true;
        return false;
    }

    public static boolean isDataEmpty(Object data) {
        if (null == data)
            return true;
        return false;
    }

    public static boolean isDataNull(Object... data) {
        for (int index = 0; index < data.length; index++) {
            if (null == data[index])
                return true;
        }
        return false;
    }

    public static boolean isStringDataEmpty(String... data) {
        for (int index = 0; index < data.length; index++) {
            if (null == data[index] || data[index].equals(""))
                return true;
        }
        return false;
    }

    public static boolean isMobilePhoneNumber(String mobilePhoneNumber) {
        if (isDataEmpty(mobilePhoneNumber) || mobilePhoneNumber.length() != 11)
            return false;
        return mobilePhoneNumberPattern.matcher(mobilePhoneNumber).matches();
    }

//    public static boolean isImage(File file) {
//        ImageInputStream imageInputStream = null;
//        try {
//            imageInputStream = ImageIO.createImageInputStream(file);
//            if (null == imageInputStream) {
//                return false;
//            }
//        } catch (Exception ignored) {
//            return false;
//        } finally {
//            try {
//                if (null != imageInputStream)
//                    imageInputStream.close();
//            } catch (IOException e) {
//                e.printStackTrace();
//            }
//        }
//        return true;
//    }

    public static boolean isImage(String fullFileName) {
        // 获得文件后缀名
        String suffix = fullFileName.substring(fullFileName.lastIndexOf(".") + 1,
                fullFileName.length());
        // 声明图片后缀名数组
        String imageSuffixArray[] = {
                "bmp", "dib", "gif", "jfif", "jpe", "jpeg", "jpg", "png", "tif", "tiff", "ico"
        };
        // 遍历后缀数组
        for (String anImageSuffixArray : imageSuffixArray) {
            // 判断后缀是否匹配
            if (anImageSuffixArray.equals(suffix.toLowerCase())) {
                return true;
            }
        }
        return false;
    }
}
