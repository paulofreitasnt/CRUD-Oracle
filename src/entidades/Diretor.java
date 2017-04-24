package entidades;

import java.sql.SQLData;
import java.sql.SQLException;
import java.sql.SQLInput;
import java.sql.SQLOutput;

public class Diretor implements SQLData {

    private String nome;
    private Telefone fone;
    
    public Diretor(){ }

    public Diretor(String nome, Telefone fone) {
        this.nome = nome;
        this.fone = fone;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public Telefone getFone() {
        return fone;
    }

    public void setFone(Telefone fone) {
        this.fone = fone;
    }

    @Override
    public String getSQLTypeName() throws SQLException {
        return "DIRETOR";
    }

    @Override
    public void readSQL(SQLInput stream, String typeName) throws SQLException {
        nome = stream.readString();
        fone = (Telefone) stream.readObject();
    }

    @Override
    public void writeSQL(SQLOutput stream) throws SQLException {
        stream.writeString(nome);
        stream.writeObject(fone);
    }

    @Override
    public String toString() {
        return "Diretor{" + "nome=" + nome + ", fone=" + fone + '}';
    }
    
}
