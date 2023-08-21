package org.demo.documentation.date.basic;

import java.time.LocalDate;
import javax.persistence.Entity;
import javax.persistence.Table;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.cxbox.model.core.entity.BaseEntity;

//dateBasic

@Entity
@Table(name = "DateBasic")
@Getter
@Setter
@NoArgsConstructor
public class DateBasic extends BaseEntity {

	private LocalDate customField;

}