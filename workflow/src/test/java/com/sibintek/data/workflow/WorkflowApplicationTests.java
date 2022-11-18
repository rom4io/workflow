package com.sibintek.data.workflow;

import com.sibintek.data.workflow.statemachine.event.EventOrderOrg;
import com.sibintek.data.workflow.statemachine.state.StateOrderOrg;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.statemachine.StateMachine;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@SpringBootTest
class WorkflowApplicationTests {

    private StateMachine<StateOrderOrg, EventOrderOrg> stateMachine;

    WorkflowApplicationTests(StateMachine<StateOrderOrg, EventOrderOrg> stateMachine) {
        this.stateMachine = stateMachine;
    }

    @Test
    public void contextLoads() {
    }

    @Test
    public void initTest() {
        Assertions.assertThat(stateMachine.getState().getId())
                .isEqualTo(StateOrderOrg.NEW);

        Assertions.assertThat(stateMachine).isNotNull();
    }

}
