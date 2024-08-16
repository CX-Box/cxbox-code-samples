package org.demo.documentation.widgets.assoc.actions.buttonassoc;

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
public class MyEntity3062 extends BaseEntity {

    @JoinTable(name = "MyEntity3062_MyEntity3062Multi",
            joinColumns = @JoinColumn(name = "MyEntity3062_id"),
            inverseJoinColumns = @JoinColumn(name = "MyEntity3062Multi_id")
    )
    @ManyToMany(cascade =
            {CascadeType.PERSIST,
                    CascadeType.MERGE})
    private List<MyEntity3062Multi> customFieldList = new ArrayList<>();
}