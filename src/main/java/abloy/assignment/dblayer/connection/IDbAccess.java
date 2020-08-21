package abloy.assignment.dblayer.connection;

import abloy.assignment.appexception.DbAccessException;

public interface IDbAccess<T> {
    T connect() throws DbAccessException;
}
