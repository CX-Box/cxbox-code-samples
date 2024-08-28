package org.demo.documentation.widgets.assoc.colortitle;

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
public class MyEntity3056 extends BaseEntity {

    @JoinTable(name = "MyEntity3056_MyEntity3056MultiPick",
            joinColumns = @JoinColumn(name = "MyEntity3056_id"),
            inverseJoinColumns = @JoinColumn(name = "MyEntity3056Multi_id")
    )
    @ManyToMany(cascade =
            {CascadeType.PERSIST,
                    CascadeType.MERGE})
    private List<MyEntity3056Multi> customFieldMultiList = new ArrayList<>();
    @JoinTable(name = "MyEntity3056_MyEntity3056MultiPick0",
            joinColumns = @JoinColumn(name = "MyEntity3056_id"),
            inverseJoinColumns = @JoinColumn(name = "MyEntity3056Multi_id")
    )
    @ManyToMany(cascade =
            {CascadeType.PERSIST,
                    CascadeType.MERGE})
    private List<MyEntity3056Multi> customFieldMultiConstList = new ArrayList<>();
}