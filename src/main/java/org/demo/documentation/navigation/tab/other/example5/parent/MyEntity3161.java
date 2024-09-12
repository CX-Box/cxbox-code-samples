package org.demo.documentation.navigation.tab.other.example5.parent;

import jakarta.persistence.Entity;
import jakarta.persistence.Column;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.cxbox.model.core.entity.BaseEntity;


// 3161
// 
// 

@Entity
@Getter
@Setter
@NoArgsConstructor
public class MyEntity3161 extends BaseEntity {
    @Column
    private String customField;
    @Column
    private Boolean customFieldCheckBox;
    @Column
    private String customFieldText;
}