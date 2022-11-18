package com.sibintek.data.workflow.listener;

import com.sibintek.data.workflow.statemachine.event.EventOrderOrg;
import com.sibintek.data.workflow.statemachine.state.StateOrderOrg;
import org.springframework.messaging.Message;
import org.springframework.statemachine.StateContext;
import org.springframework.statemachine.StateMachine;
import org.springframework.statemachine.listener.StateMachineListener;
import org.springframework.statemachine.state.State;
import org.springframework.statemachine.transition.Transition;

public class StateMachineOrdOrgListener implements StateMachineListener<StateOrderOrg, EventOrderOrg> {
    @Override
    public void stateChanged(State<StateOrderOrg, EventOrderOrg> from, State<StateOrderOrg, EventOrderOrg> to) {
        if(from.getId() != null){
            System.out.println("Переход из статуса " + from.getId() + " в статус " + to.getId());
        }
    }

    @Override
    public void stateEntered(State<StateOrderOrg, EventOrderOrg> state) {

    }

    @Override
    public void stateExited(State<StateOrderOrg, EventOrderOrg> state) {

    }

    @Override
    public void eventNotAccepted(Message<EventOrderOrg> event) {

    }

    @Override
    public void transition(Transition<StateOrderOrg, EventOrderOrg> transition) {

    }

    @Override
    public void transitionStarted(Transition<StateOrderOrg, EventOrderOrg> transition) {

    }

    @Override
    public void transitionEnded(Transition<StateOrderOrg, EventOrderOrg> transition) {

    }

    @Override
    public void stateMachineStarted(StateMachine<StateOrderOrg, EventOrderOrg> stateMachine) {

    }

    @Override
    public void stateMachineStopped(StateMachine<StateOrderOrg, EventOrderOrg> stateMachine) {

    }

    @Override
    public void stateMachineError(StateMachine<StateOrderOrg, EventOrderOrg> stateMachine, Exception exception) {

    }

    @Override
    public void extendedStateChanged(Object key, Object value) {

    }

    @Override
    public void stateContext(StateContext<StateOrderOrg, EventOrderOrg> stateContext) {

    }
}
