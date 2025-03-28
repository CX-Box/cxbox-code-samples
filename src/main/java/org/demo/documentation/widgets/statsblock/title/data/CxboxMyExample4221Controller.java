package org.demo.documentation.widgets.statsblock.title.data;

import lombok.Getter;
import org.cxbox.core.crudma.bc.EnumBcIdentifier;
import org.cxbox.core.crudma.bc.impl.AbstractEnumBcSupplier;
import org.cxbox.core.crudma.bc.impl.BcDescription;
import org.springframework.stereotype.Component;

@Getter
public enum CxboxMyExample4221Controller implements EnumBcIdentifier {



    myexample4221(MyExample4221Service.class);



    public static final EnumBcIdentifier.Holder<CxboxMyExample4221Controller> Holder = new Holder<>(
            CxboxMyExample4221Controller.class);

    private final BcDescription bcDescription;

    CxboxMyExample4221Controller(String parentName, Class<?> serviceClass, boolean refresh) {
        this.bcDescription = buildDescription(parentName, serviceClass, refresh);
    }

    CxboxMyExample4221Controller(Class<?> serviceClass) {
        this((String) null, serviceClass, false);
    }

    @Component
    public static class BcSupplier extends AbstractEnumBcSupplier<CxboxMyExample4221Controller> {

        public BcSupplier() {
            super(CxboxMyExample4221Controller.Holder);
        }

    }

}