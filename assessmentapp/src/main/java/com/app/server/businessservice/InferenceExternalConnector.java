package com.app.server.businessservice;
import org.springframework.stereotype.Service;
import com.athena.deo.camel.utility.ExternalIntegrationCaller;
import org.springframework.beans.factory.annotation.Autowired;
import com.app.shared.assessmentcontext.survey.assessmentinferenceextdtofc.AssessmentInferenceExtDTO;
import java.util.List;

@Service
public class InferenceExternalConnector {

    @Autowired
    private ExternalIntegrationCaller externalIntegrationCaller;

    public List<AssessmentInferenceExtDTO> processData() throws Exception {
        try {
            java.util.HashMap map = new java.util.HashMap();
            java.util.List<com.app.shared.assessmentcontext.survey.assessmentinferenceextdtofc.AssessmentInferenceExtDTO> assessmentinferenceextdto = (java.util.List<com.app.shared.assessmentcontext.survey.assessmentinferenceextdtofc.AssessmentInferenceExtDTO>) externalIntegrationCaller.executeRoute("C5FD6ABF-7D78-41AC-A2A3-A6BAB6E9DA9B", map);
            return assessmentinferenceextdto;
        } catch (java.lang.Exception e) {
            e.printStackTrace();
            throw e;
        }
    }
}
