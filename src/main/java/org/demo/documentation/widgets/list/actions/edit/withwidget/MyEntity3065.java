package org.demo.documentation.widgets.list.actions.edit.withwidget;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.cxbox.model.core.entity.BaseEntity;
import org.demo.documentation.fields.date.basic.DateBasic;
import org.demo.documentation.other.savewithparent.example5.entity.ApplicationEntity;

import java.util.ArrayList;
import java.util.List;


@Entity
@Getter
@Setter
@NoArgsConstructor
public class MyEntity3065 extends BaseEntity {
    @Column
    private String customField;
    @Column
    private String customFieldText;

    @JoinColumn(name = "DFGJHKL_ID")
    @ManyToOne
    private DateBasic dfgjhklEntity;

    @JoinColumn(name = "FJHJKL_ID")
    @ManyToOne
    private ApplicationEntity fjhjklEntity;

    @JoinTable(name = "MyEntity3065_ApplicationEntityPick0",
            joinColumns = @JoinColumn(name = "MyEntity3065_id"),
            inverseJoinColumns = @JoinColumn(name = "ApplicationEntity_id")
    )
    @ManyToMany(cascade =
            {CascadeType.PERSIST,
                    CascadeType.MERGE})
    private List<ApplicationEntity> hkjhkjList = new ArrayList<>();
}