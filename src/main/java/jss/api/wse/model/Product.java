package jss.api.wse.model;

import lombok.Data;

import javax.persistence.*;
import java.math.BigInteger;
import java.time.LocalDateTime;

@Data
@Entity
@Table(name = "product")
public class Product {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @Column(length = 60)
    private String name;

    @Column
    private BigInteger amount;

    @ManyToOne
    @JoinColumn(name = "trend")
    private Trend trend;

    @ManyToOne
    @JoinColumn(name = "sku_id")
    private SKU sku;

    @Column
    private LocalDateTime createdAt;

}
