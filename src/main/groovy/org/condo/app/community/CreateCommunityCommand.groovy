package org.condo.app.community

import groovy.transform.TupleConstructor

@TupleConstructor
class CreateCommunityCommand {
    String id
    String name
}
