package org.demo.documentation.date.filtration;

import java.time.LocalDate;
import java.time.LocalDateTime;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.cxbox.model.core.entity.BaseEntity;

//dateFiltration
@Entity
@Table(name = "dateFiltrationEntity")
@Getter
@Setter
@NoArgsConstructor
public class dateFiltrationEntity extends BaseEntity {

	private LocalDate customField;

	@Column
	private LocalDateTime customField2;

}