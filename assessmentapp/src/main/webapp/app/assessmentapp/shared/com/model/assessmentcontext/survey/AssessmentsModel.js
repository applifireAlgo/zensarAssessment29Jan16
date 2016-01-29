Ext.define('Assessmentapp.assessmentapp.shared.com.model.assessmentcontext.survey.AssessmentsModel', {
     "extend": "Ext.data.Model",
     "fields": [{
          "name": "primaryKey",
          "type": "string",
          "defaultValue": ""
     }, {
          "name": "assessmentId",
          "type": "string",
          "defaultValue": ""
     }, {
          "name": "assessmentName",
          "type": "string",
          "defaultValue": ""
     }, {
          "name": "duration",
          "type": "int",
          "defaultValue": ""
     }, {
          "name": "firstquestionid",
          "reference": "AssessmentQuestion",
          "defaultValue": ""
     }, {
          "name": "versionId",
          "type": "int",
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