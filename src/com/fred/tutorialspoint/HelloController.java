package com.fred.tutorialspoint;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * http://localhost:8081/HelloWeb/helloworld
 * @author Thinkpad
 *
 */
@Controller
public class HelloController {
	
    /**
     * 1. ʹ��RequestMappingע����ӳ�������URL
     * 2. ����ֵ��ͨ����ͼ����������Ϊʵ�ʵ�������ͼ, ����InternalResourceViewResolver��ͼ���������������½���
     * ͨ��prefix+returnVal+suffix �����ķ�ʽ�õ�ʵ�ʵ�������ͼ��Ȼ���ת������
     * "/WEB-INF/views/success.jsp"
     * @return
     */
    @RequestMapping("/helloworld")
    public String hello(){
        System.out.println("hello world");
        
        HelloService service = new HelloService();
        if (service.getAll() == null) {
        	return "error";
        }
        
        return "success";
    }
    
}
