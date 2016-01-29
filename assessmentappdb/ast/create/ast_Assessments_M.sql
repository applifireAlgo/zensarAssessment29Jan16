DROP TABLE IF EXISTS `ast_Assessments_M`;

CREATE TABLE `ast_Assessments_M` ( `assessmentId` VARCHAR(256) NOT NULL, `assessmentName` VARCHAR(256) NOT NULL, `duration` INT(10) NOT NULL, `firstQuestionId` VARCHAR(256) NOT NULL, `createdBy` VARCHAR(64) NULL DEFAULT '-1', `createdDate` DATETIME NULL DEFAULT '1900-01-01', `updatedBy` VARCHAR(64) NULL DEFAULT '-1', `updatedDate` DATETIME NULL DEFAULT '1900-01-01', `versionId` INT(11) NULL DEFAULT '-1', `activeStatus` INT(1) NULL DEFAULT '1', `txnAccessCode` INT(11) NULL DEFAULT NULL, PRIMARY KEY (`assessmentId`), UNIQUE KEY (`assessmentName`));

