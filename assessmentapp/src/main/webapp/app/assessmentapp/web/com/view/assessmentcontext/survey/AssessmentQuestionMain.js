Ext.define('Assessmentapp.assessmentapp.web.com.view.assessmentcontext.survey.AssessmentQuestionMain', {
     "extend": "Ext.tab.Panel",
     "customWidgetType": "vdTabLayout",
     "autoScroll": false,
     "controller": "AssessmentQuestionMainController",
     "restURL": "/AssessmentQuestion",
     "defaults": {
          "split": true
     },
     "requires": ["Assessmentapp.assessmentapp.shared.com.model.assessmentcontext.survey.AssessmentQuestionModel", "Assessmentapp.assessmentapp.web.com.controller.assessmentcontext.survey.AssessmentQuestionMainController", "Assessmentapp.view.fw.component.Grids", "Assessmentapp.assessmentapp.shared.com.viewmodel.assessmentcontext.survey.AssessmentQuestionViewModel"],
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
               "displayName": "AssessmentQuestion",
               "name": "AssessmentQuestionTreeContainer",
               "itemId": "AssessmentQuestionTreeContainer",
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
                    "itemId": "AssessmentQuestionTree",
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
                    "displayName": "AssessmentQuestion",
                    "name": "AssessmentQuestion",
                    "itemId": "AssessmentQuestionForm",
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
                                   "name": "questionId",
                                   "itemId": "questionId",
                                   "xtype": "textfield",
                                   "customWidgetType": "vdTextfield",
                                   "displayName": "Question ID",
                                   "margin": "5 5 5 5",
                                   "fieldLabel": "Question ID<font color='red'> *<\/font>",
                                   "fieldId": "F3577536-5FD7-490E-A42D-46E12EECFE06",
                                   "hidden": true,
                                   "value": "",
                                   "bindable": "questionId",
                                   "bind": "{questionId}"
                              }, {
                                   "name": "question",
                                   "itemId": "question",
                                   "xtype": "textfield",
                                   "customWidgetType": "vdTextfield",
                                   "displayName": "Question",
                                   "margin": "5 5 5 5",
                                   "fieldLabel": "Question<font color='red'> *<\/font>",
                                   "allowBlank": false,
                                   "fieldId": "33833A7A-8E88-45CC-A0EE-C87377DD1A7B",
                                   "minLength": "0",
                                   "maxLength": "256",
                                   "bindable": "question",
                                   "columnWidth": 0.5,
                                   "bind": "{question}"
                              }, {
                                   "name": "questionDesc",
                                   "itemId": "questionDesc",
                                   "xtype": "textareafield",
                                   "customWidgetType": "vdTextareafield",
                                   "displayName": "Question Description",
                                   "margin": "5 5 5 5",
                                   "fieldLabel": "Question Description",
                                   "fieldId": "0CB3BF5B-532E-44A4-9456-0BDE47AA477E",
                                   "bindable": "questionDesc",
                                   "columnWidth": 0.5,
                                   "bind": "{questionDesc}"
                              }, {
                                   "name": "questionInference",
                                   "itemId": "questionInference",
                                   "xtype": "checkbox",
                                   "customWidgetType": "vdCheckbox",
                                   "displayName": "Question Inference ?",
                                   "margin": "5 5 5 5",
                                   "inputValue": true,
                                   "fieldLabel": "Question Inference ?",
                                   "fieldId": "8A487C56-7B18-4321-BE7E-6D9115980FBA",
                                   "bindable": "questionInference",
                                   "columnWidth": 0.5,
                                   "bind": "{questionInference}"
                              }, {
                                   "name": "versionId",
                                   "itemId": "versionId",
                                   "xtype": "numberfield",
                                   "customWidgetType": "vdNumberfield",
                                   "displayName": "versionId",
                                   "margin": "5 5 5 5",
                                   "value": "-1",
                                   "fieldLabel": "versionId",
                                   "fieldId": "B7FDA6B6-F519-4BA4-8ACC-7DE3654710C0",
                                   "bindable": "versionId",
                                   "bind": "{versionId}",
                                   "hidden": true
                              }]
                         }]
                    }, {
                         "xtype": "form",
                         "displayName": "AssessmentAnswer",
                         "title": "AssessmentAnswer",
                         "name": "AssessmentAnswer",
                         "itemId": "AssessmentAnswerForm",
                         "bodyPadding": 10,
                         "items": [{
                              "xtype": "form",
                              "itemId": "form1",
                              "customWidgetType": "vdAnchorLayout",
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
                                        "name": "answer",
                                        "itemId": "answer",
                                        "xtype": "textfield",
                                        "customWidgetType": "vdTextfield",
                                        "displayName": "Answer",
                                        "margin": "5 5 5 5",
                                        "fieldLabel": "Answer<font color='red'> *<\/font>",
                                        "allowBlank": false,
                                        "fieldId": "AE5852CB-E884-4FB1-8F2A-648988B0837D",
                                        "minLength": "0",
                                        "maxLength": "256",
                                        "bindable": "assessmentAnswer.answer",
                                        "columnWidth": 0.5
                                   }, {
                                        "name": "answerDesc",
                                        "itemId": "answerDesc",
                                        "xtype": "textareafield",
                                        "customWidgetType": "vdTextareafield",
                                        "displayName": "Answer Description",
                                        "margin": "5 5 5 5",
                                        "fieldLabel": "Answer Description",
                                        "fieldId": "3E92D1D7-7EDC-4067-BEC2-11E4F49748C0",
                                        "bindable": "assessmentAnswer.answerDesc",
                                        "columnWidth": 0.5
                                   }]
                              }]
                         }, {
                              "columnWidth": 1,
                              "xtype": "button",
                              "customWidgetType": "vdButton",
                              "maxWidth": 231,
                              "text": "Add AssessmentAnswer",
                              "handler": "addAssessmentAnswer"
                         }, {
                              "xtype": "grids",
                              "customWidgetType": "vdGrid",
                              "title": "AssessmentAnswer",
                              "columnWidth": 1,
                              "itemId": "AssessmentAnswerGrid",
                              "fieldLabel": "List",
                              "bindLevel": "assessmentAnswer",
                              "bindable": "assessmentAnswer",
                              "listeners": {
                                   "select": "onAssessmentAnswerGridItemClick"
                              },
                              "store": {
                                   "fields": [],
                                   "data": []
                              },
                              "columns": [{
                                   "header": "Answer ID",
                                   "text": "Answer ID",
                                   "customWidgetType": "vdGridColumn",
                                   "dataIndex": "answerId",
                                   "hidden": true,
                                   "flex": 1
                              }, {
                                   "header": "Answer",
                                   "text": "Answer",
                                   "customWidgetType": "vdGridColumn",
                                   "dataIndex": "answer",
                                   "flex": 1
                              }, {
                                   "header": "Answer Description",
                                   "text": "Answer Description",
                                   "customWidgetType": "vdGridColumn",
                                   "dataIndex": "answerDesc",
                                   "flex": 1
                              }, {
                                   "header": "createdBy",
                                   "text": "createdBy",
                                   "customWidgetType": "vdGridColumn",
                                   "dataIndex": "createdBy",
                                   "hidden": true,
                                   "flex": 1
                              }, {
                                   "header": "createdDate",
                                   "text": "createdDate",
                                   "customWidgetType": "vdGridColumn",
                                   "dataIndex": "createdDate",
                                   "hidden": true,
                                   "flex": 1
                              }, {
                                   "header": "updatedBy",
                                   "text": "updatedBy",
                                   "customWidgetType": "vdGridColumn",
                                   "dataIndex": "updatedBy",
                                   "hidden": true,
                                   "flex": 1
                              }, {
                                   "header": "updatedDate",
                                   "text": "updatedDate",
                                   "customWidgetType": "vdGridColumn",
                                   "dataIndex": "updatedDate",
                                   "hidden": true,
                                   "flex": 1
                              }, {
                                   "header": "versionId",
                                   "text": "versionId",
                                   "customWidgetType": "vdGridColumn",
                                   "dataIndex": "versionId",
                                   "hidden": true,
                                   "flex": 1
                              }, {
                                   "header": "activeStatus",
                                   "text": "activeStatus",
                                   "customWidgetType": "vdGridColumn",
                                   "dataIndex": "activeStatus",
                                   "hidden": true,
                                   "flex": 1
                              }, {
                                   "header": "txnAccessCode",
                                   "text": "txnAccessCode",
                                   "customWidgetType": "vdGridColumn",
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
                                        "handler": "onDeleteActionColumnClick"
                                   }]
                              }]
                         }],
                         "customWidgetType": "vdCard"
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
                    }, {
                         "xtype": "toolbar",
                         "customWidgetType": "vdTBar",
                         "defaults": {
                              "margin": "0 5 0 5"
                         },
                         "isDockedItem": true,
                         "items": [{
                              "xtype": "tbfill",
                              "customWidgetType": "vdTbFill"
                         }, {
                              "xtype": "button",
                              "customWidgetType": "vdButton",
                              "itemId": "cardPrev",
                              "text": "&laquo; Previous",
                              "handler": "showPreviousCard",
                              "disabled": true,
                              "margin": "0 5 0 5"
                         }, {
                              "xtype": "button",
                              "customWidgetType": "vdButton",
                              "itemId": "cardNext",
                              "text": "Next &raquo;",
                              "handler": "showNextCard",
                              "margin": "0 5 0 5"
                         }]
                    }],
                    "viewModel": "AssessmentQuestionViewModel",
                    "listeners": {},
                    "extend": "Ext.form.Panel",
                    "region": "center",
                    "customWidgetType": "vdCardLayout"
               }, {
                    "xtype": "grid",
                    "customWidgetType": "vdGrid",
                    "displayName": "AssessmentQuestion",
                    "title": "Details Grid",
                    "name": "AssessmentQuestionGrid",
                    "itemId": "AssessmentQuestionGrid",
                    "store": [],
                    "bodyPadding": 10,
                    "requires": [],
                    "columns": [{
                         "header": "Question ID",
                         "dataIndex": "questionId",
                         "hidden": true,
                         "flex": 1
                    }, {
                         "header": "primaryKey",
                         "dataIndex": "primaryKey",
                         "hidden": true
                    }, {
                         "header": "Question",
                         "dataIndex": "question",
                         "flex": 1
                    }, {
                         "header": "Question Description",
                         "dataIndex": "questionDesc",
                         "flex": 1
                    }, {
                         "header": "Question Inference ?",
                         "dataIndex": "questionInference",
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
               "displayName": "AssessmentQuestion",
               "name": "AssessmentQuestion",
               "itemId": "AssessmentQuestionForm",
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
                              "name": "questionId",
                              "itemId": "questionId",
                              "xtype": "textfield",
                              "customWidgetType": "vdTextfield",
                              "displayName": "Question ID",
                              "margin": "5 5 5 5",
                              "fieldLabel": "Question ID<font color='red'> *<\/font>",
                              "fieldId": "F3577536-5FD7-490E-A42D-46E12EECFE06",
                              "hidden": true,
                              "value": "",
                              "bindable": "questionId",
                              "bind": "{questionId}"
                         }, {
                              "name": "question",
                              "itemId": "question",
                              "xtype": "textfield",
                              "customWidgetType": "vdTextfield",
                              "displayName": "Question",
                              "margin": "5 5 5 5",
                              "fieldLabel": "Question<font color='red'> *<\/font>",
                              "allowBlank": false,
                              "fieldId": "33833A7A-8E88-45CC-A0EE-C87377DD1A7B",
                              "minLength": "0",
                              "maxLength": "256",
                              "bindable": "question",
                              "columnWidth": 0.5,
                              "bind": "{question}"
                         }, {
                              "name": "questionDesc",
                              "itemId": "questionDesc",
                              "xtype": "textareafield",
                              "customWidgetType": "vdTextareafield",
                              "displayName": "Question Description",
                              "margin": "5 5 5 5",
                              "fieldLabel": "Question Description",
                              "fieldId": "0CB3BF5B-532E-44A4-9456-0BDE47AA477E",
                              "bindable": "questionDesc",
                              "columnWidth": 0.5,
                              "bind": "{questionDesc}"
                         }, {
                              "name": "questionInference",
                              "itemId": "questionInference",
                              "xtype": "checkbox",
                              "customWidgetType": "vdCheckbox",
                              "displayName": "Question Inference ?",
                              "margin": "5 5 5 5",
                              "inputValue": true,
                              "fieldLabel": "Question Inference ?",
                              "fieldId": "8A487C56-7B18-4321-BE7E-6D9115980FBA",
                              "bindable": "questionInference",
                              "columnWidth": 0.5,
                              "bind": "{questionInference}"
                         }, {
                              "name": "versionId",
                              "itemId": "versionId",
                              "xtype": "numberfield",
                              "customWidgetType": "vdNumberfield",
                              "displayName": "versionId",
                              "margin": "5 5 5 5",
                              "value": "-1",
                              "fieldLabel": "versionId",
                              "fieldId": "B7FDA6B6-F519-4BA4-8ACC-7DE3654710C0",
                              "bindable": "versionId",
                              "bind": "{versionId}",
                              "hidden": true
                         }]
                    }]
               }, {
                    "xtype": "form",
                    "displayName": "AssessmentAnswer",
                    "title": "AssessmentAnswer",
                    "name": "AssessmentAnswer",
                    "itemId": "AssessmentAnswerForm",
                    "bodyPadding": 10,
                    "items": [{
                         "xtype": "form",
                         "itemId": "form1",
                         "customWidgetType": "vdAnchorLayout",
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
                                   "name": "answer",
                                   "itemId": "answer",
                                   "xtype": "textfield",
                                   "customWidgetType": "vdTextfield",
                                   "displayName": "Answer",
                                   "margin": "5 5 5 5",
                                   "fieldLabel": "Answer<font color='red'> *<\/font>",
                                   "allowBlank": false,
                                   "fieldId": "AE5852CB-E884-4FB1-8F2A-648988B0837D",
                                   "minLength": "0",
                                   "maxLength": "256",
                                   "bindable": "assessmentAnswer.answer",
                                   "columnWidth": 0.5
                              }, {
                                   "name": "answerDesc",
                                   "itemId": "answerDesc",
                                   "xtype": "textareafield",
                                   "customWidgetType": "vdTextareafield",
                                   "displayName": "Answer Description",
                                   "margin": "5 5 5 5",
                                   "fieldLabel": "Answer Description",
                                   "fieldId": "3E92D1D7-7EDC-4067-BEC2-11E4F49748C0",
                                   "bindable": "assessmentAnswer.answerDesc",
                                   "columnWidth": 0.5
                              }]
                         }]
                    }, {
                         "columnWidth": 1,
                         "xtype": "button",
                         "customWidgetType": "vdButton",
                         "maxWidth": 231,
                         "text": "Add AssessmentAnswer",
                         "handler": "addAssessmentAnswer"
                    }, {
                         "xtype": "grids",
                         "customWidgetType": "vdGrid",
                         "title": "AssessmentAnswer",
                         "columnWidth": 1,
                         "itemId": "AssessmentAnswerGrid",
                         "fieldLabel": "List",
                         "bindLevel": "assessmentAnswer",
                         "bindable": "assessmentAnswer",
                         "listeners": {
                              "select": "onAssessmentAnswerGridItemClick"
                         },
                         "store": {
                              "fields": [],
                              "data": []
                         },
                         "columns": [{
                              "header": "Answer ID",
                              "text": "Answer ID",
                              "customWidgetType": "vdGridColumn",
                              "dataIndex": "answerId",
                              "hidden": true,
                              "flex": 1
                         }, {
                              "header": "Answer",
                              "text": "Answer",
                              "customWidgetType": "vdGridColumn",
                              "dataIndex": "answer",
                              "flex": 1
                         }, {
                              "header": "Answer Description",
                              "text": "Answer Description",
                              "customWidgetType": "vdGridColumn",
                              "dataIndex": "answerDesc",
                              "flex": 1
                         }, {
                              "header": "createdBy",
                              "text": "createdBy",
                              "customWidgetType": "vdGridColumn",
                              "dataIndex": "createdBy",
                              "hidden": true,
                              "flex": 1
                         }, {
                              "header": "createdDate",
                              "text": "createdDate",
                              "customWidgetType": "vdGridColumn",
                              "dataIndex": "createdDate",
                              "hidden": true,
                              "flex": 1
                         }, {
                              "header": "updatedBy",
                              "text": "updatedBy",
                              "customWidgetType": "vdGridColumn",
                              "dataIndex": "updatedBy",
                              "hidden": true,
                              "flex": 1
                         }, {
                              "header": "updatedDate",
                              "text": "updatedDate",
                              "customWidgetType": "vdGridColumn",
                              "dataIndex": "updatedDate",
                              "hidden": true,
                              "flex": 1
                         }, {
                              "header": "versionId",
                              "text": "versionId",
                              "customWidgetType": "vdGridColumn",
                              "dataIndex": "versionId",
                              "hidden": true,
                              "flex": 1
                         }, {
                              "header": "activeStatus",
                              "text": "activeStatus",
                              "customWidgetType": "vdGridColumn",
                              "dataIndex": "activeStatus",
                              "hidden": true,
                              "flex": 1
                         }, {
                              "header": "txnAccessCode",
                              "text": "txnAccessCode",
                              "customWidgetType": "vdGridColumn",
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
                                   "handler": "onDeleteActionColumnClick"
                              }]
                         }]
                    }],
                    "customWidgetType": "vdCard"
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
               }, {
                    "xtype": "toolbar",
                    "customWidgetType": "vdTBar",
                    "defaults": {
                         "margin": "0 5 0 5"
                    },
                    "isDockedItem": true,
                    "items": [{
                         "xtype": "tbfill",
                         "customWidgetType": "vdTbFill"
                    }, {
                         "xtype": "button",
                         "customWidgetType": "vdButton",
                         "itemId": "cardPrev",
                         "text": "&laquo; Previous",
                         "handler": "showPreviousCard",
                         "disabled": true,
                         "margin": "0 5 0 5"
                    }, {
                         "xtype": "button",
                         "customWidgetType": "vdButton",
                         "itemId": "cardNext",
                         "text": "Next &raquo;",
                         "handler": "showNextCard",
                         "margin": "0 5 0 5"
                    }]
               }],
               "viewModel": "AssessmentQuestionViewModel",
               "listeners": {},
               "extend": "Ext.form.Panel",
               "region": "center",
               "customWidgetType": "vdCardLayout"
          }]
     }]
});