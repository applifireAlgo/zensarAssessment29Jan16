package com.app.server.businessservice.assessmentcontext.survey;
import com.app.server.repository.AssessmentTranRepository;
import com.app.server.repository.AssessmentsRepository;
import com.app.shared.survey.AssessmentTran;
import com.app.shared.survey.Assessments;
import com.athena.framework.server.helper.RuntimeLogInfoHelper;
import com.spartan.shield.sessionService.SessionDataMgtService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import com.app.shared.assessmentcontext.survey.StartAssessMentDTO;
import com.athena.framework.server.exception.biz.SpartanBusinessValidationFailedException;
import com.athena.framework.server.exception.repository.SpartanPersistenceException;

@Component
public class StartAssessmentService {

    @Autowired
    private RuntimeLogInfoHelper runtimeLogInfoHelper;

    @Autowired
    private AssessmentTranRepository<AssessmentTran> assessmentTranRepository;

    @Autowired
    private SessionDataMgtService sessionService;

    @Autowired
    private AssessmentsRepository<Assessments> assessmentsRepository;

    public void startAssessment(StartAssessMentDTO startAssessMentDTO) throws SpartanBusinessValidationFailedException, SpartanPersistenceException, Exception {
        if (startAssessMentDTO.getAssesmentId() == null) {
            throw new com.athena.framework.server.exception.biz.SpartanBusinessValidationFailedException("3007");
        }
        com.app.shared.survey.AssessmentTran assessmentTran = new com.app.shared.survey.AssessmentTran();
        assessmentTran.setAssessmentId(startAssessMentDTO.getAssesmentId());
        assessmentTran.setAssessmentStartsAt(java.lang.System.currentTimeMillis());
        assessmentTran.setStartTime(new java.sql.Timestamp(java.lang.System.currentTimeMillis()));
        assessmentTran.setStatusCode(10);
        assessmentTran.setUserId(runtimeLogInfoHelper.getRuntimeLogInfo().getUserId());
        assessmentTran.getSystemInfo().setActiveStatus(1);
        com.app.shared.survey.AssessmentTran assessmentTran1 = assessmentTranRepository.save(assessmentTran);
        sessionService.setSessionAttribute("assessmentTranId", assessmentTran1.getAssessmentTranId());
        com.app.shared.survey.Assessments assessments = assessmentsRepository.findById(startAssessMentDTO.getAssesmentId());
        sessionService.setSessionAttribute("questionId", assessments.getFirstQuestionId());
    }
}
