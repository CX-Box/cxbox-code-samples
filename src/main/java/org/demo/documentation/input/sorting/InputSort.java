package org.demo.documentation.input.sorting;

import javax.persistence.Entity;
import javax.persistence.Table;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.cxbox.model.core.entity.BaseEntity;

//InputSort
@Entity
@Table(name = "InputSort")
@Getter
@Setter
@NoArgsConstructor
public class InputSort extends BaseEntity {

	private String customField;

}
