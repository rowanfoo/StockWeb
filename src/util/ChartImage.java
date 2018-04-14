package util;



import java.awt.image.BufferedImage;
import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.IOException;
import java.net.URL;
import java.net.URLEncoder;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.regex.Pattern;

import javax.imageio.ImageIO;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

import com.sun.org.apache.xerces.internal.impl.dv.util.Base64;
/**
 * import ASX news from ASX website
 * @author rowan
 *
 */
public class ChartImage {

	public static String preurl="http://bigcharts.marketwatch.com/advchart/frames/frames.asp?show=&insttype=Stock&symb=au%3A";	
	public static String year5="&x=63&y=15&time=12&startdate=1%2F4%2F1999&enddate=11%2F24%2F2016&freq=3&compidx=aaaaa%3A0&comptemptext=&comp=none&ma=3&maval=10&uf=0&lf=268435456&lf2=2&lf3=0&type=1&style=320&size=4&timeFrameToggle=false&compareToToggle=false&indicatorsToggle=false&chartStyleToggle=false&state=11";
	public static String year3="&x=55&y=4&time=10&startdate=1%2F4%2F1999&enddate=11%2F24%2F2016&freq=2&compidx=aaaaa%3A0&comptemptext=&comp=none&ma=3&maval=15&uf=0&lf=268435456&lf2=2&lf3=0&type=1&style=320&size=4&timeFrameToggle=false&compareToToggle=false&indicatorsToggle=false&chartStyleToggle=false&state=11";
	public static String year1="&x=51&y=9&time=8&startdate=1%2F4%2F1999&enddate=11%2F24%2F2016&freq=1&compidx=aaaaa%3A0&comptemptext=&comp=none&ma=3&maval=50&uf=0&lf=268435456&lf2=2&lf3=0&type=1&style=320&size=4&timeFrameToggle=false&compareToToggle=false&indicatorsToggle=false&chartStyleToggle=false&state=11";
	public static String yearhalf="&x=58&y=14&time=7&startdate=1%2F4%2F1999&enddate=11%2F24%2F2016&freq=1&compidx=aaaaa%3A0&comptemptext=&comp=none&ma=3&maval=20&uf=0&lf=268435456&lf2=2&lf3=0&type=1&style=320&size=4&timeFrameToggle=false&compareToToggle=false&indicatorsToggle=false&chartStyleToggle=false&state=11";
	public static String year10="&x=68&y=14&time=13&startdate=1%2F4%2F1999&enddate=11%2F24%2F2016&freq=3&compidx=aaaaa%3A0&comptemptext=&comp=none&ma=3&maval=10&uf=0&lf=268435456&lf2=2&lf3=0&type=1&style=320&size=4&timeFrameToggle=false&compareToToggle=false&indicatorsToggle=false&chartStyleToggle=false&state=11";
	
	
	
	
	public static ArrayList<String> chartImage( String code,String category )throws Exception{
		System.out.println("chartImage");
		System.out.println("chartImage code "+code);
	
	String href = "<a href=\"Research/getCharts?code="+code+".AX" ;
	String mode = "&mode=";
	String ccategory = "&category="+URLEncoder.encode(category,"UTF-8");
	
	
	String[] link ={year10,year5,year3,year1,yearhalf};
	//String[] link ={year10};
	//String[] link ={sixMonth,year,week,month};
	//String[] link ={sixMonth};
	ArrayList<String> ls = new ArrayList<String>(Arrays.asList(link) );
	

	
	ArrayList<String> image = new ArrayList<String> ();
	int x=0;
	for(String urls : ls){
		String url =preurl+code+urls;
		String imagetag=getImageTag( url );
		String imagedata = getImage(imagetag);
		//image.add("<img alt=\"Embedded Image\" "+ getImage(imagetag)+"'> ");
//		image.add(href+mode+x+"&image="+ imagedata+"\">"+   "<img alt=\"Embedded Image\" "+ imagedata+"'> </a>");
		image.add(href+mode+x+ccategory+"\">"+   "<img alt=\"Embedded Image\" src=\""+ imagedata+"\"> </a>");
		x++;
	}
	//System.out.println("OK");

	return image;
//	Document doc = Jsoup.connect(url).get();

	  
	
	}	
	public static String getImageTag(String url )throws Exception{
	//	System.out.println("getImageTag :" +url);
		Document doc = Jsoup.connect(url).get();
		
		Elements img = doc.select("img");

		
		for (Element tb : img) {
			String t = tb.attr("src");
			
			String pattern = ".*nosettings?.*";
			if (Pattern.matches(pattern, t)) {
		//		 System.out.println("CORRECT TABLE"+t);

				 return t;
				
				
			}
				 
				 
				 
			
		}
		//System.out.println("getImageTag  done :" );
		 return "";
	     
		
	}
	
	
	public static String getImage(String url )throws Exception{
		//System.out.println("getImage :" +url);
	     BufferedImage  image = image = ImageIO.read( new URL(url));
	     ByteArrayOutputStream baos = new ByteArrayOutputStream();
	     ImageIO.write(image, "png", baos);
	     return "data:image/png;base64,"+ Base64.encode(baos.toByteArray());
	     
		
	}
	
	
	
	public void run(){
		String url = "http://bigcharts.marketwatch.com/advchart/frames/frames.asp?show=&insttype=&symb=au%3Ahgg&x=0&y=0&time=7&startdate=1%2F4%2F1999&enddate=11%2F24%2F2016&freq=1&compidx=aaaaa%3A0&comptemptext=&comp=none&ma=1&maval=20&uf=0&lf=268435456&lf2=2&lf3=0&type=1&style=320&size=4&timeFrameToggle=false&compareToToggle=false&indicatorsToggle=false&chartStyleToggle=false&state=11";
		System.out.println("RUNB");

		try {
			int count = 0;
			Document doc = Jsoup.connect(url).get();

			Elements img = doc.select("img");

			
			for (Element tb : img) {
				String t = tb.attr("src");
				String pattern = ".*nosettings?.*";
				// boolean matches = Pattern.matches(pattern, t)
			

			//	System.out.println(" TABLE:" + t);
				if (Pattern.matches(pattern, t)) {
					 System.out.println("CORRECT TABLE"+t);

					 
					 BufferedImage  image = null;
					
					 try {
						 System.out.println("image t:"+t);
					     URL urli = new URL(t);
					     image = ImageIO.read(urli);
					     
					     ImageIO.write(image,"jpg",new File("d:\\test.gif"));
					     
					 } catch (IOException e) {
						 System.out.println("error immage. "+e);
					 }
					 
					 
					 
				
			}
			

			
			System.out.println("FINISH ");

		} 
		}catch (Exception e) {
			System.out.println("Error:" + e);

		}
	
	}
	
	
	
	public static void main(String[] args) {

		
		/*		
				   //get current date time with Date()
		Date mydate= new Date();
		Calendar cal = Calendar.getInstance();
		cal.setTime(mydate);
		int month = cal.get(Calendar.YEAR);	 
		System.out.println("yr"+month);		   
			    
		System.out.println("yr"+(month-1));		    
			*/  
		new ChartImage().run();
			    
		
			        	
	
			
			
			  }
		
		
		

	

}
