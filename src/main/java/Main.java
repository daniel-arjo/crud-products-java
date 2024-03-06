import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String productName;
        double productPrice;
        String productDescription;
        int productStockQuantity;
        int option;
        int id;

        do {
            System.out.println("====================================");
            System.out.println("Sistema CRUD de produtos 1.0");
            System.out.println("Digite 1 para inserir um novo produto");
            System.out.println("Digite 2 para listar todos os produtos");
            System.out.println("Digite 3 para atualizar um produto existente");
            System.out.println("Digite 4 para deletar um produto");
            System.out.println("Digite 0 para sair do programa");
            System.out.print("Selecione uma opção : ");
            option = scanner.nextInt();
            System.out.println("====================================");

            switch (option) {
                case 1:
                    System.out.println("informe o nome do produto : ");
                    scanner.nextLine();
                    productName = scanner.nextLine();
                    System.out.println("informe o preço do produto : ");
                    productPrice = scanner.nextDouble();
                    scanner.nextLine();
                    System.out.println("informe a descrição do produto : ");
                    scanner.nextLine();
                    productDescription = scanner.nextLine();
                    System.out.println("informe a quantidade de estoque do produto : ");
                    productStockQuantity = scanner.nextInt();

                    Product product = new Product(productName, productPrice, productDescription, productStockQuantity);

                    CrudProducts.save(product);
                    break;
                case 2:
                    List<Product> products = CrudProducts.findAll();
                    Product[] productsArray = products.toArray(new Product[0]);
                    System.out.println("Produtos: " + Arrays.toString(productsArray));
                    break;
                case 3:
                    System.out.println("informe o id a ser atualizado : ");
                    id = scanner.nextInt();
                    System.out.println("informe o nome do produto : ");
                    productName = scanner.nextLine();
                    System.out.println("informe o preço do produto : ");
                    productPrice = scanner.nextDouble();
                    System.out.println("informe a descrição do produto : ");
                    productDescription = scanner.nextLine();
                    System.out.println("informe a quantidade de estoque do produto : ");
                    productStockQuantity = scanner.nextInt();

                    Product productUpdate = new Product(productName, productPrice, productDescription, productStockQuantity);

                    CrudProducts.update(id, productUpdate);
                    break;
                case 4:
                    System.out.println("informe o id a ser deletado : ");
                    id = scanner.nextInt();
                    CrudProducts.delete(id);
                    break;
                case 0:
                    System.out.println("Até logo!");
                    break;
                default:
                    System.out.println("Opção inválida");
                    break;
            }
        }while(option != 0);
    }
}
