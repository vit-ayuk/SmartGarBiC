package core;

import java.text.SimpleDateFormat;
import java.util.Date;
import routing.PECCSRouter;
import core.DTNHost;

/**
 * Class to record cache decisions made by nodes in a DTN network.
 */
public class CacheDecision {

    /** Timestamp when the decision was made */
    private long timestamp;

    /** ID of the node making the decision */
    private String nodeId;

    /** ID of the message affected by the decision */
    private String messageId;

    /** Type of decision (e.g., "Add to Cache", "Remove from Cache", "Forward", "Drop") */
    private String decisionType;

    /** Reason for the decision */
    private String reason;

    /** ID of the target node (if applicable, e.g., for forwarding decisions) */
    private String targetNodeId;

    /** Congestion level of the node at the time of the decision */
    private double congestionLevel;

    /** Free buffer space of the node after the decision */
    private long freeBufferSpace;

    private double contentScore;


    /**
     * Constructor to initialize a cache decision.
     *
     * @param timestamp       Time when the decision was made
     * @param nodeId          ID of the node making the decision
     * @param messageId       ID of the message affected by the decision
     * @param decisionType    Type of decision (e.g., "Add to Cache", "Drop")
     * @param reason          Reason for the decision
     * @param targetNodeId    ID of the target node (optional, for forwarding)
     * @param congestionLevel Congestion level of the node
     * @param freeBufferSpace Free buffer space after the decision
     */
    public CacheDecision(long timestamp, String nodeId, String messageId, String decisionType, String reason,
                         String targetNodeId, double congestionLevel, long freeBufferSpace, double contentScore) {
        this.timestamp = timestamp;
        this.nodeId = nodeId;
        this.messageId = messageId;
        this.decisionType = decisionType;
        this.reason = reason;
        this.targetNodeId = targetNodeId;
        this.congestionLevel = congestionLevel;
        this.freeBufferSpace = freeBufferSpace;
        this.contentScore = contentScore;

    }

//    public CacheDecision(long timestamp, String nodeId, String contentId, String decisionType, String reason,
//                         String targetNodeId, double congestionLevel, long freeBufferSpace) {
//        this.timestamp = timestamp;            // Time when the decision was made
//        this.nodeId = nodeId;                  // ID of the node making the decision
//        this.messageId = contentId;            // Unique ID of the content (rename from messageId)
//        this.decisionType = decisionType;      // Type of decision (e.g., Cached, Deleted, Offloaded)
//        this.reason = reason;                  // Reason for the decision
//        this.targetNodeId = targetNodeId;      // Target node ID if decision involves offloading
//        this.congestionLevel = congestionLevel; // Congestion level at the time of the decision
//        this.freeBufferSpace = freeBufferSpace; // Available cache space
//    }

    // Getters and setters for each field

    public long getTimestamp() {
        return timestamp;
    }

    public void setTimestamp(long timestamp) {
        this.timestamp = timestamp;
    }

    public String getNodeId() {
        return nodeId;
    }

    public void setNodeId(String nodeId) {
        this.nodeId = nodeId;
    }

    public String getMessageId() {
        return messageId;
    }

    public void setMessageId(String messageId) {
        this.messageId = messageId;
    }

    public String getDecisionType() {
        return decisionType;
    }

    public void setDecisionType(String decisionType) {
        this.decisionType = decisionType;
    }

    public String getReason() {
        return reason;
    }

    public void setReason(String reason) {
        this.reason = reason;
    }

    public String getTargetNodeId() {
        return targetNodeId;
    }

    public void setTargetNodeId(String targetNodeId) {
        this.targetNodeId = targetNodeId;
    }

    public double getCongestionLevel() {
        return congestionLevel;
    }

    public void setCongestionLevel(double congestionLevel) {
        this.congestionLevel = congestionLevel;
    }

    public long getFreeBufferSpace() {
        return freeBufferSpace;
    }

    public void setFreeBufferSpace(long freeBufferSpace) {
        this.freeBufferSpace = freeBufferSpace;
    }

        // Getter for contentScore
       public double getContentScore() {
       return contentScore;
    }

    // Setter for contentScore
    public void setContentScore(double contentScore) {
        this.contentScore = contentScore;
    }



    /**
     * Converts the timestamp to a human-readable date format.
     *
     * @return Formatted date string
     */
    public String getFormattedTimestamp() {
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        return sdf.format(new Date(this.timestamp));
    }

    /**
     * Textual representation of the CacheDecision.
     */
    @Override
    public String toString() {
        return "CacheDecision{" +
                "timestamp=" + getFormattedTimestamp() +
                ", nodeId='" + nodeId + '\'' +
                ", messageId='" + messageId + '\'' +
                ", decisionType='" + decisionType + '\'' +
                ", reason='" + reason + '\'' +
                ", targetNodeId='" + (targetNodeId != null ? targetNodeId : "N/A") + '\'' +
                ", congestionLevel=" + congestionLevel +
                ", freeBufferSpace=" + freeBufferSpace +
                ", contentScore=" + contentScore +
                '}';
    }
}