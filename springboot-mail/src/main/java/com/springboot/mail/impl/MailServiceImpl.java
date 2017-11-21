package com.springboot.mail.impl;

import com.springboot.mail.MailService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.core.io.FileSystemResource;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import javax.mail.MessagingException;
import javax.mail.internet.MimeMessage;
import java.io.File;

/**
 * Created by xiaohong on 2017/11/21.
 */
@Service
public class MailServiceImpl implements MailService {

   private Logger logger = LoggerFactory.getLogger(MailServiceImpl.class);

    @Resource
    private JavaMailSender mailSender;

    @Value("${mail.fromMail.addr}")
    private String from;

    @Override
    public void sendSimpleMail(String to, String subject, String content) {
        SimpleMailMessage message = new SimpleMailMessage();
        message.setFrom(from);
        message.setTo(to);
        message.setSubject(subject);
        message.setText(content);

        try{
            mailSender.send(message);
            logger.info("简单邮件发送成功");
        }catch (Exception e){
            logger.error(e.getMessage());
            logger.error("发送简单邮件时发生异常");
        }

    }

    @Override
    public void sendHtmlMail(String to, String subject, String content) {
        MimeMessage mimeMessage = mailSender.createMimeMessage();

        try {

            logger.info(content);
            MimeMessageHelper helper = new MimeMessageHelper(mimeMessage, true);
            helper.setFrom(from);
            helper.setTo(to);
            helper.setSubject(subject);
            helper.setText(content, true);
            mailSender.send(mimeMessage);
            logger.info("发送html邮件成功");
        } catch (MessagingException e) {
            logger.error("发送html邮件时发生异常",e);
        }
    }

    @Override
    public void sendAttachmentsMail(String to, String subject, String content, String filePath) {
        MimeMessage mimeMessage = mailSender.createMimeMessage();

        try {
            MimeMessageHelper helper = new MimeMessageHelper(mimeMessage, true);
            helper.setFrom(from);
            helper.setTo(to);
            helper.setSubject(subject);
            helper.setText(content,true);

            FileSystemResource file = new FileSystemResource(new File(filePath));
            String fileName = filePath.substring(filePath.lastIndexOf(File.separator));
            helper.addAttachment(fileName, file);

            mailSender.send(mimeMessage);
            logger.info("发送附件邮件成功");
        } catch (MessagingException e) {
            logger.error("发送附件邮件时发生异常", e);
        }

    }

    @Override
    public void sendInlineResourceMail(String to, String subject, String content, String srcPath, String srcId) {
        MimeMessage message = mailSender.createMimeMessage();

        try {
            MimeMessageHelper helper = new MimeMessageHelper(message,true);
            helper.setFrom(from);
            helper.setTo(to);
            helper.setSubject(subject);
            helper.setText(content, true);
            FileSystemResource res = new FileSystemResource(new File(srcPath));
            helper.addInline(srcId, res);

            mailSender.send(message);
            logger.info("发送静态资源的邮件成功");
        } catch (MessagingException e) {
            logger.error("发送静态资源的邮件时发生异常", e);
        }

    }
}
