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
import javax.persistence.Transient;
import com.fasterxml.jackson.annotation.JsonProperty;
import javax.persistence.Column;
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

@Table(name = "ast_UserAssessmentTemp_T")
@Entity
@Cache(type = CacheType.CACHE)
@SourceCodeAuthorClass(createdBy = "john.doe", updatedBy = "john.doe", versionNumber = "6", comments = "UserAssessmentTemp", complexity = Complexity.LOW)
@NamedQueries({ @javax.persistence.NamedQuery(name = "UserAssessmentTemp.DefaultFinders", query = "select e from UserAssessmentTemp e where e.systemInfo.activeStatus=1 and e.assessmentTranId LIKE :assessmentTranId"), @javax.persistence.NamedQuery(name = "UserAssessmentTemp.findByAssessmentTranId", query = "select e from UserAssessmentTemp e where e.systemInfo.activeStatus=1 and e.assessmentTranId=:assessmentTranId"), @javax.persistence.NamedQuery(name = "UserAssessmentTemp.findByUserId", query = "select e from UserAssessmentTemp e where e.systemInfo.activeStatus=1 and e.userId=:userId"), @javax.persistence.NamedQuery(name = "UserAssessmentTemp.findByQuestionId", query = "select e from UserAssessmentTemp e where e.systemInfo.activeStatus=1 and e.questionId=:questionId"), @javax.persistence.NamedQuery(name = "UserAssessmentTemp.findByAnswerId", query = "select e from UserAssessmentTemp e where e.systemInfo.activeStatus=1 and e.answerId=:answerId"), @javax.persistence.NamedQuery(name = "UserAssessmentTemp.findById", query = "select e from UserAssessmentTemp e where e.systemInfo.activeStatus=1 and e.userAssessmentId =:userAssessmentId") })
public class UserAssessmentTemp implements Serializable, CommonEntityInterface, Comparator<UserAssessmentTemp> {

    @Transient
    private String primaryKey;

    @Id
    @Column(name = "userAssessmentId")
    @JsonProperty("userAssessmentId")
    @GeneratedValue(generator = "UUIDGenerator")
    private String userAssessmentId;

    @Column(name = "assessmentTranId")
    @JsonProperty("assessmentTranId")
    private String assessmentTranId;

    @Column(name = "userId")
    @JsonProperty("userId")
    private String userId;

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

    public String getPrimaryKey() {
        return userAssessmentId;
    }

    public void setPrimaryKey(String _primaryKey) {
        this.primaryKey = _primaryKey;
    }

    public String _getPrimarykey() {
        return userAssessmentId;
    }

    public String getUserAssessmentId() {
        return userAssessmentId;
    }

    public void setUserAssessmentId(String _userAssessmentId) {
        this.userAssessmentId = _userAssessmentId;
    }

    public String getAssessmentTranId() {
        return assessmentTranId;
    }

    public void setAssessmentTranId(String _assessmentTranId) {
        this.assessmentTranId = _assessmentTranId;
    }

    public String getUserId() {
        return userId;
    }

    public void setUserId(String _userId) {
        this.userId = _userId;
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
    public int compare(UserAssessmentTemp object1, UserAssessmentTemp object2) {
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
        if (userAssessmentId == null) {
            return super.hashCode();
        } else {
            return userAssessmentId.hashCode();
        }
    }

    public boolean equals(Object obj) {
        try {
            com.app.shared.survey.UserAssessmentTemp other = (com.app.shared.survey.UserAssessmentTemp) obj;
            if (userAssessmentId == null) {
                return false;
            } else if (!userAssessmentId.equals(other.userAssessmentId)) {
                return false;
            }
        } catch (java.lang.Exception ignore) {
            return false;
        }
        return true;
    }
}
