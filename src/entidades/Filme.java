package entidades;

import java.sql.SQLData;
import java.sql.SQLException;
import java.sql.SQLInput;
import java.sql.SQLOutput;

public class Filme implements SQLData{

    private String titulo;
    private Diretor diretor;
    private int duracao;

    public Filme(){ }

    public Filme(String titulo, Diretor diretor, int duracao) {
        this.titulo = titulo;
        this.diretor = diretor;
        this.duracao = duracao;
    }

    public String getTitulo() {
        return titulo;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    public Diretor getDiretor() {
        return diretor;
    }

    public void setDiretor(Diretor diretor) {
        this.diretor = diretor;
    }

    public int getDuracao() {
        return duracao;
    }

    public void setDuracao(int duracao) {
        this.duracao = duracao;
    }


    
    @Override
    public String getSQLTypeName() throws SQLException {
        return "FILME";
    }

    @Override
    public void readSQL(SQLInput stream, String typeName) throws SQLException {
        titulo = stream.readString();
        diretor = (Diretor) stream.readObject();
        duracao = stream.readInt();
    }

    @Override
    public void writeSQL(SQLOutput stream) throws SQLException {
        stream.writeString(titulo);
        stream.writeObject(diretor);
        stream.writeInt(duracao);
    }

    @Override
    public String toString() {
        return "Filme{" + "titulo=" + titulo + ", diretor=" + diretor + ", duracao=" + duracao + '}';
    }

}
