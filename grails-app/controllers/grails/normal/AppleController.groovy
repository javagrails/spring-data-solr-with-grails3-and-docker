package grails.normal

import grails.validation.ValidationException
import static org.springframework.http.HttpStatus.*

class AppleController {

    AppleService appleService

    static allowedMethods = [save: "POST", update: "PUT", delete: "DELETE"]

    def index(Integer max) {
        params.max = Math.min(max ?: 10, 100)
        respond appleService.list(params), model:[appleCount: appleService.count()]
    }

    def show(Long id) {
        respond appleService.get(id)
    }

    def create() {
        respond new Apple(params)
    }

    def save(Apple apple) {
        if (apple == null) {
            notFound()
            return
        }

        try {
            appleService.save(apple)
        } catch (ValidationException e) {
            respond apple.errors, view:'create'
            return
        }

        request.withFormat {
            form multipartForm {
                flash.message = message(code: 'default.created.message', args: [message(code: 'apple.label', default: 'Apple'), apple.id])
                redirect apple
            }
            '*' { respond apple, [status: CREATED] }
        }
    }

    def edit(Long id) {
        respond appleService.get(id)
    }

    def update(Apple apple) {
        if (apple == null) {
            notFound()
            return
        }

        try {
            appleService.save(apple)
        } catch (ValidationException e) {
            respond apple.errors, view:'edit'
            return
        }

        request.withFormat {
            form multipartForm {
                flash.message = message(code: 'default.updated.message', args: [message(code: 'apple.label', default: 'Apple'), apple.id])
                redirect apple
            }
            '*'{ respond apple, [status: OK] }
        }
    }

    def delete(Long id) {
        if (id == null) {
            notFound()
            return
        }

        appleService.delete(id)

        request.withFormat {
            form multipartForm {
                flash.message = message(code: 'default.deleted.message', args: [message(code: 'apple.label', default: 'Apple'), id])
                redirect action:"index", method:"GET"
            }
            '*'{ render status: NO_CONTENT }
        }
    }

    protected void notFound() {
        request.withFormat {
            form multipartForm {
                flash.message = message(code: 'default.not.found.message', args: [message(code: 'apple.label', default: 'Apple'), params.id])
                redirect action: "index", method: "GET"
            }
            '*'{ render status: NOT_FOUND }
        }
    }
}
