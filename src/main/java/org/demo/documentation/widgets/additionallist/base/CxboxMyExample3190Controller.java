package org.demo.documentation.widgets.additionallist.base;

import lombok.Getter;
import org.cxbox.api.data.BcIdentifier;
import org.cxbox.core.crudma.bc.EnumBcIdentifier;
import org.cxbox.core.crudma.bc.impl.AbstractEnumBcSupplier;
import org.cxbox.core.crudma.bc.impl.BcDescription;
import org.demo.documentation.widgets.additionallist.base.allfields.MyExample3191Service;
import org.demo.documentation.widgets.additionallist.base.onefield.MyExample3190Service;
import org.springframework.stereotype.Component;

@Getter
public enum CxboxMyExample3190Controller implements EnumBcIdentifier {

    myexample3191(MyExample3191Service.class),
    myexample3190(MyExample3190Service .class);

    public static final EnumBcIdentifier.Holder<CxboxMyExample3190Controller> Holder = new Holder<>(
            CxboxMyExample3190Controller.class);

    private final BcDescription bcDescription;

    CxboxMyExample3190Controller(String parentName, Class<?> serviceClass, boolean refresh) {
        this.bcDescription = buildDescription(parentName, serviceClass, refresh);
    }

    CxboxMyExample3190Controller(String parentName, Class<?> serviceClass) {
        this(parentName, serviceClass, false);
    }

    CxboxMyExample3190Controller(BcIdentifier parent, Class<?> serviceClass, boolean refresh) {
        this(parent == null ? null : parent.getName(), serviceClass, refresh);
    }

    CxboxMyExample3190Controller(BcIdentifier parent, Class<?> serviceClass) {
        this(parent, serviceClass, false);
    }

    CxboxMyExample3190Controller(Class<?> serviceClass, boolean refresh) {
        this((String) null, serviceClass, refresh);
    }

    CxboxMyExample3190Controller(Class<?> serviceClass) {
        this((String) null, serviceClass, false);
    }

    @Component
    public static class BcSupplier extends AbstractEnumBcSupplier<CxboxMyExample3190Controller> {

        public BcSupplier() {
            super(CxboxMyExample3190Controller.Holder);
        }

    }

}