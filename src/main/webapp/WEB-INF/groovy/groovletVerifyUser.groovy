import org.springframework.web.context.support.*
import org.springframework.web.context.*

println "en el groovlet"

WebApplicationContext ctx = WebApplicationContextUtils.getWebApplicationContext(context)

println "<br>"
println ctx.getBean("customerRepository")
println "<br>"
println ctx.getBean("delegateActor")
println "<br>"
println ctx.properties
println "<br>"

//ctx.getBean(CustomerRepository)
