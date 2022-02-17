package jss.api.wse.model;

import lombok.Data;

import javax.persistence.*;
import java.time.LocalDateTime;
import java.util.UUID;

@Data
@Entity
@Table(name = "sku")
public class SKU {

    public enum Size {
        SM, MD, LG
    }

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private UUID id;

    @Column(length = 3)
    private Size size;

    @ManyToOne
    @JoinColumn(name = "trend")
    private Trend trend;

    @ManyToOne
    @JoinColumn(name = "color")
    private Color color;

    @ManyToOne
    @JoinColumn(name = "category")
    private Category category;

    @Column
    private LocalDateTime createdAt;
}
