package br.com.tebd.atena.persistence.mysql;
import java.sql.*;

public class Conexao {
	private Connection con;
    private Statement stm;

   public void conectar(){
       try{
        // registro do driver JDBC pelo MySql
        Class.forName("com.mysql.jdbc.Driver").newInstance();

        // abrindo a conexao
        //url, user e password
        String connectionURL = "jdbc:mysql://localhost:3306/atena?autoReconnect=true&useSSL=false";
        con = DriverManager.getConnection(connectionURL,"default","default");
        stm = con.createStatement();

      }
       catch(SQLException e){
           System.out.println(e.getMessage());
       }
       catch(ClassNotFoundException c){
           System.out.println(c.getMessage());
       }
        catch(InstantiationException i){
            System.out.println(i.getMessage());
       }
        catch(IllegalAccessException il){
            System.out.println(il.getMessage());
       }
   }
   
   public int processaInclusao(String sql){
        try{
        return stm.executeUpdate(sql);
        }
        catch (SQLException e){
            return -1;
        }
   }

   public ResultSet processaConsulta(String sql){
       try{
         // executa um comando select e recebe o retorno no resultset
         return stm.executeQuery(sql);

        }
        catch (SQLException e){
           return null;
        }
   }
}
