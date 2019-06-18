package com.lti.servlet;

import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.image.BufferedImage;
import java.io.IOException;

import javax.imageio.ImageIO;
import javax.servlet.ServletException;
import javax.servlet.ServletOutputStream;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class CaptchaServlet
 */ 
@WebServlet("/Capt%20chan.jpeg")
public class CaptchaServlet extends HttpServlet {

       
    
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.setContentType("image/jpeg");
		ServletOutputStream out= response.getOutputStream();
		String str="qwertyuiopasdfghjklzxcvbnmQWERTYUIOPASDFGHJKLZXCVBNM1234567890";
		StringBuffer captcha=new StringBuffer();
		String[] fnt= {"Arial","Monotype Corsiva","Harrington","Bradley Hand","Chalkduster","Times New Roman","Impact","Comic Sans"};
		int z;
		
		BufferedImage img=new BufferedImage(150, 70, BufferedImage.TYPE_INT_RGB);
		Graphics g=img.getGraphics();
		//g.setColor(Color.RED);
		g.fillRect(0, 0, 150, 50);	
		
		for(int i=0;i<6;i++)
		{	g.setColor(new Color((int)(Math.random()*256*256*256)));
			g.setFont(new Font(fnt[(int)(Math.random()*fnt.length)],Font.BOLD,30));
			z=(int)(Math.floor((Math.random()*str.length())));
		g.drawString(String.valueOf(str.charAt(z)),30+i*20,(int)(30+Math.random()*10));
		}
		ImageIO.write(img, "jpg", out);
		
		
	}
	
}
