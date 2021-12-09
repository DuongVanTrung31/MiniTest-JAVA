
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Nhập số lượng sản phẩm : ");
        int count = scanner.nextInt();
        scanner.nextLine();
        Product[]products = new Product[count];
        for (int i = 0; i < products.length; i++) {
            System.out.println("Nhập sản phẩm");
            products[i] = createProduct(scanner);
        }
        int choice = -1;
        do {
            System.out.println("Menu");
            System.out.println("1.Tìm sản phẩm");
            System.out.println("2.Tính tổng sản phẩm");
            System.out.println("0.Exit");
            choice = scanner.nextInt();
            switch (choice) {
                case 1:
                    findNameProduct(products,scanner);
                    break;
                case 2:
                    System.out.println(getSumPrices(products));
                    break;
                case 0:
                    System.exit(0);
            }
        } while (choice != 0);
    }

    public static Product createProduct(Scanner scanner) {
        System.out.println("Nhâp id: ");
        int id = scanner.nextInt();
        scanner.nextLine();
        System.out.println("Nhập tên sản phẩm: ");
        String name = scanner.nextLine();
        System.out.println("Nhập giá sản phẩm: ");
        double price = scanner.nextDouble();
        scanner.nextLine();
        System.out.println("Nhập loại sản phẩm: ");
        String type = scanner.nextLine();
        return new Product(id,name,price,type);
    }

    public static void findNameProduct(Product[] products,Scanner scanner) {
        System.out.println("Nhập tên sản phẩm cần tìm :");
        String name = scanner.nextLine();
        for (int i = 0; i < products.length; i++) {
            if (products[i].getName().equals(name)) {
                System.out.println(products[i]);
            } else {
                System.out.println("Không tìm thấy sản phẩm");
            }
        }
    }
    public static double getSumPrices(Product[] products) {
        double sum = 0;
        for (Product x: products
             ) {
            sum += x.getPrice();
        }
        return sum;
    }

}
