package org.demo.documentation.dateytimewithseconds.ro;

import java.time.LocalDateTime;
import javax.persistence.Entity;
import javax.persistence.Table;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.cxbox.model.core.entity.BaseEntity;

//dateTimeWithSecondsCreateEdit
@Entity
@Table(name = "DateTimeWithSecondsCreateEditEntity")
@Getter
@Setter
@NoArgsConstructor
public class DateTimeWithSecondsCreateEditEntity extends BaseEntity {

	private LocalDateTime customField;

}