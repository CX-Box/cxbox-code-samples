package org.demo.documentation.other.forceactive2.forproject;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.cxbox.model.core.entity.BaseEntity;
import org.demo.documentation.other.forceactive2.forproject.enums.FileTypeEnum;
import org.demo.documentation.other.forceactive2.forproject.enums.ObjectTypeEnum;
import org.demo.documentation.other.forceactive2.forproject.enums.PlacePresentationEnum;


@Entity
@Getter
@Setter
@NoArgsConstructor
public class MyEntity4903Instance extends BaseEntity {
    @Column
    private String customField;
}
