package org.demo.documentation.datetime.color;

import java.time.LocalDateTime;
import javax.persistence.Entity;
import javax.persistence.Table;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.cxbox.model.core.entity.BaseEntity;

//dateTimeColorCalc
@Entity
@Table(name = "DateTimeColorCalc")
@Getter
@Setter
@NoArgsConstructor
public class DateTimeColorCalc extends BaseEntity {

	private LocalDateTime customField;

}