package JuanJose.PruebaSomic.repository;

import JuanJose.PruebaSomic.entities.Client;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface ClientRepository extends JpaRepository <Client, Long> {
    Optional<Client> findByDocument(String document);
}
