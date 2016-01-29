Ext.define('Assessmentapp.assessmentapp.web.com.view.assessmentcontext.survey.AssessmentQuestionarie', {
     "xtype": "assessmentQuestionarie",
     "name": "assessmentQuestionarie",
     "items": [{
          "xtype": "hiddenfield",
          "fieldLabel": "questionId",
          "bindable": "questionId",
          "margin": 5,
          "name": "questionId",
          "title": "questionId",
          "itemId": "enfldci"
     }, {
          "xtype": "displayfield",
          "fieldLabel": "Questions",
          "margin": 5,
          "bindable": "question",
          "name": "question",
          "title": "Questions",
          "itemId": "fjdkobi"
     }, {
          "xtype": "radiogroup",
          "name": "answerId",
          "fieldLabel": "Answer",
          "columns": 2,
          "vertical": true,
          "margin": 5,
          "groupData": "answerId",
          "isDynamic": true,
          "itemId": "fmjcjpi",
          "inputValue": "answerId",
          "items": [{
               "boxLabel": "Yes",
               "inputValue": "1",
               "name": "answerId",
               "checked": true
          }, {
               "boxLabel": "No",
               "inputValue": "2",
               "name": "answerId",
               "checked": false
          }],
          "bindable": "answerId"
     }, {
          "xtype": "button",
          "text": "Submit",
          "isSubmitBtn": true,
          "margin": 5,
          "name": "Submit",
          "itemId": "cknchbi",
          "listeners": {
               "click": "onSubmitclick"
          }
     }],
     "border": true,
     "autoScroll": true,
     "title": "Assessment Questionarie",
     "margin": 5,
     "itemId": "aboeppi",
     "dockedItems": [],
     "extend": "Ext.form.Panel",
     "listeners": {
          "afterrender": "onassessmentQuestionarieafterrender",
          "scope": "controller"
     },
     "requires": ["Assessmentapp.assessmentapp.web.com.controller.assessmentcontext.survey.AssessmentQuestionarieController", "Assessmentapp.assessmentapp.shared.com.viewmodel.assessmentcontext.survey.AssessmentQuestionarieViewModel", "Assessmentapp.assessmentapp.shared.com.model.assessmentcontext.survey.AssessmentQuestionarieModel"],
     "viewModel": "AssessmentQuestionarieViewModel",
     "controller": "AssessmentQuestionarieController"
});