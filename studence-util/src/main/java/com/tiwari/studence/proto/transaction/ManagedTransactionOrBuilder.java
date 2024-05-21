// Generated by the protocol buffer compiler.  DO NOT EDIT!
// source: transaction.proto

package com.tiwari.studence.proto.transaction;

public interface ManagedTransactionOrBuilder extends
    // @@protoc_insertion_point(interface_extends:com.tiwari.studence.proto.transaction.ManagedTransaction)
    com.google.protobuf.MessageOrBuilder {

  /**
   * <code>optional .com.tiwari.studence.proto.reference.MultiLevelReferencePb id = 1;</code>
   * @return Whether the id field is set.
   */
  boolean hasId();
  /**
   * <code>optional .com.tiwari.studence.proto.reference.MultiLevelReferencePb id = 1;</code>
   * @return The id.
   */
  com.tiwari.studence.proto.reference.MultiLevelReferencePb getId();
  /**
   * <code>optional .com.tiwari.studence.proto.reference.MultiLevelReferencePb id = 1;</code>
   */
  com.tiwari.studence.proto.reference.MultiLevelReferencePbOrBuilder getIdOrBuilder();

  /**
   * <code>optional .com.tiwari.studence.proto.transaction.TransactionState state = 2;</code>
   * @return Whether the state field is set.
   */
  boolean hasState();
  /**
   * <code>optional .com.tiwari.studence.proto.transaction.TransactionState state = 2;</code>
   * @return The enum numeric value on the wire for state.
   */
  int getStateValue();
  /**
   * <code>optional .com.tiwari.studence.proto.transaction.TransactionState state = 2;</code>
   * @return The state.
   */
  com.tiwari.studence.proto.transaction.TransactionState getState();

  /**
   * <pre>
   * This is the time when it entered into this state.
   * </pre>
   *
   * <code>optional .com.tiwari.studence.proto.transaction.Outcome result = 3;</code>
   * @return Whether the result field is set.
   */
  boolean hasResult();
  /**
   * <pre>
   * This is the time when it entered into this state.
   * </pre>
   *
   * <code>optional .com.tiwari.studence.proto.transaction.Outcome result = 3;</code>
   * @return The enum numeric value on the wire for result.
   */
  int getResultValue();
  /**
   * <pre>
   * This is the time when it entered into this state.
   * </pre>
   *
   * <code>optional .com.tiwari.studence.proto.transaction.Outcome result = 3;</code>
   * @return The result.
   */
  com.tiwari.studence.proto.transaction.Outcome getResult();

  /**
   * <pre>
   * TODO : change time to timePb
   * </pre>
   *
   * <code>optional int32 time = 4;</code>
   * @return Whether the time field is set.
   */
  boolean hasTime();
  /**
   * <pre>
   * TODO : change time to timePb
   * </pre>
   *
   * <code>optional int32 time = 4;</code>
   * @return The time.
   */
  int getTime();

  /**
   * <code>optional int32 retryCount = 5;</code>
   * @return Whether the retryCount field is set.
   */
  boolean hasRetryCount();
  /**
   * <code>optional int32 retryCount = 5;</code>
   * @return The retryCount.
   */
  int getRetryCount();
}
