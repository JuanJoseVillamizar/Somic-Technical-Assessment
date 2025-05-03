package JuanJose.PruebaSomic.data;

import JuanJose.PruebaSomic.entities.Client;
import JuanJose.PruebaSomic.entities.Product;
import JuanJose.PruebaSomic.repository.ClientRepository;
import JuanJose.PruebaSomic.repository.ProductRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import java.math.BigDecimal;

@Component
@RequiredArgsConstructor
@Slf4j
public class DataInitializer implements CommandLineRunner {

    private final ClientRepository clientRepository;
    private final ProductRepository productRepository;

    @Override
    public void run(String... args) {
        if (clientRepository.count() > 0 && productRepository.count() > 0) {
            log.info("Data already initialized, skipping...");
            return;
        }
        log.info("initializing test data...");
        createClientIfNotExists(
                "123456789",
                "Farmacia La Económica",
                "901234567",
                new BigDecimal("5000000"),
                30
        );
        createClientIfNotExists(
                "987654321",
                "Droguería Salud Total",
                "109876543",
                new BigDecimal("3000000"),
                15
        );
        createProductIfNotExists(
                "ACET500",
                "Acetaminofen 500mg",
                "MK",
                100,
                new BigDecimal("1500"),
                new BigDecimal("2500")
        );
        createProductIfNotExists(
                "IBP500",
                "Ibuprofeno 600mg",
                "Bayer",
                50,
                new BigDecimal("1800"),
                new BigDecimal("3000")
        );
        log.info("test data inizializated succesfully");
    }

    private void createClientIfNotExists(
            String taxId,
            String name,
            String document,
            BigDecimal creditLimit,
            Integer paymentTerms
    ) {
        clientRepository.findByDocument(document).orElseGet(() -> {
            Client client = Client.builder()
                    .taxId(taxId)
                    .name(name)
                    .document(document)
                    .creditLimit(creditLimit)
                    .paymentTerms(paymentTerms)
                    .build();
            return clientRepository.save(client);
        });

    }

    private void createProductIfNotExists(
            String code,
            String name,
            String lab,
            Integer stock,
            BigDecimal cost,
            BigDecimal salePrice
    ) {
        productRepository.findByCode(code).orElseGet(() -> {
            Product product = Product.builder()
                    .code(code)
                    .name(name)
                    .lab(lab)
                    .stock(stock)
                    .cost(cost)
                    .salePrice(salePrice)
                    .build();
            return productRepository.save(product);
        });
    }
}
