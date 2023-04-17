package org.condo.app.community

import org.axonframework.commandhandling.CommandHandler
import org.axonframework.eventsourcing.EventSourcingHandler
import org.axonframework.modelling.command.AggregateIdentifier
import org.axonframework.spring.stereotype.Aggregate
import static org.axonframework.modelling.command.AggregateLifecycle.apply

@Aggregate
class Community {

    Community() {}

    @AggregateIdentifier
    String id

    @CommandHandler
    Community(CreateCommunityCommand command) {
        apply(new CommunityCreatedEvent(id: command.id, name: command.name))
    }

    @EventSourcingHandler
    void on(CommunityCreatedEvent evt) {
        id = evt.id
    }
}
