package org.demo.documentation.widgets.picklist.customizationcolumns;

import lombok.Getter;
import org.cxbox.api.data.BcIdentifier;
import org.cxbox.core.crudma.bc.EnumBcIdentifier;
import org.cxbox.core.crudma.bc.impl.AbstractEnumBcSupplier;
import org.cxbox.core.crudma.bc.impl.BcDescription;
import org.springframework.stereotype.Component;

@Getter
public enum CxboxMyExample3089Controller implements EnumBcIdentifier {

    // @formatter:on

    myexample3089(MyExample3089Service.class), myEntity3089PickPick(myexample3089, MyEntity3089PickPickService.class);

    // @formatter:on

    public static final EnumBcIdentifier.Holder<CxboxMyExample3089Controller> Holder = new Holder<>(
            CxboxMyExample3089Controller.class);

    private final BcDescription bcDescription;

    CxboxMyExample3089Controller(String parentName, Class<?> serviceClass, boolean refresh) {
        this.bcDescription = buildDescription(parentName, serviceClass, refresh);
    }

    CxboxMyExample3089Controller(String parentName, Class<?> serviceClass) {
        this(parentName, serviceClass, false);
    }

    CxboxMyExample3089Controller(BcIdentifier parent, Class<?> serviceClass, boolean refresh) {
        this(parent == null ? null : parent.getName(), serviceClass, refresh);
    }

    CxboxMyExample3089Controller(BcIdentifier parent, Class<?> serviceClass) {
        this(parent, serviceClass, false);
    }

    CxboxMyExample3089Controller(Class<?> serviceClass, boolean refresh) {
        this((String) null, serviceClass, refresh);
    }

    CxboxMyExample3089Controller(Class<?> serviceClass) {
        this((String) null, serviceClass, false);
    }

    @Component
    public static class BcSupplier extends AbstractEnumBcSupplier<CxboxMyExample3089Controller> {

        public BcSupplier() {
            super(CxboxMyExample3089Controller.Holder);
        }

    }

}