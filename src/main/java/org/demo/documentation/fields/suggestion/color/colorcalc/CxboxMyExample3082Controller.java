package org.demo.documentation.fields.suggestion.color.colorcalc;

import lombok.Getter;
import org.cxbox.api.data.BcIdentifier;
import org.cxbox.core.crudma.bc.EnumBcIdentifier;
import org.cxbox.core.crudma.bc.impl.AbstractEnumBcSupplier;
import org.cxbox.core.crudma.bc.impl.BcDescription;
import org.demo.documentation.fields.suggestion.color.colorcalc.forfield.MyExample3093Service;
import org.springframework.stereotype.Component;

@Getter
public enum CxboxMyExample3082Controller implements EnumBcIdentifier {



    myexample3082(MyExample3082SuggestionService.class),
    myexample3093(MyExample3093Service.class);



    public static final EnumBcIdentifier.Holder<CxboxMyExample3082Controller> Holder = new Holder<>(
            CxboxMyExample3082Controller.class);

    private final BcDescription bcDescription;

    CxboxMyExample3082Controller(String parentName, Class<?> serviceClass, boolean refresh) {
        this.bcDescription = buildDescription(parentName, serviceClass, refresh);
    }

    CxboxMyExample3082Controller(String parentName, Class<?> serviceClass) {
        this(parentName, serviceClass, false);
    }

    CxboxMyExample3082Controller(BcIdentifier parent, Class<?> serviceClass, boolean refresh) {
        this(parent == null ? null : parent.getName(), serviceClass, refresh);
    }

    CxboxMyExample3082Controller(BcIdentifier parent, Class<?> serviceClass) {
        this(parent, serviceClass, false);
    }

    CxboxMyExample3082Controller(Class<?> serviceClass, boolean refresh) {
        this((String) null, serviceClass, refresh);
    }

    CxboxMyExample3082Controller(Class<?> serviceClass) {
        this((String) null, serviceClass, false);
    }

    @Component
    public static class BcSupplier extends AbstractEnumBcSupplier<CxboxMyExample3082Controller> {

        public BcSupplier() {
            super(CxboxMyExample3082Controller.Holder);
        }

    }

}