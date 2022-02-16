import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;

public class cinema {
	
	public static void connection() {
		 Connection conn =null; 
		try { 
			 String url = "jdbc:sqlite:C:/sqlite/Cinema.db";
		        // create a connection to the database  
		            conn = DriverManager.getConnection(url); 
	   	        System.out.println("Created database and established sqlite connection");  

	        }catch(SQLException e) {
	        	System.out.println(e.getMessage());
	        }finally {  
	            try {  
					if (conn != null) {  
	                    conn.close();
	                }  
	            } catch (SQLException ex) {  
	                System.out.println(ex.getMessage());  
	            }  
	        }
	}
	        
	      public static void createTable() {
	    	 
	    	  String url = "jdbc:sqlite:C:/sqlite/Cinema.db";
	    	  
	    	  
	    	  // SQL statement for creating a new table  
		        String sql = "CREATE TABLE IF NOT EXISTS Movies(\n"    
		                 +"name String,\n" 
		                 +" actor String,\n" 
		                 +" actress String,\n" 
		                 +"director String,\n" 
		                 +"yearOfRelease integer\n"
		                 +");"; 
	    	  
	    	  try
	      { 
	    	Connection conn = DriverManager.getConnection(url);   
	    	 System.out.println("Opened database successfully");
				 Statement stmt = conn.createStatement();  
				 stmt.execute(sql); 
	        } catch (SQLException e) {  
	            System.out.println(e.getMessage());
	        } 
	      System.out.println("Table Created Successfully");
	      }
	 public static void insert(String name,String actor,String actress,String director,Integer yearOfRelease) {
		 String url = "jdbc:sqlite:C:/sqlite/Cinema.db";
		   
		 try {  
			 String sql="INSERT INTO Movies(name, actor, actress, director, yearOfRelease) VALUES(?,?,?,?,?)";
			 Connection	conn = DriverManager.getConnection(url);
			 PreparedStatement pstmt=conn.prepareStatement(sql);
			 
			 pstmt.setString(1, name);
			 pstmt.setString(2, actor);
			 pstmt.setString(3, actress);
			 pstmt.setString(4, director);
			 pstmt.setInt(5, yearOfRelease);
			 pstmt.executeUpdate();		        
		         } catch ( Exception ex ) {
		        	 System.err.println("got an exeception!");
	         System.err.println(ex.getMessage());
	      }
	 
	      System.out.println("Records created successfully");
	 }
	 public static void select() {
	      try
	      {
	    	   
	    	  String url = "jdbc:sqlite:C:/sqlite/Cinema.db"; 
	         Connection conn = DriverManager.getConnection(url); 
	          String sql1="SELECT name,actor,actress,director,yearOfRelease FROM Movies";
	    	  Statement stmt2=conn.createStatement();
			ResultSet rs=stmt2.executeQuery(sql1);
			 System.out.println("name|actor|actress|director|yearOfRelease");

	    	  while(rs.next()) {
	    		  String name = rs.getString("name");
	    		  String actor =  rs.getString("actor");
	    		  String actress = rs.getString("actress");
	    		  String director = rs.getString("director");
	    		  Integer yearOfRelease = rs.getInt("yearOfRelease");
	    		  System.out.println(name+"|"+actor+ "|" +actress+ "|" +director+ "|" +yearOfRelease);
	    	  }
}catch(SQLException e) {
	System.out.println(e.getMessage());
}
	      System.out.println("Operation done successfully");
	      }
	      
	      public static void main(String[] args) throws SQLException { 
	    	  connection();
	  		  createTable();
	  		  insert("Dharma Durai", "Vijay Sethupathi", "Tamannaah", "Seenu Ramasamy", 2016);
	  		  insert("Kaavalan", "vijay", "Asin", "Siddique", 2011);
	  		  insert("Live Telecast", "Vaibhav", "Kajal Aggarwal", "Venkat Prabhu", 2021);
	  		  insert("Thambi", "Madhavan", "Pooja", "Seeman", 2006);
	  		  insert("Pattas", "Dhanush", " Sneha", "R. S. Durai Senthilkumar", 2020);
	  		  insert("FIR", "Vishnu Vishal", "Reba Monica John", "Manu Anand", 2022);
	  		  insert("Thendral", "Parthiban", "Uma", "Thangar Bachan", 2021);
	  		  insert("Mayanginen Thayanginen", "Nithin Sathya", "Disha Pandey", "Vendhan", 2012);
	  		  insert("K3", "Sudeep", "Madonna Sebastian", "Shiva Karthik", 2022);
	  		  insert("Bheemaa", "Vikram", " Trisha Krishnan", "N. Linguswamy", 2008);
	  		  select();
	 }
	        
	        }  
  

