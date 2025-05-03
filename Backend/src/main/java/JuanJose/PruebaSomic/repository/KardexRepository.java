package JuanJose.PruebaSomic.repository;

import JuanJose.PruebaSomic.entities.InvoiceKardex;
import org.springframework.data.jpa.repository.JpaRepository;

public interface KardexRepository extends JpaRepository<InvoiceKardex,Long> {
}
