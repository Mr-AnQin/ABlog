package top.aqlog.mapper;

import org.apache.ibatis.annotations.Mapper;
import top.aqlog.entity.Pdf;

/**
 * @author anqin
 * @date 2022/10/7 17:49
 * @title NBlog
 * @describe
 */
@Mapper
public interface PdfMapper {


    void pdfUpload(Pdf pdf);
}
