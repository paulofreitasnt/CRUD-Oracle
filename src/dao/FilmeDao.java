package dao;

import banco.ConFactory;
import entidades.Diretor;
import entidades.Filme;
import entidades.Telefone;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class FilmeDao{

    private Connection con;
    
    public FilmeDao() throws ClassNotFoundException, SQLException{
    
        con = ConFactory.getConexao();
    
        try{
            Map map = con.getTypeMap();
            map.put("FILME", Filme.class);
            map.put("DIRETOR", Diretor.class);
            map.put("TELEFONE", Telefone.class);
            con.setTypeMap(map);
        }catch(Exception e){
            e.printStackTrace();
        }
        
    }    
    
    public List <Filme> list() throws SQLException{
                
        List <Filme> filmes = new ArrayList<>();
        
        PreparedStatement stmt = con.prepareStatement(
            "SELECT VALUE(p) FROM filmes p");
        ResultSet rs = stmt.executeQuery();
            
        while(rs.next()){
            Filme a = (Filme) rs.getObject(1);
            filmes.add(a);
        }
        
        return filmes;
    
    }
    
    public boolean create(Filme f) throws SQLException{

        PreparedStatement stmt = con.prepareStatement(
            "INSERT INTO filmes VALUES (?)");
        stmt.setObject(1, f);
        return stmt.executeUpdate()>0;
        
    }
    
    public boolean delete(Filme f) throws SQLException{
        
        PreparedStatement stmt = con.prepareStatement("DELETE FROM filmes"
                + "WHERE titulo LIKE ?");
        stmt.setString(1, f.getTitulo());
        return stmt.executeUpdate()>0;
        
    }

    public boolean update(String titulo, double nValor) throws SQLException {
        
        PreparedStatement stmt = con.prepareStatement("UPDATE filmes"
                + "SET valor = ? WHERE titulo LIKE ?");
        stmt.setDouble(1, nValor);
        stmt.setString(2, titulo);
        return stmt.executeUpdate()>0;
    }
    
    public void disconnect() throws SQLException {
        con.close();
    }
}
