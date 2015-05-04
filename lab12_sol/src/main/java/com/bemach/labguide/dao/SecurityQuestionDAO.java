package com.bemach.labguide.dao;

import com.bemach.labguide.SecurityQuestion;

/**
 * Created by ktran on 4/30/2015.
 */
public interface SecurityQuestionDAO {
    public boolean create(SecurityQuestion securityQuestion);
    public SecurityQuestion read(String questionId);
    public boolean update(SecurityQuestion oldSecurityQuestion, SecurityQuestion newSecurityQuestion);
    public boolean delete(SecurityQuestion securityQuestion);
}
