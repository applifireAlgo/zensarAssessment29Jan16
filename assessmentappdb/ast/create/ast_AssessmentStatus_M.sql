DROP TABLE IF EXISTS `ast_AssessmentStatus_M`;

CREATE TABLE `ast_AssessmentStatus_M` ( `assessmentStatusId` VARCHAR(256) NOT NULL, `statusCode` INT(10) NOT NULL, `statusText` VARCHAR(256) NOT NULL, `createdBy` VARCHAR(64) NULL DEFAULT '-1', `createdDate` DATETIME NULL DEFAULT '1900-01-01', `updatedBy` VARCHAR(64) NULL DEFAULT '-1', `updatedDate` DATETIME NULL DEFAULT '1900-01-01', `versionId` INT(11) NULL DEFAULT '-1', `activeStatus` INT(1) NULL DEFAULT '1', `txnAccessCode` INT(11) NULL DEFAULT NULL, PRIMARY KEY (`assessmentStatusId`));

