package assignment.demo.dblayer.connection;

import assignment.demo.appexception.DbAccessException;

public interface IDbAccess<T> {
    T connect() throws DbAccessException;
}
