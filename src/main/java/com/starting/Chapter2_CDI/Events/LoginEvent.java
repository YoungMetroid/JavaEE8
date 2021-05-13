package com.starting.Chapter2_CDI.Events;

public class LoginEvent
{
    private final Integer attemptsMade;
    private final String userId;
    private boolean lockAccount = false;

    public LoginEvent(Integer count, String userId)
    {
        this.attemptsMade = count;
        this.userId = userId;
    }

    public Integer getAttemptsMade()
    {
        return attemptsMade;
    }

    public String getUserId()
    {
        return userId;
    }
    public void setLockAccount(boolean lockAccount)
    {
        this.lockAccount = lockAccount;
    }

    public boolean isLockAccount() {
        return lockAccount;
    }
}
