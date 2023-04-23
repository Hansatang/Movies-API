package org.sep6.persistence;

import java.sql.Connection;
import java.sql.SQLException;

import javax.sql.DataSource;

import org.springframework.jdbc.datasource.AbstractDataSource;
import org.springframework.retry.annotation.Backoff;
import org.springframework.retry.annotation.Retryable;

import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
public class RetryableDataSource extends AbstractDataSource {

	private final DataSource dataSource;

    @Override
	@Retryable(maxAttempts = 10, backoff = @Backoff(delay = 10_000))
    public Connection getConnection() throws SQLException {
        return dataSource.getConnection();
    }

    @Override
    public Connection getConnection(String username, String password) throws SQLException {
		return dataSource.getConnection(username, password);
    }
}
