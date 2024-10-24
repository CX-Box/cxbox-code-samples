package org.demo.documentation.widgets.picklist.actions.create;

import lombok.Getter;
import org.cxbox.api.data.BcIdentifier;
import org.cxbox.core.crudma.bc.EnumBcIdentifier;
import org.cxbox.core.crudma.bc.impl.AbstractEnumBcSupplier;
import org.cxbox.core.crudma.bc.impl.BcDescription;
import org.demo.documentation.widgets.picklist.actions.create.inlinepicklist.MyEntity3072InlinePickPickService;
import org.demo.documentation.widgets.picklist.actions.create.picklist.MyEntity3072PickPickService;
import org.springframework.stereotype.Component;

@Getter
public enum CxboxMyExample3072Controller implements EnumBcIdentifier {



    myexample3072(MyExample3072Service.class),
    myEntity3072InlinePickPickListPopup(myexample3072, MyEntity3072InlinePickPickService.class),
    myEntity3072PickPickListPopup(myexample3072, MyEntity3072PickPickService.class);



    public static final EnumBcIdentifier.Holder<CxboxMyExample3072Controller> Holder = new Holder<>(
            CxboxMyExample3072Controller.class);

    private final BcDescription bcDescription;

    CxboxMyExample3072Controller(String parentName, Class<?> serviceClass, boolean refresh) {
        this.bcDescription = buildDescription(parentName, serviceClass, refresh);
    }

    CxboxMyExample3072Controller(String parentName, Class<?> serviceClass) {
        this(parentName, serviceClass, false);
    }

    CxboxMyExample3072Controller(BcIdentifier parent, Class<?> serviceClass, boolean refresh) {
        this(parent == null ? null : parent.getName(), serviceClass, refresh);
    }

    CxboxMyExample3072Controller(BcIdentifier parent, Class<?> serviceClass) {
        this(parent, serviceClass, false);
    }

    CxboxMyExample3072Controller(Class<?> serviceClass, boolean refresh) {
        this((String) null, serviceClass, refresh);
    }

    CxboxMyExample3072Controller(Class<?> serviceClass) {
        this((String) null, serviceClass, false);
    }

    @Component
    public static class BcSupplier extends AbstractEnumBcSupplier<CxboxMyExample3072Controller> {

        public BcSupplier() {
            super(CxboxMyExample3072Controller.Holder);
        }

    }

}