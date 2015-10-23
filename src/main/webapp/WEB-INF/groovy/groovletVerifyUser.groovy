import com.makingdevs.CustomerRepository
import org.springframework.web.context.support.*
import org.springframework.web.context.*


println "en el groovlet"

WebApplicationContext ctx = WebApplicationContextUtils.getWebApplicationContext(context)

println "<br>"
println ctx.dump()
ctx.metaClass.metaMethods.each {
  println it.name
  println "<br>"
}
println "<br>"
println ctx.properties
println "<br>"

//ctx.getBean(CustomerRepository)
