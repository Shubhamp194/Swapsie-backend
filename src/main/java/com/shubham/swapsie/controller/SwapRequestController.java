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

    @GetMapping("/get/{id}")
    public ResponseEntity<SwapRequest> getSwapRequestById(@PathVariable long id){
        SwapRequest swapRequest = swapRequestService.getSwapRequestById(id);
        return new ResponseEntity<>(swapRequest, HttpStatus.OK);
    }

    @PutMapping("/{id}/accept")
    public ResponseEntity<SwapRequest> acceptSwapRequest(@PathVariable long id){
        SwapRequest acceptedSwapRequest = swapRequestService.acceptSwapRequest(id);
        return new ResponseEntity<>(acceptedSwapRequest, HttpStatus.ACCEPTED);
    }

    @PutMapping("/{id}/decline")
    public void declineSwapRequest(@PathVariable long id){
        swapRequestService.declineSwapRequest(id);
//        return new ResponseEntity<>(HttpStatus.OK);
    }

}
