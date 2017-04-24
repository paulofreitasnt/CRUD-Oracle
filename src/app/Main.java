package app;

import dao.FilmeDao;
import java.sql.SQLException;

public class Main {

    public static void main(String[] args){
        
        FilmeDao dao = null;
        
        try{
            dao = new FilmeDao();
            
            System.out.println(dao.list());
            
            dao.disconnect();
            
        } catch (ClassNotFoundException ex) {
            ex.printStackTrace();
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
        
    }
    
}
