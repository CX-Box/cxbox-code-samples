package org.demo.documentation.widgets.headerwidget.showcondition.byparententity;

import lombok.Getter;
import org.cxbox.api.data.BcIdentifier;
import org.cxbox.core.crudma.bc.EnumBcIdentifier;
import org.cxbox.core.crudma.bc.impl.AbstractEnumBcSupplier;
import org.cxbox.core.crudma.bc.impl.BcDescription;
import org.demo.documentation.widgets.headerwidget.showcondition.byparententity.child.MyExample5029Service;
import org.demo.documentation.widgets.headerwidget.showcondition.byparententity.parent.MyExample5030Service;
import org.springframework.stereotype.Component;

@Getter
public enum CxboxMyExample5029Controller implements EnumBcIdentifier {

    // @formatter:on

    myexample5030(MyExample5030Service.class),
    myexample5029(myexample5030,MyExample5029Service.class);

    // @formatter:on

    public static final Holder<CxboxMyExample5029Controller> Holder = new Holder<>(
            CxboxMyExample5029Controller.class);

    private final BcDescription bcDescription;

    CxboxMyExample5029Controller(String parentName, Class<?> serviceClass, boolean refresh) {
        this.bcDescription = buildDescription(parentName, serviceClass, refresh);
    }

    CxboxMyExample5029Controller(String parentName, Class<?> serviceClass) {
        this(parentName, serviceClass, false);
    }

    CxboxMyExample5029Controller(BcIdentifier parent, Class<?> serviceClass, boolean refresh) {
        this(parent == null ? null : parent.getName(), serviceClass, refresh);
    }

    CxboxMyExample5029Controller(BcIdentifier parent, Class<?> serviceClass) {
        this(parent, serviceClass, false);
    }

    CxboxMyExample5029Controller(Class<?> serviceClass, boolean refresh) {
        this((String) null, serviceClass, refresh);
    }

    CxboxMyExample5029Controller(Class<?> serviceClass) {
        this((String) null, serviceClass, false);
    }

    @Component
    public static class BcSupplier extends AbstractEnumBcSupplier<CxboxMyExample5029Controller> {

        public BcSupplier() {
            super(CxboxMyExample5029Controller.Holder);
        }

    }

}