package connexion;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class Connexion {
      static final String url="jdbc:mysql://localhost:3306/gestionreservations";
      static final String user="root";
      static final String password="";
      static Connection cnx = null;
      
      static {
      try {
  		Class.forName("com.mysql.cj.jdbc.Driver");
  	   cnx=DriverManager.getConnection(url,user,password);
  	   System.out.println("connected succesfully");
  	}
  	catch(SQLException e) {
  		System.out.println("Erreur de la connexion à la BD");
  	}
  	catch(ClassNotFoundException e){
  		System.out.println("Failed");
  	}
      }
      
      public static Connection getcnx() {
    	  return cnx;
      }

    
}
