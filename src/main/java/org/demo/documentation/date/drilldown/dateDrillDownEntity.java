package org.demo.documentation.date.drilldown;

import java.time.LocalDateTime;
import javax.persistence.Entity;
import javax.persistence.Table;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.cxbox.model.core.entity.BaseEntity;

//dateDrillDown
@Entity
@Table(name = "dateDrillDownEntity")
@Getter
@Setter
@NoArgsConstructor
public class dateDrillDownEntity extends BaseEntity {

	private LocalDateTime  customField;

}