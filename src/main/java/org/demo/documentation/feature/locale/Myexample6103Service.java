package org.demo.documentation.feature.locale;


import lombok.Getter;
import lombok.RequiredArgsConstructor;
import org.cxbox.api.util.i18n.LocalizationFormatter;
import org.cxbox.core.crudma.bc.BusinessComponent;
import org.cxbox.core.crudma.impl.VersionAwareResponseService;
import org.cxbox.core.dto.rowmeta.ActionResultDTO;
import org.cxbox.core.dto.rowmeta.CreateResult;
import org.cxbox.core.dto.rowmeta.PostAction;
import org.cxbox.core.exception.BusinessException;
import org.cxbox.core.service.action.Actions;
import org.demo.documentation.feature.locale.enums.FieldOfActivityEnum;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.stereotype.Service;
import java.time.LocalDateTime;
import java.util.stream.Collectors;

@Service
@Getter
@RequiredArgsConstructor
public class Myexample6103Service extends VersionAwareResponseService<Myexample6103DTO, Myexample6103> {

	@Getter(onMethod_ = @Override)
	private final Class<Myexample6103MetaBuilder> meta = Myexample6103MetaBuilder.class;

	private final Myexample6103Repository myexample6103Repository;


	@Override
	protected Specification<Myexample6103> getSpecification(BusinessComponent bc) {
		return super.getSpecification(bc);
	}

	@Override
	protected CreateResult<Myexample6103DTO> doCreateEntity(Myexample6103 entity, BusinessComponent bc) {
		return new CreateResult<>(entityToDto(bc, myexample6103Repository.save(entity)));
	}

	// --8<-- [start:doUpdateEntity]
	@Override
	protected ActionResultDTO<Myexample6103DTO> doUpdateEntity(Myexample6103 entity, Myexample6103DTO data, BusinessComponent bc) {

		if (data.isFieldChanged(Myexample6103DTO_.dateStart)) {
			LocalDateTime sysdate = LocalDateTime.now();
			if (data.getDateStart() != null && sysdate.compareTo(data.getDateStart()) > 0) {
				throw new BusinessException().addPopup(LocalizationFormatter.uiMessage("business.exception.less.current.date"));
			}
			entity.setDateStart(data.getDateStart());
		}
		setIfChanged(data, Myexample6103DTO_.status, entity::setStatus);
		setIfChanged(data, Myexample6103DTO_.importance, entity::setImportance);
		setIfChanged(data, Myexample6103DTO_.address, entity::setAddress);
		if (data.isFieldChanged(Myexample6103DTO_.fieldOfActivity)) {
			entity.setFieldOfActivity(
					data.getFieldOfActivity().getValues()
							.stream()
							.map(v -> FieldOfActivityEnum.getByValue(v.getValue()))
							.collect(Collectors.toSet()));
		}
		setIfChanged(data, Myexample6103DTO_.fullName, entity::setFullName);
		return new ActionResultDTO<>(entityToDto(bc, myexample6103Repository.save(entity)))
				.setAction(PostAction.refreshBc(bc));
	}
 	// --8<-- [end:doUpdateEntity]

	// --8<-- [start:getActions]
	@Override
	public Actions<Myexample6103DTO> getActions() {
		return Actions.<Myexample6103DTO>builder()
				.save(sv -> sv.text(LocalizationFormatter.uiMessage("action.save")))
				.cancelCreate(ccr -> ccr.text(LocalizationFormatter.uiMessage("action.cancel")).available(bc -> true))
				.create(crt -> crt.text(LocalizationFormatter.uiMessage("action.add")))
				.delete(dlt -> dlt.text(LocalizationFormatter.uiMessage("action.delete")))
				.build();
	}
	// --8<-- [end:getActions]

}
