package org.demo.documentation.input.drilldown;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.cxbox.model.core.entity.BaseEntity;

@Entity
@Table(name = "InputDrilldown")
@Getter
@Setter
@NoArgsConstructor
public class InputDrilldown extends BaseEntity {

    private String customField;

    @Column
    private String customField2;
}
