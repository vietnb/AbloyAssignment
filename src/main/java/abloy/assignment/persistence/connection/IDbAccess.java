package abloy.assignment.persistence.connection;

import abloy.assignment.appexception.DbAccessException;

public interface IDbAccess<T> {
    T connect() throws DbAccessException;
}
