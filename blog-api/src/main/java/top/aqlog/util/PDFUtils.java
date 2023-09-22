package top.aqlog.util;

import com.itextpdf.text.pdf.PdfReader;
import org.apache.pdfbox.pdmodel.PDDocument;
import org.apache.pdfbox.rendering.PDFRenderer;

import javax.imageio.ImageIO;
import java.awt.image.BufferedImage;
import java.io.*;
import java.util.*;
import java.util.List;

/**
 * @author anqin
 * @date 2022/10/7 17:58
 * @title NBlog
 * @describe
 */
public class PDFUtils {


    /**
     * 获取总页数
     *
     * @param pdfIn PDF 字节数组
     * @return 总页数
     * @throws IOException 文件解析异常
     */
    public static String getTotalPages(byte[] pdfIn) throws IOException {
        PdfReader reader = new PdfReader(pdfIn);
        int pages = reader.getNumberOfPages();
        System.out.println("pdf总共多少页-----" + pages);
        return String.valueOf(pages);
    }


    /**
     * PDF文件转PNG图片，全部页数
     *
     * @param f PDF
     * @param dstImgFolder 图片存放的文件夹
     * @param dpi dpi越大转换后越清晰，相对转换速度越慢
     * @return 返回转换后图片集合list
     */
    public static List<String> pdfToImage(File f, String dstImgFolder, int dpi) {
        String uuId = UUID.randomUUID().toString();
        System.out.println(uuId);

        //定义集合保存返回图片数据
        List<String> fileList = new ArrayList<String>();
        @SuppressWarnings("resource")//抑制警告
        PDDocument pdDocument = new PDDocument();
        try {
            //String imagePDFName = file.getName().substring(0, dot); // 获取图片文件名
            String imgFolderPath = null;
            imgFolderPath = dstImgFolder + File.separator + uuId;// 获取图片存放的文件夹路径
            if (createDirectory(imgFolderPath)) {
                pdDocument = PDDocument.load(f);
                PDFRenderer renderer = new PDFRenderer(pdDocument);
                /* dpi越大转换后越清晰，相对转换速度越慢 */

                // TODO 只获取首页，若需要全部转，先获取全部页数，使用for循环即可
                StringBuilder imgFilePath = null;
                for (int i = 0; i < 1; i++) {
                    String imgFilePathPrefix = imgFolderPath + File.separator + "study";
                    System.out.println("imgFilePathPrefix=====" + imgFilePathPrefix);
                    imgFilePath = new StringBuilder();
                    imgFilePath.append(imgFilePathPrefix);
                    imgFilePath.append("-");
                    imgFilePath.append(String.valueOf(i));
                    imgFilePath.append(".jpg");
                    File dstFile = new File(imgFilePath.toString());
                    BufferedImage image = renderer.renderImageWithDPI(i, dpi);
                    ImageIO.write(image, "png", dstFile);
                    fileList.add(dstFile.toString());
                }
                System.out.println("PDF文档转PNG图片成功！");
                pdDocument.close();
                fileList.add(uuId);
                return fileList;
            } else {
                System.out.println("PDF文档转PNG图片失败：" + "创建" + imgFolderPath + "失败");
                return null;
            }
        } catch (IOException e) {
            e.printStackTrace();
            return null;
        }
    }

    //创建文件夹
    private static boolean createDirectory(String folder) {
        File dir = new File(folder);
        if (dir.exists()) {
            return true;
        } else {
            return dir.mkdirs();
        }
    }
}
