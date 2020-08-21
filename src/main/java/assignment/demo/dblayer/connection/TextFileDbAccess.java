package assignment.demo.dblayer.connection;

import assignment.demo.appexception.DbAccessException;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class TextFileDbAccess implements IDbAccess<Scanner> {

    private String dir;

    public TextFileDbAccess(String dir) {
        this.dir = dir;
    }

    public Scanner connect() throws DbAccessException {
        File file = new File(this.dir);
        Scanner sc = null;
        try {
             sc = new Scanner(file);
        } catch (FileNotFoundException e) {
            throw new DbAccessException(e.getMessage());
        }
        return sc;
    }
}
