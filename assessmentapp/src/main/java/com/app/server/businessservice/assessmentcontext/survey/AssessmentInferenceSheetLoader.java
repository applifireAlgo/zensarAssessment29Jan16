package com.app.server.businessservice.assessmentcontext.survey;
import com.app.server.businessservice.InferenceExternalConnector;
import com.app.server.repository.QuestionInferenceRepository;
import com.app.shared.survey.QuestionInference;
import com.athena.framework.server.helper.RuntimeLogInfoHelper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import com.athena.framework.server.exception.biz.SpartanBusinessValidationFailedException;
import com.athena.framework.server.exception.repository.SpartanPersistenceException;

@Component
public class AssessmentInferenceSheetLoader {

    @Autowired
    private RuntimeLogInfoHelper runtimeLogInfoHelper;

    @Autowired
    private InferenceExternalConnector inferenceExternalConnector;

    @Autowired
    private QuestionInferenceRepository<QuestionInference> questionInferenceRepository;

    public void loadAssessmentInferenceFromSheet() throws SpartanBusinessValidationFailedException, SpartanPersistenceException, Exception {
        java.util.List<com.app.shared.assessmentcontext.survey.assessmentinferenceextdtofc.AssessmentInferenceExtDTO> assessmentinferenceextdtoList = inferenceExternalConnector.processData();
        if (assessmentinferenceextdtoList == null) {
            throw new com.athena.framework.server.exception.biz.SpartanBusinessValidationFailedException("3008");
        }
        for (com.app.shared.assessmentcontext.survey.assessmentinferenceextdtofc.AssessmentInferenceExtDTO assessmentinferenceextdtoListElement : assessmentinferenceextdtoList) {
            com.app.shared.survey.QuestionInference questionInference = new com.app.shared.survey.QuestionInference();
            questionInference.getSystemInfo().setActiveStatus(1);
            questionInference.setInferenceHeading(assessmentinferenceextdtoListElement.getInferenceHeading());
            questionInference.setInferenceKeyword(assessmentinferenceextdtoListElement.getInferenceKeyword());
            questionInference.setInferenceNoValue(assessmentinferenceextdtoListElement.getInferenceNoValue());
            questionInference.setInferenceYesValue(assessmentinferenceextdtoListElement.getInferenceYesValue());
            questionInference.setQuestionId(assessmentinferenceextdtoListElement.getQuestionNumber());
            com.app.shared.survey.QuestionInference questionInference1 = questionInferenceRepository.save(questionInference);
        }
    }
}
