package org.demo.documentation.widgets.property.defaultlimitpage;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.cxbox.model.core.entity.BaseEntity;
import org.demo.documentation.widgets.property.defaultlimitpage.forassoc.MyEntity359Assoc;
import org.demo.documentation.widgets.property.defaultlimitpage.forassoc.MyEntity359Pick;

import java.util.ArrayList;
import java.util.List;

@Entity
@Getter
@Setter
@NoArgsConstructor
public class MyEntity359 extends BaseEntity {
    @Column
    private String customField;
    @JoinTable(name = "MyEntity359_MyEntity359AssocPick",
            joinColumns = @JoinColumn(name = "MyEntity359_id"),
            inverseJoinColumns = @JoinColumn(name = "MyEntity359Assoc_id")
    )
    @ManyToMany(cascade =
            {CascadeType.PERSIST,
                    CascadeType.MERGE})
    private List<MyEntity359Assoc> customFieldMultivalueList = new ArrayList<>();
    @JoinColumn(name = "CUSTOM_FIELD_PICKLIST_ID")
    @ManyToOne
    private MyEntity359Pick customFieldPicklistEntity;
}