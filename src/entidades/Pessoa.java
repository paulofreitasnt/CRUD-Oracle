package entidades;

import java.sql.SQLData;
import java.sql.SQLException;
import java.sql.SQLInput;
import java.sql.SQLOutput;

public class Pessoa implements SQLData{

    private String nome;
    private int idade;

    // Obrigatório
    public Pessoa() { }
    
    public Pessoa(String nome, int idade){
        this.nome = nome;
        this.idade = idade;
    }

    public void setNome(String nome){
        this.nome = nome;
    }
    
    public String getNome() {
        return nome;
    }

    public int getIdade() {
        return idade;
    }
    
    public void setIdade(int idade){
        this.idade = idade;
    }

    @Override
    public String getSQLTypeName() throws SQLException {
        return "PESSOA";
    }

    @Override
    public void readSQL(SQLInput stream, String typeName) throws SQLException {
        nome = stream.readString();        
        idade = stream.readInt();
        
    }

    @Override
    public void writeSQL(SQLOutput stream) throws SQLException {
        stream.writeString(nome);
        stream.writeInt(idade);
    }
    
    @Override
    public String toString() {
        return "Pessoa{" + "nome=" + nome + ", idade=" + idade + '}';
    }
    
}
