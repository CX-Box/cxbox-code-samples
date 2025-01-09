package org.demo.documentation.navigation.tab.typestandard.defaultview.typicalexample;

import lombok.Getter;
import org.cxbox.api.data.BcIdentifier;
import org.cxbox.core.crudma.bc.EnumBcIdentifier;
import org.cxbox.core.crudma.bc.impl.AbstractEnumBcSupplier;
import org.cxbox.core.crudma.bc.impl.BcDescription;
import org.demo.documentation.navigation.tab.typestandard.defaultview.typicalexample.child.MyExample3239Service;
import org.springframework.stereotype.Component;

@Getter
public enum CxboxMyExample3238Controller implements EnumBcIdentifier {

    

    myexample3238(MyExample3238Service.class),
    myexample3239(myexample3238, MyExample3239Service.class);

    

    public static final EnumBcIdentifier.Holder<CxboxMyExample3238Controller> Holder = new Holder<>(
            CxboxMyExample3238Controller.class);

    private final BcDescription bcDescription;

    CxboxMyExample3238Controller(String parentName, Class<?> serviceClass, boolean refresh) {
        this.bcDescription = buildDescription(parentName, serviceClass, refresh);
    }

    CxboxMyExample3238Controller(String parentName, Class<?> serviceClass) {
        this(parentName, serviceClass, false);
    }

    CxboxMyExample3238Controller(BcIdentifier parent, Class<?> serviceClass, boolean refresh) {
        this(parent == null ? null : parent.getName(), serviceClass, refresh);
    }

    CxboxMyExample3238Controller(BcIdentifier parent, Class<?> serviceClass) {
        this(parent, serviceClass, false);
    }

    CxboxMyExample3238Controller(Class<?> serviceClass, boolean refresh) {
        this((String) null, serviceClass, refresh);
    }

    CxboxMyExample3238Controller(Class<?> serviceClass) {
        this((String) null, serviceClass, false);
    }

    @Component
    public static class BcSupplier extends AbstractEnumBcSupplier<CxboxMyExample3238Controller> {

        public BcSupplier() {
            super(CxboxMyExample3238Controller.Holder);
        }

    }

}