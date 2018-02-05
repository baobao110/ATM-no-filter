package Test;

import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.Map;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.codec.cli.Digest;
import org.apache.commons.codec.digest.DigestUtils;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

import AccountFlow.Account;
import BankCard.Card;
import base.DataBase;
import inter.AccountDAO;
import inter.CardDAO;
import service.Service;

public class Test extends HttpServlet{
	
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException{
		req.getRequestDispatcher("/user/toLogin.do");
	}
	
}

	
/*
 * Mybaties的最后Test语句程序比较固定,具体的格式要求见Mybaties。text文件中的中文文档
 */
