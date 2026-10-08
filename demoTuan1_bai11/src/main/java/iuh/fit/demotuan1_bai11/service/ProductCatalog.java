package iuh.fit.demotuan1_bai11.service;

import iuh.fit.demotuan1_bai11.model.Product;
import jakarta.enterprise.context.ApplicationScoped;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@ApplicationScoped
public class ProductCatalog {
    private static List<Product> dssp= new ArrayList<>();

    static{
        dssp.add(new Product(
                1L,
                "Laptop",
                new BigDecimal("1500.00")
        ));
        dssp.add(
                new Product(
                        2L,
                        "Keyboard",
                        new BigDecimal("80.00")
                )
        );
        dssp.add(new Product(
                3L,
                "Mouse",
                new BigDecimal("40.00"))
        );
    }

    public List<Product> findAll(){
        return dssp;
    }
    public Optional<Product> findById(Long id){
        return dssp.stream().filter(it-> it.getId()==id).findFirst();
    }

    public static List<Product> getDssp() {
        return dssp;
    }

    public static void setDssp(List<Product> dssp) {
        ProductCatalog.dssp = dssp;
    }
}
