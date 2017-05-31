package hello

import scala.beans.BeanProperty

class ApiGatewayRequest( @BeanProperty var resource: String,
                         @BeanProperty var path: String,
                         @BeanProperty var httpMethod: String,
                         @BeanProperty var queryStringParameters: java.util.Map[String, String],
                         @BeanProperty var headers: java.util.Map[String, String],
                         @BeanProperty var pathParameters: java.util.Map[String, String],
                         @BeanProperty var stageVariables: java.util.Map[String, String],
                         @BeanProperty var body: String) {
  def this() = this("", "", "", null, null, null, null, null)
}

