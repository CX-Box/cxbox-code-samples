package org.demo.documentation.navigation.tab.other.example2;

import lombok.Getter;
import org.cxbox.api.data.BcIdentifier;
import org.cxbox.core.crudma.bc.EnumBcIdentifier;
import org.cxbox.core.crudma.bc.impl.AbstractEnumBcSupplier;
import org.cxbox.core.crudma.bc.impl.BcDescription;
import org.demo.documentation.navigation.tab.other.example2.client.MyExample3425Service;
import org.demo.documentation.navigation.tab.other.example2.relatedobject.MyExample3423Service;
import org.springframework.stereotype.Component;

@Getter
public enum CxboxMyExample3422Controller implements EnumBcIdentifier {

    // @formatter:on

    myexample3422(MyExample3422Service.class),
    myexample3425(myexample3422, MyExample3425Service.class),
    myexample3423(myexample3422, MyExample3423Service.class);

    // @formatter:on

    public static final EnumBcIdentifier.Holder<CxboxMyExample3422Controller> Holder = new Holder<>(
            CxboxMyExample3422Controller.class);

    private final BcDescription bcDescription;

    CxboxMyExample3422Controller(String parentName, Class<?> serviceClass, boolean refresh) {
        this.bcDescription = buildDescription(parentName, serviceClass, refresh);
    }

    CxboxMyExample3422Controller(String parentName, Class<?> serviceClass) {
        this(parentName, serviceClass, false);
    }

    CxboxMyExample3422Controller(BcIdentifier parent, Class<?> serviceClass, boolean refresh) {
        this(parent == null ? null : parent.getName(), serviceClass, refresh);
    }

    CxboxMyExample3422Controller(BcIdentifier parent, Class<?> serviceClass) {
        this(parent, serviceClass, false);
    }

    CxboxMyExample3422Controller(Class<?> serviceClass, boolean refresh) {
        this((String) null, serviceClass, refresh);
    }

    CxboxMyExample3422Controller(Class<?> serviceClass) {
        this((String) null, serviceClass, false);
    }

    @Component
    public static class BcSupplier extends AbstractEnumBcSupplier<CxboxMyExample3422Controller> {

        public BcSupplier() {
            super(CxboxMyExample3422Controller.Holder);
        }

    }

}