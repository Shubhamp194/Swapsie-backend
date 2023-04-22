package com.shubham.swapsie.service;

import com.shubham.swapsie.model.SwapRequest;

import java.util.List;

public interface SwapRequestService {
    SwapRequest createSwapRequest(SwapRequest swapRequest);

    List<SwapRequest> getAllSwapRequests();
    void deleteRequest(long id);

    SwapRequest getSwapRequestById(long id);

    SwapRequest acceptSwapRequest(long id);

    void declineSwapRequest(long id);
    SwapRequest getSwapRequestByProduct1(long product1_id);

    SwapRequest getSwapRequestByProduct2(long product2_id);

    SwapRequest getSwapRequestByUser1(long user1_id);

    SwapRequest getSwapRequestByUser2(long user2_id);
}
