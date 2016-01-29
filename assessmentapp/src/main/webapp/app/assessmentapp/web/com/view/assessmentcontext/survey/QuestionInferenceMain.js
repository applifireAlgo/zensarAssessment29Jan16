Ext.define('Assessmentapp.assessmentapp.web.com.view.assessmentcontext.survey.QuestionInferenceMain', {
     "extend": "Ext.tab.Panel",
     "customWidgetType": "vdTabLayout",
     "autoScroll": false,
     "controller": "QuestionInferenceMainController",
     "restURL": "/QuestionInference",
     "defaults": {
          "split": true
     },
     "requires": ["Assessmentapp.assessmentapp.shared.com.model.assessmentcontext.survey.QuestionInferenceModel", "Assessmentapp.assessmentapp.web.com.controller.assessmentcontext.survey.QuestionInferenceMainController", "Assessmentapp.assessmentapp.shared.com.model.assessmentcontext.survey.AssessmentQuestionModel", "Assessmentapp.assessmentapp.shared.com.viewmodel.assessmentcontext.survey.QuestionInferenceViewModel"],
     "communicationLog": [],
     "tabPosition": "bottom",
     "items": [{
          "title": "Data Browser",
          "layout": "border",
          "defaults": {
               "split": true
          },
          "autoScroll": false,
          "customWidgetType": "vdBorderLayout",
          "items": [{
               "xtype": "tabpanel",
               "customWidgetType": "vdTabLayout",
               "displayName": "QuestionInference",
               "name": "QuestionInferenceTreeContainer",
               "itemId": "QuestionInferenceTreeContainer",
               "margin": "5 0 5 5",
               "autoScroll": false,
               "collapsible": true,
               "titleCollapse": true,
               "collapseMode": "header",
               "collapsed": false,
               "items": [{
                    "xtype": "treepanel",
                    "customWidgetType": "vdTree",
                    "useArrows": true,
                    "title": "Browse",
                    "rootVisible": false,
                    "itemId": "QuestionInferenceTree",
                    "listeners": {
                         "select": "treeClick"
                    },
                    "tbar": [{
                         "xtype": "triggerfield",
                         "customWidgetType": "vdTriggerField",
                         "emptyText": "Search",
                         "triggerCls": "",
                         "listeners": {
                              "change": "onTriggerfieldChange",
                              "buffer": 250
                         }
                    }, "->", {
                         "xtype": "tool",
                         "type": "refresh",
                         "tooltip": "Refresh Tree Data",
                         "handler": "onTreeRefreshClick"
                    }]
               }, {
                    "title": "Advance Search",
                    "xtype": "form",
                    "customWidgetType": "vdFormpanel",
                    "layout": "fit",
                    "autoScroll": false,
                    "itemId": "queryPanel",
                    "buttons": [{
                         "text": "Filter",
                         "handler": "onFilterClick"
                    }],
                    "items": []
               }],
               "region": "west",
               "width": "20%"
          }, {
               "region": "center",
               "layout": "border",
               "defaults": {
                    "split": true
               },
               "customWidgetType": "vdBorderLayout",
               "items": [{
                    "xtype": "form",
                    "displayName": "QuestionInference",
                    "name": "QuestionInference",
                    "itemId": "QuestionInferenceForm",
                    "bodyPadding": 10,
                    "items": [{
                         "xtype": "form",
                         "itemId": "form0",
                         "customWidgetType": "vdCard",
                         "header": {
                              "hidden": true
                         },
                         "items": [{
                              "layout": "column",
                              "customWidgetType": "vdColumnLayout",
                              "header": {
                                   "hidden": true
                              },
                              "xtype": "panel",
                              "items": [{
                                   "name": "questionInferenceId",
                                   "itemId": "questionInferenceId",
                                   "xtype": "textfield",
                                   "customWidgetType": "vdTextfield",
                                   "displayName": "Question Inference Id",
                                   "margin": "5 5 5 5",
                                   "fieldLabel": "Question Inference Id<font color='red'> *<\/font>",
                                   "fieldId": "62F91E84-FBE2-435E-B03A-AEA4255AAC52",
                                   "hidden": true,
                                   "value": "",
                                   "bindable": "questionInferenceId",
                                   "bind": "{questionInferenceId}"
                              }, {
                                   "name": "questionId",
                                   "itemId": "questionId",
                                   "xtype": "combo",
                                   "customWidgetType": "vdCombo",
                                   "displayName": "QuestionId",
                                   "margin": "5 5 5 5",
                                   "fieldLabel": "QuestionId<font color='red'> *<\/font>",
                                   "allowBlank": false,
                                   "fieldId": "F87B3B2A-512D-4238-8BC6-D84554E5507E",
                                   "restURL": "AssessmentQuestion",
                                   "displayField": "primaryDisplay",
                                   "valueField": "primaryKey",
                                   "typeAhead": true,
                                   "queryMode": "local",
                                   "minChars": 2,
                                   "store": {
                                        "data": [],
                                        "model": "Assessmentapp.assessmentapp.shared.com.model.assessmentcontext.survey.AssessmentQuestionModel"
                                   },
                                   "bindable": "questionId",
                                   "columnWidth": 0.5,
                                   "bind": "{questionId}"
                              }, {
                                   "name": "inferenceKeyword",
                                   "itemId": "inferenceKeyword",
                                   "xtype": "textareafield",
                                   "customWidgetType": "vdTextareafield",
                                   "displayName": "Inference Keyword",
                                   "margin": "5 5 5 5",
                                   "fieldLabel": "Inference Keyword<font color='red'> *<\/font>",
                                   "allowBlank": false,
                                   "fieldId": "AE1F8F21-F35D-468F-B186-ED08295CCC7C",
                                   "bindable": "inferenceKeyword",
                                   "columnWidth": 0.5,
                                   "bind": "{inferenceKeyword}"
                              }, {
                                   "name": "inferenceHeading",
                                   "itemId": "inferenceHeading",
                                   "xtype": "textfield",
                                   "customWidgetType": "vdTextfield",
                                   "displayName": "Inference Heading",
                                   "margin": "5 5 5 5",
                                   "fieldLabel": "Inference Heading",
                                   "fieldId": "47CD64E8-E5D8-4D69-9FC7-A3EE5EE66DE7",
                                   "minLength": "0",
                                   "maxLength": "256",
                                   "bindable": "inferenceHeading",
                                   "columnWidth": 0.5,
                                   "bind": "{inferenceHeading}"
                              }, {
                                   "name": "inferenceYesValue",
                                   "itemId": "inferenceYesValue",
                                   "xtype": "textfield",
                                   "customWidgetType": "vdTextfield",
                                   "displayName": "Inference Yes Value",
                                   "margin": "5 5 5 5",
                                   "fieldLabel": "Inference Yes Value",
                                   "fieldId": "08822BEB-399F-48C0-A7A8-9654A9926872",
                                   "minLength": "0",
                                   "maxLength": "256",
                                   "bindable": "inferenceYesValue",
                                   "columnWidth": 0.5,
                                   "bind": "{inferenceYesValue}"
                              }, {
                                   "name": "inferenceNoValue",
                                   "itemId": "inferenceNoValue",
                                   "xtype": "textfield",
                                   "customWidgetType": "vdTextfield",
                                   "displayName": "Inference No Value",
                                   "margin": "5 5 5 5",
                                   "fieldLabel": "Inference No Value",
                                   "fieldId": "8F31DB9C-0936-4510-9F32-A2858180401E",
                                   "minLength": "0",
                                   "maxLength": "256",
                                   "bindable": "inferenceNoValue",
                                   "columnWidth": 0.5,
                                   "bind": "{inferenceNoValue}"
                              }, {
                                   "name": "versionId",
                                   "itemId": "versionId",
                                   "xtype": "numberfield",
                                   "customWidgetType": "vdNumberfield",
                                   "displayName": "versionId",
                                   "margin": "5 5 5 5",
                                   "value": "-1",
                                   "fieldLabel": "versionId",
                                   "fieldId": "05074EF4-C4A8-43F9-8525-13274419C48D",
                                   "bindable": "versionId",
                                   "bind": "{versionId}",
                                   "hidden": true
                              }]
                         }]
                    }],
                    "tools": [{
                         "type": "help",
                         "tooltip": "Get Console",
                         "handler": "onConsoleClick"
                    }, {
                         "type": "refresh",
                         "tooltip": "Refresh Tab",
                         "handler": "init"
                    }],
                    "layout": "card",
                    "defaults": {
                         "autoScroll": true
                    },
                    "autoScroll": true,
                    "dockedItems": [{
                         "xtype ": "toolbar",
                         "customWidgetType": "vdBBar",
                         "dock": "bottom",
                         "margin": 0,
                         "isDockedItem": true,
                         "items": [{
                              "xtype": "tbfill",
                              "customWidgetType": "vdTbFill"
                         }, {
                              "xtype": "button",
                              "customWidgetType": "vdButton",
                              "margin": "0 5 0 5",
                              "text": "Save",
                              "hiddenName": "button",
                              "canHaveParent": false,
                              "itemId": "saveFormButton",
                              "listeners": {
                                   "click": "saveForm"
                              }
                         }, {
                              "xtype": "button",
                              "customWidgetType": "vdButton",
                              "margin": "0 5 0 5",
                              "text": "Reset",
                              "hiddenName": "button",
                              "canHaveParent": false,
                              "itemId": "resetFormButton",
                              "listeners": {
                                   "click": "resetForm"
                              }
                         }],
                         "defaults": {
                              "margin": "0 5 0 5"
                         }
                    }],
                    "viewModel": "QuestionInferenceViewModel",
                    "listeners": {},
                    "extend": "Ext.form.Panel",
                    "region": "center",
                    "customWidgetType": "vdCardLayout"
               }, {
                    "xtype": "grid",
                    "customWidgetType": "vdGrid",
                    "displayName": "QuestionInference",
                    "title": "Details Grid",
                    "name": "QuestionInferenceGrid",
                    "itemId": "QuestionInferenceGrid",
                    "store": [],
                    "bodyPadding": 10,
                    "requires": [],
                    "columns": [{
                         "header": "Question Inference Id",
                         "dataIndex": "questionInferenceId",
                         "hidden": true,
                         "flex": 1
                    }, {
                         "header": "primaryKey",
                         "dataIndex": "primaryKey",
                         "hidden": true
                    }, {
                         "header": "QuestionId",
                         "dataIndex": "questionId",
                         "renderer": "renderFormValue",
                         "flex": 1
                    }, {
                         "header": "Inference Keyword",
                         "dataIndex": "inferenceKeyword",
                         "flex": 1
                    }, {
                         "header": "Inference Heading",
                         "dataIndex": "inferenceHeading",
                         "flex": 1
                    }, {
                         "header": "Inference Yes Value",
                         "dataIndex": "inferenceYesValue",
                         "flex": 1
                    }, {
                         "header": "Inference No Value",
                         "dataIndex": "inferenceNoValue",
                         "flex": 1
                    }, {
                         "header": "createdBy",
                         "dataIndex": "createdBy",
                         "hidden": true,
                         "flex": 1
                    }, {
                         "header": "createdDate",
                         "dataIndex": "createdDate",
                         "hidden": true,
                         "flex": 1
                    }, {
                         "header": "updatedBy",
                         "dataIndex": "updatedBy",
                         "hidden": true,
                         "flex": 1
                    }, {
                         "header": "updatedDate",
                         "dataIndex": "updatedDate",
                         "hidden": true,
                         "flex": 1
                    }, {
                         "header": "versionId",
                         "dataIndex": "versionId",
                         "hidden": true,
                         "flex": 1
                    }, {
                         "header": "activeStatus",
                         "dataIndex": "activeStatus",
                         "hidden": true,
                         "flex": 1
                    }, {
                         "header": "txnAccessCode",
                         "dataIndex": "txnAccessCode",
                         "hidden": true,
                         "flex": 1
                    }, {
                         "xtype": "actioncolumn",
                         "customWidgetType": "vdActionColumn",
                         "width": 30,
                         "sortable": false,
                         "menuDisable": true,
                         "items": [{
                              "icon": "images/delete.gif",
                              "tooltip": "Delete Record",
                              "handler": "onDeleteActionColumnClickMainGrid"
                         }]
                    }],
                    "listeners": {
                         "itemclick": "onGridItemClick"
                    },
                    "tools": [{
                         "type": "refresh",
                         "tooltip": "Refresh Grid Data",
                         "handler": "onGridRefreshClick"
                    }],
                    "collapsible": true,
                    "titleCollapse": true,
                    "collapseMode": "header",
                    "region": "south",
                    "height": "40%"
               }]
          }]
     }, {
          "title": "Add New",
          "itemId": "addNewForm",
          "layout": "border",
          "customWidgetType": "vdBorderLayout",
          "autoScroll": false,
          "items": [{
               "xtype": "form",
               "displayName": "QuestionInference",
               "name": "QuestionInference",
               "itemId": "QuestionInferenceForm",
               "bodyPadding": 10,
               "items": [{
                    "xtype": "form",
                    "itemId": "form0",
                    "customWidgetType": "vdCard",
                    "header": {
                         "hidden": true
                    },
                    "items": [{
                         "layout": "column",
                         "customWidgetType": "vdColumnLayout",
                         "header": {
                              "hidden": true
                         },
                         "xtype": "panel",
                         "items": [{
                              "name": "questionInferenceId",
                              "itemId": "questionInferenceId",
                              "xtype": "textfield",
                              "customWidgetType": "vdTextfield",
                              "displayName": "Question Inference Id",
                              "margin": "5 5 5 5",
                              "fieldLabel": "Question Inference Id<font color='red'> *<\/font>",
                              "fieldId": "62F91E84-FBE2-435E-B03A-AEA4255AAC52",
                              "hidden": true,
                              "value": "",
                              "bindable": "questionInferenceId",
                              "bind": "{questionInferenceId}"
                         }, {
                              "name": "questionId",
                              "itemId": "questionId",
                              "xtype": "combo",
                              "customWidgetType": "vdCombo",
                              "displayName": "QuestionId",
                              "margin": "5 5 5 5",
                              "fieldLabel": "QuestionId<font color='red'> *<\/font>",
                              "allowBlank": false,
                              "fieldId": "F87B3B2A-512D-4238-8BC6-D84554E5507E",
                              "restURL": "AssessmentQuestion",
                              "displayField": "primaryDisplay",
                              "valueField": "primaryKey",
                              "typeAhead": true,
                              "queryMode": "local",
                              "minChars": 2,
                              "store": {
                                   "data": [],
                                   "model": "Assessmentapp.assessmentapp.shared.com.model.assessmentcontext.survey.AssessmentQuestionModel"
                              },
                              "bindable": "questionId",
                              "columnWidth": 0.5,
                              "bind": "{questionId}"
                         }, {
                              "name": "inferenceKeyword",
                              "itemId": "inferenceKeyword",
                              "xtype": "textareafield",
                              "customWidgetType": "vdTextareafield",
                              "displayName": "Inference Keyword",
                              "margin": "5 5 5 5",
                              "fieldLabel": "Inference Keyword<font color='red'> *<\/font>",
                              "allowBlank": false,
                              "fieldId": "AE1F8F21-F35D-468F-B186-ED08295CCC7C",
                              "bindable": "inferenceKeyword",
                              "columnWidth": 0.5,
                              "bind": "{inferenceKeyword}"
                         }, {
                              "name": "inferenceHeading",
                              "itemId": "inferenceHeading",
                              "xtype": "textfield",
                              "customWidgetType": "vdTextfield",
                              "displayName": "Inference Heading",
                              "margin": "5 5 5 5",
                              "fieldLabel": "Inference Heading",
                              "fieldId": "47CD64E8-E5D8-4D69-9FC7-A3EE5EE66DE7",
                              "minLength": "0",
                              "maxLength": "256",
                              "bindable": "inferenceHeading",
                              "columnWidth": 0.5,
                              "bind": "{inferenceHeading}"
                         }, {
                              "name": "inferenceYesValue",
                              "itemId": "inferenceYesValue",
                              "xtype": "textfield",
                              "customWidgetType": "vdTextfield",
                              "displayName": "Inference Yes Value",
                              "margin": "5 5 5 5",
                              "fieldLabel": "Inference Yes Value",
                              "fieldId": "08822BEB-399F-48C0-A7A8-9654A9926872",
                              "minLength": "0",
                              "maxLength": "256",
                              "bindable": "inferenceYesValue",
                              "columnWidth": 0.5,
                              "bind": "{inferenceYesValue}"
                         }, {
                              "name": "inferenceNoValue",
                              "itemId": "inferenceNoValue",
                              "xtype": "textfield",
                              "customWidgetType": "vdTextfield",
                              "displayName": "Inference No Value",
                              "margin": "5 5 5 5",
                              "fieldLabel": "Inference No Value",
                              "fieldId": "8F31DB9C-0936-4510-9F32-A2858180401E",
                              "minLength": "0",
                              "maxLength": "256",
                              "bindable": "inferenceNoValue",
                              "columnWidth": 0.5,
                              "bind": "{inferenceNoValue}"
                         }, {
                              "name": "versionId",
                              "itemId": "versionId",
                              "xtype": "numberfield",
                              "customWidgetType": "vdNumberfield",
                              "displayName": "versionId",
                              "margin": "5 5 5 5",
                              "value": "-1",
                              "fieldLabel": "versionId",
                              "fieldId": "05074EF4-C4A8-43F9-8525-13274419C48D",
                              "bindable": "versionId",
                              "bind": "{versionId}",
                              "hidden": true
                         }]
                    }]
               }],
               "tools": [{
                    "type": "help",
                    "tooltip": "Get Console",
                    "handler": "onConsoleClick"
               }, {
                    "type": "refresh",
                    "tooltip": "Refresh Tab",
                    "handler": "init"
               }],
               "layout": "card",
               "defaults": {
                    "autoScroll": true
               },
               "autoScroll": true,
               "dockedItems": [{
                    "xtype ": "toolbar",
                    "customWidgetType": "vdBBar",
                    "dock": "bottom",
                    "margin": 0,
                    "isDockedItem": true,
                    "items": [{
                         "xtype": "tbfill",
                         "customWidgetType": "vdTbFill"
                    }, {
                         "xtype": "button",
                         "customWidgetType": "vdButton",
                         "margin": "0 5 0 5",
                         "text": "Save",
                         "hiddenName": "button",
                         "canHaveParent": false,
                         "itemId": "saveFormButton",
                         "listeners": {
                              "click": "saveForm"
                         }
                    }, {
                         "xtype": "button",
                         "customWidgetType": "vdButton",
                         "margin": "0 5 0 5",
                         "text": "Reset",
                         "hiddenName": "button",
                         "canHaveParent": false,
                         "itemId": "resetFormButton",
                         "listeners": {
                              "click": "resetForm"
                         }
                    }],
                    "defaults": {
                         "margin": "0 5 0 5"
                    }
               }],
               "viewModel": "QuestionInferenceViewModel",
               "listeners": {},
               "extend": "Ext.form.Panel",
               "region": "center",
               "customWidgetType": "vdCardLayout"
          }]
     }]
});