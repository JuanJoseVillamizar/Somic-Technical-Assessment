package JuanJose.PruebaSomic.repository;

import JuanJose.PruebaSomic.entities.Invoice;
import org.springframework.data.jpa.repository.JpaRepository;

public interface InvoiceRepository extends JpaRepository<Invoice,Long> {
}
