package Utils;

import java.util.Properties;

import javax.activation.DataHandler;
import javax.activation.DataSource;
import javax.activation.FileDataSource;
import javax.mail.BodyPart;
import javax.mail.Message;
import javax.mail.Multipart;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeBodyPart;
import javax.mail.internet.MimeMessage;
import javax.mail.internet.MimeMultipart;

/**   
 *  
 * Simple to Introduction  
 * @ProjectName:  APITest
 * @Package:      Utils.SendMail.java
 * @ClassName:    SendMail
 * @Description:  一句话描述该类的功能  
 * @Author:       Administrator
 * @CreateDate:   2016年2月23日 下午4:35:14
 * @UpdateUser:   Administrator
 * @UpdateDate:   2016年2月23日 下午4:35:14 
 * @UpdateRemark: 说明本次修改内容  
 * @Version:      v1.0
 *    
 */
public class SendMail {
    private static String host = "smtp.mxhichina.com"; // smtp服务器  
    private static String user = "chiweisong@smartpos.top"; // 用户名  
    private static String pwd = "cws0705%"; // 密码  
    private static String from = "chiweisong@smartpos.top"; // 发件人地址  
    private static String to = "chiweisong@smartpos.top"; // 收件人地址 
    private static String subject = "发邮件测试"; // 邮件标题  
  
public static void send() {  
     Properties props = new Properties();  
     // 设置发送邮件的邮件服务器的属性（这里使用网易的smtp服务器）  
     props.put("mail.smtp.host", host);  
     // 需要经过授权，也就是有户名和密码的校验，这样才能通过验证（一定要有这一条）  
     props.put("mail.smtp.auth", "true");  
     // 用刚刚设置好的props对象构建一个session  
     Session session = Session.getDefaultInstance(props);  
     // 有了这句便可以在发送邮件的过程中在console处显示过程信息，供调试使  
     // 用（你可以在控制台（console)上看到发送邮件的过程）  
     session.setDebug(false);  
     // 用session为参数定义消息对象  
     MimeMessage message = new MimeMessage(session);  
     try {  
      // 加载发件人地址  
      message.setFrom(new InternetAddress(from));  
      // 加载收件人地址  
      message.addRecipient(Message.RecipientType.TO, new InternetAddress(to));  
      // 加载标题  
      message.setSubject(subject);  
      // 向multipart对象中添加邮件的各个部分内容，包括文本内容和附件  
      Multipart multipart = new MimeMultipart();  
  
      // 设置邮件的文本内容  
//      BodyPart contentPart = new MimeBodyPart();  
//      contentPart.setText(txt); 
//      multipart.addBodyPart(contentPart);  

      // 添加附件  
      BodyPart messageBodyPart = new MimeBodyPart();
      String filename="E://Users//Administrator//workspace//APITest//test-output//emailable-report.html";
      DataSource source = new FileDataSource(filename);

       //添加附件的内容  
      DataHandler datahandler=new DataHandler(source);
      messageBodyPart.setDataHandler(datahandler);
      messageBodyPart.setFileName(filename);
      multipart.addBodyPart(messageBodyPart);  
        
      // 将multipart对象放到message中  
      message.setContent(multipart);  
      // 保存邮件  
      message.saveChanges();  
      // 发送邮件  
      Transport transport = session.getTransport("smtp");  
      // 连接服务器的邮箱  
      transport.connect(host, user, pwd);  
      // 把邮件发送出去  
      transport.sendMessage(message, message.getAllRecipients());  
      transport.close();  
     } catch (Exception e) {  
      e.printStackTrace();  
     }  
    } 
}
