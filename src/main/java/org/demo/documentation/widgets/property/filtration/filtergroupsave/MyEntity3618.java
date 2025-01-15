package org.demo.documentation.widgets.property.filtration.filtergroupsave;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.cxbox.model.core.entity.BaseEntity;
import org.demo.documentation.widgets.property.filtration.filtergroupsave.enums.CustomFieldDictionaryEnum;
import org.demo.documentation.widgets.property.filtration.filtergroupsave.forassoc.MyEntity3624;

import java.util.ArrayList;
import java.util.List;


@Entity
@Getter
@Setter
@NoArgsConstructor
public class MyEntity3618 extends BaseEntity {
    @Column
    private String customField;
    @Column
    private String customFieldNew;
    @Enumerated(value = EnumType.STRING)
    @Column
    private CustomFieldDictionaryEnum customFieldDictionary;
    @JoinTable(name = "MyEntity3618_MyEntity3624Pick",
            joinColumns = @JoinColumn(name = "MyEntity3618_id"),
            inverseJoinColumns = @JoinColumn(name = "MyEntity3624_id")
    )
    @ManyToMany(cascade =
            {CascadeType.PERSIST,
                    CascadeType.MERGE})
    private List<MyEntity3624> customFieldMultivalueDisplayedKeyList = new ArrayList<>();
}