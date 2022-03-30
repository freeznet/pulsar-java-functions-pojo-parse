/**
 * Licensed to the Apache Software Foundation (ASF) under one
 * or more contributor license agreements.  See the NOTICE file
 * distributed with this work for additional information
 * regarding copyright ownership.  The ASF licenses this file
 * to you under the Apache License, Version 2.0 (the
 * "License"); you may not use this file except in compliance
 * with the License.  You may obtain a copy of the License at
 *
 *   http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing,
 * software distributed under the License is distributed on an
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY
 * KIND, either express or implied.  See the License for the
 * specific language governing permissions and limitations
 * under the License.
 */
// Generated by the protocol buffer compiler.  DO NOT EDIT!
// source: StockMsg.proto

package org.examples;

public final class StockProtoMessage {
  private StockProtoMessage() {}
  public static void registerAllExtensions(
      com.google.protobuf.ExtensionRegistryLite registry) {
  }

  public static void registerAllExtensions(
      com.google.protobuf.ExtensionRegistry registry) {
    registerAllExtensions(
        (com.google.protobuf.ExtensionRegistryLite) registry);
  }
  public interface StockOrBuilder extends
      // @@protoc_insertion_point(interface_extends:proto.Stock)
      com.google.protobuf.MessageOrBuilder {

    /**
     * <code>int32 entryId = 1;</code>
     */
    int getEntryId();

    /**
     * <code>string symbol = 2;</code>
     */
    String getSymbol();
    /**
     * <code>string symbol = 2;</code>
     */
    com.google.protobuf.ByteString
        getSymbolBytes();

    /**
     * <code>double sharePrice = 3;</code>
     */
    double getSharePrice();
  }
  /**
   * Protobuf type {@code proto.Stock}
   */
  public  static final class Stock extends
      com.google.protobuf.GeneratedMessageV3 implements
      // @@protoc_insertion_point(message_implements:proto.Stock)
      StockOrBuilder {
  private static final long serialVersionUID = 0L;
    // Use Stock.newBuilder() to construct.
    private Stock(com.google.protobuf.GeneratedMessageV3.Builder<?> builder) {
      super(builder);
    }
    private Stock() {
      entryId_ = 0;
      symbol_ = "";
      sharePrice_ = 0D;
    }

    @Override
    public final com.google.protobuf.UnknownFieldSet
    getUnknownFields() {
      return this.unknownFields;
    }
    private Stock(
        com.google.protobuf.CodedInputStream input,
        com.google.protobuf.ExtensionRegistryLite extensionRegistry)
        throws com.google.protobuf.InvalidProtocolBufferException {
      this();
      if (extensionRegistry == null) {
        throw new NullPointerException();
      }
      int mutable_bitField0_ = 0;
      com.google.protobuf.UnknownFieldSet.Builder unknownFields =
          com.google.protobuf.UnknownFieldSet.newBuilder();
      try {
        boolean done = false;
        while (!done) {
          int tag = input.readTag();
          switch (tag) {
            case 0:
              done = true;
              break;
            default: {
              if (!parseUnknownFieldProto3(
                  input, unknownFields, extensionRegistry, tag)) {
                done = true;
              }
              break;
            }
            case 8: {

              entryId_ = input.readInt32();
              break;
            }
            case 18: {
              String s = input.readStringRequireUtf8();

              symbol_ = s;
              break;
            }
            case 25: {

              sharePrice_ = input.readDouble();
              break;
            }
          }
        }
      } catch (com.google.protobuf.InvalidProtocolBufferException e) {
        throw e.setUnfinishedMessage(this);
      } catch (java.io.IOException e) {
        throw new com.google.protobuf.InvalidProtocolBufferException(
            e).setUnfinishedMessage(this);
      } finally {
        this.unknownFields = unknownFields.build();
        makeExtensionsImmutable();
      }
    }
    public static final com.google.protobuf.Descriptors.Descriptor
        getDescriptor() {
      return StockProtoMessage.internal_static_proto_Stock_descriptor;
    }

    protected FieldAccessorTable
        internalGetFieldAccessorTable() {
      return StockProtoMessage.internal_static_proto_Stock_fieldAccessorTable
          .ensureFieldAccessorsInitialized(
              Stock.class, Builder.class);
    }

    public static final int ENTRYID_FIELD_NUMBER = 1;
    private int entryId_;
    /**
     * <code>int32 entryId = 1;</code>
     */
    public int getEntryId() {
      return entryId_;
    }

    public static final int SYMBOL_FIELD_NUMBER = 2;
    private volatile Object symbol_;
    /**
     * <code>string symbol = 2;</code>
     */
    public String getSymbol() {
      Object ref = symbol_;
      if (ref instanceof String) {
        return (String) ref;
      } else {
        com.google.protobuf.ByteString bs = 
            (com.google.protobuf.ByteString) ref;
        String s = bs.toStringUtf8();
        symbol_ = s;
        return s;
      }
    }
    /**
     * <code>string symbol = 2;</code>
     */
    public com.google.protobuf.ByteString
        getSymbolBytes() {
      Object ref = symbol_;
      if (ref instanceof String) {
        com.google.protobuf.ByteString b = 
            com.google.protobuf.ByteString.copyFromUtf8(
                (String) ref);
        symbol_ = b;
        return b;
      } else {
        return (com.google.protobuf.ByteString) ref;
      }
    }

    public static final int SHAREPRICE_FIELD_NUMBER = 3;
    private double sharePrice_;
    /**
     * <code>double sharePrice = 3;</code>
     */
    public double getSharePrice() {
      return sharePrice_;
    }

    private byte memoizedIsInitialized = -1;
    public final boolean isInitialized() {
      byte isInitialized = memoizedIsInitialized;
      if (isInitialized == 1) return true;
      if (isInitialized == 0) return false;

      memoizedIsInitialized = 1;
      return true;
    }

    public void writeTo(com.google.protobuf.CodedOutputStream output)
                        throws java.io.IOException {
      if (entryId_ != 0) {
        output.writeInt32(1, entryId_);
      }
      if (!getSymbolBytes().isEmpty()) {
        com.google.protobuf.GeneratedMessageV3.writeString(output, 2, symbol_);
      }
      if (sharePrice_ != 0D) {
        output.writeDouble(3, sharePrice_);
      }
      unknownFields.writeTo(output);
    }

    public int getSerializedSize() {
      int size = memoizedSize;
      if (size != -1) return size;

      size = 0;
      if (entryId_ != 0) {
        size += com.google.protobuf.CodedOutputStream
          .computeInt32Size(1, entryId_);
      }
      if (!getSymbolBytes().isEmpty()) {
        size += com.google.protobuf.GeneratedMessageV3.computeStringSize(2, symbol_);
      }
      if (sharePrice_ != 0D) {
        size += com.google.protobuf.CodedOutputStream
          .computeDoubleSize(3, sharePrice_);
      }
      size += unknownFields.getSerializedSize();
      memoizedSize = size;
      return size;
    }

    @Override
    public boolean equals(final Object obj) {
      if (obj == this) {
       return true;
      }
      if (!(obj instanceof Stock)) {
        return super.equals(obj);
      }
      Stock other = (Stock) obj;

      boolean result = true;
      result = result && (getEntryId()
          == other.getEntryId());
      result = result && getSymbol()
          .equals(other.getSymbol());
      result = result && (
          Double.doubleToLongBits(getSharePrice())
          == Double.doubleToLongBits(
              other.getSharePrice()));
      result = result && unknownFields.equals(other.unknownFields);
      return result;
    }

    @Override
    public int hashCode() {
      if (memoizedHashCode != 0) {
        return memoizedHashCode;
      }
      int hash = 41;
      hash = (19 * hash) + getDescriptor().hashCode();
      hash = (37 * hash) + ENTRYID_FIELD_NUMBER;
      hash = (53 * hash) + getEntryId();
      hash = (37 * hash) + SYMBOL_FIELD_NUMBER;
      hash = (53 * hash) + getSymbol().hashCode();
      hash = (37 * hash) + SHAREPRICE_FIELD_NUMBER;
      hash = (53 * hash) + com.google.protobuf.Internal.hashLong(
          Double.doubleToLongBits(getSharePrice()));
      hash = (29 * hash) + unknownFields.hashCode();
      memoizedHashCode = hash;
      return hash;
    }

    public static Stock parseFrom(
        java.nio.ByteBuffer data)
        throws com.google.protobuf.InvalidProtocolBufferException {
      return PARSER.parseFrom(data);
    }
    public static Stock parseFrom(
        java.nio.ByteBuffer data,
        com.google.protobuf.ExtensionRegistryLite extensionRegistry)
        throws com.google.protobuf.InvalidProtocolBufferException {
      return PARSER.parseFrom(data, extensionRegistry);
    }
    public static Stock parseFrom(
        com.google.protobuf.ByteString data)
        throws com.google.protobuf.InvalidProtocolBufferException {
      return PARSER.parseFrom(data);
    }
    public static Stock parseFrom(
        com.google.protobuf.ByteString data,
        com.google.protobuf.ExtensionRegistryLite extensionRegistry)
        throws com.google.protobuf.InvalidProtocolBufferException {
      return PARSER.parseFrom(data, extensionRegistry);
    }
    public static Stock parseFrom(byte[] data)
        throws com.google.protobuf.InvalidProtocolBufferException {
      return PARSER.parseFrom(data);
    }
    public static Stock parseFrom(
        byte[] data,
        com.google.protobuf.ExtensionRegistryLite extensionRegistry)
        throws com.google.protobuf.InvalidProtocolBufferException {
      return PARSER.parseFrom(data, extensionRegistry);
    }
    public static Stock parseFrom(java.io.InputStream input)
        throws java.io.IOException {
      return com.google.protobuf.GeneratedMessageV3
          .parseWithIOException(PARSER, input);
    }
    public static Stock parseFrom(
        java.io.InputStream input,
        com.google.protobuf.ExtensionRegistryLite extensionRegistry)
        throws java.io.IOException {
      return com.google.protobuf.GeneratedMessageV3
          .parseWithIOException(PARSER, input, extensionRegistry);
    }
    public static Stock parseDelimitedFrom(java.io.InputStream input)
        throws java.io.IOException {
      return com.google.protobuf.GeneratedMessageV3
          .parseDelimitedWithIOException(PARSER, input);
    }
    public static Stock parseDelimitedFrom(
        java.io.InputStream input,
        com.google.protobuf.ExtensionRegistryLite extensionRegistry)
        throws java.io.IOException {
      return com.google.protobuf.GeneratedMessageV3
          .parseDelimitedWithIOException(PARSER, input, extensionRegistry);
    }
    public static Stock parseFrom(
        com.google.protobuf.CodedInputStream input)
        throws java.io.IOException {
      return com.google.protobuf.GeneratedMessageV3
          .parseWithIOException(PARSER, input);
    }
    public static Stock parseFrom(
        com.google.protobuf.CodedInputStream input,
        com.google.protobuf.ExtensionRegistryLite extensionRegistry)
        throws java.io.IOException {
      return com.google.protobuf.GeneratedMessageV3
          .parseWithIOException(PARSER, input, extensionRegistry);
    }

    public Builder newBuilderForType() { return newBuilder(); }
    public static Builder newBuilder() {
      return DEFAULT_INSTANCE.toBuilder();
    }
    public static Builder newBuilder(Stock prototype) {
      return DEFAULT_INSTANCE.toBuilder().mergeFrom(prototype);
    }
    public Builder toBuilder() {
      return this == DEFAULT_INSTANCE
          ? new Builder() : new Builder().mergeFrom(this);
    }

    @Override
    protected Builder newBuilderForType(
        BuilderParent parent) {
      Builder builder = new Builder(parent);
      return builder;
    }
    /**
     * Protobuf type {@code proto.Stock}
     */
    public static final class Builder extends
        com.google.protobuf.GeneratedMessageV3.Builder<Builder> implements
        // @@protoc_insertion_point(builder_implements:proto.Stock)
        StockOrBuilder {
      public static final com.google.protobuf.Descriptors.Descriptor
          getDescriptor() {
        return StockProtoMessage.internal_static_proto_Stock_descriptor;
      }

      protected FieldAccessorTable
          internalGetFieldAccessorTable() {
        return StockProtoMessage.internal_static_proto_Stock_fieldAccessorTable
            .ensureFieldAccessorsInitialized(
                Stock.class, Builder.class);
      }

      // Construct using org.apache.pulsar.tests.integration.presto.StockProtoMessage.Stock.newBuilder()
      private Builder() {
        maybeForceBuilderInitialization();
      }

      private Builder(
          BuilderParent parent) {
        super(parent);
        maybeForceBuilderInitialization();
      }
      private void maybeForceBuilderInitialization() {
        if (com.google.protobuf.GeneratedMessageV3
                .alwaysUseFieldBuilders) {
        }
      }
      public Builder clear() {
        super.clear();
        entryId_ = 0;

        symbol_ = "";

        sharePrice_ = 0D;

        return this;
      }

      public com.google.protobuf.Descriptors.Descriptor
          getDescriptorForType() {
        return StockProtoMessage.internal_static_proto_Stock_descriptor;
      }

      public Stock getDefaultInstanceForType() {
        return Stock.getDefaultInstance();
      }

      public Stock build() {
        Stock result = buildPartial();
        if (!result.isInitialized()) {
          throw newUninitializedMessageException(result);
        }
        return result;
      }

      public Stock buildPartial() {
        Stock result = new Stock(this);
        result.entryId_ = entryId_;
        result.symbol_ = symbol_;
        result.sharePrice_ = sharePrice_;
        onBuilt();
        return result;
      }

      public Builder clone() {
        return (Builder) super.clone();
      }
      public Builder setField(
          com.google.protobuf.Descriptors.FieldDescriptor field,
          Object value) {
        return (Builder) super.setField(field, value);
      }
      public Builder clearField(
          com.google.protobuf.Descriptors.FieldDescriptor field) {
        return (Builder) super.clearField(field);
      }
      public Builder clearOneof(
          com.google.protobuf.Descriptors.OneofDescriptor oneof) {
        return (Builder) super.clearOneof(oneof);
      }
      public Builder setRepeatedField(
          com.google.protobuf.Descriptors.FieldDescriptor field,
          int index, Object value) {
        return (Builder) super.setRepeatedField(field, index, value);
      }
      public Builder addRepeatedField(
          com.google.protobuf.Descriptors.FieldDescriptor field,
          Object value) {
        return (Builder) super.addRepeatedField(field, value);
      }
      public Builder mergeFrom(com.google.protobuf.Message other) {
        if (other instanceof Stock) {
          return mergeFrom((Stock)other);
        } else {
          super.mergeFrom(other);
          return this;
        }
      }

      public Builder mergeFrom(Stock other) {
        if (other == Stock.getDefaultInstance()) return this;
        if (other.getEntryId() != 0) {
          setEntryId(other.getEntryId());
        }
        if (!other.getSymbol().isEmpty()) {
          symbol_ = other.symbol_;
          onChanged();
        }
        if (other.getSharePrice() != 0D) {
          setSharePrice(other.getSharePrice());
        }
        this.mergeUnknownFields(other.unknownFields);
        onChanged();
        return this;
      }

      public final boolean isInitialized() {
        return true;
      }

      public Builder mergeFrom(
          com.google.protobuf.CodedInputStream input,
          com.google.protobuf.ExtensionRegistryLite extensionRegistry)
          throws java.io.IOException {
        Stock parsedMessage = null;
        try {
          parsedMessage = PARSER.parsePartialFrom(input, extensionRegistry);
        } catch (com.google.protobuf.InvalidProtocolBufferException e) {
          parsedMessage = (Stock) e.getUnfinishedMessage();
          throw e.unwrapIOException();
        } finally {
          if (parsedMessage != null) {
            mergeFrom(parsedMessage);
          }
        }
        return this;
      }

      private int entryId_ ;
      /**
       * <code>int32 entryId = 1;</code>
       */
      public int getEntryId() {
        return entryId_;
      }
      /**
       * <code>int32 entryId = 1;</code>
       */
      public Builder setEntryId(int value) {
        
        entryId_ = value;
        onChanged();
        return this;
      }
      /**
       * <code>int32 entryId = 1;</code>
       */
      public Builder clearEntryId() {
        
        entryId_ = 0;
        onChanged();
        return this;
      }

      private Object symbol_ = "";
      /**
       * <code>string symbol = 2;</code>
       */
      public String getSymbol() {
        Object ref = symbol_;
        if (!(ref instanceof String)) {
          com.google.protobuf.ByteString bs =
              (com.google.protobuf.ByteString) ref;
          String s = bs.toStringUtf8();
          symbol_ = s;
          return s;
        } else {
          return (String) ref;
        }
      }
      /**
       * <code>string symbol = 2;</code>
       */
      public com.google.protobuf.ByteString
          getSymbolBytes() {
        Object ref = symbol_;
        if (ref instanceof String) {
          com.google.protobuf.ByteString b = 
              com.google.protobuf.ByteString.copyFromUtf8(
                  (String) ref);
          symbol_ = b;
          return b;
        } else {
          return (com.google.protobuf.ByteString) ref;
        }
      }
      /**
       * <code>string symbol = 2;</code>
       */
      public Builder setSymbol(
          String value) {
        if (value == null) {
    throw new NullPointerException();
  }
  
        symbol_ = value;
        onChanged();
        return this;
      }
      /**
       * <code>string symbol = 2;</code>
       */
      public Builder clearSymbol() {
        
        symbol_ = getDefaultInstance().getSymbol();
        onChanged();
        return this;
      }
      /**
       * <code>string symbol = 2;</code>
       */
      public Builder setSymbolBytes(
          com.google.protobuf.ByteString value) {
        if (value == null) {
    throw new NullPointerException();
  }
  checkByteStringIsUtf8(value);
        
        symbol_ = value;
        onChanged();
        return this;
      }

      private double sharePrice_ ;
      /**
       * <code>double sharePrice = 3;</code>
       */
      public double getSharePrice() {
        return sharePrice_;
      }
      /**
       * <code>double sharePrice = 3;</code>
       */
      public Builder setSharePrice(double value) {
        
        sharePrice_ = value;
        onChanged();
        return this;
      }
      /**
       * <code>double sharePrice = 3;</code>
       */
      public Builder clearSharePrice() {
        
        sharePrice_ = 0D;
        onChanged();
        return this;
      }
      public final Builder setUnknownFields(
          final com.google.protobuf.UnknownFieldSet unknownFields) {
        return super.setUnknownFieldsProto3(unknownFields);
      }

      public final Builder mergeUnknownFields(
          final com.google.protobuf.UnknownFieldSet unknownFields) {
        return super.mergeUnknownFields(unknownFields);
      }


      // @@protoc_insertion_point(builder_scope:proto.Stock)
    }

    // @@protoc_insertion_point(class_scope:proto.Stock)
    private static final Stock DEFAULT_INSTANCE;
    static {
      DEFAULT_INSTANCE = new Stock();
    }

    public static Stock getDefaultInstance() {
      return DEFAULT_INSTANCE;
    }

    private static final com.google.protobuf.Parser<Stock>
        PARSER = new com.google.protobuf.AbstractParser<Stock>() {
      public Stock parsePartialFrom(
          com.google.protobuf.CodedInputStream input,
          com.google.protobuf.ExtensionRegistryLite extensionRegistry)
          throws com.google.protobuf.InvalidProtocolBufferException {
        return new Stock(input, extensionRegistry);
      }
    };

    public static com.google.protobuf.Parser<Stock> parser() {
      return PARSER;
    }

    @Override
    public com.google.protobuf.Parser<Stock> getParserForType() {
      return PARSER;
    }

    public Stock getDefaultInstanceForType() {
      return DEFAULT_INSTANCE;
    }

  }

  private static final com.google.protobuf.Descriptors.Descriptor
    internal_static_proto_Stock_descriptor;
  private static final 
    com.google.protobuf.GeneratedMessageV3.FieldAccessorTable
      internal_static_proto_Stock_fieldAccessorTable;

  public static com.google.protobuf.Descriptors.FileDescriptor
      getDescriptor() {
    return descriptor;
  }
  private static  com.google.protobuf.Descriptors.FileDescriptor
      descriptor;
  static {
    String[] descriptorData = {
      "\n\016StockMsg.proto\022\005proto\"<\n\005Stock\022\017\n\007entr" +
      "yId\030\001 \001(\005\022\016\n\006symbol\030\002 \001(\t\022\022\n\nsharePrice\030" +
      "\003 \001(\001B?\n*org.apache.pulsar.tests.integra" +
      "tion.prestoB\021StockProtoMessageb\006proto3"
    };
    com.google.protobuf.Descriptors.FileDescriptor.InternalDescriptorAssigner assigner =
        new com.google.protobuf.Descriptors.FileDescriptor.    InternalDescriptorAssigner() {
          public com.google.protobuf.ExtensionRegistry assignDescriptors(
              com.google.protobuf.Descriptors.FileDescriptor root) {
            descriptor = root;
            return null;
          }
        };
    com.google.protobuf.Descriptors.FileDescriptor
      .internalBuildGeneratedFileFrom(descriptorData,
        new com.google.protobuf.Descriptors.FileDescriptor[] {
        }, assigner);
    internal_static_proto_Stock_descriptor =
      getDescriptor().getMessageTypes().get(0);
    internal_static_proto_Stock_fieldAccessorTable = new
      com.google.protobuf.GeneratedMessageV3.FieldAccessorTable(
        internal_static_proto_Stock_descriptor,
        new String[] { "EntryId", "Symbol", "SharePrice", });
  }

  // @@protoc_insertion_point(outer_class_scope)
}