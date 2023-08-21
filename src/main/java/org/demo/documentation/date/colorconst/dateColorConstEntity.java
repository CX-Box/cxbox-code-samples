package org.demo.documentation.date.colorconst;

import java.time.LocalDate;
import javax.persistence.Entity;
import javax.persistence.Table;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.cxbox.model.core.entity.BaseEntity;

//dateColorConst
@Entity
@Table(name = "dateColorConstEntity")
@Getter
@Setter
@NoArgsConstructor
public class dateColorConstEntity extends BaseEntity {

	private LocalDate customField;

}