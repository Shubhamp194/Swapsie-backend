package com.shubham.swapsie.service.impl;

import com.shubham.swapsie.exception.ResourceNotFoundException;
import com.shubham.swapsie.model.Product;
import com.shubham.swapsie.model.SwapRequest;
import com.shubham.swapsie.model.User;
import com.shubham.swapsie.repository.SwapRequestRepository;
import com.shubham.swapsie.service.SwapRequestService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class SwapRequestServiceImpl implements SwapRequestService {

    @Autowired
    SwapRequestRepository swapRequestRepository;

    @Override
    public SwapRequest createSwapRequest(SwapRequest swapRequest) {
        return swapRequestRepository.save(swapRequest);
    }

    @Override
    public List<SwapRequest> getAllSwapRequests() {
        return swapRequestRepository.findAll();
    }

    @Override
    public void deleteRequest(long id) {
        swapRequestRepository.deleteById(id);
    }

    @Override
    public SwapRequest getSwapRequestById(long id) {
        SwapRequest swapRequest = swapRequestRepository.findById(id)
                .orElseThrow( () -> new ResourceNotFoundException("SwapRequest with id : "+id+" does not exist"));
        return swapRequest;
    }

    @Override
    public SwapRequest acceptSwapRequest(long id) {
        SwapRequest swapRequest = swapRequestRepository.findById(id)
                .orElseThrow( () -> new ResourceNotFoundException("SwapRequest with id : "+id+" does not exist"));
        Product product1 = swapRequest.getProduct1();
        Product product2 = swapRequest.getProduct2();
        User user1 = swapRequest.getProduct1().getUser();
        User user2 = swapRequest.getProduct2().getUser();

        swapRequest.setStatus("Completed");
        product1.setUser(user2);
        product2.setUser(user1);


        return swapRequest;
    }
    @Override
    public void declineSwapRequest(long id) {
        swapRequestRepository.deleteById(id);
    }

    @Override
    public SwapRequest getSwapRequestByProduct1(long product1_id) {
        return null;
    }

    @Override
    public SwapRequest getSwapRequestByProduct2(long product2_id) {
        return null;
    }

    @Override
    public SwapRequest getSwapRequestByUser1(long user1_id) {
        return null;
    }

    @Override
    public SwapRequest getSwapRequestByUser2(long user2_id) {
        return null;
    }
}
