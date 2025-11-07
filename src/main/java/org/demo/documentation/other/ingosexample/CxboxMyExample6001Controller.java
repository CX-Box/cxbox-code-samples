package org.demo.documentation.other.ingosexample;

import lombok.Getter;
import org.cxbox.api.data.BcIdentifier;
import org.cxbox.core.crudma.bc.EnumBcIdentifier;
import org.cxbox.core.crudma.bc.impl.AbstractEnumBcSupplier;
import org.cxbox.core.crudma.bc.impl.BcDescription;
import org.demo.documentation.other.test.MyExample420Service;
import org.springframework.stereotype.Component;

@Getter
public enum CxboxMyExample6001Controller implements EnumBcIdentifier {

    // @formatter:on

    myexample6001(MyExample6001Service.class),
    assignmentRuleCreateAssigneeMultivaluePopup(myexample6001, MyExample420Service.class),
    applicationEntityPick(myexample6001, ApplicationEntityPickService.class);

    // @formatter:on

    public static final Holder<CxboxMyExample6001Controller> Holder = new Holder<>(
            CxboxMyExample6001Controller.class);

    private final BcDescription bcDescription;

    CxboxMyExample6001Controller(String parentName, Class<?> serviceClass, boolean refresh) {
        this.bcDescription = buildDescription(parentName, serviceClass, refresh);
    }

    CxboxMyExample6001Controller(String parentName, Class<?> serviceClass) {
        this(parentName, serviceClass, false);
    }

    CxboxMyExample6001Controller(BcIdentifier parent, Class<?> serviceClass, boolean refresh) {
        this(parent == null ? null : parent.getName(), serviceClass, refresh);
    }

    CxboxMyExample6001Controller(BcIdentifier parent, Class<?> serviceClass) {
        this(parent, serviceClass, false);
    }

    CxboxMyExample6001Controller(Class<?> serviceClass, boolean refresh) {
        this((String) null, serviceClass, refresh);
    }

    CxboxMyExample6001Controller(Class<?> serviceClass) {
        this((String) null, serviceClass, false);
    }

    @Component
    public static class BcSupplier extends AbstractEnumBcSupplier<CxboxMyExample6001Controller> {

        public BcSupplier() {
            super(CxboxMyExample6001Controller.Holder);
        }

    }

}