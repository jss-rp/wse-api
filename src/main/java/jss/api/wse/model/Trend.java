package jss.api.wse.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.NonNull;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import java.time.LocalDateTime;

@Data
@Entity
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "trend")
public class Trend {

    @Id
    @NonNull
    @Column(name = "code", nullable = false, length = 3)
    private String code;

    @NonNull
    @Column(length = 60, unique = true)
    private String name;

    @NonNull
    @Column
    private LocalDateTime createdAt;
}