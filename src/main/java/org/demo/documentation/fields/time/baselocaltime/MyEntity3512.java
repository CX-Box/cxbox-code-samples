package org.demo.documentation.fields.time.baselocaltime;

import jakarta.persistence.Entity;
import jakarta.persistence.Column;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.cxbox.model.core.entity.BaseEntity;

import java.time.LocalDateTime;
import java.time.LocalTime;


@Entity
@Getter
@Setter
@NoArgsConstructor
public class MyEntity3512 extends BaseEntity {
    @Column
    private LocalTime customField;
    @Column
    private LocalTime customFieldhA;
    @Column
    private LocalTime customFieldhmmA;
    @Column
    private LocalTime customFieldhmmssA;
    @Column
    private LocalTime customFieldh;
    @Column
    private LocalTime customFieldhmm;
}