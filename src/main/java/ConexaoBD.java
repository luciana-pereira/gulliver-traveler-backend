import java.sql.*;

public class ConexaoBD {
    private Connection conexao;

    public ConexaoBD() throws SQLException {
        String url = "jdbc:mysql://localhost:3306/db-gulliver-traveller";
        String usuario = "admgulliver";
        String senha = "gulliver1830";
        conexao = DriverManager.getConnection(url, usuario, senha);
    }

    public Connection getConexao() {
        return conexao;
    }

    public void fechar() throws SQLException {
        conexao.close();
    }
}

