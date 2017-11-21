package com.springboot.mail;

import javax.xml.soap.SAAJResult;

/**
 * Created by xiaohong on 2017/11/21.
 */
public interface MailService {

    void sendSimpleMail(String to, String subject, String content);

    /**
     * 发送html格式邮件
     * @param to
     * @param subject
     * @param content
     */
    void sendHtmlMail(String to, String subject, String content);

    /**
     * 发送带附件的邮件
     * @param to
     * @param subject
     * @param content
     * @param filePath
     */
    void sendAttachmentsMail(String to, String subject, String content, String filePath);

    /**
     * 发送带静态资源的邮件
     */
    void sendInlineResourceMail(String to, String subject, String content, String srcPath, String srcId);

}
