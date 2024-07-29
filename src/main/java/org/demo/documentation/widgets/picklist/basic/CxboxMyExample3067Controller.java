package org.demo.documentation.widgets.picklist.basic;

import lombok.Getter;
import org.cxbox.api.data.BcIdentifier;
import org.cxbox.core.crudma.bc.EnumBcIdentifier;
import org.cxbox.core.crudma.bc.impl.AbstractEnumBcSupplier;
import org.cxbox.core.crudma.bc.impl.BcDescription;
import org.springframework.stereotype.Component;

@Getter
public enum CxboxMyExample3067Controller implements EnumBcIdentifier {

    // @formatter:on

    myexample3067(MyExample3067Service.class), myEntity3067PickPickListPopup(myexample3067, MyEntity3067PickPickService.class);

    // @formatter:on

    public static final EnumBcIdentifier.Holder<CxboxMyExample3067Controller> Holder = new Holder<>(
            CxboxMyExample3067Controller.class);

    private final BcDescription bcDescription;

    CxboxMyExample3067Controller(String parentName, Class<?> serviceClass, boolean refresh) {
        this.bcDescription = buildDescription(parentName, serviceClass, refresh);
    }

    CxboxMyExample3067Controller(String parentName, Class<?> serviceClass) {
        this(parentName, serviceClass, false);
    }

    CxboxMyExample3067Controller(BcIdentifier parent, Class<?> serviceClass, boolean refresh) {
        this(parent == null ? null : parent.getName(), serviceClass, refresh);
    }

    CxboxMyExample3067Controller(BcIdentifier parent, Class<?> serviceClass) {
        this(parent, serviceClass, false);
    }

    CxboxMyExample3067Controller(Class<?> serviceClass, boolean refresh) {
        this((String) null, serviceClass, refresh);
    }

    CxboxMyExample3067Controller(Class<?> serviceClass) {
        this((String) null, serviceClass, false);
    }

    @Component
    public static class BcSupplier extends AbstractEnumBcSupplier<CxboxMyExample3067Controller> {

        public BcSupplier() {
            super(CxboxMyExample3067Controller.Holder);
        }

    }

}