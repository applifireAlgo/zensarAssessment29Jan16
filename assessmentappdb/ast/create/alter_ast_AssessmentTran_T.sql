

ALTER TABLE `ast_AssessmentTran_T` ADD CONSTRAINT FOREIGN KEY (`userId`) REFERENCES `ast_User_T`(`userId`);



ALTER TABLE `ast_AssessmentTran_T` ADD CONSTRAINT FOREIGN KEY (`assessmentId`) REFERENCES `ast_Assessments_M`(`assessmentId`);

