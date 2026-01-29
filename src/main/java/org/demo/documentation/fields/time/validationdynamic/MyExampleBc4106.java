package org.demo.documentation.fields.time.validationdynamic;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Table;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.cxbox.model.core.entity.BaseEntity;

import java.time.LocalDateTime;


@Entity
@Table(name = "MY_EXAMPLE_BC4106")
@Getter
@Setter
@NoArgsConstructor
@EqualsAndHashCode(of = {}, callSuper = true)
public class MyExampleBc4106 extends BaseEntity {


    @Column
    private LocalDateTime customField;

    @Column
    private LocalDateTime customFieldAdditional;
}