package org.demo.documentation.widgets.assoc.title;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.cxbox.model.core.entity.BaseEntity;

import java.util.ArrayList;
import java.util.List;


@Entity
@Getter
@Setter
@NoArgsConstructor
public class MyEntity3090 extends BaseEntity {
    @Column
    private String customField;
    @JoinTable(name = "MyEntity3090_MyEntity3090MultiPick",
            joinColumns = @JoinColumn(name = "MyEntity3090_id"),
            inverseJoinColumns = @JoinColumn(name = "MyEntity3090Multi_id")
    )
    @ManyToMany(cascade =
            {CascadeType.PERSIST,
                    CascadeType.MERGE})
    private List<MyEntity3090Multi> customFieldMultivalueList = new ArrayList<>();
}