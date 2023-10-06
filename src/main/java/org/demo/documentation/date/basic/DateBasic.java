package org.demo.documentation.date.basic;

import java.time.LocalDateTime;
import java.time.LocalDateTime;
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

	private LocalDateTime customField;

}