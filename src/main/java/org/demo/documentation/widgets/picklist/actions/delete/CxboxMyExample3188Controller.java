package org.demo.documentation.widgets.picklist.actions.delete;

import lombok.Getter;
import org.cxbox.api.data.BcIdentifier;
import org.cxbox.core.crudma.bc.EnumBcIdentifier;
import org.cxbox.core.crudma.bc.impl.AbstractEnumBcSupplier;
import org.cxbox.core.crudma.bc.impl.BcDescription;
import org.demo.documentation.widgets.picklist.actions.delete.forpicklistpopup.MyEntity3188PickPickService;
import org.springframework.stereotype.Component;

@Getter
public enum CxboxMyExample3188Controller implements EnumBcIdentifier {

    // @formatter:on

    myexample3188(MyExample3188Service.class), myEntity3188PickPick(myexample3188, MyEntity3188PickPickService.class);

    // @formatter:on

    public static final EnumBcIdentifier.Holder<CxboxMyExample3188Controller> Holder = new Holder<>(
            CxboxMyExample3188Controller.class);

    private final BcDescription bcDescription;

    CxboxMyExample3188Controller(String parentName, Class<?> serviceClass, boolean refresh) {
        this.bcDescription = buildDescription(parentName, serviceClass, refresh);
    }

    CxboxMyExample3188Controller(String parentName, Class<?> serviceClass) {
        this(parentName, serviceClass, false);
    }

    CxboxMyExample3188Controller(BcIdentifier parent, Class<?> serviceClass, boolean refresh) {
        this(parent == null ? null : parent.getName(), serviceClass, refresh);
    }

    CxboxMyExample3188Controller(BcIdentifier parent, Class<?> serviceClass) {
        this(parent, serviceClass, false);
    }

    CxboxMyExample3188Controller(Class<?> serviceClass, boolean refresh) {
        this((String) null, serviceClass, refresh);
    }

    CxboxMyExample3188Controller(Class<?> serviceClass) {
        this((String) null, serviceClass, false);
    }

    @Component
    public static class BcSupplier extends AbstractEnumBcSupplier<CxboxMyExample3188Controller> {

        public BcSupplier() {
            super(CxboxMyExample3188Controller.Holder);
        }

    }

}