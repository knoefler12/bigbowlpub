package com.example.bigbowlxp;

import com.example.bigbowlxp.models.BowlingLane;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
public class ModelTest {


    @Test
    void bowlingModelTest(){
        BowlingLane lane = new BowlingLane();
        lane.setId(1);
        lane.setChildLane(false);
        lane.setStatus(true);
        lane.desription("all ok!");
    }

}
