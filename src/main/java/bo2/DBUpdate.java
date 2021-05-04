package bo2;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.List;

public class DBUpdate {
    public String url = "jdbc:mysql://localhost:3308/TP2";
    public String user="oussema";
    public String password = "root";
    public String query = "UPDATE product_sale set sent = 1 where id = ?";
    public void update(List<Product> productList) throws SQLException {
        try(Connection connection = DriverManager.getConnection(url, user, password);
            PreparedStatement pst = connection.prepareStatement(query)
        ){
            for(int i=0; i<productList.size(); i++) {
                pst.setInt(1, productList.get(i).getId());
                pst.executeUpdate();
            }
        }
    }
}
