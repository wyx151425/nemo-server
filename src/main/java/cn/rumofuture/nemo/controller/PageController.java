package cn.rumofuture.nemo.controller;

import cn.rumofuture.nemo.domain.dto.ResponseEntity;
import cn.rumofuture.nemo.service.BookService;
import cn.rumofuture.nemo.service.PageService;
import cn.rumofuture.nemo.util.utils.DataUtils;
import cn.rumofuture.nemo.util.utils.FilePathUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.io.IOException;

/**
 * Created by WangZhenqi on 2017/8/11.
 */

@RestController
@RequestMapping(value = "/page")
public class PageController {

    @Autowired
    private BookService bookService;

    @Autowired
    private PageService pageService;

    private ResponseEntity responseEntity = null;

    /**
     * 漫画册分页上传方法，逻辑如下：
     * 1.
     *
     * @param bookId 所属漫画册的id
     * @param image  漫画分页图片
     * @return 返回响应结果对象
     */
    @PostMapping(value = "/append")
    public ResponseEntity bookCoverUpload(
            @RequestParam(value = "bookId", required = true) Integer bookId,
            @RequestParam(value = "image", required = true) MultipartFile image
    ) {
        responseEntity = new ResponseEntity();  // 创建返回对象

        // 检查客户端提交的数据
        if (DataUtils.isIdEmpty(bookId)) {
            responseEntity.setCode(ResponseEntity.FAILED);
            responseEntity.setMessage("文件上传失败");
            responseEntity.setData(null);
            return responseEntity;
        }

        // 如果文件不为空，则将文件保存到制定路径中
        if (!image.isEmpty()) {
            // 上传文件路径
            String path = FilePathUtils.getPageImagePath(bookId);
            // 上传文件名
            String fileName = image.getOriginalFilename();
            File filePath = new File(path, fileName);
            // 判断路径是否存在，如果不存在则创建路径
            if (!filePath.getParentFile().exists()) {
                filePath.getParentFile().mkdirs();
            }
            // 将上传文件保存到一个目标文件当中
            try {
                image.transferTo(new File(path + fileName));
                responseEntity.setCode(ResponseEntity.SUCCESS);
                responseEntity.setMessage("文件上传成功");
                responseEntity.setData(path + fileName);
            } catch (IOException e) {
                responseEntity.setCode(ResponseEntity.FAILED);
                responseEntity.setMessage("文件保存失败");
                responseEntity.setData(null);
            }
        } else {
            responseEntity.setCode(ResponseEntity.FAILED);
            responseEntity.setMessage("文件上传失败");
            responseEntity.setData(null);
        }
        return responseEntity;
    }
}
