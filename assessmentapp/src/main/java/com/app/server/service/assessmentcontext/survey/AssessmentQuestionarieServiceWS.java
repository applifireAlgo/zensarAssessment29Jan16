package com.app.server.service.assessmentcontext.survey;
import com.app.server.businessservice.assessmentcontext.survey.AssessmentQuestionarieService;
import com.app.shared.assessmentcontext.survey.AssessmentQuestionarieDTO;
import com.athena.framework.server.bean.ResponseBean;
import com.athena.framework.server.exception.biz.SpartanBusinessValidationFailedException;
import com.athena.framework.server.exception.biz.SpartanDataNotFoundException;
import com.athena.framework.server.exception.biz.SpartanIncorrectDataException;
import com.athena.framework.server.exception.repository.SpartanPersistenceException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.context.annotation.ScopedProxyMode;
import org.springframework.http.HttpEntity;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
@Scope(value = "request", proxyMode = ScopedProxyMode.TARGET_CLASS)
@RequestMapping("/AssessmentQuestionarieServiceWS")
public class AssessmentQuestionarieServiceWS {

    @Autowired
    private AssessmentQuestionarieService assessmentquestionarieservice;

    @RequestMapping(value = "/saveAssessmentQuestionarie", consumes = "application/json", method = RequestMethod.POST)
    public HttpEntity<ResponseBean> saveAssessmentQuestionarie(@RequestBody AssessmentQuestionarieDTO assessmentQuestionarie) throws Exception, SpartanBusinessValidationFailedException, SpartanDataNotFoundException, SpartanIncorrectDataException, SpartanPersistenceException {
        com.athena.framework.server.bean.ResponseBean responseBean = new com.athena.framework.server.bean.ResponseBean();
        org.springframework.http.HttpStatus httpStatus = org.springframework.http.HttpStatus.CREATED;
        assessmentquestionarieservice.saveAssessmentQuestionarie(assessmentQuestionarie);
        responseBean.add("success", true);
        responseBean.add("message", "Successfully executed ");
        return new org.springframework.http.ResponseEntity<com.athena.framework.server.bean.ResponseBean>(responseBean, httpStatus);
    }
}
