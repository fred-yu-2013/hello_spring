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
     * 1. 使用RequestMapping注解来映射请求的URL
     * 2. 返回值会通过视图解析器解析为实际的物理视图, 对于InternalResourceViewResolver视图解析器，会做如下解析
     * 通过prefix+returnVal+suffix 这样的方式得到实际的物理视图，然后会转发操作
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
