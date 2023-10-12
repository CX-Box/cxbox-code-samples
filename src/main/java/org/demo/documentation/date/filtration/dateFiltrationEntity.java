package org.demo.documentation.date.filtration;

import java.time.LocalDateTime;
import java.time.LocalDateTime;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.cxbox.model.core.entity.BaseEntity;


@Entity
@Table(name = "dateFiltrationEntity")
@Getter
@Setter
@NoArgsConstructor
public class dateFiltrationEntity extends BaseEntity {

	private LocalDateTime customField;

	@Column
	private LocalDateTime customField2;

}