package org.demo.documentation.time.sorting;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.cxbox.model.core.entity.BaseEntity;

import javax.persistence.Column;
import javax.persistence.Entity;
import java.time.LocalDateTime;


@Entity
@Getter
@Setter
@NoArgsConstructor
public class MyEntity3508 extends BaseEntity {

    @Column
    private LocalDateTime customField;
}