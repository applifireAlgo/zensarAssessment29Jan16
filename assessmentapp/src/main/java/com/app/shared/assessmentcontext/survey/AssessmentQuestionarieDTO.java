package com.app.shared.assessmentcontext.survey;
import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement
public class AssessmentQuestionarieDTO {

    private String questionId;

    private String answerId;

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
}
