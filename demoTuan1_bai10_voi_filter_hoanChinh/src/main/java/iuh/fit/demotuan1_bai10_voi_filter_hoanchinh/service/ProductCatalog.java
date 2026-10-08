package iuh.fit.demotuan1_bai10_voi_filter_hoanchinh.service;

import iuh.fit.demotuan1_bai10_voi_filter_hoanchinh.model.Product;
import jakarta.enterprise.context.ApplicationScoped;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@ApplicationScoped
public class ProductCatalog {
    private static List<Product> dsProducts= new ArrayList<>();

    static {
        dsProducts.add(new Product(1L,"Iphone",new BigDecimal(1000)));
        dsProducts.add(new Product(2L,"Laptop",new BigDecimal(850)));
        dsProducts.add(new Product(3L,"Pin",new BigDecimal(50)));
    }

    public List<Product> getAll(){
        return dsProducts;
    }

    public Product findById(long id){
        return dsProducts.stream().filter(it-> it.getId()==id)
                        .findFirst()
//                       có thì trả về product ko thì trả về null
                        .orElse(null);
    }

//    Hoặc cách này vì findFirst trả về Optional (có thể null)
//    public Optional<Product> findById(int id){
//        return dsProducts.stream()
//                .filter(sp->sp.getId()==id)
//                .findFirst();
//    }
}
