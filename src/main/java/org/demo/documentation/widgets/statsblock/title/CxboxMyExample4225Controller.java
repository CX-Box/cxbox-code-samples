package org.demo.documentation.widgets.statsblock.title;

import lombok.Getter;
import org.cxbox.api.data.BcIdentifier;
import org.cxbox.core.crudma.bc.EnumBcIdentifier;
import org.cxbox.core.crudma.bc.impl.AbstractEnumBcSupplier;
import org.cxbox.core.crudma.bc.impl.BcDescription;
import org.demo.documentation.widgets.statsblock.title.withouttitle.MyExample4225Service;
import org.demo.documentation.widgets.statsblock.title.withtitle.MyExample4226Service;
import org.springframework.stereotype.Component;

@Getter
public enum CxboxMyExample4225Controller implements EnumBcIdentifier {



    myexample4225(MyExample4225Service.class),
    myexample4226(MyExample4226Service .class);


    public static final EnumBcIdentifier.Holder<CxboxMyExample4225Controller> Holder = new Holder<>(
            CxboxMyExample4225Controller.class);

    private final BcDescription bcDescription;

    CxboxMyExample4225Controller(String parentName, Class<?> serviceClass, boolean refresh) {
        this.bcDescription = buildDescription(parentName, serviceClass, refresh);
    }

    CxboxMyExample4225Controller(String parentName, Class<?> serviceClass) {
        this(parentName, serviceClass, false);
    }

    CxboxMyExample4225Controller(BcIdentifier parent, Class<?> serviceClass, boolean refresh) {
        this(parent == null ? null : parent.getName(), serviceClass, refresh);
    }

    CxboxMyExample4225Controller(BcIdentifier parent, Class<?> serviceClass) {
        this(parent, serviceClass, false);
    }

    CxboxMyExample4225Controller(Class<?> serviceClass, boolean refresh) {
        this((String) null, serviceClass, refresh);
    }

    CxboxMyExample4225Controller(Class<?> serviceClass) {
        this((String) null, serviceClass, false);
    }

    @Component
    public static class BcSupplier extends AbstractEnumBcSupplier<CxboxMyExample4225Controller> {

        public BcSupplier() {
            super(CxboxMyExample4225Controller.Holder);
        }

    }

}