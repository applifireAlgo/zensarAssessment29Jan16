Ext.define('Assessmentapp.assessmentapp.web.com.view.multitenant.customers.AppCustomerCategoryMain', {
     "extend": "Ext.tab.Panel",
     "customWidgetType": "vdTabLayout",
     "autoScroll": false,
     "controller": "AppCustomerCategoryMainController",
     "restURL": "/AppCustomerCategory",
     "defaults": {
          "split": true
     },
     "requires": ["Assessmentapp.assessmentapp.shared.com.model.multitenant.customers.AppCustomerCategoryModel", "Assessmentapp.assessmentapp.web.com.controller.multitenant.customers.AppCustomerCategoryMainController", "Assessmentapp.assessmentapp.shared.com.viewmodel.multitenant.customers.AppCustomerCategoryViewModel"],
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
               "margin": "5 0 5 5",
               "border": 1,
               "style": {
                    "borderColor": "#f6f6f6",
                    "borderStyle": "solid",
                    "borderWidth": "1px"
               },
               "displayName": "AppCustomer Category",
               "name": "AppCustomerCategoryTreeContainer",
               "itemId": "AppCustomerCategoryTreeContainer",
               "restURL": "/AppCustomerCategory",
               "autoScroll": false,
               "collapsible": true,
               "titleCollapse": true,
               "collapseMode": "header",
               "collapsed": false,
               "items": [{
                    "xtype": "treepanel",
                    "customWidgetType": "vdTree",
                    "title": "Browse",
                    "useArrows": true,
                    "rootVisible": false,
                    "itemId": "AppCustomerCategoryTree",
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
                    "itemId": "queryPanel",
                    "dockedItems": [{
                         "xtype ": "toolbar",
                         "customWidgetType": "vdBBar",
                         "dock": "bottom",
                         "isDockedItem": true,
                         "items": [{
                              "xtype": "tbfill",
                              "customWidgetType": "vdTbFill"
                         }, {
                              "xtype": "button",
                              "customWidgetType": "vdButton",
                              "text": "Filter",
                              "handler": "onFilterClick"
                         }]
                    }],
                    "items": [{
                         "name": "customerCategory",
                         "itemId": "customerCategory",
                         "xtype": "textfield",
                         "customWidgetType": "vdTextfield",
                         "displayName": "Customer Category",
                         "margin": "5 5 5 5",
                         "fieldLabel": "Customer Category",
                         "fieldId": "84BF6B13-9AA9-4E9E-ACB8-F035BDD0CC41",
                         "minLength": "0",
                         "maxLength": "65535"
                    }]
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
                    "customWidgetType": "vdFormpanel",
                    "viewModel": "AppCustomerCategoryViewModel",
                    "xtype": "form",
                    "displayName": "AppCustomer Category",
                    "title": "AppCustomer Category",
                    "name": "AppCustomerCategory",
                    "itemId": "AppCustomerCategory",
                    "bodyPadding": 10,
                    "items": [{
                         "name": "appcustCategoryId",
                         "itemId": "appcustCategoryId",
                         "xtype": "textfield",
                         "customWidgetType": "vdTextfield",
                         "displayName": "appcustCategoryId",
                         "margin": "5 5 5 5",
                         "fieldLabel": "appcustCategoryId<font color='red'> *<\/font>",
                         "fieldId": "858903F5-CF7E-4B23-8B8E-976F99AF68FD",
                         "hidden": true,
                         "value": "",
                         "bindable": "appcustCategoryId",
                         "bind": "{appcustCategoryId}"
                    }, {
                         "name": "customerCategory",
                         "itemId": "customerCategory",
                         "xtype": "textfield",
                         "customWidgetType": "vdTextfield",
                         "displayName": "Customer Category",
                         "margin": "5 5 5 5",
                         "fieldLabel": "Customer Category<font color='red'> *<\/font>",
                         "allowBlank": false,
                         "fieldId": "84BF6B13-9AA9-4E9E-ACB8-F035BDD0CC41",
                         "minLength": "0",
                         "maxLength": "65535",
                         "bindable": "customerCategory",
                         "bind": "{customerCategory}",
                         "columnWidth": 0.5
                    }, {
                         "name": "versionId",
                         "itemId": "versionId",
                         "xtype": "numberfield",
                         "customWidgetType": "vdNumberfield",
                         "displayName": "versionId",
                         "margin": "5 5 5 5",
                         "value": "-1",
                         "fieldLabel": "versionId",
                         "fieldId": "39C34717-06D3-4F54-BFC4-DCFD31CB74B0",
                         "bindable": "versionId",
                         "bind": "{versionId}",
                         "hidden": true
                    }],
                    "layout": "column",
                    "defaults": {
                         "columnWidth": 0.5,
                         "labelAlign": "left",
                         "labelWidth": 200
                    },
                    "autoScroll": true,
                    "dockedItems": [{
                         "xtype ": "toolbar",
                         "customWidgetType": "vdBBar",
                         "dock": "bottom",
                         "ui": "footer",
                         "isDockedItem": true,
                         "parentId": 1,
                         "customId": 482,
                         "items": [{
                              "xtype": "tbfill",
                              "customWidgetType": "vdTbFill",
                              "parentId": 482,
                              "customId": 707
                         }, {
                              "customWidgetType": "vdButton",
                              "xtype": "button",
                              "margin": "0 5 0 5",
                              "text": "Save",
                              "hiddenName": "button",
                              "canHaveParent": false,
                              "itemId": "saveFormButton",
                              "parentId": 482,
                              "customId": 708,
                              "listeners": {
                                   "click": "saveForm"
                              }
                         }, {
                              "customWidgetType": "vdButton",
                              "xtype": "button",
                              "margin": "0 5 0 5",
                              "text": "Reset",
                              "hiddenName": "button",
                              "canHaveParent": false,
                              "itemId": "resetFormButton",
                              "parentId": 482,
                              "customId": 709,
                              "listeners": {
                                   "click": "resetForm"
                              }
                         }],
                         "defaults": {}
                    }],
                    "listeners": {
                         "scope": "controller"
                    },
                    "tools": [{
                         "type": "help",
                         "tooltip": "Console",
                         "handler": "onConsoleClick"
                    }, {
                         "type": "refresh",
                         "tooltip": "Refresh Tab",
                         "handler": "init"
                    }],
                    "extend": "Ext.form.Panel",
                    "region": "center"
               }, {
                    "xtype": "gridpanel",
                    "customWidgetType": "vdGrid",
                    "displayName": "AppCustomer Category",
                    "title": "Details Grid",
                    "name": "AppCustomerCategoryGrid",
                    "itemId": "AppCustomerCategoryGrid",
                    "restURL": "/AppCustomerCategory",
                    "store": [],
                    "bodyPadding": 10,
                    "columns": [{
                         "header": "appcustCategoryId",
                         "dataIndex": "appcustCategoryId",
                         "hidden": true,
                         "flex": 1
                    }, {
                         "header": "primaryDisplay",
                         "dataIndex": "primaryDisplay",
                         "hidden": true
                    }, {
                         "header": "primaryKey",
                         "dataIndex": "primaryKey",
                         "hidden": true
                    }, {
                         "header": "Customer Category",
                         "dataIndex": "customerCategory",
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
               "customWidgetType": "vdFormpanel",
               "viewModel": "AppCustomerCategoryViewModel",
               "xtype": "form",
               "displayName": "AppCustomer Category",
               "title": "AppCustomer Category",
               "name": "AppCustomerCategory",
               "itemId": "AppCustomerCategory",
               "bodyPadding": 10,
               "items": [{
                    "name": "appcustCategoryId",
                    "itemId": "appcustCategoryId",
                    "xtype": "textfield",
                    "customWidgetType": "vdTextfield",
                    "displayName": "appcustCategoryId",
                    "margin": "5 5 5 5",
                    "fieldLabel": "appcustCategoryId<font color='red'> *<\/font>",
                    "fieldId": "858903F5-CF7E-4B23-8B8E-976F99AF68FD",
                    "hidden": true,
                    "value": "",
                    "bindable": "appcustCategoryId",
                    "bind": "{appcustCategoryId}"
               }, {
                    "name": "customerCategory",
                    "itemId": "customerCategory",
                    "xtype": "textfield",
                    "customWidgetType": "vdTextfield",
                    "displayName": "Customer Category",
                    "margin": "5 5 5 5",
                    "fieldLabel": "Customer Category<font color='red'> *<\/font>",
                    "allowBlank": false,
                    "fieldId": "84BF6B13-9AA9-4E9E-ACB8-F035BDD0CC41",
                    "minLength": "0",
                    "maxLength": "65535",
                    "bindable": "customerCategory",
                    "bind": "{customerCategory}",
                    "columnWidth": 0.5
               }, {
                    "name": "versionId",
                    "itemId": "versionId",
                    "xtype": "numberfield",
                    "customWidgetType": "vdNumberfield",
                    "displayName": "versionId",
                    "margin": "5 5 5 5",
                    "value": "-1",
                    "fieldLabel": "versionId",
                    "fieldId": "39C34717-06D3-4F54-BFC4-DCFD31CB74B0",
                    "bindable": "versionId",
                    "bind": "{versionId}",
                    "hidden": true
               }],
               "layout": "column",
               "defaults": {
                    "columnWidth": 0.5,
                    "labelAlign": "left",
                    "labelWidth": 200
               },
               "autoScroll": true,
               "dockedItems": [{
                    "xtype ": "toolbar",
                    "customWidgetType": "vdBBar",
                    "dock": "bottom",
                    "ui": "footer",
                    "isDockedItem": true,
                    "parentId": 1,
                    "customId": 482,
                    "items": [{
                         "xtype": "tbfill",
                         "customWidgetType": "vdTbFill",
                         "parentId": 482,
                         "customId": 707
                    }, {
                         "customWidgetType": "vdButton",
                         "xtype": "button",
                         "margin": "0 5 0 5",
                         "text": "Save",
                         "hiddenName": "button",
                         "canHaveParent": false,
                         "itemId": "saveFormButton",
                         "parentId": 482,
                         "customId": 708,
                         "listeners": {
                              "click": "saveForm"
                         }
                    }, {
                         "customWidgetType": "vdButton",
                         "xtype": "button",
                         "margin": "0 5 0 5",
                         "text": "Reset",
                         "hiddenName": "button",
                         "canHaveParent": false,
                         "itemId": "resetFormButton",
                         "parentId": 482,
                         "customId": 709,
                         "listeners": {
                              "click": "resetForm"
                         }
                    }],
                    "defaults": {}
               }],
               "listeners": {
                    "scope": "controller"
               },
               "tools": [{
                    "type": "help",
                    "tooltip": "Console",
                    "handler": "onConsoleClick"
               }, {
                    "type": "refresh",
                    "tooltip": "Refresh Tab",
                    "handler": "init"
               }],
               "extend": "Ext.form.Panel",
               "region": "center"
          }]
     }]
});