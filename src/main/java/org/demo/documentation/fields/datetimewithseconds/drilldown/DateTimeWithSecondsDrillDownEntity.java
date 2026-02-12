package org.demo.documentation.fields.datetimewithseconds.drilldown;

import jakarta.persistence.Entity;
import jakarta.persistence.Table;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.cxbox.model.core.entity.BaseEntity;

import java.time.LocalDateTime;

//dateTimeWithSecondsDrillDown
@Entity
@Table(name = "DateTimeWithSecondsDrillDownEntity")
@Getter
@Setter
@NoArgsConstructor
public class DateTimeWithSecondsDrillDownEntity extends BaseEntity {

	private LocalDateTime customField;

}