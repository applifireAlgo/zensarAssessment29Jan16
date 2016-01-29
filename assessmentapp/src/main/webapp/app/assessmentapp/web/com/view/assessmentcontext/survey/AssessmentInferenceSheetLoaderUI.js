Ext.define('Assessmentapp.assessmentapp.web.com.view.assessmentcontext.survey.AssessmentInferenceSheetLoaderUI', {
     "xtype": "assessmentInferenceSheetLoaderUI",
     "name": "AssessmentInferenceSheetLoader",
     "items": [{
          "xtype": "button",
          "name": "button",
          "text": "Upload assessment Inference",
          "margin": 5,
          "itemId": "iolaepi",
          "listeners": {
               "click": "onbuttonclick"
          }
     }, {
          "xtype": "grids",
          "name": "assessmentInferenidceSheetLoaderGr",
          "title": "Inference",
          "hiddenName": "Grid",
          "margin": 5,
          "collapseMode": "header",
          "border": true,
          "editTools": false,
          "features": [],
          "plugins": [{
               "ptype": "cellediting",
               "clicksToEdit": 1
          }],
          "columns": [{
               "xtype": "gridcolumn",
               "header": "questionInferenceId",
               "hidden": true,
               "dataIndex": "questionInferenceId",
               "flex": 1
          }, {
               "xtype": "gridcolumn",
               "header": "questionId",
               "dataIndex": "questionId",
               "flex": 1
          }, {
               "xtype": "gridcolumn",
               "header": "inferenceKeyword",
               "dataIndex": "inferenceKeyword",
               "flex": 1
          }, {
               "xtype": "gridcolumn",
               "header": "inferenceHeading",
               "dataIndex": "inferenceHeading",
               "flex": 1
          }, {
               "xtype": "gridcolumn",
               "header": "inferenceYesValue",
               "dataIndex": "inferenceYesValue",
               "flex": 1
          }, {
               "xtype": "gridcolumn",
               "header": "inferenceNoValue",
               "dataIndex": "inferenceNoValue",
               "flex": 1
          }, {
               "xtype": "gridcolumn",
               "header": "createdBy",
               "hidden": true,
               "dataIndex": "createdBy",
               "flex": 1
          }, {
               "xtype": "gridcolumn",
               "header": "createdDate",
               "hidden": true,
               "dataIndex": "createdDate",
               "flex": 1
          }, {
               "xtype": "gridcolumn",
               "header": "updatedBy",
               "hidden": true,
               "dataIndex": "updatedBy",
               "flex": 1
          }, {
               "xtype": "gridcolumn",
               "header": "updatedDate",
               "hidden": true,
               "dataIndex": "updatedDate",
               "flex": 1
          }, {
               "xtype": "gridcolumn",
               "header": "versionId",
               "hidden": true,
               "dataIndex": "versionId",
               "flex": 1
          }, {
               "xtype": "gridcolumn",
               "header": "activeStatus",
               "hidden": true,
               "dataIndex": "activeStatus",
               "flex": 1
          }, {
               "xtype": "gridcolumn",
               "header": "txnAccessCode",
               "hidden": true,
               "dataIndex": "txnAccessCode",
               "flex": 1
          }],
          "itemId": "oogfafi",
          "store": {
               "model": "Assessmentapp.assessmentapp.shared.com.model.assessmentcontext.survey.QuestionInferenceModel",
               "autoLoad": true,
               "autoSync": true,
               "proxy": {
                    "type": "ajax",
                    "url": "secure/QuestionInference/findAll",
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
          },
          "tools": [{
               "type": "refresh",
               "tooltip": "Refresh Grid Data",
               "handler": "onGridRefreshClick"
          }]
     }],
     "border": true,
     "autoScroll": true,
     "title": "Assessment Inference Sheet Loader",
     "margin": 5,
     "itemId": "gkkoomi",
     "dockedItems": [],
     "requires": ["Assessmentapp.assessmentapp.shared.com.model.assessmentcontext.survey.QuestionInferenceModel", "Assessmentapp.assessmentapp.web.com.controller.assessmentcontext.survey.AssessmentInferenceSheetLoaderUIController", "Assessmentapp.assessmentapp.shared.com.viewmodel.assessmentcontext.survey.AssessmentInferenceSheetLoaderUIViewModel", "Assessmentapp.assessmentapp.shared.com.model.assessmentcontext.survey.AssessmentInferenceSheetLoaderUIModel", "Assessmentapp.view.fw.component.Grids"],
     "extend": "Ext.form.Panel",
     "viewModel": "AssessmentInferenceSheetLoaderUIViewModel",
     "controller": "AssessmentInferenceSheetLoaderUIController"
});