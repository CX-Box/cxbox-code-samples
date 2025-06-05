package org.demo.documentation.other.drilldown.option.forfilter;

import lombok.NonNull;
import lombok.RequiredArgsConstructor;
import org.cxbox.core.controller.param.QueryParameters;
import org.cxbox.core.crudma.bc.BusinessComponent;
import org.cxbox.core.dao.AnySourceBaseDAO;
import org.cxbox.core.dao.impl.AbstractAnySourceBaseDAO;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.stereotype.Service;

import java.util.*;

@Service
@RequiredArgsConstructor
public class MyEntity3424ForFilterDao extends AbstractAnySourceBaseDAO<MyExample3424ForFilterDTO> implements AnySourceBaseDAO<MyExample3424ForFilterDTO> {

    public static final int ROWS_TOTAL = 1;

    public static final String NEW_CLIENTS_ID = "0";

    @Override
    public String getId(final MyExample3424ForFilterDTO entity) {
        return entity.getId();
    }

    @Override
    public void setId(final String id, final MyExample3424ForFilterDTO entity) {
        entity.setId(id);
    }

    @Override
    public MyExample3424ForFilterDTO getByIdIgnoringFirstLevelCache(final BusinessComponent bc) {
        return getClientStats().stream().filter(s -> Objects.equals(s.getId(), bc.getId())).findFirst().orElse(null);
    }

    @Override
    public void delete(final BusinessComponent bc) {
        throw new IllegalStateException();
    }

    @Override
    public Page<MyExample3424ForFilterDTO> getList(final BusinessComponent bc, final QueryParameters queryParameters) {
        return new PageImpl<>(getClientStats());
    }

    @Override
    public MyExample3424ForFilterDTO update(BusinessComponent bc, MyExample3424ForFilterDTO entity) {
        throw new IllegalStateException();
    }

    @Override
    public MyExample3424ForFilterDTO create(final BusinessComponent bc, final MyExample3424ForFilterDTO entity) {
        throw new IllegalStateException();
    }

    @NonNull
    private  List<MyExample3424ForFilterDTO> getClientStats() {
        List<MyExample3424ForFilterDTO> result = new ArrayList<>(ROWS_TOTAL);
        MyExample3424ForFilterDTO newFilter = new MyExample3424ForFilterDTO();
        newFilter.setId(NEW_CLIENTS_ID);
        result.add(newFilter);
        return result;
    }

}
