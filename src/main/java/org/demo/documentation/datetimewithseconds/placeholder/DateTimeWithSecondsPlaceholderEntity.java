package org.demo.documentation.datetimewithseconds.placeholder;

import java.time.LocalDateTime;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.cxbox.model.core.entity.BaseEntity;

//dateTimeWithSecondsPlaceholder
@Entity
@Table(name = "DateTimeWithSecondsPlaceholderEntity")
@Getter
@Setter
@NoArgsConstructor
public class DateTimeWithSecondsPlaceholderEntity extends BaseEntity {


	@Column
	private LocalDateTime customField;

}