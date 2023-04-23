package com.shubham.swapsie.controller;

import com.shubham.swapsie.model.Product;
import com.shubham.swapsie.model.SwapRequest;
import com.shubham.swapsie.service.SwapRequestService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin(origins = "http://localhost:3000")
@RequestMapping("/swapRequest")
public class SwapRequestController {

    @Autowired
    SwapRequestService swapRequestService;

    @PostMapping("/create")
    public ResponseEntity<SwapRequest> createSwapRequest(@RequestBody SwapRequest swapRequest){
        SwapRequest newSwapRequest = swapRequestService.createSwapRequest(swapRequest);
        return new ResponseEntity<>(newSwapRequest, HttpStatus.CREATED);
    }

    @GetMapping("/getAllSwapRequests")
    public ResponseEntity<List<SwapRequest>> getAllSwapRequests(){
        List<SwapRequest> swapRequestList = swapRequestService.getAllSwapRequests();
        return new ResponseEntity<>(swapRequestList, HttpStatus.OK);
    }

    @GetMapping("/getAllSwapRequestsByProduct1/{product1_id}")
    public ResponseEntity<List<SwapRequest>> getAllSwapRequestsByProduct1(@PathVariable long product1_id){
        List<SwapRequest> swapRequestList = swapRequestService.getSwapRequestByProduct1(product1_id);
        return new ResponseEntity<>(swapRequestList,HttpStatus.OK);
    }

    @GetMapping("/getAllSwapRequestsByProduct2/{product2_id}")
    public ResponseEntity<List<SwapRequest>> getAllSwapRequestsByProduct2(@PathVariable long product2_id){
        List<SwapRequest> swapRequestList = swapRequestService.getSwapRequestByProduct2(product2_id);
        return new ResponseEntity<>(swapRequestList,HttpStatus.OK);
    }

    @GetMapping("/getAllSwapRequestsByUser1/{user1_id}")
    public ResponseEntity<List<SwapRequest>> getAllSwapRequestsByUser1(@PathVariable long user1_id){
        List<SwapRequest> swapRequestList = swapRequestService.getSwapRequestByUser1(user1_id);
        return new ResponseEntity<>(swapRequestList,HttpStatus.OK);
    }

    @GetMapping("/getAllSwapRequestsByUser2/{user2_id}")
    public ResponseEntity<List<SwapRequest>> getAllSwapRequestsByUser2(@PathVariable long user2_id){
        List<SwapRequest> swapRequestList = swapRequestService.getSwapRequestByUser2(user2_id);
        return new ResponseEntity<>(swapRequestList,HttpStatus.OK);
    }


    @GetMapping("/get/{id}")
    public ResponseEntity<SwapRequest> getSwapRequestById(@PathVariable long id){
        SwapRequest swapRequest = swapRequestService.getSwapRequestById(id);
        return new ResponseEntity<>(swapRequest, HttpStatus.OK);
    }

    @DeleteMapping("/delete/{id}")
    public String deleteSwapRequest(@PathVariable long id){
        return swapRequestService.deleteSwapRequest(id);
    }

    @PutMapping("/update/{id}")
    public ResponseEntity<SwapRequest> updateSwapRequest(@PathVariable long id,@RequestBody SwapRequest swapRequest){
        SwapRequest updatedSwapRequest = swapRequestService.updateSwapRequest(id, swapRequest);
        return new ResponseEntity<>(updatedSwapRequest,HttpStatus.OK);
    }

    @PutMapping("/{id}/decline")
    public String declineSwapRequest(@PathVariable long id){
        return swapRequestService.declineSwapRequest(id);
    }

    @PutMapping("/{id}/accept")
    public ResponseEntity<SwapRequest> acceptSwapRequest(@PathVariable long id){
        SwapRequest acceptedSwapRequest = swapRequestService.acceptSwapRequest(id);
        return new ResponseEntity<>(acceptedSwapRequest, HttpStatus.ACCEPTED);
    }

}
