package com.sibintek.data.workflow.config;

import com.sibintek.data.workflow.listener.StateMachineOrdOrgListener;
import com.sibintek.data.workflow.statemachine.event.EventOrderOrg;
import com.sibintek.data.workflow.statemachine.state.StateOrderOrg;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.statemachine.StateMachinePersist;
import org.springframework.statemachine.config.EnableStateMachineFactory;
import org.springframework.statemachine.config.EnumStateMachineConfigurerAdapter;
import org.springframework.statemachine.config.StateMachineFactory;
import org.springframework.statemachine.config.builders.StateMachineConfigurationConfigurer;
import org.springframework.statemachine.config.builders.StateMachineStateConfigurer;
import org.springframework.statemachine.config.builders.StateMachineTransitionConfigurer;
import org.springframework.statemachine.data.jpa.JpaPersistingStateMachineInterceptor;
import org.springframework.statemachine.data.jpa.JpaStateMachineRepository;
import org.springframework.statemachine.persist.DefaultStateMachinePersister;
import org.springframework.statemachine.persist.StateMachinePersister;
import org.springframework.statemachine.persist.StateMachineRuntimePersister;
import org.springframework.statemachine.service.DefaultStateMachineService;
import org.springframework.statemachine.service.StateMachineService;

import java.util.EnumSet;

@Configuration
@EnableStateMachineFactory
public class StateMachineConfig extends EnumStateMachineConfigurerAdapter<StateOrderOrg, EventOrderOrg> {

    @Autowired
    private JpaStateMachineRepository jpaStateMachineRepository;


    @Override
    public void configure(StateMachineConfigurationConfigurer<StateOrderOrg, EventOrderOrg> config) throws Exception {
        config
//                .withPersistence()
//                .runtimePersister(stateMachineRuntimePersister());
                .withConfiguration()
                .autoStartup(true)
                .listener(new StateMachineOrdOrgListener());

    }

    @Override
    public void configure(StateMachineStateConfigurer<StateOrderOrg, EventOrderOrg> states) throws Exception {
        states
                .withStates()
                .initial(StateOrderOrg.NEW)
                .end(StateOrderOrg.APPROVE)
                .end(StateOrderOrg.DECLINE)
                .states(EnumSet.allOf(StateOrderOrg.class));
    }

    @Override
    public void configure(StateMachineTransitionConfigurer<StateOrderOrg, EventOrderOrg> transitions) throws Exception {
        transitions
                .withExternal().source(StateOrderOrg.NEW).target(StateOrderOrg.SAVE).event(EventOrderOrg.SAVING)
                .and()
                .withExternal().source(StateOrderOrg.SAVE).target(StateOrderOrg.CHECK).event(EventOrderOrg.TO_CHECK)
                .and()
                .withExternal().source(StateOrderOrg.CHECK).target(StateOrderOrg.APPROVE).event(EventOrderOrg.APPROVED)
                .and()
                .withExternal().source(StateOrderOrg.CHECK).target(StateOrderOrg.DECLINE).event(EventOrderOrg.DECLINED)
                .and()
                .withExternal().source(StateOrderOrg.CHECK).target(StateOrderOrg.CORRECT).event(EventOrderOrg.TO_CORRECT)
                .and()
                .withExternal().source(StateOrderOrg.CORRECT).target(StateOrderOrg.SAVE).event(EventOrderOrg.SAVE_AFTER_CORRECT);

    }

    @Bean
    public StateMachineRuntimePersister<StateOrderOrg, EventOrderOrg, String> stateMachineRuntimePersister() {
        return new JpaPersistingStateMachineInterceptor<>(jpaStateMachineRepository);
    }

    @Bean
    public StateMachinePersister<StateOrderOrg, EventOrderOrg, String> stateMachinePersister(
            StateMachinePersist<StateOrderOrg, EventOrderOrg, String> defaultPersist) {
        return new DefaultStateMachinePersister<>(defaultPersist);
    }

    @Bean
    public StateMachineService<StateOrderOrg, EventOrderOrg> stateMachineService(
            StateMachineFactory<StateOrderOrg, EventOrderOrg> stateMachineFactory,
            StateMachineRuntimePersister<StateOrderOrg, EventOrderOrg, String> stateMachineRuntimePersister) {
        return new DefaultStateMachineService<StateOrderOrg, EventOrderOrg>(stateMachineFactory, stateMachineRuntimePersister);
    }
}
