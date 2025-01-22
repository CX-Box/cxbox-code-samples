package org.demo.documentation.widgets.assoc.actions.other.createwithparent;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.cxbox.model.core.entity.BaseEntity;
import org.demo.documentation.widgets.assoc.actions.other.createwithparent.parent.MyEntity3661;
import org.demo.documentation.widgets.assoc.actions.other.createwithparent.assoc.MyEntity3662;
import org.demo.documentation.widgets.assoc.actions.other.createwithparent.assocreq.MyEntity3663;

import java.util.ArrayList;
import java.util.List;

@Entity
@Getter
@Setter
@NoArgsConstructor
public class MyEntity3660 extends BaseEntity {

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "PARENT_ID")
    private MyEntity3661 customFieldEntity;

    @JoinTable(name = "MyEntity3660_MyEntity3662",
            joinColumns = @JoinColumn(name = "MyEntity3660_id"),
            inverseJoinColumns = @JoinColumn(name = "MyEntity3662_id")
    )
    @ManyToMany(cascade =
            {CascadeType.PERSIST,
                    CascadeType.MERGE})
    private List<MyEntity3662> customFieldList = new ArrayList<>();
    @Column
    private String customFieldText;
    @Column
    private String customFieldTextReq;
    @JoinTable(name = "MyEntity3660_MyEntity3663",
            joinColumns = @JoinColumn(name = "MyEntity3660_id"),
            inverseJoinColumns = @JoinColumn(name = "MyEntity3663_id")
    )
    @ManyToMany(cascade =
            {CascadeType.PERSIST,
                    CascadeType.MERGE})
    private List<MyEntity3663> customFieldReqList = new ArrayList<>();
}