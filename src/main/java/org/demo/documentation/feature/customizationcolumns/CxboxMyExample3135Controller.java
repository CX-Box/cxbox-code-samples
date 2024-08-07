package org.demo.documentation.feature.customizationcolumns;

import lombok.Getter;
import org.cxbox.api.data.BcIdentifier;
import org.cxbox.core.crudma.bc.EnumBcIdentifier;
import org.cxbox.core.crudma.bc.impl.AbstractEnumBcSupplier;
import org.cxbox.core.crudma.bc.impl.BcDescription;
import org.demo.documentation.feature.customizationcolumns.forfields.MyEntity3135InlinePickPickService;
import org.demo.documentation.feature.customizationcolumns.forfields.MyEntity3135MultiHoverMultivalueService;
import org.demo.documentation.feature.customizationcolumns.forfields.MyEntity3135MultiMultivalueService;
import org.demo.documentation.feature.customizationcolumns.forfields.MyEntity3135PickPickService;
import org.springframework.stereotype.Component;

@Getter
public enum CxboxMyExample3135Controller implements EnumBcIdentifier {

    // @formatter:on

    myexample3135(MyExample3135Service.class), myEntity3135MultiAssocListPopup(myexample3135, MyEntity3135MultiMultivalueService.class),
    myEntity3135PickPickListPopup(myexample3135, MyEntity3135PickPickService.class),
    myEntity3135InlinePickPickListPopup(myexample3135, MyEntity3135InlinePickPickService.class),
    myEntity3135MultiHoverAssocListPopup(myexample3135, MyEntity3135MultiHoverMultivalueService.class);

    // @formatter:on

    public static final EnumBcIdentifier.Holder<CxboxMyExample3135Controller> Holder = new Holder<>(
            CxboxMyExample3135Controller.class);

    private final BcDescription bcDescription;

    CxboxMyExample3135Controller(String parentName, Class<?> serviceClass, boolean refresh) {
        this.bcDescription = buildDescription(parentName, serviceClass, refresh);
    }

    CxboxMyExample3135Controller(String parentName, Class<?> serviceClass) {
        this(parentName, serviceClass, false);
    }

    CxboxMyExample3135Controller(BcIdentifier parent, Class<?> serviceClass, boolean refresh) {
        this(parent == null ? null : parent.getName(), serviceClass, refresh);
    }

    CxboxMyExample3135Controller(BcIdentifier parent, Class<?> serviceClass) {
        this(parent, serviceClass, false);
    }

    CxboxMyExample3135Controller(Class<?> serviceClass, boolean refresh) {
        this((String) null, serviceClass, refresh);
    }

    CxboxMyExample3135Controller(Class<?> serviceClass) {
        this((String) null, serviceClass, false);
    }

    @Component
    public static class BcSupplier extends AbstractEnumBcSupplier<CxboxMyExample3135Controller> {

        public BcSupplier() {
            super(CxboxMyExample3135Controller.Holder);
        }

    }

}