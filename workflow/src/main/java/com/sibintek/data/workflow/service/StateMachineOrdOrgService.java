package com.sibintek.data.workflow.service;

import com.sibintek.data.workflow.statemachine.event.EventOrderOrg;

public interface StateMachineOrdOrgService {

    Boolean persistSM(String id, int event);

    String getStateById(String id);
}
