package com.sibintek.data.workflow.model;

import com.sibintek.data.workflow.statemachine.event.EventOrderOrg;
import com.sibintek.data.workflow.statemachine.state.StateOrderOrg;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.statemachine.StateMachineContext;

import javax.persistence.*;

@AllArgsConstructor
@NoArgsConstructor
@Data
@Entity
public class StateMachineModel {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Lob
    private StateMachineContext<StateOrderOrg, EventOrderOrg> stateMachine;
}
