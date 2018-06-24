package grails.normal

import grails.testing.mixin.integration.Integration
import grails.gorm.transactions.Rollback
import spock.lang.Specification
import org.hibernate.SessionFactory

@Integration
@Rollback
class AppleServiceSpec extends Specification {

    AppleService appleService
    SessionFactory sessionFactory

    private Long setupData() {
        // TODO: Populate valid domain instances and return a valid ID
        //new Apple(...).save(flush: true, failOnError: true)
        //new Apple(...).save(flush: true, failOnError: true)
        //Apple apple = new Apple(...).save(flush: true, failOnError: true)
        //new Apple(...).save(flush: true, failOnError: true)
        //new Apple(...).save(flush: true, failOnError: true)
        assert false, "TODO: Provide a setupData() implementation for this generated test suite"
        //apple.id
    }

    void "test get"() {
        setupData()

        expect:
        appleService.get(1) != null
    }

    void "test list"() {
        setupData()

        when:
        List<Apple> appleList = appleService.list(max: 2, offset: 2)

        then:
        appleList.size() == 2
        assert false, "TODO: Verify the correct instances are returned"
    }

    void "test count"() {
        setupData()

        expect:
        appleService.count() == 5
    }

    void "test delete"() {
        Long appleId = setupData()

        expect:
        appleService.count() == 5

        when:
        appleService.delete(appleId)
        sessionFactory.currentSession.flush()

        then:
        appleService.count() == 4
    }

    void "test save"() {
        when:
        assert false, "TODO: Provide a valid instance to save"
        Apple apple = new Apple()
        appleService.save(apple)

        then:
        apple.id != null
    }
}
