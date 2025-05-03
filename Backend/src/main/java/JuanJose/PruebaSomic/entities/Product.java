package JuanJose.PruebaSomic.entities;

import jakarta.persistence.*;
import lombok.*;

import java.math.BigDecimal;


@Entity
@Table(name="product")
@Getter
@Builder
@AllArgsConstructor
@NoArgsConstructor
@EqualsAndHashCode(of="id")
public class Product {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false, length =20)
    private String code;

    @Column(nullable = false, length =100)
    private String name;

    @Column(nullable = false, length =100)
    private String lab;

    @Column(nullable = false)
    private Integer stock;

    @Column(nullable = false)
    private BigDecimal cost;

    @Column(nullable = false)
    private BigDecimal salePrice;

}
