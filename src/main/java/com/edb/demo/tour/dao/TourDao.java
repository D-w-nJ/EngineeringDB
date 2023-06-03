package com.edb.demo.tour.dao;

import com.edb.demo.tour.dto.request.TourOption;
import com.edb.demo.tour.dto.response.TouristAttraction;
import com.edb.demo.tour.dto.response.TransportationInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import javax.sql.DataSource;
import java.util.List;

@Repository
public class TourDao {

    private JdbcTemplate jdbcTemplate;

    @Autowired
    public void setDataSource(DataSource dataSource) {
        this.jdbcTemplate = new JdbcTemplate(dataSource);
    }

    public void saveOption(int memberId, TourOption tourOption) {
        String saveOptionQuery = "INSERT INTO TRAVEL_OPTION (member_id, travel_purpose, crowd_preference, has_child, preference_for_nature, travel_days) VALUE (?,?,?,?,?,?)";
        Object[] saveOptionParams = new Object[]{
                memberId,
                tourOption.getTravelPulpose(),
                tourOption.getCrowdPreference(),
                tourOption.getHasChild(),
                tourOption.getPreferenceNature(),
                tourOption.getTravelDays()};
        this.jdbcTemplate.update(saveOptionQuery, saveOptionParams);
    }

    public List<TouristAttraction> recommend(TourOption tourOption) {
        String recommendQuery = "SELECT\n" +
                "region, tourist_attraction_name, sub_category, tourist_attraction_url\n" +
                "FROM TOURIST_ATTRACTION\n" +
                "WHERE\n" +
                "CATEGORY NOT IN ('숙박', '기타')\n" +
                "AND region IN " +
                "( SELECT REGION.region from TRANSPORTATION_INFO INNER JOIN REGION on TRANSPORTATION_INFO.region = REGION.region " +
                "WHERE transportation_time <= ? AND log2(visitor_count/area)-9 <= ? + 3 " +
                "AND log2(visitor_count/area)-9 >= ? - 3)\n" +
                "AND natural_affinity_score >= ?\n" +
                "AND IF(? = 1, kid_friendly_score = 1.0, 1)\n" +
                "ORDER BY RAND()\n" +
                "LIMIT 5;";
        Object[] recommendParams = new Object[]{tourOption.getTravelDays() * 30, tourOption.getCrowdPreference(), tourOption.getCrowdPreference(),(double) tourOption.getPreferenceNature() / 10.0, tourOption.getHasChild()};

        return this.jdbcTemplate.query(recommendQuery, recommendParams,
                (rs, rowNum) -> TouristAttraction.builder()
                        .region(rs.getString("region"))
                        .destination(rs.getString("tourist_attraction_name"))
                        .category(rs.getString("sub_category"))
                        .destinationUrl(rs.getString("tourist_attraction_url"))
                        .transportationInfos(getTransportationInfo(rs.getString("region")))
                        .build()
        );
    }

    public List<TransportationInfo> getTransportationInfo(String region){
        String getTransportationInfoQuery = "SELECT transportation_type, transportation_time, transportation_cost FROM TRANSPORTATION_INFO WHERE region = ?";
        Object[] getTransportationInfoParams = new Object[]{region};

        return this.jdbcTemplate.query(getTransportationInfoQuery,getTransportationInfoParams,
                (rs, rowNum) -> TransportationInfo.builder()
                        .type(rs.getString("transportation_type"))
                        .timeTaken((double) (rs.getInt("transportation_time")/60.0))
                        .cost(rs.getInt("transportation_cost"))
                        .build()
        );
    }
}
