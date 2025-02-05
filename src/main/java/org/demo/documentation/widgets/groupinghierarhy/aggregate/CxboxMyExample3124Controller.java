package org.demo.documentation.widgets.groupinghierarhy.aggregate;

import lombok.Getter;
import org.cxbox.api.data.BcIdentifier;
import org.cxbox.core.crudma.bc.EnumBcIdentifier;
import org.cxbox.core.crudma.bc.impl.AbstractEnumBcSupplier;
import org.cxbox.core.crudma.bc.impl.BcDescription;
import org.demo.documentation.widgets.groupinghierarhy.aggregate.aggfields.MyExample3124Service;
import org.demo.documentation.widgets.groupinghierarhy.aggregate.agglevels.MyExample3125Service;
import org.demo.documentation.widgets.groupinghierarhy.aggregate.customfunction.MyExample3126Service;
import org.springframework.stereotype.Component;

@Getter
public enum CxboxMyExample3124Controller implements EnumBcIdentifier {

    // @formatter:on

    myexample3126(MyExample3126Service.class),
    myexample3125(MyExample3125Service.class),
    myexample3124(MyExample3124Service.class);

    // @formatter:on

    public static final EnumBcIdentifier.Holder<CxboxMyExample3124Controller> Holder = new Holder<>(
            CxboxMyExample3124Controller.class);

    private final BcDescription bcDescription;

    CxboxMyExample3124Controller(String parentName, Class<?> serviceClass, boolean refresh) {
        this.bcDescription = buildDescription(parentName, serviceClass, refresh);
    }

    CxboxMyExample3124Controller(String parentName, Class<?> serviceClass) {
        this(parentName, serviceClass, false);
    }

    CxboxMyExample3124Controller(BcIdentifier parent, Class<?> serviceClass, boolean refresh) {
        this(parent == null ? null : parent.getName(), serviceClass, refresh);
    }

    CxboxMyExample3124Controller(BcIdentifier parent, Class<?> serviceClass) {
        this(parent, serviceClass, false);
    }

    CxboxMyExample3124Controller(Class<?> serviceClass, boolean refresh) {
        this((String) null, serviceClass, refresh);
    }

    CxboxMyExample3124Controller(Class<?> serviceClass) {
        this((String) null, serviceClass, false);
    }

    @Component
    public static class BcSupplier extends AbstractEnumBcSupplier<CxboxMyExample3124Controller> {

        public BcSupplier() {
            super(CxboxMyExample3124Controller.Holder);
        }

    }

}