package org.demo.documentation.feature.drilldown.advancedfiltergroup;

import lombok.Getter;
import org.cxbox.api.data.BcIdentifier;
import org.cxbox.core.crudma.bc.EnumBcIdentifier;
import org.cxbox.core.crudma.bc.impl.AbstractEnumBcSupplier;
import org.cxbox.core.crudma.bc.impl.BcDescription;
import org.springframework.stereotype.Component;

@Getter
public enum CxboxMyExample3617Controller implements EnumBcIdentifier {



    myexample3617(MyExample3617Service.class);



    public static final EnumBcIdentifier.Holder<CxboxMyExample3617Controller> Holder = new Holder<>(
            CxboxMyExample3617Controller.class);

    private final BcDescription bcDescription;

    CxboxMyExample3617Controller(String parentName, Class<?> serviceClass, boolean refresh) {
        this.bcDescription = buildDescription(parentName, serviceClass, refresh);
    }


    CxboxMyExample3617Controller(Class<?> serviceClass) {
        this((String) null, serviceClass, false);
    }

    @Component
    public static class BcSupplier extends AbstractEnumBcSupplier<CxboxMyExample3617Controller> {

        public BcSupplier() {
            super(CxboxMyExample3617Controller.Holder);
        }

    }

}