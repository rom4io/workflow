package com.sibintek.data.workflow.service;

import com.sibintek.data.workflow.statemachine.event.EventOrderOrg;
import com.sibintek.data.workflow.statemachine.state.StateOrderOrg;
import org.springframework.statemachine.StateMachine;
import org.springframework.statemachine.config.StateMachineFactory;
import org.springframework.statemachine.persist.StateMachinePersister;
import org.springframework.statemachine.service.StateMachineService;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class StateMachineOrdOrgServiceImpl implements StateMachineOrdOrgService {


    private StateMachineService stateMachineService;
    private StateMachinePersister persister;

    private final StateMachineFactory<StateOrderOrg, EventOrderOrg> stateMachineFactory;

    public StateMachineOrdOrgServiceImpl(StateMachineService stateMachineService, StateMachinePersister persister,
                                         StateMachineFactory<StateOrderOrg, EventOrderOrg> stateMachineFactory) {
        this.stateMachineService = stateMachineService;
        this.persister = persister;
        this.stateMachineFactory = stateMachineFactory;
    }

    @Transactional
    public Boolean persistSM(String id, int event) {

        StateMachine<StateOrderOrg, EventOrderOrg> sm = stateMachineService.acquireStateMachine(id, true);
        sm.sendEvent(EventOrderOrg.values()[event]);
        stateMachineService.releaseStateMachine(id, false);
//        final StateMachine<StateOrderOrg, EventOrderOrg> sm = stateMachineFactory.getStateMachine();
//        try {
//            if (persister.restore(sm, id) == null) {
//                sm.sendEvent(EventOrderOrg.values()[event]);
//                persister.persist(sm, id);
//            } else {
//                persister.restore(sm, id);
//                sm.sendEvent(EventOrderOrg.values()[event]);
//            }
//        } catch (Exception e) {
//            e.printStackTrace();
//            return false;
//        }

        return true;
    }

    @Transactional
    public String getStateById(String id) {
        StateMachine<StateOrderOrg, EventOrderOrg> sm = stateMachineService.acquireStateMachine(id, false);
        return sm.getState().toString();
//        final StateMachine<StateOrderOrg, EventOrderOrg> sm = stateMachineFactory.getStateMachine();
//        try {
//            return persister.restore(sm, id).getState().toString();
//        } catch (Exception e) {
//            throw new RuntimeException(e);
    }
}



