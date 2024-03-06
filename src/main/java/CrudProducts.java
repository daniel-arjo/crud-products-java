import java.sql.*;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class CrudProducts {
    private static final String URL = "jdbc:mysql://localhost:3306/db_products";
    private static final String USER = "root";
    private static final String PASSWORD = "123456";

    private static Connection connect() throws SQLException{
        return DriverManager.getConnection(URL, USER, PASSWORD);
    }

    public static void save(Product product){
        try {
            Connection connection = connect();

            String sql = "INSERT INTO db_products.products (name, price, description, stock_quantity) VALUES (?, ?, ?, ?)";

            PreparedStatement preparedStatement = connection.prepareStatement(sql);

            LocalDate nowDate = LocalDate.now();
            preparedStatement.setString(1, product.getName());
            preparedStatement.setDouble(2, product.getPrice());
            preparedStatement.setString(3, product.getDescription());
            preparedStatement.setInt(4, product.getStockQuantity());

            preparedStatement.executeUpdate();

            System.out.println("Produto adicionado com sucesso");

        } catch (SQLException e) {
            System.err.println("Erro ao adicionar o produto ao banco de dados: " + e.getMessage());
            throw new RuntimeException(e);
        }
    }
    public static List<Product> findAll(){
        List<Product> productList = new ArrayList<>();
        try {
            Connection connection = connect();
            String sql = "SELECT * FROM db_products.products";
            PreparedStatement preparedStatement = connection.prepareStatement(sql);

            ResultSet resultSet = preparedStatement.executeQuery();

            while (resultSet.next()) {
                Integer id = resultSet.getInt("id");
                String name = resultSet.getString("name");
                double price = resultSet.getDouble("price");
                String description = resultSet.getString("description");
                int stockQuantity = resultSet.getInt("stock_quantity");

                // Criando um objeto Product com os dados do banco de dados
                Product product = new Product(id, name, price, description, stockQuantity);
                productList.add(product);
            }

        } catch (SQLException e) {
            System.err.println("Erro ao encontrar os produtos no banco de dados: " + e.getMessage());
            throw new RuntimeException(e);
        }

        return productList;
    }

    public static void update(int id, Product product){

        try {
            Connection connection = connect();

            String sql = "UPDATE db_products.products SET name = ?, price = ?, description = ?, stock_quantity = ? WHERE id = ?";

            PreparedStatement preparedStatement = connection.prepareStatement(sql);

            preparedStatement.setString(1, product.getName());
            preparedStatement.setDouble(2, product.getPrice());
            preparedStatement.setString(3, product.getDescription());
            preparedStatement.setInt(4, product.StockQuantity);
            preparedStatement.setInt(5, id);

            preparedStatement.executeUpdate();

            System.out.println("Produto atualizado com sucesso");

        } catch (SQLException e) {
            System.err.println("Erro ao atualizar o produto no banco de dados: " + e.getMessage());
            throw new RuntimeException(e);
        }

    }

    public static void delete(int id){
        try {
            Connection connection = connect();

            String sql = "DELETE FROM db_products.products WHERE id = ?";

            PreparedStatement preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setInt(1, id);
            preparedStatement.executeUpdate();

            System.out.println("Produto deletado com sucesso");

        } catch (SQLException e) {
            System.err.println("Erro ao deletar o produto no banco de dados: " + e.getMessage());
            throw new RuntimeException(e);
        }
    }
}
