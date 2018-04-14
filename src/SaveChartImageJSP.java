
import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Hashtable;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import access.StockAccess;

public class SaveChartImageJSP  extends HttpServlet{
	int mycount =0;
	Hashtable  <String ,StockAccess>  arr ;

	public void init() throws ServletException	  {
		  
	  }
	
	
	
	
	/**
	 * direct to 3 pages, 
	 * 1. Input page , which then directs 
	 * 	2. Technical page
	 *  3. Fundamental page.
	 */
	
	public void doGet(HttpServletRequest request,
	          HttpServletResponse response)
	  throws ServletException, IOException
		{
			System.out.println("Do GET SaveChartImageJSP");
			
			
			String nextJSP = "/testsk.jsp";
			
		
			
		
		
		
			
			
			 RequestDispatcher dispatcher = getServletContext().getRequestDispatcher(nextJSP);
				dispatcher.forward(request,response);
		
			
			
	}
	
	
	public void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		System.out.println("Do POST  SaveChartImageJSP");
		String code = request.getParameter("myHiddenField");


		System.out.println(code);

		BufferedWriter bw = null;
		FileWriter fw = null;
		try {
			fw = new FileWriter("D:\\filename.txt");
			bw = new BufferedWriter(fw);
			bw.write(code);
		} catch (Exception e) {
			System.out.println("Do POST  SaveChartImageJSP EERROR:"+e);
		}finally {

			try {

				if (bw != null)
					bw.close();

				if (fw != null)
					fw.close();

			} catch (IOException ex) {

				ex.printStackTrace();

			}

		}
		
		
		
		
		
		
		doGet(request, response);

	}
	
	
}
