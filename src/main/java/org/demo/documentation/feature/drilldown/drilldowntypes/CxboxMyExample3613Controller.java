package org.demo.documentation.feature.drilldown.drilldowntypes;

import lombok.Getter;
import org.cxbox.api.data.BcIdentifier;
import org.cxbox.core.crudma.bc.EnumBcIdentifier;
import org.cxbox.core.crudma.bc.impl.AbstractEnumBcSupplier;
import org.cxbox.core.crudma.bc.impl.BcDescription;
import org.springframework.stereotype.Component;

@Getter
public enum CxboxMyExample3613Controller implements EnumBcIdentifier {

    // @formatter:on

    myexample3613(MyExample3613Service.class);

    // @formatter:on

    public static final EnumBcIdentifier.Holder<CxboxMyExample3613Controller> Holder = new Holder<>(
            CxboxMyExample3613Controller.class);

    private final BcDescription bcDescription;

    CxboxMyExample3613Controller(String parentName, Class<?> serviceClass, boolean refresh) {
        this.bcDescription = buildDescription(parentName, serviceClass, refresh);
    }

    CxboxMyExample3613Controller(String parentName, Class<?> serviceClass) {
        this(parentName, serviceClass, false);
    }

    CxboxMyExample3613Controller(BcIdentifier parent, Class<?> serviceClass, boolean refresh) {
        this(parent == null ? null : parent.getName(), serviceClass, refresh);
    }

    CxboxMyExample3613Controller(BcIdentifier parent, Class<?> serviceClass) {
        this(parent, serviceClass, false);
    }

    CxboxMyExample3613Controller(Class<?> serviceClass, boolean refresh) {
        this((String) null, serviceClass, refresh);
    }

    CxboxMyExample3613Controller(Class<?> serviceClass) {
        this((String) null, serviceClass, false);
    }

    @Component
    public static class BcSupplier extends AbstractEnumBcSupplier<CxboxMyExample3613Controller> {

        public BcSupplier() {
            super(CxboxMyExample3613Controller.Holder);
        }

    }

}