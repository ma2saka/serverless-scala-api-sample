package hello

import com.amazonaws.services.lambda.runtime.{Context, RequestHandler}
import scala.collection.JavaConverters

class ApiGatewayHandler extends RequestHandler[ApiGatewayRequest, ApiGatewayResponse] {
  def handleRequest(input: ApiGatewayRequest, context: Context): ApiGatewayResponse = {
    val headers = JavaConverters.mapAsJavaMap[String, Object](Map())
    val body = s"Hello ${ input.pathParameters.get("name") } !!"
    ApiGatewayResponse(200, body, headers, true)
  }
}
