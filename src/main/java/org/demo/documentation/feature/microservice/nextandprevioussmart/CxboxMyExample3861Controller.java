package org.demo.documentation.feature.microservice.nextandprevioussmart;

import lombok.Getter;
import org.cxbox.core.crudma.bc.EnumBcIdentifier;
import org.cxbox.core.crudma.bc.impl.AbstractEnumBcSupplier;
import org.cxbox.core.crudma.bc.impl.BcDescription;
import org.springframework.stereotype.Component;

@Getter
public enum CxboxMyExample3861Controller implements EnumBcIdentifier {



    myexample3861(MyExample3861Service.class);



    public static final EnumBcIdentifier.Holder<CxboxMyExample3861Controller> Holder = new Holder<>(
            CxboxMyExample3861Controller.class);

    private final BcDescription bcDescription;

    CxboxMyExample3861Controller(String parentName, Class<?> serviceClass, boolean refresh) {
        this.bcDescription = buildDescription(parentName, serviceClass, refresh);
    }

    CxboxMyExample3861Controller(Class<?> serviceClass) {
        this((String) null, serviceClass, false);
    }

    @Component
    public static class BcSupplier extends AbstractEnumBcSupplier<CxboxMyExample3861Controller> {

        public BcSupplier() {
            super(CxboxMyExample3861Controller.Holder);
        }

    }

}