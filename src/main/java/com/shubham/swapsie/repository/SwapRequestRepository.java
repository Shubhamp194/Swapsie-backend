package com.shubham.swapsie.repository;

import com.shubham.swapsie.model.SwapRequest;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface SwapRequestRepository extends JpaRepository<SwapRequest, Long> {
    public List<SwapRequest> findAllByProduct1UserId(long product1_user_id);

    public List<SwapRequest> findAllByProduct2UserId(long product2_user_id);
}
