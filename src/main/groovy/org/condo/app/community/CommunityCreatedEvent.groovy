package org.condo.app.community

import groovy.transform.TupleConstructor

@TupleConstructor
class CommunityCreatedEvent {
    String id
    String name
}
