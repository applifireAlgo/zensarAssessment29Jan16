package com.app.server.businessservice.assessmentcontext.survey;
import com.app.server.businessservice.QuestionsExternalConnector;
import com.app.server.repository.AssessmentAnswerRepository;
import com.app.server.repository.AssessmentQuestionRepository;
import com.app.server.repository.QuestionLinkageRepository;
import com.app.shared.survey.AssessmentAnswer;
import com.app.shared.survey.AssessmentQuestion;
import com.app.shared.survey.QuestionLinkage;
import com.athena.framework.server.helper.RuntimeLogInfoHelper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import com.athena.framework.server.exception.biz.SpartanBusinessValidationFailedException;
import com.athena.framework.server.exception.repository.SpartanPersistenceException;

@Component
public class AssessmentQuestionSheetLoader {

    @Autowired
    private RuntimeLogInfoHelper runtimeLogInfoHelper;

    @Autowired
    private QuestionLinkageRepository<QuestionLinkage> questionLinkageRepository;

    @Autowired
    private AssessmentQuestionRepository<AssessmentQuestion> assessmentQuestionRepository;

    @Autowired
    private QuestionsExternalConnector questionsExternalConnector;

    @Autowired
    private AssessmentAnswerRepository<AssessmentAnswer> assessmentAnswerRepository;

    public void loadQuestionsFromSheet() throws SpartanBusinessValidationFailedException, SpartanPersistenceException, Exception {
        java.util.List<com.app.shared.assessmentcontext.survey.assessmentquestionsextdtofc.AssessmentQuestionsExtDTO> assessmentquestionsextdtoList = questionsExternalConnector.processData();
        if (assessmentquestionsextdtoList == null) {
            throw new com.athena.framework.server.exception.biz.SpartanBusinessValidationFailedException("3008");
        }
        java.util.List<com.app.shared.survey.AssessmentAnswer> assessmentAnswerList = assessmentAnswerRepository.findAll();
        for (com.app.shared.assessmentcontext.survey.assessmentquestionsextdtofc.AssessmentQuestionsExtDTO assessmentquestionsextdtoListElement : assessmentquestionsextdtoList) {
            com.app.shared.survey.AssessmentQuestion assessmentQuestion1 = new com.app.shared.survey.AssessmentQuestion();
            assessmentQuestion1.getSystemInfo().setActiveStatus(1);
            assessmentQuestion1.setAssessmentAnswer(assessmentAnswerList);
            assessmentQuestion1.setQuestion(assessmentquestionsextdtoListElement.getQuestion());
            assessmentQuestion1.setQuestionId(assessmentquestionsextdtoListElement.getQuestionNumber());
            assessmentQuestion1.setQuestionInference(java.lang.Boolean.valueOf(false));
            if (assessmentquestionsextdtoListElement.getKeywordForInference() != null && assessmentquestionsextdtoListElement.getKeywordForInference() != "") {
                assessmentQuestion1.setQuestionInference(java.lang.Boolean.valueOf(true));
            }
            com.app.shared.survey.AssessmentQuestion assessmentQuestion2 = assessmentQuestionRepository.save(assessmentQuestion1);
        }
        com.app.shared.assessmentcontext.survey.CounterBean counterBean = new com.app.shared.assessmentcontext.survey.CounterBean();
        counterBean.setQuestionCount(0);
        for (com.app.shared.assessmentcontext.survey.assessmentquestionsextdtofc.AssessmentQuestionsExtDTO assessmentquestionsextdtoListElement1 : assessmentquestionsextdtoList) {
            com.app.shared.survey.QuestionLinkage questionLinkage = new com.app.shared.survey.QuestionLinkage();
            questionLinkage.getSystemInfo().setActiveStatus(1);
            questionLinkage.setAnswerId(java.lang.String.valueOf(1));
            questionLinkage.setFirstGenQuestion(java.lang.Boolean.valueOf(false));
            questionLinkage.setLastGenQuestion(java.lang.Boolean.valueOf(false));
            questionLinkage.setLinkedQuestionId(assessmentquestionsextdtoListElement1.getYesLinkedQuestion());
            questionLinkage.setQuestionId(assessmentquestionsextdtoListElement1.getQuestionNumber());
            com.app.shared.survey.QuestionLinkage questionLinkage1 = new com.app.shared.survey.QuestionLinkage();
            questionLinkage1.getSystemInfo().setActiveStatus(1);
            questionLinkage1.setAnswerId(java.lang.String.valueOf(2));
            questionLinkage1.setFirstGenQuestion(java.lang.Boolean.valueOf(false));
            questionLinkage1.setLastGenQuestion(java.lang.Boolean.valueOf(false));
            questionLinkage1.setLinkedQuestionId(assessmentquestionsextdtoListElement1.getNoLinkedQuestion());
            questionLinkage1.setQuestionId(assessmentquestionsextdtoListElement1.getQuestionNumber());
            if (counterBean.getQuestionCount() == 0) {
                questionLinkage.setFirstGenQuestion(java.lang.Boolean.valueOf(true));
                questionLinkage1.setFirstGenQuestion(java.lang.Boolean.valueOf(true));
            }
            counterBean.setQuestionCount(counterBean.getQuestionCount() + 1);
            if (assessmentquestionsextdtoListElement1.getYesLinkedQuestion().equals("-1")) {
                questionLinkage.setLastGenQuestion(java.lang.Boolean.valueOf(true));
            }
            if (assessmentquestionsextdtoListElement1.getNoLinkedQuestion().equals("-1")) {
                questionLinkage1.setLastGenQuestion(java.lang.Boolean.valueOf(true));
            }
            com.app.shared.survey.QuestionLinkage questionLinkage2 = questionLinkageRepository.save(questionLinkage);
            com.app.shared.survey.QuestionLinkage questionLinkage3 = questionLinkageRepository.save(questionLinkage1);
        }
    }
}
