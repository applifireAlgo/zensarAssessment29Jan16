Ext.define('Assessmentapp.assessmentapp.web.com.view.assessmentcontext.survey.StartAssessment', {
     "xtype": "startAssessment",
     "name": "startAssessment",
     "items": [{
          "xtype": "combo",
          "name": "assesmentId",
          "margin": 5,
          "bindable": "assesmentId",
          "typeAhead": true,
          "queryMode": "local",
          "minChars": 1,
          "fieldLabel": "Assessment",
          "displayField": "assessmentName",
          "valueField": "assessmentId",
          "itemId": "ocdlkei",
          "store": {
               "model": "Assessmentapp.assessmentapp.shared.com.model.assessmentcontext.survey.AssessmentsModel",
               "autoLoad": true,
               "autoSync": true,
               "sorters": [{
                    "property": "assessmentName",
                    "direction": "ASC"
               }],
               "proxy": {
                    "type": "ajax",
                    "url": "secure/Assessments/findAll",
                    "actionMethods": {
                         "read": "GET"
                    },
                    "headers": {
                         "Content-Type": "application/json"
                    },
                    "extraParams": {},
                    "reader": {
                         "type": "json",
                         "rootProperty": "response.data"
                    }
               }
          }
     }, {
          "xtype": "button",
          "text": "Start Assessment",
          "isSubmitBtn": true,
          "margin": 5,
          "name": "submitStartAssessment",
          "itemId": "eodoioi",
          "height": 30,
          "width": 150,
          "listeners": {
               "click": "onsubmitStartAssessmentclick"
          }
     }],
     "border": true,
     "autoScroll": true,
     "title": "Start Assessment",
     "margin": 5,
     "itemId": "gbilifi",
     "dockedItems": [],
     "requires": ["Assessmentapp.assessmentapp.shared.com.model.assessmentcontext.survey.AssessmentsModel", "Assessmentapp.assessmentapp.web.com.controller.assessmentcontext.survey.StartAssessmentController", "Assessmentapp.assessmentapp.shared.com.viewmodel.assessmentcontext.survey.StartAssessmentViewModel", "Assessmentapp.assessmentapp.shared.com.model.assessmentcontext.survey.StartAssessmentModel"],
     "extend": "Ext.form.Panel",
     "viewModel": "StartAssessmentViewModel",
     "controller": "StartAssessmentController"
});