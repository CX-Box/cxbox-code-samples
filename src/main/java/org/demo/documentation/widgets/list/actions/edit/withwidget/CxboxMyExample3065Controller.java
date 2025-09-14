package org.demo.documentation.widgets.list.actions.edit.withwidget;

import lombok.Getter;
import org.cxbox.api.data.BcIdentifier;
import org.cxbox.core.crudma.bc.EnumBcIdentifier;
import org.cxbox.core.crudma.bc.impl.AbstractEnumBcSupplier;
import org.cxbox.core.crudma.bc.impl.BcDescription;
import org.springframework.stereotype.Component;

@Getter
public enum CxboxMyExample3065Controller implements EnumBcIdentifier {



    myexample3065(MyExample3065Service.class), applicationEntityPick0(myexample3065, ApplicationEntityPick0Service.class), applicationEntityPick(myexample3065, ApplicationEntityPickService.class), dateBasicPick(myexample3065, DateBasicPickService.class);



    public static final EnumBcIdentifier.Holder<CxboxMyExample3065Controller> Holder = new Holder<>(
            CxboxMyExample3065Controller.class);

    private final BcDescription bcDescription;

    CxboxMyExample3065Controller(String parentName, Class<?> serviceClass, boolean refresh) {
        this.bcDescription = buildDescription(parentName, serviceClass, refresh);
    }

    CxboxMyExample3065Controller(String parentName, Class<?> serviceClass) {
        this(parentName, serviceClass, false);
    }

    CxboxMyExample3065Controller(BcIdentifier parent, Class<?> serviceClass, boolean refresh) {
        this(parent == null ? null : parent.getName(), serviceClass, refresh);
    }

    CxboxMyExample3065Controller(BcIdentifier parent, Class<?> serviceClass) {
        this(parent, serviceClass, false);
    }

    CxboxMyExample3065Controller(Class<?> serviceClass, boolean refresh) {
        this((String) null, serviceClass, refresh);
    }

    CxboxMyExample3065Controller(Class<?> serviceClass) {
        this((String) null, serviceClass, false);
    }

    @Component
    public static class BcSupplier extends AbstractEnumBcSupplier<CxboxMyExample3065Controller> {

        public BcSupplier() {
            super(CxboxMyExample3065Controller.Holder);
        }

    }

}