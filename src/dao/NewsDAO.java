package dao;





import java.sql.Connection;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Collections;
import java.util.Comparator;
import java.util.Date;
import java.util.HashSet;
import java.util.logging.Logger;



import util.ExcelLogger;
import java.util.ArrayList;
import java.sql.ResultSet;
import java.sql.Statement;
import java.time.LocalDate;
import java.sql.PreparedStatement;

import access.DataAccess;
import access.NewsAccess;
import access.StockAccess;

import java.util.Hashtable;


public class NewsDAO extends DAO{
	
	

	
	public NewsDAO( Connection mycon ){
		con=mycon;
		
	}
	 		
	public ArrayList <NewsAccess>   getAsxNewsByWishListAndDate(String date)throws Exception{
		ArrayList <NewsAccess> arr = new ArrayList();

		String mysql="select * from news where code in (SELECT SUBSTRING_INDEX(code, '.', 1) as mycode FROM fortune.stock where wishlist='Y') and date =?";
				

			 
		
		PreparedStatement ps = con.prepareStatement(mysql);
		ps.setString(1, date);
		
		ResultSet rs = ps.executeQuery();
		StockAccess stock=null ;
		DataAccess data =null;
		while(rs.next()){
			 arr.add(getNewsAccess( rs )); 
			 
	      }
		ps.close();	
		
	return arr;
	
	
	}
	private NewsAccess getNewsAccess(ResultSet rs )throws Exception{
		return 	new NewsAccess( rs.getString("code"),rs.getDate("date"), rs.getString("link"),rs.getString("title"),rs.getString("seen"),rs.getString("ok"),rs.getString("notes"),rs.getString("yes") ,rs.getString("yesNotes")); 
		
	}
	public ArrayList <NewsAccess>   getAsxNewsByWishListAndMonth(LocalDate date)throws Exception{
		ArrayList <NewsAccess> arr = new ArrayList<NewsAccess> ();

		String mysql="select * from news where code in (SELECT SUBSTRING_INDEX(code, '.', 1) as mycode FROM fortune.stock where wishlist='Y') and  month(date)=? and year(date)=?";
				
		
			 
		
		PreparedStatement ps = con.prepareStatement(mysql);
		ps.setInt(1, date.getMonthValue());
		ps.setInt(2, date.getYear()  );
		
		ResultSet rs = ps.executeQuery();
		
		while(rs.next()){
			 arr.add(getNewsAccess( rs )); 
			 
	      }
		ps.close();	
		
	return arr;
	
	
	}

	public ArrayList <NewsAccess>   searchNewsKeywordDate(String date , String keyword)throws Exception{
		ArrayList <NewsAccess> arr = new ArrayList<NewsAccess> ();

		String mysql="SELECT * FROM fortune.news where LOWER( title ) like ? and date=?";
				
		 
		System.out.println("searchNewsKeywordDate:");	 
		
		PreparedStatement ps = con.prepareStatement(mysql);
		ps.setString(1, "%"+ keyword.toLowerCase()+"%" );
		ps.setString(2, date);
		 
	System.out.println("searchNewsKeywordDate:"+ps);
		
		ResultSet rs = ps.executeQuery();
		
		while(rs.next()){
			 arr.add(getNewsAccess( rs )); 
			 
	      }
		System.out.println("searchNewsKeywordDate:"+arr.size());	
		ps.close();	
		
	return arr;
	
	
	}
	public ArrayList <NewsAccess>   searchNewsKeywordCustomDate(String date , String keyword)throws Exception{
		ArrayList <NewsAccess> arr = new ArrayList<NewsAccess> ();

		String mysql="SELECT * FROM fortune.news where LOWER( title ) like '%?%' and ";
				
		mysql=mysql+date;
			 
		
		PreparedStatement ps = con.prepareStatement(mysql);
		ps.setString(1, keyword.toLowerCase() );
		
	
		
		ResultSet rs = ps.executeQuery();
		
		while(rs.next()){
			 arr.add(getNewsAccess( rs )); 
			 
	      }
		ps.close();	
		
	return arr;
	
	
	}
	
	public ArrayList <NewsAccess>   searchNewsKeywordMonth(int month, String keyword)throws Exception{
		ArrayList <NewsAccess> arr = new ArrayList<NewsAccess> ();
		//System.out.println("searchNewsKeywordMonth sql: ");

		String mysql="SELECT * FROM fortune.news where LOWER( title ) like ? and month(date)=?";
				
		 
			 
		
		PreparedStatement ps = con.prepareStatement(mysql);
		ps.setString(1,"%"+keyword.toLowerCase() +"%");
		ps.setInt(2, month);
		
	//System.out.println("searchNewsKeywordMonth sql: "+ps);
		
		ResultSet rs = ps.executeQuery();
		
		while(rs.next()){
			 arr.add(getNewsAccess( rs )); 
			 
	      }
		ps.close();	
		
	return arr;
	
	
	}
	public ArrayList <NewsAccess>   searchNewsKeywordMonth(int month, ArrayList <String>  keyword)throws Exception{
		ArrayList <NewsAccess> arr = new ArrayList<NewsAccess> ();
		//System.out.println("searchNewsKeywordMonth sql: ");

		String mysql=" SELECT * FROM fortune.news where LOWER( title ) REGEXP ?  and month(date)=?"; 
				
		String search="";
		int x =0;
		for(String kwd : keyword){
			if(x==0)search=kwd.toLowerCase();
			else search=search+"|"+kwd.toLowerCase();
			x++;
		}
		
		PreparedStatement ps = con.prepareStatement(mysql);
ps.setString(1,search);
		ps.setInt(2, month);
		
	//System.out.println("searchNewsKeywordMonthMultiple sql: "+ps);
		
		ResultSet rs = ps.executeQuery();
		
		while(rs.next()){
			 arr.add(getNewsAccess( rs )); 
			 
	      }
		ps.close();	
		
	return arr;
	
	
	}
	
	public ArrayList <NewsAccess>   searchNewsKeywordDate(String date, ArrayList <String>  keyword)throws Exception{
		ArrayList <NewsAccess> arr = new ArrayList<NewsAccess> ();
		//System.out.println("searchNewsKeywordMonth sql: ");

		String mysql=" SELECT * FROM fortune.news where LOWER( title ) REGEXP ?  and date=?"; 
				
		String search="";
		int x =0;
		for(String kwd : keyword){
			if(x==0)search=kwd.toLowerCase();
			else search=search+"|"+kwd.toLowerCase();
			x++;
		}
		
		PreparedStatement ps = con.prepareStatement(mysql);
		ps.setString(1,search);
		ps.setString(2, date);
		
	//System.out.println("searchNewsKeywordDate sql: "+ps);
		
		ResultSet rs = ps.executeQuery();
		
		while(rs.next()){
			 arr.add(getNewsAccess( rs )); 
			 
	      }
		ps.close();	
		
	return arr;
	
	
	}
	
	
	public ArrayList <NewsAccess>   getAsxNewsByOkAndDate(String date)throws Exception{
		ArrayList <NewsAccess> arr = new ArrayList<NewsAccess>();
		String mysql="SELECT * FROM fortune.news where date=?  and ok='Y'";

			 
		
		PreparedStatement ps = con.prepareStatement(mysql);
		ps.setString(1, date);
		
		ResultSet rs = ps.executeQuery();
	
		while(rs.next()){
			 arr.add(getNewsAccess( rs )); 
			 
	      }
		ps.close();	
		
	return arr;
	
	
	}
	

	

	public ArrayList <NewsAccess>   getAsxNewsByOkAndMonth(LocalDate date)throws Exception{
		ArrayList <NewsAccess> arr = new ArrayList<NewsAccess>();
		String mysql="SELECT * FROM fortune.news where ok='Y'  and  month(date)=? and year(date)=?  ";

			 
		
		PreparedStatement ps = con.prepareStatement(mysql);
		ps.setInt(1, date.getMonthValue());
		ps.setInt(2, date.getYear()  );
		ResultSet rs = ps.executeQuery();
		
		while(rs.next()){
				 arr.add(getNewsAccess( rs )); 
			 
	      }
		ps.close();	
		
	return arr;
	
	
	}
	
	public ArrayList <NewsAccess>   getAsxNewsByYesAndMonth(LocalDate date)throws Exception{
		ArrayList <NewsAccess> arr = new ArrayList <NewsAccess> ();
	

		String mysql="SELECT * FROM fortune.news where yes='Y'  and  month(date)=? and year(date)=?  ";

		
		PreparedStatement ps = con.prepareStatement(mysql);
		ps.setInt(1, date.getMonthValue());
		ps.setInt(2, date.getYear()  );
		
		ResultSet rs = ps.executeQuery();
	
		while(rs.next()){
		
			 
			 arr.add(getNewsAccess( rs )); 
			 
	      }
		ps.close();	
		
	return arr;
	
	
	}

	public ArrayList <NewsAccess>   getAsxNewsByYesAndDate(String date)throws Exception{
		ArrayList <NewsAccess> arr = new ArrayList <NewsAccess> ();
		String mysql="SELECT * FROM fortune.news where date=?  and yes='Y'";

			 
		
		PreparedStatement ps = con.prepareStatement(mysql);
		ps.setString(1, date);
		
		ResultSet rs = ps.executeQuery();
		StockAccess stock=null ;
		DataAccess data =null;
		while(rs.next()){
			 arr.add(getNewsAccess( rs )); 
			 
	      }
		ps.close();	
		
	return arr;
	
	
	}

	
	public ArrayList <NewsAccess>   getAsxNewsByDate(String date)throws Exception{
		ArrayList <NewsAccess> arr = new ArrayList();
		String mysql="SELECT * FROM fortune.news where date=?";

			 
		
		PreparedStatement ps = con.prepareStatement(mysql);
		ps.setString(1, date);
		
		ResultSet rs = ps.executeQuery();
		StockAccess stock=null ;
		DataAccess data =null;
		while(rs.next()){
		
	 
			 arr.add(getNewsAccess( rs )); 
			 
	      }
		ps.close();	
		
	return arr;
	
	
	}
	/**
	 * This is because sometimes in ASX news one code can have multiple news items.
	 * @param date
	 * @return
	 * @throws Exception
	 */
	public ArrayList<NewsAccess> getAsxNewsUniqueByDate(String date) throws Exception {
		ArrayList<NewsAccess> arr = new ArrayList();
		Hashtable<String, NewsAccess> code = new Hashtable<String, NewsAccess>();
		String mysql = "SELECT * FROM fortune.news where date=? and seen=''";

		PreparedStatement ps = con.prepareStatement(mysql);
		ps.setString(1, date);

		ResultSet rs = ps.executeQuery();
		StockAccess stock = null;
		DataAccess data = null;
		while (rs.next()) {

			NewsAccess news =getNewsAccess( rs );

			if (code.containsKey(news.getCode())) {
				NewsAccess original = code.get(news.getCode());
				original.addNewsCollection(news);

			} else {
				code.put(news.getCode(), news);
				arr.add(news);

			}

		}
		ps.close();

		return arr;

	}
	

	public void updateNewsSeen(NewsAccess obj) throws Exception {

		String mysql = "UPDATE news SET seen=? WHERE code=? and date=? and title=?";

		PreparedStatement ps = con.prepareStatement(mysql);

		ps.setString(1, obj.getSeen());
		ps.setString(2, obj.getCode());
		ps.setString(3, obj.changeStringToDate());
		ps.setString(4, obj.getTitle() );

		System.out.println("updateNewsSeen SQL " + ps);
		ps.executeUpdate();

		ps.close();
	}
	


	public void updateNews(NewsAccess obj) throws Exception {

		String mysql = "UPDATE news SET seen=?,ok=?, notes=?, yes=?,yesNotes=?, seen=? WHERE code=? and date=? and title=?";

		PreparedStatement ps = con.prepareStatement(mysql);
	
		ps.setString(1, obj.getSeen());
		ps.setString(2, obj.getOk() );
	
		ps.setString(3, obj.getNotes());
		ps.setString(4, obj.getYes());
	
		ps.setString(5, obj.getYesNotes());
		ps.setString(6, obj.getSeen());
		
		ps.setString(7, obj.getCode());
	
		ps.setString(8, obj.changeStringToDate());
	

		ps.setString(9, obj.getTitle() );

		//System.out.println("updateNewsSeen SQL " + ps);
		ps.executeUpdate();

		ps.close();
	}
	


	public void insertNewNews(ArrayList<NewsAccess> arr) throws Exception {

		String mysql = "INSERT INTO news (code,date,link,title,seen,ok,notes,yes,yesNotes)VALUES(?,?,?,?,?,?,?,?,?)";
		System.out.println("insertNewNews : "  );
		PreparedStatement ps = con.prepareStatement(mysql);
		for (NewsAccess obj : arr) {

			ps.setString(1, obj.getCode());
			ps.setString(2, obj.changeStringToDate());

			ps.setString(3, obj.getLink());
			ps.setString(4, obj.getTitle());
			ps.setString(5, obj.getSeen());
			ps.setString(6, obj.getOk());

			ps.setString(7, obj.getNotes());
			ps.setString(8, obj.getYes());
			ps.setString(9, obj.getYesNotes());
			//System.out.println("insertNewNews : "+ ps);

			ps.addBatch();
		}

		ps.executeBatch();
		System.out.println("insertNewNews : finish "  );
		ps.close();

	}	
	

	

	

	
	



		public void updateStockCategory(StockAccess obj)throws Exception {
		
		
			
			String mysql="UPDATE stock SET category=?WHERE code=?";
			
		
			
			
			
			PreparedStatement ps =
			        con.prepareStatement(mysql);
			
			ps.setString(1, obj.getCategory());
			ps.setString(2, obj.getCode());
			System.out.println("StockDAO.java updateStockCategory "+mysql  );
			ps.executeUpdate();
			
			
			ps.close();	
		}
		public void updateStockSubCategory(StockAccess obj)throws Exception {
		
		
			
			String mysql="UPDATE stock SET subcategory=? WHERE code=?";
			
		
			
			
			
			PreparedStatement ps =
			        con.prepareStatement(mysql);
			
		
			ps.setString(1, obj.getSubcategory());
	
			ps.setString(2, obj.getCode());
			
			
			
		
			
			
			
			
			System.out.println("updateStockSubCategory SQL "+ps  );
			ps.executeUpdate();
			
			
			ps.close();	
		}
		
	
	
		
		/**
		 * Used at httpnow data . get and import data now, have to refresh , so got to delete data now , if not get primary key constraint
		 * @throws Exception
		 */
		public void deleteTodayDate()throws Exception {
			
			
			
			String mysql="delete from news where date=curdate()";
			
		
			
			
			
			PreparedStatement ps =
			        con.prepareStatement(mysql);
			System.out.println("deleteTodayDate SQL "+mysql  );
			ps.executeUpdate();
			
			
			ps.close();	
		}
		
	
	
	
	
	
}
