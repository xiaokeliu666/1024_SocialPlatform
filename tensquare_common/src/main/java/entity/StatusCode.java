package entity;

public class StatusCode {
    public static final int OK=20000;// Success
    public static final int ERROR =20001;// Failure
    public static final int LOGINERROR =20002;// Username or Password error
    public static final int ACCESSERROR =20003;// No Authorization
    public static final int REMOTEERROR =20004;// Remotely invoke fail
    public static final int REPERROR =20005;// Repeat Operation
}
