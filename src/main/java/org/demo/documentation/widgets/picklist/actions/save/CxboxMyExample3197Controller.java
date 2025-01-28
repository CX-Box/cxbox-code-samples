package org.demo.documentation.widgets.picklist.actions.save;

import lombok.Getter;
import org.cxbox.api.data.BcIdentifier;
import org.cxbox.core.crudma.bc.EnumBcIdentifier;
import org.cxbox.core.crudma.bc.impl.AbstractEnumBcSupplier;
import org.cxbox.core.crudma.bc.impl.BcDescription;
import org.demo.documentation.widgets.picklist.actions.save.forpicklistpopup.MyEntity3197PickPickService;
import org.springframework.stereotype.Component;

@Getter
public enum CxboxMyExample3197Controller implements EnumBcIdentifier {

    // @formatter:on

    myexample3197(MyExample3197Service.class), myEntity3197PickPick(myexample3197, MyEntity3197PickPickService.class);

    // @formatter:on

    public static final EnumBcIdentifier.Holder<CxboxMyExample3197Controller> Holder = new Holder<>(
            CxboxMyExample3197Controller.class);

    private final BcDescription bcDescription;

    CxboxMyExample3197Controller(String parentName, Class<?> serviceClass, boolean refresh) {
        this.bcDescription = buildDescription(parentName, serviceClass, refresh);
    }

    CxboxMyExample3197Controller(String parentName, Class<?> serviceClass) {
        this(parentName, serviceClass, false);
    }

    CxboxMyExample3197Controller(BcIdentifier parent, Class<?> serviceClass, boolean refresh) {
        this(parent == null ? null : parent.getName(), serviceClass, refresh);
    }

    CxboxMyExample3197Controller(BcIdentifier parent, Class<?> serviceClass) {
        this(parent, serviceClass, false);
    }

    CxboxMyExample3197Controller(Class<?> serviceClass, boolean refresh) {
        this((String) null, serviceClass, refresh);
    }

    CxboxMyExample3197Controller(Class<?> serviceClass) {
        this((String) null, serviceClass, false);
    }

    @Component
    public static class BcSupplier extends AbstractEnumBcSupplier<CxboxMyExample3197Controller> {

        public BcSupplier() {
            super(CxboxMyExample3197Controller.Holder);
        }

    }

}