package assignment2;

import java.sql.*;
public class assignmentTwo {
public static void main( String[] args ) {
	 Connection conn = null;
	 Statement stmt = null;
	 /***********************************************************************
	 * determine if the JDBC driver exists and load it...
	 ***********************************************************************/
	 System.out.print( "\nLoading JDBC driver...\n\n" );
	 try {
		 Class.forName("oracle.jdbc.OracleDriver");
	 }
	 catch(ClassNotFoundException e) {
		 System.out.println(e);
		 System.exit(1);
	 }
	 /***********************************************************************
	 * establish a connection to the database...
	 ***********************************************************************/
	 try {
		 System.out.print( "Connecting to ACADPRD0 database...\n\n" );
		 conn = DriverManager.getConnection("jdbc:oracle:thin:@acadoradbprd01.dpu.depaul.edu:1521:ACADPRD0", "KHE11", "cdm1886997");
		 System.out.println( "Connected to database ACADPRD0..." );
		 stmt = conn.createStatement();
	 	}
	 catch (SQLException se) {
		 System.out.println(se);
		 System.exit(1);
	 }
	
	 try {
	
	
	
	
		
		 ResultSet rsetTwo = stmt.executeQuery("select Count(distinct ProjectNo) as p,Count(distinct PartNo) as q " +
		 "From Shipments\r\n" 
		);
		 int value = 0;
		 while( rsetTwo.next() ) {
			 System.out.println( "ProjectNo cardinality : " + rsetTwo.getString("p"));
			 System.out.println("PartNo cardinality : " + rsetTwo.getString("q") );
			 value = Integer.parseInt(rsetTwo.getString("p"))*Integer.parseInt(rsetTwo.getString("q"));
			 
		 }
		 ResultSet rset = stmt.executeQuery("select count(ProjectNo) as m \r\n" + 
		 		"from (select distinct ProjectNo, PartNo\r\n" + 
		 		"from Shipments\r\n" + 
		 		"order by ProjectNo, PartNO)");
		 while( rset.next() ) {
			 System.out.println( "Combined cardinality: " + rset.getString("m"));
			 System.out.println("Maximum cardinality: " + value);
			 
		 }

		 rset.close();
		 rsetTwo.close();
		 stmt.close();
		 conn.close();
		
		 }
	 catch (SQLException se) {
		 System.out.println( "SQL ERROR: " + se );
	 }
	 } // end main
}