package com.app.server.businessservice.assessmentcontext.survey;
import com.app.server.repository.AssessmentQuestionRepository;
import com.app.shared.survey.AssessmentQuestion;
import com.athena.framework.server.helper.RuntimeLogInfoHelper;
import com.spartan.shield.sessionService.SessionDataMgtService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import com.athena.framework.server.exception.biz.SpartanDataNotFoundException;
import com.athena.framework.server.exception.biz.SpartanUnableToProcessException;
import com.athena.framework.server.exception.repository.SpartanPersistenceException;

@Component
public class FetchAssessmentQuestionarieService {

    @Autowired
    private RuntimeLogInfoHelper runtimeLogInfoHelper;

    @Autowired
    private AssessmentQuestionRepository<AssessmentQuestion> assessmentQuestionRepository;

    @Autowired
    private SessionDataMgtService sessionService;

    public AssessmentQuestion fetchData() throws SpartanUnableToProcessException, SpartanDataNotFoundException, SpartanPersistenceException, Exception {
        java.lang.String questionIdFromSession = (java.lang.String) sessionService.getSessionData("questionId");
        if (questionIdFromSession == null) {
            throw new com.athena.framework.server.exception.biz.SpartanDataNotFoundException("Data not found in session");
        }
        com.app.shared.survey.AssessmentQuestion assessmentQuestion = assessmentQuestionRepository.findById(questionIdFromSession);
        return assessmentQuestion;
    }
}
