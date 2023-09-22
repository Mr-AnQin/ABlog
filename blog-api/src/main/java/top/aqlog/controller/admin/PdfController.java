package top.aqlog.controller.admin;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;
import top.aqlog.model.vo.Result;
import top.aqlog.service.PdfService;
import top.aqlog.util.StringUtils;

/**
 * @author anqin
 * @date 2022/10/7 14:45
 * @title Blog
 * @describe PDF上传 后台管理端
 */
@RestController
@RequestMapping("/admin")
public class PdfController {

    @Autowired
    private PdfService pdfService;

    /**
     * PDF 文件上传
     * @param file 文件本体
     * @param type PDF 类型
     * @return String
     */
    @RequestMapping(value = "/pdfUpload",method = {RequestMethod.POST})
    public Result pdfUpload(MultipartFile file,String type){
        if(file.isEmpty() || file.getSize() == 0){
            return Result.error("文件不存在");
        }
        if(StringUtils.isEmpty(type)){
            return Result.error("参数异常");
        }

        try {
            return Result.ok(pdfService.pdfUpload(file,type));
        } catch (Exception e) {
            e.printStackTrace();
            return Result.error(e.getMessage());
        }

    }
}
