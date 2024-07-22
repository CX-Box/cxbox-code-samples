package org.demo.documentation.widgets.additionalinfo.colortitle;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.cxbox.model.core.entity.BaseEntity;
import org.demo.documentation.widgets.additionalinfo.colortitle.enums.CustomFieldColorDictionaryEnum;
import org.demo.documentation.widgets.additionalinfo.colortitle.enums.CustomFieldColorRadioEnum;

import java.time.LocalDateTime;


@Entity
@Getter
@Setter
@NoArgsConstructor
public class MyEntity3029 extends BaseEntity {
    @Column
    private String customField;

}