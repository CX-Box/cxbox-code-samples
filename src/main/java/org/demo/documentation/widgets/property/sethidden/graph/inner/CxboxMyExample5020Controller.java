package org.demo.documentation.widgets.property.sethidden.graph.inner;

import lombok.Getter;
import org.cxbox.api.data.BcIdentifier;
import org.cxbox.core.crudma.bc.EnumBcIdentifier;
import org.cxbox.core.crudma.bc.impl.AbstractEnumBcSupplier;
import org.cxbox.core.crudma.bc.impl.BcDescription;
import org.demo.documentation.widgets.property.sethidden.graph.SaleStatsProductService;
import org.springframework.stereotype.Component;

@Getter
public enum CxboxMyExample5020Controller implements EnumBcIdentifier {

    // @formatter:on
    saleStatsProduct(SaleStatsProductService.class),
    myexample5020(MyExample5020Service.class);

    // @formatter:on

    public static final Holder<CxboxMyExample5020Controller> Holder = new Holder<>(
            CxboxMyExample5020Controller.class);

    private final BcDescription bcDescription;

    CxboxMyExample5020Controller(String parentName, Class<?> serviceClass, boolean refresh) {
        this.bcDescription = buildDescription(parentName, serviceClass, refresh);
    }

    CxboxMyExample5020Controller(String parentName, Class<?> serviceClass) {
        this(parentName, serviceClass, false);
    }

    CxboxMyExample5020Controller(BcIdentifier parent, Class<?> serviceClass, boolean refresh) {
        this(parent == null ? null : parent.getName(), serviceClass, refresh);
    }

    CxboxMyExample5020Controller(BcIdentifier parent, Class<?> serviceClass) {
        this(parent, serviceClass, false);
    }

    CxboxMyExample5020Controller(Class<?> serviceClass, boolean refresh) {
        this((String) null, serviceClass, refresh);
    }

    CxboxMyExample5020Controller(Class<?> serviceClass) {
        this((String) null, serviceClass, false);
    }

    @Component
    public static class BcSupplier extends AbstractEnumBcSupplier<CxboxMyExample5020Controller> {

        public BcSupplier() {
            super(CxboxMyExample5020Controller.Holder);
        }

    }

}