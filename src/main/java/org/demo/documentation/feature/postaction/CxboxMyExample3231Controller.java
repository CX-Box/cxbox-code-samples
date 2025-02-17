package org.demo.documentation.feature.postaction;

import lombok.Getter;
import org.cxbox.api.data.BcIdentifier;
import org.cxbox.core.crudma.bc.EnumBcIdentifier;
import org.cxbox.core.crudma.bc.impl.AbstractEnumBcSupplier;
import org.cxbox.core.crudma.bc.impl.BcDescription;
import org.demo.documentation.feature.postaction.drilldownandwaituntil.MyExample3232Service;
import org.demo.documentation.feature.postaction.waituntil.MyExample3231Service;
import org.springframework.stereotype.Component;

@Getter
public enum CxboxMyExample3231Controller implements EnumBcIdentifier {

    // @formatter:on
    myexample3232(MyExample3232Service.class),
    myexample3231(MyExample3231Service.class);

    // @formatter:on

    public static final EnumBcIdentifier.Holder<CxboxMyExample3231Controller> Holder = new Holder<>(
            CxboxMyExample3231Controller.class);

    private final BcDescription bcDescription;

    CxboxMyExample3231Controller(String parentName, Class<?> serviceClass, boolean refresh) {
        this.bcDescription = buildDescription(parentName, serviceClass, refresh);
    }

    CxboxMyExample3231Controller(String parentName, Class<?> serviceClass) {
        this(parentName, serviceClass, false);
    }

    CxboxMyExample3231Controller(BcIdentifier parent, Class<?> serviceClass, boolean refresh) {
        this(parent == null ? null : parent.getName(), serviceClass, refresh);
    }

    CxboxMyExample3231Controller(BcIdentifier parent, Class<?> serviceClass) {
        this(parent, serviceClass, false);
    }

    CxboxMyExample3231Controller(Class<?> serviceClass, boolean refresh) {
        this((String) null, serviceClass, refresh);
    }

    CxboxMyExample3231Controller(Class<?> serviceClass) {
        this((String) null, serviceClass, false);
    }

    @Component
    public static class BcSupplier extends AbstractEnumBcSupplier<CxboxMyExample3231Controller> {

        public BcSupplier() {
            super(CxboxMyExample3231Controller.Holder);
        }

    }

}