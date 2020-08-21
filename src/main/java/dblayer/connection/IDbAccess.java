package dblayer.connection;

import appexception.DbAccessException;

public interface IDbAccess<T> {
    T connect() throws DbAccessException;
}
