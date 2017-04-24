package banco;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class ConFactory {

    private static String url;
    private static String schema;
    private static String senha;
    
    public static Connection getConexao() throws ClassNotFoundException, SQLException{
        
        url = "jdbc:oracle:thin:@localhost:1521:XE";
        schema = "aula";
        senha = "oracle";
        
        Connection conexao = null;
        
        Class.forName("oracle.jdbc.driver.OracleDriver");
        conexao = DriverManager.getConnection(url, schema, senha);
        
        return conexao;
    }
    
}