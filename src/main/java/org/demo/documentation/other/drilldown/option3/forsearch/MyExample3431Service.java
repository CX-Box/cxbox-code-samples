package org.demo.documentation.other.drilldown.option3.forsearch;

import lombok.Getter;
import lombok.RequiredArgsConstructor;
import org.cxbox.core.crudma.bc.BusinessComponent;
import org.cxbox.core.crudma.impl.VersionAwareResponseService;
import org.cxbox.core.dto.rowmeta.ActionResultDTO;
import org.cxbox.core.dto.rowmeta.CreateResult;
import org.cxbox.core.service.action.ActionScope;
import org.cxbox.core.service.action.Actions;
import org.cxbox.core.util.session.SessionService;
import org.demo.entity.core.User;
import org.demo.entity.core.User_;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.stereotype.Service;

import java.util.Optional;


@SuppressWarnings("java:S1170")
@RequiredArgsConstructor
@Service
public class MyExample3431Service extends VersionAwareResponseService<MyExample3431DTO, User> {


	@Getter(onMethod_ = @Override)
	private final Class<MyExample3431Meta> meta = MyExample3431Meta.class;
	@Autowired
	private MyEntity3431Repository contractFilterParametersRepository;

	@Autowired
	private SessionService sessionService;

	@Override
	protected CreateResult<MyExample3431DTO> doCreateEntity(final User entity, final BusinessComponent bc) {
		throw new UnsupportedOperationException();
	}

	private ActionResultDTO<MyExample3431DTO> clearFilter(final BusinessComponent bc, final MyExample3431DTO data) {
		getContractFilterParametersByUser().ifPresent(parameters -> contractFilterParametersRepository.delete(parameters));
		return new ActionResultDTO<>();
	}

	@Override
	public Actions<MyExample3431DTO> getActions() {
		return Actions.<MyExample3431DTO>builder()
				.action(act -> act
						.action("applyFilter", "Применить")
						.available(bc -> true)
						.scope(ActionScope.BC)
						.invoker((bc, data) -> new ActionResultDTO<>())
				)
				.action(act -> act
						.action("clearFilter", "Сбросить")
						.scope(ActionScope.BC)
						.available(bc -> true)
						.invoker(this::clearFilter)
				)
				.build();
	}

	@Override
	protected Specification<User> getSpecification(final BusinessComponent bc) {
		final Specification<User> filterSpecification = (root, cq, cb) -> cb.equal(
				root.get(User_.id),
				sessionService.getSessionUser().getId()
		);
		return super.getSpecification(bc).and(filterSpecification);

	}

	@Override
	protected ActionResultDTO<MyExample3431DTO> doUpdateEntity(final User entity, final MyExample3431DTO data, final BusinessComponent bc) {
		MyEntity3431 filter = contractFilterParametersRepository.findByUserId(sessionService.getSessionUser().getId()).orElse(null);
		if (filter == null) {
			filter = new MyEntity3431();
			filter.setUserId(sessionService.getSessionUser().getId());
			contractFilterParametersRepository.save(filter);
		}

		if (data.isFieldChanged(MyExample3431DTO_.customField)) {
			filter.setCustomField(data.getCustomField());
		}

		return new ActionResultDTO<>(entityToDto(bc, entity));
	}

	@Override
	protected MyExample3431DTO entityToDto(final BusinessComponent bc, final User entity) {
		final MyExample3431DTO dto = new MyExample3431DTO(getContractFilterParametersByUser().orElse(new MyEntity3431()));
		dto.setId(String.valueOf(entity.getId()));
		dto.setVstamp(-1);
		return dto;
	}

	private Optional<MyEntity3431> getContractFilterParametersByUser() {
		return contractFilterParametersRepository.findByUserId(sessionService.getSessionUser().getId());
	}


}