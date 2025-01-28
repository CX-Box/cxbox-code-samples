package org.demo.documentation.widgets.picklist.actions.cancelcreate;

import lombok.Getter;
import org.cxbox.api.data.BcIdentifier;
import org.cxbox.core.crudma.bc.EnumBcIdentifier;
import org.cxbox.core.crudma.bc.impl.AbstractEnumBcSupplier;
import org.cxbox.core.crudma.bc.impl.BcDescription;
import org.demo.documentation.widgets.picklist.actions.cancelcreate.forpicklistpopup.MyEntity3198PickPickService;
import org.springframework.stereotype.Component;

@Getter
public enum CxboxMyExample3198Controller implements EnumBcIdentifier {

    // @formatter:on

    myexample3198(MyExample3198Service.class),
        myEntity3198PickPick(myexample3198, MyEntity3198PickPickService.class);

    // @formatter:on

    public static final EnumBcIdentifier.Holder<CxboxMyExample3198Controller> Holder = new Holder<>(
            CxboxMyExample3198Controller.class);

    private final BcDescription bcDescription;

    CxboxMyExample3198Controller(String parentName, Class<?> serviceClass, boolean refresh) {
        this.bcDescription = buildDescription(parentName, serviceClass, refresh);
    }

    CxboxMyExample3198Controller(String parentName, Class<?> serviceClass) {
        this(parentName, serviceClass, false);
    }

    CxboxMyExample3198Controller(BcIdentifier parent, Class<?> serviceClass, boolean refresh) {
        this(parent == null ? null : parent.getName(), serviceClass, refresh);
    }

    CxboxMyExample3198Controller(BcIdentifier parent, Class<?> serviceClass) {
        this(parent, serviceClass, false);
    }

    CxboxMyExample3198Controller(Class<?> serviceClass, boolean refresh) {
        this((String) null, serviceClass, refresh);
    }

    CxboxMyExample3198Controller(Class<?> serviceClass) {
        this((String) null, serviceClass, false);
    }

    @Component
    public static class BcSupplier extends AbstractEnumBcSupplier<CxboxMyExample3198Controller> {

        public BcSupplier() {
            super(CxboxMyExample3198Controller.Holder);
        }

    }

}