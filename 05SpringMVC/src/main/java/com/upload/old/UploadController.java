package com.upload.old;

import org.apache.commons.fileupload.FileItem;
import org.apache.commons.fileupload.FileUploadException;
import org.apache.commons.fileupload.disk.DiskFileItemFactory;
import org.apache.commons.fileupload.servlet.ServletFileUpload;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.File;
import java.util.List;
import java.util.UUID;

@Controller
@RequestMapping("/upload")
public class UploadController {
    @RequestMapping("/uploadFile")
    public String uploadFile(HttpServletRequest request) throws Exception {
        String realPath = request.getSession().getServletContext().getRealPath("/uploads/");
        System.out.println(realPath);
        File file = new File(realPath);
        if(!file.exists()){
            file.mkdirs();
        }
        //解析request对象，获取上传文件信息
        DiskFileItemFactory factory = new DiskFileItemFactory();
        ServletFileUpload upload = new ServletFileUpload(factory);
        List<FileItem> fileItems = upload.parseRequest(request);
        for (FileItem fileItem : fileItems) {
            if(fileItem.isFormField()){
                //普通表单项
                System.out.println(fileItem.getFieldName());
            }else{
                //文件上传项
                String name = fileItem.getName();
                String uuid = UUID.randomUUID().toString().replace("-","").toLowerCase();
                fileItem.write(new File(realPath,uuid+"_"+name));
                //删除临时文件
                fileItem.delete();
            }
        }
        return "uploadSuccess";
    }

    /**
     * SpringMVC方式上传
      * @param request
     * @return
     * @throws Exception
     */
    @RequestMapping("/uploadFile2")
    public String uploadFile2(HttpServletRequest request, MultipartFile upload) throws Exception {
        String realPath = request.getSession().getServletContext().getRealPath("/uploads/");
        File file = new File(realPath);
        if(!file.exists()){
            file.mkdirs();
        }
        String filename = upload.getOriginalFilename();
        String uuid = UUID.randomUUID().toString().replace("-", "").toLowerCase();
        upload.transferTo(new File(realPath,uuid+"_"+filename));
        return "uploadSuccess";
    }
}
