import org.springframework.web.context.support.*
import javax.servlet.http.HttpServletResponse
import org.springframework.web.context.*

try {
  WebApplicationContext ctx = WebApplicationContextUtils.getWebApplicationContext(context)
  def actor = ctx.getBean('delegateActor')
  def contentType = headers.find { k,v -> k.toLowerCase() == 'content-type' }?.value

  if(contentType != "application/json")
    throw new RuntimeException("Please use 'application/json' header, just received ${headers} instead")

  if(!params.username)
    throw new RuntimeException("The 'username' param is required")

  if (!actor.isActive())
    actor.start()

  actor.send(params.username)

  response.contentType = 'application/json'
  json(status:'OK') 

}
catch(RuntimeException e) {
  println e.message
  response.contentType = 'application/json'
  response.setStatus(HttpServletResponse.SC_BAD_REQUEST, e.message)
}catch(Exception e){
  println e.message
  response.contentType = 'application/json'
  response.setStatus(HttpServletResponse.SC_NOT_FOUND, e.message)
}