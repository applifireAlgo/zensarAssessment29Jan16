package com.app.shared.assessmentcontext.survey.assessmentinferenceextdtofc;
import org.apache.camel.dataformat.bindy.annotation.DataField;
import javax.xml.bind.annotation.XmlRootElement;
import org.apache.camel.dataformat.bindy.annotation.CsvRecord;

@XmlRootElement
@CsvRecord(separator = ",", crlf = ",\n")
public class AssessmentInferenceExtDTO {

    @DataField(pos = 1)
    private String questionNumber;

    @DataField(pos = 2)
    private String inferenceKeyword;

    @DataField(pos = 3)
    private String inferenceHeading;

    @DataField(pos = 4)
    private String inferenceYesValue;

    @DataField(pos = 5)
    private String inferenceNoValue;

    public String getQuestionNumber() {
        return questionNumber;
    }

    public void setQuestionNumber(String _questionNumber) {
        this.questionNumber = _questionNumber;
    }

    public String getInferenceKeyword() {
        return inferenceKeyword;
    }

    public void setInferenceKeyword(String _inferenceKeyword) {
        this.inferenceKeyword = _inferenceKeyword;
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
}
