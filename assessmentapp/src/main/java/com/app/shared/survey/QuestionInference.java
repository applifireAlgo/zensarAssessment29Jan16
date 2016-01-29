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
import javax.validation.constraints.NotNull;
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

@Table(name = "ast_QuestionInference_T")
@Entity
@Cache(type = CacheType.CACHE)
@SourceCodeAuthorClass(createdBy = "john.doe", updatedBy = "john.doe", versionNumber = "4", comments = "QuestionInference", complexity = Complexity.LOW)
@NamedQueries({ @javax.persistence.NamedQuery(name = "QuestionInference.findByQuestionId", query = "select e from QuestionInference e where e.systemInfo.activeStatus=1 and e.questionId=:questionId"), @javax.persistence.NamedQuery(name = "QuestionInference.findById", query = "select e from QuestionInference e where e.systemInfo.activeStatus=1 and e.questionInferenceId =:questionInferenceId") })
public class QuestionInference implements Serializable, CommonEntityInterface, Comparator<QuestionInference> {

    @Column(name = "inferenceKeyword")
    @JsonProperty("inferenceKeyword")
    @NotNull
    private String inferenceKeyword;

    @Column(name = "inferenceHeading")
    @JsonProperty("inferenceHeading")
    @Size(min = 0, max = 256)
    private String inferenceHeading;

    @Column(name = "inferenceYesValue")
    @JsonProperty("inferenceYesValue")
    @Size(min = 0, max = 256)
    private String inferenceYesValue;

    @Column(name = "inferenceNoValue")
    @JsonProperty("inferenceNoValue")
    @Size(min = 0, max = 256)
    private String inferenceNoValue;

    @Transient
    private String primaryKey;

    @Id
    @Column(name = "questionInferenceId")
    @JsonProperty("questionInferenceId")
    @GeneratedValue(generator = "UUIDGenerator")
    private String questionInferenceId;

    @Column(name = "questionId")
    @JsonProperty("questionId")
    private String questionId;

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

    public String getInferenceKeyword() {
        return inferenceKeyword;
    }

    public void setInferenceKeyword(String _inferenceKeyword) {
        if (_inferenceKeyword != null) {
            this.inferenceKeyword = _inferenceKeyword;
        }
    }

    public String getInferenceHeading() {
        return inferenceHeading;
    }

    public void setInferenceHeading(String _inferenceHeading) {
        this.inferenceHeading = _inferenceHeading;
    }

    public String getInferenceYesValue() {
        return inferenceYesValue;
    }

    public void setInferenceYesValue(String _inferenceYesValue) {
        this.inferenceYesValue = _inferenceYesValue;
    }

    public String getInferenceNoValue() {
        return inferenceNoValue;
    }

    public void setInferenceNoValue(String _inferenceNoValue) {
        this.inferenceNoValue = _inferenceNoValue;
    }

    public String getPrimaryKey() {
        return questionInferenceId;
    }

    public void setPrimaryKey(String _primaryKey) {
        this.primaryKey = _primaryKey;
    }

    public String _getPrimarykey() {
        return questionInferenceId;
    }

    public String getQuestionInferenceId() {
        return questionInferenceId;
    }

    public void setQuestionInferenceId(String _questionInferenceId) {
        this.questionInferenceId = _questionInferenceId;
    }

    public String getQuestionId() {
        return questionId;
    }

    public void setQuestionId(String _questionId) {
        this.questionId = _questionId;
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
    public int compare(QuestionInference object1, QuestionInference object2) {
        return 0;
    }

    public String getPrimaryDisplay() {
        StringBuilder sb = new StringBuilder();
        sb.append("");
        sb.append((inferenceKeyword == null ? " " : inferenceKeyword));
        return sb.toString();
    }

    public String toString() {
        return getPrimaryDisplay();
    }

    public int hashCode() {
        if (questionInferenceId == null) {
            return super.hashCode();
        } else {
            return questionInferenceId.hashCode();
        }
    }

    public boolean equals(Object obj) {
        try {
            com.app.shared.survey.QuestionInference other = (com.app.shared.survey.QuestionInference) obj;
            if (questionInferenceId == null) {
                return false;
            } else if (!questionInferenceId.equals(other.questionInferenceId)) {
                return false;
            }
        } catch (java.lang.Exception ignore) {
            return false;
        }
        return true;
    }
}
