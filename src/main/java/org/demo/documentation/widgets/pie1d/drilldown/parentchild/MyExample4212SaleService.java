package org.demo.documentation.widgets.pie1d.drilldown.parentchild;

import lombok.Getter;
import lombok.RequiredArgsConstructor;
import org.cxbox.core.crudma.bc.BusinessComponent;
import org.cxbox.core.crudma.impl.VersionAwareResponseService;
import org.cxbox.core.dto.rowmeta.ActionResultDTO;
import org.cxbox.core.dto.rowmeta.CreateResult;
import org.demo.documentation.widgets.pie1d.drilldown.data.MyExample4219SaleDTO;
import org.demo.documentation.widgets.pie1d.drilldown.data.MyExample4219SaleMeta;
import org.demo.documentation.widgets.pie1d.data.MyEntityRingData;
import org.demo.documentation.widgets.pie1d.data.MyEntityRingData_;
import org.demo.documentation.widgets.pie1d.data.MyEntityRingRepository;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.stereotype.Service;

@SuppressWarnings("java:S1170")
@RequiredArgsConstructor
@Service
public class MyExample4212SaleService extends VersionAwareResponseService<MyExample4219SaleDTO, MyEntityRingData> {

	private final MyEntityRingRepository repository;

	@Getter(onMethod_ = @Override)
	private final Class<MyExample4219SaleMeta> meta = MyExample4219SaleMeta.class;

	// --8<-- [start:getParentSpecification]
	/** The id of a segment is the id of a sale of the client: the list shows all sales of this client. */
	@Override
	protected Specification<MyEntityRingData> getParentSpecification(BusinessComponent bc) {
		String client = repository.findById(bc.getParentIdAsLong()).map(MyEntityRingData::getCustomField).orElse(null);
		return (root, cq, cb) -> cb.equal(root.get(MyEntityRingData_.customField), client);
	}
	// --8<-- [end:getParentSpecification]

	@Override
	protected CreateResult<MyExample4219SaleDTO> doCreateEntity(MyEntityRingData entity, BusinessComponent bc) {
		throw new IllegalStateException();
	}

	@Override
	protected ActionResultDTO<MyExample4219SaleDTO> doUpdateEntity(MyEntityRingData entity, MyExample4219SaleDTO data,
			BusinessComponent bc) {
		throw new IllegalStateException();
	}

}
