package org.demo.documentation.fields.dictionary.dictionarydictionary.anysorce;

import lombok.Getter;
import org.cxbox.core.crudma.bc.EnumBcIdentifier;
import org.cxbox.core.crudma.bc.impl.AbstractEnumBcSupplier;
import org.cxbox.core.crudma.bc.impl.BcDescription;

import org.springframework.stereotype.Component;

@Getter
public enum CxboxMyExample381Controller implements EnumBcIdentifier {


    myexample381(MyExample381Service.class);


    public static final EnumBcIdentifier.Holder<CxboxMyExample381Controller> Holder = new Holder<>(
            CxboxMyExample381Controller.class);

    private final BcDescription bcDescription;

    CxboxMyExample381Controller(String parentName, Class<?> serviceClass, boolean refresh) {
        this.bcDescription = buildDescription(parentName, serviceClass, refresh);
    }

    CxboxMyExample381Controller(Class<?> serviceClass) {
        this((String) null, serviceClass, false);
    }

    @Component
    public static class BcSupplier extends AbstractEnumBcSupplier<CxboxMyExample381Controller> {

        public BcSupplier() {
            super(CxboxMyExample381Controller.Holder);
        }

    }

}