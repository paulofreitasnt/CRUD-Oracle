package entidades;

import java.sql.SQLData;
import java.sql.SQLException;
import java.sql.SQLInput;
import java.sql.SQLOutput;

public class Telefone implements SQLData{

    private int ddd;
    private String numero;

    public Telefone() { }

    public Telefone(int ddd, String numero) {
        this.ddd = ddd;
        this.numero = numero;
    }

    public int getDdd() {
        return ddd;
    }

    public void setDdd(int ddd) {
        this.ddd = ddd;
    }

    public String getNumero() {
        return numero;
    }

    public void setNumero(String numero) {
        this.numero = numero;
    }

    @Override
    public String getSQLTypeName() throws SQLException {
        return "TELEFONE";
    }

    @Override
    public void readSQL(SQLInput stream, String typeName) throws SQLException {
        ddd = stream.readInt();
        numero = stream.readString();
    }

    @Override
    public void writeSQL(SQLOutput stream) throws SQLException {
        stream.writeInt(ddd);
        stream.writeString(numero);
    }

    @Override
    public String toString() {
        return "Telefone{" + "ddd=" + ddd + ", numero=" + numero + '}';
    }
    
}
