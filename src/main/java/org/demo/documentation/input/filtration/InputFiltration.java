package org.demo.documentation.input.filtration;


import jakarta.persistence.Entity;
import jakarta.persistence.Table;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.cxbox.model.core.entity.BaseEntity;

//InputFiltration
@Entity
@Table(name = "InputFiltration")
@Getter
@Setter
@NoArgsConstructor
public class InputFiltration extends BaseEntity {

	private String customField;

	private String brand;

}
