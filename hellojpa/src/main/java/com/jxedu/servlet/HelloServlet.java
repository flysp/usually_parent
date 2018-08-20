package com.jxedu.servlet;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.annotation.MultipartConfig;
import javax.servlet.annotation.WebInitParam;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet(name = "/helloServlt", value = "/helloServlet",initParams = {@WebInitParam(name = "par",value = "初始化值 1")})
@MultipartConfig(maxFileSize =2097152,maxRequestSize = 4194304)
public class HelloServlet  extends HttpServlet {

   private  static final   Logger logger = LoggerFactory.getLogger(HelloServlet.class);

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        String name = req.getParameter("name");
        logger.info("请求name的值:{}",name);

        ServletConfig servletConfig = this.getServletConfig();
         // String par =this.getInitParameter("par");
        logger.info("初始化的值:{}",servletConfig.getInitParameter("par"));

        req.setAttribute("address","佛山");
        req.removeAttribute("address");
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
      doGet(req,resp);
    }
}
