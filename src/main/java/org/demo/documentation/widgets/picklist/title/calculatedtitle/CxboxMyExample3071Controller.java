package org.demo.documentation.widgets.picklist.title.calculatedtitle;

import lombok.Getter;
import org.cxbox.api.data.BcIdentifier;
import org.cxbox.core.crudma.bc.EnumBcIdentifier;
import org.cxbox.core.crudma.bc.impl.AbstractEnumBcSupplier;
import org.cxbox.core.crudma.bc.impl.BcDescription;
import org.springframework.stereotype.Component;

@Getter
public enum CxboxMyExample3071Controller implements EnumBcIdentifier {

    // @formatter:on

    myexample3071(MyExample3071Service.class), myEntity3071PickPickListPopup(myexample3071, MyEntity3071PickPickService.class);

    // @formatter:on

    public static final EnumBcIdentifier.Holder<CxboxMyExample3071Controller> Holder = new Holder<>(
            CxboxMyExample3071Controller.class);

    private final BcDescription bcDescription;

    CxboxMyExample3071Controller(String parentName, Class<?> serviceClass, boolean refresh) {
        this.bcDescription = buildDescription(parentName, serviceClass, refresh);
    }

    CxboxMyExample3071Controller(String parentName, Class<?> serviceClass) {
        this(parentName, serviceClass, false);
    }

    CxboxMyExample3071Controller(BcIdentifier parent, Class<?> serviceClass, boolean refresh) {
        this(parent == null ? null : parent.getName(), serviceClass, refresh);
    }

    CxboxMyExample3071Controller(BcIdentifier parent, Class<?> serviceClass) {
        this(parent, serviceClass, false);
    }

    CxboxMyExample3071Controller(Class<?> serviceClass, boolean refresh) {
        this((String) null, serviceClass, refresh);
    }

    CxboxMyExample3071Controller(Class<?> serviceClass) {
        this((String) null, serviceClass, false);
    }

    @Component
    public static class BcSupplier extends AbstractEnumBcSupplier<CxboxMyExample3071Controller> {

        public BcSupplier() {
            super(CxboxMyExample3071Controller.Holder);
        }

    }

}