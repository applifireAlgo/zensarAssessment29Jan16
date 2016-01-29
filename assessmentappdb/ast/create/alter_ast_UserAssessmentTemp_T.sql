

ALTER TABLE `ast_UserAssessmentTemp_T` ADD CONSTRAINT FOREIGN KEY (`userId`) REFERENCES `ast_User_T`(`userId`);



ALTER TABLE `ast_UserAssessmentTemp_T` ADD CONSTRAINT FOREIGN KEY (`assessmentTranId`) REFERENCES `ast_AssessmentTran_T`(`assessmentTranId`);



ALTER TABLE `ast_UserAssessmentTemp_T` ADD CONSTRAINT FOREIGN KEY (`questionId`) REFERENCES `ast_AssessmentQuestion_T`(`questionId`);



ALTER TABLE `ast_UserAssessmentTemp_T` ADD CONSTRAINT FOREIGN KEY (`answerId`) REFERENCES `ast_AssessmentAnswer_M`(`answerId`);

