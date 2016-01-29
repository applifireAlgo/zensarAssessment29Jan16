package com.app.server.businessservice;
import org.springframework.stereotype.Service;
import com.athena.deo.camel.utility.ExternalIntegrationCaller;
import org.springframework.beans.factory.annotation.Autowired;
import com.app.shared.assessmentcontext.survey.assessmentquestionsextdtofc.AssessmentQuestionsExtDTO;
import java.util.List;

@Service
public class QuestionsExternalConnector {

    @Autowired
    private ExternalIntegrationCaller externalIntegrationCaller;

    public List<AssessmentQuestionsExtDTO> processData() throws Exception {
        try {
            java.util.HashMap map = new java.util.HashMap();
            java.util.List<com.app.shared.assessmentcontext.survey.assessmentquestionsextdtofc.AssessmentQuestionsExtDTO> assessmentquestionsextdto = (java.util.List<com.app.shared.assessmentcontext.survey.assessmentquestionsextdtofc.AssessmentQuestionsExtDTO>) externalIntegrationCaller.executeRoute("B07D1DE0-620C-46DB-A2D1-DCEB679B2C39", map);
            return assessmentquestionsextdto;
        } catch (java.lang.Exception e) {
            e.printStackTrace();
            throw e;
        }
    }
}
