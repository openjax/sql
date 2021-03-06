/* Copyright (c) 2018 LibJ
 *
 * Permission is hereby granted, free of charge, to any person obtaining a copy
 * of this software and associated documentation files (the "Software"), to deal
 * in the Software without restriction, including without limitation the rights
 * to use, copy, modify, merge, publish, distribute, sublicense, and/or sell
 * copies of the Software, and to permit persons to whom the Software is
 * furnished to do so, subject to the following conditions:
 *
 * The above copyright notice and this permission notice shall be included in
 * all copies or substantial portions of the Software.
 *
 * You should have received a copy of The MIT License (MIT) along with this
 * program. If not, see <http://opensource.org/licenses/MIT/>.
 */

package org.libj.sql;

import java.sql.Array;
import java.sql.Blob;
import java.sql.CallableStatement;
import java.sql.Clob;
import java.sql.Connection;
import java.sql.DatabaseMetaData;
import java.sql.NClob;
import java.sql.PreparedStatement;
import java.sql.SQLClientInfoException;
import java.sql.SQLException;
import java.sql.SQLWarning;
import java.sql.SQLXML;
import java.sql.Savepoint;
import java.sql.Statement;
import java.sql.Struct;
import java.util.Map;
import java.util.Objects;
import java.util.Properties;
import java.util.concurrent.Executor;

/**
 * A {@link DelegateConnection} contains some other {@link Connection}, possibly
 * transforming the method parameters along the way or providing additional
 * functionality. The class {@link DelegateConnection} itself simply overrides
 * all methods of {@link Connection} with versions that delegate all calls to
 * the target {@link Connection}. Subclasses of {@link DelegateConnection} may
 * further override some of these methods and may also provide additional
 * methods and fields.
 */
public abstract class DelegateConnection implements Connection {
  /** The target {@link Connection}. */
  protected volatile Connection target;

  /**
   * Creates a new {@link DelegateConnection} with the specified target
   * {@link Connection}.
   *
   * @param target The target {@link Connection}.
   * @throws NullPointerException If the target {@link Connection} is null.
   */
  public DelegateConnection(final Connection target) {
    this.target = Objects.requireNonNull(target);
  }

  /**
   * Creates a new {@link DelegateConnection} with a null target.
   */
  protected DelegateConnection() {
  }

  @Override
  public Statement createStatement() throws SQLException {
    return target.createStatement();
  }

  @Override
  public PreparedStatement prepareStatement(final String sql) throws SQLException {
    return target.prepareStatement(sql);
  }

  @Override
  public CallableStatement prepareCall(final String sql) throws SQLException {
    return target.prepareCall(sql);
  }

  @Override
  public String nativeSQL(final String sql) throws SQLException {
    return target.nativeSQL(sql);
  }

  @Override
  public void setAutoCommit(final boolean autoCommit) throws SQLException {
    target.setAutoCommit(autoCommit);
  }

  @Override
  public boolean getAutoCommit() throws SQLException {
    return target.getAutoCommit();
  }

  @Override
  public void commit() throws SQLException {
    target.commit();
  }

  @Override
  public void rollback() throws SQLException {
    target.rollback();
  }

  @Override
  public void close() throws SQLException {
    target.close();
  }

  @Override
  public boolean isClosed() throws SQLException {
    return target.isClosed();
  }

  @Override
  public DatabaseMetaData getMetaData() throws SQLException {
    return target.getMetaData();
  }

  @Override
  public void setReadOnly(final boolean readOnly) throws SQLException {
    target.setReadOnly(readOnly);
  }

  @Override
  public boolean isReadOnly() throws SQLException {
    return target.isReadOnly();
  }

  @Override
  public void setCatalog(final String catalog) throws SQLException {
    target.setCatalog(catalog);
  }

  @Override
  public String getCatalog() throws SQLException {
    return target.getCatalog();
  }

  @Override
  public void setTransactionIsolation(final int level) throws SQLException {
    target.setTransactionIsolation(level);
  }

  @Override
  public int getTransactionIsolation() throws SQLException {
    return target.getTransactionIsolation();
  }

  @Override
  public SQLWarning getWarnings() throws SQLException {
    return target.getWarnings();
  }

  @Override
  public void clearWarnings() throws SQLException {
    target.clearWarnings();
  }

  @Override
  public Statement createStatement(final int resultSetType, final int resultSetConcurrency) throws SQLException {
    return target.createStatement(resultSetType, resultSetConcurrency);
  }

  @Override
  public PreparedStatement prepareStatement(final String sql, final int resultSetType, final int resultSetConcurrency) throws SQLException {
    return target.prepareStatement(sql, resultSetType, resultSetConcurrency);
  }

  @Override
  public CallableStatement prepareCall(final String sql, final int resultSetType, final int resultSetConcurrency) throws SQLException {
    return target.prepareCall(sql, resultSetType, resultSetConcurrency);
  }

  @Override
  public Map<String,Class<?>> getTypeMap() throws SQLException {
    return target.getTypeMap();
  }

  @Override
  public void setTypeMap(final Map<String,Class<?>> map) throws SQLException {
    target.setTypeMap(map);
  }

  @Override
  public void setHoldability(final int holdability) throws SQLException {
    target.setHoldability(holdability);
  }

  @Override
  public int getHoldability() throws SQLException {
    return target.getHoldability();
  }

  @Override
  public Savepoint setSavepoint() throws SQLException {
    return target.setSavepoint();
  }

  @Override
  public Savepoint setSavepoint(final String name) throws SQLException {
    return target.setSavepoint(name);
  }

  @Override
  public void rollback(final Savepoint savepoint) throws SQLException {
    target.rollback(savepoint);
  }

  @Override
  public void releaseSavepoint(final Savepoint savepoint) throws SQLException {
    target.releaseSavepoint(savepoint);
  }

  @Override
  public Statement createStatement(final int resultSetType, final int resultSetConcurrency, final int resultSetHoldability) throws SQLException {
    return target.createStatement(resultSetType, resultSetConcurrency, resultSetHoldability);
  }

  @Override
  public PreparedStatement prepareStatement(final String sql, final int resultSetType, final int resultSetConcurrency, final int resultSetHoldability) throws SQLException {
    return target.prepareStatement(sql, resultSetType, resultSetConcurrency, resultSetHoldability);
  }

  @Override
  public CallableStatement prepareCall(final String sql, final int resultSetType, final int resultSetConcurrency, final int resultSetHoldability) throws SQLException {
    return target.prepareCall(sql, resultSetType, resultSetConcurrency, resultSetHoldability);
  }

  @Override
  public PreparedStatement prepareStatement(final String sql, final int autoGeneratedKeys) throws SQLException {
    return target.prepareStatement(sql, autoGeneratedKeys);
  }

  @Override
  public PreparedStatement prepareStatement(final String sql, final int[] columnIndexes) throws SQLException {
    return target.prepareStatement(sql, columnIndexes);
  }

  @Override
  public PreparedStatement prepareStatement(final String sql, final String[] columnNames) throws SQLException {
    return target.prepareStatement(sql, columnNames);
  }

  @Override
  public Clob createClob() throws SQLException {
    return target.createClob();
  }

  @Override
  public Blob createBlob() throws SQLException {
    return target.createBlob();
  }

  @Override
  public NClob createNClob() throws SQLException {
    return target.createNClob();
  }

  @Override
  public SQLXML createSQLXML() throws SQLException {
    return target.createSQLXML();
  }

  @Override
  public boolean isValid(final int timeout) throws SQLException {
    return target.isValid(timeout);
  }

  @Override
  public void setClientInfo(final String name, final String value) throws SQLClientInfoException {
    target.setClientInfo(name, value);
  }

  @Override
  public void setClientInfo(final Properties properties) throws SQLClientInfoException {
    target.setClientInfo(properties);
  }

  @Override
  public String getClientInfo(final String name) throws SQLException {
    return target.getClientInfo(name);
  }

  @Override
  public Properties getClientInfo() throws SQLException {
    return target.getClientInfo();
  }

  @Override
  public Array createArrayOf(final String typeName, final Object[] elements) throws SQLException {
    return target.createArrayOf(typeName, elements);
  }

  @Override
  public Struct createStruct(final String typeName, final Object[] attributes) throws SQLException {
    return target.createStruct(typeName, attributes);
  }

  @Override
  public <T>T unwrap(final Class<T> iface) throws SQLException {
    return target.unwrap(iface);
  }

  @Override
  public boolean isWrapperFor(final Class<?> iface) throws SQLException {
    return target.isWrapperFor(iface);
  }

  @Override
  public void setSchema(final String schema) throws SQLException {
    target.setSchema(schema);
  }

  @Override
  public String getSchema() throws SQLException {
    return target.getSchema();
  }

  @Override
  public void abort(final Executor executor) throws SQLException {
    target.abort(executor);
  }

  @Override
  public void setNetworkTimeout(final Executor executor, final int milliseconds) throws SQLException {
    target.setNetworkTimeout(executor, milliseconds);
  }

  @Override
  public int getNetworkTimeout() throws SQLException {
    return target.getNetworkTimeout();
  }

  @Override
  public boolean equals(final Object obj) {
    return target.equals(obj);
  }

  @Override
  public int hashCode() {
    return target.hashCode();
  }

  @Override
  public String toString() {
    return target.toString();
  }
}