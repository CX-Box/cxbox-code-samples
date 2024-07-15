package org.demo.documentation.fields.datetimewithseconds.basic;

import java.time.LocalDateTime;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Table;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.cxbox.model.core.entity.BaseEntity;

@Entity
@Table(name = "DateTimeWithSecondsEntity")
@Getter
@Setter
@NoArgsConstructor
public class DateTimeWithSecondsEntity extends BaseEntity {

	@Column
	private LocalDateTime customField;

	@Column
	private LocalDateTime customField2;

}