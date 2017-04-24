package dao;

import banco.ConFactory;
import entidades.Pessoa;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class PessoaDao{

    private Connection con;
    
    public PessoaDao() throws ClassNotFoundException, SQLException{
    
        con = ConFactory.getConexao();
    
        try{
            Map map = con.getTypeMap();
            map.put("PESSOA", Pessoa.class);
            con.setTypeMap(map);
        }catch(SQLException e){
            e.printStackTrace();
        }
        
    }    
    
    public List<Pessoa> list() throws SQLException{
        
        List <Pessoa> pessoas = new ArrayList<>();
        
        PreparedStatement stmt = con.prepareStatement(
                "SELECT VALUE(p) FROM pessoas p");
        ResultSet rs = stmt.executeQuery();
       
        while(rs.next()){
            Pessoa a = (Pessoa) rs.getObject(1);
            pessoas.add(a);
        }
        
        return pessoas;
    }  
    
    public boolean create(Pessoa p) throws SQLException{
        
        PreparedStatement stmt = con.prepareStatement(
                "INSERT INTO pessoas VALUES (?)");
        stmt.setObject(1, p);
        return stmt.executeUpdate()>0;
        
    }
    
    public boolean delete(Pessoa p) throws SQLException{
        
        PreparedStatement stmt = con.prepareStatement(
                "DELETE FROM pessoas WHERE nome LIKE ?");
        stmt.setString(1, p.getNome());
        return stmt.executeUpdate()>0;
        
    }

    public Pessoa find(String nome) throws SQLException{
        
        Pessoa a = null;
        PreparedStatement stmt = con.prepareStatement(
            "SELECT value(p) FROM pessoas p WHERE nome LIKE ?");
        stmt.setString(1, nome);
        ResultSet rs = stmt.executeQuery();
        if(rs.next()) a = (Pessoa)rs.getObject(1);
        return a;
        
    }

    public boolean update(Pessoa p) throws SQLException{
        PreparedStatement stmt = con.prepareStatement(
                "UPDATE pessoas SET idade = ?"
                        + " WHERE nome LIKE ?");
        stmt.setInt(1, p.getIdade());
        stmt.setString(2, p.getNome());
        return stmt.executeUpdate()>0;
    } 
    
    public void disconnect() throws SQLException {
        con.close();
    }
    
}