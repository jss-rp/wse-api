package jss.api.wse.model;

import lombok.Data;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import java.time.LocalDateTime;

@Data
@Entity
@Table(name = "trend")
public class Trend {

    @Id
    @Column(name = "code", nullable = false, length = 3)
    private String code;

    @Column(length = 60, unique = true)
    private String name;

    @Column
    private LocalDateTime createdAt;
}