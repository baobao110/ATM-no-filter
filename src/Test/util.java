package Test;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.OutputStream;
import java.io.OutputStreamWriter;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.junit.runner.Request;

import org.apache.commons.fileupload.FileItem;
import org.apache.commons.fileupload.disk.DiskFileItemFactory;
import org.apache.commons.fileupload.servlet.ServletFileUpload;

import AccountFlow.Account;
import BankCard.Card;
import fenye.Fenye;
import handler.Handler;
import inter.CardDAO;
import service.CardService;
import service.Service;
import service.UserService;
import user.User;

public class util extends HttpServlet {
	
	@Override
	public void init(ServletConfig config) throws ServletException {
		// TODO Auto-generated method stub
		Handler.init(config.getServletContext().getRealPath("/"));
		/*
		 * 这里的ServletConfig config 的两个方法
		 * config.getServletContext().getRealPath("/")该项目的根路径即app
		 * config.getInitParameter("pack")获取web.xml中的init paramater的"pack"对应的值
		 */
	}

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doPost(req, resp);
	}

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		// TODO Auto-generated method stub
		String msg=req.getRequestURI();//获取url地址，这里的方法非常巧妙
		System.out.println(msg);
		if(msg==null) {
			req.getRequestDispatcher("/WEB-INF/pag/failure.jsp");
		}
		String[]result=msg.split("\\/");
		msg=result[result.length-1];
		System.out.println(msg);
		String parent=result[result.length-2];
		System.out.println(parent);
		if(parent==null) {
			req.getRequestDispatcher("/WEB-INF/pag/failure.jsp");
		}
		result=msg.split("\\.");//这里要特别注意分割的方法
		String method=result[0];
		System.out.println(method);
		if(method==null) {
			req.getRequestDispatcher("/WEB-INF/pag/failure.jsp");
		}
		Object object=Handler.getControl(parent);
		System.out.println(object);
		try {
			System.out.println(object.getClass());
			Method action=object.getClass().getMethod(method,HttpServletRequest.class,HttpServletResponse.class );//这里查看API的Class和Method
			System.out.println(action);
			String url=(String)action.invoke(object,req,resp);
			if(url!=null) {
				url="/WEB-INF/pag/"+url+".jsp";
				req.getRequestDispatcher(url).forward(req, resp);
			}
			else {
				req.getRequestDispatcher("/WEB-INF/pag/failure.jsp").forward(req, resp);;
			}
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
}
	
