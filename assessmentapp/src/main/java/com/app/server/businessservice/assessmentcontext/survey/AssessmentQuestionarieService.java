package com.app.server.businessservice.assessmentcontext.survey;
import com.app.server.repository.AssessmentTranRepository;
import com.app.server.repository.AssessmentsRepository;
import com.app.server.repository.QuestionLinkageRepository;
import com.app.server.repository.UserAssessmentRepository;
import com.app.server.repository.UserAssessmentTempRepository;
import com.app.shared.survey.AssessmentTran;
import com.app.shared.survey.Assessments;
import com.app.shared.survey.QuestionLinkage;
import com.app.shared.survey.UserAssessment;
import com.app.shared.survey.UserAssessmentTemp;
import com.athena.framework.server.helper.RuntimeLogInfoHelper;
import com.spartan.shield.sessionService.SessionDataMgtService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import com.app.shared.assessmentcontext.survey.AssessmentQuestionarieDTO;
import com.athena.framework.server.exception.biz.SpartanBusinessValidationFailedException;
import com.athena.framework.server.exception.biz.SpartanDataNotFoundException;
import com.athena.framework.server.exception.repository.SpartanPersistenceException;

@Component
public class AssessmentQuestionarieService {

    @Autowired
    private RuntimeLogInfoHelper runtimeLogInfoHelper;

    @Autowired
    private QuestionLinkageRepository<QuestionLinkage> questionLinkageRepository;

    @Autowired
    private AssessmentTranRepository<AssessmentTran> assessmentTranRepository;

    @Autowired
    private UserAssessmentRepository<UserAssessment> userAssessmentRepository;

    @Autowired
    private SessionDataMgtService sessionService;

    @Autowired
    private AssessmentsRepository<Assessments> assessmentsRepository;

    @Autowired
    private UserAssessmentTempRepository<UserAssessmentTemp> userAssessmentTempRepository;

    public void saveAssessmentQuestionarie(AssessmentQuestionarieDTO assessmentQuestionarie) throws SpartanBusinessValidationFailedException, SpartanDataNotFoundException, SpartanPersistenceException, Exception {
        java.lang.String assessmentTranIdFromSession = (java.lang.String) sessionService.getSessionData("assessmentTranId");
        if (assessmentTranIdFromSession == null) {
            throw new com.athena.framework.server.exception.biz.SpartanDataNotFoundException("Data not found in session");
        }
        if (assessmentQuestionarie.getAnswerId() == null || assessmentQuestionarie.getAnswerId().equals("") || assessmentQuestionarie.getQuestionId() == null || assessmentQuestionarie.getQuestionId().equals("")) {
            throw new com.athena.framework.server.exception.biz.SpartanBusinessValidationFailedException("3007");
        }
        com.app.shared.survey.AssessmentTran assessmentTran = assessmentTranRepository.findById(assessmentTranIdFromSession);
        com.app.shared.survey.Assessments assessments = assessmentsRepository.findById(assessmentTran.getAssessmentId());
        com.app.shared.survey.UserAssessmentTemp userAssessmentTemp = new com.app.shared.survey.UserAssessmentTemp();
        userAssessmentTemp.setAnswerId(assessmentQuestionarie.getAnswerId());
        userAssessmentTemp.setQuestionId(assessmentQuestionarie.getQuestionId());
        userAssessmentTemp.setAssessmentTranId(assessmentTran.getAssessmentTranId());
        userAssessmentTemp.setUserId(runtimeLogInfoHelper.getRuntimeLogInfo().getUserId());
        com.app.shared.survey.UserAssessmentTemp userAssessmentTemp1 = userAssessmentTempRepository.save(userAssessmentTemp);
        com.app.shared.survey.QuestionLinkage questionLinkage = questionLinkageRepository.FindLinkageByQuestionAnswer(assessmentQuestionarie.getQuestionId(), assessmentQuestionarie.getAnswerId());
        if (questionLinkage.getLastGenQuestion() == true) {
            java.util.List<com.app.shared.survey.UserAssessmentTemp> userAssessmentTempList2 = userAssessmentTempRepository.findByAssessmentTranId(assessmentTranIdFromSession);
            for (com.app.shared.survey.UserAssessmentTemp userAssessmentTempList2Element : userAssessmentTempList2) {
                com.app.shared.survey.UserAssessment userAssessment = new com.app.shared.survey.UserAssessment();
                userAssessment.getSystemInfo().setActiveStatus(1);
                userAssessment.setAnswerId(userAssessmentTempList2Element.getAnswerId());
                userAssessment.setAssessmentTranId(userAssessmentTempList2Element.getAssessmentTranId());
                userAssessment.setQuestionId(userAssessmentTempList2Element.getQuestionId());
                userAssessment.setUserId(userAssessmentTempList2Element.getUserId());
                com.app.shared.survey.UserAssessment userAssessment1 = userAssessmentRepository.save(userAssessment);
                userAssessmentTempRepository.delete(userAssessmentTempList2Element.getUserAssessmentId());
            }
            assessmentTran.setEndTime(new java.sql.Timestamp(java.lang.System.currentTimeMillis()));
            assessmentTran.setStatusCode(20);
            assessmentTranRepository.update(assessmentTran);
            throw new com.athena.framework.server.exception.biz.SpartanBusinessValidationFailedException("3009");
        }
        sessionService.setSessionAttribute("questionId", questionLinkage.getLinkedQuestionId());
    }
}
