package org.demo.documentation.datetimewithseconds.validationbusinessex;

import org.cxbox.model.core.entity.BaseEntity;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.Column;
import javax.persistence.Entity;
import java.time.LocalDateTime;

@Entity
@Getter
@Setter
@NoArgsConstructor
public class MyEntity300 extends BaseEntity {

    @Column
    private LocalDateTime customField;
}