DROP TABLE IF EXISTS `ast_AssessmentTran_T`;

CREATE TABLE `ast_AssessmentTran_T` ( `assessmentTranId` VARCHAR(256) NOT NULL, `startTime` DATETIME NOT NULL, `endTime` DATETIME NULL DEFAULT NULL, `statusCode` INT(10) NOT NULL, `assessmentStartsAt` BIGINT(20) NULL DEFAULT NULL, `assessmentId` VARCHAR(256) NOT NULL, `userId` VARCHAR(64) NOT NULL, `createdBy` VARCHAR(64) NULL DEFAULT '-1', `createdDate` DATETIME NULL DEFAULT '1900-01-01', `updatedBy` VARCHAR(64) NULL DEFAULT '-1', `updatedDate` DATETIME NULL DEFAULT '1900-01-01', `versionId` INT(11) NULL DEFAULT '-1', `activeStatus` INT(1) NULL DEFAULT '1', `txnAccessCode` INT(11) NULL DEFAULT NULL, PRIMARY KEY (`assessmentTranId`));

