package com.app.shared.assessmentcontext.survey;
import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement
public class StartAssessMentDTO {

    private String assesmentId;

    public String getAssesmentId() {
        return assesmentId;
    }

    public void setAssesmentId(String _assesmentId) {
        this.assesmentId = _assesmentId;
    }
}
