package com.edb.demo.tour.controller;


import com.edb.demo.global.BaseController;
import com.edb.demo.member.exception.MemberNotMatchException;
import com.edb.demo.tour.dto.request.TourOption;
import com.edb.demo.tour.dto.response.TouristAttraction;
import com.edb.demo.tour.service.TourService;
import com.edb.demo.util.JwtService;
import io.swagger.annotations.ApiOperation;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/tours")
@Slf4j
public class TourController extends BaseController {
    private final TourService tourService;
    private final JwtService jwtService;

    @Autowired
    public TourController(TourService tourService, JwtService jwtService) {
        this.tourService = tourService;
        this.jwtService = jwtService;
    }

    @PostMapping("")
    @ApiOperation(value = "여행지 추천", notes = "여행지를 추천한다.", httpMethod = "POST", response = ResponseEntity.class, consumes = "application/json", tags = {})
    public ResponseEntity<?> recommendDestination(@RequestBody TourOption tourOption, @RequestParam(required = true) int memberId) throws Exception {
//        int memberIdByJwt = jwtService.getUserIdx();
//        if(memberIdByJwt != memberIdByJwt){
//            throw new MemberNotMatchException();
//        }

        List<TouristAttraction> result = tourService.recommend(memberId,tourOption);
        return ResponseEntity.ok(result);
    }
}
