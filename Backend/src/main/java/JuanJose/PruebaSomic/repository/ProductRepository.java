package JuanJose.PruebaSomic.repository;

import JuanJose.PruebaSomic.entities.Product;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ProductRepository extends JpaRepository<Product,Long> {
}
