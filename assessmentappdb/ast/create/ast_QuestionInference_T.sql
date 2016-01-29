DROP TABLE IF EXISTS `ast_QuestionInference_T`;

CREATE TABLE `ast_QuestionInference_T` ( `questionInferenceId` VARCHAR(256) NOT NULL, `questionId` VARCHAR(256) NOT NULL, `inferenceKeyword` TEXT NOT NULL, `inferenceHeading` VARCHAR(256) NULL DEFAULT NULL, `inferenceYesValue` VARCHAR(256) NULL DEFAULT NULL, `inferenceNoValue` VARCHAR(256) NULL DEFAULT NULL, `createdBy` VARCHAR(64) NULL DEFAULT '-1', `createdDate` DATETIME NULL DEFAULT '1900-01-01', `updatedBy` VARCHAR(64) NULL DEFAULT '-1', `updatedDate` DATETIME NULL DEFAULT '1900-01-01', `versionId` INT(11) NULL DEFAULT '-1', `activeStatus` INT(1) NULL DEFAULT '1', `txnAccessCode` INT(11) NULL DEFAULT NULL, PRIMARY KEY (`questionInferenceId`));

