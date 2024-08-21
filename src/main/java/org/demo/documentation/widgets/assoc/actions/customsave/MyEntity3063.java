package org.demo.documentation.widgets.assoc.actions.customsave;

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
public class MyEntity3063 extends BaseEntity {

    @JoinTable(name = "MyEntity3063_MyEntity3063Multi",
            joinColumns = @JoinColumn(name = "MyEntity3063_id"),
            inverseJoinColumns = @JoinColumn(name = "MyEntity3063Multi_id")
    )
    @ManyToMany(cascade =
            {CascadeType.PERSIST,
                    CascadeType.MERGE})
    private List<MyEntity3063Multi> customFieldList = new ArrayList<>();
}