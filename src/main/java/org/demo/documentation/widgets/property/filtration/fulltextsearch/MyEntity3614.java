package org.demo.documentation.widgets.property.filtration.fulltextsearch;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.cxbox.model.core.entity.BaseEntity;
import org.demo.documentation.widgets.property.filtration.fulltextsearch.forassoc.MyEntity3625;
import org.demo.documentation.widgets.property.filtration.fulltextsearch.forpicklist.MyEntity3614Pick;

import java.util.ArrayList;
import java.util.List;


@Entity
@Getter
@Setter
@NoArgsConstructor
public class MyEntity3614 extends BaseEntity {
    @Column
    private String customField;
    @Column
    private String fullName;
    @Column
    private String address;
    @JoinTable(name = "MyEntity3614_MyEntity3625Pick",
            joinColumns = @JoinColumn(name = "MyEntity3614_id"),
            inverseJoinColumns = @JoinColumn(name = "MyEntity3625_id")
    )
    @ManyToMany(cascade =
            {CascadeType.PERSIST,
                    CascadeType.MERGE})
    private List<MyEntity3625> customFieldMultivalueDisplayedKeyList = new ArrayList<>();
    @JoinColumn(name = "CUSTOM_FIELD_PICKLIST_ID")
    @ManyToOne
    private MyEntity3614Pick customFieldPicklistEntity;
}