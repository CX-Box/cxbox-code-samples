package org.demo.documentation.fields.multivaluehover.required;

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
public class MyEntity236 extends BaseEntity {

    @JoinTable(name = "MyEntity236_MyEntity238Pick",
            joinColumns = @JoinColumn(name = "MyEntity236_id"),
            inverseJoinColumns = @JoinColumn(name = "MyEntity238_id")
    )
    @ManyToMany(cascade =
            {CascadeType.PERSIST,
                    CascadeType.MERGE})
    private List<MyEntity238> customFieldMultiHoverList = new ArrayList<>();
}