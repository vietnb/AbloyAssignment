package assignment.demo.appexception;

public class DbAccessException extends Exception {
    public DbAccessException(String s) {
        super(s);
    }
}