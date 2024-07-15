package org.demo.documentation.fields.datetimewithseconds.drilldown;

import java.time.LocalDateTime;
import jakarta.persistence.Entity;
import jakarta.persistence.Table;
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