package org.demo.documentation.widgets.groupinghierarhy.defaultgroupinghierarchy.threelevel;

import lombok.Getter;
import org.cxbox.api.data.BcIdentifier;
import org.cxbox.core.crudma.bc.EnumBcIdentifier;
import org.cxbox.core.crudma.bc.impl.AbstractEnumBcSupplier;
import org.cxbox.core.crudma.bc.impl.BcDescription;
import org.springframework.stereotype.Component;

@Getter
public enum CxboxMyExample3165Controller implements EnumBcIdentifier {

    // @formatter:on

    myexample3165(MyExample3165Service.class);

    // @formatter:on

    public static final EnumBcIdentifier.Holder<CxboxMyExample3165Controller> Holder = new Holder<>(
            CxboxMyExample3165Controller.class);

    private final BcDescription bcDescription;

    CxboxMyExample3165Controller(String parentName, Class<?> serviceClass, boolean refresh) {
        this.bcDescription = buildDescription(parentName, serviceClass, refresh);
    }

    CxboxMyExample3165Controller(String parentName, Class<?> serviceClass) {
        this(parentName, serviceClass, false);
    }

    CxboxMyExample3165Controller(BcIdentifier parent, Class<?> serviceClass, boolean refresh) {
        this(parent == null ? null : parent.getName(), serviceClass, refresh);
    }

    CxboxMyExample3165Controller(BcIdentifier parent, Class<?> serviceClass) {
        this(parent, serviceClass, false);
    }

    CxboxMyExample3165Controller(Class<?> serviceClass, boolean refresh) {
        this((String) null, serviceClass, refresh);
    }

    CxboxMyExample3165Controller(Class<?> serviceClass) {
        this((String) null, serviceClass, false);
    }

    @Component
    public static class BcSupplier extends AbstractEnumBcSupplier<CxboxMyExample3165Controller> {

        public BcSupplier() {
            super(CxboxMyExample3165Controller.Holder);
        }

    }

}