package org.demo.documentation.fields.date.filtration;

import java.time.LocalDateTime;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Table;
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