package top;

import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;
import top.aqlog.BlogApiApplication;
import top.aqlog.util.MailUtils;

import javax.annotation.Resource;

/**
 * @ClassName: MailTest
 * @author: anqin
 * @Description:
 * @date: 2022/11/24 23:05
 */
@SpringBootTest(classes = BlogApiApplication.class)
public class MailTest {

    @Resource
    private MailUtils mailUtils;

    @Test
    public void hello() {
        mailUtils.sendSimpleMail("1306895785@qq.com",
                "我是邮件的标题",
                "我是邮件的内容");
    }
}
