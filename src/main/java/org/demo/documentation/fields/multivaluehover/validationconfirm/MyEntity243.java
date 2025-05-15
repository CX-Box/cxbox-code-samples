package org.demo.documentation.fields.multivaluehover.validationconfirm;

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
public class MyEntity243 extends BaseEntity {

    @JoinTable(name = "MyEntity243_MyEntity244Pick",
            joinColumns = @JoinColumn(name = "MyEntity243_id"),
            inverseJoinColumns = @JoinColumn(name = "MyEntity244_id")
    )
    @ManyToMany(cascade =
            {CascadeType.PERSIST,
                    CascadeType.MERGE})
    private List<MyEntity244> customFieldMultiHoverList = new ArrayList<>();
}