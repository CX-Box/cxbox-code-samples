package org.demo.documentation.widgets.property.defaultlimitpage;

import lombok.Getter;
import org.cxbox.api.data.BcIdentifier;
import org.cxbox.core.crudma.bc.EnumBcIdentifier;
import org.cxbox.core.crudma.bc.impl.AbstractEnumBcSupplier;
import org.cxbox.core.crudma.bc.impl.BcDescription;
import org.demo.documentation.widgets.property.defaultlimitpage.forassoc.MyEntity359AssocPickService;
import org.demo.documentation.widgets.property.defaultlimitpage.forpick.MyEntity359PickPickService;
import org.springframework.stereotype.Component;

@Getter
public enum CxboxMyExample359Controller implements EnumBcIdentifier {

    

    myexample359(MyExample359Service.class),
        myEntity359PickPick(myexample359, MyEntity359PickPickService.class),
        myEntity359AssocPick(myexample359, MyEntity359AssocPickService.class);

    

    public static final EnumBcIdentifier.Holder<CxboxMyExample359Controller> Holder = new Holder<>(
            CxboxMyExample359Controller.class);

    private final BcDescription bcDescription;

    CxboxMyExample359Controller(String parentName, Class<?> serviceClass, boolean refresh) {
        this.bcDescription = buildDescription(parentName, serviceClass, refresh);
    }

    CxboxMyExample359Controller(String parentName, Class<?> serviceClass) {
        this(parentName, serviceClass, false);
    }

    CxboxMyExample359Controller(BcIdentifier parent, Class<?> serviceClass, boolean refresh) {
        this(parent == null ? null : parent.getName(), serviceClass, refresh);
    }

    CxboxMyExample359Controller(BcIdentifier parent, Class<?> serviceClass) {
        this(parent, serviceClass, false);
    }

    CxboxMyExample359Controller(Class<?> serviceClass, boolean refresh) {
        this((String) null, serviceClass, refresh);
    }

    CxboxMyExample359Controller(Class<?> serviceClass) {
        this((String) null, serviceClass, false);
    }

    @Component
    public static class BcSupplier extends AbstractEnumBcSupplier<CxboxMyExample359Controller> {

        public BcSupplier() {
            super(CxboxMyExample359Controller.Holder);
        }

    }

}