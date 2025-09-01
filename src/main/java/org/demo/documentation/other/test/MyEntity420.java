package org.demo.documentation.other.test;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.cxbox.model.core.entity.BaseEntity;
import org.demo.documentation.other.savewithparent.example5.entity.ApplicationEntity;

@Entity
@Getter
@Setter
@NoArgsConstructor
public class MyEntity420 extends BaseEntity {

    @Column
    private String customField;

    @Column
    private String customField2;

    @Column
    private String customField3;

    @Column
    private String customF9ield3;

    @Column
    private String customFieldForceActive;

    @Column
    private String customFieldForceActive3;

    @Column
    private String customFieldForceActive2;

    @JoinColumn(name = "PAYMENT_REQUEST_ID")
    @ManyToOne
    private ApplicationEntity paymentRequestEntity;

    @Column
    private String endpoint;

    @Column
    private String request;

    @Column
    private String requestFiles;

    @Column
    private String response;

    @Column
    private String responseFiles;
}