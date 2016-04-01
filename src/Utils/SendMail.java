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
 * @Description:  һ�仰��������Ĺ���  
 * @Author:       Administrator
 * @CreateDate:   2016��2��23�� ����4:35:14
 * @UpdateUser:   Administrator
 * @UpdateDate:   2016��2��23�� ����4:35:14 
 * @UpdateRemark: ˵�������޸�����  
 * @Version:      v1.0
 *    
 */
public class SendMail {
    private static String host = "smtp.mxhichina.com"; // smtp������  
    private static String user = "chiweisong@smartpos.top"; // �û���  
    private static String pwd = "cws0705%"; // ����  
    private static String from = "chiweisong@smartpos.top"; // �����˵�ַ  
    private static String to = "chiweisong@smartpos.top"; // �ռ��˵�ַ 
    private static String subject = "���ʼ�����"; // �ʼ�����  
  
public static void send() {  
     Properties props = new Properties();  
     // ���÷����ʼ����ʼ������������ԣ�����ʹ�����׵�smtp��������  
     props.put("mail.smtp.host", host);  
     // ��Ҫ������Ȩ��Ҳ�����л����������У�飬��������ͨ����֤��һ��Ҫ����һ����  
     props.put("mail.smtp.auth", "true");  
     // �øո����úõ�props���󹹽�һ��session  
     Session session = Session.getDefaultInstance(props);  
     // ������������ڷ����ʼ��Ĺ�������console����ʾ������Ϣ��������ʹ  
     // �ã�������ڿ���̨��console)�Ͽ��������ʼ��Ĺ��̣�  
     session.setDebug(false);  
     // ��sessionΪ����������Ϣ����  
     MimeMessage message = new MimeMessage(session);  
     try {  
      // ���ط����˵�ַ  
      message.setFrom(new InternetAddress(from));  
      // �����ռ��˵�ַ  
      message.addRecipient(Message.RecipientType.TO, new InternetAddress(to));  
      // ���ر���  
      message.setSubject(subject);  
      // ��multipart����������ʼ��ĸ����������ݣ������ı����ݺ͸���  
      Multipart multipart = new MimeMultipart();  
  
      // �����ʼ����ı�����  
//      BodyPart contentPart = new MimeBodyPart();  
//      contentPart.setText(txt); 
//      multipart.addBodyPart(contentPart);  

      // ��Ӹ���  
      BodyPart messageBodyPart = new MimeBodyPart();
      String filename="E://Users//Administrator//workspace//APITest//test-output//emailable-report.html";
      DataSource source = new FileDataSource(filename);

       //��Ӹ���������  
      DataHandler datahandler=new DataHandler(source);
      messageBodyPart.setDataHandler(datahandler);
      messageBodyPart.setFileName(filename);
      multipart.addBodyPart(messageBodyPart);  
        
      // ��multipart����ŵ�message��  
      message.setContent(multipart);  
      // �����ʼ�  
      message.saveChanges();  
      // �����ʼ�  
      Transport transport = session.getTransport("smtp");  
      // ���ӷ�����������  
      transport.connect(host, user, pwd);  
      // ���ʼ����ͳ�ȥ  
      transport.sendMessage(message, message.getAllRecipients());  
      transport.close();  
     } catch (Exception e) {  
      e.printStackTrace();  
     }  
    } 
}
