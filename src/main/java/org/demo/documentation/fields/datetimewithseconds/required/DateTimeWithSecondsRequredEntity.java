package org.demo.documentation.fields.datetimewithseconds.required;

import jakarta.persistence.Entity;
import jakarta.persistence.Table;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.cxbox.model.core.entity.BaseEntity;

import java.time.LocalDateTime;

//dateTimeWithSecondsRequred
@Entity
@Table(name = "DateTimeWithSecondsRequredEntity")
@Getter
@Setter
@NoArgsConstructor
public class DateTimeWithSecondsRequredEntity extends BaseEntity {

	private LocalDateTime customField;

}