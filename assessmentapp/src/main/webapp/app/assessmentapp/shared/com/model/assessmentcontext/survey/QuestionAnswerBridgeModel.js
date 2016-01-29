Ext.define('Assessmentapp.assessmentapp.shared.com.model.assessmentcontext.survey.QuestionAnswerBridgeModel', {
     "extend": "Ext.data.Model",
     "fields": [{
          "name": "primaryKey",
          "type": "int",
          "defaultValue": ""
     }, {
          "name": "questionanswerbridgePkey",
          "type": "int",
          "defaultValue": ""
     }, {
          "name": "questionid",
          "reference": "AssessmentQuestion",
          "defaultValue": ""
     }, {
          "name": "answerid",
          "reference": "AssessmentAnswer",
          "defaultValue": ""
     }, {
          "name": "entityAudit",
          "reference": "EntityAudit"
     }, {
          "name": "primaryDisplay",
          "type": "string",
          "defaultValue": ""
     }]
});