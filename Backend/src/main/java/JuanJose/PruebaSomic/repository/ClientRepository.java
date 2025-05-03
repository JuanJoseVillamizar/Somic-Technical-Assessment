package JuanJose.PruebaSomic.repository;

import JuanJose.PruebaSomic.entities.Client;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ClientRepository extends JpaRepository <Client, Long> {
}
