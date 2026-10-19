package fit.se.demospringsecurity2.config;

import fit.se.demospringsecurity2.entity.Product;
import fit.se.demospringsecurity2.repository.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

@Component
public class DataInitializer implements CommandLineRunner {

    @Autowired
    private ProductRepository productRepository;

    @Override
    public void run(String... args) throws Exception {
        System.out.println("=== DataInitializer started ===");
        long count = productRepository.count();
        System.out.println("Current products count: " + count);
        
        if (count == 0) {
            System.out.println("Adding sample products...");
            
            Product product1 = new Product();
            product1.setName("iPhone 15");
            product1.setDescription("Latest iPhone with advanced features");
            product1.setPrice(999.99);
            product1.setQuantity(50);
            product1.setImageUrl("https://via.placeholder.com/300x200?text=iPhone+15");
            productRepository.save(product1);

            Product product2 = new Product();
            product2.setName("Samsung Galaxy S24");
            product2.setDescription("Premium Android smartphone");
            product2.setPrice(899.99);
            product2.setQuantity(30);
            product2.setImageUrl("https://via.placeholder.com/300x200?text=Galaxy+S24");
            productRepository.save(product2);

            Product product3 = new Product();
            product3.setName("MacBook Pro");
            product3.setDescription("Professional laptop for developers");
            product3.setPrice(1999.99);
            product3.setQuantity(20);
            product3.setImageUrl("https://via.placeholder.com/300x200?text=MacBook+Pro");
            productRepository.save(product3);

            System.out.println("Sample data initialized successfully!");
        } else {
            System.out.println("Products already exist, skipping initialization.");
        }
    }
}