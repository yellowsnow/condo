package org.condo.app

import org.axonframework.test.aggregate.AggregateTestFixture
import org.axonframework.test.aggregate.FixtureConfiguration
import org.condo.app.community.Community
import org.condo.app.community.CommunityCreatedEvent
import org.condo.app.community.CreateCommunityCommand
import org.junit.jupiter.api.Test

import org.springframework.boot.test.context.SpringBootTest

@SpringBootTest
class CommunityTests {
    private FixtureConfiguration<Community> fixture= new AggregateTestFixture<>(Community.class)


    @Test
    void testCreateCommunity() {
        fixture.given().when(new CreateCommunityCommand("id1", "Community 1"))
                .expectSuccessfulHandlerExecution()
                .expectEvents(new CommunityCreatedEvent("id1", "Community 1"))
    }
}
