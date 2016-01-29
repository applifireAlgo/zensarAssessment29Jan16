Ext.define('Assessmentapp.assessmentapp.web.com.view.organizationboundedcontext.location.DistrictMain', {
     "extend": "Ext.tab.Panel",
     "customWidgetType": "vdTabLayout",
     "autoScroll": false,
     "controller": "DistrictMainController",
     "restURL": "/District",
     "defaults": {
          "split": true
     },
     "requires": ["Assessmentapp.assessmentapp.shared.com.model.organizationboundedcontext.location.DistrictModel", "Assessmentapp.assessmentapp.web.com.controller.organizationboundedcontext.location.DistrictMainController", "Assessmentapp.assessmentapp.shared.com.model.organizationboundedcontext.location.CountryModel", "Assessmentapp.assessmentapp.shared.com.model.organizationboundedcontext.location.StateModel", "Assessmentapp.assessmentapp.shared.com.model.organizationboundedcontext.location.RegionModel", "Assessmentapp.assessmentapp.shared.com.viewmodel.organizationboundedcontext.location.DistrictViewModel"],
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
               "displayName": "District",
               "name": "DistrictTreeContainer",
               "itemId": "DistrictTreeContainer",
               "restURL": "/District",
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
                    "itemId": "DistrictTree",
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
                         "name": "countryId",
                         "itemId": "countryId",
                         "xtype": "combo",
                         "customWidgetType": "vdCombo",
                         "displayName": "Country",
                         "margin": "5 5 5 5",
                         "fieldLabel": "Country",
                         "fieldId": "2D336CC8-0F94-4747-92B8-766AA0DA1999",
                         "restURL": "Country",
                         "displayField": "primaryDisplay",
                         "valueField": "primaryKey",
                         "typeAhead": true,
                         "queryMode": "local",
                         "minChars": 2,
                         "store": {
                              "data": [],
                              "model": "Assessmentapp.assessmentapp.shared.com.model.organizationboundedcontext.location.CountryModel"
                         }
                    }, {
                         "name": "stateId",
                         "itemId": "stateId",
                         "xtype": "combo",
                         "customWidgetType": "vdCombo",
                         "displayName": "State",
                         "margin": "5 5 5 5",
                         "fieldLabel": "State",
                         "fieldId": "2089F86C-D3E5-4AF4-BD42-EF68486A09D3",
                         "restURL": "State",
                         "displayField": "primaryDisplay",
                         "valueField": "primaryKey",
                         "typeAhead": true,
                         "queryMode": "local",
                         "minChars": 2,
                         "store": {
                              "data": [],
                              "model": "Assessmentapp.assessmentapp.shared.com.model.organizationboundedcontext.location.StateModel"
                         }
                    }, {
                         "name": "regionId",
                         "itemId": "regionId",
                         "xtype": "combo",
                         "customWidgetType": "vdCombo",
                         "displayName": "Region",
                         "margin": "5 5 5 5",
                         "fieldLabel": "Region",
                         "fieldId": "D1CB7D68-2AE7-4233-A72F-04C8884CF494",
                         "restURL": "Region",
                         "displayField": "primaryDisplay",
                         "valueField": "primaryKey",
                         "typeAhead": true,
                         "queryMode": "local",
                         "minChars": 2,
                         "store": {
                              "data": [],
                              "model": "Assessmentapp.assessmentapp.shared.com.model.organizationboundedcontext.location.RegionModel"
                         }
                    }, {
                         "name": "code2",
                         "itemId": "code2",
                         "xtype": "textfield",
                         "customWidgetType": "vdTextfield",
                         "displayName": "District Code",
                         "margin": "5 5 5 5",
                         "fieldLabel": "District Code",
                         "fieldId": "AFF79430-0DE4-40B5-9EC3-508D455E6373",
                         "minLength": "0",
                         "maxLength": "32"
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
                    "viewModel": "DistrictViewModel",
                    "xtype": "form",
                    "displayName": "District",
                    "title": "District",
                    "name": "District",
                    "itemId": "District",
                    "bodyPadding": 10,
                    "items": [{
                         "name": "districtId",
                         "itemId": "districtId",
                         "xtype": "textfield",
                         "customWidgetType": "vdTextfield",
                         "displayName": "District Id",
                         "margin": "5 5 5 5",
                         "fieldLabel": "District Id<font color='red'> *<\/font>",
                         "fieldId": "87D5C2B0-B761-4A5D-8590-60B2C9C77E90",
                         "minLength": "0",
                         "maxLength": "64",
                         "hidden": true,
                         "value": "",
                         "bindable": "districtId",
                         "bind": "{districtId}"
                    }, {
                         "name": "countryId",
                         "itemId": "countryId",
                         "xtype": "combo",
                         "customWidgetType": "vdCombo",
                         "displayName": "Country",
                         "margin": "5 5 5 5",
                         "fieldLabel": "Country<font color='red'> *<\/font>",
                         "allowBlank": false,
                         "fieldId": "2D336CC8-0F94-4747-92B8-766AA0DA1999",
                         "restURL": "Country",
                         "displayField": "primaryDisplay",
                         "valueField": "primaryKey",
                         "typeAhead": true,
                         "queryMode": "local",
                         "minChars": 2,
                         "store": {
                              "data": [],
                              "model": "Assessmentapp.assessmentapp.shared.com.model.organizationboundedcontext.location.CountryModel"
                         },
                         "bindable": "countryId",
                         "bind": "{countryId}",
                         "columnWidth": 0.5,
                         "listeners": {
                              "change": "onCountryIdChange"
                         }
                    }, {
                         "name": "stateId",
                         "itemId": "stateId",
                         "xtype": "combo",
                         "customWidgetType": "vdCombo",
                         "displayName": "State",
                         "margin": "5 5 5 5",
                         "fieldLabel": "State<font color='red'> *<\/font>",
                         "allowBlank": false,
                         "fieldId": "2089F86C-D3E5-4AF4-BD42-EF68486A09D3",
                         "restURL": "State",
                         "displayField": "primaryDisplay",
                         "valueField": "primaryKey",
                         "typeAhead": true,
                         "queryMode": "local",
                         "minChars": 2,
                         "store": {
                              "data": [],
                              "model": "Assessmentapp.assessmentapp.shared.com.model.organizationboundedcontext.location.StateModel"
                         },
                         "bindable": "stateId",
                         "bind": "{stateId}",
                         "columnWidth": 0.5,
                         "listeners": {
                              "change": "onStateIdChange"
                         }
                    }, {
                         "name": "regionId",
                         "itemId": "regionId",
                         "xtype": "combo",
                         "customWidgetType": "vdCombo",
                         "displayName": "Region",
                         "margin": "5 5 5 5",
                         "fieldLabel": "Region<font color='red'> *<\/font>",
                         "allowBlank": false,
                         "fieldId": "D1CB7D68-2AE7-4233-A72F-04C8884CF494",
                         "restURL": "Region",
                         "displayField": "primaryDisplay",
                         "valueField": "primaryKey",
                         "typeAhead": true,
                         "queryMode": "local",
                         "minChars": 2,
                         "store": {
                              "data": [],
                              "model": "Assessmentapp.assessmentapp.shared.com.model.organizationboundedcontext.location.RegionModel"
                         },
                         "bindable": "regionId",
                         "bind": "{regionId}",
                         "columnWidth": 0.5
                    }, {
                         "name": "name",
                         "itemId": "name",
                         "xtype": "textfield",
                         "customWidgetType": "vdTextfield",
                         "displayName": "District Name",
                         "margin": "5 5 5 5",
                         "fieldLabel": "District Name<font color='red'> *<\/font>",
                         "allowBlank": false,
                         "fieldId": "4A22F8F3-2953-4299-8B26-F2C4AB24A86D",
                         "minLength": "0",
                         "maxLength": "256",
                         "bindable": "name",
                         "bind": "{name}",
                         "columnWidth": 0.5
                    }, {
                         "name": "code2",
                         "itemId": "code2",
                         "xtype": "textfield",
                         "customWidgetType": "vdTextfield",
                         "displayName": "District Code",
                         "margin": "5 5 5 5",
                         "fieldLabel": "District Code<font color='red'> *<\/font>",
                         "allowBlank": false,
                         "fieldId": "AFF79430-0DE4-40B5-9EC3-508D455E6373",
                         "minLength": "0",
                         "maxLength": "32",
                         "bindable": "code2",
                         "bind": "{code2}",
                         "columnWidth": 0.5
                    }, {
                         "name": "districtDescription",
                         "itemId": "districtDescription",
                         "xtype": "textareafield",
                         "customWidgetType": "vdTextareafield",
                         "displayName": "District Description",
                         "margin": "5 5 5 5",
                         "fieldLabel": "District Description",
                         "fieldId": "FDCAEB1B-6C68-4C1D-9EC0-DC440597DECA",
                         "bindable": "districtDescription",
                         "bind": "{districtDescription}",
                         "columnWidth": 0.5
                    }, {
                         "name": "districtFlag",
                         "itemId": "districtFlag",
                         "xtype": "textfield",
                         "customWidgetType": "vdTextfield",
                         "displayName": "Flag",
                         "margin": "5 5 5 5",
                         "fieldLabel": "Flag",
                         "fieldId": "01FB1989-6A5A-4276-9D4E-E476D3A7C805",
                         "minLength": "0",
                         "maxLength": "128",
                         "bindable": "districtFlag",
                         "bind": "{districtFlag}",
                         "columnWidth": 0.5
                    }, {
                         "name": "districtLatitude",
                         "itemId": "districtLatitude",
                         "xtype": "numberfield",
                         "customWidgetType": "vdNumberfield",
                         "displayName": "District Latitude",
                         "margin": "5 5 5 5",
                         "fieldLabel": "District Latitude",
                         "fieldId": "C07A9016-1072-4DC8-A2AB-938595E798A2",
                         "minValue": "0",
                         "maxValue": "11",
                         "bindable": "districtLatitude",
                         "bind": "{districtLatitude}",
                         "columnWidth": 0.5
                    }, {
                         "name": "districtLongitude",
                         "itemId": "districtLongitude",
                         "xtype": "numberfield",
                         "customWidgetType": "vdNumberfield",
                         "displayName": "District Longitude",
                         "margin": "5 5 5 5",
                         "fieldLabel": "District Longitude",
                         "fieldId": "BE9B4BBC-5BE9-4E31-8117-AE269497C5DE",
                         "minValue": "0",
                         "maxValue": "11",
                         "bindable": "districtLongitude",
                         "bind": "{districtLongitude}",
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
                         "fieldId": "289FCD95-933D-45A5-8F42-816DADB752C6",
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
                         "customId": 22,
                         "items": [{
                              "xtype": "tbfill",
                              "customWidgetType": "vdTbFill",
                              "parentId": 22,
                              "customId": 924
                         }, {
                              "customWidgetType": "vdButton",
                              "xtype": "button",
                              "margin": "0 5 0 5",
                              "text": "Save",
                              "hiddenName": "button",
                              "canHaveParent": false,
                              "itemId": "saveFormButton",
                              "parentId": 22,
                              "customId": 925,
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
                              "parentId": 22,
                              "customId": 926,
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
                    "displayName": "District",
                    "title": "Details Grid",
                    "name": "DistrictGrid",
                    "itemId": "DistrictGrid",
                    "restURL": "/District",
                    "store": [],
                    "bodyPadding": 10,
                    "columns": [{
                         "header": "District Id",
                         "dataIndex": "districtId",
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
                         "header": "Country",
                         "dataIndex": "countryId",
                         "renderer": "renderFormValue",
                         "flex": 1
                    }, {
                         "header": "State",
                         "dataIndex": "stateId",
                         "renderer": "renderFormValue",
                         "flex": 1
                    }, {
                         "header": "Region",
                         "dataIndex": "regionId",
                         "renderer": "renderFormValue",
                         "flex": 1
                    }, {
                         "header": "District Name",
                         "dataIndex": "name",
                         "flex": 1
                    }, {
                         "header": "District Code",
                         "dataIndex": "code2",
                         "flex": 1
                    }, {
                         "header": "District Description",
                         "dataIndex": "districtDescription",
                         "flex": 1
                    }, {
                         "header": "Flag",
                         "dataIndex": "districtFlag",
                         "flex": 1
                    }, {
                         "header": "District Latitude",
                         "dataIndex": "districtLatitude",
                         "flex": 1
                    }, {
                         "header": "District Longitude",
                         "dataIndex": "districtLongitude",
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
               "viewModel": "DistrictViewModel",
               "xtype": "form",
               "displayName": "District",
               "title": "District",
               "name": "District",
               "itemId": "District",
               "bodyPadding": 10,
               "items": [{
                    "name": "districtId",
                    "itemId": "districtId",
                    "xtype": "textfield",
                    "customWidgetType": "vdTextfield",
                    "displayName": "District Id",
                    "margin": "5 5 5 5",
                    "fieldLabel": "District Id<font color='red'> *<\/font>",
                    "fieldId": "87D5C2B0-B761-4A5D-8590-60B2C9C77E90",
                    "minLength": "0",
                    "maxLength": "64",
                    "hidden": true,
                    "value": "",
                    "bindable": "districtId",
                    "bind": "{districtId}"
               }, {
                    "name": "countryId",
                    "itemId": "countryId",
                    "xtype": "combo",
                    "customWidgetType": "vdCombo",
                    "displayName": "Country",
                    "margin": "5 5 5 5",
                    "fieldLabel": "Country<font color='red'> *<\/font>",
                    "allowBlank": false,
                    "fieldId": "2D336CC8-0F94-4747-92B8-766AA0DA1999",
                    "restURL": "Country",
                    "displayField": "primaryDisplay",
                    "valueField": "primaryKey",
                    "typeAhead": true,
                    "queryMode": "local",
                    "minChars": 2,
                    "store": {
                         "data": [],
                         "model": "Assessmentapp.assessmentapp.shared.com.model.organizationboundedcontext.location.CountryModel"
                    },
                    "bindable": "countryId",
                    "bind": "{countryId}",
                    "columnWidth": 0.5,
                    "listeners": {
                         "change": "onCountryIdChange"
                    }
               }, {
                    "name": "stateId",
                    "itemId": "stateId",
                    "xtype": "combo",
                    "customWidgetType": "vdCombo",
                    "displayName": "State",
                    "margin": "5 5 5 5",
                    "fieldLabel": "State<font color='red'> *<\/font>",
                    "allowBlank": false,
                    "fieldId": "2089F86C-D3E5-4AF4-BD42-EF68486A09D3",
                    "restURL": "State",
                    "displayField": "primaryDisplay",
                    "valueField": "primaryKey",
                    "typeAhead": true,
                    "queryMode": "local",
                    "minChars": 2,
                    "store": {
                         "data": [],
                         "model": "Assessmentapp.assessmentapp.shared.com.model.organizationboundedcontext.location.StateModel"
                    },
                    "bindable": "stateId",
                    "bind": "{stateId}",
                    "columnWidth": 0.5,
                    "listeners": {
                         "change": "onStateIdChange"
                    }
               }, {
                    "name": "regionId",
                    "itemId": "regionId",
                    "xtype": "combo",
                    "customWidgetType": "vdCombo",
                    "displayName": "Region",
                    "margin": "5 5 5 5",
                    "fieldLabel": "Region<font color='red'> *<\/font>",
                    "allowBlank": false,
                    "fieldId": "D1CB7D68-2AE7-4233-A72F-04C8884CF494",
                    "restURL": "Region",
                    "displayField": "primaryDisplay",
                    "valueField": "primaryKey",
                    "typeAhead": true,
                    "queryMode": "local",
                    "minChars": 2,
                    "store": {
                         "data": [],
                         "model": "Assessmentapp.assessmentapp.shared.com.model.organizationboundedcontext.location.RegionModel"
                    },
                    "bindable": "regionId",
                    "bind": "{regionId}",
                    "columnWidth": 0.5
               }, {
                    "name": "name",
                    "itemId": "name",
                    "xtype": "textfield",
                    "customWidgetType": "vdTextfield",
                    "displayName": "District Name",
                    "margin": "5 5 5 5",
                    "fieldLabel": "District Name<font color='red'> *<\/font>",
                    "allowBlank": false,
                    "fieldId": "4A22F8F3-2953-4299-8B26-F2C4AB24A86D",
                    "minLength": "0",
                    "maxLength": "256",
                    "bindable": "name",
                    "bind": "{name}",
                    "columnWidth": 0.5
               }, {
                    "name": "code2",
                    "itemId": "code2",
                    "xtype": "textfield",
                    "customWidgetType": "vdTextfield",
                    "displayName": "District Code",
                    "margin": "5 5 5 5",
                    "fieldLabel": "District Code<font color='red'> *<\/font>",
                    "allowBlank": false,
                    "fieldId": "AFF79430-0DE4-40B5-9EC3-508D455E6373",
                    "minLength": "0",
                    "maxLength": "32",
                    "bindable": "code2",
                    "bind": "{code2}",
                    "columnWidth": 0.5
               }, {
                    "name": "districtDescription",
                    "itemId": "districtDescription",
                    "xtype": "textareafield",
                    "customWidgetType": "vdTextareafield",
                    "displayName": "District Description",
                    "margin": "5 5 5 5",
                    "fieldLabel": "District Description",
                    "fieldId": "FDCAEB1B-6C68-4C1D-9EC0-DC440597DECA",
                    "bindable": "districtDescription",
                    "bind": "{districtDescription}",
                    "columnWidth": 0.5
               }, {
                    "name": "districtFlag",
                    "itemId": "districtFlag",
                    "xtype": "textfield",
                    "customWidgetType": "vdTextfield",
                    "displayName": "Flag",
                    "margin": "5 5 5 5",
                    "fieldLabel": "Flag",
                    "fieldId": "01FB1989-6A5A-4276-9D4E-E476D3A7C805",
                    "minLength": "0",
                    "maxLength": "128",
                    "bindable": "districtFlag",
                    "bind": "{districtFlag}",
                    "columnWidth": 0.5
               }, {
                    "name": "districtLatitude",
                    "itemId": "districtLatitude",
                    "xtype": "numberfield",
                    "customWidgetType": "vdNumberfield",
                    "displayName": "District Latitude",
                    "margin": "5 5 5 5",
                    "fieldLabel": "District Latitude",
                    "fieldId": "C07A9016-1072-4DC8-A2AB-938595E798A2",
                    "minValue": "0",
                    "maxValue": "11",
                    "bindable": "districtLatitude",
                    "bind": "{districtLatitude}",
                    "columnWidth": 0.5
               }, {
                    "name": "districtLongitude",
                    "itemId": "districtLongitude",
                    "xtype": "numberfield",
                    "customWidgetType": "vdNumberfield",
                    "displayName": "District Longitude",
                    "margin": "5 5 5 5",
                    "fieldLabel": "District Longitude",
                    "fieldId": "BE9B4BBC-5BE9-4E31-8117-AE269497C5DE",
                    "minValue": "0",
                    "maxValue": "11",
                    "bindable": "districtLongitude",
                    "bind": "{districtLongitude}",
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
                    "fieldId": "289FCD95-933D-45A5-8F42-816DADB752C6",
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
                    "customId": 22,
                    "items": [{
                         "xtype": "tbfill",
                         "customWidgetType": "vdTbFill",
                         "parentId": 22,
                         "customId": 924
                    }, {
                         "customWidgetType": "vdButton",
                         "xtype": "button",
                         "margin": "0 5 0 5",
                         "text": "Save",
                         "hiddenName": "button",
                         "canHaveParent": false,
                         "itemId": "saveFormButton",
                         "parentId": 22,
                         "customId": 925,
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
                         "parentId": 22,
                         "customId": 926,
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