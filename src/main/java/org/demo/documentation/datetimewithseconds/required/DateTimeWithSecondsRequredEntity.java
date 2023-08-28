package org.demo.documentation.datetimewithseconds.required;

import java.time.LocalDateTime;
import javax.persistence.Entity;
import javax.persistence.Table;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.cxbox.model.core.entity.BaseEntity;

//dateTimeWithSecondsRequred
@Entity
@Table(name = "DateTimeWithSecondsRequredEntity")
@Getter
@Setter
@NoArgsConstructor
public class DateTimeWithSecondsRequredEntity extends BaseEntity {

	private LocalDateTime customField;

}