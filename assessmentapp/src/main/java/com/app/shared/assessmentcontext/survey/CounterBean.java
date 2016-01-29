package com.app.shared.assessmentcontext.survey;
import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement
public class CounterBean {

    private Integer questionCount;

    public Integer getQuestionCount() {
        return questionCount;
    }

    public void setQuestionCount(Integer _questionCount) {
        this.questionCount = _questionCount;
    }
}
