

ALTER TABLE `ast_QuestionAnswerBridge_B` ADD CONSTRAINT FOREIGN KEY (`questionId`) REFERENCES `ast_AssessmentQuestion_T`(`questionId`);



ALTER TABLE `ast_QuestionAnswerBridge_B` ADD CONSTRAINT FOREIGN KEY (`answerId`) REFERENCES `ast_AssessmentAnswer_M`(`answerId`);

