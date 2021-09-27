package com.example.bigbowlxp;

import com.example.bigbowlxp.models.BowlingLane;
import com.example.bigbowlxp.services.BowlingService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.ArrayList;
import java.util.List;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

@SpringBootTest
public class BowlingLaneApplicationTest {

    @Autowired
    BowlingService bowlingService;

    @Test
    void laneListTest(){
        List<BowlingLane> lanes = bowlingService.getLanes();
        assertThat(lanes.size() == 24);
        assertThat(lanes.get(0).isChildLane());
        assertThat(lanes.get(1).isChildLane());
        assertThat(lanes.get(2).isChildLane());
        assertThat(lanes.get(3).isChildLane());
    }


}
