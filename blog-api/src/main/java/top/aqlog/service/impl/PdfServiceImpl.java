package top.aqlog.service.impl;

import com.aliyun.oss.OSS;
import org.apache.tomcat.util.http.fileupload.FileUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;
import top.aqlog.config.properties.AliyunProperties;
import top.aqlog.entity.Pdf;
import top.aqlog.mapper.PdfMapper;
import top.aqlog.service.PdfService;
import top.aqlog.util.PDFUtils;
import top.aqlog.util.upload.MultipartFileToFile;

import java.io.File;
import java.net.URL;
import java.util.Date;
import java.util.List;

/**
 * @author anqin
 * @date 2022/10/7 14:58
 * @title NBlog
 * @describe
 */
@Service
public class PdfServiceImpl implements PdfService {
    @Autowired
    private OSS oss;
    @Autowired
    private AliyunProperties aliyunProperties;

    @Autowired
    private PdfMapper pdfMapper;

    @Override
    public String pdfUpload(MultipartFile file, String type) throws Exception {


        // 源文件名
        String fileName = file.getOriginalFilename();

        // 文件类型
        String fileType = file.getContentType();
        // 字节数量
        String size = String.valueOf(file.getSize());

        String name = file.getName();

        // 将MultipartFile 转为 File
        try {
            File f = MultipartFileToFile.multipartFileToFile(file);
            // 上传至oss
            oss.putObject(aliyunProperties.getBucketName(), fileName, f);

            // 获取总页数
            String totalPages = PDFUtils.getTotalPages(file.getBytes());

            // 获取返回的URL
            Date expiration = new Date(System.currentTimeMillis() + (3600L * 1000 * 24 * 365 * 10) * 100);
            // 生成Url
            URL url = oss.generatePresignedUrl(aliyunProperties.getBucketName(), fileName, expiration);
            System.out.println(url);


            List<String> list = PDFUtils.pdfToImage(f, "D:\\AnQinBlog_PDF_images_temp", 150);
            if(list == null){
                return fileName;
            }
            oss.putObject(aliyunProperties.getBucketName(), fileName,new File(list.get(0)));
            FileUtils.forceDelete(new File("D:\\AnQinBlog_PDF_images_temp\\" + list.get(1)));
            // 首图
            URL urlImg = oss.generatePresignedUrl(aliyunProperties.getBucketName(), fileName, expiration);
            System.out.println(urlImg);
            // 数据分装
            Pdf pdf = new Pdf(null, fileName, null, type, new Date().toString(), null, totalPages, urlImg.toString(), url.toString(), fileType,size);

         //   pdfMapper.pdfUpload(pdf);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return fileName;
    }
}
