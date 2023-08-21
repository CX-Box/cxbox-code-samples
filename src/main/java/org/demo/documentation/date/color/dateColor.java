package org.demo.documentation.date.color;

import java.time.LocalDate;
import javax.persistence.Entity;
import javax.persistence.Table;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.cxbox.model.core.entity.BaseEntity;

//dateColor
@Entity
@Table(name = "dateColor")
@Getter
@Setter
@NoArgsConstructor
public class dateColor extends BaseEntity {

	private LocalDate customField;

}