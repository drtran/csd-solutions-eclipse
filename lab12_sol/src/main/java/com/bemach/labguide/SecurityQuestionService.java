package com.bemach.labguide;

import java.util.List;

/**
 * Created by ktran on 4/30/2015.
 */
public interface SecurityQuestionService {
    public List<SecurityQuestion> getSecurityQuestionList();
    public List<SecurityQA> getUserSecurityQA(String userId, String answerIndicator);
    public boolean modifyUserSecurityQuestions(String userId, String questionIds[], String answers[]);
}
