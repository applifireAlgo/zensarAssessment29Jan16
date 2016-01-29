package com.app.server.businessservice;
import com.app.server.repository.AssessmentQuestionRepository;
import com.app.shared.survey.AssessmentQuestion;
import com.athena.framework.server.exception.repository.SpartanPersistenceException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import java.util.List;

@Component
public class AssessmentQuestionBusinessService {

    @Autowired
    private AssessmentQuestionRepository assessmentQuestionRepository;

    public void update(AssessmentQuestion entity) throws SpartanPersistenceException {
        try {
            if (entity.isHardDelete()) {
                assessmentQuestionRepository.delete(entity.getQuestionId());
            } else {
                assessmentQuestionRepository.deleteAssessmentAnswer(entity.getDeletedAssessmentAnswerList());
                assessmentQuestionRepository.update(entity);
            }
        } catch (javax.persistence.PersistenceException e) {
            throw new com.athena.framework.server.exception.repository.SpartanPersistenceException("Error in entity creation", e);
        } catch (Exception e) {
            throw new com.athena.framework.server.exception.repository.SpartanPersistenceException("Error while updating entity", e);
        }
    }

    public void update(List<AssessmentQuestion> entity) throws SpartanPersistenceException {
        try {
            for (AssessmentQuestion _assessmentquestion : entity) {
                if (_assessmentquestion.isHardDelete()) {
                    assessmentQuestionRepository.delete(_assessmentquestion.getQuestionId());
                } else {
                    assessmentQuestionRepository.deleteAssessmentAnswer(_assessmentquestion.getDeletedAssessmentAnswerList());
                    assessmentQuestionRepository.update(_assessmentquestion);
                }
            }
        } catch (javax.persistence.PersistenceException e) {
            throw new com.athena.framework.server.exception.repository.SpartanPersistenceException("Error in updating Entity", e);
        } catch (Exception e) {
            throw new com.athena.framework.server.exception.repository.SpartanPersistenceException("Error while updating entity", e);
        }
    }
}
