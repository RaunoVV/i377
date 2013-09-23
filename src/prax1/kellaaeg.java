package prax1;

import java.awt.Color;
import java.awt.Font;
import java.awt.FontMetrics;
import java.awt.Graphics2D;
import java.awt.image.BufferedImage;
import java.io.IOException;
import java.io.OutputStream;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

import javax.imageio.ImageIO;
import javax.servlet.ServletException;
import javax.servlet.ServletOutputStream;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class kellaaeg
 */
public class kellaaeg extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//response.getWriter().println(getDateTime());
		
		try {
		      int width = 200, height = 200;

		      
		      BufferedImage bi = new BufferedImage(width, height, BufferedImage.TYPE_INT_ARGB);

		      Graphics2D ig2 = bi.createGraphics();


		      Font font = new Font("TimesRoman", Font.BOLD, 20);
		      ig2.setFont(font);
		      String message = getDateTime();
		      FontMetrics fontMetrics = ig2.getFontMetrics();
		      int stringWidth = fontMetrics.stringWidth(message);
		      int stringHeight = fontMetrics.getAscent();
		      ig2.setPaint(Color.black);
		      ig2.drawString(message, (width - stringWidth) / 2, height / 2 + stringHeight / 4);
		      
		      OutputStream out = response.getOutputStream();
		      response.setContentType("image/png");
		      ImageIO.write(bi, "PNG", out);
		      
		    } catch (IOException ie) {
		      ie.printStackTrace();
		    }

	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
	}
	
	private String getDateTime() {
        DateFormat dateFormat = new SimpleDateFormat("HH:mm:ss");
        Date date = new Date();
        return dateFormat.format(date);
    }

}
