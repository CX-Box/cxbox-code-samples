package org.demo.documentation.microservice;

import lombok.RequiredArgsConstructor;
import org.cxbox.core.controller.param.QueryParameters;
import org.cxbox.core.crudma.bc.BusinessComponent;
import org.cxbox.core.dao.AnySourceBaseDAO;
import org.cxbox.core.dao.impl.AbstractAnySourceBaseDAO;
import org.springframework.data.domain.Page;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
@RequiredArgsConstructor
public class MyEntity3800Dao extends AbstractAnySourceBaseDAO<MyEntity3800OutServiceDTO> implements AnySourceBaseDAO<MyEntity3800OutServiceDTO> {

	private final MyEntity3800Client myEntity3800Client;

	@Override
	public String getId(final MyEntity3800OutServiceDTO entity) {
		return entity.getId();
	}

	@Override
	public void setId(final String id, final MyEntity3800OutServiceDTO entity) {
		entity.setId(id);
	}

	@Override
	public MyEntity3800OutServiceDTO getByIdIgnoringFirstLevelCache(final BusinessComponent bc) {
		return myEntity3800Client.getOne(bc.getIdAsLong()).getBody();
	}

	@Override
	public void delete(BusinessComponent bc) {

	}

	@Override
	public Page<MyEntity3800OutServiceDTO> getList(final BusinessComponent bc, final QueryParameters queryParameters) {
		return myEntity3800Client.getAll(bc).getBody();
	}

	@Override
	public MyEntity3800OutServiceDTO update(BusinessComponent bc, MyEntity3800OutServiceDTO entity) {
		return null;
	}

	@Override
	public MyEntity3800OutServiceDTO create(BusinessComponent bc, MyEntity3800OutServiceDTO entity) {
		return null;
	}


}
