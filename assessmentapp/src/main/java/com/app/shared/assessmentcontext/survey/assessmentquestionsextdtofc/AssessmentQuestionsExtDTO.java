package com.app.shared.assessmentcontext.survey.assessmentquestionsextdtofc;
import org.apache.camel.dataformat.bindy.annotation.DataField;
import javax.xml.bind.annotation.XmlRootElement;
import org.apache.camel.dataformat.bindy.annotation.CsvRecord;

@XmlRootElement
@CsvRecord(separator = ",", crlf = ",\n")
public class AssessmentQuestionsExtDTO {

    @DataField(pos = 1)
    private String questionNumber;

    @DataField(pos = 2)
    private String question;

    @DataField(pos = 3)
    private String yesLinkedQuestion;

    @DataField(pos = 4)
    private String noLinkedQuestion;

    @DataField(pos = 5)
    private String keywordForInference;

    public String getQuestionNumber() {
        return questionNumber;
    }

    public void setQuestionNumber(String _questionNumber) {
        this.questionNumber = _questionNumber;
    }

    public String getQuestion() {
        return question;
    }

    public void setQuestion(String _question) {
        this.question = _question;
    }

    public String getYesLinkedQuestion() {
        return yesLinkedQuestion;
    }

    public void setYesLinkedQuestion(String _yesLinkedQuestion) {
        this.yesLinkedQuestion = _yesLinkedQuestion;
    }

    public String getNoLinkedQuestion() {
        return noLinkedQuestion;
    }

    public void setNoLinkedQuestion(String _noLinkedQuestion) {
        this.noLinkedQuestion = _noLinkedQuestion;
    }

    public String getKeywordForInference() {
        return keywordForInference;
    }

    public void setKeywordForInference(String _keywordForInference) {
        this.keywordForInference = _keywordForInference;
    }
}
