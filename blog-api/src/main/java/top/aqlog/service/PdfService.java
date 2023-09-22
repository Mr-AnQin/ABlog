package top.aqlog.service;

import org.springframework.web.multipart.MultipartFile;

/**
 * @author anqin
 * @date 2022/10/7 14:58
 * @title NBlog
 * @describe
 */
public interface PdfService {
    /**
     * PDF 文件上传
     * @param file PDF
     * @param type PDF类型
     * @return
     */
    String pdfUpload(MultipartFile file, String type) throws Exception;
}
