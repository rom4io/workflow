//package com.sibintek.data.workflow.config;
//
//import com.sibintek.data.workflow.statemachine.event.EventOrderOrg;
//import com.sibintek.data.workflow.statemachine.state.StateOrderOrg;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.context.annotation.Bean;
//import org.springframework.context.annotation.Configuration;
//import org.springframework.statemachine.StateMachinePersist;
//import org.springframework.statemachine.config.StateMachineFactory;
//import org.springframework.statemachine.data.RepositoryState;
//import org.springframework.statemachine.data.StateRepository;
//import org.springframework.statemachine.data.jpa.JpaPersistingStateMachineInterceptor;
//import org.springframework.statemachine.data.jpa.JpaStateMachineRepository;
//import org.springframework.statemachine.persist.DefaultStateMachinePersister;
//import org.springframework.statemachine.persist.StateMachinePersister;
//import org.springframework.statemachine.persist.StateMachineRuntimePersister;
//import org.springframework.statemachine.service.DefaultStateMachineService;
//import org.springframework.statemachine.service.StateMachineService;
//
//@Configuration
//public class StateMachineConfigPersist {
//
//
//    @Bean
//    public StateMachineRuntimePersister<StateOrderOrg, EventOrderOrg, Long> stateMachineRuntimePersister(
//            final JpaStateMachineRepository jpaStateMachineRepository) {
//        return new JpaPersistingStateMachineInterceptor<>(jpaStateMachineRepository);
//    }
//
//
//    @Bean
//    public StateMachinePersister<StateOrderOrg, EventOrderOrg, Long> stateMachinePersister(
//            StateMachinePersist<StateOrderOrg, EventOrderOrg, Long> defaultPersist) {
//        return new DefaultStateMachinePersister<>(defaultPersist);
//    }
//
//    @Bean
//    public StateMachineService<StateOrderOrg, EventOrderOrg> stateMachineService(StateMachineFactory<StateOrderOrg, EventOrderOrg> stateMachineFactory,
//                                                                                 StateMachineRuntimePersister<StateOrderOrg, EventOrderOrg, String> stateMachineRuntimePersister) {
//        return new DefaultStateMachineService<StateOrderOrg, EventOrderOrg>(stateMachineFactory, stateMachineRuntimePersister);
//    }
//}
