package com.edb.demo.tour.service;

import com.edb.demo.tour.dao.TourDao;
import com.edb.demo.tour.dto.request.TourOption;
import com.edb.demo.tour.dto.response.TouristAttraction;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TourService {

    private final TourDao tourDao;

    @Autowired
    public TourService(TourDao tourDao) {
        this.tourDao = tourDao;
    }

    public List<TouristAttraction> recommend(int memberId, TourOption tourOption) {
        tourDao.saveOption(memberId,tourOption);

        return tourDao.recommend(tourOption);
    }
}
