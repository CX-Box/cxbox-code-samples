package org.demo.documentation.fields.time.filtration;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.cxbox.model.core.entity.BaseEntity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;

import java.time.LocalDateTime;


@Entity
@Getter
@Setter
@NoArgsConstructor
public class MyEntity3504 extends BaseEntity {

    @Column
    private LocalDateTime customField;
    @Column
    private LocalDateTime customFieldhmm;
    @Column
    private LocalDateTime customFieldh;
    @Column
    private LocalDateTime customFieldhmmA;
    @Column
    private LocalDateTime customFieldhmmssA;
    @Column
    private LocalDateTime customFieldmm;
    @Column
    private LocalDateTime customFieldmmss;
    @Column
    private LocalDateTime customFieldss;
    @Column
    private LocalDateTime customFieldhA;
}