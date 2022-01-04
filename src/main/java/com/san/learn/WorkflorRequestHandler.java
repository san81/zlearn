package com.san.learn;
import java.util.List;
import java.util.Random;
import java.util.stream.Collectors;

/**
 * In this scenario, we have a collection of long-running requests whose status we would like to monitor. Most
 * importantly, we want to know when every request has completed or if any single one has failed.
 */
class WorkflowRequestHandler {

    private Random rand = new Random();

    public enum RequestStatus {
        IN_PROGRESS,
        COMPLETE,
        FAILED
    }

    /**
     * This class acts as a proxy for an external service that is processing a single request. What the service is doing
     * is irrelevant - what is important, however, is retrieving the {@link RequestStatus} of this request via the
     * {@link SimpleServiceLifecycle#getRequestStatus()} method.
     */
    public class SimpleServiceLifecycle {

        private long requestId;

        private RequestStatus requestStatus = RequestStatus.IN_PROGRESS;

        private boolean requestIsFinalized = false;

        public SimpleServiceLifecycle(long requestId) {
            this.requestId = requestId;
        }

        public long getRequestId() {
            return requestId;
        }

        /**
         * Returns the status of our mocked request. The status will remain {@link RequestStatus#IN_PROGRESS} until it
         * has reached either {@link RequestStatus#COMPLETE} or {@link RequestStatus#FAILED}, at which point the status
         * is final.
         */
        public RequestStatus getRequestStatus() {
            if (requestIsFinalized) {
                return requestStatus;
            }

            int randVal = rand.nextInt(100) + 1;
            // 1% chance of failure; 25% chance of completion
            if (randVal == 1) {
                requestStatus = RequestStatus.FAILED;
                requestIsFinalized = true;
            } else if (randVal <= 75) {
                requestStatus = RequestStatus.IN_PROGRESS;
            } else {
                requestStatus = RequestStatus.COMPLETE;
                requestIsFinalized = true;
            }

            return requestStatus;
        }
    }

    /**
     * Fires off service requests for the given list of requestIds so the statuses can be tracked via this class.
     */
    public void submitRequests(List<Long> requestIds) {
        // IMPLEMENT THIS
    }

    /**
     * Returns the overall status of all our requests. If a single request is {@link RequestStatus#FAILED}, all requests
     * should be considered failed. Similarly, this method should only return {@link RequestStatus#COMPLETE} if all
     * requests are complete.
     * Example 1:
     *  Request 1 -> COMPLETE
     *  Request 2 -> IN_PROGRESS
     *  Request 3 -> FAILED
     *  getOverallStatus() -> FAILED
     *
     * Example 2:
     *  Request 1 -> COMPLETE
     *  Request 2 -> IN_PROGRESS
     *  Request 3 -> COMPLETE
     *
     *  getOverallStatus() -> IN_PROGRESS
     *
     * Example 3:
     *  Request 1 -> COMPLETE
     *  Request 2 -> COMPLETE
     *  Request 3 -> COMPLETE
     *
     *  getOverallStatus() -> COMPLETE
     **/
    public RequestStatus getOverallStatus() {
        // IMPLEMENT THIS

        return RequestStatus.COMPLETE;
    }

    public static void main(String[] args) {
        List<Long> requestIds = new Random()
                .longs(10)
                .boxed()
                .collect(Collectors.toList());

        WorkflowRequestHandler handler = new WorkflowRequestHandler();
        handler.submitRequests(requestIds);
        while (handler.getOverallStatus() == RequestStatus.IN_PROGRESS) {
            System.out.println(RequestStatus.IN_PROGRESS);
        }

        System.out.println("Requests finished with status " + handler.getOverallStatus());
    }
}