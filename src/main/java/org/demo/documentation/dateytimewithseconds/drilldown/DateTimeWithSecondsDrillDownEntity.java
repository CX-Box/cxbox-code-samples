package org.demo.documentation.dateytimewithseconds.drilldown;

import java.time.LocalDateTime;
import javax.persistence.Entity;
import javax.persistence.Table;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.cxbox.model.core.entity.BaseEntity;

//dateTimeWithSecondsDrillDown
@Entity
@Table(name = "DateTimeWithSecondsDrillDownEntity")
@Getter
@Setter
@NoArgsConstructor
public class DateTimeWithSecondsDrillDownEntity extends BaseEntity {

	private LocalDateTime customField;

}