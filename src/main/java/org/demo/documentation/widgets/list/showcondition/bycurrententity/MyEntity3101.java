package org.demo.documentation.widgets.list.showcondition.bycurrententity;

import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.cxbox.model.core.entity.BaseEntity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import org.demo.documentation.widgets.list.showcondition.bycurrententity.enums.*;

import java.time.LocalDateTime;


@Entity
@Getter
@Setter
@NoArgsConstructor
public class MyEntity3101 extends BaseEntity {

    @Column
    private Long customField;

    @Column
    private String bookkeepingNumber;

    @Column
    private String bookkeepingAccountNumber;

    @Column
    private String accrualTransactionAisNumber;

    @Column
    private Double accrualAmount;

    @Column
    private Double receiptAmount;

    @Column
    private Double debtAmount;

    @Column
    private String clientName;

    @Enumerated(value = EnumType.STRING)
    @Column
    private PayerClassificationEnum payerClassification;

    @Column
    private String bookkeepingComment;

    @Column
    private String legalCaseAisNumber;

    @Column
    private String legalCaseFemidaNumber;

    @Column
    private String contractNumber;

    @Enumerated(value = EnumType.STRING)
    @Column
    private LegalCaseTypeEnum legalCaseType;

    @Column
    private String lossNumber;

    @Column
    private String requirementType;

    @Column
    private LocalDateTime requirementClosingDate;

    @Enumerated(value = EnumType.STRING)
    @Column
    private RequirementStatusEnum requirementStatus;

    @Column
    private String requirementStep;

    @Column
    private String bankruptcyAttribute;

    @Column
    private LocalDateTime bankruptcyAttributeDate;

    @Column
    private String defendantName;

    @Column
    private LocalDateTime defendantBirthDate;

    @Column
    private String requirementCurator;

    @Column
    private String regionCenterOrMainOffice;

    @Column
    private String branchOrDivision;

    @Column
    private String division;

    @Enumerated(value = EnumType.STRING)
    @Column
    private ManagerDecisionEnum managerDecision;

    @Column
    private String managerNameDecision;

    @Column
    private LocalDateTime managerDecisionDate;

    @Enumerated(value = EnumType.STRING)
    @Column
    private InventoryReasonEnum inventoryReason;

    @Enumerated(value = EnumType.STRING)
    @Column
    private ArticleReasonEnum articleReason;

    @Column
    private String electronicFlg;

    @Column
    private String executiveListNumber;

    @Column
    private String caseNumber;

    @Column
    private Double executiveListOutgoingAmount;

    @Column
    private Double executiveListOutgoingDebtAmount;

    @Column
    private LocalDateTime lastPaymentDate;

    @Column
    private String sspNumber;

    @Column
    private String sspType;

    @Enumerated(value = EnumType.STRING)
    @Column
    private ExecutiveListLocationEnum executiveListLocation;

    @Column
    private String fsspName;

    @Column
    private String ospName;

    @Column
    private LocalDateTime executiveProcedureStartDate;

    @Column
    private LocalDateTime executiveProcedureFinishDate;

    @Column
    private String debtorInn;

    @Column
    private String executiveListPerspective;

    @Column
    private String businessName;

    @Column
    private String bookkeepingAccountName;

    @Column
    private String accountNumber;

    @Column
    private String balanceSummary;

    @Enumerated(value = EnumType.STRING)
    @Column
    private BalanceSummaryConfirmedDebtorsEnum balanceSummaryConfirmedDebtors;

    @Column
    private String balanceSummaryNotConfirmerDebtors;

    @Column
    private Double expiredBalanceAmount;

    @Column
    private String bookkeepingEntryParentNumber;

    @Column
    private LocalDateTime bookkeepingEntryDate;

    @Column
    private Double debtorDebtAmount;

    @Column
    private Double creditorDebtAmount;

    @Column
    private String femidaLegalCaseNumber;

    @Column
    private String regressNumber;

    @Column
    private String document;

    @Column
    private Double remainAmountAfterNotFullQuiting;

    @Column
    private String comment;
}