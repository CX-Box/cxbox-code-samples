package org.demo.documentation.fields.dictionary.dictionarylov.administration;

import lombok.Getter;
import org.cxbox.api.data.BcIdentifier;
import org.cxbox.core.crudma.bc.EnumBcIdentifier;
import org.cxbox.core.crudma.bc.impl.AbstractEnumBcSupplier;
import org.cxbox.core.crudma.bc.impl.BcDescription;
import org.demo.documentation.fields.dictionary.dictionarylov.administration.example.MyExample356Service;
import org.springframework.stereotype.Component;

@Getter
public enum CxboxMyExample357Controller implements EnumBcIdentifier {

    // @formatter:on
    myexample356(MyExample356Service.class),
    myexample357(MyExample357Service.class),
        dictionaryTypeDescPick(myexample357, DictionaryTypeDescPickService.class);

    // @formatter:on

    public static final EnumBcIdentifier.Holder<CxboxMyExample357Controller> Holder = new Holder<>(
            CxboxMyExample357Controller.class);

    private final BcDescription bcDescription;

    CxboxMyExample357Controller(String parentName, Class<?> serviceClass, boolean refresh) {
        this.bcDescription = buildDescription(parentName, serviceClass, refresh);
    }

    CxboxMyExample357Controller(String parentName, Class<?> serviceClass) {
        this(parentName, serviceClass, false);
    }

    CxboxMyExample357Controller(BcIdentifier parent, Class<?> serviceClass, boolean refresh) {
        this(parent == null ? null : parent.getName(), serviceClass, refresh);
    }

    CxboxMyExample357Controller(BcIdentifier parent, Class<?> serviceClass) {
        this(parent, serviceClass, false);
    }

    CxboxMyExample357Controller(Class<?> serviceClass, boolean refresh) {
        this((String) null, serviceClass, refresh);
    }

    CxboxMyExample357Controller(Class<?> serviceClass) {
        this((String) null, serviceClass, false);
    }

    @Component
    public static class BcSupplier extends AbstractEnumBcSupplier<CxboxMyExample357Controller> {

        public BcSupplier() {
            super(CxboxMyExample357Controller.Holder);
        }

    }

}