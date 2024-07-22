package org.demo.documentation.widgets.assoc.colortitle.forfields;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.cxbox.model.core.entity.BaseEntity;
import org.demo.documentation.widgets.assoc.colortitle.MyEntity3052Multi;

import java.util.ArrayList;
import java.util.List;


@Entity
@Getter
@Setter
@NoArgsConstructor
public class MyEntity3052MultiMultiAssoc extends BaseEntity {
    @Column
    private String customField;
    @JoinTable(name = "MyEntity3052_MyEntity3052Multi",
            joinColumns = @JoinColumn(name = "MyEntity3052_id"),
            inverseJoinColumns = @JoinColumn(name = "MyEntity3052Multi_id")
    )
    @ManyToMany(cascade =
            {CascadeType.PERSIST,
                    CascadeType.MERGE})
    private List<MyEntity3052Multi> customFieldMultiList = new ArrayList<>();
}