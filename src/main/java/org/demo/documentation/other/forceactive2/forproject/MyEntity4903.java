package org.demo.documentation.other.forceactive2.forproject;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.cxbox.model.core.entity.BaseEntity;
import org.demo.documentation.other.forceactive2.forproject.enums.PlacePresentationEnum;


@Entity
@Getter
@Setter
@NoArgsConstructor
public class MyEntity4903 extends BaseEntity {
    @Column
    private String customField;
    @JoinColumn(name = "NAME_F_S_P_P_ID")
    @ManyToOne
    private MyEntity4903Pick nameFSPPEntity;
    @Enumerated(value = EnumType.STRING)
    @Column
    private PlacePresentationEnum placePresentation;
    @JoinColumn(name = "NAME_O_S_P_ID")
    @ManyToOne
    private MyEntity4903OCPPick nameOSPEntity;
}
