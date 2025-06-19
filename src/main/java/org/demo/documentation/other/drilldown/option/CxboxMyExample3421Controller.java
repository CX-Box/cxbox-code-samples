package org.demo.documentation.other.drilldown.option;

import lombok.Getter;
import org.cxbox.api.data.BcIdentifier;
import org.cxbox.core.crudma.bc.EnumBcIdentifier;
import org.cxbox.core.crudma.bc.impl.AbstractEnumBcSupplier;
import org.cxbox.core.crudma.bc.impl.BcDescription;
import org.demo.documentation.other.drilldown.option.any.MyExample3424Service;
import org.demo.documentation.other.drilldown.option.forfilter.MyExample3424ForFilterDTO;
import org.demo.documentation.other.drilldown.option.forfilter.MyExample3424ForFilterService;
import org.springframework.stereotype.Component;

@Getter
public enum CxboxMyExample3421Controller implements EnumBcIdentifier {

    // @formatter:on
    myexample3424ForFilter(MyExample3424ForFilterService.class),
    myexample3424(MyExample3424Service.class),
    myexample3421(MyExample3421Service.class);

    // @formatter:on

    public static final EnumBcIdentifier.Holder<CxboxMyExample3421Controller> Holder = new Holder<>(
            CxboxMyExample3421Controller.class);

    private final BcDescription bcDescription;

    CxboxMyExample3421Controller(String parentName, Class<?> serviceClass, boolean refresh) {
        this.bcDescription = buildDescription(parentName, serviceClass, refresh);
    }

    CxboxMyExample3421Controller(String parentName, Class<?> serviceClass) {
        this(parentName, serviceClass, false);
    }

    CxboxMyExample3421Controller(BcIdentifier parent, Class<?> serviceClass, boolean refresh) {
        this(parent == null ? null : parent.getName(), serviceClass, refresh);
    }

    CxboxMyExample3421Controller(BcIdentifier parent, Class<?> serviceClass) {
        this(parent, serviceClass, false);
    }

    CxboxMyExample3421Controller(Class<?> serviceClass, boolean refresh) {
        this((String) null, serviceClass, refresh);
    }

    CxboxMyExample3421Controller(Class<?> serviceClass) {
        this((String) null, serviceClass, false);
    }

    @Component
    public static class BcSupplier extends AbstractEnumBcSupplier<CxboxMyExample3421Controller> {

        public BcSupplier() {
            super(CxboxMyExample3421Controller.Holder);
        }

    }

}