package grails.normal

class Apple {

    Long id
    String name
    String code
    Date releaseDate

    static mapping = {
        version false
    }

    static constraints = {
        name blank: false
        code blank: false
        releaseDate blank: false
    }

    @Override
    String toString() {
        return name
    }
}
