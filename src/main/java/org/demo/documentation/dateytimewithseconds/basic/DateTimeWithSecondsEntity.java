package org.demo.documentation.dateytimewithseconds.basic;

import java.time.LocalDateTime;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.cxbox.model.core.entity.BaseEntity;

//dateTimeWithSeconds
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