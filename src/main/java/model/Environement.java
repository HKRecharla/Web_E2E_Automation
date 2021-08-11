package model;

public enum Environement {

    QA("qa"),DEV("dev"),UAT("uat");

    private final String env;

    private Environement(String env) {
        this.env= env;
    }

    public String getEnv(){
        return env;
    }
}
