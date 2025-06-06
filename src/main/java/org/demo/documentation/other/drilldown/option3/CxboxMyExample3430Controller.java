package org.demo.documentation.other.drilldown.option3;

import lombok.Getter;
import org.cxbox.api.data.BcIdentifier;
import org.cxbox.core.crudma.bc.EnumBcIdentifier;
import org.cxbox.core.crudma.bc.impl.AbstractEnumBcSupplier;
import org.cxbox.core.crudma.bc.impl.BcDescription;
import org.demo.documentation.other.drilldown.option3.any.MyExample3435Service;
import org.demo.documentation.other.drilldown.option3.forsearch.MyExample3431Service;
import org.springframework.stereotype.Component;

@Getter
public enum CxboxMyExample3430Controller implements EnumBcIdentifier {
dsds
    // @formatter:on

    myexample3430(MyExample3430Service.class),
        myexample3431(myexample3430, MyExample3431Service.class),
            myexample3435(myexample3431, MyExample3435Service.class);

    // @formatter:on

    public static final EnumBcIdentifier.Holder<CxboxMyExample3430Controller> Holder = new Holder<>(
            CxboxMyExample3430Controller.class);

    private final BcDescription bcDescription;

    CxboxMyExample3430Controller(String parentName, Class<?> serviceClass, boolean refresh) {
        this.bcDescription = buildDescription(parentName, serviceClass, refresh);
    }

    CxboxMyExample3430Controller(String parentName, Class<?> serviceClass) {
        this(parentName, serviceClass, false);
    }

    CxboxMyExample3430Controller(BcIdentifier parent, Class<?> serviceClass, boolean refresh) {
        this(parent == null ? null : parent.getName(), serviceClass, refresh);
    }

    CxboxMyExample3430Controller(BcIdentifier parent, Class<?> serviceClass) {
        this(parent, serviceClass, false);
    }

    CxboxMyExample3430Controller(Class<?> serviceClass, boolean refresh) {
        this((String) null, serviceClass, refresh);
    }

    CxboxMyExample3430Controller(Class<?> serviceClass) {
        this((String) null, serviceClass, false);
    }

    @Component
    public static class BcSupplier extends AbstractEnumBcSupplier<CxboxMyExample3430Controller> {

        public BcSupplier() {
            super(CxboxMyExample3430Controller.Holder);
        }

    }

}