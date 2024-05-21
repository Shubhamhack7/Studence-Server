package com.tiwari.studence.common.service.v2.table;

import com.tiwari.studence.proto.error.ErrorTypePbEnum;
import com.tiwari.studence.proto.search.PaginationRequestUiPb;
import com.tiwari.studence.proto.search.SearchResultSummaryUiPb;
import com.tiwari.studence.proto.search.TablePartitionInfoUiPb;
import com.tiwari.studence.util.collect.Pair;
import com.tiwari.studence.util.common.Strings;
import com.tiwari.studence.util.exception.Preconditions;

import java.util.Collections;
import java.util.List;

public abstract class ATablePartitioner {

  public abstract String getPartitionKey(String id);

  public abstract String getPartitionKeyWithArg(String arg);

  /**
   * @return must return partitions in a  Chronological Order
   */
  public abstract List<String> getAllTablePartitions();

  public String getMinPartitionKey() {
    return getAllTablePartitions().get(0);
  }

  public String getMaxPartitionKey() {
    return getAllTablePartitions().get(getAllTablePartitions().size() - 1);
  }

  public Pair<String, PaginationRequestUiPb> getPartitionKeyAndPagination(
          TablePartitionInfoUiPb partitionInfo, PaginationRequestUiPb pagination,
          boolean isAscending) {
    if (this.getClass() == EmptyTablePartitioner.class) {
      return new Pair<String, PaginationRequestUiPb>("", pagination);
    }
    List<String> partitions = getPartitions(partitionInfo, isAscending);
    if (Strings.isEmpty(pagination.getStartToken())) {
      return new Pair<String, PaginationRequestUiPb>(partitions.get(0), pagination);
    } else {
      Pair<String, String> tokens = splitTokens(pagination.getStartToken());
      String partitionKey = tokens.getFirst();
      String startToken = tokens.getSecond();
      Preconditions.check(isValidPartition(partitionKey),
              "Invalid partition key found in start token", pagination);
      PaginationRequestUiPb.Builder paginationBuilder = PaginationRequestUiPb.newBuilder(
              pagination);
      paginationBuilder.setStartToken(startToken);
      return new Pair<String, PaginationRequestUiPb>(partitionKey, paginationBuilder.build());
    }
  }

  public SearchResultSummaryUiPb getSearchResultSummaryWithTablePartition(
          SearchResultSummaryUiPb uiPb, TablePartitionInfoUiPb partitionInfo, String partitionKey,
          boolean isAscending) {
    if (this.getClass() == EmptyTablePartitioner.class) {
      return uiPb;
    }
    SearchResultSummaryUiPb.Builder builder = SearchResultSummaryUiPb.newBuilder(uiPb);
    if (Strings.notEmpty(builder.getNextToken())) {
      builder.setNextToken(mergeTokens(partitionKey, builder.getNextToken()));
    } else {
      String nextPartitionKey = getNextPartition(partitionInfo, partitionKey, isAscending);
      if (Strings.notEmpty(nextPartitionKey)) {
        builder.setNextToken(nextPartitionKey);
      }
    }
    return builder.build();
  }

  public String getPartitionSeparator() {
    return "#";
  }

  public Pair<String, String> splitTokens(String token) {
    if (token.contains(getPartitionSeparator())) {
      int index = token.indexOf(getPartitionSeparator());
      String tablePartitionKey = token.substring(0, index);
      String nextToken = token.substring(index + 1);
      return new Pair<String, String>(tablePartitionKey, nextToken);
    }
    return new Pair<String, String>(token, "");
  }

  public String mergeTokens(String partitionKey, String nextToken) {
    if (Strings.notEmpty(nextToken)) {
      return partitionKey + getPartitionSeparator() + nextToken;
    }
    return partitionKey;
  }

  private String getNextPartition(TablePartitionInfoUiPb partitionInfo, String currentPartitionKey,
          boolean isAscending) {
    List<String> partitions = getPartitions(partitionInfo, isAscending);
    if (!partitions.contains(currentPartitionKey)) {
      if (isAscending && (currentPartitionKey.compareTo(partitions.get(0)) < 0)) {
        return partitions.get(0);
      }
      if (!isAscending && (currentPartitionKey.compareTo(partitions.get(0)) > 0)) {
        return partitions.get(0);
      }
      return "";
    }
    int index = partitions.indexOf(currentPartitionKey);
    if (index < (partitions.size() - 1)) {
      return partitions.get(index + 1);
    } else {
      return "";
    }
  }

  private List<String> getPartitions(TablePartitionInfoUiPb partitionInfo, boolean isAscending) {
    TablePartitionInfoUiPb correctedPartitionInfo = getCorrectedTablePartitionInfo(partitionInfo);
    List<String> allPartitions = getAllTablePartitions();
    String startPartitionKey = correctedPartitionInfo.getStartPartitionKey();
    String endPartitionKey = correctedPartitionInfo.getEndPartitionKey();
    Preconditions.check(allPartitions.contains(startPartitionKey), "StartPartitionKey is invalid",
            allPartitions, startPartitionKey);
    Preconditions.check(allPartitions.contains(endPartitionKey), "EndPartitionKey is invalid",
            allPartitions, endPartitionKey);
    int startIndex = allPartitions.indexOf(startPartitionKey);
    int endIndex = allPartitions.indexOf(endPartitionKey);
    Preconditions.check(startIndex <= endIndex, "AllPartitions should be in ascending order",
            allPartitions);
    List<String> partitions = allPartitions.subList(startIndex, endIndex + 1);
    if (!isAscending) {
      Collections.sort(partitions, Collections.reverseOrder());
    }
    Preconditions.check(partitions.size() > 0, ErrorTypePbEnum.VALIDATION_FAILED,
            "Number of partitions are zero for given range");
    return partitions;
  }

  private TablePartitionInfoUiPb getCorrectedTablePartitionInfo(TablePartitionInfoUiPb uiPb) {
    TablePartitionInfoUiPb.Builder builder = TablePartitionInfoUiPb.newBuilder(uiPb);
    if (builder.getStartPartitionKey().compareTo(getMinPartitionKey()) < 0) {
      builder.setStartPartitionKey(getMinPartitionKey());
    }
    if (builder.getEndPartitionKey().compareTo(getMaxPartitionKey()) > 0) {
      builder.setEndPartitionKey(getMaxPartitionKey());
    }
    return builder.build();
  }

  private boolean isValidPartition(String partition) {
    return getAllTablePartitions().contains(partition);
  }

}
