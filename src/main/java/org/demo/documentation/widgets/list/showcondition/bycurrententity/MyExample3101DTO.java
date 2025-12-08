package org.demo.documentation.widgets.list.showcondition.bycurrententity;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.cxbox.api.data.dto.DataResponseDTO;
import org.cxbox.core.util.filter.SearchParameter;
import org.cxbox.core.util.filter.provider.impl.*;
import org.demo.documentation.widgets.list.showcondition.bycurrententity.enums.*;

import java.time.LocalDateTime;


@Getter
@Setter
@NoArgsConstructor
public class MyExample3101DTO extends DataResponseDTO {
    public static final String TEXT = "Сondition can include boolean expression depending on current entity fields. Field updates will trigger condition recalculation only on save or if field is force active";

    public static final String TEXT2 = "Show condition - if CustomField  > 5 widget show.";

    private Long customField;
    private String customFieldShowCond;

    @SearchParameter(name = "bookkeepingNumber", provider = StringValueProvider.class)
    private String bookkeepingNumber;

    @SearchParameter(name = "bookkeepingAccountNumber", provider = StringValueProvider.class)
    private String bookkeepingAccountNumber;

    @SearchParameter(name = "accrualTransactionAisNumber", provider = StringValueProvider.class)
    private String accrualTransactionAisNumber;

    @SearchParameter(name = "accrualAmount", provider = BigDecimalValueProvider.class)
    private Double accrualAmount;

    @SearchParameter(name = "receiptAmount", provider = BigDecimalValueProvider.class)
    private Double receiptAmount;

    @SearchParameter(name = "debtAmount", provider = BigDecimalValueProvider.class)
    private Double debtAmount;

    @SearchParameter(name = "clientName", provider = StringValueProvider.class)
    private String clientName;

    @SearchParameter(name = "payerClassification", provider = EnumValueProvider.class)
    private PayerClassificationEnum payerClassification;

    @SearchParameter(name = "bookkeepingComment", provider = StringValueProvider.class)
    private String bookkeepingComment;

    @SearchParameter(name = "legalCaseAisNumber", provider = StringValueProvider.class)
    private String legalCaseAisNumber;

    @SearchParameter(name = "legalCaseFemidaNumber", provider = StringValueProvider.class)
    private String legalCaseFemidaNumber;

    @SearchParameter(name = "contractNumber", provider = StringValueProvider.class)
    private String contractNumber;

    @SearchParameter(name = "legalCaseType", provider = EnumValueProvider.class)
    private LegalCaseTypeEnum legalCaseType;

    @SearchParameter(name = "lossNumber", provider = StringValueProvider.class)
    private String lossNumber;

    @SearchParameter(name = "requirementType", provider = StringValueProvider.class)
    private String requirementType;

    @SearchParameter(name = "requirementClosingDate", provider = DateValueProvider.class)
    private LocalDateTime requirementClosingDate;

    @SearchParameter(name = "requirementStatus", provider = EnumValueProvider.class)
    private RequirementStatusEnum requirementStatus;

    @SearchParameter(name = "requirementStep", provider = StringValueProvider.class)
    private String requirementStep;

    @SearchParameter(name = "bankruptcyAttribute", provider = StringValueProvider.class)
    private String bankruptcyAttribute;

    @SearchParameter(name = "bankruptcyAttributeDate", provider = DateValueProvider.class)
    private LocalDateTime bankruptcyAttributeDate;

    @SearchParameter(name = "defendantName", provider = StringValueProvider.class)
    private String defendantName;

    @SearchParameter(name = "defendantBirthDate", provider = DateValueProvider.class)
    private LocalDateTime defendantBirthDate;

    @SearchParameter(name = "requirementCurator", provider = StringValueProvider.class)
    private String requirementCurator;

    @SearchParameter(name = "regionCenterOrMainOffice", provider = StringValueProvider.class)
    private String regionCenterOrMainOffice;

    @SearchParameter(name = "branchOrDivision", provider = StringValueProvider.class)
    private String branchOrDivision;

    @SearchParameter(name = "division", provider = StringValueProvider.class)
    private String division;

    @SearchParameter(name = "managerDecision", provider = EnumValueProvider.class)
    private ManagerDecisionEnum managerDecision;

    @SearchParameter(name = "managerNameDecision", provider = StringValueProvider.class)
    private String managerNameDecision;

    @SearchParameter(name = "managerDecisionDate", provider = DateValueProvider.class)
    private LocalDateTime managerDecisionDate;

    @SearchParameter(name = "inventoryReason", provider = EnumValueProvider.class)
    private InventoryReasonEnum inventoryReason;

    @SearchParameter(name = "articleReason", provider = EnumValueProvider.class)
    private ArticleReasonEnum articleReason;

    @SearchParameter(name = "electronicFlg", provider = StringValueProvider.class)
    private String electronicFlg;

    @SearchParameter(name = "executiveListNumber", provider = StringValueProvider.class)
    private String executiveListNumber;

    @SearchParameter(name = "caseNumber", provider = StringValueProvider.class)
    private String caseNumber;

    @SearchParameter(name = "executiveListOutgoingAmount", provider = BigDecimalValueProvider.class)
    private Double executiveListOutgoingAmount;

    @SearchParameter(name = "executiveListOutgoingDebtAmount", provider = BigDecimalValueProvider.class)
    private Double executiveListOutgoingDebtAmount;

    @SearchParameter(name = "lastPaymentDate", provider = DateTimeValueProvider.class)
    private LocalDateTime lastPaymentDate;

    @SearchParameter(name = "sspNumber", provider = StringValueProvider.class)
    private String sspNumber;

    @SearchParameter(name = "sspType", provider = StringValueProvider.class)
    private String sspType;

    @SearchParameter(name = "executiveListLocation", provider = EnumValueProvider.class)
    private ExecutiveListLocationEnum executiveListLocation;

    @SearchParameter(name = "fsspName", provider = StringValueProvider.class)
    private String fsspName;

    @SearchParameter(name = "ospName", provider = StringValueProvider.class)
    private String ospName;

    @SearchParameter(name = "executiveProcedureStartDate", provider = DateValueProvider.class)
    private LocalDateTime executiveProcedureStartDate;

    @SearchParameter(name = "executiveProcedureFinishDate", provider = DateValueProvider.class)
    private LocalDateTime executiveProcedureFinishDate;

    @SearchParameter(name = "debtorInn", provider = StringValueProvider.class)
    private String debtorInn;

    @SearchParameter(name = "executiveListPerspective", provider = StringValueProvider.class)
    private String executiveListPerspective;

    @SearchParameter(name = "businessName", provider = StringValueProvider.class)
    private String businessName;

    @SearchParameter(name = "bookkeepingAccountName", provider = StringValueProvider.class)
    private String bookkeepingAccountName;

    @SearchParameter(name = "accountNumber", provider = StringValueProvider.class)
    private String accountNumber;

    @SearchParameter(name = "balanceSummary", provider = StringValueProvider.class)
    private String balanceSummary;

    @SearchParameter(name = "balanceSummaryConfirmedDebtors", provider = EnumValueProvider.class)
    private BalanceSummaryConfirmedDebtorsEnum balanceSummaryConfirmedDebtors;

    @SearchParameter(name = "balanceSummaryNotConfirmerDebtors", provider = StringValueProvider.class)
    private String balanceSummaryNotConfirmerDebtors;

    @SearchParameter(name = "expiredBalanceAmount", provider = BigDecimalValueProvider.class)
    private Double expiredBalanceAmount;

    @SearchParameter(name = "bookkeepingEntryParentNumber", provider = StringValueProvider.class)
    private String bookkeepingEntryParentNumber;

    @SearchParameter(name = "bookkeepingEntryDate", provider = DateTimeValueProvider.class)
    private LocalDateTime bookkeepingEntryDate;

    @SearchParameter(name = "debtorDebtAmount", provider = BigDecimalValueProvider.class)
    private Double debtorDebtAmount;

    @SearchParameter(name = "creditorDebtAmount", provider = BigDecimalValueProvider.class)
    private Double creditorDebtAmount;

    @SearchParameter(name = "femidaLegalCaseNumber", provider = StringValueProvider.class)
    private String femidaLegalCaseNumber;

    @SearchParameter(name = "regressNumber", provider = StringValueProvider.class)
    private String regressNumber;

    @SearchParameter(name = "document", provider = StringValueProvider.class)
    private String document;

    @SearchParameter(name = "remainAmountAfterNotFullQuiting", provider = BigDecimalValueProvider.class)
    private Double remainAmountAfterNotFullQuiting;

    @SearchParameter(name = "comment", provider = StringValueProvider.class)
    private String comment;

    public MyExample3101DTO(MyEntity3101 entity) {
        this.id = entity.getId().toString();
        this.customField = entity.getCustomField();
        this.customFieldShowCond = entity.getCustomField() > 5 ? "true" : "false";
        this.bookkeepingNumber = entity.getBookkeepingNumber();
        this.bookkeepingAccountNumber = entity.getBookkeepingAccountNumber();
        this.accrualTransactionAisNumber = entity.getAccrualTransactionAisNumber();
        this.accrualAmount = entity.getAccrualAmount();
        this.receiptAmount = entity.getReceiptAmount();
        this.debtAmount = entity.getDebtAmount();
        this.clientName = entity.getClientName();
        this.payerClassification = entity.getPayerClassification();
        this.bookkeepingComment = entity.getBookkeepingComment();
        this.legalCaseAisNumber = entity.getLegalCaseAisNumber();
        this.legalCaseFemidaNumber = entity.getLegalCaseFemidaNumber();
        this.contractNumber = entity.getContractNumber();
        this.legalCaseType = entity.getLegalCaseType();
        this.lossNumber = entity.getLossNumber();
        this.requirementType = entity.getRequirementType();
        this.requirementClosingDate = entity.getRequirementClosingDate();
        this.requirementStatus = entity.getRequirementStatus();
        this.requirementStep = entity.getRequirementStep();
        this.bankruptcyAttribute = entity.getBankruptcyAttribute();
        this.bankruptcyAttributeDate = entity.getBankruptcyAttributeDate();
        this.defendantName = entity.getDefendantName();
        this.defendantBirthDate = entity.getDefendantBirthDate();
        this.requirementCurator = entity.getRequirementCurator();
        this.regionCenterOrMainOffice = entity.getRegionCenterOrMainOffice();
        this.branchOrDivision = entity.getBranchOrDivision();
        this.division = entity.getDivision();
        this.managerDecision = entity.getManagerDecision();
        this.managerNameDecision = entity.getManagerNameDecision();
        this.managerDecisionDate = entity.getManagerDecisionDate();
        this.inventoryReason = entity.getInventoryReason();
        this.articleReason = entity.getArticleReason();
        this.electronicFlg = entity.getElectronicFlg();
        this.executiveListNumber = entity.getExecutiveListNumber();
        this.caseNumber = entity.getCaseNumber();
        this.executiveListOutgoingAmount = entity.getExecutiveListOutgoingAmount();
        this.executiveListOutgoingDebtAmount = entity.getExecutiveListOutgoingDebtAmount();
        this.lastPaymentDate = entity.getLastPaymentDate();
        this.sspNumber = entity.getSspNumber();
        this.sspType = entity.getSspType();
        this.executiveListLocation = entity.getExecutiveListLocation();
        this.fsspName = entity.getFsspName();
        this.ospName = entity.getOspName();
        this.executiveProcedureStartDate = entity.getExecutiveProcedureStartDate();
        this.executiveProcedureFinishDate = entity.getExecutiveProcedureFinishDate();
        this.debtorInn = entity.getDebtorInn();
        this.executiveListPerspective = entity.getExecutiveListPerspective();
        this.businessName = entity.getBusinessName();
        this.bookkeepingAccountName = entity.getBookkeepingAccountName();
        this.accountNumber = entity.getAccountNumber();
        this.balanceSummary = entity.getBalanceSummary();
        this.balanceSummaryConfirmedDebtors = entity.getBalanceSummaryConfirmedDebtors();
        this.balanceSummaryNotConfirmerDebtors = entity.getBalanceSummaryNotConfirmerDebtors();
        this.expiredBalanceAmount = entity.getExpiredBalanceAmount();
        this.bookkeepingEntryParentNumber = entity.getBookkeepingEntryParentNumber();
        this.bookkeepingEntryDate = entity.getBookkeepingEntryDate();
        this.debtorDebtAmount = entity.getDebtorDebtAmount();
        this.creditorDebtAmount = entity.getCreditorDebtAmount();
        this.femidaLegalCaseNumber = entity.getFemidaLegalCaseNumber();
        this.regressNumber = entity.getRegressNumber();
        this.document = entity.getDocument();
        this.remainAmountAfterNotFullQuiting = entity.getRemainAmountAfterNotFullQuiting();
        this.comment = entity.getComment();
    }
}