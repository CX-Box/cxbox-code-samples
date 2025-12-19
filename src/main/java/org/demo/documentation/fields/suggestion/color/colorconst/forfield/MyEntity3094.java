package org.demo.documentation.fields.suggestion.color.colorconst.forfield;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.cxbox.model.core.entity.BaseEntity;
import org.demo.documentation.fields.input.filtration.InputFiltration;
import org.demo.documentation.fields.suggestion.color.colorconst.forfield.enums.ResidentTypeEnum;

@Entity
@Getter
@Setter
@NoArgsConstructor
public class MyEntity3094 extends BaseEntity {
    @Column
    private String customField;
    @Column
    private String customFieldDate;

    @Enumerated(value = EnumType.STRING)
    @Column
    private ResidentTypeEnum residentType;

    @JoinColumn(name = "RUS_SHORT_NAME_ID")
    @ManyToOne
    private InputFiltration rusShortNameEntity;

    @Column
    private String rusFullName;

    @Column
    private String inn;

    @JoinColumn(name = "INN2_ID")
    @ManyToOne
    private InputFiltration inn2Entity;
}