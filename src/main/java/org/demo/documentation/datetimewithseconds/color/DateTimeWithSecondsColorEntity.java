package org.demo.documentation.datetimewithseconds.color;

import java.time.LocalDateTime;
import javax.persistence.Entity;
import javax.persistence.Table;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.cxbox.model.core.entity.BaseEntity;

//dateTimeWithSecondsColor
@Entity
@Table(name = "DateTimeWithSecondsColorEntity")
@Getter
@Setter
@NoArgsConstructor
public class DateTimeWithSecondsColorEntity extends BaseEntity {

	private LocalDateTime customField;

}