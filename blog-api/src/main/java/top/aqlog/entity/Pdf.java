package top.aqlog.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @author anqin
 * @date 2022/10/7 14:49
 * @title NBlog
 * @describe PDF
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Pdf {

    private String id;

    /**
     * 源文件名
     */
    private String fileName;

    /**
     * 分类id
     */
    private String typeId;

    /**
     * 类型
     */
    private String type;
    /**
     * 上传时间
     */
    private String uploadTime;

    /**
     * 修改时间
     */
    private String updateTime;

    /**
     * 总页数
     */
    private String totalPage;

    /**
     * 首页图：用作前端展示
     */
    private String firstFigure;

    /**
     * url
     */
    private String url;

    /**
     * 文件类型
     */
    private String fileType;

    /**
     * 文件字节数
     */
    private String size;
}
