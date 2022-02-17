package jss.api.wse.model;

import lombok.Data;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import java.time.LocalDateTime;

@Data
@Entity
@Table(name = "category")
public class Category {

    @Id
    @Column(name = "code", nullable = false, length = 3)
    private String code;

    @Column(length = 20)
    private String name;

    @Column
    private LocalDateTime createdAt;
}