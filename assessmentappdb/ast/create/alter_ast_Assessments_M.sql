

ALTER TABLE `ast_Assessments_M` ADD CONSTRAINT FOREIGN KEY (`firstQuestionId`) REFERENCES `ast_AssessmentQuestion_T`(`questionId`);

