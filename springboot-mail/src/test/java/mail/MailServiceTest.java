package mail;

import com.springboot.MailApplication;
import com.springboot.mail.MailService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import org.thymeleaf.TemplateEngine;
import org.thymeleaf.context.Context;

import javax.annotation.Resource;

/**
 * Created by xiaohong on 2017/11/21.
 */
@RunWith(SpringRunner.class)
@SpringBootTest(classes = MailApplication.class)
public class MailServiceTest {
    @Resource
    private MailService mailService;

    public static final String to = "zhenmoqu12300@163.com";
    @Test
    public void test(){
        mailService.sendSimpleMail(to, "自我介绍","我是小小");
    }

    @Test
    public void test1(){
        String subject = "推荐学习";
        String content = "<html>\n" +
                " <body>\n" +
                "   <a href = \"https://github.com/xiaohongwang\">小小的github地址分享</a>\n" +
                " </body>\n" +
                "</html>";
        mailService.sendHtmlMail(to, subject, content);
    }

    @Test
    public void test2(){
        String subject = "学习资料";
        String content = "<html>\n" +
                " <body>\n" +
                "   <a href = \"https://github.com/xiaohongwang\">小小的github地址分享</a>\n" +
                "   <p>  第三方支付资深架构师系列博文  </p>\n"+
                "   <a href = \"http://www.ityouknow.com/spring-boot\">博文地址</a>\n"+
                "   <a href = \"https://github.com/ityouknow/spring-boot-examples\">github项目源码</a>\n"+
                "   <p> 更过的资料请查看附件  </p>\n"+
                " </body>\n" +
                "</html>";
        String filePath = "G:\\learn.txt";
        mailService.sendAttachmentsMail(to, subject, content, filePath);
    }

    @Test
    public void test3(){
        String subject = "静态资邮件源";
        String srcId = "100";

        String content = "<html>\n" +
                " <body>\n" +
                "   <img  style= \'width: 40%; height: 50%\' src= \'cid:"+ srcId
                + "\'>\n" +
                " </body>\n" +
                "</html>";
        String srcPath = "G:\\100.jpg";
        mailService.sendInlineResourceMail(to, subject, content, srcPath, srcId);
    }

    @Resource
    private TemplateEngine templateEngine;

    @Test
    public void test4(){
        Context context = new Context();
        context.setVariable("userName","xiaoxiao");
        String subject = "模板邮件";
        String emailContent = templateEngine.process("emailTemplate", context);
        mailService.sendHtmlMail(to, subject, emailContent);
    }

}
