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
import java.util.List;
import javax.persistence.JoinTable;
import javax.persistence.CascadeType;
import javax.persistence.OneToMany;
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

@Table(name = "ast_AssessmentQuestion_T")
@Entity
@Cache(type = CacheType.CACHE)
@SourceCodeAuthorClass(createdBy = "john.doe", updatedBy = "john.doe", versionNumber = "4", comments = "AssessmentQuestion", complexity = Complexity.LOW)
@NamedQueries({ @javax.persistence.NamedQuery(name = "AssessmentQuestion.findById", query = "select e from AssessmentQuestion e where e.systemInfo.activeStatus=1 and e.questionId =:questionId") })
public class AssessmentQuestion implements Serializable, CommonEntityInterface, Comparator<AssessmentQuestion> {

    @Column(name = "question")
    @JsonProperty("question")
    @NotNull
    @Size(min = 0, max = 256)
    private String question;

    @Column(name = "questionDesc")
    @JsonProperty("questionDesc")
    private String questionDesc;

    @Column(name = "questionInference")
    @JsonProperty("questionInference")
    private Boolean questionInference;

    @Transient
    private String primaryKey;

    @Id
    @Column(name = "questionId")
    @JsonProperty("questionId")
    @GeneratedValue(generator = "UUIDGenerator")
    private String questionId;

    @JoinTable(name = "ast_QuestionAnswerBridge_B", joinColumns = { @javax.persistence.JoinColumn(name = "questionId", referencedColumnName = "questionId") }, inverseJoinColumns = { @javax.persistence.JoinColumn(name = "answerId", referencedColumnName = "answerId") })
    @OneToMany(cascade = CascadeType.ALL)
    private List<AssessmentAnswer> assessmentAnswer;

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

    public String getQuestion() {
        return question;
    }

    public void setQuestion(String _question) {
        if (_question != null) {
            this.question = _question;
        }
    }

    public String getQuestionDesc() {
        return questionDesc;
    }

    public void setQuestionDesc(String _questionDesc) {
        this.questionDesc = _questionDesc;
    }

    public Boolean getQuestionInference() {
        return questionInference;
    }

    public void setQuestionInference(Boolean _questionInference) {
        this.questionInference = _questionInference;
    }

    public String getPrimaryKey() {
        return questionId;
    }

    public void setPrimaryKey(String _primaryKey) {
        this.primaryKey = _primaryKey;
    }

    public String _getPrimarykey() {
        return questionId;
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

    public AssessmentQuestion addAssessmentAnswer(AssessmentAnswer _assessmentAnswer) {
        if (this.assessmentAnswer == null) {
            this.assessmentAnswer = new java.util.ArrayList<com.app.shared.survey.AssessmentAnswer>();
        }
        if (_assessmentAnswer != null) {
            this.assessmentAnswer.add(_assessmentAnswer);
        }
        return this;
    }

    public AssessmentQuestion removeAssessmentAnswer(AssessmentAnswer _assessmentAnswer) {
        if (this.assessmentAnswer != null) {
            this.assessmentAnswer.remove(_assessmentAnswer);
        }
        return this;
    }

    public AssessmentQuestion addAllAssessmentAnswer(List<AssessmentAnswer> _assessmentAnswer) {
        if (this.assessmentAnswer == null) {
            this.assessmentAnswer = new java.util.ArrayList<com.app.shared.survey.AssessmentAnswer>();
        }
        if (_assessmentAnswer != null) {
            this.assessmentAnswer.addAll(_assessmentAnswer);
        }
        return this;
    }

    @JsonIgnore
    public Integer sizeOfAssessmentAnswer() {
        if (this.assessmentAnswer != null) {
            return this.assessmentAnswer.size();
        }
        return 0;
    }

    public List<AssessmentAnswer> getAssessmentAnswer() {
        return assessmentAnswer;
    }

    public void setAssessmentAnswer(List<AssessmentAnswer> _assessmentAnswer) {
        this.assessmentAnswer = _assessmentAnswer;
    }

    @JsonIgnore
    public List<AssessmentAnswer> getDeletedAssessmentAnswerList() {
        List<AssessmentAnswer> assessmentanswerToRemove = new java.util.ArrayList<AssessmentAnswer>();
        for (AssessmentAnswer _assessmentanswer : assessmentAnswer) {
            if (_assessmentanswer.isHardDelete()) {
                assessmentanswerToRemove.add(_assessmentanswer);
            }
        }
        assessmentAnswer.removeAll(assessmentanswerToRemove);
        return assessmentanswerToRemove;
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
        setValidatorassessmentAnswer(_validateFactory);
    }

    private void setValidatorassessmentAnswer(EntityValidatorHelper<Object> _validateFactory) {
        for (int i = 0; i < assessmentAnswer.size(); i++) {
            assessmentAnswer.get(i).setEntityValidator(_validateFactory);
        }
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
        if (this.assessmentAnswer == null) {
            this.assessmentAnswer = new java.util.ArrayList<AssessmentAnswer>();
        }
        for (AssessmentAnswer _assessmentAnswer : assessmentAnswer) {
            _assessmentAnswer.setEntityAudit(customerId, userId, recordType);
            _assessmentAnswer.setSystemInformation(recordType);
        }
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
        if (this.assessmentAnswer == null) {
            this.assessmentAnswer = new java.util.ArrayList<AssessmentAnswer>();
        }
        for (AssessmentAnswer _assessmentAnswer : assessmentAnswer) {
            _assessmentAnswer.setEntityAudit(customerId, userId);
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
            this.systemInfo.setActiveStatus(-1);
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
    public int compare(AssessmentQuestion object1, AssessmentQuestion object2) {
        return 0;
    }

    public String getPrimaryDisplay() {
        StringBuilder sb = new StringBuilder();
        sb.append("");
        sb.append((question == null ? " " : question));
        return sb.toString();
    }

    public String toString() {
        return getPrimaryDisplay();
    }

    public int hashCode() {
        if (questionId == null) {
            return super.hashCode();
        } else {
            return questionId.hashCode();
        }
    }

    public boolean equals(Object obj) {
        try {
            com.app.shared.survey.AssessmentQuestion other = (com.app.shared.survey.AssessmentQuestion) obj;
            if (questionId == null) {
                return false;
            } else if (!questionId.equals(other.questionId)) {
                return false;
            }
        } catch (java.lang.Exception ignore) {
            return false;
        }
        return true;
    }
}
