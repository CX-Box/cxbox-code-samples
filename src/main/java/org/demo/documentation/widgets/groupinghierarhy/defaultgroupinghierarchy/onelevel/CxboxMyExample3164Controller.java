package org.demo.documentation.widgets.groupinghierarhy.defaultgroupinghierarchy.onelevel;

import lombok.Getter;
import org.cxbox.api.data.BcIdentifier;
import org.cxbox.core.crudma.bc.EnumBcIdentifier;
import org.cxbox.core.crudma.bc.impl.AbstractEnumBcSupplier;
import org.cxbox.core.crudma.bc.impl.BcDescription;
import org.springframework.stereotype.Component;

@Getter
public enum CxboxMyExample3164Controller implements EnumBcIdentifier {

    // @formatter:on

    myexample3164(MyExample3164Service.class);

    // @formatter:on

    public static final EnumBcIdentifier.Holder<CxboxMyExample3164Controller> Holder = new Holder<>(
            CxboxMyExample3164Controller.class);

    private final BcDescription bcDescription;

    CxboxMyExample3164Controller(String parentName, Class<?> serviceClass, boolean refresh) {
        this.bcDescription = buildDescription(parentName, serviceClass, refresh);
    }

    CxboxMyExample3164Controller(String parentName, Class<?> serviceClass) {
        this(parentName, serviceClass, false);
    }

    CxboxMyExample3164Controller(BcIdentifier parent, Class<?> serviceClass, boolean refresh) {
        this(parent == null ? null : parent.getName(), serviceClass, refresh);
    }

    CxboxMyExample3164Controller(BcIdentifier parent, Class<?> serviceClass) {
        this(parent, serviceClass, false);
    }

    CxboxMyExample3164Controller(Class<?> serviceClass, boolean refresh) {
        this((String) null, serviceClass, refresh);
    }

    CxboxMyExample3164Controller(Class<?> serviceClass) {
        this((String) null, serviceClass, false);
    }

    @Component
    public static class BcSupplier extends AbstractEnumBcSupplier<CxboxMyExample3164Controller> {

        public BcSupplier() {
            super(CxboxMyExample3164Controller.Holder);
        }

    }

}