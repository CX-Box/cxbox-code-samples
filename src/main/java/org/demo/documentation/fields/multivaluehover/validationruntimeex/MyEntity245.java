package org.demo.documentation.fields.multivaluehover.validationruntimeex;

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
public class MyEntity245 extends BaseEntity {

    @JoinTable(name = "MyEntity245_MyEntity246Pick",
            joinColumns = @JoinColumn(name = "MyEntity245_id"),
            inverseJoinColumns = @JoinColumn(name = "MyEntity246_id")
    )
    @ManyToMany(cascade =
            {CascadeType.PERSIST,
                    CascadeType.MERGE})
    private List<MyEntity246> customFieldMultiHoverList = new ArrayList<>();
}