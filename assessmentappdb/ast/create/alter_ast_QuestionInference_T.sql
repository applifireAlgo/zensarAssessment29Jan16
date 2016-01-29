

ALTER TABLE `ast_QuestionInference_T` ADD CONSTRAINT FOREIGN KEY (`questionId`) REFERENCES `ast_AssessmentQuestion_T`(`questionId`);

