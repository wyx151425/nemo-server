package cn.rumofuture.nemo.util.utils;

/**
 * Created by WangZhenqi on 2017/8/11.
 */

public class FilePathUtils {

    public static String getUserAvatarPath(Integer userId) {
        return "C:/Nemo/File/User/" + userId + "/Avatar/";
    }

    public static String getUserPortraitPath(Integer userId) {
        return "C:/Nemo/File/User/" + userId + "/Portrait/";
    }

    public static String getBookCoverPath(Integer bookId) {
        return "C:/Nemo/File/Book/" + bookId + "/Cover/";
    }

    public static String getPageImagePath(Integer pageId) {
        return "C:/Nemo/File/Page/" + pageId + "/Image/";
    }
}
