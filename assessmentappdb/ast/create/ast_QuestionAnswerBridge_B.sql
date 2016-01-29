DROP TABLE IF EXISTS `ast_QuestionAnswerBridge_B`;

CREATE TABLE `ast_QuestionAnswerBridge_B` ( `questionanswerbridgePkey` INT(11) NOT NULL AUTO_INCREMENT, `questionId` VARCHAR(256) NOT NULL, `answerId` VARCHAR(256) NOT NULL, PRIMARY KEY (`questionanswerbridgePkey`));

