package com.sibintek.data.workflow.controller;

import com.sibintek.data.workflow.service.StateMachineOrdOrgService;
import org.springframework.web.bind.annotation.*;

@RequestMapping("/api/statemachine")
@RestController
public class ControllerOrdPrg {

    private StateMachineOrdOrgService service;

    public ControllerOrdPrg(StateMachineOrdOrgService service) {
        this.service = service;
    }

    @GetMapping("/{id}/persist/{event}")
    public Boolean persistState(@PathVariable String id, @PathVariable int event){
        return service.persistSM(id, event);
    }

    @GetMapping("/{id}")
    public String getStateById(@PathVariable String id){
        return service.getStateById(id);
    }

}
