package org.demo.documentation.dateytimewithseconds.filtration;

import java.time.LocalDateTime;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.cxbox.model.core.entity.BaseEntity;

//dateTimeWithSecondsFiltration
@Entity
@Table(name = "DateTimeWithSecondsFiltrationEntity")
@Getter
@Setter
@NoArgsConstructor
public class DateTimeWithSecondsFiltrationEntity extends BaseEntity {


	@Column
	private LocalDateTime customField;

}