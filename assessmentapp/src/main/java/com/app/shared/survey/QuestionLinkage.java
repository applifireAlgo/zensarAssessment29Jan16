package com.app.shared.survey;
import com.athena.annotation.Complexity;
import com.athena.annotation.SourceCodeAuthorClass;
import com.athena.framework.shared.entity.web.entityInterface.CommonEntityInterface;
import java.io.Serializable;
import java.util.Comparator;
import javax.persistence.Entity;
import javax.persistence.Table;
import org.eclipse.persistence.annotations.Cache;
import org.eclipse.persistence.annotations.CacheType;
import com.fasterxml.jackson.annotation.JsonProperty;
import javax.persistence.Column;
import javax.validation.constraints.Size;
import javax.persistence.Transient;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import com.athena.framework.server.helper.EntityValidatorHelper;
import com.fasterxml.jackson.annotation.JsonIgnore;
import javax.persistence.Version;
import com.app.shared.EntityAudit;
import javax.persistence.Embedded;
import com.app.shared.SystemInfo;
import com.athena.framework.server.exception.biz.SpartanConstraintViolationException;
import com.athena.framework.server.exception.biz.SpartanIncorrectDataException;
import java.lang.Override;
import javax.persistence.NamedQueries;

@Table(name = "ast_QuestionLinkage_T")
@Entity
@Cache(type = CacheType.CACHE)
@SourceCodeAuthorClass(createdBy = "john.doe", updatedBy = "john.doe", versionNumber = "2", comments = "QuestionLinkage", complexity = Complexity.LOW)
@NamedQueries({ @javax.persistence.NamedQuery(name = "QuestionLinkage.findByQuestionId", query = "select e from QuestionLinkage e where e.systemInfo.activeStatus=1 and e.questionId=:questionId"), @javax.persistence.NamedQuery(name = "QuestionLinkage.findByAnswerId", query = "select e from QuestionLinkage e where e.systemInfo.activeStatus=1 and e.answerId=:answerId"), @javax.persistence.NamedQuery(name = "QuestionLinkage.findById", query = "select e from QuestionLinkage e where e.systemInfo.activeStatus=1 and e.questionLinkId =:questionLinkId"), @javax.persistence.NamedQuery(name = "FindLinkageByQuestionAnswer", query = "SELECT questionLinkage FROM QuestionLinkage AS questionLinkage WHERE questionLinkage.questionId = :questionId AND questionLinkage.answerId = :answerId ") })
public class QuestionLinkage implements Serializable, CommonEntityInterface, Comparator<QuestionLinkage> {

    @Column(name = "linkedQuestionId")
    @JsonProperty("linkedQuestionId")
    @Size(min = 0, max = 256)
    private String linkedQuestionId;

    @Column(name = "firstGenQuestion")
    @JsonProperty("firstGenQuestion")
    private Boolean firstGenQuestion;

    @Column(name = "lastGenQuestion")
    @JsonProperty("lastGenQuestion")
    private Boolean lastGenQuestion;

    @Transient
    private String primaryKey;

    @Id
    @Column(name = "questionLinkId")
    @JsonProperty("questionLinkId")
    @GeneratedValue(generator = "UUIDGenerator")
    private String questionLinkId;

    @Column(name = "questionId")
    @JsonProperty("questionId")
    private String questionId;

    @Column(name = "answerId")
    @JsonProperty("answerId")
    private String answerId;

    @Transient
    @JsonIgnore
    private EntityValidatorHelper<Object> entityValidator;

    @Version
    @Column(name = "versionId")
    @JsonProperty("versionId")
    private int versionId;

    @Embedded
    @JsonIgnore
    private EntityAudit entityAudit = new EntityAudit();

    @Embedded
    private SystemInfo systemInfo = new SystemInfo();

    @Transient
    private String primaryDisplay;

    public String getLinkedQuestionId() {
        return linkedQuestionId;
    }

    public void setLinkedQuestionId(String _linkedQuestionId) {
        this.linkedQuestionId = _linkedQuestionId;
    }

    public Boolean getFirstGenQuestion() {
        return firstGenQuestion;
    }

    public void setFirstGenQuestion(Boolean _firstGenQuestion) {
        this.firstGenQuestion = _firstGenQuestion;
    }

    public Boolean getLastGenQuestion() {
        return lastGenQuestion;
    }

    public void setLastGenQuestion(Boolean _lastGenQuestion) {
        this.lastGenQuestion = _lastGenQuestion;
    }

    public String getPrimaryKey() {
        return questionLinkId;
    }

    public void setPrimaryKey(String _primaryKey) {
        this.primaryKey = _primaryKey;
    }

    public String _getPrimarykey() {
        return questionLinkId;
    }

    public String getQuestionLinkId() {
        return questionLinkId;
    }

    public void setQuestionLinkId(String _questionLinkId) {
        this.questionLinkId = _questionLinkId;
    }

    public String getQuestionId() {
        return questionId;
    }

    public void setQuestionId(String _questionId) {
        this.questionId = _questionId;
    }

    public String getAnswerId() {
        return answerId;
    }

    public void setAnswerId(String _answerId) {
        this.answerId = _answerId;
    }

    public int getVersionId() {
        return versionId;
    }

    public void setVersionId(int _versionId) {
        this.versionId = _versionId;
    }

    public void setPrimaryDisplay(String _primaryDisplay) {
        this.primaryDisplay = _primaryDisplay;
    }

    public SystemInfo getSystemInfo() {
        return systemInfo;
    }

    public void setSystemInfo(SystemInfo _systemInfo) {
        this.systemInfo = _systemInfo;
    }

    @JsonIgnore
    public boolean isHardDelete() {
        if (this.systemInfo == null) {
            this.systemInfo = new SystemInfo();
        }
        if (this.systemInfo.getActiveStatus() == -1) {
            return true;
        } else {
            return false;
        }
    }

    @JsonIgnore
    @Override
    public boolean isValid() throws SpartanConstraintViolationException, SpartanIncorrectDataException {
        boolean isValid = false;
        if (this.entityValidator != null) {
            isValid = this.entityValidator.validateEntity(this);
        } else {
            throw new SpartanIncorrectDataException("Entity validator is not set");
        }
        return isValid;
    }

    @Override
    public void setEntityValidator(EntityValidatorHelper<Object> _validateFactory) {
        this.entityValidator = _validateFactory;
    }

    @Override
    public void setEntityAudit(int customerId, String userId, RECORD_TYPE recordType) {
        System.out.println("Setting logged in user info for " + recordType);
        if (entityAudit == null) {
            entityAudit = new EntityAudit();
        }
        if (recordType == RECORD_TYPE.ADD) {
            this.entityAudit.setCreatedBy(userId);
        } else {
            this.entityAudit.setUpdatedBy(userId);
        }
        setSystemInformation(recordType);
    }

    @Override
    public void setEntityAudit(int customerId, String userId) {
        if (entityAudit == null) {
            entityAudit = new EntityAudit();
        }
        if (getPrimaryKey() == null) {
            this.entityAudit.setCreatedBy(userId);
            this.systemInfo.setActiveStatus(1);
        } else {
            this.entityAudit.setUpdatedBy(userId);
        }
    }

    @JsonIgnore
    public String getLoggedInUserInfo() {
        String auditInfo = "";
        if (this.entityAudit != null) {
            auditInfo = entityAudit.toString();
        }
        return auditInfo;
    }

    @Override
    @JsonIgnore
    public void setSystemInformation(RECORD_TYPE recordType) {
        if (systemInfo == null) {
            systemInfo = new SystemInfo();
        }
        if (recordType == RECORD_TYPE.DELETE) {
            this.systemInfo.setActiveStatus(0);
        } else {
            this.systemInfo.setActiveStatus(1);
        }
    }

    @JsonIgnore
    public void setSystemInformation(Integer activeStatus) {
        this.systemInfo.setActiveStatus(activeStatus);
    }

    @JsonIgnore
    public String getSystemInformation() {
        String systemInfo = "";
        if (this.systemInfo != null) {
            systemInfo = systemInfo.toString();
        }
        return systemInfo;
    }

    @Override
    @JsonIgnore
    public void setSystemTxnCode(Integer transactionAccessCode) {
        if (systemInfo == null) {
            systemInfo = new SystemInfo();
        }
        this.systemInfo.setTxnAccessCode(transactionAccessCode);
    }

    @Override
    public int compare(QuestionLinkage object1, QuestionLinkage object2) {
        return 0;
    }

    public String getPrimaryDisplay() {
        StringBuilder sb = new StringBuilder();
        sb.append("");
        return sb.toString();
    }

    public String toString() {
        return getPrimaryDisplay();
    }

    public int hashCode() {
        if (questionLinkId == null) {
            return super.hashCode();
        } else {
            return questionLinkId.hashCode();
        }
    }

    public boolean equals(Object obj) {
        try {
            com.app.shared.survey.QuestionLinkage other = (com.app.shared.survey.QuestionLinkage) obj;
            if (questionLinkId == null) {
                return false;
            } else if (!questionLinkId.equals(other.questionLinkId)) {
                return false;
            }
        } catch (java.lang.Exception ignore) {
            return false;
        }
        return true;
    }
}
