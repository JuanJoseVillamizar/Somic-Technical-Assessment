package JuanJose.PruebaSomic.entities;

import jakarta.persistence.*;
import lombok.*;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name="client")
@Getter
@Builder
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode(of="id")
public class Client {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false, length =20)
    private String taxId;

    @Column(nullable = false, length =100)
    private String name;

    @Column(nullable = false, unique = true, length =20)
    private String document;

    @Column(nullable = false)
    private BigDecimal creditLimit;

    @Column(nullable = false)
    private Integer paymentTerms;

    @OneToMany(mappedBy =  "client", cascade= CascadeType.ALL)
    private List<Invoice> invoices = new ArrayList<>();
}
