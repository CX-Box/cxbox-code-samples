package org.demo.documentation.widgets.property.excel.postAction.base;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Table;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.experimental.SuperBuilder;
import org.cxbox.model.core.entity.BaseEntity;

@Setter
@Getter
@NoArgsConstructor
@SuperBuilder
@Entity
@Table(name = "MY_EXAMPLE6500_POST_ACTION_EXPORT_TO_EXCEL_LIST_ENTITY" )
public class MyExample6500PostActionExportToExcelListEntity extends BaseEntity {

    @Column(name = "TEST_DATA" )
    public String testData;

}
