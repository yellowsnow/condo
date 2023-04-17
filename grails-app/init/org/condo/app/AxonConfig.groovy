package org.condo.app

import org.axonframework.commandhandling.CommandBus
import org.axonframework.commandhandling.SimpleCommandBus
import org.axonframework.eventsourcing.AggregateSnapshotter
import org.axonframework.eventsourcing.Snapshotter
import org.axonframework.eventsourcing.eventstore.EmbeddedEventStore
import org.axonframework.eventsourcing.eventstore.EventStorageEngine
import org.axonframework.eventsourcing.eventstore.EventStore
import org.axonframework.eventsourcing.eventstore.inmemory.InMemoryEventStorageEngine
import org.springframework.boot.SpringBootConfiguration
import org.springframework.context.annotation.Bean

@SuppressWarnings("unused")
@SpringBootConfiguration
class AxonConfig {


    @Bean
    @SuppressWarnings("GrMethodMayBeStatic")
    CommandBus commandBus() {
        return SimpleCommandBus.builder().build()
    }


    @Bean
    @SuppressWarnings("GrMethodMayBeStatic")
    Snapshotter snapshotter(EventStore eventStore) {
        return AggregateSnapshotter.builder().eventStore(eventStore).build()
    }

    @Bean
    @SuppressWarnings("GrMethodMayBeStatic")
    EventStore eventStore(EventStorageEngine storageEngine) {
        return EmbeddedEventStore.builder().storageEngine(storageEngine).build()
    }

    @Bean
    @SuppressWarnings("GrMethodMayBeStatic")
    EventStorageEngine storageEngine() {
        return new InMemoryEventStorageEngine()
    }
}

