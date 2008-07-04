package org.openqa.selenium.remote.server.handler;

import org.openqa.selenium.remote.Response;
import org.openqa.selenium.remote.server.DriverSessions;
import org.openqa.selenium.remote.server.rest.ResultType;

public class GetElementAttribute extends WebDriverHandler {

  private String elementId;
  private String name;
  private Response response;

  public GetElementAttribute(DriverSessions sessions) {
    super(sessions);
  }

  public void setId(String elementId) {
    this.elementId = elementId;
  }

  public void setName(String name) {
    this.name = name;
  }

  public ResultType handle() throws Exception {
    response = newResponse();
    response.setValue(getKnownElements().get(elementId).getAttribute(name));

    return ResultType.SUCCESS;
  }

  public Response getResponse() {
    return response;
  }

}
